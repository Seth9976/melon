package io.netty.util.internal.logging;

import java.util.HashSet;
import java.util.Set;

public final class MessageFormatter {
    private static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    public static FormattingTuple arrayFormat(String s, Object[] arr_object) {
        Throwable throwable0 = null;
        if(arr_object != null && arr_object.length != 0) {
            int v = arr_object.length - 1;
            Object object0 = arr_object[v];
            Throwable throwable1 = object0 instanceof Throwable ? ((Throwable)object0) : null;
            if(s == null) {
                return new FormattingTuple(null, throwable1);
            }
            int v1 = s.indexOf("{}");
            if(v1 == -1) {
                return new FormattingTuple(s, throwable1);
            }
            StringBuilder stringBuilder0 = new StringBuilder(s.length() + 50);
            int v2 = 0;
            int v3 = 0;
            do {
                boolean z = v1 == 0 || s.charAt(v1 - 1) != 92;
                if(z) {
                    stringBuilder0.append(s, v2, v1);
                }
                else {
                    stringBuilder0.append(s, v2, v1 - 1);
                    z = v1 >= 2 && s.charAt(v1 - 2) == 92;
                }
                v2 = v1 + 2;
                if(z) {
                    MessageFormatter.deeplyAppendParameter(stringBuilder0, arr_object[v3], null);
                    ++v3;
                    if(v3 > v) {
                        break;
                    }
                }
                else {
                    stringBuilder0.append("{}");
                }
                v1 = s.indexOf("{}", v2);
            }
            while(v1 != -1);
            stringBuilder0.append(s, v2, s.length());
            String s1 = stringBuilder0.toString();
            if(v3 <= v) {
                throwable0 = throwable1;
            }
            return new FormattingTuple(s1, throwable0);
        }
        return new FormattingTuple(s, null);
    }

    private static void booleanArrayAppend(StringBuilder stringBuilder0, boolean[] arr_z) {
        if(arr_z.length != 0) {
            stringBuilder0.append(arr_z[0]);
            for(int v = 1; v < arr_z.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_z[v]);
            }
        }
    }

    private static void byteArrayAppend(StringBuilder stringBuilder0, byte[] arr_b) {
        if(arr_b.length != 0) {
            stringBuilder0.append(((int)arr_b[0]));
            for(int v = 1; v < arr_b.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(((int)arr_b[v]));
            }
        }
    }

    private static void charArrayAppend(StringBuilder stringBuilder0, char[] arr_c) {
        if(arr_c.length != 0) {
            stringBuilder0.append(arr_c[0]);
            for(int v = 1; v < arr_c.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_c[v]);
            }
        }
    }

    private static void deeplyAppendParameter(StringBuilder stringBuilder0, Object object0, Set set0) {
        if(object0 == null) {
            stringBuilder0.append("null");
            return;
        }
        Class class0 = object0.getClass();
        if(!class0.isArray()) {
            if(Number.class.isAssignableFrom(class0)) {
                if(class0 == Long.class) {
                    stringBuilder0.append(((long)(((Long)object0))));
                    return;
                }
                if(class0 != Integer.class && class0 != Short.class && class0 != Byte.class) {
                    if(class0 == Double.class) {
                        stringBuilder0.append(((double)(((Double)object0))));
                        return;
                    }
                    if(class0 == Float.class) {
                        stringBuilder0.append(((float)(((Float)object0))));
                        return;
                    }
                    MessageFormatter.safeObjectAppend(stringBuilder0, object0);
                    return;
                }
                stringBuilder0.append(((Number)object0).intValue());
                return;
            }
            MessageFormatter.safeObjectAppend(stringBuilder0, object0);
            return;
        }
        stringBuilder0.append('[');
        if(class0 == boolean[].class) {
            MessageFormatter.booleanArrayAppend(stringBuilder0, ((boolean[])object0));
        }
        else if(class0 == byte[].class) {
            MessageFormatter.byteArrayAppend(stringBuilder0, ((byte[])object0));
        }
        else if(class0 == char[].class) {
            MessageFormatter.charArrayAppend(stringBuilder0, ((char[])object0));
        }
        else if(class0 == short[].class) {
            MessageFormatter.shortArrayAppend(stringBuilder0, ((short[])object0));
        }
        else if(class0 == int[].class) {
            MessageFormatter.intArrayAppend(stringBuilder0, ((int[])object0));
        }
        else if(class0 == long[].class) {
            MessageFormatter.longArrayAppend(stringBuilder0, ((long[])object0));
        }
        else if(class0 == float[].class) {
            MessageFormatter.floatArrayAppend(stringBuilder0, ((float[])object0));
        }
        else if(class0 == double[].class) {
            MessageFormatter.doubleArrayAppend(stringBuilder0, ((double[])object0));
        }
        else {
            MessageFormatter.objectArrayAppend(stringBuilder0, ((Object[])object0), set0);
        }
        stringBuilder0.append(']');
    }

    private static void doubleArrayAppend(StringBuilder stringBuilder0, double[] arr_f) {
        if(arr_f.length != 0) {
            stringBuilder0.append(arr_f[0]);
            for(int v = 1; v < arr_f.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_f[v]);
            }
        }
    }

    private static void floatArrayAppend(StringBuilder stringBuilder0, float[] arr_f) {
        if(arr_f.length != 0) {
            stringBuilder0.append(arr_f[0]);
            for(int v = 1; v < arr_f.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_f[v]);
            }
        }
    }

    public static FormattingTuple format(String s, Object object0) {
        return MessageFormatter.arrayFormat(s, new Object[]{object0});
    }

    public static FormattingTuple format(String s, Object object0, Object object1) {
        return MessageFormatter.arrayFormat(s, new Object[]{object0, object1});
    }

    private static void intArrayAppend(StringBuilder stringBuilder0, int[] arr_v) {
        if(arr_v.length != 0) {
            stringBuilder0.append(arr_v[0]);
            for(int v = 1; v < arr_v.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_v[v]);
            }
        }
    }

    private static void longArrayAppend(StringBuilder stringBuilder0, long[] arr_v) {
        if(arr_v.length != 0) {
            stringBuilder0.append(arr_v[0]);
            for(int v = 1; v < arr_v.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_v[v]);
            }
        }
    }

    private static void objectArrayAppend(StringBuilder stringBuilder0, Object[] arr_object, Set set0) {
        if(arr_object.length == 0) {
            return;
        }
        if(set0 == null) {
            set0 = new HashSet(arr_object.length);
        }
        if(set0.add(arr_object)) {
            MessageFormatter.deeplyAppendParameter(stringBuilder0, arr_object[0], set0);
            for(int v = 1; v < arr_object.length; ++v) {
                stringBuilder0.append(", ");
                MessageFormatter.deeplyAppendParameter(stringBuilder0, arr_object[v], set0);
            }
            set0.remove(arr_object);
            return;
        }
        stringBuilder0.append("...");
    }

    private static void safeObjectAppend(StringBuilder stringBuilder0, Object object0) {
        try {
            stringBuilder0.append(object0.toString());
        }
        catch(Throwable throwable0) {
            System.err.println("SLF4J: Failed toString() invocation on an object of type [" + object0.getClass().getName() + ']');
            throwable0.printStackTrace();
            stringBuilder0.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuilder stringBuilder0, short[] arr_v) {
        if(arr_v.length != 0) {
            stringBuilder0.append(((int)arr_v[0]));
            for(int v = 1; v < arr_v.length; ++v) {
                stringBuilder0.append(", ");
                stringBuilder0.append(((int)arr_v[v]));
            }
        }
    }
}

