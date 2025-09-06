package androidx.datastore.preferences.protobuf;

import De.I;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class o extends I {
    public M j;
    public final byte[] k;
    public final int l;
    public int m;
    public final OutputStream n;
    public static final Logger o;
    public static final boolean p;

    static {
        o.o = Logger.getLogger("androidx.datastore.preferences.protobuf.o");
        o.p = false;
    }

    public o(OutputStream outputStream0, int v) {
        if(v < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int v1 = Math.max(v, 20);
        this.k = new byte[v1];
        this.l = v1;
        if(outputStream0 == null) {
            throw new NullPointerException("out");
        }
        this.n = outputStream0;
    }

    public final void A0(int v, long v1) {
        this.s0(18);
        this.i0(v, 1);
        this.h0(v1);
    }

    public final void B0(long v) {
        this.s0(8);
        this.h0(v);
    }

    public final void C0(int v, int v1) {
        this.s0(20);
        this.i0(v, 0);
        if(v1 >= 0) {
            this.j0(v1);
            return;
        }
        this.k0(((long)v1));
    }

    public final void D0(int v) {
        if(v >= 0) {
            this.J0(v);
            return;
        }
        this.L0(((long)v));
    }

    public final void E0(int v, a a0, e0 e00) {
        this.H0(v, 2);
        this.J0(a0.a(e00));
        e00.e(a0, this.j);
    }

    public final void F0(int v, String s) {
        this.H0(v, 2);
        this.G0(s);
    }

    public final void G0(String s) {
        byte[] arr_b1;
        int v6;
        int v5;
        int v3;
        try {
            int v = s.length();
            int v1 = o.p0(v * 3);
            int v2 = v1 + v * 3;
            v3 = this.l;
            if(v2 > v3) {
                byte[] arr_b = new byte[v * 3];
                int v4 = u0.a.D(s, arr_b, 0, v * 3);
                this.J0(v4);
                this.u0(arr_b, 0, v4);
                return;
            }
            if(v2 > v3 - this.m) {
                this.r0();
            }
            v5 = o.p0(s.length());
            v6 = this.m;
            arr_b1 = this.k;
            if(v5 == v1) {
                goto label_16;
            }
            goto label_23;
        }
        catch(t0 t00) {
            goto label_34;
        }
        try {
        label_16:
            int v7 = v6 + v5;
            this.m = v7;
            int v8 = u0.a.D(s, arr_b1, v7, v3 - v7);
            this.m = v6;
            this.j0(v8 - v6 - v5);
            this.m = v8;
            return;
        label_23:
            int v9 = u0.a(s);
            this.j0(v9);
            this.m = u0.a.D(s, arr_b1, this.m, v9);
            return;
        }
        catch(t0 t01) {
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            throw new n(arrayIndexOutOfBoundsException0);
        }
        try {
            this.m = v6;
            throw t01;
        }
        catch(t0 t00) {
        }
    label_34:
        o.o.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", t00);
        byte[] arr_b2 = s.getBytes(D.a);
        try {
            this.J0(arr_b2.length);
            this.f0(arr_b2, 0, arr_b2.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new n(indexOutOfBoundsException0);
        }
    }

    public final void H0(int v, int v1) {
        this.J0(v << 3 | v1);
    }

    public final void I0(int v, int v1) {
        this.s0(20);
        this.i0(v, 0);
        this.j0(v1);
    }

    public final void J0(int v) {
        this.s0(5);
        this.j0(v);
    }

    public final void K0(int v, long v1) {
        this.s0(20);
        this.i0(v, 0);
        this.k0(v1);
    }

    public final void L0(long v) {
        this.s0(10);
        this.k0(v);
    }

    @Override  // De.I
    public final void f0(byte[] arr_b, int v, int v1) {
        this.u0(arr_b, v, v1);
    }

    public final void g0(int v) {
        int v1 = this.m;
        this.m = v1 + 1;
        this.k[v1] = (byte)(v & 0xFF);
        this.m = v1 + 2;
        this.k[v1 + 1] = (byte)(v >> 8 & 0xFF);
        this.m = v1 + 3;
        this.k[v1 + 2] = (byte)(v >> 16 & 0xFF);
        this.m = v1 + 4;
        this.k[v1 + 3] = (byte)(v >> 24 & 0xFF);
    }

    public final void h0(long v) {
        int v1 = this.m;
        this.m = v1 + 1;
        this.k[v1] = (byte)(((int)(v & 0xFFL)));
        this.m = v1 + 2;
        this.k[v1 + 1] = (byte)(((int)(v >> 8 & 0xFFL)));
        this.m = v1 + 3;
        this.k[v1 + 2] = (byte)(((int)(v >> 16 & 0xFFL)));
        this.m = v1 + 4;
        this.k[v1 + 3] = (byte)(((int)(0xFFL & v >> 24)));
        this.m = v1 + 5;
        this.k[v1 + 4] = (byte)(((int)(v >> 0x20)) & 0xFF);
        this.m = v1 + 6;
        this.k[v1 + 5] = (byte)(((int)(v >> 40)) & 0xFF);
        this.m = v1 + 7;
        this.k[v1 + 6] = (byte)(((int)(v >> 0x30)) & 0xFF);
        this.m = v1 + 8;
        this.k[v1 + 7] = (byte)(((int)(v >> 56)) & 0xFF);
    }

    public final void i0(int v, int v1) {
        this.j0(v << 3 | v1);
    }

    public final void j0(int v) {
        byte[] arr_b = this.k;
        if(o.p) {
            while((v & 0xFFFFFF80) != 0) {
                int v1 = this.m;
                this.m = v1 + 1;
                r0.j(arr_b, ((long)v1), ((byte)((v | 0x80) & 0xFF)));
                v >>>= 7;
            }
            int v2 = this.m;
            this.m = v2 + 1;
            r0.j(arr_b, ((long)v2), ((byte)v));
            return;
        }
        while((v & 0xFFFFFF80) != 0) {
            int v3 = this.m;
            this.m = v3 + 1;
            arr_b[v3] = (byte)((v | 0x80) & 0xFF);
            v >>>= 7;
        }
        int v4 = this.m;
        this.m = v4 + 1;
        arr_b[v4] = (byte)v;
    }

    public final void k0(long v) {
        byte[] arr_b = this.k;
        if(o.p) {
            while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                int v1 = this.m;
                this.m = v1 + 1;
                r0.j(arr_b, ((long)v1), ((byte)((((int)v) | 0x80) & 0xFF)));
                v >>>= 7;
            }
            int v2 = this.m;
            this.m = v2 + 1;
            r0.j(arr_b, ((long)v2), ((byte)(((int)v))));
            return;
        }
        while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
            int v3 = this.m;
            this.m = v3 + 1;
            arr_b[v3] = (byte)((((int)v) | 0x80) & 0xFF);
            v >>>= 7;
        }
        int v4 = this.m;
        this.m = v4 + 1;
        arr_b[v4] = (byte)(((int)v));
    }

    public static int l0(int v, j j0) {
        return o.m0(j0) + o.o0(v);
    }

    public static int m0(j j0) {
        int v = j0.size();
        return o.p0(v) + v;
    }

    public static int n0(String s) {
        int v;
        try {
            v = u0.a(s);
            return o.p0(v) + v;
        }
        catch(t0 unused_ex) {
            v = s.getBytes(D.a).length;
            return o.p0(v) + v;
        }
    }

    public static int o0(int v) [...] // 潜在的解密器

    public static int p0(int v) {
        return 0x160 - Integer.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public static int q0(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public final void r0() {
        this.n.write(this.k, 0, this.m);
        this.m = 0;
    }

    public final void s0(int v) {
        if(this.l - this.m < v) {
            this.r0();
        }
    }

    public final void t0(byte b) {
        if(this.m == this.l) {
            this.r0();
        }
        int v = this.m;
        this.m = v + 1;
        this.k[v] = b;
    }

    public final void u0(byte[] arr_b, int v, int v1) {
        int v2 = this.m;
        int v3 = this.l;
        int v4 = v3 - v2;
        byte[] arr_b1 = this.k;
        if(v4 >= v1) {
            System.arraycopy(arr_b, v, arr_b1, v2, v1);
            this.m += v1;
            return;
        }
        System.arraycopy(arr_b, v, arr_b1, v2, v4);
        int v5 = v + v4;
        int v6 = v1 - v4;
        this.m = v3;
        this.r0();
        if(v6 <= v3) {
            System.arraycopy(arr_b, v5, arr_b1, 0, v6);
            this.m = v6;
            return;
        }
        this.n.write(arr_b, v5, v6);
    }

    public final void v0(int v, boolean z) {
        this.s0(11);
        this.i0(v, 0);
        int v1 = this.m;
        this.m = v1 + 1;
        this.k[v1] = (byte)z;
    }

    public final void w0(int v, j j0) {
        this.H0(v, 2);
        this.x0(j0);
    }

    public final void x0(j j0) {
        this.J0(j0.size());
        this.f0(((i)j0).d, ((i)j0).g(), ((i)j0).size());
    }

    public final void y0(int v, int v1) {
        this.s0(14);
        this.i0(v, 5);
        this.g0(v1);
    }

    public final void z0(int v) {
        this.s0(4);
        this.g0(v);
    }
}

