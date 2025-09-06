package com.google.android.exoplayer2.analytics;

import android.util.Pair;
import b3.Z;
import java.util.Collections;
import java.util.List;

public final class PlaybackStats {
    public static final PlaybackStats EMPTY = null;
    public static final int PLAYBACK_STATE_ABANDONED = 15;
    public static final int PLAYBACK_STATE_BUFFERING = 6;
    static final int PLAYBACK_STATE_COUNT = 16;
    public static final int PLAYBACK_STATE_ENDED = 11;
    public static final int PLAYBACK_STATE_FAILED = 13;
    public static final int PLAYBACK_STATE_INTERRUPTED_BY_AD = 14;
    public static final int PLAYBACK_STATE_JOINING_BACKGROUND = 1;
    public static final int PLAYBACK_STATE_JOINING_FOREGROUND = 2;
    public static final int PLAYBACK_STATE_NOT_STARTED = 0;
    public static final int PLAYBACK_STATE_PAUSED = 4;
    public static final int PLAYBACK_STATE_PAUSED_BUFFERING = 7;
    public static final int PLAYBACK_STATE_PLAYING = 3;
    public static final int PLAYBACK_STATE_SEEKING = 5;
    public static final int PLAYBACK_STATE_SEEK_BUFFERING = 8;
    public static final int PLAYBACK_STATE_STOPPED = 12;
    public static final int PLAYBACK_STATE_SUPPRESSED = 9;
    public static final int PLAYBACK_STATE_SUPPRESSED_BUFFERING = 10;
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final List audioFormatHistory;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final List fatalErrorHistory;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final List mediaTimeHistory;
    public final int nonFatalErrorCount;
    public final List nonFatalErrorHistory;
    public final int playbackCount;
    private final long[] playbackStateDurationsMs;
    public final List playbackStateHistory;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;
    public final List videoFormatHistory;

    static {
        PlaybackStats.EMPTY = PlaybackStats.merge(new PlaybackStats[0]);
    }

    public PlaybackStats(int v, long[] arr_v, List list0, List list1, long v1, int v2, int v3, int v4, int v5, long v6, int v7, int v8, int v9, int v10, int v11, long v12, int v13, List list2, List list3, long v14, long v15, long v16, long v17, long v18, long v19, int v20, int v21, int v22, long v23, int v24, long v25, long v26, long v27, long v28, long v29, int v30, int v31, int v32, List list4, List list5) {
        this.playbackCount = v;
        this.playbackStateDurationsMs = arr_v;
        this.playbackStateHistory = Collections.unmodifiableList(list0);
        this.mediaTimeHistory = Collections.unmodifiableList(list1);
        this.firstReportedTimeMs = v1;
        this.foregroundPlaybackCount = v2;
        this.abandonedBeforeReadyCount = v3;
        this.endedCount = v4;
        this.backgroundJoiningCount = v5;
        this.totalValidJoinTimeMs = v6;
        this.validJoinTimeCount = v7;
        this.totalPauseCount = v8;
        this.totalPauseBufferCount = v9;
        this.totalSeekCount = v10;
        this.totalRebufferCount = v11;
        this.maxRebufferTimeMs = v12;
        this.adPlaybackCount = v13;
        this.videoFormatHistory = Collections.unmodifiableList(list2);
        this.audioFormatHistory = Collections.unmodifiableList(list3);
        this.totalVideoFormatHeightTimeMs = v14;
        this.totalVideoFormatHeightTimeProduct = v15;
        this.totalVideoFormatBitrateTimeMs = v16;
        this.totalVideoFormatBitrateTimeProduct = v17;
        this.totalAudioFormatTimeMs = v18;
        this.totalAudioFormatBitrateTimeProduct = v19;
        this.initialVideoFormatHeightCount = v20;
        this.initialVideoFormatBitrateCount = v21;
        this.totalInitialVideoFormatHeight = v22;
        this.totalInitialVideoFormatBitrate = v23;
        this.initialAudioFormatBitrateCount = v24;
        this.totalInitialAudioFormatBitrate = v25;
        this.totalBandwidthTimeMs = v26;
        this.totalBandwidthBytes = v27;
        this.totalDroppedFrames = v28;
        this.totalAudioUnderruns = v29;
        this.fatalErrorPlaybackCount = v30;
        this.fatalErrorCount = v31;
        this.nonFatalErrorCount = v32;
        this.fatalErrorHistory = Collections.unmodifiableList(list4);
        this.nonFatalErrorHistory = Collections.unmodifiableList(list5);
    }

