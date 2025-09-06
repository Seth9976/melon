package com.google.protobuf;

import b3.Z;
import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class h {
    public abstract int A(String arg1, byte[] arg2, int arg3, int arg4);

    public static String B(o o0) {
        StringBuilder stringBuilder0 = new StringBuilder(o0.size());
        for(int v = 0; v < o0.size(); ++v) {
            int v1 = o0.a(v);
            switch(v1) {
                case 7: {
                    stringBuilder0.append("\\a");
                    break;
                }
                case 8: {
                    stringBuilder0.append("\\b");
                    break;
                }
                case 9: {
                    stringBuilder0.append("\\t");
                    break;
                }
                case 10: {
                    stringBuilder0.append("\\n");
                    break;
                }
                case 11: {
                    stringBuilder0.append("\\v");
                    break;
                }
                case 12: {
                    stringBuilder0.append("\\f");
                    break;
                }
                case 13: {
                    stringBuilder0.append("\\r");
                    break;
                }
                case 34: {
                    stringBuilder0.append("\\\"");
                    break;
                }
                case 39: {
                    stringBuilder0.append("\\\'");
                    break;
                }
                case 92: {
                    stringBuilder0.append("\\\\");
                    break;
                }
                default: {
                    if(v1 < 0x20 || v1 > 0x7E) {
                        stringBuilder0.append('\\');
                        stringBuilder0.append(((char)((v1 >>> 6 & 3) + 0x30)));
                        stringBuilder0.append(((char)((v1 >>> 3 & 7) + 0x30)));
                        stringBuilder0.append(((char)((v1 & 7) + 0x30)));
                    }
                    else {
                        stringBuilder0.append(((char)v1));
                    }
                }
            }
        }
        return stringBuilder0.toString();
    }

    public static boolean C(byte b) {
        return b > -65;
    }

    public static int D(Object object0, E2 e20, byte[] arr_b, int v, int v1, int v2, g g0) {
        int v3 = g0.e + 1;
        g0.e = v3;
        if(v3 >= 100) {
            throw new R1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v4 = ((o2)e20).G(object0, arr_b, v, v1, v2, g0);
        --g0.e;
        g0.c = object0;
        return v4;
    }

    public static int E(Object object0, E2 e20, byte[] arr_b, int v, int v1, g g0) {
        int v2 = v + 1;
        int v3 = arr_b[v];
        if(v3 < 0) {
            v2 = h.w(v3, arr_b, v2, g0);
            v3 = g0.a;
        }
        if(v3 < 0 || v3 > v1 - v2) {
            throw R1.h();
        }
        int v4 = g0.e + 1;
        g0.e = v4;
        if(v4 >= 100) {
            throw new R1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v5 = v2 + v3;
        e20.g(object0, arr_b, v2, v5, g0);
        --g0.e;
        g0.c = object0;
        return v5;
    }

    public abstract int F(byte[] arg1, int arg2, int arg3);

    public static Object G(t t0, j3 j30, int v) {
        switch(j30.ordinal()) {
            case 0: {
                return t0.n();
            }
            case 1: {
                return t0.r();
            }
            case 2: {
                return t0.u();
            }
            case 3: {
                return t0.G();
            }
            case 4: {
                return t0.t();
            }
            case 5: {
                return t0.q();
            }
            case 6: {
                return t0.p();
            }
            case 7: {
                return Boolean.valueOf(t0.l());
            }
            case 8: {
                switch(v) {
                    case 1: {
                        return t0.C();
                    }
                    case 2: {
                        return t0.D();
                    }
                    default: {
                        return t0.m();
                    }
                }
            }
            case 9: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            }
            case 10: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            }
            case 11: {
                return t0.m();
            }
            case 12: {
                return t0.F();
            }
            case 13: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            }
            case 14: {
                return t0.y();
            }
            case 15: {
                return t0.z();
            }
            case 16: {
                return t0.A();
            }
            case 17: {
                return t0.B();
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    public static int H(int v, byte[] arr_b, int v1, int v2, g g0) {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    return h.z(arr_b, v1, g0);
                }
                case 1: {
                    return v1 + 8;
                }
                case 2: {
                    return h.x(arr_b, v1, g0) + g0.a;
                }
                case 3: {
                    int v3 = v & -8 | 4;
                    int v4 = 0;
                    while(v1 < v2) {
                        v1 = h.x(arr_b, v1, g0);
                        v4 = g0.a;
                        if(v4 == v3) {
                            break;
                        }
                        v1 = h.H(v4, arr_b, v1, v2, g0);
                    }
                    if(v1 > v2 || v4 != v3) {
                        throw R1.g();
                    }
                    return v1;
                }
                case 5: {
                    return v1 + 4;
                }
                default: {
                    throw R1.b();
                }
            }
        }
        throw R1.b();
    }

    public abstract void I(byte[] arg1, int arg2, int arg3);

    public static void a(byte b, byte b1, byte b2, byte b3, char[] arr_c, int v) {
        if(h.C(b1) || b1 + 0x70 + (b << 28) >> 30 != 0 || h.C(b2) || h.C(b3)) {
            throw R1.c();
        }
        int v1 = (b & 7) << 18 | (b1 & 0x3F) << 12 | (b2 & 0x3F) << 6 | b3 & 0x3F;
        arr_c[v] = (char)((v1 >>> 10) + 0xD7C0);
        arr_c[v + 1] = (char)((v1 & 0x3FF) + 0xDC00);
    }

    public static void b(byte b, byte b1, char[] arr_c, int v) {
        if(b < -62 || h.C(b1)) {
            throw R1.c();
        }
        arr_c[v] = (char)((b & 0x1F) << 6 | b1 & 0x3F);
    }

    public static void c(byte b, byte b1, byte b2, char[] arr_c, int v) {
        if(h.C(b1) || b == 0xFFFFFFE0 && b1 < 0xFFFFFFA0 || b == -19 && b1 >= 0xFFFFFFA0 || h.C(b2)) {
            throw R1.c();
        }
        arr_c[v] = (char)((b & 15) << 12 | (b1 & 0x3F) << 6 | b2 & 0x3F);
    }

    public static int d(byte[] arr_b, int v, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a;
        if(v2 < 0) {
            throw R1.f();
        }
        if(v2 > arr_b.length - v1) {
            throw R1.h();
        }
        if(v2 == 0) {
            g0.c = o.b;
            return v1;
        }
        g0.c = o.d(arr_b, v1, v2);
        return v1 + v2;
    }

    public static int e(int v, byte[] arr_b) {
        return (arr_b[v + 3] & 0xFF) << 24 | (arr_b[v] & 0xFF | (arr_b[v + 1] & 0xFF) << 8 | (arr_b[v + 2] & 0xFF) << 16);
    }

    public static long f(int v, byte[] arr_b) {
        return (((long)arr_b[v + 7]) & 0xFFL) << 56 | (((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30);
    }

    public static int g(E2 e20, byte[] arr_b, int v, int v1, int v2, g g0) {
        Object object0 = e20.d();
        int v3 = h.D(object0, e20, arr_b, v, v1, v2, g0);
        e20.b(object0);
        g0.c = object0;
        return v3;
    }

    public static int h(E2 e20, byte[] arr_b, int v, int v1, g g0) {
        Object object0 = e20.d();
        int v2 = h.E(object0, e20, arr_b, v, v1, g0);
        e20.b(object0);
        g0.c = object0;
        return v2;
    }

    public static int i(E2 e20, int v, byte[] arr_b, int v1, int v2, O1 o10, g g0) {
        int v3 = h.h(e20, arr_b, v1, v2, g0);
        o10.add(g0.c);
        while(v3 < v2) {
            int v4 = h.x(arr_b, v3, g0);
            if(v != g0.a) {
                break;
            }
            v3 = h.h(e20, arr_b, v4, v2, g0);
            o10.add(g0.c);
        }
        return v3;
    }

    public static int j(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a + v1;
        while(v1 < v2) {
            v1 = h.z(arr_b, v1, g0);
            ((j)o10).d(g0.b != 0L);
        }
        if(v1 != v2) {
            throw R1.h();
        }
        return v1;
    }

    public static int k(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a;
        int v3 = v1 + v2;
        if(v3 > arr_b.length) {
            throw R1.h();
        }
        int v4 = v2 / 8 + ((W0)o10).c;
        double[] arr_f = ((W0)o10).b;
        if(v4 > arr_f.length) {
            if(arr_f.length == 0) {
                ((W0)o10).b = new double[Math.max(v4, 10)];
            }
            else {
                int v5;
                for(v5 = arr_f.length; v5 < v4; v5 = Z.c(v5, 3, 2, 1, 10)) {
                }
                ((W0)o10).b = Arrays.copyOf(((W0)o10).b, v5);
            }
        }
        while(v1 < v3) {
            ((W0)o10).d(Double.longBitsToDouble(h.f(v1, arr_b)));
            v1 += 8;
        }
        if(v1 != v3) {
            throw R1.h();
        }
        return v1;
    }

    public static int l(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a;
        int v3 = v1 + v2;
        if(v3 > arr_b.length) {
            throw R1.h();
        }
        int v4 = v2 / 4 + ((D1)o10).c;
        int[] arr_v = ((D1)o10).b;
        if(v4 > arr_v.length) {
            if(arr_v.length == 0) {
                ((D1)o10).b = new int[Math.max(v4, 10)];
            }
            else {
                int v5;
                for(v5 = arr_v.length; v5 < v4; v5 = Z.c(v5, 3, 2, 1, 10)) {
                }
                ((D1)o10).b = Arrays.copyOf(((D1)o10).b, v5);
            }
        }
        while(v1 < v3) {
            ((D1)o10).d(h.e(v1, arr_b));
            v1 += 4;
        }
        if(v1 != v3) {
            throw R1.h();
        }
        return v1;
    }

    public static int m(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a;
        int v3 = v1 + v2;
        if(v3 > arr_b.length) {
            throw R1.h();
        }
        int v4 = v2 / 8 + ((c2)o10).c;
        long[] arr_v = ((c2)o10).b;
        if(v4 > arr_v.length) {
            if(arr_v.length == 0) {
                ((c2)o10).b = new long[Math.max(v4, 10)];
            }
            else {
                int v5;
                for(v5 = arr_v.length; v5 < v4; v5 = Z.c(v5, 3, 2, 1, 10)) {
                }
                ((c2)o10).b = Arrays.copyOf(((c2)o10).b, v5);
            }
        }
        while(v1 < v3) {
            ((c2)o10).d(h.f(v1, arr_b));
            v1 += 8;
        }
        if(v1 != v3) {
            throw R1.h();
        }
        return v1;
    }

    public static int n(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a;
        int v3 = v1 + v2;
        if(v3 > arr_b.length) {
            throw R1.h();
        }
        int v4 = v2 / 4 + ((q1)o10).c;
        float[] arr_f = ((q1)o10).b;
        if(v4 > arr_f.length) {
            if(arr_f.length == 0) {
                ((q1)o10).b = new float[Math.max(v4, 10)];
            }
            else {
                int v5;
                for(v5 = arr_f.length; v5 < v4; v5 = Z.c(v5, 3, 2, 1, 10)) {
                }
                ((q1)o10).b = Arrays.copyOf(((q1)o10).b, v5);
            }
        }
        while(v1 < v3) {
            ((q1)o10).d(Float.intBitsToFloat(h.e(v1, arr_b)));
            v1 += 4;
        }
        if(v1 != v3) {
            throw R1.h();
        }
        return v1;
    }

    public static int o(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a + v1;
        while(v1 < v2) {
            v1 = h.x(arr_b, v1, g0);
            ((D1)o10).d(-(g0.a & 1) ^ g0.a >>> 1);
        }
        if(v1 != v2) {
            throw R1.h();
        }
        return v1;
    }

    public static int p(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a + v1;
        while(v1 < v2) {
            v1 = h.z(arr_b, v1, g0);
            ((c2)o10).d(-(g0.b & 1L) ^ g0.b >>> 1);
        }
        if(v1 != v2) {
            throw R1.h();
        }
        return v1;
    }

    public static int q(byte[] arr_b, int v, O1 o10, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a + v1;
        while(v1 < v2) {
            v1 = h.x(arr_b, v1, g0);
            ((D1)o10).d(g0.a);
        }
        if(v1 != v2) {
            throw R1.h();
        }
        return v1;
    }

    public static int r(byte[] arr_b, int v, g g0) {
        int v1 = h.x(arr_b, v, g0);
        int v2 = g0.a;
        if(v2 < 0) {
            throw R1.f();
        }
        if(v2 == 0) {
            g0.c = "";
            return v1;
        }
        g0.c = new String(arr_b, v1, v2, P1.a);
        return v1 + v2;
    }

    public static int s(int v, byte[] arr_b, int v1, int v2, S2 s20, g g0) {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    int v3 = h.z(arr_b, v1, g0);
                    s20.f(v, g0.b);
                    return v3;
                }
                case 1: {
                    s20.f(v, h.f(v1, arr_b));
                    return v1 + 8;
                }
                case 2: {
                    int v4 = h.x(arr_b, v1, g0);
                    int v5 = g0.a;
                    if(v5 < 0) {
                        throw R1.f();
                    }
                    if(v5 > arr_b.length - v4) {
                        throw R1.h();
                    }
                    if(v5 == 0) {
                        s20.f(v, o.b);
                        return v4;
                    }
                    s20.f(v, o.d(arr_b, v4, v5));
                    return v4 + v5;
                }
                case 3: {
                    S2 s21 = new S2();
                    int v6 = v & -8 | 4;
                    int v7 = g0.e + 1;
                    g0.e = v7;
                    if(v7 >= 100) {
                        throw new R1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    int v8 = 0;
                    while(v1 < v2) {
                        int v9 = h.x(arr_b, v1, g0);
                        v8 = g0.a;
                        if(v8 == v6) {
                            v1 = v9;
                            break;
                        }
                        v1 = h.s(v8, arr_b, v9, v2, s21, g0);
                    }
                    --g0.e;
                    if(v1 > v2 || v8 != v6) {
                        throw R1.g();
                    }
                    s20.f(v, s21);
                    return v1;
                }
                case 5: {
                    s20.f(v, h.e(v1, arr_b));
                    return v1 + 4;
                }
                default: {
                    throw R1.b();
                }
            }
        }
        throw R1.b();
    }

    public abstract String t(byte[] arg1, int arg2, int arg3);

    public static String u(ByteBuffer byteBuffer0, int v, int v1) {
        if((v | v1 | byteBuffer0.limit() - v - v1) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", byteBuffer0.limit(), v, v1));
        }
        int v2 = v + v1;
        char[] arr_c = new char[v1];
        int v3;
        for(v3 = 0; v < v2; ++v3) {
            int v4 = byteBuffer0.get(v);
            if(v4 < 0) {
                break;
            }
            ++v;
            arr_c[v3] = (char)v4;
        }
        int v5 = v3;
        while(v < v2) {
            int v6 = v + 1;
            int v7 = byteBuffer0.get(v);
            if(v7 >= 0) {
                int v8 = v5 + 1;
                arr_c[v5] = (char)v7;
                int v9 = v6;
                while(v9 < v2) {
                    int v10 = byteBuffer0.get(v9);
                    if(v10 < 0) {
                        break;
                    }
                    ++v9;
                    arr_c[v8] = (char)v10;
                    ++v8;
                }
                v5 = v8;
                v = v9;
                continue;
            }
            if(v7 < 0xFFFFFFE0) {
                if(v6 < v2) {
                    v += 2;
                    h.b(((byte)v7), byteBuffer0.get(v6), arr_c, v5);
                    ++v5;
                    continue;
                }
            }
            else if(v7 >= -16) {
                if(v6 < v2 - 2) {
                    int v12 = byteBuffer0.get(v6);
                    int v13 = v + 3;
                    int v14 = byteBuffer0.get(v + 2);
                    v += 4;
                    h.a(((byte)v7), ((byte)v12), ((byte)v14), byteBuffer0.get(v13), arr_c, v5);
                    v5 += 2;
                    continue;
                }
            }
            else if(v6 < v2 - 1) {
                int v11 = v + 2;
                v += 3;
                h.c(((byte)v7), byteBuffer0.get(v6), byteBuffer0.get(v11), arr_c, v5);
                ++v5;
                continue;
            }
            throw R1.c();
        }
        return new String(arr_c, 0, v5);
    }

    public abstract String v(ByteBuffer arg1, int arg2, int arg3);

    public static int w(int v, byte[] arr_b, int v1, g g0) {
        int v2 = arr_b[v1];
        if(v2 >= 0) {
            g0.a = v & 0x7F | v2 << 7;
            return v1 + 1;
        }
        int v3 = v & 0x7F | (v2 & 0x7F) << 7;
        int v4 = arr_b[v1 + 1];
        if(v4 >= 0) {
            g0.a = v3 | v4 << 14;
            return v1 + 2;
        }
        int v5 = v3 | (v4 & 0x7F) << 14;
        int v6 = arr_b[v1 + 2];
        if(v6 >= 0) {
            g0.a = v5 | v6 << 21;
            return v1 + 3;
        }
        int v7 = v5 | (v6 & 0x7F) << 21;
        int v8 = v1 + 4;
        int v9 = arr_b[v1 + 3];
        if(v9 >= 0) {
            g0.a = v7 | v9 << 28;
            return v8;
        }
        while(arr_b[v8] < 0) {
            ++v8;
        }
        g0.a = v7 | (v9 & 0x7F) << 28;
        return v8 + 1;
    }

    public static int x(byte[] arr_b, int v, g g0) {
        int v1 = arr_b[v];
        if(v1 >= 0) {
            g0.a = v1;
            return v + 1;
        }
        return h.w(v1, arr_b, v + 1, g0);
    }

    public static int y(int v, byte[] arr_b, int v1, int v2, O1 o10, g g0) {
        int v3 = h.x(arr_b, v1, g0);
        ((D1)o10).d(g0.a);
        while(v3 < v2) {
            int v4 = h.x(arr_b, v3, g0);
            if(v != g0.a) {
                break;
            }
            v3 = h.x(arr_b, v4, g0);
            ((D1)o10).d(g0.a);
        }
        return v3;
    }

    public static int z(byte[] arr_b, int v, g g0) {
        long v1 = (long)arr_b[v];
        if(v1 >= 0L) {
            g0.b = v1;
            return v + 1;
        }
        int v2 = v + 2;
        int v3 = arr_b[v + 1];
        long v4 = v1 & 0x7FL | ((long)(v3 & 0x7F)) << 7;
        int v5 = 7;
        while(v3 < 0) {
            int v6 = arr_b[v2];
            v5 += 7;
            v4 |= ((long)(v6 & 0x7F)) << v5;
            v3 = v6;
            ++v2;
        }
        g0.b = v4;
        return v2;
    }
}

