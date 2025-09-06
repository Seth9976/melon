package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

final class DefaultMediaClock implements MediaClock {
    public interface PlaybackParameterListener {
        void onPlaybackParametersChanged(PlaybackParameters arg1);
    }

    private boolean isUsingStandaloneClock;
    private final PlaybackParameterListener listener;
    private MediaClock rendererClock;
    private Renderer rendererClockSource;
    private final StandaloneMediaClock standaloneClock;
    private boolean standaloneClockIsStarted;

    public DefaultMediaClock(PlaybackParameterListener defaultMediaClock$PlaybackParameterListener0, Clock clock0) {
        this.listener = defaultMediaClock$PlaybackParameterListener0;
        this.standaloneClock = new StandaloneMediaClock(clock0);
        this.isUsingStandaloneClock = true;
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.rendererClock == null ? this.standaloneClock.getPlaybackParameters() : this.rendererClock.getPlaybackParameters();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        return this.isUsingStandaloneClock ? this.standaloneClock.getPositionUs() : this.rendererClock.getPositionUs();
    }

    public void onRendererDisabled(Renderer renderer0) {
        if(renderer0 == this.rendererClockSource) {
            this.rendererClock = null;
            this.rendererClockSource = null;
            this.isUsingStandaloneClock = true;
        }
    }

    public void onRendererEnabled(Renderer renderer0) {
        MediaClock mediaClock0 = renderer0.getMediaClock();
        if(mediaClock0 != null) {
            MediaClock mediaClock1 = this.rendererClock;
            if(mediaClock0 != mediaClock1) {
                if(mediaClock1 != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.rendererClock = mediaClock0;
                this.rendererClockSource = renderer0;
                mediaClock0.setPlaybackParameters(this.standaloneClock.getPlaybackParameters());
            }
        }
    }

    public void resetPosition(long v) {
        this.standaloneClock.resetPosition(v);
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        MediaClock mediaClock0 = this.rendererClock;
        if(mediaClock0 != null) {
            mediaClock0.setPlaybackParameters(playbackParameters0);
            playbackParameters0 = this.rendererClock.getPlaybackParameters();
        }
        this.standaloneClock.setPlaybackParameters(playbackParameters0);
    }

    // 去混淆评级： 低(40)
    private boolean shouldUseStandaloneClock(boolean z) {
        return this.rendererClockSource == null || this.rendererClockSource.isEnded() || !this.rendererClockSource.isReady() && (z || this.rendererClockSource.hasReadStreamToEnd());
    }

    public void start() {
        this.standaloneClockIsStarted = true;
        this.standaloneClock.start();
    }

    public void stop() {
        this.standaloneClockIsStarted = false;
        this.standaloneClock.stop();
    }

    public long syncAndGetPositionUs(boolean z) {
        this.syncClocks(z);
        return this.getPositionUs();
    }

    private void syncClocks(boolean z) {
        if(this.shouldUseStandaloneClock(z)) {
            this.isUsingStandaloneClock = true;
            if(this.standaloneClockIsStarted) {
                this.standaloneClock.start();
            }
        }
        else {
            long v = this.rendererClock.getPositionUs();
            if(this.isUsingStandaloneClock) {
                if(v < this.standaloneClock.getPositionUs()) {
                    this.standaloneClock.stop();
                    return;
                }
                this.isUsingStandaloneClock = false;
                if(this.standaloneClockIsStarted) {
                    this.standaloneClock.start();
                }
            }
            this.standaloneClock.resetPosition(v);
            PlaybackParameters playbackParameters0 = this.rendererClock.getPlaybackParameters();
            if(!playbackParameters0.equals(this.standaloneClock.getPlaybackParameters())) {
                this.standaloneClock.setPlaybackParameters(playbackParameters0);
                this.listener.onPlaybackParametersChanged(playbackParameters0);
            }
        }
    }
}

