package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] arr_v, long[] arr_v1, long v, long v1) {
        this.timesUs = arr_v;
        this.positions = arr_v1;
        this.durationUs = v;
        this.dataEndPosition = v1;
    }

    public static VbriSeeker create(long v, long v1, MpegAudioHeader mpegAudioHeader0, ParsableByteArray parsableByteArray0) {
        int v10;
        parsableByteArray0.skipBytes(10);
        int v2 = parsableByteArray0.readInt();
        if(v2 <= 0) {
            return null;
        }
        long v3 = Util.scaleLargeTimestamp(v2, ((long)(mpegAudioHeader0.sampleRate < 32000 ? 0x240 : 0x480)) * 1000000L, mpegAudioHeader0.sampleRate);
        int v4 = parsableByteArray0.readUnsignedShort();
        int v5 = parsableByteArray0.readUnsignedShort();
        int v6 = parsableByteArray0.readUnsignedShort();
        parsableByteArray0.skipBytes(2);
        long v7 = v1 + ((long)mpegAudioHeader0.frameSize);
        long[] arr_v = new long[v4];
        long[] arr_v1 = new long[v4];
        long v9 = v1;
        for(int v8 = 0; v8 < v4; ++v8) {
            arr_v[v8] = ((long)v8) * v3 / ((long)v4);
            arr_v1[v8] = Math.max(v9, v7);
            switch(v6) {
                case 1: {
                    v10 = parsableByteArray0.readUnsignedByte();
                    break;
                }
                case 2: {
                    v10 = parsableByteArray0.readUnsignedShort();
                    break;
                }
                case 3: {
                    v10 = parsableByteArray0.readUnsignedInt24();
                    break;
                }
                case 4: {
                    v10 = parsableByteArray0.readUnsignedIntToInt();
                    break;
                }
                default: {
                    return null;
                }
            }
            v9 += (long)(v10 * v5);
        }
        if(v != -1L && v != v9) {
            Log.w("VbriSeeker", "VBRI data size mismatch: " + v + ", " + v9);
        }
        return new VbriSeeker(arr_v, arr_v1, v3, v9);
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
        int v1 = Util.binarySearchFloor(this.timesUs, v, true, true);
        SeekPoint seekPoint0 = new SeekPoint(this.timesUs[v1], this.positions[v1]);
        return seekPoint0.timeUs >= v || v1 == this.timesUs.length - 1 ? new SeekPoints(seekPoint0) : new SeekPoints(seekPoint0, new SeekPoint(this.timesUs[v1 + 1], this.positions[v1 + 1]));
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long v) {
        return this.timesUs[Util.binarySearchFloor(this.positions, v, true, true)];
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}

