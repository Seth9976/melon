package com.google.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class x extends h {
    public e2 a;
    public static final Logger b;
    public static final boolean c;

    static {
        x.b = Logger.getLogger("com.google.protobuf.x");
        x.c = false;
    }

    public static int J(int v, o o0) {
        return x.K(o0) + x.O(v);
    }

    public static int K(o o0) {
        int v = o0.size();
        return x.P(v) + v;
    }

    public static int L(int v) {
        return x.P(v >> 0x1F ^ v << 1);
    }

    public static int M(long v) {
        return x.Q(v >> 0x3F ^ v << 1);
    }

    public static int N(String s) {
        int v;
        try {
            v = b3.b(s);
            return x.P(v) + v;
        }
        catch(a3 unused_ex) {
            v = s.getBytes(P1.a).length;
            return x.P(v) + v;
        }
    }

    public static int O(int v) [...] // 潜在的解密器

    public static int P(int v) {
        return 0x160 - Integer.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public static int Q(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public final void R(String s, a3 a30) {
        x.b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", a30);
        byte[] arr_b = s.getBytes(P1.a);
        try {
            this.l0(arr_b.length);
            this.I(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(indexOutOfBoundsException0);
        }
    }

    public abstract void S(byte arg1);

    public abstract void T(int arg1, boolean arg2);

    public abstract void U(int arg1, byte[] arg2);

    public abstract void V(int arg1, o arg2);

    public abstract void W(o arg1);

    public abstract void X(int arg1, int arg2);

    public abstract void Y(int arg1);

    public abstract void Z(int arg1, long arg2);

    public abstract void a0(long arg1);

    public abstract void b0(int arg1, int arg2);

    public abstract void c0(int arg1);

    public abstract void d0(int arg1, l2 arg2, E2 arg3);

    public abstract void e0(l2 arg1);

    public abstract void f0(int arg1, l2 arg2);

    public abstract void g0(int arg1, o arg2);

    public abstract void h0(int arg1, String arg2);

    public abstract void i0(String arg1);

    public abstract void j0(int arg1, int arg2);

    public abstract void k0(int arg1, int arg2);

    public abstract void l0(int arg1);

    public abstract void m0(int arg1, long arg2);

    public abstract void n0(long arg1);
}

