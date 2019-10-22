#!/usr/bin/env python3

import subscription
import util
from config import *

import sys
import os
import shutil
import logging

from google.cloud import storage


def compile_db_report(submissionid, result):
    """Sends the result of the run to the database"""
    try:
        # TODO report to database
        pass
    except:
        logging.critical('Could not report to database')

def compile_log_error(submissionid, reason):
    """Reports a server-side error to the database and terminates with failure"""
    compile_db_report(submissionid, 'error')
    logging.error(reason)
    sys.exit(1)

def compile_worker(submissionid):
    """Performs a compilation job as specified in submissionid"""

    client = storage.Client()
    bucket = client.get_bucket(GCLOUD_BUCKET_ID)

    # Filesystem structure:
    # /tmp/bc20-compile-{submissionid}/
    #     `-- source.zip
    #     `-- source/
    #     |      `-- all contents of source.zip
    #     `-- player.jar
    rootdir   = os.path.join('/', 'tmp', 'bc20-compile-'+submissionid)
    sourcedir = os.path.join(rootdir, 'source')

    # Obtain compressed archive of the submission
    try:
        os.mkdir(rootdir)
        os.mkdir(sourcedir)
        with open(os.path.join(rootdir, 'source.zip'), 'wb') as file_obj:
            bucket.get_blob(os.path.join(submissionid, 'source.zip')).download_to_file(file_obj)
    except:
        compile_log_error(submissionid, 'Could not retrieve source file from bucket')

    # Decompress submission archive
    result = util.monitor_command(
        ['unzip', 'source.zip', '-d', sourcedir],
        cwd=rootdir,
        timeout=TIMEOUT_UNZIP)
    if result[0] != 0:
        compile_log_error(submissionid, 'Could not decompress source file')

    # TODO: Invoke compilation to produce executable jar
    result = util.monitor_command(
        ['cp', os.path.join('..', 'source.zip'), os.path.join('..', 'player.jar')],
        cwd=sourcedir,
        timeout=TIMEOUT_COMPILE)

    if result[0] == 0:
        # The compilation succeeded; send the jar to the bucket for storage
        try:
            with open(os.path.join(rootdir, 'player.jar'), 'rb') as file_obj:
                bucket.blob(os.path.join(submissionid, 'player.jar')).upload_from_file(file_obj)
        except:
            compile_log_error(submissionid, 'Could not send executable to bucket')
        compile_db_report(submissionid, 'success')
    else:
        # The compilation failed; report this to database
        compile_db_report(submissionid, 'failed')

    # Clean up working directory
    try:
        shutil.rmtree(rootdir)
    except:
        logging.warning('Could not clean up compilation directory')

if __name__ == '__main__':
    subscription.subscribe(GCLOUD_SUB_COMPILE_NAME, compile_worker)
