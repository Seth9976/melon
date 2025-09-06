package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl.Builder;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import java.util.List;

public final class BufferSizeAdaptationBuilder {
    static final class BufferSizeAdaptiveTrackSelection extends BaseTrackSelection {
        private static final int BITRATE_BLACKLISTED = -1;
        private final BandwidthMeter bandwidthMeter;
        private final double bitrateToBufferFunctionIntercept;
        private final double bitrateToBufferFunctionSlope;
        private final Clock clock;
        private final DynamicFormatFilter dynamicFormatFilter;
        private final int[] formatBitrates;
        private final long hysteresisBufferUs;
        private boolean isInSteadyState;
        private final int maxBitrate;
        private final long maxBufferUs;
        private final int minBitrate;
        private final long minBufferUs;
        private float playbackSpeed;
        private int selectedIndex;
        private int selectionReason;
        private final float startUpBandwidthFraction;
        private final long startUpMinBufferForQualityIncreaseUs;

        private BufferSizeAdaptiveTrackSelection(TrackGroup trackGroup0, int[] arr_v, BandwidthMeter bandwidthMeter0, int v, int v1, int v2, float f, int v3, DynamicFormatFilter bufferSizeAdaptationBuilder$DynamicFormatFilter0, Clock clock0) {
            super(trackGroup0, arr_v);
            this.bandwidthMeter = bandwidthMeter0;
            long v4 = C.msToUs(v);
            this.minBufferUs = v4;
            long v5 = C.msToUs(v1);
            this.maxBufferUs = v5;
            long v6 = C.msToUs(v2);
            this.hysteresisBufferUs = v6;
            this.startUpBandwidthFraction = f;
            this.startUpMinBufferForQualityIncreaseUs = C.msToUs(v3);
            this.dynamicFormatFilter = bufferSizeAdaptationBuilder$DynamicFormatFilter0;
            this.clock = clock0;
            this.formatBitrates = new int[this.length];
            Format format0 = this.getFormat(0);
            this.maxBitrate = format0.bitrate;
            Format format1 = this.getFormat(this.length - 1);
            this.minBitrate = format1.bitrate;
            this.selectionReason = 0;
            this.playbackSpeed = 1.0f;
            double f1 = ((double)(v5 - v6 - v4)) / Math.log(((double)format0.bitrate) / ((double)format1.bitrate));
            this.bitrateToBufferFunctionSlope = f1;
            this.bitrateToBufferFunctionIntercept = ((double)v4) - Math.log(format1.bitrate) * f1;
        }

        public BufferSizeAdaptiveTrackSelection(TrackGroup trackGroup0, int[] arr_v, BandwidthMeter bandwidthMeter0, int v, int v1, int v2, float f, int v3, DynamicFormatFilter bufferSizeAdaptationBuilder$DynamicFormatFilter0, Clock clock0, com.google.android.exoplayer2.trackselection.BufferSizeAdaptationBuilder.1 bufferSizeAdaptationBuilder$10) {
            this(trackGroup0, arr_v, bandwidthMeter0, v, v1, v2, f, v3, bufferSizeAdaptationBuilder$DynamicFormatFilter0, clock0);
        }

        private static long getCurrentPeriodBufferedDurationUs(long v, long v1) {
            return v < 0L ? v + v1 : v1;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return this.selectionReason;
        }

        private long getTargetBufferForBitrateUs(int v) {
            if(v <= this.minBitrate) {
                return this.minBufferUs;
            }
            return v < this.maxBitrate ? ((long)(((int)(Math.log(v) * this.bitrateToBufferFunctionSlope + this.bitrateToBufferFunctionIntercept)))) : this.maxBufferUs - this.hysteresisBufferUs;
        }

