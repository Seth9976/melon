package com.google.protobuf;

import java.nio.ByteBuffer;

public final class s extends t {
    public final ByteBuffer d;
    public final long e;
    public long f;
    public long g;
    public final long h;
    public int i;
    public int j;
    public int k;

    public s(ByteBuffer byteBuffer0, boolean z) {
        this.k = 0x7FFFFFFF;
        this.d = byteBuffer0.duplicate();
        long v = Y2.c.j(byteBuffer0, Y2.g);
        this.e = v;
        this.f = ((long)byteBuffer0.limit()) + v;
        long v1 = v + ((long)byteBuffer0.position());
        this.g = v1;
        this.h = v1;
    }

    @Override  // com.google.protobuf.t
    public final int A() {
        return t.c(this.w());
    }

    @Override  // com.google.protobuf.t
    public final long B() {
        return t.d(this.L());
    }

    @Override  // com.google.protobuf.t
    public final String C() {
        int v = this.w();
        if(v > 0) {
            long v1 = this.g;
            if(v <= ((int)(this.f - v1))) {
                byte[] arr_b = new byte[v];
                Y2.c.c(v1, arr_b, ((long)v));
                this.g += (long)v;
                return new String(arr_b, P1.a);
            }
        }
        if(v != 0) {
            throw v >= 0 ? R1.h() : R1.f();
        }
        return "";
    }

    @Override  // com.google.protobuf.t
    public final String D() {
        String s;
        int v = this.w();
        if(v > 0) {
            long v1 = this.g;
            if(v <= ((int)(this.f - v1))) {
                int v2 = (int)(v1 - this.e);
                h h0 = b3.a;
                h0.getClass();
                ByteBuffer byteBuffer0 = this.d;
                if(byteBuffer0.hasArray()) {
                    int v3 = byteBuffer0.arrayOffset();
                    s = h0.t(byteBuffer0.array(), v3 + v2, v);
                }
                else {
                    s = byteBuffer0.isDirect() ? h0.v(byteBuffer0, v2, v) : h.u(byteBuffer0, v2, v);
                }
                this.g += (long)v;
                return s;
            }
        }
        if(v != 0) {
            throw v > 0 ? R1.h() : R1.f();
        }
        return "";
    }

    @Override  // com.google.protobuf.t
    public final int E() {
        if(this.g()) {
            this.j = 0;
            return 0;
        }
        int v = this.w();
        this.j = v;
        if(v >>> 3 == 0) {
            throw R1.b();
        }
        return v;
    }

    @Override  // com.google.protobuf.t
    public final int F() {
        return this.w();
    }

    @Override  // com.google.protobuf.t
    public final long G() {
        return this.L();
    }

    @Override  // com.google.protobuf.t
    public final boolean H(int v) {
        int v1 = 0;
        switch(v & 7) {
            case 0: {
                if(((int)(this.f - this.g)) >= 10) {
                    while(v1 < 10) {
                        long v2 = this.g;
                        this.g = v2 + 1L;
                        if(Y2.c.e(v2) >= 0) {
                            return true;
                        }
                        ++v1;
                    }
                    throw R1.e();
                }
                while(v1 < 10) {
                    long v3 = this.g;
                    if(v3 == this.f) {
                        throw R1.h();
                    }
                    this.g = v3 + 1L;
                    if(Y2.c.e(v3) >= 0) {
                        return true;
                    }
                    ++v1;
                }
                throw R1.e();
            }
            case 1: {
                this.O(8);
                return true;
            }
            default: {
                if((v & 7) != 2) {
                    switch(v & 7) {
                        case 3: {
                            this.I();
                            this.a(v >>> 3 << 3 | 4);
                            return true;
                        }
                        case 4: {
                            if(this.b == 0) {
                                this.a(0);
                            }
                            return false;
                        }
                        default: {
                            if((v & 7) != 5) {
                                throw R1.d();
                            }
                            this.O(4);
                            return true;
                        }
                    }
                }
                this.O(this.w());
                return true;
            }
        }
    }

    public final int J() {
        long v = this.g;
        if(this.f - v < 4L) {
            throw R1.h();
        }
        this.g = v + 4L;
        int v1 = Y2.c.e(v);
        int v2 = Y2.c.e(v + 1L);
        int v3 = Y2.c.e(v + 2L);
        return (Y2.c.e(v + 3L) & 0xFF) << 24 | (v1 & 0xFF | (v2 & 0xFF) << 8 | (v3 & 0xFF) << 16);
    }

