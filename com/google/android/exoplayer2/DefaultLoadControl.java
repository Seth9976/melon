package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public class DefaultLoadControl implements LoadControl {
    public static final class Builder {
        private DefaultAllocator allocator;
        private int backBufferDurationMs;
        private int bufferForPlaybackAfterRebufferMs;
        private int bufferForPlaybackMs;
        private boolean createDefaultLoadControlCalled;
        private int maxBufferMs;
        private int minBufferAudioMs;
        private int minBufferVideoMs;
        private boolean prioritizeTimeOverSizeThresholds;
        private boolean retainBackBufferFromKeyframe;
        private int targetBufferBytes;

        public Builder() {
            this.minBufferAudioMs = 15000;
            this.minBufferVideoMs = 50000;
            this.maxBufferMs = 50000;
            this.bufferForPlaybackMs = 2500;
            this.bufferForPlaybackAfterRebufferMs = 5000;
            this.targetBufferBytes = -1;
            this.prioritizeTimeOverSizeThresholds = true;
            this.backBufferDurationMs = 0;
            this.retainBackBufferFromKeyframe = false;
        }

        public DefaultLoadControl createDefaultLoadControl() {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.createDefaultLoadControlCalled = true;
            if(this.allocator == null) {
                this.allocator = new DefaultAllocator(true, 0x10000);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferAudioMs, this.minBufferVideoMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }

        public Builder setAllocator(DefaultAllocator defaultAllocator0) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.allocator = defaultAllocator0;
            return this;
        }

        public Builder setBackBuffer(int v, boolean z) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            DefaultLoadControl.assertGreaterOrEqual(v, 0, "backBufferDurationMs", "0");
            this.backBufferDurationMs = v;
            this.retainBackBufferFromKeyframe = z;
            return this;
        }

        public Builder setBufferDurationsMs(int v, int v1, int v2, int v3) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            DefaultLoadControl.assertGreaterOrEqual(v2, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(v3, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(v, v2, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.assertGreaterOrEqual(v, v3, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.assertGreaterOrEqual(v1, v, "maxBufferMs", "minBufferMs");
            this.minBufferAudioMs = v;
            this.minBufferVideoMs = v;
            this.maxBufferMs = v1;
            this.bufferForPlaybackMs = v2;
            this.bufferForPlaybackAfterRebufferMs = v3;
            return this;
        }

        public Builder setPrioritizeTimeOverSizeThresholds(boolean z) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.prioritizeTimeOverSizeThresholds = z;
            return this;
        }

        public Builder setTargetBufferBytes(int v) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.targetBufferBytes = v;
            return this;
        }
    }

    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 0x360000;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 0x20000;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 0x20000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 0x22C0000;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 0x20000;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 0x1F40000;
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean hasVideo;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferAudioUs;
    private final long minBufferVideoUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private final int targetBufferBytesOverwrite;
    private int targetBufferSize;

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 0x10000));
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator0) {
        this(defaultAllocator0, 15000, 50000, 50000, 2500, 5000, -1, true, 0, false);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator0, int v, int v1, int v2, int v3, int v4, int v5, boolean z, int v6, boolean z1) {
        DefaultLoadControl.assertGreaterOrEqual(v3, 0, "bufferForPlaybackMs", "0");
        DefaultLoadControl.assertGreaterOrEqual(v4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        DefaultLoadControl.assertGreaterOrEqual(v, v3, "minBufferAudioMs", "bufferForPlaybackMs");
        DefaultLoadControl.assertGreaterOrEqual(v1, v3, "minBufferVideoMs", "bufferForPlaybackMs");
        DefaultLoadControl.assertGreaterOrEqual(v, v4, "minBufferAudioMs", "bufferForPlaybackAfterRebufferMs");
        DefaultLoadControl.assertGreaterOrEqual(v1, v4, "minBufferVideoMs", "bufferForPlaybackAfterRebufferMs");
        DefaultLoadControl.assertGreaterOrEqual(v2, v, "maxBufferMs", "minBufferAudioMs");
        DefaultLoadControl.assertGreaterOrEqual(v2, v1, "maxBufferMs", "minBufferVideoMs");
        DefaultLoadControl.assertGreaterOrEqual(v6, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator0;
        this.minBufferAudioUs = C.msToUs(v);
        this.minBufferVideoUs = C.msToUs(v1);
        this.maxBufferUs = C.msToUs(v2);
        this.bufferForPlaybackUs = C.msToUs(v3);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs(v4);
        this.targetBufferBytesOverwrite = v5;
        this.prioritizeTimeOverSizeThresholds = z;
        this.backBufferDurationUs = C.msToUs(v6);
        this.retainBackBufferFromKeyframe = z1;
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator0, int v, int v1, int v2, int v3, int v4, boolean z) {
        this(defaultAllocator0, v, v, v1, v2, v3, v4, z, 0, false);
    }

    private static void assertGreaterOrEqual(int v, int v1, String s, String s1) {
        Assertions.checkArgument(v >= v1, s + " cannot be less than " + s1);
    }

    public int calculateTargetBufferSize(Renderer[] arr_renderer, TrackSelectionArray trackSelectionArray0) {
        int v1 = 0;
        for(int v = 0; v < arr_renderer.length; ++v) {
            if(trackSelectionArray0.get(v) != null) {
                v1 += DefaultLoadControl.getDefaultBufferSize(arr_renderer[v].getTrackType());
            }
        }
        return v1;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    private static int getDefaultBufferSize(int v) {
        switch(v) {
            case 0: {
                return 0x22C0000;
            }
            case 1: {
                return 0x360000;
            }
            case 2: {
                return 0x1F40000;
            }
            case 3: 
            case 4: 
            case 5: {
                return 0x20000;
            }
            case 6: {
                return 0;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean hasVideo(Renderer[] arr_renderer, TrackSelectionArray trackSelectionArray0) {
        for(int v = 0; v < arr_renderer.length; ++v) {
            if(arr_renderer[v].getTrackType() == 2 && trackSelectionArray0.get(v) != null) {
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        this.reset(false);
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        this.reset(true);
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        this.reset(true);
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] arr_renderer, TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
        this.hasVideo = DefaultLoadControl.hasVideo(arr_renderer, trackSelectionArray0);
        int v = this.targetBufferBytesOverwrite == -1 ? this.calculateTargetBufferSize(arr_renderer, trackSelectionArray0) : this.targetBufferBytesOverwrite;
        this.targetBufferSize = v;
        this.allocator.setTargetBufferSize(v);
    }

    private void reset(boolean z) {
        this.targetBufferSize = 0;
        this.isBuffering = false;
        if(z) {
            this.allocator.reset();
        }
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long v, float f) {
        boolean z = true;
        boolean z1 = this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
        long v1 = this.hasVideo ? this.minBufferVideoUs : this.minBufferAudioUs;
        if(f > 1.0f) {
            v1 = Math.min(Util.getMediaDurationForPlayoutDuration(v1, f), this.maxBufferUs);
        }
        if(v < v1) {
            if(!this.prioritizeTimeOverSizeThresholds && z1) {
                z = false;
            }
            this.isBuffering = z;
            return this.isBuffering;
        }
        if(v >= this.maxBufferUs || z1) {
            this.isBuffering = false;
        }
        return this.isBuffering;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long v, float f, boolean z) {
        long v1 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return v1 <= 0L || Util.getPlayoutDurationForMediaDuration(v, f) >= v1 || !this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
    }
}

