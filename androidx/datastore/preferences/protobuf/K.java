package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

public final class k extends m {
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public int h;
    public int i;

    public k(byte[] arr_b, int v, int v1, boolean z) {
        this.i = 0x7FFFFFFF;
        this.c = arr_b;
        this.d = v1 + v;
        this.f = v;
        this.g = v;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int A() {
        if(this.c()) {
            this.h = 0;
            return 0;
        }
        int v = this.H();
        this.h = v;
        if(v >>> 3 == 0) {
            throw new F("Protocol message contained an invalid tag (zero).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        return v;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int B() {
        return this.H();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long C() {
        return this.I();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final boolean D(int v) {
        int v1 = 0;
        switch(v & 7) {
            case 0: {
                byte[] arr_b = this.c;
                if(this.d - this.f >= 10) {
                    while(v1 < 10) {
                        int v2 = this.f;
                        this.f = v2 + 1;
                        if(arr_b[v2] >= 0) {
                            return true;
                        }
                        ++v1;
                    }
                    throw F.c();
                }
                while(v1 < 10) {
                    int v3 = this.f;
                    if(v3 == this.d) {
                        throw F.e();
                    }
                    this.f = v3 + 1;
                    if(arr_b[v3] >= 0) {
                        return true;
                    }
                    ++v1;
                }
                throw F.c();
            }
            case 1: {
                this.L(8);
                return true;
            }
            default: {
                if((v & 7) != 2) {
                    switch(v & 7) {
                        case 3: {
                            this.E();
                            this.a(v >>> 3 << 3 | 4);
                            return true;
                        }
                        case 4: {
                            return false;
                        }
                        default: {
                            if((v & 7) != 5) {
                                throw F.b();
                            }
                            this.L(4);
                            return true;
                        }
                    }
                }
                this.L(this.H());
                return true;
            }
        }
    }

    public final int F() {
        int v = this.f;
        if(this.d - v < 4) {
            throw F.e();
        }
        this.f = v + 4;
        return (this.c[v + 3] & 0xFF) << 24 | (this.c[v] & 0xFF | (this.c[v + 1] & 0xFF) << 8 | (this.c[v + 2] & 0xFF) << 16);
    }

    public final long G() {
        int v = this.f;
        if(this.d - v < 8) {
            throw F.e();
        }
        this.f = v + 8;
        return (((long)this.c[v + 7]) & 0xFFL) << 56 | (((long)this.c[v]) & 0xFFL | (((long)this.c[v + 1]) & 0xFFL) << 8 | (((long)this.c[v + 2]) & 0xFFL) << 16 | (((long)this.c[v + 3]) & 0xFFL) << 24 | (((long)this.c[v + 4]) & 0xFFL) << 0x20 | (((long)this.c[v + 5]) & 0xFFL) << 40 | (((long)this.c[v + 6]) & 0xFFL) << 0x30);
    }

    public final int H() {
        int v5;
        int v = this.f;
        int v1 = this.d;
        if(v1 != v) {
            byte[] arr_b = this.c;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.f = v + 1;
                return v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(v4 < 0) {
                    v5 = v4 ^ 0xFFFFFF80;
                    this.f = v3;
                    return v5;
                }
                int v6 = v + 3;
                int v7 = arr_b[v3] << 14 ^ v4;
                if(v7 >= 0) {
                    v5 = v7 ^ 0x3F80;
                    v3 = v6;
                    this.f = v3;
                    return v5;
                }
                int v8 = v + 4;
                int v9 = v7 ^ arr_b[v6] << 21;
                if(v9 < 0) {
                    v5 = 0xFFE03F80 ^ v9;
                    v3 = v8;
                    this.f = v3;
                    return v5;
                }
                v6 = v + 5;
                int v10 = arr_b[v8];
                int v11 = v9 ^ v10 << 28 ^ 0xFE03F80;
                if(v10 >= 0) {
                    v3 = v6;
                    this.f = v3;
                    return v11;
                }
                v8 = v + 6;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.f = v3;
                    return v11;
                }
                v6 = v + 7;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.f = v3;
                    return v11;
                }
                v8 = v + 8;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.f = v3;
                    return v11;
                }
                v6 = v + 9;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.f = v3;
                    return v11;
                }
                else if(arr_b[v6] >= 0) {
                    v3 = v + 10;
                    this.f = v3;
                    return v11;
                }
            }
        }
        return (int)this.J();
    }