    public final long K() {
        long v = this.g;
        if(this.f - v < 8L) {
            throw R1.h();
        }
        this.g = v + 8L;
        long v1 = ((long)Y2.c.e(v)) & 0xFFL | (((long)Y2.c.e(v + 1L)) & 0xFFL) << 8 | (((long)Y2.c.e(v + 2L)) & 0xFFL) << 16 | (((long)Y2.c.e(v + 3L)) & 0xFFL) << 24 | (((long)Y2.c.e(v + 4L)) & 0xFFL) << 0x20 | (((long)Y2.c.e(v + 5L)) & 0xFFL) << 40 | (((long)Y2.c.e(v + 6L)) & 0xFFL) << 0x30;
        return (((long)Y2.c.e(v + 7L)) & 0xFFL) << 56 | v1;
    }

    public final long L() {
        long v13;
        long v10;
        long v7;
        int v4;
        long v = this.g;
        if(this.f != v) {
            X2 x20 = Y2.c;
            int v1 = x20.e(v);
            if(v1 >= 0) {
                this.g = v + 1L;
                return (long)v1;
            }
            if(this.f - (v + 1L) >= 9L) {
                long v2 = v + 2L;
                int v3 = x20.e(v + 1L) << 7 ^ v1;
                if(v3 < 0) {
                    v4 = v3 ^ 0xFFFFFF80;
                    this.g = v2;
                    return (long)v4;
                }
                long v5 = v + 3L;
                int v6 = v3 ^ x20.e(v2) << 14;
                if(v6 >= 0) {
                    v7 = (long)(v6 ^ 0x3F80);
                    v2 = v5;
                    this.g = v2;
                    return v7;
                }
                v2 = v + 4L;
                int v8 = v6 ^ x20.e(v5) << 21;
                if(v8 < 0) {
                    v4 = 0xFFE03F80 ^ v8;
                    this.g = v2;
                    return (long)v4;
                }
                v5 = v + 5L;
                long v9 = ((long)v8) ^ ((long)x20.e(v2)) << 28;
                if(v9 >= 0L) {
                    v10 = 0xFE03F80L;
                    v7 = v10 ^ v9;
                    v2 = v5;
                    this.g = v2;
                    return v7;
                }
                long v11 = v + 6L;
                long v12 = v9 ^ ((long)x20.e(v5)) << 35;
                if(v12 < 0L) {
                    v13 = 0xFFFFFFF80FE03F80L;
                    v7 = v13 ^ v12;
                    v2 = v11;
                    this.g = v2;
                    return v7;
                }
                v5 = v + 7L;
                v9 = v12 ^ ((long)x20.e(v11)) << 42;
                if(v9 >= 0L) {
                    v10 = 0x3F80FE03F80L;
                    v7 = v10 ^ v9;
                    v2 = v5;
                    this.g = v2;
                    return v7;
                }
                v11 = v + 8L;
                v12 = v9 ^ ((long)x20.e(v5)) << 49;
                if(v12 < 0L) {
                    v13 = 0xFFFE03F80FE03F80L;
                    v7 = v13 ^ v12;
                    v2 = v11;
                    this.g = v2;
                    return v7;
                }
                long v14 = v12 ^ ((long)x20.e(v11)) << 56 ^ 0xFE03F80FE03F80L;
                if(v14 >= 0L) {
                    v2 = v + 9L;
                    this.g = v2;
                    return v14;
                }
                else if(((long)x20.e(v + 9L)) >= 0L) {
                    v2 = v + 10L;
                    this.g = v2;
                    return v14;
                }
            }
        }
        return this.M();
    }

    public final long M() {
        long v = 0L;
        for(int v1 = 0; v1 < 0x40; v1 += 7) {
            long v2 = this.g;
            if(v2 == this.f) {
                throw R1.h();
            }
            this.g = v2 + 1L;
            int v3 = Y2.c.e(v2);
            v |= ((long)(v3 & 0x7F)) << v1;
            if((v3 & 0x80) == 0) {
                return v;
            }
        }
        throw R1.e();
    }

    public final void N() {
        long v = this.f + ((long)this.i);
        this.f = v;
        int v1 = (int)(v - this.h);
        int v2 = this.k;
        if(v1 > v2) {
            int v3 = v1 - v2;
            this.i = v3;
            this.f = v - ((long)v3);
            return;
        }
        this.i = 0;
    }

    public final void O(int v) {
        if(v >= 0) {
            long v1 = this.g;
            if(v <= ((int)(this.f - v1))) {
                this.g = v1 + ((long)v);
                return;
            }
        }
        throw v >= 0 ? R1.h() : R1.f();
    }

    @Override  // com.google.protobuf.t
    public final void a(int v) {
        if(this.j != v) {
            throw R1.a();
        }
    }

    @Override  // com.google.protobuf.t
    public final int e() {
        return this.k == 0x7FFFFFFF ? -1 : this.k - this.f();
    }

