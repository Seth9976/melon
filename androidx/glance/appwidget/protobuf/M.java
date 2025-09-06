package androidx.glance.appwidget.protobuf;

import V4.u;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class m extends u {
    public K n;
    public final byte[] o;
    public final int p;
    public int q;
    public final OutputStream r;
    public static final Logger s;
    public static final boolean t;

    static {
        m.s = Logger.getLogger("androidx.glance.appwidget.protobuf.m");
        m.t = i0.e;
    }

    public m(OutputStream outputStream0, int v) {
        if(v < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int v1 = Math.max(v, 20);
        this.o = new byte[v1];
        this.p = v1;
        if(outputStream0 == null) {
            throw new NullPointerException("out");
        }
        this.r = outputStream0;
    }

    @Override  // V4.u
    public final void K(byte[] arr_b, int v, int v1) {
        this.Y(arr_b, v, v1);
    }

    public final void L(int v) {
        int v1 = this.q;
        this.q = v1 + 1;
        this.o[v1] = (byte)(v & 0xFF);
        this.q = v1 + 2;
        this.o[v1 + 1] = (byte)(v >> 8 & 0xFF);
        this.q = v1 + 3;
        this.o[v1 + 2] = (byte)(v >> 16 & 0xFF);
        this.q = v1 + 4;
        this.o[v1 + 3] = (byte)(v >> 24 & 0xFF);
    }

    public final void M(long v) {
        int v1 = this.q;
        this.q = v1 + 1;
        this.o[v1] = (byte)(((int)(v & 0xFFL)));
        this.q = v1 + 2;
        this.o[v1 + 1] = (byte)(((int)(v >> 8 & 0xFFL)));
        this.q = v1 + 3;
        this.o[v1 + 2] = (byte)(((int)(v >> 16 & 0xFFL)));
        this.q = v1 + 4;
        this.o[v1 + 3] = (byte)(((int)(0xFFL & v >> 24)));
        this.q = v1 + 5;
        this.o[v1 + 4] = (byte)(((int)(v >> 0x20)) & 0xFF);
        this.q = v1 + 6;
        this.o[v1 + 5] = (byte)(((int)(v >> 40)) & 0xFF);
        this.q = v1 + 7;
        this.o[v1 + 6] = (byte)(((int)(v >> 0x30)) & 0xFF);
        this.q = v1 + 8;
        this.o[v1 + 7] = (byte)(((int)(v >> 56)) & 0xFF);
    }

    public final void N(int v, int v1) {
        this.O(v << 3 | v1);
    }

    public final void O(int v) {
        byte[] arr_b = this.o;
        if(m.t) {
            while((v & 0xFFFFFF80) != 0) {
                int v1 = this.q;
                this.q = v1 + 1;
                i0.j(arr_b, ((long)v1), ((byte)((v | 0x80) & 0xFF)));
                v >>>= 7;
            }
            int v2 = this.q;
            this.q = v2 + 1;
            i0.j(arr_b, ((long)v2), ((byte)v));
            return;
        }
        while((v & 0xFFFFFF80) != 0) {
            int v3 = this.q;
            this.q = v3 + 1;
            arr_b[v3] = (byte)((v | 0x80) & 0xFF);
            v >>>= 7;
        }
        int v4 = this.q;
        this.q = v4 + 1;
        arr_b[v4] = (byte)v;
    }

    public final void P(long v) {
        byte[] arr_b = this.o;
        if(m.t) {
            while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                int v1 = this.q;
                this.q = v1 + 1;
                i0.j(arr_b, ((long)v1), ((byte)((((int)v) | 0x80) & 0xFF)));
                v >>>= 7;
            }
            int v2 = this.q;
            this.q = v2 + 1;
            i0.j(arr_b, ((long)v2), ((byte)(((int)v))));
            return;
        }
        while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
            int v3 = this.q;
            this.q = v3 + 1;
            arr_b[v3] = (byte)((((int)v) | 0x80) & 0xFF);
            v >>>= 7;
        }
        int v4 = this.q;
        this.q = v4 + 1;
        arr_b[v4] = (byte)(((int)v));
    }

    public static int Q(int v, i i0) {
        return m.R(i0) + m.T(v);
    }

    public static int R(i i0) {
        int v = i0.size();
        return m.U(v) + v;
    }

    public static int S(String s) {
        int v;
        try {
            v = l0.a(s);
            return m.U(v) + v;
        }
        catch(k0 unused_ex) {
            v = s.getBytes(B.a).length;
            return m.U(v) + v;
        }
    }

    public static int T(int v) [...] // 潜在的解密器

    public static int U(int v) {
        return 0x160 - Integer.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public static int V(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public final void W() {
        this.r.write(this.o, 0, this.q);
        this.q = 0;
    }

    public final void X(int v) {
        if(this.p - this.q < v) {
            this.W();
        }
    }

    public final void Y(byte[] arr_b, int v, int v1) {
        int v2 = this.q;
        int v3 = this.p;
        int v4 = v3 - v2;
        byte[] arr_b1 = this.o;
        if(v4 >= v1) {
            System.arraycopy(arr_b, v, arr_b1, v2, v1);
            this.q += v1;
            return;
        }
        System.arraycopy(arr_b, v, arr_b1, v2, v4);
        int v5 = v + v4;
        int v6 = v1 - v4;
        this.q = v3;
        this.W();
        if(v6 <= v3) {
            System.arraycopy(arr_b, v5, arr_b1, 0, v6);
            this.q = v6;
            return;
        }
        this.r.write(arr_b, v5, v6);
    }

    public final void Z(int v, boolean z) {
        this.X(11);
        this.N(v, 0);
        int v1 = this.q;
        this.q = v1 + 1;
        this.o[v1] = (byte)z;
    }

    public final void a0(int v, i i0) {
        this.j0(v, 2);
        this.l0(i0.size());
        this.K(((h)i0).d, ((h)i0).f(), ((h)i0).size());
    }

    public final void b0(int v, int v1) {
        this.X(14);
        this.N(v, 5);
        this.L(v1);
    }

    public final void c0(int v) {
        this.X(4);
        this.L(v);
    }

    public final void d0(int v, long v1) {
        this.X(18);
        this.N(v, 1);
        this.M(v1);
    }

    public final void e0(long v) {
        this.X(8);
        this.M(v);
    }

    public final void f0(int v, int v1) {
        this.X(20);
        this.N(v, 0);
        if(v1 >= 0) {
            this.O(v1);
            return;
        }
        this.P(((long)v1));
    }

    public final void g0(int v) {
        if(v >= 0) {
            this.l0(v);
            return;
        }
        this.n0(((long)v));
    }

    public final void h0(int v, a a0, Z z0) {
        this.j0(v, 2);
        this.l0(a0.a(z0));
        z0.h(a0, this.n);
    }

    public final void i0(int v, String s) {
        byte[] arr_b1;
        int v7;
        int v6;
        int v4;
        this.j0(v, 2);
        try {
            int v1 = s.length();
            int v2 = m.U(v1 * 3);
            int v3 = v2 + v1 * 3;
            v4 = this.p;
            if(v3 > v4) {
                byte[] arr_b = new byte[v1 * 3];
                int v5 = l0.a.v(s, arr_b, 0, v1 * 3);
                this.l0(v5);
                this.Y(arr_b, 0, v5);
                return;
            }
            if(v3 > v4 - this.q) {
                this.W();
            }
            v6 = m.U(s.length());
            v7 = this.q;
            arr_b1 = this.o;
            if(v6 == v2) {
                goto label_17;
            }
            goto label_24;
        }
        catch(k0 k00) {
            goto label_35;
        }
        try {
        label_17:
            int v8 = v7 + v6;
            this.q = v8;
            int v9 = l0.a.v(s, arr_b1, v8, v4 - v8);
            this.q = v7;
            this.O(v9 - v7 - v6);
            this.q = v9;
            return;
        label_24:
            int v10 = l0.a(s);
            this.O(v10);
            this.q = l0.a.v(s, arr_b1, this.q, v10);
            return;
        }
        catch(k0 k01) {
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            throw new l(arrayIndexOutOfBoundsException0);
        }
        try {
            this.q = v7;
            throw k01;
        }
        catch(k0 k00) {
        }
    label_35:
        m.s.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", k00);
        byte[] arr_b2 = s.getBytes(B.a);
        try {
            this.l0(arr_b2.length);
            this.K(arr_b2, 0, arr_b2.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new l(indexOutOfBoundsException0);
        }
    }

    public final void j0(int v, int v1) {
        this.l0(v << 3 | v1);
    }

    public final void k0(int v, int v1) {
        this.X(20);
        this.N(v, 0);
        this.O(v1);
    }

    public final void l0(int v) {
        this.X(5);
        this.O(v);
    }

    public final void m0(int v, long v1) {
        this.X(20);
        this.N(v, 0);
        this.P(v1);
    }

    public final void n0(long v) {
        this.X(10);
        this.P(v);
    }
}

