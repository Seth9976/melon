package com.google.protobuf;

public final class u extends x {
    public final byte[] d;
    public final int e;
    public int f;

    public u(byte[] arr_b, int v) {
        if((arr_b.length - v | v) < 0) {
            throw new IllegalArgumentException("Array range is invalid. Buffer.length=" + arr_b.length + ", offset=0, length=" + v);
        }
        this.d = arr_b;
        this.f = 0;
        this.e = v;
    }

    @Override  // com.google.protobuf.h
    public final void I(byte[] arr_b, int v, int v1) {
        this.p0(arr_b, v, v1);
    }

    @Override  // com.google.protobuf.x
    public final void S(byte b) {
        int v;
        try {
            v = this.f;
            this.d[v] = b;
            this.f = v + 1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(v + 1, this.e, 1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.protobuf.x
    public final void T(int v, boolean z) {
        this.j0(v, 0);
        this.S(((byte)z));
    }

    @Override  // com.google.protobuf.x
    public final void U(int v, byte[] arr_b) {
        this.l0(v);
        this.p0(arr_b, 0, v);
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
        this.j0(v, 5);
        this.Y(v1);
    }

    @Override  // com.google.protobuf.x
    public final void Y(int v) {
        int v1;
        try {
            v1 = this.f;
            this.d[v1] = (byte)v;
            this.d[v1 + 1] = (byte)(v >> 8);
            this.d[v1 + 2] = (byte)(v >> 16);
            this.d[v1 + 3] = (byte)(v >> 24);
            this.f = v1 + 4;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(v1, this.e, 4, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.protobuf.x
    public final void Z(int v, long v1) {
        this.j0(v, 1);
        this.a0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void a0(long v) {
        int v1;
        try {
            v1 = this.f;
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
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(v1, this.e, 8, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.protobuf.x
    public final void b0(int v, int v1) {
        this.j0(v, 0);
        this.c0(v1);
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
        int v;
        try {
            v = this.f;
            int v1 = x.P(s.length());
            byte[] arr_b = this.d;
            if(v1 == x.P(s.length() * 3)) {
                int v2 = v + v1;
                this.f = v2;
                int v3 = b3.a.A(s, arr_b, v2, this.o0());
                this.f = v;
                this.l0(v3 - v - v1);
                this.f = v3;
                return;
            }
            this.l0(b3.b(s));
            this.f = b3.a.A(s, arr_b, this.f, this.o0());
            return;
        }
        catch(a3 a30) {
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(indexOutOfBoundsException0);
        }
        this.f = v;
        this.R(s, a30);
    }

    @Override  // com.google.protobuf.x
    public final void j0(int v, int v1) {
        this.l0(v << 3 | v1);
    }

    @Override  // com.google.protobuf.x
    public final void k0(int v, int v1) {
        this.j0(v, 0);
        this.l0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void l0(int v) {
        int v2;
        int v1 = this.f;
        try {
            while(true) {
                byte[] arr_b = this.d;
                if((v & 0xFFFFFF80) == 0) {
                    v2 = v1 + 1;
                    arr_b[v1] = (byte)v;
                    this.f = v2;
                    return;
                }
                v2 = v1 + 1;
                arr_b[v1] = (byte)(v | 0x80);
                v >>>= 7;
                v1 = v2;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(v2, this.e, 1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.protobuf.x
    public final void m0(int v, long v1) {
        this.j0(v, 0);
        this.n0(v1);
    }

    @Override  // com.google.protobuf.x
    public final void n0(long v) {
        int v2;
        int v1 = this.f;
        byte[] arr_b = this.d;
        if(!x.c || this.o0() < 10) {
            try {
                while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                    v2 = v1 + 1;
                    arr_b[v1] = (byte)(((int)v) | 0x80);
                    v >>>= 7;
                    v1 = v2;
                }
                v2 = v1 + 1;
                arr_b[v1] = (byte)(((int)v));
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new v(v2, this.e, 1, indexOutOfBoundsException0);
            }
        }
        else {
            while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                Y2.k(arr_b, ((long)v1), ((byte)(((int)v) | 0x80)));
                v >>>= 7;
                ++v1;
            }
            v2 = v1 + 1;
            Y2.k(arr_b, ((long)v1), ((byte)(((int)v))));
        }
        this.f = v2;
    }

    public final int o0() {
        return this.e - this.f;
    }

    public final void p0(byte[] arr_b, int v, int v1) {
        try {
            System.arraycopy(arr_b, v, this.d, this.f, v1);
            this.f += v1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new v(this.f, this.e, v1, indexOutOfBoundsException0);
        }
    }
}