    @Override  // com.google.protobuf.t
    public final int f() {
        return (int)(this.g - this.h);
    }

    @Override  // com.google.protobuf.t
    public final boolean g() {
        return this.g == this.f;
    }

    @Override  // com.google.protobuf.t
    public final void j(int v) {
        this.k = v;
        this.N();
    }

    @Override  // com.google.protobuf.t
    public final int k(int v) {
        if(v < 0) {
            throw R1.f();
        }
        int v1 = this.f() + v;
        int v2 = this.k;
        if(v1 > v2) {
            throw R1.h();
        }
        this.k = v1;
        this.N();
        return v2;
    }

    @Override  // com.google.protobuf.t
    public final boolean l() {
        return this.L() != 0L;
    }

    @Override  // com.google.protobuf.t
    public final n m() {
        int v = this.w();
        if(v > 0) {
            long v1 = this.g;
            if(v <= ((int)(this.f - v1))) {
                byte[] arr_b = new byte[v];
                Y2.c.c(v1, arr_b, ((long)v));
                this.g += (long)v;
                return new n(arr_b);
            }
        }
        if(v != 0) {
            throw v >= 0 ? R1.h() : R1.f();
        }
        return o.b;
    }

    @Override  // com.google.protobuf.t
    public final double n() {
        return Double.longBitsToDouble(this.K());
    }

    @Override  // com.google.protobuf.t
    public final int o() {
        return this.w();
    }

    @Override  // com.google.protobuf.t
    public final int p() {
        return this.J();
    }

    @Override  // com.google.protobuf.t
    public final long q() {
        return this.K();
    }

    @Override  // com.google.protobuf.t
    public final float r() {
        return Float.intBitsToFloat(this.J());
    }

    @Override  // com.google.protobuf.t
    public final void s(int v, k2 k20, g1 g10) {
        this.b();
        ++this.b;
        ((t1)k20).g(this, g10);
        this.a(v << 3 | 4);
        --this.b;
    }

    @Override  // com.google.protobuf.t
    public final int t() {
        return this.w();
    }

    @Override  // com.google.protobuf.t
    public final long u() {
        return this.L();
    }

    @Override  // com.google.protobuf.t
    public final void v(k2 k20, g1 g10) {
        int v = this.w();
        this.b();
        int v1 = this.k(v);
        ++this.a;
        ((t1)k20).g(this, g10);
        this.a(0);
        --this.a;
        if(this.e() != 0) {
            throw R1.h();
        }
        this.j(v1);
    }

    @Override  // com.google.protobuf.t
    public final int w() {
        int v4;
        long v = this.g;
        if(this.f != v) {
            X2 x20 = Y2.c;
            int v1 = x20.e(v);
            if(v1 >= 0) {
                this.g = v + 1L;
                return v1;
            }
            if(this.f - (v + 1L) >= 9L) {
                long v2 = v + 2L;
                int v3 = x20.e(v + 1L) << 7 ^ v1;
                if(v3 < 0) {
                    v4 = v3 ^ 0xFFFFFF80;
                    this.g = v2;
                    return v4;
                }
                long v5 = v + 3L;
                int v6 = v3 ^ x20.e(v2) << 14;
                if(v6 >= 0) {
                    v4 = v6 ^ 0x3F80;
                    v2 = v5;
                    this.g = v2;
                    return v4;
                }
                v2 = v + 4L;
                int v7 = v6 ^ x20.e(v5) << 21;
                if(v7 < 0) {
                    v4 = 0xFFE03F80 ^ v7;
                    this.g = v2;
                    return v4;
                }
                v5 = v + 5L;
                int v8 = x20.e(v2);
                int v9 = v7 ^ v8 << 28 ^ 0xFE03F80;
                if(v8 >= 0) {
                    v2 = v5;
                    this.g = v2;
                    return v9;
                }
                v2 = v + 6L;
                if(x20.e(v5) >= 0) {
                    this.g = v2;
                    return v9;
                }
                v5 = v + 7L;
                if(x20.e(v2) >= 0) {
                    v2 = v5;
                    this.g = v2;
                    return v9;
                }
                v2 = v + 8L;
                if(x20.e(v5) >= 0) {
                    this.g = v2;
                    return v9;
                }
                if(x20.e(v2) >= 0) {
                    v2 = v + 9L;
                    this.g = v2;
                    return v9;
                }
                v2 = v + 10L;
                if(x20.e(v + 9L) >= 0) {
                    this.g = v2;
                    return v9;
                }
            }
        }
        return (int)this.M();
    }

    @Override  // com.google.protobuf.t
    public final int y() {
        return this.J();
    }

    @Override  // com.google.protobuf.t
    public final long z() {
        return this.K();
    }
}

