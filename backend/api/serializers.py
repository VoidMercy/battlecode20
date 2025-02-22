"""
The medium between JSON and Python database objects. Also any
events that need to happen before, during, or after serializing
or deserializing objects.
"""

from django.contrib.auth import get_user_model
from rest_framework import serializers
from rest_framework.reverse import reverse

from .models import *

class LeagueHyperlinkedIdentityField(serializers.HyperlinkedIdentityField):
    def get_url(self, obj, view_name, request, format):
        if hasattr(obj, 'pk') and obj.pk is None:
            return None

        lookup_value = getattr(obj, self.lookup_field)
        kwargs = {self.lookup_url_kwarg: lookup_value}
        kwargs['league_id'] = self.context['league_id']
        return reverse(view_name, kwargs=kwargs, request=request, format=format)

class BasicTeamSerializer(serializers.HyperlinkedModelSerializer):
    #serializer_url_field = LeagueHyperlinkedIdentityField
    league = serializers.SlugRelatedField(queryset=League.objects.all(), slug_field='id')

    class Meta:
        model = Team
        fields = ('id', 'league', 'name', 'avatar', 'wins', 'losses', 'draws',
            'bio', 'divisions', 'auto_accept_ranked', 'auto_accept_unranked')
        read_only_fields = ('id',)


class TeamSerializer(serializers.HyperlinkedModelSerializer):
    serializer_url_field = LeagueHyperlinkedIdentityField
    league = serializers.SlugRelatedField(queryset=League.objects.all(), slug_field='id')
    users = serializers.SlugRelatedField(queryset=get_user_model().objects.all(), slug_field='username', many=True)

    class Meta:
        model = Team
        fields = ('url', 'id', 'league', 'name', 'avatar', 'users', 'wins', 'losses', 'draws',
            'bio', 'divisions', 'auto_accept_ranked', 'auto_accept_unranked', 'mu', 'sigma')
        read_only_fields = ('id',)

    def update(self, instance, validated_data):
        #print(validated_data)
        instance.bio = validated_data.get('bio', instance.bio)
        instance.divisions = validated_data.get('divisions', instance.divisions)
        instance.auto_accept_ranked = validated_data.get('auto_accept_ranked', instance.auto_accept_ranked)
        instance.auto_accept_unranked = validated_data.get('auto_accept_unranked', instance.auto_accept_unranked)
        instance.avatar = validated_data.get('avatar', instance.avatar)
        instance.save()
        return instance

class BasicUserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = get_user_model()
        fields = ('url', 'id', 'username', 'avatar', 'bio', 'country')
        read_only_fields = ('url', 'id', 'username', 'avatar', 'bio', 'country')

class VerifyUserSerializer(serializers.Serializer):
    registration_key = serializers.CharField(allow_null=True, max_length=32,
                                             required=True)



class FullUserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = get_user_model()
        fields = ('id', 'url', 'email', 'first_name', 'last_name', 'password', 'date_of_birth',
            'username', 'avatar', 'bio', 'country', 'is_staff', 'verified')
        read_only_fields = ('id', 'url', 'registration_key', 'is_staff', 'verified')
        extra_kwargs = {
            'password': {'write_only': True}
        }

    def create(self, validated_data):
        """
        Create and return a new user, given the validated data.
        """
        try:
            return get_user_model().objects.create_user(**validated_data)
        except Exception as e:
            print(e)
            error = {'message': ','.join(e.args) if len(e.args) > 0 else 'Unknown Error'}
            raise serializers.ValidationError(error)

    def update(self, instance, validated_data):
        """
        Update and return an existing user object, given the validated data.
        """
        instance.first_name = validated_data.get('first_name', instance.first_name)
        instance.last_name = validated_data.get('last_name', instance.last_name)
        instance.date_of_birth = validated_data.get('date_of_birth', instance.date_of_birth)
        instance.bio = validated_data.get('bio', instance.bio)
        instance.country = validated_data.get('country', instance.country)
        instance.avatar = validated_data.get('avatar', instance.avatar)
        instance.save()
        return instance


class UpdateSerializer(serializers.ModelSerializer):
    class Meta:
        model = Update
        fields = '__all__'

class LeagueSerializer(serializers.HyperlinkedModelSerializer):
    updates = UpdateSerializer(many=True, read_only=True)

    class Meta:
        model = League
        fields = '__all__'

class SubmissionSerializer(serializers.HyperlinkedModelSerializer):
    serializer_url_field = LeagueHyperlinkedIdentityField
    team = serializers.SlugRelatedField(queryset=Team.objects.all(), slug_field='id')

    class Meta:
        model = Submission
        fields = ('url', 'id', 'team', 'link', 'submitted_at', 'compilation_status')

class TeamSubmissionSerializer(serializers.HyperlinkedModelSerializer):
    serializer_url_field = LeagueHyperlinkedIdentityField
    team = serializers.SlugRelatedField(queryset=Team.objects.all(), slug_field='id')
    compiling = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    last_1 = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    last_2 = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    last_3 = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    tour_sprint = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    tour_seed = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    tour_qual = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')
    tour_final = serializers.SlugRelatedField(allow_null=True, queryset=Submission.objects.all(), slug_field='id')

    class Meta:
        model = TeamSubmission
        fields = ('url', 'team', 'compiling', 'last_1', 'last_2', 'last_3', 'tour_sprint', 'tour_seed', 'tour_qual', 'tour_final')


class ScrimmageSerializer(serializers.HyperlinkedModelSerializer):
    serializer_url_field = LeagueHyperlinkedIdentityField
    league          = serializers.SlugRelatedField(queryset=League.objects.all(), slug_field='id')
    red_team        = serializers.SlugRelatedField(queryset=Team.objects.all(), slug_field='name')
    blue_team       = serializers.SlugRelatedField(queryset=Team.objects.all(), slug_field='name')
    requested_by    = serializers.SlugRelatedField(queryset=Team.objects.all(), slug_field='id')

    class Meta:
        model = Scrimmage
        fields = ('url', 'id', 'league', 'red_team', 'red_mu', 'blue_team', 'blue_mu', 'ranked',
            'status', 'replay', 'requested_by', 'requested_at', 'started_at', 'updated_at')
        read_only_fields = ('url', 'requested_at', 'started_at', 'updated_at')


class TournamentSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Tournament
        fields = ('url', 'league', 'name', 'style', 'date_time', 'divisions', 'stream_link')


class TournamentScrimmageSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = TournamentScrimmage
