package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;

public interface ExoPlayer extends Player {
    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private LoadControl loadControl;
        private Looper looper;
        private final Renderer[] renderers;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;

        public Builder(Context context0, Renderer[] arr_renderer) {
            this(arr_renderer, new DefaultTrackSelector(context0), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context0), Util.getLooper(), new AnalyticsCollector(Clock.DEFAULT), true, Clock.DEFAULT);
        }

        public Builder(Renderer[] arr_renderer, TrackSelector trackSelector0, LoadControl loadControl0, BandwidthMeter bandwidthMeter0, Looper looper0, AnalyticsCollector analyticsCollector0, boolean z, Clock clock0) {
            Assertions.checkArgument(arr_renderer.length > 0);
            this.renderers = arr_renderer;
            this.trackSelector = trackSelector0;
            this.loadControl = loadControl0;
            this.bandwidthMeter = bandwidthMeter0;
            this.looper = looper0;
            this.analyticsCollector = analyticsCollector0;
            this.useLazyPreparation = z;
            this.clock = clock0;
        }

        public ExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new ExoPlayerImpl(this.renderers, this.trackSelector, this.loadControl, this.bandwidthMeter, this.clock, this.looper);
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector0) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector0;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter0) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter0;
            return this;
        }

        public Builder setClock(Clock clock0) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock0;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl0) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl0;
            return this;
        }

        public Builder setLooper(Looper looper0) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper0;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector0) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector0;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }
    }

    PlayerMessage createMessage(Target arg1);

    Looper getPlaybackLooper();

    SeekParameters getSeekParameters();

    void prepare(MediaSource arg1);

    void prepare(MediaSource arg1, boolean arg2, boolean arg3);

    void retry();

    void setForegroundMode(boolean arg1);

    void setSeekParameters(SeekParameters arg1);
}

