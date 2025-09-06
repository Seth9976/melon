package com.google.protobuf;

import java.io.OutputStream;

public final class w extends x {
    public final byte[] d;
    public final int e;
    public int f;
    public final OutputStream g;

    public w(OutputStream outputStream0, int v) {
        if(v < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int v1 = Math.max(v, 20);
        this.d = new byte[v1];
        this.e = v1;
        if(outputStream0 == null) {
            throw new NullPointerException("out");
        }
        this.g = outputStream0;
    }

    @Override  // com.google.protobuf.h
    public final void I(byte[] arr_b, int v, int v1) {
        this.v0(arr_b, v, v1);
    }

    @Override  // com.google.protobuf.x
    public final void S(byte b) {
        if(this.f == this.e) {
            this.t0();
        }
        int v = this.f;
        this.d[v] = b;
        this.f = v + 1;
    }

    @Override  // com.google.protobuf.x
    public final void T(int v, boolean z) {
        this.u0(11);
        this.q0(v, 0);
        int v1 = this.f;
        this.d[v1] = (byte)z;
        this.f = v1 + 1;
    }

    @Override  // com.google.protobuf.x
    public final void U(int v, byte[] arr_b) {
        this.l0(v);
        this.v0(arr_b, 0, v);
    }

    @Override  // com.google.protobuf.x
    public final void V(int v, o o0) {
        this.j0(v, 2);
        this.W(o0);
    }

    @Override  // com.google.protobuf.x
    public final void W(o o0) {
        this.l0(o0.size());
        o0.q(this);
    }

    @Override  // com.google.protobuf.x
    public final void X(int v, int v1) {
        this.u0(14);
        this.q0(v, 5);
        this.o0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void Y(int v) {
        this.u0(4);
        this.o0(v);
    }

    @Override  // com.google.protobuf.x
    public final void Z(int v, long v1) {
        this.u0(18);
        this.q0(v, 1);
        this.p0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void a0(long v) {
        this.u0(8);
        this.p0(v);
    }

    @Override  // com.google.protobuf.x
    public final void b0(int v, int v1) {
        this.u0(20);
        this.q0(v, 0);
        if(v1 >= 0) {
            this.r0(v1);
            return;
        }
        this.s0(((long)v1));
    }

    @Override  // com.google.protobuf.x
    public final void c0(int v) {
        if(v >= 0) {
            this.l0(v);
            return;
        }
        this.n0(((long)v));
    }

    @Override  // com.google.protobuf.x
    public final void d0(int v, l2 l20, E2 e20) {
        this.j0(v, 2);
        this.l0(((b)l20).getSerializedSize(e20));
        e20.e(l20, this.a);
    }

    @Override  // com.google.protobuf.x
    public final void e0(l2 l20) {
        this.l0(l20.getSerializedSize());
        l20.writeTo(this);
    }

    @Override  // com.google.protobuf.x
    public final void f0(int v, l2 l20) {
        this.j0(1, 3);
        this.k0(2, v);
        this.j0(3, 2);
        this.e0(l20);
        this.j0(1, 4);
    }

    @Override  // com.google.protobuf.x
    public final void g0(int v, o o0) {
        this.j0(1, 3);
        this.k0(2, v);
        this.V(3, o0);
        this.j0(1, 4);
    }

    @Override  // com.google.protobuf.x
    public final void h0(int v, String s) {
        this.j0(v, 2);
        this.i0(s);
    }

    @Override  // com.google.protobuf.x
    public final void i0(String s) {
        byte[] arr_b1;
        int v6;
        int v5;
        int v3;
        try {
            int v = s.length();
            int v1 = x.P(v * 3);
            int v2 = v1 + v * 3;
            v3 = this.e;
            if(v2 > v3) {
                byte[] arr_b = new byte[v * 3];
                int v4 = b3.a.A(s, arr_b, 0, v * 3);
                this.l0(v4);
                this.v0(arr_b, 0, v4);
                return;
            }
            if(v2 > v3 - this.f) {
                this.t0();
            }
            v5 = x.P(s.length());
            v6 = this.f;
            arr_b1 = this.d;
            if(v5 == v1) {
                goto label_16;
            }
            goto label_23;
        }
        catch(a3 a30) {
            this.R(s, a30);
            return;
        }
        try {
        label_16:
            int v7 = v6 + v5;
            this.f = v7;
            int v8 = b3.a.A(s, arr_b1, v7, v3 - v7);
            this.f = v6;
            this.r0(v8 - v6 - v5);
            this.f = v8;
            return;
        label_23:
            int v9 = b3.b(s);
            this.r0(v9);
            this.f = b3.a.A(s, arr_b1, this.f, v9);
            return;
        }
        catch(a3 a31) {
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            throw new v(arrayIndexOutOfBoundsException0);
        }
        try {
            this.f = v6;
            throw a31;
        }
        catch(a3 a30) {
        }
        this.R(s, a30);
    }

    @Override  // com.google.protobuf.x
    public final void j0(int v, int v1) {
        this.l0(v << 3 | v1);
    }

    @Override  // com.google.protobuf.x
    public final void k0(int v, int v1) {
        this.u0(20);
        this.q0(v, 0);
        this.r0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void l0(int v) {
        this.u0(5);
        this.r0(v);
    }

    @Override  // com.google.protobuf.x
    public final void m0(int v, long v1) {
        this.u0(20);
        this.q0(v, 0);
        this.s0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void n0(long v) {
        this.u0(10);
        this.s0(v);
    }

    public final void o0(int v) {
        int v1 = this.f;
        this.d[v1] = (byte)v;
        this.d[v1 + 1] = (byte)(v >> 8);
        this.d[v1 + 2] = (byte)(v >> 16);
        this.d[v1 + 3] = (byte)(v >> 24);
        this.f = v1 + 4;
    }

    public final void p0(long v) {
        int v1 = this.f;
        this.d[v1] = (byte)(((int)v));
        this.d[v1 + 1] = (byte)(((int)(v >> 8)));
        this.d[v1 + 2] = (byte)(((int)(v >> 16)));
        this.d[v1 + 3] = (byte)(((int)(v >> 24)));
        this.d[v1 + 4] = (byte)(((int)(v >> 0x20)));
        this.d[v1 + 5] = (byte)(((int)(v >> 40)));
        this.d[v1 + 6] = (byte)(((int)(v >> 0x30)));
        this.d[v1 + 7] = (byte)(((int)(v >> 56)));
        this.f = v1 + 8;
    }

    public final void q0(int v, int v1) {
        this.r0(v << 3 | v1);
    }

    public final void r0(int v) {
        byte[] arr_b = this.d;
        if(x.c) {
            while((v & 0xFFFFFF80) != 0) {
                int v1 = this.f;
                this.f = v1 + 1;
                Y2.k(arr_b, ((long)v1), ((byte)(v | 0x80)));
                v >>>= 7;
            }
            int v2 = this.f;
            this.f = v2 + 1;
            Y2.k(arr_b, ((long)v2), ((byte)v));
            return;
        }
        while((v & 0xFFFFFF80) != 0) {
            int v3 = this.f;
            this.f = v3 + 1;
            arr_b[v3] = (byte)(v | 0x80);
            v >>>= 7;
        }
        int v4 = this.f;
        this.f = v4 + 1;
        arr_b[v4] = (byte)v;
    }

    public final void s0(long v) {
        byte[] arr_b = this.d;
        if(x.c) {
            while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                int v1 = this.f;
                this.f = v1 + 1;
                Y2.k(arr_b, ((long)v1), ((byte)(((int)v) | 0x80)));
                v >>>= 7;
            }
            int v2 = this.f;
            this.f = v2 + 1;
            Y2.k(arr_b, ((long)v2), ((byte)(((int)v))));
            return;
        }
        while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
            int v3 = this.f;
            this.f = v3 + 1;
            arr_b[v3] = (byte)(((int)v) | 0x80);
            v >>>= 7;
        }
        int v4 = this.f;
        this.f = v4 + 1;
        arr_b[v4] = (byte)(((int)v));
    }

    public final void t0() {
        this.g.write(this.d, 0, this.f);
        this.f = 0;
    }

    public final void u0(int v) {
        if(this.e - this.f < v) {
            this.t0();
        }
    }

    public final void v0(byte[] arr_b, int v, int v1) {
        int v2 = this.f;
        int v3 = this.e;
        int v4 = v3 - v2;
        byte[] arr_b1 = this.d;
        if(v4 >= v1) {
            System.arraycopy(arr_b, v, arr_b1, v2, v1);
            this.f += v1;
            return;
        }
        System.arraycopy(arr_b, v, arr_b1, v2, v4);
        int v5 = v + v4;
        int v6 = v1 - v4;
        this.f = v3;
        this.t0();
        if(v6 <= v3) {
            System.arraycopy(arr_b, v5, arr_b1, 0, v6);
            this.f = v6;
            return;
        }
        this.g.write(arr_b, v5, v6);
    }
}

