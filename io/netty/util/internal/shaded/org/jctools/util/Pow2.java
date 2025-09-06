package io.netty.util.internal.shaded.org.jctools.util;

public final class Pow2 {
    public static final int MAX_POW2 = 0x40000000;

    public static long align(long v, int v1) {
        if(!Pow2.isPowerOfTwo(v1)) {
            throw new IllegalArgumentException("alignment must be a power of 2:" + v1);
        }
        return v + ((long)(v1 - 1)) & ((long)(~(v1 - 1)));
    }

    public static boolean isPowerOfTwo(int v) {
        return (v & v - 1) == 0;
    }

    public static int roundToPowerOfTwo(int v) {
        if(v > 0x40000000) {
            throw new IllegalArgumentException("There is no larger power of 2 int for value:" + v + " since it exceeds 2^31.");
        }
        if(v < 0) {
            throw new IllegalArgumentException("Given value:" + v + ". Expecting value >= 0.");
        }
        return 1 << 0x20 - Integer.numberOfLeadingZeros(v - 1);
    }
}

