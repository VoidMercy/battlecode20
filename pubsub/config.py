import logging, multiprocessing

# Configure logging format

multiprocessing.log_to_stderr()
multiprocessing.get_logger().handlers[0].setFormatter(logging.Formatter(
    '%(asctime)s [%(threadName)-12.12s] [%(levelname)-5.5s]  %(message)s'))
logging.getLogger().addHandler(multiprocessing.get_logger().handlers[0])
logging.getLogger().setLevel(logging.INFO)


# Constants, parameters and configurations

GCLOUD_PROJECT_ID       = 'battlecode18'
GCLOUD_SUB_COMPILE_NAME = 'bc20-compile-sub'
GCLOUD_SUB_GAME_NAME    = 'bc20-game-sub'
GCLOUD_BUCKET_ID        = 'bc20-submissions'

PUBSUB_ACK_DEADLINE = 30 # Value to which ack deadline is reset
PUBSUB_SLEEP_TIME   = 10 # Interval between checks for new jobs and ack deadline

TIMEOUT_UNZIP   = 10   # Maximum execution time for unzipping submission archive
TIMEOUT_COMPILE = 90   # Maximum execution time for submission compilation
TIMEOUT_GAME    = 3600 # Maximum execution time for game running

PSQL_SERVER   = '35.227.72.43'
PSQL_USERNAME = 'battlecode'
PSQL_PASSWORD = '[redacted]'
PSQL_DATABASE = 'battlecode'