    public float getAbandonedBeforeReadyRatio() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)(this.abandonedBeforeReadyCount - (this.playbackCount - this.foregroundPlaybackCount))) / ((float)this.foregroundPlaybackCount);
    }

    public float getAudioUnderrunRate() {
        long v = this.getTotalPlayTimeMs();
        return v == 0L ? 0.0f : ((float)this.totalAudioUnderruns) * 1000.0f / ((float)v);
    }

    public float getDroppedFramesRate() {
        long v = this.getTotalPlayTimeMs();
        return v == 0L ? 0.0f : ((float)this.totalDroppedFrames) * 1000.0f / ((float)v);
    }

    public float getEndedRatio() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.endedCount) / ((float)this.foregroundPlaybackCount);
    }

    public float getFatalErrorRate() {
        long v = this.getTotalPlayTimeMs();
        return v == 0L ? 0.0f : ((float)this.fatalErrorCount) * 1000.0f / ((float)v);
    }

    public float getFatalErrorRatio() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.fatalErrorPlaybackCount) / ((float)this.foregroundPlaybackCount);
    }

    public float getJoinTimeRatio() {
        long v = this.getTotalPlayAndWaitTimeMs();
        return v == 0L ? 0.0f : ((float)this.getTotalJoinTimeMs()) / ((float)v);
    }

    public int getMeanAudioFormatBitrate() {
        return this.totalAudioFormatTimeMs == 0L ? -1 : ((int)(this.totalAudioFormatBitrateTimeProduct / this.totalAudioFormatTimeMs));
    }

    public int getMeanBandwidth() {
        return this.totalBandwidthTimeMs == 0L ? -1 : ((int)(this.totalBandwidthBytes * 8000L / this.totalBandwidthTimeMs));
    }

    public long getMeanElapsedTimeMs() {
        return this.playbackCount == 0 ? 0x8000000000000001L : this.getTotalElapsedTimeMs() / ((long)this.playbackCount);
    }

    public int getMeanInitialAudioFormatBitrate() {
        return this.initialAudioFormatBitrateCount == 0 ? -1 : ((int)(this.totalInitialAudioFormatBitrate / ((long)this.initialAudioFormatBitrateCount)));
    }

    public int getMeanInitialVideoFormatBitrate() {
        return this.initialVideoFormatBitrateCount == 0 ? -1 : ((int)(this.totalInitialVideoFormatBitrate / ((long)this.initialVideoFormatBitrateCount)));
    }

    public int getMeanInitialVideoFormatHeight() {
        return this.initialVideoFormatHeightCount == 0 ? -1 : this.totalInitialVideoFormatHeight / this.initialVideoFormatHeightCount;
    }

    public long getMeanJoinTimeMs() {
        return this.validJoinTimeCount == 0 ? 0x8000000000000001L : this.totalValidJoinTimeMs / ((long)this.validJoinTimeCount);
    }

    public float getMeanNonFatalErrorCount() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.nonFatalErrorCount) / ((float)this.foregroundPlaybackCount);
    }

    public float getMeanPauseBufferCount() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.totalPauseBufferCount) / ((float)this.foregroundPlaybackCount);
    }

    public float getMeanPauseCount() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.totalPauseCount) / ((float)this.foregroundPlaybackCount);
    }

    public long getMeanPausedTimeMs() {
        return this.foregroundPlaybackCount == 0 ? 0x8000000000000001L : this.getTotalPausedTimeMs() / ((long)this.foregroundPlaybackCount);
    }

    public long getMeanPlayAndWaitTimeMs() {
        return this.foregroundPlaybackCount == 0 ? 0x8000000000000001L : this.getTotalPlayAndWaitTimeMs() / ((long)this.foregroundPlaybackCount);
    }

    public long getMeanPlayTimeMs() {
        return this.foregroundPlaybackCount == 0 ? 0x8000000000000001L : this.getTotalPlayTimeMs() / ((long)this.foregroundPlaybackCount);
    }

    public float getMeanRebufferCount() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.totalRebufferCount) / ((float)this.foregroundPlaybackCount);
    }

    public long getMeanRebufferTimeMs() {
        return this.foregroundPlaybackCount == 0 ? 0x8000000000000001L : this.getTotalRebufferTimeMs() / ((long)this.foregroundPlaybackCount);
    }

    public float getMeanSeekCount() {
        return this.foregroundPlaybackCount == 0 ? 0.0f : ((float)this.totalSeekCount) / ((float)this.foregroundPlaybackCount);
    }

    public long getMeanSeekTimeMs() {
        return this.foregroundPlaybackCount == 0 ? 0x8000000000000001L : this.getTotalSeekTimeMs() / ((long)this.foregroundPlaybackCount);
    }

    public long getMeanSingleRebufferTimeMs() {
        return this.totalRebufferCount == 0 ? 0x8000000000000001L : (this.getPlaybackStateDurationMs(7) + this.getPlaybackStateDurationMs(6)) / ((long)this.totalRebufferCount);
    }

    public long getMeanSingleSeekTimeMs() {
        return this.totalSeekCount == 0 ? 0x8000000000000001L : this.getTotalSeekTimeMs() / ((long)this.totalSeekCount);
    }

    public float getMeanTimeBetweenFatalErrors() {
        return 1.0f / this.getFatalErrorRate();
    }

    public float getMeanTimeBetweenNonFatalErrors() {
        return 1.0f / this.getNonFatalErrorRate();
    }

    public float getMeanTimeBetweenRebuffers() {
        return 1.0f / this.getRebufferRate();
    }

    public int getMeanVideoFormatBitrate() {
        return this.totalVideoFormatBitrateTimeMs == 0L ? -1 : ((int)(this.totalVideoFormatBitrateTimeProduct / this.totalVideoFormatBitrateTimeMs));
    }

    public int getMeanVideoFormatHeight() {
        return this.totalVideoFormatHeightTimeMs == 0L ? -1 : ((int)(this.totalVideoFormatHeightTimeProduct / this.totalVideoFormatHeightTimeMs));
    }

    public long getMeanWaitTimeMs() {
        return this.foregroundPlaybackCount == 0 ? 0x8000000000000001L : this.getTotalWaitTimeMs() / ((long)this.foregroundPlaybackCount);
    }

    public long getMediaTimeMsAtRealtimeMs(long v) {
        if(this.mediaTimeHistory.isEmpty()) {
            return 0x8000000000000001L;
        }
        int v1;
        for(v1 = 0; v1 < this.mediaTimeHistory.size() && ((long[])this.mediaTimeHistory.get(v1))[0] <= v; ++v1) {
        }
        if(v1 == 0) {
            return ((long[])this.mediaTimeHistory.get(0))[1];
        }
        if(v1 == this.mediaTimeHistory.size()) {
            return ((long[])Z.h(1, this.mediaTimeHistory))[1];
        }
        long v2 = ((long[])this.mediaTimeHistory.get(v1 - 1))[0];
        long v3 = ((long[])this.mediaTimeHistory.get(v1 - 1))[1];
        long v4 = ((long[])this.mediaTimeHistory.get(v1))[0] - v2;
        return v4 == 0L ? v3 : v3 + ((long)(((float)(((long[])this.mediaTimeHistory.get(v1))[1] - v3)) * (((float)(v - v2)) / ((float)v4))));
    }

    public float getNonFatalErrorRate() {
        long v = this.getTotalPlayTimeMs();
        return v == 0L ? 0.0f : ((float)this.nonFatalErrorCount) * 1000.0f / ((float)v);
    }

    public int getPlaybackStateAtTime(long v) {
        int v1 = 0;
        for(Object object0: this.playbackStateHistory) {
            if(((EventTime)((Pair)object0).first).realtimeMs > v) {
                break;
            }
            v1 = (int)(((Integer)((Pair)object0).second));
        }
        return v1;
    }

    public long getPlaybackStateDurationMs(int v) {
        return this.playbackStateDurationsMs[v];
    }

    public float getRebufferRate() {
        long v = this.getTotalPlayTimeMs();
        return v == 0L ? 0.0f : ((float)this.totalRebufferCount) * 1000.0f / ((float)v);
    }

    public float getRebufferTimeRatio() {
        long v = this.getTotalPlayAndWaitTimeMs();
        return v == 0L ? 0.0f : ((float)this.getTotalRebufferTimeMs()) / ((float)v);
    }

    public float getSeekTimeRatio() {
        long v = this.getTotalPlayAndWaitTimeMs();
        return v == 0L ? 0.0f : ((float)this.getTotalSeekTimeMs()) / ((float)v);
    }

    public long getTotalElapsedTimeMs() {
        long v = 0L;
        for(int v1 = 0; v1 < 16; ++v1) {
            v += this.playbackStateDurationsMs[v1];
        }
        return v;
    }

    public long getTotalJoinTimeMs() {
        return this.getPlaybackStateDurationMs(2);
    }

    public long getTotalPausedTimeMs() {
        return this.getPlaybackStateDurationMs(7) + this.getPlaybackStateDurationMs(4);
    }

    public long getTotalPlayAndWaitTimeMs() {
        return this.getTotalWaitTimeMs() + this.getTotalPlayTimeMs();
    }

    public long getTotalPlayTimeMs() {
        return this.getPlaybackStateDurationMs(3);
    }

    public long getTotalRebufferTimeMs() {
        return this.getPlaybackStateDurationMs(6);
    }

    public long getTotalSeekTimeMs() {
        return this.getPlaybackStateDurationMs(8) + this.getPlaybackStateDurationMs(5);
    }

    public long getTotalWaitTimeMs() {
        return this.getPlaybackStateDurationMs(8) + (this.getPlaybackStateDurationMs(5) + (this.getPlaybackStateDurationMs(6) + this.getPlaybackStateDurationMs(2)));
    }

    public float getWaitTimeRatio() {
        long v = this.getTotalPlayAndWaitTimeMs();
        return v == 0L ? 0.0f : ((float)this.getTotalWaitTimeMs()) / ((float)v);
    }

    public static PlaybackStats merge(PlaybackStats[] arr_playbackStats) {
        long[] arr_v = new long[16];
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        int v13 = 0;
        long v14 = 0L;
        long v15 = 0L;
        long v16 = 0L;
        long v17 = 0L;
        long v18 = 0L;
        long v19 = 0L;
        long v20 = 0L;
        long v21 = 0L;
        long v22 = 0L;
        long v23 = 0L;
        long v24 = -1L;
        long v25 = -1L;
        long v26 = 0x8000000000000001L;
        long v27 = 0x8000000000000001L;
        long v28 = 0x8000000000000001L;
        int v29 = -1;
        int v31 = 0;
        int v32 = 0;
        int v33 = 0;
        for(int v30 = 0; v30 < arr_playbackStats.length; ++v30) {
            PlaybackStats playbackStats0 = arr_playbackStats[v30];
            v += playbackStats0.playbackCount;
            for(int v34 = 0; v34 < 16; ++v34) {
                arr_v[v34] += playbackStats0.playbackStateDurationsMs[v34];
            }
            if(v27 == 0x8000000000000001L) {
                v27 = playbackStats0.firstReportedTimeMs;
            }
            else {
                long v35 = playbackStats0.firstReportedTimeMs;
                if(v35 != 0x8000000000000001L) {
                    v27 = Math.min(v27, v35);
                }
            }
            v31 += playbackStats0.foregroundPlaybackCount;
            v32 += playbackStats0.abandonedBeforeReadyCount;
            v33 += playbackStats0.endedCount;
            v1 += playbackStats0.backgroundJoiningCount;
            if(v28 == 0x8000000000000001L) {
                v28 = playbackStats0.totalValidJoinTimeMs;
            }
            else {
                long v36 = playbackStats0.totalValidJoinTimeMs;
                if(v36 != 0x8000000000000001L) {
                    v28 += v36;
                }
            }
            v2 += playbackStats0.validJoinTimeCount;
            v3 += playbackStats0.totalPauseCount;
            v4 += playbackStats0.totalPauseBufferCount;
            v5 += playbackStats0.totalSeekCount;
            v6 += playbackStats0.totalRebufferCount;
            if(v26 == 0x8000000000000001L) {
                v26 = playbackStats0.maxRebufferTimeMs;
            }
            else {
                long v37 = playbackStats0.maxRebufferTimeMs;
                if(v37 != 0x8000000000000001L) {
                    v26 = Math.max(v26, v37);
                }
            }
            v7 += playbackStats0.adPlaybackCount;
            v14 += playbackStats0.totalVideoFormatHeightTimeMs;
            v15 += playbackStats0.totalVideoFormatHeightTimeProduct;
            v16 += playbackStats0.totalVideoFormatBitrateTimeMs;
            v17 += playbackStats0.totalVideoFormatBitrateTimeProduct;
            v18 += playbackStats0.totalAudioFormatTimeMs;
            v19 += playbackStats0.totalAudioFormatBitrateTimeProduct;
            v8 += playbackStats0.initialVideoFormatHeightCount;
            v9 += playbackStats0.initialVideoFormatBitrateCount;
            if(v29 == -1) {
                v29 = playbackStats0.totalInitialVideoFormatHeight;
            }
            else {
                int v38 = playbackStats0.totalInitialVideoFormatHeight;
                if(v38 != -1) {
                    v29 += v38;
                }
            }
            if(v24 == -1L) {
                v24 = playbackStats0.totalInitialVideoFormatBitrate;
            }
            else {
                long v39 = playbackStats0.totalInitialVideoFormatBitrate;
                if(v39 != -1L) {
                    v24 += v39;
                }
            }
            v10 += playbackStats0.initialAudioFormatBitrateCount;
            if(v25 == -1L) {
                v25 = playbackStats0.totalInitialAudioFormatBitrate;
            }
            else {
                long v40 = playbackStats0.totalInitialAudioFormatBitrate;
                if(v40 != -1L) {
                    v25 += v40;
                }
            }
            v20 += playbackStats0.totalBandwidthTimeMs;
            v21 += playbackStats0.totalBandwidthBytes;
            v22 += playbackStats0.totalDroppedFrames;
            v23 += playbackStats0.totalAudioUnderruns;
            v11 += playbackStats0.fatalErrorPlaybackCount;
            v12 += playbackStats0.fatalErrorCount;
            v13 += playbackStats0.nonFatalErrorCount;
        }
        return new PlaybackStats(v, arr_v, Collections.EMPTY_LIST, Collections.EMPTY_LIST, v27, v31, v32, v33, v1, v28, v2, v3, v4, v5, v6, v26, v7, Collections.EMPTY_LIST, Collections.EMPTY_LIST, v14, v15, v16, v17, v18, v19, v8, v9, v29, v24, v10, v25, v20, v21, v22, v23, v11, v12, v13, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
    }
}

