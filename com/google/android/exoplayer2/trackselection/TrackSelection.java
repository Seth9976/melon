package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

public interface TrackSelection {
    public static final class Definition {
        public final Object data;
        public final TrackGroup group;
        public final int reason;
        public final int[] tracks;

        public Definition(TrackGroup trackGroup0, int[] arr_v) {
            this(trackGroup0, arr_v, 0, null);
        }

        public Definition(TrackGroup trackGroup0, int[] arr_v, int v, Object object0) {
            this.group = trackGroup0;
            this.tracks = arr_v;
            this.reason = v;
            this.data = object0;
        }
    }

    public interface Factory {
        TrackSelection[] createTrackSelections(Definition[] arg1, BandwidthMeter arg2);
    }

    boolean blacklist(int arg1, long arg2);

    void disable();

    void enable();

    int evaluateQueueSize(long arg1, List arg2);

    Format getFormat(int arg1);

    int getIndexInTrackGroup(int arg1);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int arg1);

    int indexOf(Format arg1);

    int length();

    default void onDiscontinuity() {
    }

    void onPlaybackSpeed(float arg1);

    void updateSelectedTrack(long arg1, long arg2, long arg3, List arg4, MediaChunkIterator[] arg5);
}

