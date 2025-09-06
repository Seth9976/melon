package Tf;

import h7.u0;
import je.c;
import je.f;
import kotlin.jvm.internal.q;

public abstract class v extends u {
    public static String h0(char[] arr_c, int v, int v1) {
        f.Companion.getClass();
        c.a(v, v1, arr_c.length);
        return new String(arr_c, v, v1 - v);
    }

    public static boolean i0(String s, String s1, boolean z) {
        q.g(s, "<this>");
        q.g(s1, "suffix");
        return z ? v.m0(s.length() - s1.length(), 0, s1.length(), s, s1, true) : s.endsWith(s1);
    }

    public static boolean j0(String s, String s1, boolean z) {
        if(s == null) {
            return s1 == null;
        }
        return z ? s.equalsIgnoreCase(s1) : s.equals(s1);
    }

    public static void k0() {
        q.f(String.CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
    }

    public static final void l0(String s) {
        throw new NumberFormatException("Invalid number format: \'" + s + '\'');
    }

    public static boolean m0(int v, int v1, int v2, String s, String s1, boolean z) {
        q.g(s, "<this>");
        q.g(s1, "other");
        return z ? s.regionMatches(true, v, s1, v1, v2) : s.regionMatches(v, s1, v1, v2);
    }

    public static String n0(int v, String s) {
        q.g(s, "<this>");
        if(v >= 0) {
            switch(v) {
                case 0: {
                    return "";
                label_17:
                    char c = s.charAt(0);
                    char[] arr_c = new char[v];
                    for(int v2 = 0; v2 < v; ++v2) {
                        arr_c[v2] = c;
                    }
                    return new String(arr_c);
                }
                case 1: {
                    return s.toString();
                label_6:
                    switch(s.length()) {
                        case 0: {
                            return "";
                        }
                        case 1: {
                            goto label_17;
                        }
                        default: {
                            StringBuilder stringBuilder0 = new StringBuilder(s.length() * v);
                            if(1 <= v) {
                                for(int v1 = 1; true; ++v1) {
                                    stringBuilder0.append(s);
                                    if(v1 == v) {
                                        break;
                                    }
                                }
                            }
                            String s1 = stringBuilder0.toString();
                            q.d(s1);
                            return s1;
                        }
                    }
                }
                default: {
                    goto label_6;
                }
            }
        }
        throw new IllegalArgumentException(("Count \'n\' must be non-negative, but was " + v + '.').toString());
    }

    public static String o0(String s, char c, char c1) [...] // 潜在的解密器

    public static String p0(String s, String s1, String s2) [...] // 潜在的解密器

    public static boolean q0(int v, String s, String s1, boolean z) {
        q.g(s, "<this>");
        return z ? v.m0(v, 0, s1.length(), s, s1, true) : s.startsWith(s1, v);
    }

    public static boolean r0(String s, String s1, boolean z) {
        q.g(s, "<this>");
        q.g(s1, "prefix");
        return z ? v.m0(0, 0, s1.length(), s, s1, true) : s.startsWith(s1);
    }

    public static Integer s0(int v, String s) {
        int v6;
        boolean z;
        q.g(s, "<this>");
        u0.l(v);
        int v1 = s.length();
        if(v1 != 0) {
            int v2 = 1;
            int v3 = 0;
            int v4 = s.charAt(0);
            int v5 = 0x80000001;
            if(q.h(v4, 0x30) >= 0) {
                z = false;
                v2 = 0;
                v6 = 0xFC71C71D;
            label_21:
                while(v2 < v1) {
                    int v7 = Character.digit(s.charAt(v2), v);
                    if(v7 < 0) {
                        return null;
                    }
                    if(v3 < v6) {
                        if(v6 != 0xFC71C71D) {
                            return null;
                        }
                        v6 = v5 / v;
                        if(v3 >= v6) {
                            goto label_28;
                        }
                        return null;
                    }
                label_28:
                    int v8 = v3 * v;
                    if(v8 < v5 + v7) {
                        return null;
                    }
                    v3 = v8 - v7;
                    ++v2;
                }
                return z ? v3 : ((int)(-v3));
            }
            else if(v1 != 1) {
                switch(v4) {
                    case 43: {
                        z = false;
                        break;
                    }
                    case 45: {
                        v5 = 0x80000000;
                        z = true;
                        break;
                    }
                    default: {
                        return null;
                    }
                }
                v6 = 0xFC71C71D;
                goto label_21;
            }
        }
        return null;
    }

    public static Integer t0(String s) {
        q.g(s, "<this>");
        return v.s0(10, s);
    }

    public static Long u0(String s) {
        long v5;
        long v4;
        q.g(s, "<this>");
        u0.l(10);
        int v = s.length();
        if(v != 0) {
            boolean z = true;
            int v1 = 0;
            int v2 = s.charAt(0);
            long v3 = 0x8000000000000001L;
            if(q.h(v2, 0x30) >= 0) {
                z = false;
                v4 = 0L;
                v5 = -256204778801521550L;
            label_23:
                while(v1 < v) {
                    int v6 = Character.digit(s.charAt(v1), 10);
                    if(v6 < 0) {
                        return null;
                    }
                    if(v4 < v5) {
                        if(v5 != -256204778801521550L) {
                            return null;
                        }
                        v5 = v3 / 10L;
                        if(v4 >= v5) {
                            goto label_30;
                        }
                        return null;
                    }
                label_30:
                    if(v4 * 10L < v3 + ((long)v6)) {
                        return null;
                    }
                    v4 = v4 * 10L - ((long)v6);
                    ++v1;
                }
                return z ? v4 : ((long)(-v4));
            }
            else if(v != 1) {
                switch(v2) {
                    case 43: {
                        z = false;
                        v1 = 1;
                        break;
                    }
                    case 45: {
                        v3 = 0x8000000000000000L;
                        v1 = 1;
                        break;
                    }
                    default: {
                        return null;
                    }
                }
                v4 = 0L;
                v5 = -256204778801521550L;
                goto label_23;
            }
        }
        return null;
    }
}

