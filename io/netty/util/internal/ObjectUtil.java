package io.netty.util.internal;

import U4.x;
import java.util.Collection;
import java.util.Map;

public final class ObjectUtil {
    private static final double DOUBLE_ZERO;
    private static final float FLOAT_ZERO;
    private static final int INT_ZERO;
    private static final long LONG_ZERO;

    public static int checkInRange(int v, int v1, int v2, String s) {
        if(v < v1 || v > v2) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: " + v1 + "-" + v2 + ")");
        }
        return v;
    }

    public static long checkInRange(long v, long v1, long v2, String s) {
        if(v < v1 || v > v2) {
            throw new IllegalArgumentException(s + ": " + v + " (expected: " + v1 + "-" + v2 + ")");
        }
        return v;
    }

    public static CharSequence checkNonEmpty(CharSequence charSequence0, String s) {
        if(((CharSequence)ObjectUtil.checkNotNull(charSequence0, s)).length() == 0) {
            throw new IllegalArgumentException("Param \'" + s + "\' must not be empty");
        }
        return charSequence0;
    }

    public static String checkNonEmpty(String s, String s1) {
        if(((String)ObjectUtil.checkNotNull(s, s1)).isEmpty()) {
            throw new IllegalArgumentException("Param \'" + s1 + "\' must not be empty");
        }
        return s;
    }

    public static Collection checkNonEmpty(Collection collection0, String s) {
        if(((Collection)ObjectUtil.checkNotNull(collection0, s)).isEmpty()) {
            throw new IllegalArgumentException("Param \'" + s + "\' must not be empty");
        }
        return collection0;
    }

    public static Map checkNonEmpty(Map map0, String s) {
        if(((Map)ObjectUtil.checkNotNull(map0, s)).isEmpty()) {
            throw new IllegalArgumentException(x.k("Param \'", s, "\' must not be empty"));
        }
        return map0;
    }

    public static byte[] checkNonEmpty(byte[] arr_b, String s) {
        if(((byte[])ObjectUtil.checkNotNull(arr_b, s)).length == 0) {
            throw new IllegalArgumentException(x.k("Param \'", s, "\' must not be empty"));
        }
        return arr_b;
    }

    public static char[] checkNonEmpty(char[] arr_c, String s) {
        if(((char[])ObjectUtil.checkNotNull(arr_c, s)).length == 0) {
            throw new IllegalArgumentException("Param \'" + s + "\' must not be empty");
        }
        return arr_c;
    }

    public static Object[] checkNonEmpty(Object[] arr_object, String s) {
        if(((Object[])ObjectUtil.checkNotNull(arr_object, s)).length == 0) {
            throw new IllegalArgumentException("Param \'" + s + "\' must not be empty");
        }
        return arr_object;
    }

    public static String checkNonEmptyAfterTrim(String s, String s1) {
        return ObjectUtil.checkNonEmpty(((String)ObjectUtil.checkNotNull(s, s1)).trim(), s1);
    }

    public static Object checkNotNull(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
        return object0;
    }

    public static Object checkNotNullArrayParam(Object object0, int v, String s) {
        if(object0 == null) {
            throw new IllegalArgumentException("Array index " + v + " of parameter \'" + s + "\' must not be null");
        }
        return object0;
    }

    public static Object checkNotNullWithIAE(Object object0, String s) {
        if(object0 == null) {
            throw new IllegalArgumentException("Param \'" + s + "\' must not be null");
        }
        return object0;
    }

    public static double checkPositive(double f, String s) {
        if(f <= 0.0) {
            throw new IllegalArgumentException(s + " : " + f + " (expected: > 0)");
        }
        return f;
    }

    public static float checkPositive(float f, String s) {
        if(f <= 0.0f) {
            throw new IllegalArgumentException(s + " : " + f + " (expected: > 0)");
        }
        return f;
    }

    public static int checkPositive(int v, String s) {
        if(v <= 0) {
            throw new IllegalArgumentException(s + " : " + v + " (expected: > 0)");
        }
        return v;
    }

    public static long checkPositive(long v, String s) {
        if(v <= 0L) {
            throw new IllegalArgumentException(s + " : " + v + " (expected: > 0)");
        }
        return v;
    }

    public static double checkPositiveOrZero(double f, String s) {
        if(f < 0.0) {
            throw new IllegalArgumentException(s + " : " + f + " (expected: >= 0)");
        }
        return f;
    }

    public static float checkPositiveOrZero(float f, String s) {
        if(f < 0.0f) {
            throw new IllegalArgumentException(s + " : " + f + " (expected: >= 0)");
        }
        return f;
    }

    public static int checkPositiveOrZero(int v, String s) {
        if(v < 0) {
            throw new IllegalArgumentException(s + " : " + v + " (expected: >= 0)");
        }
        return v;
    }

    public static long checkPositiveOrZero(long v, String s) {
        if(v < 0L) {
            throw new IllegalArgumentException(s + " : " + v + " (expected: >= 0)");
        }
        return v;
    }

    public static Object[] deepCheckNotNull(String s, Object[] arr_object) {
        if(arr_object == null) {
            throw new NullPointerException(s);
        }
        for(int v = 0; v < arr_object.length; ++v) {
            if(arr_object[v] == null) {
                throw new NullPointerException(s);
            }
        }
        return arr_object;
    }

    public static int intValue(Integer integer0, int v) {
        return integer0 == null ? v : ((int)integer0);
    }

    public static long longValue(Long long0, long v) {
        return long0 == null ? v : ((long)long0);
    }
}

