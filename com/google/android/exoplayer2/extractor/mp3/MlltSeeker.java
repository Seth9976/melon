package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

final class MlltSeeker implements Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    private MlltSeeker(long[] arr_v, long[] arr_v1) {
        this.referencePositions = arr_v;
        this.referenceTimesMs = arr_v1;
        this.durationUs = C.msToUs(arr_v1[arr_v1.length - 1]);
    }

    public static MlltSeeker create(long v, MlltFrame mlltFrame0) {
        int v1 = mlltFrame0.bytesDeviations.length + 1;
        long[] arr_v = new long[v1];
        long[] arr_v1 = new long[v1];
        arr_v[0] = v;
        long v2 = 0L;
        arr_v1[0] = 0L;
        for(int v3 = 1; v3 <= mlltFrame0.bytesDeviations.length; ++v3) {
            v += (long)(mlltFrame0.bytesBetweenReference + mlltFrame0.bytesDeviations[v3 - 1]);
            v2 += (long)(mlltFrame0.millisecondsBetweenReference + mlltFrame0.millisecondsDeviations[v3 - 1]);
            arr_v[v3] = v;
            arr_v1[v3] = v2;
        }
        return new MlltSeeker(arr_v, arr_v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        Pair pair0 = MlltSeeker.linearlyInterpolate(C.usToMs(Util.constrainValue(v, 0L, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new SeekPoints(new SeekPoint(C.msToUs(((long)(((Long)pair0.first)))), ((long)(((Long)pair0.second)))));
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long v) {
        return C.msToUs(((long)(((Long)MlltSeeker.linearlyInterpolate(v, this.referencePositions, this.referenceTimesMs).second))));
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    private static Pair linearlyInterpolate(long v, long[] arr_v, long[] arr_v1) {
        int v1 = Util.binarySearchFloor(arr_v, v, true, true);
        long v2 = arr_v[v1];
        long v3 = arr_v1[v1];
        if(v1 + 1 == arr_v.length) {
            return Pair.create(v2, v3);
        }
        long v4 = arr_v[v1 + 1];
        long v5 = arr_v1[v1 + 1];
        return v4 == v2 ? Pair.create(v, ((long)(((long)(0.0 * ((double)(v5 - v3)))) + v3))) : Pair.create(v, ((long)(((long)((((double)v) - ((double)v2)) / ((double)(v4 - v2)) * ((double)(v5 - v3)))) + v3)));
    }
}

