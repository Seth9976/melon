package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.media3.session.a0;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;
import java.util.Random;

public final class RandomTrackSelection extends BaseTrackSelection {
    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final Random random;

        public Factory() {
            this.random = new Random();
        }

        public Factory(int v) {
            this.random = new Random(((long)v));
        }

        public static TrackSelection a(Factory randomTrackSelection$Factory0, Definition trackSelection$Definition0) {
            return randomTrackSelection$Factory0.lambda$createTrackSelections$0(trackSelection$Definition0);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection$Factory
        public TrackSelection[] createTrackSelections(Definition[] arr_trackSelection$Definition, BandwidthMeter bandwidthMeter0) {
            return TrackSelectionUtil.createTrackSelectionsForDefinitions(arr_trackSelection$Definition, new a0(this, 22));
        }

        private TrackSelection lambda$createTrackSelections$0(Definition trackSelection$Definition0) {
            return new RandomTrackSelection(trackSelection$Definition0.group, trackSelection$Definition0.tracks, this.random);
        }
    }

    private final Random random;
    private int selectedIndex;

    public RandomTrackSelection(TrackGroup trackGroup0, int[] arr_v) {
        super(trackGroup0, arr_v);
        Random random0 = new Random();
        this.random = random0;
        this.selectedIndex = random0.nextInt(this.length);
    }

    public RandomTrackSelection(TrackGroup trackGroup0, int[] arr_v, long v) {
        this(trackGroup0, arr_v, new Random(v));
    }

    public RandomTrackSelection(TrackGroup trackGroup0, int[] arr_v, Random random0) {
        super(trackGroup0, arr_v);
        this.random = random0;
        this.selectedIndex = random0.nextInt(this.length);
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
        return 3;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long v, long v1, long v2, List list0, MediaChunkIterator[] arr_mediaChunkIterator) {
        long v3 = SystemClock.elapsedRealtime();
        int v6 = 0;
        for(int v5 = 0; v5 < this.length; ++v5) {
            if(!this.isBlacklisted(v5, v3)) {
                ++v6;
            }
        }
        this.selectedIndex = this.random.nextInt(v6);
        if(v6 != this.length) {
            int v7 = 0;
            for(int v4 = 0; v4 < this.length; ++v4) {
                if(!this.isBlacklisted(v4, v3)) {
                    if(this.selectedIndex == v7) {
                        this.selectedIndex = v4;
                        return;
                    }
                    ++v7;
                }
            }
        }
    }
}

