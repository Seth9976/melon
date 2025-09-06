package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;

final class AudioTrackPositionTracker {
    public interface Listener {
        void onInvalidLatency(long arg1);

        void onPositionFramesMismatch(long arg1, long arg2, long arg3, long arg4);

        void onSystemTimeUsMismatch(long arg1, long arg2, long arg3, long arg4);

        void onUnderrun(int arg1, long arg2);
    }

    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200L;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000L;
    private static final long MAX_LATENCY_US = 5000000L;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final long MODE_SWITCH_SMOOTHING_DURATION_US = 1000000L;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastPositionUs;
    private long lastRawPlaybackHeadPosition;
    private boolean lastSampleUsedGetTimestampMode;
    private long lastSystemTimeUs;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long previousModePositionUs;
    private long previousModeSystemTimeUs;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public AudioTrackPositionTracker(Listener audioTrackPositionTracker$Listener0) {
        this.listener = (Listener)Assertions.checkNotNull(audioTrackPositionTracker$Listener0);
        if(Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            }
            catch(NoSuchMethodException unused_ex) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && ((AudioTrack)Assertions.checkNotNull(this.audioTrack)).getPlayState() == 2 && this.getPlaybackHeadPosition() == 0L;
    }

    private long framesToDurationUs(long v) {
        return v * 1000000L / ((long)this.outputSampleRate);
    }

    public int getAvailableBufferSize(long v) {
        long v1 = this.getPlaybackHeadPosition();
        return this.bufferSize - ((int)(v - v1 * ((long)this.outputPcmFrameSize)));
    }

