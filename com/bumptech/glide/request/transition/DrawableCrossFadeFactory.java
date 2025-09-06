package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory {
    public static class Builder {
        private static final int DEFAULT_DURATION_MS = 300;
        private final int durationMillis;
        private boolean isCrossFadeEnabled;

        public Builder() {
            this(300);
        }

        public Builder(int v) {
            this.durationMillis = v;
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }

        public Builder setCrossFadeEnabled(boolean z) {
            this.isCrossFadeEnabled = z;
            return this;
        }
    }

    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public DrawableCrossFadeFactory(int v, boolean z) {
        this.duration = v;
        this.isCrossFadeEnabled = z;
    }

    @Override  // com.bumptech.glide.request.transition.TransitionFactory
    public Transition build(DataSource dataSource0, boolean z) {
        return dataSource0 == DataSource.MEMORY_CACHE ? NoTransition.get() : this.getResourceTransition();
    }

    private Transition getResourceTransition() {
        if(this.resourceTransition == null) {
            this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }
}

