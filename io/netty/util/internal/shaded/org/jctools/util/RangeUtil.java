package io.netty.util.internal.shaded.org.jctools.util;

public final class RangeUtil {
    public static int checkGreaterThanOrEqual(int v, int v1, String s) {
        if(v < v1) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: >= " + v1 + ')');
        }
        return v;
    }

    public static int checkLessThan(int v, int v1, String s) {
        if(v >= v1) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: < " + v1 + ')');
        }
        return v;
    }

    public static int checkLessThanOrEqual(int v, long v1, String s) {
        if(((long)v) > v1) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: <= " + v1 + ')');
        }
        return v;
    }

    public static long checkPositive(long v, String s) {
        if(v <= 0L) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: > 0)");
        }
        return v;
    }

    public static int checkPositiveOrZero(int v, String s) {
        if(v < 0) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: >= 0)");
        }
        return v;
    }
}

