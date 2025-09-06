package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class XingSeeker implements Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long v, int v1, long v2) {
        this(v, v1, v2, -1L, null);
    }

    private XingSeeker(long v, int v1, long v2, long v3, long[] arr_v) {
        this.dataStartPosition = v;
        this.xingFrameSize = v1;
        this.durationUs = v2;
        this.tableOfContents = arr_v;
        this.dataSize = v3;
        this.dataEndPosition = v3 == -1L ? -1L : v + v3;
    }

    public static XingSeeker create(long v, long v1, MpegAudioHeader mpegAudioHeader0, ParsableByteArray parsableByteArray0) {
        int v2 = mpegAudioHeader0.samplesPerFrame;
        int v3 = mpegAudioHeader0.sampleRate;
        int v4 = parsableByteArray0.readInt();
        if((v4 & 1) == 1) {
            int v5 = parsableByteArray0.readUnsignedIntToInt();
            if(v5 != 0) {
                long v6 = Util.scaleLargeTimestamp(v5, ((long)v2) * 1000000L, v3);
                if((v4 & 6) != 6) {
                    return new XingSeeker(v1, mpegAudioHeader0.frameSize, v6);
                }
                long v7 = parsableByteArray0.readUnsignedInt();
                long[] arr_v = new long[100];
                for(int v8 = 0; v8 < 100; ++v8) {
                    arr_v[v8] = (long)parsableByteArray0.readUnsignedByte();
                }
                if(v != -1L) {
                    long v9 = v1 + v7;
                    if(v != v9) {
                        Log.w("XingSeeker", "XING data size mismatch: " + v + ", " + v9);
                    }
                }
                return new XingSeeker(v1, mpegAudioHeader0.frameSize, v6, v7, arr_v);
            }
        }
        return null;
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        if(!this.isSeekable()) {
            return new SeekPoints(new SeekPoint(0L, this.dataStartPosition + ((long)this.xingFrameSize)));
        }
        long v1 = Util.constrainValue(v, 0L, this.durationUs);
        double f = ((double)v1) * 100.0 / ((double)this.durationUs);
        double f1 = 0.0;
        if(Double.compare(f, 0.0) > 0) {
            if(f >= 100.0) {
                return new SeekPoints(new SeekPoint(v1, this.dataStartPosition + Util.constrainValue(Math.round(1.0 * ((double)this.dataSize)), this.xingFrameSize, this.dataSize - 1L)));
            }
            long[] arr_v = (long[])Assertions.checkNotNull(this.tableOfContents);
            double f2 = (double)arr_v[((int)f)];
            f1 = f2 + ((((int)f) == 99 ? 256.0 : ((double)arr_v[((int)f) + 1])) - f2) * (f - ((double)(((int)f))));
        }
        return new SeekPoints(new SeekPoint(v1, this.dataStartPosition + Util.constrainValue(Math.round(f1 / 256.0 * ((double)this.dataSize)), this.xingFrameSize, this.dataSize - 1L)));
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long v) {
        long v1 = v - this.dataStartPosition;
        if(this.isSeekable() && v1 > ((long)this.xingFrameSize)) {
            long[] arr_v = (long[])Assertions.checkNotNull(this.tableOfContents);
            double f = ((double)v1) * 256.0 / ((double)this.dataSize);
            int v2 = Util.binarySearchFloor(arr_v, ((long)f), true, true);
            long v3 = this.getTimeUsForTableIndex(v2);
            long v4 = arr_v[v2];
            long v5 = this.getTimeUsForTableIndex(v2 + 1);
            long v6 = v2 == 99 ? 0x100L : arr_v[v2 + 1];
            return v4 == v6 ? Math.round(0.0 * ((double)(v5 - v3))) + v3 : Math.round((f - ((double)v4)) / ((double)(v6 - v4)) * ((double)(v5 - v3))) + v3;
        }
        return 0L;
    }

    private long getTimeUsForTableIndex(int v) {
        return this.durationUs * ((long)v) / 100L;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }
}

