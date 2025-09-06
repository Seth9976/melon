package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;
    public final Track track;

    public TrackSampleTable(Track track0, long[] arr_v, int[] arr_v1, int v, long[] arr_v2, int[] arr_v3, long v1) {
        boolean z = false;
        Assertions.checkArgument(arr_v1.length == arr_v2.length);
        Assertions.checkArgument(arr_v.length == arr_v2.length);
        if(arr_v3.length == arr_v2.length) {
            z = true;
        }
        Assertions.checkArgument(z);
        this.track = track0;
        this.offsets = arr_v;
        this.sizes = arr_v1;
        this.maximumSize = v;
        this.timestampsUs = arr_v2;
        this.flags = arr_v3;
        this.durationUs = v1;
        this.sampleCount = arr_v.length;
        if(arr_v3.length > 0) {
            arr_v3[arr_v3.length - 1] |= 0x20000000;
        }
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long v) {
        for(int v1 = Util.binarySearchFloor(this.timestampsUs, v, true, false); v1 >= 0; --v1) {
            if((this.flags[v1] & 1) != 0) {
                return v1;
            }
        }
        return -1;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long v) {
        for(int v1 = Util.binarySearchCeil(this.timestampsUs, v, true, false); v1 < this.timestampsUs.length; ++v1) {
            if((this.flags[v1] & 1) != 0) {
                return v1;
            }
        }
        return -1;
    }
}