        private boolean isOutsideHysteresis(long v) {
            int v1 = this.formatBitrates[this.selectedIndex];
            return v1 == -1 ? true : Math.abs(v - this.getTargetBufferForBitrateUs(v1)) > this.hysteresisBufferUs;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public void onDiscontinuity() {
            this.isInSteadyState = false;
        }

        @Override  // com.google.android.exoplayer2.trackselection.BaseTrackSelection
        public void onPlaybackSpeed(float f) {
            this.playbackSpeed = f;
        }

        private int selectIdealIndexUsingBandwidth(boolean z) {
            long v = (long)(((float)this.bandwidthMeter.getBitrateEstimate()) * this.startUpBandwidthFraction);
            int v2 = 0;
            for(int v1 = 0; true; ++v1) {
                int[] arr_v = this.formatBitrates;
                if(v1 >= arr_v.length) {
                    break;
                }
                int v3 = arr_v[v1];
                if(v3 != -1) {
                    if(((long)Math.round(((float)v3) * this.playbackSpeed)) <= v) {
                        Format format0 = this.getFormat(v1);
                        if(this.dynamicFormatFilter.isFormatAllowed(format0, this.formatBitrates[v1], z)) {
                            return v1;
                        }
                    }
                    v2 = v1;
                }
            }
            return v2;
        }

        private int selectIdealIndexUsingBufferSize(long v) {
            int v2 = 0;
            for(int v1 = 0; true; ++v1) {
                int[] arr_v = this.formatBitrates;
                if(v1 >= arr_v.length) {
                    break;
                }
                int v3 = arr_v[v1];
                if(v3 != -1) {
                    if(this.getTargetBufferForBitrateUs(v3) <= v) {
                        Format format0 = this.getFormat(v1);
                        if(this.dynamicFormatFilter.isFormatAllowed(format0, this.formatBitrates[v1], false)) {
                            return v1;
                        }
                    }
                    v2 = v1;
                }
            }
            return v2;
        }

        private void selectIndexStartUpPhase(long v) {
            int v1 = this.selectIdealIndexUsingBandwidth(false);
            int v2 = this.selectIdealIndexUsingBufferSize(v);
            int v3 = this.selectedIndex;
            if(v2 <= v3) {
                this.selectedIndex = v2;
                this.isInSteadyState = true;
                return;
            }
            if(v < this.startUpMinBufferForQualityIncreaseUs && v1 < v3 && this.formatBitrates[v3] != -1) {
                return;
            }
            this.selectedIndex = v1;
        }

        private void selectIndexSteadyState(long v) {
            if(this.isOutsideHysteresis(v)) {
                this.selectedIndex = this.selectIdealIndexUsingBufferSize(v);
            }
        }

        private void updateFormatBitrates(long v) {
            for(int v1 = 0; v1 < this.length; ++v1) {
                this.formatBitrates[v1] = v == 0x8000000000000000L || !this.isBlacklisted(v1, v) ? this.getFormat(v1).bitrate : -1;
            }
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long v, long v1, long v2, List list0, MediaChunkIterator[] arr_mediaChunkIterator) {
            this.updateFormatBitrates(this.clock.elapsedRealtime());
            if(this.selectionReason == 0) {
                this.selectionReason = 1;
                this.selectedIndex = this.selectIdealIndexUsingBandwidth(true);
                return;
            }
            long v3 = BufferSizeAdaptiveTrackSelection.getCurrentPeriodBufferedDurationUs(v, v1);
            int v4 = this.selectedIndex;
            if(this.isInSteadyState) {
                this.selectIndexSteadyState(v3);
            }
            else {
                this.selectIndexStartUpPhase(v3);
            }
            if(this.selectedIndex != v4) {
                this.selectionReason = 3;
            }
        }
    }

    public interface DynamicFormatFilter {
        public static final DynamicFormatFilter NO_FILTER;

        static {
            DynamicFormatFilter.NO_FILTER = new b(28);
        }

        static boolean a(Format format0, int v, boolean z) {
            return true;
        }

        boolean isFormatAllowed(Format arg1, int arg2, boolean arg3);

        private static boolean lambda$static$0(Format format0, int v, boolean z) [...] // Inlined contents
    }

    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_HYSTERESIS_BUFFER_MS = 5000;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final float DEFAULT_START_UP_BANDWIDTH_FRACTION = 0.7f;
    public static final int DEFAULT_START_UP_MIN_BUFFER_FOR_QUALITY_INCREASE_MS = 10000;
    private DefaultAllocator allocator;
    private int bufferForPlaybackAfterRebufferMs;
    private int bufferForPlaybackMs;
    private boolean buildCalled;
    private Clock clock;
    private DynamicFormatFilter dynamicFormatFilter;
    private int hysteresisBufferMs;
    private int maxBufferMs;
    private int minBufferMs;
    private float startUpBandwidthFraction;
    private int startUpMinBufferForQualityIncreaseMs;

