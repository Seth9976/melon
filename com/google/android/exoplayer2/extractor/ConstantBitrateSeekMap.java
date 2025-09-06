package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;

public class ConstantBitrateSeekMap implements SeekMap {
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFrameBytePosition;
    private final int frameSize;
    private final long inputLength;

    public ConstantBitrateSeekMap(long v, long v1, int v2, int v3) {
        this.inputLength = v;
        this.firstFrameBytePosition = v1;
        if(v3 == -1) {
            v3 = 1;
        }
        this.frameSize = v3;
        this.bitrate = v2;
        if(v == -1L) {
            this.dataSize = -1L;
            this.durationUs = 0x8000000000000001L;
            return;
        }
        this.dataSize = v - v1;
        this.durationUs = ConstantBitrateSeekMap.getTimeUsAtPosition(v, v1, v2);
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    private long getFramePositionForTimeUs(long v) {
        return this.firstFrameBytePosition + Util.constrainValue(v * ((long)this.bitrate) / 8000000L / ((long)this.frameSize) * ((long)this.frameSize), 0L, this.dataSize - ((long)this.frameSize));
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        if(this.dataSize == -1L) {
            return new SeekPoints(new SeekPoint(0L, this.firstFrameBytePosition));
        }
        long v1 = this.getFramePositionForTimeUs(v);
        long v2 = this.getTimeUsAtPosition(v1);
        SeekPoint seekPoint0 = new SeekPoint(v2, v1);
        if(v2 < v) {
            int v3 = this.frameSize;
            if(((long)v3) + v1 < this.inputLength) {
                long v4 = v1 + ((long)v3);
                return new SeekPoints(seekPoint0, new SeekPoint(this.getTimeUsAtPosition(v4), v4));
            }
        }
        return new SeekPoints(seekPoint0);
    }

    private static long getTimeUsAtPosition(long v, long v1, int v2) {
        return Math.max(0L, v - v1) * 8000000L / ((long)v2);
    }

    public long getTimeUsAtPosition(long v) {
        return ConstantBitrateSeekMap.getTimeUsAtPosition(v, this.firstFrameBytePosition, this.bitrate);
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.dataSize != -1L;
    }
}

