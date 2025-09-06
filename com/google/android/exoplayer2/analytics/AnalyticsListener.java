package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;

public interface AnalyticsListener {
    public static final class EventTime {
        public final long currentPlaybackPositionMs;
        public final long eventPlaybackPositionMs;
        public final MediaPeriodId mediaPeriodId;
        public final long realtimeMs;
        public final Timeline timeline;
        public final long totalBufferedDurationMs;
        public final int windowIndex;

        public EventTime(long v, Timeline timeline0, int v1, MediaPeriodId mediaSource$MediaPeriodId0, long v2, long v3, long v4) {
            this.realtimeMs = v;
            this.timeline = timeline0;
            this.windowIndex = v1;
            this.mediaPeriodId = mediaSource$MediaPeriodId0;
            this.eventPlaybackPositionMs = v2;
            this.currentPlaybackPositionMs = v3;
            this.totalBufferedDurationMs = v4;
        }
    }

    default void onAudioAttributesChanged(EventTime analyticsListener$EventTime0, AudioAttributes audioAttributes0) {
    }

    default void onAudioSessionId(EventTime analyticsListener$EventTime0, int v) {
    }

    default void onAudioUnderrun(EventTime analyticsListener$EventTime0, int v, long v1, long v2) {
    }

    default void onBandwidthEstimate(EventTime analyticsListener$EventTime0, int v, long v1, long v2) {
    }

    default void onDecoderDisabled(EventTime analyticsListener$EventTime0, int v, DecoderCounters decoderCounters0) {
    }

    default void onDecoderEnabled(EventTime analyticsListener$EventTime0, int v, DecoderCounters decoderCounters0) {
    }

    default void onDecoderInitialized(EventTime analyticsListener$EventTime0, int v, String s, long v1) {
    }

    default void onDecoderInputFormatChanged(EventTime analyticsListener$EventTime0, int v, Format format0) {
    }

    default void onDownstreamFormatChanged(EventTime analyticsListener$EventTime0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onDrmKeysLoaded(EventTime analyticsListener$EventTime0) {
    }

    default void onDrmKeysRemoved(EventTime analyticsListener$EventTime0) {
    }

    default void onDrmKeysRestored(EventTime analyticsListener$EventTime0) {
    }

    default void onDrmSessionAcquired(EventTime analyticsListener$EventTime0) {
    }

    default void onDrmSessionManagerError(EventTime analyticsListener$EventTime0, Exception exception0) {
    }

    default void onDrmSessionReleased(EventTime analyticsListener$EventTime0) {
    }

    default void onDroppedVideoFrames(EventTime analyticsListener$EventTime0, int v, long v1) {
    }

    default void onIsPlayingChanged(EventTime analyticsListener$EventTime0, boolean z) {
    }

    default void onLoadCanceled(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onLoadCompleted(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onLoadError(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
    }

    default void onLoadStarted(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onLoadingChanged(EventTime analyticsListener$EventTime0, boolean z) {
    }

    default void onMediaPeriodCreated(EventTime analyticsListener$EventTime0) {
    }

    default void onMediaPeriodReleased(EventTime analyticsListener$EventTime0) {
    }

    default void onMetadata(EventTime analyticsListener$EventTime0, Metadata metadata0) {
    }

    default void onPlaybackParametersChanged(EventTime analyticsListener$EventTime0, PlaybackParameters playbackParameters0) {
    }

    default void onPlaybackSuppressionReasonChanged(EventTime analyticsListener$EventTime0, int v) {
    }

    default void onPlayerError(EventTime analyticsListener$EventTime0, ExoPlaybackException exoPlaybackException0) {
    }

    default void onPlayerStateChanged(EventTime analyticsListener$EventTime0, boolean z, int v) {
    }

    default void onPositionDiscontinuity(EventTime analyticsListener$EventTime0, int v) {
    }

    default void onReadingStarted(EventTime analyticsListener$EventTime0) {
    }

    default void onRenderedFirstFrame(EventTime analyticsListener$EventTime0, Surface surface0) {
    }

    default void onRepeatModeChanged(EventTime analyticsListener$EventTime0, int v) {
    }

    default void onSeekProcessed(EventTime analyticsListener$EventTime0) {
    }

    default void onSeekStarted(EventTime analyticsListener$EventTime0) {
    }

    default void onShuffleModeChanged(EventTime analyticsListener$EventTime0, boolean z) {
    }

    default void onSurfaceSizeChanged(EventTime analyticsListener$EventTime0, int v, int v1) {
    }

    default void onTimelineChanged(EventTime analyticsListener$EventTime0, int v) {
    }

    default void onTracksChanged(EventTime analyticsListener$EventTime0, TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
    }

    default void onUpstreamDiscarded(EventTime analyticsListener$EventTime0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onVideoSizeChanged(EventTime analyticsListener$EventTime0, int v, int v1, int v2, float f) {
    }

    default void onVolumeChanged(EventTime analyticsListener$EventTime0, float f) {
    }
}

