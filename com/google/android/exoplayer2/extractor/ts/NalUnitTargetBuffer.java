package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int v, int v1) {
        this.targetType = v;
        byte[] arr_b = new byte[v1 + 3];
        this.nalData = arr_b;
        arr_b[2] = 1;
    }

    public void appendToNalUnit(byte[] arr_b, int v, int v1) {
        if(!this.isFilling) {
            return;
        }
        int v2 = v1 - v;
        byte[] arr_b1 = this.nalData;
        int v3 = this.nalLength;
        if(arr_b1.length < v3 + v2) {
            this.nalData = Arrays.copyOf(arr_b1, (v3 + v2) * 2);
        }
        System.arraycopy(arr_b, v, this.nalData, this.nalLength, v2);
        this.nalLength += v2;
    }

    public boolean endNalUnit(int v) {
        if(!this.isFilling) {
            return false;
        }
        this.nalLength -= v;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public void startNalUnit(int v) {
        boolean z = true;
        Assertions.checkState(!this.isFilling);
        if(v != this.targetType) {
            z = false;
        }
        this.isFilling = z;
        if(z) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}

