package com.google.android.exoplayer2.trackselection;

import androidx.media3.session.a0;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

public final class FixedTrackSelection extends BaseTrackSelection {
    @Deprecated
    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final Object data;
        private final int reason;

        public Factory() {
            this.reason = 0;
            this.data = null;
        }

        public Factory(int v, Object object0) {
            this.reason = v;
            this.data = object0;
        }

        public static TrackSelection a(Factory fixedTrackSelection$Factory0, Definition trackSelection$Definition0) {
            return fixedTrackSelection$Factory0.lambda$createTrackSelections$0(trackSelection$Definition0);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection$Factory
        public TrackSelection[] createTrackSelections(Definition[] arr_trackSelection$Definition, BandwidthMeter bandwidthMeter0) {
            return TrackSelectionUtil.createTrackSelectionsForDefinitions(arr_trackSelection$Definition, new a0(this, 21));
        }

        private TrackSelection lambda$createTrackSelections$0(Definition trackSelection$Definition0) {
            return new FixedTrackSelection(trackSelection$Definition0.group, trackSelection$Definition0.tracks[0], this.reason, this.data);
        }
    }

    private final Object data;
    private final int reason;

    public FixedTrackSelection(TrackGroup trackGroup0, int v) {
        this(trackGroup0, v, 0, null);
    }

    public FixedTrackSelection(TrackGroup trackGroup0, int v, int v1, Object object0) {
        super(trackGroup0, new int[]{v});
        this.reason = v1;
        this.data = object0;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        return this.data;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long v, long v1, long v2, List list0, MediaChunkIterator[] arr_mediaChunkIterator) {
    }
}

