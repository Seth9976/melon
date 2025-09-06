package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

final class PlaybackInfo {
    private static final MediaPeriodId DUMMY_MEDIA_PERIOD_ID;
    public volatile long bufferedPositionUs;
    public final long contentPositionUs;
    public final boolean isLoading;
    public final MediaPeriodId loadingMediaPeriodId;
    public final MediaPeriodId periodId;
    public final ExoPlaybackException playbackError;
    public final int playbackState;
    public volatile long positionUs;
    public final long startPositionUs;
    public final Timeline timeline;
    public volatile long totalBufferedDurationUs;
    public final TrackGroupArray trackGroups;
    public final TrackSelectorResult trackSelectorResult;

    static {
        PlaybackInfo.DUMMY_MEDIA_PERIOD_ID = new MediaPeriodId(new Object());
    }

    public PlaybackInfo(Timeline timeline0, MediaPeriodId mediaSource$MediaPeriodId0, long v, long v1, int v2, ExoPlaybackException exoPlaybackException0, boolean z, TrackGroupArray trackGroupArray0, TrackSelectorResult trackSelectorResult0, MediaPeriodId mediaSource$MediaPeriodId1, long v3, long v4, long v5) {
        this.timeline = timeline0;
        this.periodId = mediaSource$MediaPeriodId0;
        this.startPositionUs = v;
        this.contentPositionUs = v1;
        this.playbackState = v2;
        this.playbackError = exoPlaybackException0;
        this.isLoading = z;
        this.trackGroups = trackGroupArray0;
        this.trackSelectorResult = trackSelectorResult0;
        this.loadingMediaPeriodId = mediaSource$MediaPeriodId1;
        this.bufferedPositionUs = v3;
        this.totalBufferedDurationUs = v4;
        this.positionUs = v5;
    }

    public PlaybackInfo copyWithIsLoading(boolean z) {
        return new PlaybackInfo(this.timeline, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.playbackError, z, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithLoadingMediaPeriodId(MediaPeriodId mediaSource$MediaPeriodId0) {
        return new PlaybackInfo(this.timeline, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, mediaSource$MediaPeriodId0, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    // 去混淆评级： 低(20)
    public PlaybackInfo copyWithNewPosition(MediaPeriodId mediaSource$MediaPeriodId0, long v, long v1, long v2) {
        return mediaSource$MediaPeriodId0.isAd() ? new PlaybackInfo(this.timeline, mediaSource$MediaPeriodId0, v, v1, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, v2, v) : new PlaybackInfo(this.timeline, mediaSource$MediaPeriodId0, v, 0x8000000000000001L, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, v2, v);
    }

    public PlaybackInfo copyWithPlaybackError(ExoPlaybackException exoPlaybackException0) {
        return new PlaybackInfo(this.timeline, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, exoPlaybackException0, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithPlaybackState(int v) {
        return new PlaybackInfo(this.timeline, this.periodId, this.startPositionUs, this.contentPositionUs, v, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithTimeline(Timeline timeline0) {
        return new PlaybackInfo(timeline0, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public PlaybackInfo copyWithTrackInfo(TrackGroupArray trackGroupArray0, TrackSelectorResult trackSelectorResult0) {
        return new PlaybackInfo(this.timeline, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.playbackError, this.isLoading, trackGroupArray0, trackSelectorResult0, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public static PlaybackInfo createDummy(long v, TrackSelectorResult trackSelectorResult0) {
        return new PlaybackInfo(Timeline.EMPTY, PlaybackInfo.DUMMY_MEDIA_PERIOD_ID, v, 0x8000000000000001L, 1, null, false, TrackGroupArray.EMPTY, trackSelectorResult0, PlaybackInfo.DUMMY_MEDIA_PERIOD_ID, v, 0L, v);
    }

    public MediaPeriodId getDummyFirstMediaPeriodId(boolean z, Window timeline$Window0, Period timeline$Period0) {
        if(this.timeline.isEmpty()) {
            return PlaybackInfo.DUMMY_MEDIA_PERIOD_ID;
        }
        int v = this.timeline.getFirstWindowIndex(z);
        int v1 = this.timeline.getWindow(v, timeline$Window0).firstPeriodIndex;
        int v2 = this.timeline.getIndexOfPeriod(this.periodId.periodUid);
        return v2 == -1 || v != this.timeline.getPeriod(v2, timeline$Period0).windowIndex ? new MediaPeriodId(this.timeline.getUidOfPeriod(v1), -1L) : new MediaPeriodId(this.timeline.getUidOfPeriod(v1), this.periodId.windowSequenceNumber);
    }
}

