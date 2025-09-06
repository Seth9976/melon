package io.netty.channel;

import U4.x;
import io.netty.util.internal.ObjectUtil;

public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = null;
    private static final int DEFAULT_HIGH_WATER_MARK = 0x10000;
    private static final int DEFAULT_LOW_WATER_MARK = 0x8000;
    private final int high;
    private final int low;

    static {
        WriteBufferWaterMark.DEFAULT = new WriteBufferWaterMark(0x8000, 0x10000, false);
    }

    public WriteBufferWaterMark(int v, int v1) {
        this(v, v1, true);
    }

    public WriteBufferWaterMark(int v, int v1, boolean z) {
        if(z) {
            ObjectUtil.checkPositiveOrZero(v, "low");
            if(v1 < v) {
                throw new IllegalArgumentException("write buffer\'s high water mark cannot be less than  low water mark (" + v + "): " + v1);
            }
        }
        this.low = v;
        this.high = v1;
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(55);
        stringBuilder0.append("WriteBufferWaterMark(low: ");
        stringBuilder0.append(this.low);
        stringBuilder0.append(", high: ");
        return x.g(this.high, ")", stringBuilder0);
    }
}