    public final long I() {
        long v13;
        long v11;
        long v9;
        long v5;
        int v = this.f;
        int v1 = this.d;
        if(v1 != v) {
            byte[] arr_b = this.c;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.f = v + 1;
                return (long)v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(v4 < 0) {
                    v5 = (long)(v4 ^ 0xFFFFFF80);
                    this.f = v3;
                    return v5;
                }
                int v6 = arr_b[v3] << 14 ^ v4;
                if(v6 >= 0) {
                    v5 = (long)(v6 ^ 0x3F80);
                    v3 = v + 3;
                    this.f = v3;
                    return v5;
                }
                int v7 = v + 4;
                int v8 = v6 ^ arr_b[v + 3] << 21;
                if(v8 < 0) {
                    v9 = (long)(0xFFE03F80 ^ v8);
                    v3 = v7;
                    this.f = v3;
                    return v9;
                }
                v3 = v + 5;
                long v10 = ((long)v8) ^ ((long)arr_b[v7]) << 28;
                if(v10 >= 0L) {
                    v11 = 0xFE03F80L;
                    v5 = v11 ^ v10;
                    this.f = v3;
                    return v5;
                }
                v7 = v + 6;
                long v12 = v10 ^ ((long)arr_b[v3]) << 35;
                if(v12 < 0L) {
                    v13 = 0xFFFFFFF80FE03F80L;
                    v9 = v13 ^ v12;
                    v3 = v7;
                    this.f = v3;
                    return v9;
                }
                v3 = v + 7;
                v10 = v12 ^ ((long)arr_b[v7]) << 42;
                if(v10 >= 0L) {
                    v11 = 0x3F80FE03F80L;
                    v5 = v11 ^ v10;
                    this.f = v3;
                    return v5;
                }
                v7 = v + 8;
                v12 = v10 ^ ((long)arr_b[v3]) << 49;
                if(v12 < 0L) {
                    v13 = 0xFFFE03F80FE03F80L;
                    v9 = v13 ^ v12;
                    v3 = v7;
                    this.f = v3;
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
                    this.f = v3;
                    return v14;
                }
            }
        }
        return this.J();
    }

    public final long J() {
        long v = 0L;
        for(int v1 = 0; v1 < 0x40; v1 += 7) {
            int v2 = this.f;
            if(v2 == this.d) {
                throw F.e();
            }
            this.f = v2 + 1;
            int v3 = this.c[v2];
            v |= ((long)(v3 & 0x7F)) << v1;
            if((v3 & 0x80) == 0) {
                return v;
            }
        }
        throw F.c();
    }

    public final void K() {
        int v = this.d + this.e;
        this.d = v;
        int v1 = v - this.g;
        int v2 = this.i;
        if(v1 > v2) {
            int v3 = v1 - v2;
            this.e = v3;
            this.d = v - v3;
            return;
        }
        this.e = 0;
    }

    public final void L(int v) {
        if(v >= 0) {
            int v1 = this.f;
            if(v <= this.d - v1) {
                this.f = v1 + v;
                return;
            }
        }
        throw v >= 0 ? F.e() : F.d();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void a(int v) {
        if(this.h != v) {
            throw new F("Protocol message end-group tag did not match expected tag.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int b() {
        return this.f - this.g;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final boolean c() {
        return this.f == this.d;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void h(int v) {
        this.i = v;
        this.K();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int i(int v) {
        if(v < 0) {
            throw F.d();
        }
        int v1 = this.b() + v;
        if(v1 < 0) {
            throw new F("Failed to parse the message.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v2 = this.i;
        if(v1 > v2) {
            throw F.e();
        }
        this.i = v1;
        this.K();
        return v2;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final boolean j() {
        return this.I() != 0L;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final i k() {
        int v = this.H();
        byte[] arr_b = this.c;
        if(v > 0) {
            int v1 = this.f;
            if(v <= this.d - v1) {
                i i0 = j.d(arr_b, v1, v);
                this.f += v;
                return i0;
            }
        }
        if(v == 0) {
            return j.b;
        }
        if(v > 0) {
            int v2 = this.f;
            if(v <= this.d - v2) {
                int v3 = v + v2;
                this.f = v3;
                return new i(Arrays.copyOfRange(arr_b, v2, v3));
            }
        }
        throw v > 0 ? F.e() : F.d();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final double m() {
        return Double.longBitsToDouble(this.G());
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int n() {
        return this.H();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int o() {
        return this.F();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long p() {
        return this.G();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final float q() {
        return Float.intBitsToFloat(this.F());
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int r() {
        return this.H();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long t() {
        return this.I();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int u() {
        return this.F();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long v() {
        return this.G();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int w() {
        int v = this.H();
        return -(v & 1) ^ v >>> 1;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long x() {
        long v = this.I();
        return -(v & 1L) ^ v >>> 1;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final String y() {
        int v = this.H();
        if(v > 0) {
            int v1 = this.f;
            if(v <= this.d - v1) {
                String s = new String(this.c, v1, v, D.a);
                this.f += v;
                return s;
            }
        }
        if(v != 0) {
            throw v >= 0 ? F.e() : F.d();
        }
        return "";
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final String z() {
        int v = this.H();
        if(v > 0) {
            int v1 = this.f;
            if(v <= this.d - v1) {
                String s = u0.a.B(this.c, v1, v);
                this.f += v;
                return s;
            }
        }
        if(v != 0) {
            throw v > 0 ? F.e() : F.d();
        }
        return "";
    }
}