    public long getCurrentPositionUs(boolean z) {
        long v2;
        if(((AudioTrack)Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3) {
            this.maybeSampleSyncParams();
        }
        long v = System.nanoTime();
        AudioTimestampPoller audioTimestampPoller0 = (AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller);
        boolean z1 = audioTimestampPoller0.hasAdvancingTimestamp();
        if(z1) {
            long v1 = this.framesToDurationUs(audioTimestampPoller0.getTimestampPositionFrames());
            v2 = v / 1000L - audioTimestampPoller0.getTimestampSystemTimeUs() + v1;
        }
        else {
            v2 = this.playheadOffsetCount == 0 ? this.getPlaybackHeadPositionUs() : this.smoothedPlayheadOffsetUs + v / 1000L;
            if(!z) {
                v2 = Math.max(0L, v2 - this.latencyUs);
            }
        }
        if(this.lastSampleUsedGetTimestampMode != z1) {
            this.previousModeSystemTimeUs = this.lastSystemTimeUs;
            this.previousModePositionUs = this.lastPositionUs;
        }
        long v3 = v / 1000L - this.previousModeSystemTimeUs;
        if(v3 < 1000000L) {
            long v4 = v3 * 1000L / 1000000L;
            v2 = ((1000L - v4) * (this.previousModePositionUs + v3) + v2 * v4) / 1000L;
        }
        this.lastSystemTimeUs = v / 1000L;
        this.lastPositionUs = v2;
        this.lastSampleUsedGetTimestampMode = z1;
        return v2;
    }

    private long getPlaybackHeadPosition() {
        AudioTrack audioTrack0 = (AudioTrack)Assertions.checkNotNull(this.audioTrack);
        if(this.stopTimestampUs != 0x8000000000000001L) {
            long v = SystemClock.elapsedRealtime();
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + (v * 1000L - this.stopTimestampUs) * ((long)this.outputSampleRate) / 1000000L);
        }
        int v1 = audioTrack0.getPlayState();
        if(v1 == 1) {
            return 0L;
        }
        long v2 = ((long)audioTrack0.getPlaybackHeadPosition()) & 0xFFFFFFFFL;
        if(this.needsPassthroughWorkarounds) {
            if(v1 == 2 && v2 == 0L) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            v2 += this.passthroughWorkaroundPauseOffset;
        }
        if(Util.SDK_INT <= 29) {
            if(v2 == 0L && this.lastRawPlaybackHeadPosition > 0L && v1 == 3) {
                if(this.forceResetWorkaroundTimeMs == 0x8000000000000001L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = 0x8000000000000001L;
        }
        if(this.lastRawPlaybackHeadPosition > v2) {
            ++this.rawPlaybackHeadWrapCount;
        }
        this.lastRawPlaybackHeadPosition = v2;
        return v2 + (this.rawPlaybackHeadWrapCount << 0x20);
    }

    private long getPlaybackHeadPositionUs() {
        return this.framesToDurationUs(this.getPlaybackHeadPosition());
    }

    public void handleEndOfStream(long v) {
        this.stopPlaybackHeadPosition = this.getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000L;
        this.endPlaybackHeadPosition = v;
    }

    public boolean hasPendingData(long v) {
        return v > this.getPlaybackHeadPosition() || this.forceHasPendingData();
    }

    public boolean isPlaying() {
        return ((AudioTrack)Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3;
    }

    public boolean isStalled(long v) {
        return this.forceResetWorkaroundTimeMs != 0x8000000000000001L && v > 0L && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200L;
    }

    public boolean mayHandleBuffer(long v) {
        int v1 = ((AudioTrack)Assertions.checkNotNull(this.audioTrack)).getPlayState();
        if(this.needsPassthroughWorkarounds) {
            switch(v1) {
                case 1: {
                    if(this.getPlaybackHeadPosition() == 0L) {
                        return false;
                    }
                    break;
                }
                case 2: {
                    this.hasData = false;
                    return false;
                }
            }
        }
        boolean z = this.hasData;
        boolean z1 = this.hasPendingData(v);
        this.hasData = z1;
        if(z && !z1 && v1 != 1) {
            Listener audioTrackPositionTracker$Listener0 = this.listener;
            if(audioTrackPositionTracker$Listener0 != null) {
                audioTrackPositionTracker$Listener0.onUnderrun(this.bufferSize, C.usToMs(this.bufferSizeUs));
            }
        }
        return true;
    }

    private void maybePollAndCheckTimestamp(long v, long v1) {
        AudioTimestampPoller audioTimestampPoller0 = (AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller);
        if(!audioTimestampPoller0.maybePollTimestamp(v)) {
            return;
        }
        long v2 = audioTimestampPoller0.getTimestampSystemTimeUs();
        long v3 = audioTimestampPoller0.getTimestampPositionFrames();
        if(Math.abs(v2 - v) > 5000000L) {
            this.listener.onSystemTimeUsMismatch(v3, v2, v, v1);
            audioTimestampPoller0.rejectTimestamp();
            return;
        }
        if(Math.abs(this.framesToDurationUs(v3) - v1) > 5000000L) {
            this.listener.onPositionFramesMismatch(v3, v2, v, v1);
            audioTimestampPoller0.rejectTimestamp();
            return;
        }
        audioTimestampPoller0.acceptTimestamp();
    }

    private void maybeSampleSyncParams() {
        long v = this.getPlaybackHeadPositionUs();
        if(v != 0L) {
            long v1 = System.nanoTime();
            if(v1 / 1000L - this.lastPlayheadSampleTimeUs >= 30000L) {
                int v2 = this.nextPlayheadOffsetIndex;
                this.playheadOffsets[v2] = v - v1 / 1000L;
                this.nextPlayheadOffsetIndex = (v2 + 1) % 10;
                int v3 = this.playheadOffsetCount;
                if(v3 < 10) {
                    this.playheadOffsetCount = v3 + 1;
                }
                this.lastPlayheadSampleTimeUs = v1 / 1000L;
                this.smoothedPlayheadOffsetUs = 0L;
                for(int v4 = 0; true; ++v4) {
                    int v5 = this.playheadOffsetCount;
                    if(v4 >= v5) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs = this.playheadOffsets[v4] / ((long)v5) + this.smoothedPlayheadOffsetUs;
                }
            }
            if(!this.needsPassthroughWorkarounds) {
                this.maybePollAndCheckTimestamp(v1 / 1000L, v);
                this.maybeUpdateLatency(v1 / 1000L);
            }
        }
    }

    private void maybeUpdateLatency(long v) {
        if(this.isOutputPcm) {
            Method method0 = this.getLatencyMethod;
            if(method0 != null && v - this.lastLatencySampleTimeUs >= 500000L) {
                try {
                    long v1 = Math.max(((long)(((int)(((Integer)Util.castNonNull(((Integer)method0.invoke(Assertions.checkNotNull(this.audioTrack), null)))))))) * 1000L - this.bufferSizeUs, 0L);
                    this.latencyUs = v1;
                    if(v1 > 5000000L) {
                        this.listener.onInvalidLatency(v1);
                        this.latencyUs = 0L;
                    }
                }
                catch(Exception unused_ex) {
                    this.getLatencyMethod = null;
                }
                this.lastLatencySampleTimeUs = v;
            }
        }
    }

    private static boolean needsPassthroughWorkarounds(int v) {
        return Util.SDK_INT < 23 && (v == 5 || v == 6);
    }

    public boolean pause() {
        this.resetSyncParams();
        if(this.stopTimestampUs == 0x8000000000000001L) {
            ((AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller)).reset();
            return true;
        }
        return false;
    }

    public void reset() {
        this.resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
        this.lastSystemTimeUs = 0L;
        this.previousModeSystemTimeUs = 0L;
    }

    public void setAudioTrack(AudioTrack audioTrack0, int v, int v1, int v2) {
        this.audioTrack = audioTrack0;
        this.outputPcmFrameSize = v1;
        this.bufferSize = v2;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack0);
        this.outputSampleRate = audioTrack0.getSampleRate();
        this.needsPassthroughWorkarounds = AudioTrackPositionTracker.needsPassthroughWorkarounds(v);
        boolean z = Util.isEncodingLinearPcm(v);
        this.isOutputPcm = z;
        this.bufferSizeUs = z ? this.framesToDurationUs(((long)(v2 / v1))) : 0x8000000000000001L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.passthroughWorkaroundPauseOffset = 0L;
        this.hasData = false;
        this.stopTimestampUs = 0x8000000000000001L;
        this.forceResetWorkaroundTimeMs = 0x8000000000000001L;
        this.lastLatencySampleTimeUs = 0L;
        this.latencyUs = 0L;
    }

    public void start() {
        ((AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller)).reset();
    }
}

