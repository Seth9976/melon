package io.netty.util.internal;

public final class MathUtil {
    static final boolean $assertionsDisabled;

    public static int compare(int v, int v1) {
        if(v < v1) {
            return -1;
        }
        return v <= v1 ? 0 : 1;
    }

    public static int compare(long v, long v1) {
        int v2 = Long.compare(v, v1);
        if(v2 < 0) {
            return -1;
        }
        return v2 <= 0 ? 0 : 1;
    }

    public static int findNextPositivePowerOfTwo(int v) {
        return 1 << 0x20 - Integer.numberOfLeadingZeros(v - 1);
    }

    public static boolean isOutOfBounds(int v, int v1, int v2) {
        return (v | v1 | v2 | v + v1 | v2 - (v + v1)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int v) {
        if(v <= 0) {
            return 1;
        }
        return v < 0x40000000 ? MathUtil.findNextPositivePowerOfTwo(v) : 0x40000000;
    }
}

