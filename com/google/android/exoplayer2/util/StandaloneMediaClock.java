package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;

public final class StandaloneMediaClock implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private PlaybackParameters playbackParameters;
    private boolean started;

    public StandaloneMediaClock(Clock clock0) {
        this.clock = clock0;
        this.playbackParameters = PlaybackParameters.DEFAULT;
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long v = this.baseUs;
        if(this.started) {
            long v1 = this.clock.elapsedRealtime() - this.baseElapsedMs;
            return this.playbackParameters.speed == 1.0f ? C.msToUs(v1) + v : this.playbackParameters.getMediaTimeUsForPlayoutTimeMs(v1) + v;
        }
        return v;
    }

    public void resetPosition(long v) {
        this.baseUs = v;
        if(this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        if(this.started) {
            this.resetPosition(this.getPositionUs());
        }
        this.playbackParameters = playbackParameters0;
    }

    public void start() {
        if(!this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
            this.started = true;
        }
    }

    public void stop() {
        if(this.started) {
            this.resetPosition(this.getPositionUs());
            this.started = false;
        }
    }
}

