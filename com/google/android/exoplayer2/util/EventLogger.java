package com.google.android.exoplayer2.util;

import A7.d;
import U4.x;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import b3.Z;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class EventLogger implements AnalyticsListener {
    private static final String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final NumberFormat TIME_FORMAT;
    private final Period period;
    private final long startTimeMs;
    private final String tag;
    private final MappingTrackSelector trackSelector;
    private final Window window;

    static {
        NumberFormat numberFormat0 = NumberFormat.getInstance(Locale.US);
        EventLogger.TIME_FORMAT = numberFormat0;
        numberFormat0.setMinimumFractionDigits(2);
        numberFormat0.setMaximumFractionDigits(2);
        numberFormat0.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector0) {
        this(mappingTrackSelector0, "EventLogger");
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector0, String s) {
        this.trackSelector = mappingTrackSelector0;
        this.tag = s;
        this.window = new Window();
        this.period = new Period();
        this.startTimeMs = SystemClock.elapsedRealtime();
    }

    private static String getAdaptiveSupportString(int v, int v1) {
        if(v < 2) {
            return "N/A";
        }
        switch(v1) {
            case 0: {
                return "NO";
            }
            case 8: {
                return "YES_NOT_SEAMLESS";
            }
            case 16: {
                return "YES";
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private static String getDiscontinuityReasonString(int v) {
        switch(v) {
            case 0: {
                return "PERIOD_TRANSITION";
            }
            case 1: {
                return "SEEK";
            }
            case 2: {
                return "SEEK_ADJUSTMENT";
            }
            case 3: {
                return "AD_INSERTION";
            }
            case 4: {
                return "INTERNAL";
            }
            default: {
                return "?";
            }
        }
    }

    private String getEventString(EventTime analyticsListener$EventTime0, String s, String s1, Throwable throwable0) {
        String s2 = s + " [" + this.getEventTimeString(analyticsListener$EventTime0);
        if(s1 != null) {
            s2 = s2 + ", " + s1;
        }
        String s3 = Log.getThrowableString(throwable0);
        if(!TextUtils.isEmpty(s3)) {
            s2 = s2 + "\n  " + s3.replace("\n", "\n  ") + '\n';
        }
        return s2 + "]";
    }

    private String getEventTimeString(EventTime analyticsListener$EventTime0) {
        String s = "window=" + analyticsListener$EventTime0.windowIndex;
        if(analyticsListener$EventTime0.mediaPeriodId != null) {
            s = s + ", period=" + analyticsListener$EventTime0.timeline.getIndexOfPeriod(analyticsListener$EventTime0.mediaPeriodId.periodUid);
            if(analyticsListener$EventTime0.mediaPeriodId.isAd()) {
                s = s + ", adGroup=" + analyticsListener$EventTime0.mediaPeriodId.adGroupIndex + ", ad=" + analyticsListener$EventTime0.mediaPeriodId.adIndexInAdGroup;
            }
        }
        String s1 = EventLogger.getTimeString(analyticsListener$EventTime0.realtimeMs - this.startTimeMs);
        String s2 = EventLogger.getTimeString(analyticsListener$EventTime0.currentPlaybackPositionMs);
        return x.m(Z.o(Z.e(Z.e(Z.e(23, s1), s2), s), "eventTime=", s1, ", mediaPos=", s2), ", ", s);
    }

    private static String getPlaybackSuppressionReasonString(int v) {
        switch(v) {
            case 0: {
                return "NONE";
            }
            case 1: {
                return "TRANSIENT_AUDIO_FOCUS_LOSS";
            }
            default: {
                return "?";
            }
        }
    }

    private static String getRepeatModeString(int v) {
        switch(v) {
            case 0: {
                return "OFF";
            }
            case 1: {
                return "ONE";
            }
            case 2: {
                return "ALL";
            }
            default: {
                return "?";
            }
        }
    }

    private static String getStateString(int v) {
        switch(v) {
            case 1: {
                return "IDLE";
            }
            case 2: {
                return "BUFFERING";
            }
            case 3: {
                return "READY";
            }
            case 4: {
                return "ENDED";
            }
            default: {
                return "?";
            }
        }
    }

    private static String getTimeString(long v) {
        return v == 0x8000000000000001L ? "?" : EventLogger.TIME_FORMAT.format(((double)(((float)v) / 1000.0f)));
    }

    private static String getTimelineChangeReasonString(int v) {
        switch(v) {
            case 0: {
                return "PREPARED";
            }
            case 1: {
                return "RESET";
            }
            case 2: {
                return "DYNAMIC";
            }
            default: {
                return "?";
            }
        }
    }

    // 去混淆评级： 低(40)
    private static String getTrackStatusString(TrackSelection trackSelection0, TrackGroup trackGroup0, int v) {
        return trackSelection0 == null || trackSelection0.getTrackGroup() != trackGroup0 || trackSelection0.indexOf(v) == -1 ? "[ ]" : "[X]";
    }

    // 去混淆评级： 低(20)
    private static String getTrackStatusString(boolean z) [...] // 潜在的解密器

    private void logd(EventTime analyticsListener$EventTime0, String s) {
        this.logd(this.getEventString(analyticsListener$EventTime0, s, null, null));
    }

    private void logd(EventTime analyticsListener$EventTime0, String s, String s1) {
        this.logd(this.getEventString(analyticsListener$EventTime0, s, s1, null));
    }

    public void logd(String s) {
        Log.d(this.tag, s);
    }

    private void loge(EventTime analyticsListener$EventTime0, String s, String s1, Throwable throwable0) {
        this.loge(this.getEventString(analyticsListener$EventTime0, s, s1, throwable0));
    }

    private void loge(EventTime analyticsListener$EventTime0, String s, Throwable throwable0) {
        this.loge(this.getEventString(analyticsListener$EventTime0, s, null, throwable0));
    }

    public void loge(String s) {
        Log.e(this.tag, s);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioAttributesChanged(EventTime analyticsListener$EventTime0, AudioAttributes audioAttributes0) {
        this.logd(analyticsListener$EventTime0, "audioAttributes", audioAttributes0.contentType + "," + audioAttributes0.flags + "," + audioAttributes0.usage + "," + audioAttributes0.allowedCapturePolicy);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioSessionId(EventTime analyticsListener$EventTime0, int v) {
        this.logd(analyticsListener$EventTime0, "audioSessionId", Integer.toString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(EventTime analyticsListener$EventTime0, int v, long v1, long v2) {
        this.loge(analyticsListener$EventTime0, "audioTrackUnderrun", v + ", " + v1 + ", " + v2 + "]", null);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(EventTime analyticsListener$EventTime0, int v, long v1, long v2) {
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderDisabled(EventTime analyticsListener$EventTime0, int v, DecoderCounters decoderCounters0) {
        this.logd(analyticsListener$EventTime0, "decoderDisabled", Util.getTrackTypeString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderEnabled(EventTime analyticsListener$EventTime0, int v, DecoderCounters decoderCounters0) {
        this.logd(analyticsListener$EventTime0, "decoderEnabled", Util.getTrackTypeString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInitialized(EventTime analyticsListener$EventTime0, int v, String s, long v1) {
        this.logd(analyticsListener$EventTime0, "decoderInitialized", Util.getTrackTypeString(v) + ", " + s);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInputFormatChanged(EventTime analyticsListener$EventTime0, int v, Format format0) {
        this.logd(analyticsListener$EventTime0, "decoderInputFormat", Util.getTrackTypeString(v) + ", " + Format.toLogString(format0));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(EventTime analyticsListener$EventTime0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        this.logd(analyticsListener$EventTime0, "downstreamFormat", Format.toLogString(mediaSourceEventListener$MediaLoadData0.trackFormat));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysLoaded(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "drmKeysLoaded");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRemoved(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "drmKeysRemoved");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRestored(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "drmKeysRestored");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionAcquired(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "drmSessionAcquired");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(EventTime analyticsListener$EventTime0, Exception exception0) {
        this.printInternalError(analyticsListener$EventTime0, "drmSessionManagerError", exception0);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionReleased(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "drmSessionReleased");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(EventTime analyticsListener$EventTime0, int v, long v1) {
        this.logd(analyticsListener$EventTime0, "droppedFrames", Integer.toString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsPlayingChanged(EventTime analyticsListener$EventTime0, boolean z) {
        this.logd(analyticsListener$EventTime0, "isPlaying", Boolean.toString(z));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
        this.printInternalError(analyticsListener$EventTime0, "loadError", iOException0);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadingChanged(EventTime analyticsListener$EventTime0, boolean z) {
        this.logd(analyticsListener$EventTime0, "loading", Boolean.toString(z));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaPeriodCreated(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "mediaPeriodCreated");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaPeriodReleased(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "mediaPeriodReleased");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMetadata(EventTime analyticsListener$EventTime0, Metadata metadata0) {
        String s = this.getEventTimeString(analyticsListener$EventTime0);
        this.logd((s.length() == 0 ? new String("metadata [") : "metadata [" + s));
        this.printMetadata(metadata0, "  ");
        this.logd("]");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(EventTime analyticsListener$EventTime0, PlaybackParameters playbackParameters0) {
        this.logd(analyticsListener$EventTime0, "playbackParameters", Util.formatInvariant("speed=%.2f, pitch=%.2f, skipSilence=%s", new Object[]{playbackParameters0.speed, playbackParameters0.pitch, Boolean.valueOf(playbackParameters0.skipSilence)}));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(EventTime analyticsListener$EventTime0, int v) {
        this.logd(analyticsListener$EventTime0, "playbackSuppressionReason", EventLogger.getPlaybackSuppressionReasonString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(EventTime analyticsListener$EventTime0, ExoPlaybackException exoPlaybackException0) {
        this.loge(analyticsListener$EventTime0, "playerFailed", exoPlaybackException0);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(EventTime analyticsListener$EventTime0, boolean z, int v) {
        this.logd(analyticsListener$EventTime0, "state", z + ", " + EventLogger.getStateString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(EventTime analyticsListener$EventTime0, int v) {
        this.logd(analyticsListener$EventTime0, "positionDiscontinuity", EventLogger.getDiscontinuityReasonString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onReadingStarted(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "mediaPeriodReadingStarted");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(EventTime analyticsListener$EventTime0, Surface surface0) {
        this.logd(analyticsListener$EventTime0, "renderedFirstFrame", String.valueOf(surface0));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRepeatModeChanged(EventTime analyticsListener$EventTime0, int v) {
        this.logd(analyticsListener$EventTime0, "repeatMode", EventLogger.getRepeatModeString(v));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekProcessed(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "seekProcessed");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(EventTime analyticsListener$EventTime0) {
        this.logd(analyticsListener$EventTime0, "seekStarted");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onShuffleModeChanged(EventTime analyticsListener$EventTime0, boolean z) {
        this.logd(analyticsListener$EventTime0, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSurfaceSizeChanged(EventTime analyticsListener$EventTime0, int v, int v1) {
        this.logd(analyticsListener$EventTime0, "surfaceSize", v + ", " + v1);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(EventTime analyticsListener$EventTime0, int v) {
        int v1 = analyticsListener$EventTime0.timeline.getPeriodCount();
        int v2 = analyticsListener$EventTime0.timeline.getWindowCount();
        this.logd("timeline [" + this.getEventTimeString(analyticsListener$EventTime0) + ", periodCount=" + v1 + ", windowCount=" + v2 + ", reason=" + EventLogger.getTimelineChangeReasonString(v));
        for(int v4 = 0; v4 < Math.min(v1, 3); ++v4) {
            analyticsListener$EventTime0.timeline.getPeriod(v4, this.period);
            this.logd("  period [" + EventLogger.getTimeString(this.period.getDurationMs()) + "]");
        }
        if(v1 > 3) {
            this.logd("  ...");
        }
        for(int v3 = 0; v3 < Math.min(v2, 3); ++v3) {
            analyticsListener$EventTime0.timeline.getWindow(v3, this.window);
            this.logd("  window [" + EventLogger.getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
        }
        if(v2 > 3) {
            this.logd("  ...");
        }
        this.logd("]");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(EventTime analyticsListener$EventTime0, TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
        int v2;
        MappedTrackInfo mappingTrackSelector$MappedTrackInfo0 = this.trackSelector == null ? null : this.trackSelector.getCurrentMappedTrackInfo();
        if(mappingTrackSelector$MappedTrackInfo0 == null) {
            this.logd(analyticsListener$EventTime0, "tracks", "[]");
            return;
        }
        String s = this.getEventTimeString(analyticsListener$EventTime0);
        this.logd((s.length() == 0 ? new String("tracks [") : "tracks [" + s));
        int v = mappingTrackSelector$MappedTrackInfo0.getRendererCount();
        int v1 = 0;
        while(v1 < v) {
            TrackGroupArray trackGroupArray1 = mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v1);
            TrackSelection trackSelection0 = trackSelectionArray0.get(v1);
            if(trackGroupArray1.length > 0) {
                v2 = v;
                this.logd("  Renderer:" + v1 + " [");
                for(int v3 = 0; v3 < trackGroupArray1.length; ++v3) {
                    TrackGroup trackGroup0 = trackGroupArray1.get(v3);
                    int v4 = mappingTrackSelector$MappedTrackInfo0.getAdaptiveSupport(v1, v3, false);
                    this.logd("    Group:" + v3 + ", adaptive_supported=" + EventLogger.getAdaptiveSupportString(trackGroup0.length, v4) + " [");
                    for(int v5 = 0; v5 < trackGroup0.length; ++v5) {
                        String s1 = EventLogger.getTrackStatusString(trackSelection0, trackGroup0, v5);
                        String s2 = RendererCapabilities.getFormatSupportString(mappingTrackSelector$MappedTrackInfo0.getTrackSupport(v1, v3, v5));
                        String s3 = Format.toLogString(trackGroup0.getFormat(v5));
                        StringBuilder stringBuilder0 = new StringBuilder(Z.e(Z.e(Z.e(38, s1), s3), s2));
                        stringBuilder0.append("      ");
                        stringBuilder0.append(s1);
                        stringBuilder0.append(" Track:");
                        stringBuilder0.append(v5);
                        this.logd(d.n(stringBuilder0, ", ", s3, ", supported=", s2));
                    }
                    this.logd("    ]");
                }
                if(trackSelection0 != null) {
                    for(int v6 = 0; v6 < trackSelection0.length(); ++v6) {
                        Metadata metadata0 = trackSelection0.getFormat(v6).metadata;
                        if(metadata0 != null) {
                            this.logd("    Metadata [");
                            this.printMetadata(metadata0, "      ");
                            this.logd("    ]");
                            break;
                        }
                    }
                }
                this.logd("  ]");
            }
            else {
                v2 = v;
            }
            ++v1;
            v = v2;
        }
        TrackGroupArray trackGroupArray2 = mappingTrackSelector$MappedTrackInfo0.getUnmappedTrackGroups();
        if(trackGroupArray2.length > 0) {
            this.logd("  Renderer:None [");
            for(int v7 = 0; v7 < trackGroupArray2.length; ++v7) {
                this.logd("    Group:" + v7 + " [");
                TrackGroup trackGroup1 = trackGroupArray2.get(v7);
                for(int v8 = 0; v8 < trackGroup1.length; ++v8) {
                    String s4 = Format.toLogString(trackGroup1.getFormat(v8));
                    StringBuilder stringBuilder1 = new StringBuilder(Z.e(Z.e(41, s4), "NO"));
                    stringBuilder1.append("      ");
                    stringBuilder1.append("[ ]");
                    stringBuilder1.append(" Track:");
                    stringBuilder1.append(v8);
                    this.logd(d.n(stringBuilder1, ", ", s4, ", supported=", "NO"));
                }
                this.logd("    ]");
            }
            this.logd("  ]");
        }
        this.logd("]");
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(EventTime analyticsListener$EventTime0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        this.logd(analyticsListener$EventTime0, "upstreamDiscarded", Format.toLogString(mediaSourceEventListener$MediaLoadData0.trackFormat));
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(EventTime analyticsListener$EventTime0, int v, int v1, int v2, float f) {
        this.logd(analyticsListener$EventTime0, "videoSize", v + ", " + v1);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVolumeChanged(EventTime analyticsListener$EventTime0, float f) {
        this.logd(analyticsListener$EventTime0, "volume", Float.toString(f));
    }

    private void printInternalError(EventTime analyticsListener$EventTime0, String s, Exception exception0) {
        this.loge(analyticsListener$EventTime0, "internalError", s, exception0);
    }

    private void printMetadata(Metadata metadata0, String s) {
        for(int v = 0; v < metadata0.length(); ++v) {
            this.logd(s + metadata0.get(v));
        }
    }
}

