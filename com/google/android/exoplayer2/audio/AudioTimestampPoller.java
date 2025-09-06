package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.Util;

final class AudioTimestampPoller {
    @TargetApi(19)
    static final class AudioTimestampV19 {
        private final AudioTimestamp audioTimestamp;
        private final AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public AudioTimestampV19(AudioTrack audioTrack0) {
            this.audioTrack = audioTrack0;
            this.audioTimestamp = new AudioTimestamp();
        }

        public long getTimestampPositionFrames() {
            return this.lastTimestampPositionFrames;
        }

        public long getTimestampSystemTimeUs() {
            return this.audioTimestamp.nanoTime / 1000L;
        }

        public boolean maybeUpdateTimestamp() {
            boolean z = this.audioTrack.getTimestamp(this.audioTimestamp);
            if(z) {
                long v = this.audioTimestamp.framePosition;
                if(this.lastTimestampRawPositionFrames > v) {
                    ++this.rawTimestampFramePositionWrapCount;
                }
                this.lastTimestampRawPositionFrames = v;
                this.lastTimestampPositionFrames = v + (this.rawTimestampFramePositionWrapCount << 0x20);
            }
            return z;
        }
    }

    private static final int ERROR_POLL_INTERVAL_US = 500000;
    private static final int FAST_POLL_INTERVAL_US = 10000;
    private static final int INITIALIZING_DURATION_US = 500000;
    private static final int SLOW_POLL_INTERVAL_US = 10000000;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITIALIZING = 0;
    private static final int STATE_NO_TIMESTAMP = 3;
    private static final int STATE_TIMESTAMP = 1;
    private static final int STATE_TIMESTAMP_ADVANCING = 2;
    private final AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    public AudioTimestampPoller(AudioTrack audioTrack0) {
        if(Util.SDK_INT >= 19) {
            this.audioTimestamp = new AudioTimestampV19(audioTrack0);
            this.reset();
            return;
        }
        this.audioTimestamp = null;
        this.updateState(3);
    }

    public void acceptTimestamp() {
        if(this.state == 4) {
            this.reset();
        }
    }

    public long getTimestampPositionFrames() {
        return this.audioTimestamp == null ? -1L : this.audioTimestamp.getTimestampPositionFrames();
    }

    public long getTimestampSystemTimeUs() {
        return this.audioTimestamp == null ? 0x8000000000000001L : this.audioTimestamp.getTimestampSystemTimeUs();
    }

    public boolean hasAdvancingTimestamp() {
        return this.state == 2;
    }

    public boolean hasTimestamp() {
        return this.state == 1 || this.state == 2;
    }

    public boolean maybePollTimestamp(long v) {
        AudioTimestampV19 audioTimestampPoller$AudioTimestampV190 = this.audioTimestamp;
        if(audioTimestampPoller$AudioTimestampV190 != null && v - this.lastTimestampSampleTimeUs >= this.sampleIntervalUs) {
            this.lastTimestampSampleTimeUs = v;
            boolean z = audioTimestampPoller$AudioTimestampV190.maybeUpdateTimestamp();
            int v1 = this.state;
            if(v1 == 0) {
                if(z) {
                    if(this.audioTimestamp.getTimestampSystemTimeUs() >= this.initializeSystemTimeUs) {
                        this.initialTimestampPositionFrames = this.audioTimestamp.getTimestampPositionFrames();
                        this.updateState(1);
                        return true;
                    }
                    return false;
                }
                if(v - this.initializeSystemTimeUs > 500000L) {
                    this.updateState(3);
                }
            }
            else {
                switch(v1) {
                    case 1: {
                        if(!z) {
                            this.reset();
                            return false;
                        }
                        else if(this.audioTimestamp.getTimestampPositionFrames() > this.initialTimestampPositionFrames) {
                            this.updateState(2);
                            return true;
                        }
                        break;
                    }
                    case 2: {
                        if(!z) {
                            this.reset();
                            return false;
                        }
                        break;
                    }
                    case 3: {
                        if(z) {
                            this.reset();
                            return true;
                        }
                        break;
                    }
                    default: {
                        if(v1 != 4) {
                            throw new IllegalStateException();
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public void rejectTimestamp() {
        this.updateState(4);
    }

    public void reset() {
        if(this.audioTimestamp != null) {
            this.updateState(0);
        }
    }

    private void updateState(int v) {
        this.state = v;
        switch(v) {
            case 0: {
                this.lastTimestampSampleTimeUs = 0L;
                this.initialTimestampPositionFrames = -1L;
                this.initializeSystemTimeUs = System.nanoTime() / 1000L;
                this.sampleIntervalUs = 10000L;
                return;
            }
            case 1: {
                this.sampleIntervalUs = 10000L;
                return;
            }
            case 2: 
            case 3: {
                this.sampleIntervalUs = 10000000L;
                return;
            }
            case 4: {
                this.sampleIntervalUs = 500000L;
                return;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
}

