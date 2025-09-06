package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.Util;

public final class FlacSeekTableSeekMap implements SeekMap {
    private final long firstFrameOffset;
    private final FlacStreamMetadata flacStreamMetadata;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata0, long v) {
        this.flacStreamMetadata = flacStreamMetadata0;
        this.firstFrameOffset = v;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.flacStreamMetadata.getDurationUs();
    }

    private SeekPoint getSeekPoint(long v, long v1) {
        return new SeekPoint(v * 1000000L / ((long)this.flacStreamMetadata.sampleRate), this.firstFrameOffset + v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        Assertions.checkNotNull(this.flacStreamMetadata.seekTable);
        long[] arr_v = this.flacStreamMetadata.seekTable.pointSampleNumbers;
        long[] arr_v1 = this.flacStreamMetadata.seekTable.pointOffsets;
        int v1 = Util.binarySearchFloor(arr_v, this.flacStreamMetadata.getSampleNumber(v), true, false);
        long v2 = 0L;
        long v3 = v1 == -1 ? 0L : arr_v[v1];
        if(v1 != -1) {
            v2 = arr_v1[v1];
        }
        SeekPoint seekPoint0 = this.getSeekPoint(v3, v2);
        return seekPoint0.timeUs == v || v1 == arr_v.length - 1 ? new SeekPoints(seekPoint0) : new SeekPoints(seekPoint0, this.getSeekPoint(arr_v[v1 + 1], arr_v1[v1 + 1]));
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}

