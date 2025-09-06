package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    interface BandwidthProvider {
        long getAllocatedBandwidth();
    }

    static final class DefaultBandwidthProvider implements BandwidthProvider {
        private long[][] allocationCheckpoints;
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final long reservedBandwidth;

        public DefaultBandwidthProvider(BandwidthMeter bandwidthMeter0, float f, long v) {
            this.bandwidthMeter = bandwidthMeter0;
            this.bandwidthFraction = f;
            this.reservedBandwidth = v;
        }

        public void experimental_setBandwidthAllocationCheckpoints(long[][] arr2_v) {
            Assertions.checkArgument(arr2_v.length >= 2);
            this.allocationCheckpoints = arr2_v;
        }

        @Override  // com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection$BandwidthProvider
        public long getAllocatedBandwidth() {
            long[][] arr2_v;
            long v = Math.max(0L, ((long)(((float)this.bandwidthMeter.getBitrateEstimate()) * this.bandwidthFraction)) - this.reservedBandwidth);
            if(this.allocationCheckpoints == null) {
                return v;
            }
            int v1;
            for(v1 = 1; true; ++v1) {
                arr2_v = this.allocationCheckpoints;
                if(v1 >= arr2_v.length - 1 || arr2_v[v1][0] >= v) {
                    break;
                }
            }
            long[] arr_v = arr2_v[v1 - 1];
            long[] arr_v1 = arr2_v[v1];
            long v2 = arr_v[0];
            float f = ((float)(v - v2)) / ((float)(arr_v1[0] - v2));
            long v3 = arr_v[1];
            return v3 + ((long)(f * ((float)(arr_v1[1] - v3))));
        }
    }

    public static class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f, 0.75f, 2000L, Clock.DEFAULT);
        }

        public Factory(int v, int v1, int v2, float f) {
            this(v, v1, v2, f, 0.75f, 2000L, Clock.DEFAULT);
        }

        public Factory(int v, int v1, int v2, float f, float f1, long v3, Clock clock0) {
            this(null, v, v1, v2, f, f1, v3, clock0);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter0) {
            this(bandwidthMeter0, 10000, 25000, 25000, 0.7f, 0.75f, 2000L, Clock.DEFAULT);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter0, int v, int v1, int v2, float f) {
            this(bandwidthMeter0, v, v1, v2, f, 0.75f, 2000L, Clock.DEFAULT);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter0, int v, int v1, int v2, float f, float f1, long v3, Clock clock0) {
            this.bandwidthMeter = bandwidthMeter0;
            this.minDurationForQualityIncreaseMs = v;
            this.maxDurationForQualityDecreaseMs = v1;
            this.minDurationToRetainAfterDiscardMs = v2;
            this.bandwidthFraction = f;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f1;
            this.minTimeBetweenBufferReevaluationMs = v3;
            this.clock = clock0;
        }

        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup0, BandwidthMeter bandwidthMeter0, int[] arr_v, int v) {
            return new AdaptiveTrackSelection(trackGroup0, arr_v, new DefaultBandwidthProvider(bandwidthMeter0, this.bandwidthFraction, ((long)v)), ((long)this.minDurationForQualityIncreaseMs), ((long)this.maxDurationForQualityDecreaseMs), ((long)this.minDurationToRetainAfterDiscardMs), this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock, null);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection$Factory
        public final TrackSelection[] createTrackSelections(Definition[] arr_trackSelection$Definition, BandwidthMeter bandwidthMeter0) {
            BandwidthMeter bandwidthMeter1 = this.bandwidthMeter;
            if(bandwidthMeter1 != null) {
                bandwidthMeter0 = bandwidthMeter1;
            }
            TrackSelection[] arr_trackSelection = new TrackSelection[arr_trackSelection$Definition.length];
            int v2 = 0;
            for(int v1 = 0; v1 < arr_trackSelection$Definition.length; ++v1) {
                Definition trackSelection$Definition0 = arr_trackSelection$Definition[v1];
                if(trackSelection$Definition0 != null) {
                    int[] arr_v = trackSelection$Definition0.tracks;
                    if(arr_v.length == 1) {
                        arr_trackSelection[v1] = new FixedTrackSelection(trackSelection$Definition0.group, arr_v[0], trackSelection$Definition0.reason, trackSelection$Definition0.data);
                        int v3 = trackSelection$Definition0.group.getFormat(trackSelection$Definition0.tracks[0]).bitrate;
                        if(v3 != -1) {
                            v2 += v3;
                        }
                    }
                }
            }
            ArrayList arrayList0 = new ArrayList();
            for(int v4 = 0; v4 < arr_trackSelection$Definition.length; ++v4) {
                Definition trackSelection$Definition1 = arr_trackSelection$Definition[v4];
                if(trackSelection$Definition1 != null) {
                    int[] arr_v1 = trackSelection$Definition1.tracks;
                    if(arr_v1.length > 1) {
                        AdaptiveTrackSelection adaptiveTrackSelection0 = this.createAdaptiveTrackSelection(trackSelection$Definition1.group, bandwidthMeter0, arr_v1, v2);
                        arrayList0.add(adaptiveTrackSelection0);
                        arr_trackSelection[v4] = adaptiveTrackSelection0;
                    }
                }
            }
            if(arrayList0.size() > 1) {
                long[][] arr2_v = new long[arrayList0.size()][];
                for(int v5 = 0; v5 < arrayList0.size(); ++v5) {
                    AdaptiveTrackSelection adaptiveTrackSelection1 = (AdaptiveTrackSelection)arrayList0.get(v5);
                    arr2_v[v5] = new long[adaptiveTrackSelection1.length()];
                    for(int v6 = 0; v6 < adaptiveTrackSelection1.length(); ++v6) {
                        arr2_v[v5][v6] = (long)adaptiveTrackSelection1.getFormat(adaptiveTrackSelection1.length() - v6 - 1).bitrate;
                    }
                }
                long[][][] arr3_v = AdaptiveTrackSelection.getAllocationCheckpoints(arr2_v);
                for(int v = 0; v < arrayList0.size(); ++v) {
                    ((AdaptiveTrackSelection)arrayList0.get(v)).experimental_setBandwidthAllocationCheckpoints(arr3_v[v]);
                }
            }
            return arr_trackSelection;
        }
    }

    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public static final long DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 2000L;
    private final BandwidthProvider bandwidthProvider;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    private AdaptiveTrackSelection(TrackGroup trackGroup0, int[] arr_v, BandwidthProvider adaptiveTrackSelection$BandwidthProvider0, long v, long v1, long v2, float f, long v3, Clock clock0) {
        super(trackGroup0, arr_v);
        this.bandwidthProvider = adaptiveTrackSelection$BandwidthProvider0;
        this.minDurationForQualityIncreaseUs = v * 1000L;
        this.maxDurationForQualityDecreaseUs = v1 * 1000L;
        this.minDurationToRetainAfterDiscardUs = v2 * 1000L;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f;
        this.minTimeBetweenBufferReevaluationMs = v3;
        this.clock = clock0;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = 0x8000000000000001L;
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup0, int[] arr_v, BandwidthProvider adaptiveTrackSelection$BandwidthProvider0, long v, long v1, long v2, float f, long v3, Clock clock0, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.1 adaptiveTrackSelection$10) {
        this(trackGroup0, arr_v, adaptiveTrackSelection$BandwidthProvider0, v, v1, v2, f, v3, clock0);
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup0, int[] arr_v, BandwidthMeter bandwidthMeter0) {
        this(trackGroup0, arr_v, bandwidthMeter0, 0L, 10000L, 25000L, 25000L, 0.7f, 0.75f, 2000L, Clock.DEFAULT);
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup0, int[] arr_v, BandwidthMeter bandwidthMeter0, long v, long v1, long v2, long v3, float f, float f1, long v4, Clock clock0) {
        this(trackGroup0, arr_v, new DefaultBandwidthProvider(bandwidthMeter0, f, v), v1, v2, v3, f1, v4, clock0);
    }

    public boolean canSelectFormat(Format format0, int v, float f, long v1) {
        return ((long)Math.round(((float)v) * f)) <= v1;
    }

    private static int countArrayElements(double[][] arr2_f) {
        int v1 = 0;
        for(int v = 0; v < arr2_f.length; ++v) {
            v1 += arr2_f[v].length;
        }
        return v1;
    }

    private int determineIdealSelectedIndex(long v) {
        long v1 = this.bandwidthProvider.getAllocatedBandwidth();
        int v3 = 0;
        for(int v2 = 0; v2 < this.length; ++v2) {
            if(v == 0x8000000000000000L || !this.isBlacklisted(v2, v)) {
                Format format0 = this.getFormat(v2);
                if(this.canSelectFormat(format0, format0.bitrate, this.playbackSpeed, v1)) {
                    return v2;
                }
                v3 = v2;
            }
        }
        return v3;
    }

    @Override  // com.google.android.exoplayer2.trackselection.BaseTrackSelection
    public void enable() {
        this.lastBufferEvaluationMs = 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.trackselection.BaseTrackSelection
    public int evaluateQueueSize(long v, List list0) {
        long v1 = this.clock.elapsedRealtime();
        if(!this.shouldEvaluateQueueSize(v1)) {
            return list0.size();
        }
        this.lastBufferEvaluationMs = v1;
        if(list0.isEmpty()) {
            return 0;
        }
        int v3 = list0.size();
        long v4 = this.getMinDurationToRetainAfterDiscardUs();
        if(Util.getPlayoutDurationForMediaDuration(((MediaChunk)list0.get(v3 - 1)).startTimeUs - v, this.playbackSpeed) >= v4) {
            Format format0 = this.getFormat(this.determineIdealSelectedIndex(v1));
            for(int v2 = 0; v2 < v3; ++v2) {
                MediaChunk mediaChunk0 = (MediaChunk)list0.get(v2);
                if(Util.getPlayoutDurationForMediaDuration(mediaChunk0.startTimeUs - v, this.playbackSpeed) >= v4 && mediaChunk0.trackFormat.bitrate < format0.bitrate && (mediaChunk0.trackFormat.height != -1 && mediaChunk0.trackFormat.height < 720 && (mediaChunk0.trackFormat.width != -1 && mediaChunk0.trackFormat.width < 0x500 && mediaChunk0.trackFormat.height < format0.height))) {
                    return v2;
                }
            }
        }
        return v3;
    }

    public void experimental_setBandwidthAllocationCheckpoints(long[][] arr2_v) {
        ((DefaultBandwidthProvider)this.bandwidthProvider).experimental_setBandwidthAllocationCheckpoints(arr2_v);
    }

    private static long[][][] getAllocationCheckpoints(long[][] arr2_v) {
        double[][] arr2_f = AdaptiveTrackSelection.getLogArrayValues(arr2_v);
        double[][] arr2_f1 = AdaptiveTrackSelection.getSwitchPoints(arr2_f);
        int v = AdaptiveTrackSelection.countArrayElements(arr2_f1);
        int[] arr_v = new int[3];
        arr_v[2] = 2;
        arr_v[1] = v + 3;
        arr_v[0] = arr2_f.length;
        long[][][] arr3_v = (long[][][])Array.newInstance(Long.TYPE, arr_v);
        int[] arr_v1 = new int[arr2_f.length];
        AdaptiveTrackSelection.setCheckpointValues(arr3_v, 1, arr2_v, arr_v1);
        for(int v1 = 2; v1 < v + 2; ++v1) {
            double f = 1.797693E+308;
            int v3 = 0;
            for(int v2 = 0; v2 < arr2_f.length; ++v2) {
                int v4 = arr_v1[v2];
                if(v4 + 1 != arr2_f[v2].length) {
                    double f1 = arr2_f1[v2][v4];
                    if(f1 < f) {
                        v3 = v2;
                        f = f1;
                    }
                }
            }
            ++arr_v1[v3];
            AdaptiveTrackSelection.setCheckpointValues(arr3_v, v1, arr2_v, arr_v1);
        }
        for(int v5 = 0; v5 < arr3_v.length; ++v5) {
            long[][] arr2_v1 = arr3_v[v5];
            long[] arr_v2 = arr2_v1[v + 2];
            long[] arr_v3 = arr2_v1[v + 1];
            arr_v2[0] = arr_v3[0] * 2L;
            arr_v2[1] = arr_v3[1] * 2L;
        }
        return arr3_v;
    }

    private static double[][] getLogArrayValues(long[][] arr2_v) {
        double[][] arr2_f = new double[arr2_v.length][];
        for(int v = 0; v < arr2_v.length; ++v) {
            arr2_f[v] = new double[arr2_v[v].length];
            for(int v1 = 0; true; ++v1) {
                long[] arr_v = arr2_v[v];
                if(v1 >= arr_v.length) {
                    break;
                }
                double[] arr_f = arr2_f[v];
                long v2 = arr_v[v1];
                arr_f[v1] = v2 == -1L ? 0.0 : Math.log(v2);
            }
        }
        return arr2_f;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
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
        return this.reason;
    }

    private static double[][] getSwitchPoints(double[][] arr2_f) {
        double[][] arr2_f1 = new double[arr2_f.length][];
        for(int v = 0; v < arr2_f.length; ++v) {
            double[] arr_f = new double[arr2_f[v].length - 1];
            arr2_f1[v] = arr_f;
            if(arr_f.length != 0) {
                double[] arr_f1 = arr2_f[v];
                double f = arr_f1[arr_f1.length - 1] - arr_f1[0];
                for(int v1 = 0; true; ++v1) {
                    double[] arr_f2 = arr2_f[v];
                    if(v1 >= arr_f2.length - 1) {
                        break;
                    }
                    arr2_f1[v][v1] = f == 0.0 ? 1.0 : ((arr_f2[v1] + arr_f2[v1 + 1]) * 0.5 - arr_f2[0]) / f;
                }
            }
        }
        return arr2_f1;
    }

    private long minDurationForQualityIncreaseUs(long v) {
        return v == 0x8000000000000001L || v > this.minDurationForQualityIncreaseUs ? this.minDurationForQualityIncreaseUs : ((long)(((float)v) * this.bufferedFractionToLiveEdgeForQualityIncrease));
    }

    @Override  // com.google.android.exoplayer2.trackselection.BaseTrackSelection
    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    private static void setCheckpointValues(long[][][] arr3_v, int v, long[][] arr2_v, int[] arr_v) {
        long v1 = 0L;
        for(int v2 = 0; v2 < arr3_v.length; ++v2) {
            long[] arr_v1 = arr3_v[v2][v];
            long v3 = arr2_v[v2][arr_v[v2]];
            arr_v1[1] = v3;
            v1 += v3;
        }
        for(int v4 = 0; v4 < arr3_v.length; ++v4) {
            arr3_v[v4][v][0] = v1;
        }
    }

    public boolean shouldEvaluateQueueSize(long v) {
        return this.lastBufferEvaluationMs == 0x8000000000000001L || v - this.lastBufferEvaluationMs >= this.minTimeBetweenBufferReevaluationMs;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long v, long v1, long v2, List list0, MediaChunkIterator[] arr_mediaChunkIterator) {
        long v3 = this.clock.elapsedRealtime();
        if(this.reason == 0) {
            this.reason = 1;
            this.selectedIndex = this.determineIdealSelectedIndex(v3);
            return;
        }
        int v4 = this.selectedIndex;
        int v5 = this.determineIdealSelectedIndex(v3);
        this.selectedIndex = v5;
        if(v5 != v4) {
            if(!this.isBlacklisted(v4, v3)) {
                Format format0 = this.getFormat(v4);
                Format format1 = this.getFormat(this.selectedIndex);
                if(format1.bitrate > format0.bitrate && v1 < this.minDurationForQualityIncreaseUs(v2)) {
                    this.selectedIndex = v4;
                }
                else if(format1.bitrate < format0.bitrate && v1 >= this.maxDurationForQualityDecreaseUs) {
                    this.selectedIndex = v4;
                }
            }
            if(this.selectedIndex != v4) {
                this.reason = 3;
            }
        }
    }

    class com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.1 {
    }

}

