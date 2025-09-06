package com.google.protobuf;

import java.util.Arrays;

public final class q extends t {
    public final byte[] d;
    public int e;
    public int f;
    public int g;
    public final int h;
    public int i;
    public int j;

    public q(byte[] arr_b, int v, int v1, boolean z) {
        this.j = 0x7FFFFFFF;
        this.d = arr_b;
        this.e = v1 + v;
        this.g = v;
        this.h = v;
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
            int v1 = this.g;
            if(v <= this.e - v1) {
                String s = new String(this.d, v1, v, P1.a);
                this.g += v;
                return s;
            }
        }
        if(v != 0) {
            throw v >= 0 ? R1.h() : R1.f();
        }
        return "";
    }

    @Override  // com.google.protobuf.t
    public final String D() {
        int v = this.w();
        if(v > 0) {
            int v1 = this.g;
            if(v <= this.e - v1) {
                String s = b3.a.t(this.d, v1, v);
                this.g += v;
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
            this.i = 0;
            return 0;
        }
        int v = this.w();
        this.i = v;
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
                byte[] arr_b = this.d;
                if(this.e - this.g >= 10) {
                    while(v1 < 10) {
                        int v2 = this.g;
                        this.g = v2 + 1;
                        if(arr_b[v2] >= 0) {
                            return true;
                        }
                        ++v1;
                    }
                    throw R1.e();
                }
                while(v1 < 10) {
                    int v3 = this.g;
                    if(v3 == this.e) {
                        throw R1.h();
                    }
                    this.g = v3 + 1;
                    if(arr_b[v3] >= 0) {
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
        int v = this.g;
        if(this.e - v < 4) {
            throw R1.h();
        }
        this.g = v + 4;
        return (this.d[v + 3] & 0xFF) << 24 | (this.d[v] & 0xFF | (this.d[v + 1] & 0xFF) << 8 | (this.d[v + 2] & 0xFF) << 16);
    }

    public final long K() {
        int v = this.g;
        if(this.e - v < 8) {
            throw R1.h();
        }
        this.g = v + 8;
        return (((long)this.d[v + 7]) & 0xFFL) << 56 | (((long)this.d[v]) & 0xFFL | (((long)this.d[v + 1]) & 0xFFL) << 8 | (((long)this.d[v + 2]) & 0xFFL) << 16 | (((long)this.d[v + 3]) & 0xFFL) << 24 | (((long)this.d[v + 4]) & 0xFFL) << 0x20 | (((long)this.d[v + 5]) & 0xFFL) << 40 | (((long)this.d[v + 6]) & 0xFFL) << 0x30);
    }

    public final long L() {
        long v13;
        long v11;
        long v9;
        long v5;
        int v = this.g;
        int v1 = this.e;
        if(v1 != v) {
            byte[] arr_b = this.d;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.g = v + 1;
                return (long)v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(v4 < 0) {
                    v5 = (long)(v4 ^ 0xFFFFFF80);
                    this.g = v3;
                    return v5;
                }
                int v6 = arr_b[v3] << 14 ^ v4;
                if(v6 >= 0) {
                    v5 = (long)(v6 ^ 0x3F80);
                    v3 = v + 3;
                    this.g = v3;
                    return v5;
                }
                int v7 = v + 4;
                int v8 = v6 ^ arr_b[v + 3] << 21;
                if(v8 < 0) {
                    v9 = (long)(0xFFE03F80 ^ v8);
                    v3 = v7;
                    this.g = v3;
                    return v9;
                }
                v3 = v + 5;
                long v10 = ((long)v8) ^ ((long)arr_b[v7]) << 28;
                if(v10 >= 0L) {
                    v11 = 0xFE03F80L;
                    v5 = v11 ^ v10;
                    this.g = v3;
                    return v5;
                }
                v7 = v + 6;
                long v12 = v10 ^ ((long)arr_b[v3]) << 35;
                if(v12 < 0L) {
                    v13 = 0xFFFFFFF80FE03F80L;
                    v9 = v13 ^ v12;
                    v3 = v7;
                    this.g = v3;
                    return v9;
                }
                v3 = v + 7;
                v10 = v12 ^ ((long)arr_b[v7]) << 42;
                if(v10 >= 0L) {
                    v11 = 0x3F80FE03F80L;
                    v5 = v11 ^ v10;
                    this.g = v3;
                    return v5;
                }
                v7 = v + 8;
                v12 = v10 ^ ((long)arr_b[v3]) << 49;
                if(v12 < 0L) {
                    v13 = 0xFFFE03F80FE03F80L;
                    v9 = v13 ^ v12;
                    v3 = v7;
                    this.g = v3;
                    return v9;
                }
                v3 = v + 9;
                long v14 = v12 ^ ((long)arr_b[v7]) << 56 ^ 0xFE03F80FE03F80L;
                boolean z = false;
                if(v14 >= 0L) {
                    z = true;
                }
                else if(((long)arr_b[v3]) >= 0L) {
                    z = true;
                    v3 = v + 10;
                }
                if(z) {
                    this.g = v3;
                    return v14;
                }
            }
        }
        return this.M();
    }

    public final long M() {
        long v = 0L;
        for(int v1 = 0; v1 < 0x40; v1 += 7) {
            int v2 = this.g;
            if(v2 == this.e) {
                throw R1.h();
            }
            this.g = v2 + 1;
            int v3 = this.d[v2];
            v |= ((long)(v3 & 0x7F)) << v1;
            if((v3 & 0x80) == 0) {
                return v;
            }
        }
        throw R1.e();
    }

    public final void N() {
        int v = this.e + this.f;
        this.e = v;
        int v1 = v - this.h;
        int v2 = this.j;
        if(v1 > v2) {
            int v3 = v1 - v2;
            this.f = v3;
            this.e = v - v3;
            return;
        }
        this.f = 0;
    }

    public final void O(int v) {
        if(v >= 0) {
            int v1 = this.g;
            if(v <= this.e - v1) {
                this.g = v1 + v;
                return;
            }
        }
        throw v >= 0 ? R1.h() : R1.f();
    }

    @Override  // com.google.protobuf.t
    public final void a(int v) {
        if(this.i != v) {
            throw R1.a();
        }
    }

    @Override  // com.google.protobuf.t
    public final int e() {
        return this.j == 0x7FFFFFFF ? -1 : this.j - this.f();
    }

    @Override  // com.google.protobuf.t
    public final int f() {
        return this.g - this.h;
    }

    @Override  // com.google.protobuf.t
    public final boolean g() {
        return this.g == this.e;
    }

    @Override  // com.google.protobuf.t
    public final void j(int v) {
        this.j = v;
        this.N();
    }

    @Override  // com.google.protobuf.t
    public final int k(int v) {
        if(v < 0) {
            throw R1.f();
        }
        int v1 = this.f() + v;
        if(v1 < 0) {
            throw new R1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v2 = this.j;
        if(v1 > v2) {
            throw R1.h();
        }
        this.j = v1;
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
        byte[] arr_b = this.d;
        if(v > 0) {
            int v1 = this.g;
            if(v <= this.e - v1) {
                n n0 = o.d(arr_b, v1, v);
                this.g += v;
                return n0;
            }
        }
        if(v == 0) {
            return o.b;
        }
        if(v > 0) {
            int v2 = this.g;
            if(v <= this.e - v2) {
                int v3 = v + v2;
                this.g = v3;
                return new n(Arrays.copyOfRange(arr_b, v2, v3));
            }
        }
        throw v > 0 ? R1.h() : R1.f();
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
        int v5;
        int v = this.g;
        int v1 = this.e;
        if(v1 != v) {
            byte[] arr_b = this.d;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.g = v + 1;
                return v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(v4 < 0) {
                    v5 = v4 ^ 0xFFFFFF80;
                    this.g = v3;
                    return v5;
                }
                int v6 = v + 3;
                int v7 = arr_b[v3] << 14 ^ v4;
                if(v7 >= 0) {
                    v5 = v7 ^ 0x3F80;
                    v3 = v6;
                    this.g = v3;
                    return v5;
                }
                int v8 = v + 4;
                int v9 = v7 ^ arr_b[v6] << 21;
                if(v9 < 0) {
                    v5 = 0xFFE03F80 ^ v9;
                    v3 = v8;
                    this.g = v3;
                    return v5;
                }
                v6 = v + 5;
                int v10 = arr_b[v8];
                int v11 = v9 ^ v10 << 28 ^ 0xFE03F80;
                if(v10 >= 0) {
                    v3 = v6;
                    this.g = v3;
                    return v11;
                }
                v8 = v + 6;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.g = v3;
                    return v11;
                }
                v6 = v + 7;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.g = v3;
                    return v11;
                }
                v8 = v + 8;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.g = v3;
                    return v11;
                }
                v6 = v + 9;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.g = v3;
                    return v11;
                }
                else if(arr_b[v6] >= 0) {
                    v3 = v + 10;
                    this.g = v3;
                    return v11;
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

