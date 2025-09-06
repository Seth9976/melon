package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import android.util.Pair;
import b3.Z;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PlaybackStatsListener implements AnalyticsListener, Listener {
    public interface Callback {
        void onPlaybackStatsReady(EventTime arg1, PlaybackStats arg2);
    }

    static final class PlaybackStatsTracker {
        private long audioFormatBitrateTimeProduct;
        private final List audioFormatHistory;
        private long audioFormatTimeMs;
        private long audioUnderruns;
        private long bandwidthBytes;
        private long bandwidthTimeMs;
        private Format currentAudioFormat;
        private float currentPlaybackSpeed;
        private int currentPlaybackState;
        private long currentPlaybackStateStartTimeMs;
        private Format currentVideoFormat;
        private long droppedFrames;
        private int fatalErrorCount;
        private final List fatalErrorHistory;
        private long firstReportedTimeMs;
        private boolean hasBeenReady;
        private boolean hasEnded;
        private boolean hasFatalError;
        private long initialAudioFormatBitrate;
        private long initialVideoFormatBitrate;
        private int initialVideoFormatHeight;
        private final boolean isAd;
        private boolean isFinished;
        private boolean isForeground;
        private boolean isInterruptedByAd;
        private boolean isJoinTimeInvalid;
        private boolean isSeeking;
        private boolean isSuppressed;
        private final boolean keepHistory;
        private long lastAudioFormatStartTimeMs;
        private long lastRebufferStartTimeMs;
        private long lastVideoFormatStartTimeMs;
        private long maxRebufferTimeMs;
        private final List mediaTimeHistory;
        private int nonFatalErrorCount;
        private final List nonFatalErrorHistory;
        private int pauseBufferCount;
        private int pauseCount;
        private boolean playWhenReady;
        private final long[] playbackStateDurationsMs;
        private final List playbackStateHistory;
        private int playerPlaybackState;
        private int rebufferCount;
        private int seekCount;
        private boolean startedLoading;
        private long videoFormatBitrateTimeMs;
        private long videoFormatBitrateTimeProduct;
        private long videoFormatHeightTimeMs;
        private long videoFormatHeightTimeProduct;
        private final List videoFormatHistory;

        public PlaybackStatsTracker(boolean z, EventTime analyticsListener$EventTime0) {
            this.keepHistory = z;
            this.playbackStateDurationsMs = new long[16];
            List list0 = z ? new ArrayList() : Collections.EMPTY_LIST;
            this.playbackStateHistory = list0;
            List list1 = z ? new ArrayList() : Collections.EMPTY_LIST;
            this.mediaTimeHistory = list1;
            List list2 = z ? new ArrayList() : Collections.EMPTY_LIST;
            this.videoFormatHistory = list2;
            List list3 = z ? new ArrayList() : Collections.EMPTY_LIST;
            this.audioFormatHistory = list3;
            List list4 = z ? new ArrayList() : Collections.EMPTY_LIST;
            this.fatalErrorHistory = list4;
            List list5 = z ? new ArrayList() : Collections.EMPTY_LIST;
            this.nonFatalErrorHistory = list5;
            boolean z1 = false;
            this.currentPlaybackState = 0;
            this.currentPlaybackStateStartTimeMs = analyticsListener$EventTime0.realtimeMs;
            this.playerPlaybackState = 1;
            this.firstReportedTimeMs = 0x8000000000000001L;
            this.maxRebufferTimeMs = 0x8000000000000001L;
            if(analyticsListener$EventTime0.mediaPeriodId != null && analyticsListener$EventTime0.mediaPeriodId.isAd()) {
                z1 = true;
            }
            this.isAd = z1;
            this.initialAudioFormatBitrate = -1L;
            this.initialVideoFormatBitrate = -1L;
            this.initialVideoFormatHeight = -1;
            this.currentPlaybackSpeed = 1.0f;
        }

        public PlaybackStats build(boolean z) {
            List list1;
            long[] arr_v2;
            long[] arr_v = this.playbackStateDurationsMs;
            List list0 = this.mediaTimeHistory;
            if(z) {
                arr_v2 = arr_v;
                list1 = list0;
            }
            else {
                long v = SystemClock.elapsedRealtime();
                long[] arr_v1 = Arrays.copyOf(this.playbackStateDurationsMs, 16);
                arr_v1[this.currentPlaybackState] += Math.max(0L, v - this.currentPlaybackStateStartTimeMs);
                this.maybeUpdateMaxRebufferTimeMs(v);
                this.maybeRecordVideoFormatTime(v);
                this.maybeRecordAudioFormatTime(v);
                ArrayList arrayList0 = new ArrayList(this.mediaTimeHistory);
                if(this.keepHistory && this.currentPlaybackState == 3) {
                    arrayList0.add(this.guessMediaTimeBasedOnElapsedRealtime(v));
                }
                arr_v2 = arr_v1;
                list1 = arrayList0;
            }
            int v1 = this.isJoinTimeInvalid || !this.hasBeenReady ? 1 : 0;
            long v2 = v1 == 0 ? arr_v2[2] : 0x8000000000000001L;
            int v3 = arr_v2[1] <= 0L ? 0 : 1;
            List list2 = z ? this.videoFormatHistory : new ArrayList(this.videoFormatHistory);
            List list3 = z ? this.audioFormatHistory : new ArrayList(this.audioFormatHistory);
            List list4 = z ? this.playbackStateHistory : new ArrayList(this.playbackStateHistory);
            long v4 = this.firstReportedTimeMs;
            boolean z1 = this.isForeground;
            int v5 = !this.hasBeenReady;
            int v6 = this.pauseBufferCount;
            int v7 = this.seekCount;
            int v8 = this.rebufferCount;
            boolean z2 = this.hasEnded;
            int v9 = this.pauseCount;
            long v10 = this.maxRebufferTimeMs;
            long v11 = this.videoFormatHeightTimeMs;
            long v12 = this.videoFormatHeightTimeProduct;
            long v13 = this.videoFormatBitrateTimeMs;
            long v14 = this.videoFormatBitrateTimeProduct;
            long v15 = this.audioFormatTimeMs;
            int v16 = this.initialVideoFormatHeight;
            long v17 = this.audioFormatBitrateTimeProduct;
            int v18 = v16 == -1 ? 0 : 1;
            long v19 = this.initialVideoFormatBitrate;
            int v20 = Long.compare(v19, -1L) == 0 ? 0 : 1;
            long v21 = this.initialAudioFormatBitrate;
            int v22 = Long.compare(v21, -1L) == 0 ? 0 : 1;
            long v23 = this.bandwidthTimeMs;
            long v24 = this.bandwidthBytes;
            long v25 = this.droppedFrames;
            long v26 = this.audioUnderruns;
            int v27 = this.fatalErrorCount;
            return v27 <= 0 ? new PlaybackStats(1, arr_v2, list4, list1, v4, ((int)z1), v5, ((int)z2), v3, v2, v1 ^ 1, v9, v6, v7, v8, v10, ((int)this.isAd), list2, list3, v11, v12, v13, v14, v15, v17, v18, v20, v16, v19, v22, v21, v23, v24, v25, v26, 0, v27, this.nonFatalErrorCount, this.fatalErrorHistory, this.nonFatalErrorHistory) : new PlaybackStats(1, arr_v2, list4, list1, v4, ((int)z1), v5, ((int)z2), v3, v2, v1 ^ 1, v9, v6, v7, v8, v10, ((int)this.isAd), list2, list3, v11, v12, v13, v14, v15, v17, v18, v20, v16, v19, v22, v21, v23, v24, v25, v26, 1, v27, this.nonFatalErrorCount, this.fatalErrorHistory, this.nonFatalErrorHistory);
        }

        private long[] guessMediaTimeBasedOnElapsedRealtime(long v) {
            long[] arr_v = (long[])Z.h(1, this.mediaTimeHistory);
            return new long[]{v, arr_v[1] + ((long)(((float)(v - arr_v[0])) * this.currentPlaybackSpeed))};
        }

        private static boolean isInvalidJoinTransition(int v, int v1) {
            return v == 1 || v == 2 || v == 14 ? v1 != 1 && v1 != 2 && v1 != 14 && (v1 != 3 && v1 != 4 && v1 != 9 && v1 != 11) : false;
        }

        private static boolean isPausedState(int v) {
            return v == 4 || v == 7;
        }

        private static boolean isReadyState(int v) {
            return v == 3 || v == 4 || v == 9;
        }

        private static boolean isRebufferingState(int v) {
            return v == 6 || v == 7 || v == 10;
        }

        private void maybeRecordAudioFormatTime(long v) {
            if(this.currentPlaybackState == 3) {
                Format format0 = this.currentAudioFormat;
                if(format0 != null) {
                    int v1 = format0.bitrate;
                    if(v1 != -1) {
                        long v2 = (long)(((float)(v - this.lastAudioFormatStartTimeMs)) * this.currentPlaybackSpeed);
                        this.audioFormatTimeMs += v2;
                        this.audioFormatBitrateTimeProduct = v2 * ((long)v1) + this.audioFormatBitrateTimeProduct;
                    }
                }
            }
            this.lastAudioFormatStartTimeMs = v;
        }

        private void maybeRecordVideoFormatTime(long v) {
            if(this.currentPlaybackState == 3) {
                Format format0 = this.currentVideoFormat;
                if(format0 != null) {
                    long v1 = (long)(((float)(v - this.lastVideoFormatStartTimeMs)) * this.currentPlaybackSpeed);
                    int v2 = format0.height;
                    if(v2 != -1) {
                        this.videoFormatHeightTimeMs += v1;
                        this.videoFormatHeightTimeProduct = ((long)v2) * v1 + this.videoFormatHeightTimeProduct;
                    }
                    int v3 = format0.bitrate;
                    if(v3 != -1) {
                        this.videoFormatBitrateTimeMs += v1;
                        this.videoFormatBitrateTimeProduct = v1 * ((long)v3) + this.videoFormatBitrateTimeProduct;
                    }
                }
            }
            this.lastVideoFormatStartTimeMs = v;
        }

        private void maybeUpdateAudioFormat(EventTime analyticsListener$EventTime0, Format format0) {
            if(!Util.areEqual(this.currentAudioFormat, format0)) {
                this.maybeRecordAudioFormatTime(analyticsListener$EventTime0.realtimeMs);
                if(format0 != null && this.initialAudioFormatBitrate == -1L) {
                    int v = format0.bitrate;
                    if(v != -1) {
                        this.initialAudioFormatBitrate = (long)v;
                    }
                }
                this.currentAudioFormat = format0;
                if(this.keepHistory) {
                    Pair pair0 = Pair.create(analyticsListener$EventTime0, format0);
                    this.audioFormatHistory.add(pair0);
                }
            }
        }

        private void maybeUpdateMaxRebufferTimeMs(long v) {
            if(PlaybackStatsTracker.isRebufferingState(this.currentPlaybackState)) {
                long v1 = v - this.lastRebufferStartTimeMs;
                if(this.maxRebufferTimeMs == 0x8000000000000001L || v1 > this.maxRebufferTimeMs) {
                    this.maxRebufferTimeMs = v1;
                }
            }
        }

        private void maybeUpdateMediaTimeHistory(long v, long v1) {
            if(this.keepHistory) {
                boolean z = false;
                if(this.currentPlaybackState == 3) {
                    z = true;
                }
                else if(v1 != 0x8000000000000001L) {
                    z = true;
                    if(!this.mediaTimeHistory.isEmpty()) {
                        long v2 = ((long[])Z.h(1, this.mediaTimeHistory))[1];
                        if(v2 != v1) {
                            this.mediaTimeHistory.add(new long[]{v, v2});
                        }
                    }
                }
                if(z) {
                    long[] arr_v = v1 == 0x8000000000000001L ? this.guessMediaTimeBasedOnElapsedRealtime(v) : new long[]{v, v1};
                    this.mediaTimeHistory.add(arr_v);
                }
            }
        }

        private void maybeUpdatePlaybackState(EventTime analyticsListener$EventTime0, boolean z) {
            boolean z1 = false;
            int v = this.resolveNewPlaybackState();
            if(v != this.currentPlaybackState) {
                Assertions.checkArgument(Long.compare(analyticsListener$EventTime0.realtimeMs, this.currentPlaybackStateStartTimeMs) >= 0);
                long v1 = analyticsListener$EventTime0.realtimeMs;
                int v2 = this.currentPlaybackState;
                this.playbackStateDurationsMs[v2] += v1 - this.currentPlaybackStateStartTimeMs;
                long v3 = 0x8000000000000001L;
                if(this.firstReportedTimeMs == 0x8000000000000001L) {
                    this.firstReportedTimeMs = v1;
                }
                this.isJoinTimeInvalid |= PlaybackStatsTracker.isInvalidJoinTransition(v2, v);
                this.hasBeenReady |= PlaybackStatsTracker.isReadyState(v);
                boolean z2 = this.hasEnded;
                if(v == 11) {
                    z1 = true;
                }
                this.hasEnded = z2 | z1;
                if(!PlaybackStatsTracker.isPausedState(this.currentPlaybackState) && PlaybackStatsTracker.isPausedState(v)) {
                    ++this.pauseCount;
                }
                if(v == 5) {
                    ++this.seekCount;
                }
                if(!PlaybackStatsTracker.isRebufferingState(this.currentPlaybackState) && PlaybackStatsTracker.isRebufferingState(v)) {
                    ++this.rebufferCount;
                    this.lastRebufferStartTimeMs = analyticsListener$EventTime0.realtimeMs;
                }
                if(PlaybackStatsTracker.isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && v == 7) {
                    ++this.pauseBufferCount;
                }
                long v4 = analyticsListener$EventTime0.realtimeMs;
                if(z) {
                    v3 = analyticsListener$EventTime0.eventPlaybackPositionMs;
                }
                this.maybeUpdateMediaTimeHistory(v4, v3);
                this.maybeUpdateMaxRebufferTimeMs(analyticsListener$EventTime0.realtimeMs);
                this.maybeRecordVideoFormatTime(analyticsListener$EventTime0.realtimeMs);
                this.maybeRecordAudioFormatTime(analyticsListener$EventTime0.realtimeMs);
                this.currentPlaybackState = v;
                this.currentPlaybackStateStartTimeMs = analyticsListener$EventTime0.realtimeMs;
                if(this.keepHistory) {
                    Pair pair0 = Pair.create(analyticsListener$EventTime0, v);
                    this.playbackStateHistory.add(pair0);
                }
            }
        }

        private void maybeUpdateVideoFormat(EventTime analyticsListener$EventTime0, Format format0) {
            if(!Util.areEqual(this.currentVideoFormat, format0)) {
                this.maybeRecordVideoFormatTime(analyticsListener$EventTime0.realtimeMs);
                if(format0 != null) {
                    if(this.initialVideoFormatHeight == -1) {
                        int v = format0.height;
                        if(v != -1) {
                            this.initialVideoFormatHeight = v;
                        }
                    }
                    if(this.initialVideoFormatBitrate == -1L) {
                        int v1 = format0.bitrate;
                        if(v1 != -1) {
                            this.initialVideoFormatBitrate = (long)v1;
                        }
                    }
                }
                this.currentVideoFormat = format0;
                if(this.keepHistory) {
                    Pair pair0 = Pair.create(analyticsListener$EventTime0, format0);
                    this.videoFormatHistory.add(pair0);
                }
            }
        }

        public void onAudioUnderrun() {
            ++this.audioUnderruns;
        }

        public void onBandwidthData(long v, long v1) {
            this.bandwidthTimeMs += v;
            this.bandwidthBytes += v1;
        }

        public void onDownstreamFormatChanged(EventTime analyticsListener$EventTime0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            int v = mediaSourceEventListener$MediaLoadData0.trackType;
            if(v != 0 && v != 2) {
                if(v == 1) {
                    this.maybeUpdateAudioFormat(analyticsListener$EventTime0, mediaSourceEventListener$MediaLoadData0.trackFormat);
                }
                return;
            }
            this.maybeUpdateVideoFormat(analyticsListener$EventTime0, mediaSourceEventListener$MediaLoadData0.trackFormat);
        }

        public void onDroppedVideoFrames(int v) {
            this.droppedFrames += (long)v;
        }

        public void onFatalError(EventTime analyticsListener$EventTime0, Exception exception0) {
            ++this.fatalErrorCount;
            if(this.keepHistory) {
                Pair pair0 = Pair.create(analyticsListener$EventTime0, exception0);
                this.fatalErrorHistory.add(pair0);
            }
            this.hasFatalError = true;
            this.isInterruptedByAd = false;
            this.isSeeking = false;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onFinished(EventTime analyticsListener$EventTime0) {
            this.isFinished = true;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, false);
        }

        public void onForeground(EventTime analyticsListener$EventTime0) {
            this.isForeground = true;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onInterruptedByAd(EventTime analyticsListener$EventTime0) {
            this.isInterruptedByAd = true;
            this.isSeeking = false;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onIsSuppressedChanged(EventTime analyticsListener$EventTime0, boolean z, boolean z1) {
            this.isSuppressed = z;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, z1);
        }

        public void onLoadStarted(EventTime analyticsListener$EventTime0) {
            this.startedLoading = true;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onNonFatalError(EventTime analyticsListener$EventTime0, Exception exception0) {
            ++this.nonFatalErrorCount;
            if(this.keepHistory) {
                Pair pair0 = Pair.create(analyticsListener$EventTime0, exception0);
                this.nonFatalErrorHistory.add(pair0);
            }
        }

        public void onPlaybackSpeedChanged(EventTime analyticsListener$EventTime0, float f) {
            this.maybeUpdateMediaTimeHistory(analyticsListener$EventTime0.realtimeMs, analyticsListener$EventTime0.eventPlaybackPositionMs);
            this.maybeRecordVideoFormatTime(analyticsListener$EventTime0.realtimeMs);
            this.maybeRecordAudioFormatTime(analyticsListener$EventTime0.realtimeMs);
            this.currentPlaybackSpeed = f;
        }

        public void onPlayerStateChanged(EventTime analyticsListener$EventTime0, boolean z, int v, boolean z1) {
            this.playWhenReady = z;
            this.playerPlaybackState = v;
            if(v != 1) {
                this.hasFatalError = false;
            }
            if(v == 1 || v == 4) {
                this.isInterruptedByAd = false;
            }
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, z1);
        }

        public void onPositionDiscontinuity(EventTime analyticsListener$EventTime0) {
            this.isInterruptedByAd = false;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onSeekProcessed(EventTime analyticsListener$EventTime0) {
            this.isSeeking = false;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onSeekStarted(EventTime analyticsListener$EventTime0) {
            this.isSeeking = true;
            this.maybeUpdatePlaybackState(analyticsListener$EventTime0, true);
        }

        public void onTracksChanged(EventTime analyticsListener$EventTime0, TrackSelectionArray trackSelectionArray0) {
            TrackSelection[] arr_trackSelection = trackSelectionArray0.getAll();
            boolean z = false;
            boolean z1 = false;
            for(int v = 0; v < arr_trackSelection.length; ++v) {
                TrackSelection trackSelection0 = arr_trackSelection[v];
                if(trackSelection0 != null && trackSelection0.length() > 0) {
                    int v1 = MimeTypes.getTrackType(trackSelection0.getFormat(0).sampleMimeType);
                    if(v1 == 2) {
                        z = true;
                    }
                    else if(v1 == 1) {
                        z1 = true;
                    }
                }
            }
            if(!z) {
                this.maybeUpdateVideoFormat(analyticsListener$EventTime0, null);
            }
            if(!z1) {
                this.maybeUpdateAudioFormat(analyticsListener$EventTime0, null);
            }
        }

        public void onVideoSizeChanged(EventTime analyticsListener$EventTime0, int v, int v1) {
            Format format0 = this.currentVideoFormat;
            if(format0 != null && format0.height == -1) {
                this.maybeUpdateVideoFormat(analyticsListener$EventTime0, format0.copyWithVideoSize(v, v1));
            }
        }

        private int resolveNewPlaybackState() {
            if(this.isFinished) {
                return this.currentPlaybackState == 11 ? 11 : 15;
            }
            if(this.isSeeking) {
                return 5;
            }
            if(this.hasFatalError) {
                return 13;
            }
            if(!this.isForeground) {
                return this.startedLoading;
            }
            if(this.isInterruptedByAd) {
                return 14;
            }
            int v = this.playerPlaybackState;
            if(v == 4) {
                return 11;
            }
            switch(v) {
                case 1: {
                    return this.currentPlaybackState == 0 ? this.currentPlaybackState : 12;
                }
                case 2: {
                    int v1 = this.currentPlaybackState;
                    if(v1 != 0 && v1 != 1 && v1 != 2 && v1 != 14) {
                        if(v1 != 5 && v1 != 8) {
                            if(!this.playWhenReady) {
                                return 7;
                            }
                            return this.isSuppressed ? 10 : 6;
                        }
                        return 8;
                    }
                    return 2;
                }
                case 3: {
                    if(!this.playWhenReady) {
                        return 4;
                    }
                    return this.isSuppressed ? 9 : 3;
                }
                default: {
                    return this.currentPlaybackState;
                }
            }
        }
    }

    private String activeAdPlayback;
    private String activeContentPlayback;
    private final Callback callback;
    private PlaybackStats finishedPlaybackStats;
    private boolean isSuppressed;
    private final boolean keepHistory;
    private final Period period;
    private boolean playWhenReady;
    private float playbackSpeed;
    private int playbackState;
    private final Map playbackStatsTrackers;
    private final PlaybackSessionManager sessionManager;
    private final Map sessionStartEventTimes;

    public PlaybackStatsListener(boolean z, Callback playbackStatsListener$Callback0) {
        this.callback = playbackStatsListener$Callback0;
        this.keepHistory = z;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager0 = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager0;
        this.playbackStatsTrackers = new HashMap();
        this.sessionStartEventTimes = new HashMap();
        this.finishedPlaybackStats = PlaybackStats.EMPTY;
        this.playWhenReady = false;
        this.playbackState = 1;
        this.playbackSpeed = 1.0f;
        this.period = new Period();
        defaultPlaybackSessionManager0.setListener(this);
    }

    public void finishAllSessions() {
        EventTime analyticsListener$EventTime0 = new EventTime(SystemClock.elapsedRealtime(), Timeline.EMPTY, 0, null, 0L, 0L, 0L);
        this.sessionManager.finishAllSessions(analyticsListener$EventTime0);
    }

    public PlaybackStats getCombinedPlaybackStats() {
        int v = 1;
        PlaybackStats[] arr_playbackStats = new PlaybackStats[this.playbackStatsTrackers.size() + 1];
        arr_playbackStats[0] = this.finishedPlaybackStats;
        for(Object object0: this.playbackStatsTrackers.values()) {
            arr_playbackStats[v] = ((PlaybackStatsTracker)object0).build(false);
            ++v;
        }
        return PlaybackStats.merge(arr_playbackStats);
    }

    public PlaybackStats getPlaybackStats() {
        PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker0;
        String s = this.activeAdPlayback;
        if(s != null) {
            playbackStatsListener$PlaybackStatsTracker0 = (PlaybackStatsTracker)this.playbackStatsTrackers.get(s);
            return playbackStatsListener$PlaybackStatsTracker0 == null ? null : playbackStatsListener$PlaybackStatsTracker0.build(false);
        }
        playbackStatsListener$PlaybackStatsTracker0 = this.activeContentPlayback == null ? null : ((PlaybackStatsTracker)this.playbackStatsTrackers.get(this.activeContentPlayback));
        return playbackStatsListener$PlaybackStatsTracker0 == null ? null : playbackStatsListener$PlaybackStatsTracker0.build(false);
    }

    private void maybeAddSession(EventTime analyticsListener$EventTime0) {
        if(analyticsListener$EventTime0.timeline.isEmpty() && this.playbackState == 1) {
            return;
        }
        this.sessionManager.updateSessions(analyticsListener$EventTime0);
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener
    public void onAdPlaybackStarted(EventTime analyticsListener$EventTime0, String s, String s1) {
        Assertions.checkState(((MediaPeriodId)Assertions.checkNotNull(analyticsListener$EventTime0.mediaPeriodId)).isAd());
        long v = analyticsListener$EventTime0.timeline.getPeriodByUid(analyticsListener$EventTime0.mediaPeriodId.periodUid, this.period).getAdGroupTimeUs(analyticsListener$EventTime0.mediaPeriodId.adGroupIndex);
        MediaPeriodId mediaSource$MediaPeriodId0 = new MediaPeriodId(analyticsListener$EventTime0.mediaPeriodId.periodUid, analyticsListener$EventTime0.mediaPeriodId.windowSequenceNumber, analyticsListener$EventTime0.mediaPeriodId.adGroupIndex);
        long v1 = C.usToMs((v == 0x8000000000000000L ? 0x8000000000000000L : this.period.getPositionInWindowUs() + v));
        EventTime analyticsListener$EventTime1 = new EventTime(analyticsListener$EventTime0.realtimeMs, analyticsListener$EventTime0.timeline, analyticsListener$EventTime0.windowIndex, mediaSource$MediaPeriodId0, v1, analyticsListener$EventTime0.currentPlaybackPositionMs, analyticsListener$EventTime0.totalBufferedDurationMs);
        ((PlaybackStatsTracker)Assertions.checkNotNull(((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)))).onInterruptedByAd(analyticsListener$EventTime1);
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(EventTime analyticsListener$EventTime0, int v, long v1, long v2) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onAudioUnderrun();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(EventTime analyticsListener$EventTime0, int v, long v1, long v2) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onBandwidthData(((long)v), v1);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(EventTime analyticsListener$EventTime0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onDownstreamFormatChanged(analyticsListener$EventTime0, mediaSourceEventListener$MediaLoadData0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(EventTime analyticsListener$EventTime0, Exception exception0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onNonFatalError(analyticsListener$EventTime0, exception0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(EventTime analyticsListener$EventTime0, int v, long v1) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onDroppedVideoFrames(v);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onNonFatalError(analyticsListener$EventTime0, iOException0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(EventTime analyticsListener$EventTime0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onLoadStarted(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(EventTime analyticsListener$EventTime0, PlaybackParameters playbackParameters0) {
        this.playbackSpeed = playbackParameters0.speed;
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.values()) {
            ((PlaybackStatsTracker)object0).onPlaybackSpeedChanged(analyticsListener$EventTime0, this.playbackSpeed);
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(EventTime analyticsListener$EventTime0, int v) {
        this.isSuppressed = v != 0;
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            boolean z = this.sessionManager.belongsToSession(analyticsListener$EventTime0, ((String)object0));
            ((PlaybackStatsTracker)this.playbackStatsTrackers.get(((String)object0))).onIsSuppressedChanged(analyticsListener$EventTime0, this.isSuppressed, z);
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(EventTime analyticsListener$EventTime0, ExoPlaybackException exoPlaybackException0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onFatalError(analyticsListener$EventTime0, exoPlaybackException0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(EventTime analyticsListener$EventTime0, boolean z, int v) {
        this.playWhenReady = z;
        this.playbackState = v;
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            boolean z1 = this.sessionManager.belongsToSession(analyticsListener$EventTime0, ((String)object0));
            ((PlaybackStatsTracker)this.playbackStatsTrackers.get(((String)object0))).onPlayerStateChanged(analyticsListener$EventTime0, z, v, z1);
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(EventTime analyticsListener$EventTime0, int v) {
        this.sessionManager.handlePositionDiscontinuity(analyticsListener$EventTime0, v);
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onPositionDiscontinuity(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekProcessed(EventTime analyticsListener$EventTime0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onSeekProcessed(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(EventTime analyticsListener$EventTime0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onSeekStarted(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener
    public void onSessionActive(EventTime analyticsListener$EventTime0, String s) {
        ((PlaybackStatsTracker)Assertions.checkNotNull(((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)))).onForeground(analyticsListener$EventTime0);
        if(analyticsListener$EventTime0.mediaPeriodId != null && analyticsListener$EventTime0.mediaPeriodId.isAd()) {
            this.activeAdPlayback = s;
            return;
        }
        this.activeContentPlayback = s;
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener
    public void onSessionCreated(EventTime analyticsListener$EventTime0, String s) {
        PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker0 = new PlaybackStatsTracker(this.keepHistory, analyticsListener$EventTime0);
        playbackStatsListener$PlaybackStatsTracker0.onPlayerStateChanged(analyticsListener$EventTime0, this.playWhenReady, this.playbackState, true);
        playbackStatsListener$PlaybackStatsTracker0.onIsSuppressedChanged(analyticsListener$EventTime0, this.isSuppressed, true);
        playbackStatsListener$PlaybackStatsTracker0.onPlaybackSpeedChanged(analyticsListener$EventTime0, this.playbackSpeed);
        this.playbackStatsTrackers.put(s, playbackStatsListener$PlaybackStatsTracker0);
        this.sessionStartEventTimes.put(s, analyticsListener$EventTime0);
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener
    public void onSessionFinished(EventTime analyticsListener$EventTime0, String s, boolean z) {
        if(s.equals(this.activeAdPlayback)) {
            this.activeAdPlayback = null;
        }
        else if(s.equals(this.activeContentPlayback)) {
            this.activeContentPlayback = null;
        }
        PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker0 = (PlaybackStatsTracker)Assertions.checkNotNull(((PlaybackStatsTracker)this.playbackStatsTrackers.remove(s)));
        EventTime analyticsListener$EventTime1 = (EventTime)Assertions.checkNotNull(((EventTime)this.sessionStartEventTimes.remove(s)));
        if(z) {
            playbackStatsListener$PlaybackStatsTracker0.onPlayerStateChanged(analyticsListener$EventTime0, true, 4, false);
        }
        playbackStatsListener$PlaybackStatsTracker0.onFinished(analyticsListener$EventTime0);
        PlaybackStats playbackStats0 = playbackStatsListener$PlaybackStatsTracker0.build(true);
        this.finishedPlaybackStats = PlaybackStats.merge(new PlaybackStats[]{this.finishedPlaybackStats, playbackStats0});
        Callback playbackStatsListener$Callback0 = this.callback;
        if(playbackStatsListener$Callback0 != null) {
            playbackStatsListener$Callback0.onPlaybackStatsReady(analyticsListener$EventTime1, playbackStats0);
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(EventTime analyticsListener$EventTime0, int v) {
        this.sessionManager.handleTimelineUpdate(analyticsListener$EventTime0);
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onPositionDiscontinuity(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(EventTime analyticsListener$EventTime0, TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onTracksChanged(analyticsListener$EventTime0, trackSelectionArray0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(EventTime analyticsListener$EventTime0, int v, int v1, int v2, float f) {
        this.maybeAddSession(analyticsListener$EventTime0);
        for(Object object0: this.playbackStatsTrackers.keySet()) {
            String s = (String)object0;
            if(this.sessionManager.belongsToSession(analyticsListener$EventTime0, s)) {
                ((PlaybackStatsTracker)this.playbackStatsTrackers.get(s)).onVideoSizeChanged(analyticsListener$EventTime0, v, v1);
            }
        }
    }
}

