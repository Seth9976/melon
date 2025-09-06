package com.google.android.exoplayer2.extractor;

import A7.d;
import b3.Z;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import k8.Y;

public final class ChunkIndex implements SeekMap {
    private final long durationUs;
    public final long[] durationsUs;
    public final int length;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timesUs;

    public ChunkIndex(int[] arr_v, long[] arr_v1, long[] arr_v2, long[] arr_v3) {
        this.sizes = arr_v;
        this.offsets = arr_v1;
        this.durationsUs = arr_v2;
        this.timesUs = arr_v3;
        this.length = arr_v.length;
        if(arr_v.length > 0) {
            this.durationUs = arr_v2[arr_v.length - 1] + arr_v3[arr_v.length - 1];
            return;
        }
        this.durationUs = 0L;
    }

    public int getChunkIndex(long v) {
        return Util.binarySearchFloor(this.timesUs, v, true, true);
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        int v1 = this.getChunkIndex(v);
        SeekPoint seekPoint0 = new SeekPoint(this.timesUs[v1], this.offsets[v1]);
        return seekPoint0.timeUs >= v || v1 == this.length - 1 ? new SeekPoints(seekPoint0) : new SeekPoints(seekPoint0, new SeekPoint(this.timesUs[v1 + 1], this.offsets[v1 + 1]));
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override
    public String toString() {
        String s = Arrays.toString(this.sizes);
        String s1 = Arrays.toString(this.offsets);
        String s2 = Arrays.toString(this.timesUs);
        String s3 = Arrays.toString(this.durationsUs);
        StringBuilder stringBuilder0 = new StringBuilder(Z.e(Z.e(Z.e(Z.e(71, s), s1), s2), s3));
        stringBuilder0.append("ChunkIndex(length=");
        stringBuilder0.append(this.length);
        stringBuilder0.append(", sizes=");
        stringBuilder0.append(s);
        d.u(stringBuilder0, ", offsets=", s1, ", timeUs=", s2);
        return Y.l(stringBuilder0, ", durationsUs=", s3, ")");
    }
}

