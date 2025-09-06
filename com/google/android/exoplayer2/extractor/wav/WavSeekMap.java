package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

final class WavSeekMap implements SeekMap {
    private final long blockCount;
    private final long durationUs;
    private final long firstBlockPosition;
    private final int framesPerBlock;
    private final WavHeader wavHeader;

    public WavSeekMap(WavHeader wavHeader0, int v, long v1, long v2) {
        this.wavHeader = wavHeader0;
        this.framesPerBlock = v;
        this.firstBlockPosition = v1;
        long v3 = (v2 - v1) / ((long)wavHeader0.blockSize);
        this.blockCount = v3;
        this.durationUs = this.blockIndexToTimeUs(v3);
    }

    private long blockIndexToTimeUs(long v) {
        return Util.scaleLargeTimestamp(v * ((long)this.framesPerBlock), 1000000L, this.wavHeader.frameRateHz);
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        long v1 = Util.constrainValue(((long)this.wavHeader.frameRateHz) * v / (((long)this.framesPerBlock) * 1000000L), 0L, this.blockCount - 1L);
        long v2 = this.blockIndexToTimeUs(v1);
        SeekPoint seekPoint0 = new SeekPoint(v2, ((long)this.wavHeader.blockSize) * v1 + this.firstBlockPosition);
        return v2 >= v || v1 == this.blockCount - 1L ? new SeekPoints(seekPoint0) : new SeekPoints(seekPoint0, new SeekPoint(this.blockIndexToTimeUs(v1 + 1L), ((long)this.wavHeader.blockSize) * (v1 + 1L) + this.firstBlockPosition));
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}