    public BufferSizeAdaptationBuilder() {
        this.clock = Clock.DEFAULT;
        this.minBufferMs = 15000;
        this.maxBufferMs = 50000;
        this.bufferForPlaybackMs = 2500;
        this.bufferForPlaybackAfterRebufferMs = 5000;
        this.hysteresisBufferMs = 5000;
        this.startUpBandwidthFraction = 0.7f;
        this.startUpMinBufferForQualityIncreaseMs = 10000;
        this.dynamicFormatFilter = DynamicFormatFilter.NO_FILTER;
    }

    public Pair buildPlayerComponents() {
        Assertions.checkArgument(this.hysteresisBufferMs < this.maxBufferMs - this.minBufferMs);
        Assertions.checkState(!this.buildCalled);
        this.buildCalled = true;
        Builder defaultLoadControl$Builder0 = new Builder().setTargetBufferBytes(0x7FFFFFFF).setBufferDurationsMs(this.maxBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs);
        DefaultAllocator defaultAllocator0 = this.allocator;
        if(defaultAllocator0 != null) {
            defaultLoadControl$Builder0.setAllocator(defaultAllocator0);
        }
        return Pair.create(new Factory() {
            @Override  // com.google.android.exoplayer2.trackselection.TrackSelection$Factory
            public TrackSelection[] createTrackSelections(Definition[] arr_trackSelection$Definition, BandwidthMeter bandwidthMeter0) {
                return TrackSelectionUtil.createTrackSelectionsForDefinitions(arr_trackSelection$Definition, new a(this, bandwidthMeter0));
            }

            private TrackSelection lambda$createTrackSelections$0(BandwidthMeter bandwidthMeter0, Definition trackSelection$Definition0) {
                return new BufferSizeAdaptiveTrackSelection(trackSelection$Definition0.group, trackSelection$Definition0.tracks, bandwidthMeter0, BufferSizeAdaptationBuilder.this.minBufferMs, BufferSizeAdaptationBuilder.this.maxBufferMs, BufferSizeAdaptationBuilder.this.hysteresisBufferMs, BufferSizeAdaptationBuilder.this.startUpBandwidthFraction, BufferSizeAdaptationBuilder.this.startUpMinBufferForQualityIncreaseMs, BufferSizeAdaptationBuilder.this.dynamicFormatFilter, BufferSizeAdaptationBuilder.this.clock, null);
            }
        }, defaultLoadControl$Builder0.createDefaultLoadControl());
    }

    public BufferSizeAdaptationBuilder setAllocator(DefaultAllocator defaultAllocator0) {
        Assertions.checkState(!this.buildCalled);
        this.allocator = defaultAllocator0;
        return this;
    }

    public BufferSizeAdaptationBuilder setBufferDurationsMs(int v, int v1, int v2, int v3) {
        Assertions.checkState(!this.buildCalled);
        this.minBufferMs = v;
        this.maxBufferMs = v1;
        this.bufferForPlaybackMs = v2;
        this.bufferForPlaybackAfterRebufferMs = v3;
        return this;
    }

    public BufferSizeAdaptationBuilder setClock(Clock clock0) {
        Assertions.checkState(!this.buildCalled);
        this.clock = clock0;
        return this;
    }

    public BufferSizeAdaptationBuilder setDynamicFormatFilter(DynamicFormatFilter bufferSizeAdaptationBuilder$DynamicFormatFilter0) {
        Assertions.checkState(!this.buildCalled);
        this.dynamicFormatFilter = bufferSizeAdaptationBuilder$DynamicFormatFilter0;
        return this;
    }

    public BufferSizeAdaptationBuilder setHysteresisBufferMs(int v) {
        Assertions.checkState(!this.buildCalled);
        this.hysteresisBufferMs = v;
        return this;
    }

    public BufferSizeAdaptationBuilder setStartUpTrackSelectionParameters(float f, int v) {
        Assertions.checkState(!this.buildCalled);
        this.startUpBandwidthFraction = f;
        this.startUpMinBufferForQualityIncreaseMs = v;
        return this;
    }
}

