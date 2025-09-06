package com.google.protobuf;

import java.io.InputStream;
import java.util.ArrayList;

public final class r extends t {
    public final InputStream d;
    public final byte[] e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    public r(InputStream inputStream0) {
        this.k = 0x7FFFFFFF;
        P1.a(inputStream0, "input");
        this.d = inputStream0;
        this.e = new byte[0x1000];
        this.f = 0;
        this.h = 0;
        this.j = 0;
    }

    @Override  // com.google.protobuf.t
    public final int A() {
        return t.c(this.w());
    }

    @Override  // com.google.protobuf.t
    public final long B() {
        return t.d(this.O());
    }

    @Override  // com.google.protobuf.t
    public final String C() {
        int v = this.w();
        byte[] arr_b = this.e;
        if(v > 0) {
            int v1 = this.h;
            if(v <= this.f - v1) {
                String s = new String(arr_b, v1, v, P1.a);
                this.h += v;
                return s;
            }
        }
        if(v == 0) {
            return "";
        }
        if(v < 0) {
            throw R1.f();
        }
        if(v <= this.f) {
            this.R(v);
            String s1 = new String(arr_b, this.h, v, P1.a);
            this.h += v;
            return s1;
        }
        return new String(this.J(v), P1.a);
    }

    @Override  // com.google.protobuf.t
    public final String D() {
        int v = this.w();
        int v1 = this.h;
        int v2 = this.f;
        byte[] arr_b = this.e;
        if(v <= v2 - v1 && v > 0) {
            this.h = v1 + v;
            return b3.a.t(arr_b, v1, v);
        }
        if(v == 0) {
            return "";
        }
        if(v < 0) {
            throw R1.f();
        }
        if(v <= v2) {
            this.R(v);
            this.h = v;
            return b3.a.t(arr_b, v1, v);
        }
        arr_b = this.J(v);
        return b3.a.t(arr_b, v1, v);
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
        return this.O();
    }

    @Override  // com.google.protobuf.t
    public final boolean H(int v) {
        int v1 = 0;
        switch(v & 7) {
            case 0: {
                byte[] arr_b = this.e;
                if(this.f - this.h >= 10) {
                    while(v1 < 10) {
                        int v2 = this.h;
                        this.h = v2 + 1;
                        if(arr_b[v2] >= 0) {
                            return true;
                        }
                        ++v1;
                    }
                    throw R1.e();
                }
                while(v1 < 10) {
                    if(this.h == this.f) {
                        this.R(1);
                    }
                    int v3 = this.h;
                    this.h = v3 + 1;
                    if(arr_b[v3] >= 0) {
                        return true;
                    }
                    ++v1;
                }
                throw R1.e();
            }
            case 1: {
                this.S(8);
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
                            this.S(4);
                            return true;
                        }
                    }
                }
                this.S(this.w());
                return true;
            }
        }
    }

    public final byte[] J(int v) {
        byte[] arr_b = this.K(v);
        if(arr_b != null) {
            return arr_b;
        }
        int v1 = this.h;
        int v2 = this.f - v1;
        this.j += this.f;
        this.h = 0;
        this.f = 0;
        ArrayList arrayList0 = this.L(v - v2);
        byte[] arr_b1 = new byte[v];
        System.arraycopy(this.e, v1, arr_b1, 0, v2);
        for(Object object0: arrayList0) {
            System.arraycopy(((byte[])object0), 0, arr_b1, v2, ((byte[])object0).length);
            v2 += ((byte[])object0).length;
        }
        return arr_b1;
    }

    public final byte[] K(int v) {
        int v7;
        if(v == 0) {
            return P1.b;
        }
        if(v < 0) {
            throw R1.f();
        }
        int v1 = this.j;
        int v2 = this.h;
        int v3 = v1 + v2 + v;
        if(v3 - 0x7FFFFFFF > 0) {
            throw new R1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v4 = this.k;
        if(v3 <= v4) {
            int v5 = this.f - v2;
            int v6 = v - v5;
            InputStream inputStream0 = this.d;
            if(v6 >= 0x1000) {
                try {
                    if(v6 > inputStream0.available()) {
                        return null;
                    }
                }
                catch(R1 r10) {
                    r10.a = true;
                    throw r10;
                }
            }
            byte[] arr_b = new byte[v];
            System.arraycopy(this.e, this.h, arr_b, 0, v5);
            this.j += this.f;
            this.h = 0;
            this.f = 0;
            while(v5 < v) {
                try {
                    v7 = inputStream0.read(arr_b, v5, v - v5);
                }
                catch(R1 r11) {
                    r11.a = true;
                    throw r11;
                }
                if(v7 == -1) {
                    throw R1.h();
                }
                this.j += v7;
                v5 += v7;
            }
            return arr_b;
        }
        this.S(v4 - v1 - v2);
        throw R1.h();
    }

    public final ArrayList L(int v) {
        ArrayList arrayList0 = new ArrayList();
        while(v > 0) {
            int v1 = Math.min(v, 0x1000);
            byte[] arr_b = new byte[v1];
            for(int v2 = 0; v2 < v1; v2 += v3) {
                int v3 = this.d.read(arr_b, v2, v1 - v2);
                if(v3 == -1) {
                    throw R1.h();
                }
                this.j += v3;
            }
            v -= v1;
            arrayList0.add(arr_b);
        }
        return arrayList0;
    }

    public final int M() {
        int v = this.h;
        if(this.f - v < 4) {
            this.R(4);
            v = this.h;
        }
        this.h = v + 4;
        return (this.e[v + 3] & 0xFF) << 24 | (this.e[v] & 0xFF | (this.e[v + 1] & 0xFF) << 8 | (this.e[v + 2] & 0xFF) << 16);
    }

    public final long N() {
        int v = this.h;
        if(this.f - v < 8) {
            this.R(8);
            v = this.h;
        }
        this.h = v + 8;
        return (((long)this.e[v + 7]) & 0xFFL) << 56 | (((long)this.e[v]) & 0xFFL | (((long)this.e[v + 1]) & 0xFFL) << 8 | (((long)this.e[v + 2]) & 0xFFL) << 16 | (((long)this.e[v + 3]) & 0xFFL) << 24 | (((long)this.e[v + 4]) & 0xFFL) << 0x20 | (((long)this.e[v + 5]) & 0xFFL) << 40 | (((long)this.e[v + 6]) & 0xFFL) << 0x30);
    }

    public final long O() {
        long v13;
        long v11;
        long v9;
        long v5;
        int v = this.h;
        int v1 = this.f;
        if(v1 != v) {
            byte[] arr_b = this.e;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.h = v + 1;
                return (long)v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(v4 < 0) {
                    v5 = (long)(v4 ^ 0xFFFFFF80);
                    this.h = v3;
                    return v5;
                }
                int v6 = arr_b[v3] << 14 ^ v4;
                if(v6 >= 0) {
                    v5 = (long)(v6 ^ 0x3F80);
                    v3 = v + 3;
                    this.h = v3;
                    return v5;
                }
                int v7 = v + 4;
                int v8 = v6 ^ arr_b[v + 3] << 21;
                if(v8 < 0) {
                    v9 = (long)(0xFFE03F80 ^ v8);
                    v3 = v7;
                    this.h = v3;
                    return v9;
                }
                v3 = v + 5;
                long v10 = ((long)v8) ^ ((long)arr_b[v7]) << 28;
                if(v10 >= 0L) {
                    v11 = 0xFE03F80L;
                    v5 = v11 ^ v10;
                    this.h = v3;
                    return v5;
                }
                v7 = v + 6;
                long v12 = v10 ^ ((long)arr_b[v3]) << 35;
                if(v12 < 0L) {
                    v13 = 0xFFFFFFF80FE03F80L;
                    v9 = v13 ^ v12;
                    v3 = v7;
                    this.h = v3;
                    return v9;
                }
                v3 = v + 7;
                v10 = v12 ^ ((long)arr_b[v7]) << 42;
                if(v10 >= 0L) {
                    v11 = 0x3F80FE03F80L;
                    v5 = v11 ^ v10;
                    this.h = v3;
                    return v5;
                }
                v7 = v + 8;
                v12 = v10 ^ ((long)arr_b[v3]) << 49;
                if(v12 < 0L) {
                    v13 = 0xFFFE03F80FE03F80L;
                    v9 = v13 ^ v12;
                    v3 = v7;
                    this.h = v3;
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
                    this.h = v3;
                    return v14;
                }
            }
        }
        return this.P();
    }

    public final long P() {
        long v = 0L;
        for(int v1 = 0; v1 < 0x40; v1 += 7) {
            if(this.h == this.f) {
                this.R(1);
            }
            int v2 = this.h;
            this.h = v2 + 1;
            int v3 = this.e[v2];
            v |= ((long)(v3 & 0x7F)) << v1;
            if((v3 & 0x80) == 0) {
                return v;
            }
        }
        throw R1.e();
    }

    public final void Q() {
        int v = this.f + this.g;
        this.f = v;
        int v1 = this.j + v;
        int v2 = this.k;
        if(v1 > v2) {
            int v3 = v1 - v2;
            this.g = v3;
            this.f = v - v3;
            return;
        }
        this.g = 0;
    }

    public final void R(int v) {
        if(!this.T(v)) {
            throw v <= 0x7FFFFFFF - this.j - this.h ? R1.h() : new R1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
    }

    public final void S(int v) {
        int v12;
        long v9;
        int v1 = this.f;
        int v2 = this.h;
        if(v <= v1 - v2 && v >= 0) {
            this.h = v2 + v;
            return;
        }
        InputStream inputStream0 = this.d;
        if(v < 0) {
            throw R1.f();
        }
        int v3 = this.j;
        int v4 = v3 + v2;
        int v5 = this.k;
        if(v4 + v <= v5) {
            this.j = v4;
            int v6 = v1 - v2;
            this.f = 0;
            this.h = 0;
            try {
                while(v6 < v) {
                    try {
                        long v8 = (long)(v - v6);
                        v9 = inputStream0.skip(v8);
                        int v10 = Long.compare(v9, 0L);
                    }
                    catch(R1 r10) {
                        r10.a = true;
                        throw r10;
                    }
                    if(v10 < 0 || v9 > v8) {
                        throw new IllegalStateException(inputStream0.getClass() + "#skip returned invalid result: " + v9 + "\nThe InputStream implementation is buggy.");
                    }
                    if(v10 == 0) {
                        break;
                    }
                    v6 += (int)v9;
                }
            }
            finally {
                this.j += v6;
                this.Q();
            }
            if(v6 < v) {
                int v11 = this.f - this.h;
                this.h = this.f;
                this.R(1);
                while(true) {
                    v12 = v - v11;
                    int v13 = this.f;
                    if(v12 <= v13) {
                        break;
                    }
                    v11 += v13;
                    this.h = v13;
                    this.R(1);
                }
                this.h = v12;
            }
            return;
        }
        this.S(v5 - v3 - v2);
        throw R1.h();
    }

    public final boolean T(int v) {
        int v3;
        InputStream inputStream0 = this.d;
        int v1 = this.h;
        int v2 = this.f;
        if(v1 + v <= v2) {
            throw new IllegalStateException("refillBuffer() called when " + v + " bytes were already available in buffer");
        }
        if(v <= 0x7FFFFFFF - this.j - v1 && this.j + v1 + v <= this.k) {
            byte[] arr_b = this.e;
            if(v1 > 0) {
                if(v2 > v1) {
                    System.arraycopy(arr_b, v1, arr_b, 0, v2 - v1);
                }
                this.j += v1;
                this.f -= v1;
                this.h = 0;
            }
            try {
                v3 = inputStream0.read(arr_b, this.f, Math.min(arr_b.length - this.f, 0x7FFFFFFF - this.j - this.f));
            }
            catch(R1 r10) {
                r10.a = true;
                throw r10;
            }
            if(v3 == 0 || v3 < -1 || v3 > arr_b.length) {
                throw new IllegalStateException(inputStream0.getClass() + "#read(byte[]) returned invalid result: " + v3 + "\nThe InputStream implementation is buggy.");
            }
            if(v3 > 0) {
                this.f += v3;
                this.Q();
                return this.f < v ? this.T(v) : true;
            }
        }
        return false;
    }

    @Override  // com.google.protobuf.t
    public final void a(int v) {
        if(this.i != v) {
            throw R1.a();
        }
    }

    @Override  // com.google.protobuf.t
    public final int e() {
        return this.k == 0x7FFFFFFF ? -1 : this.k - (this.j + this.h);
    }

    @Override  // com.google.protobuf.t
    public final int f() {
        return this.j + this.h;
    }

    @Override  // com.google.protobuf.t
    public final boolean g() {
        return this.h == this.f && !this.T(1);
    }

    @Override  // com.google.protobuf.t
    public final void j(int v) {
        this.k = v;
        this.Q();
    }

    @Override  // com.google.protobuf.t
    public final int k(int v) {
        if(v < 0) {
            throw R1.f();
        }
        int v1 = this.j + this.h + v;
        if(v1 < 0) {
            throw new R1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v2 = this.k;
        if(v1 > v2) {
            throw R1.h();
        }
        this.k = v1;
        this.Q();
        return v2;
    }

    @Override  // com.google.protobuf.t
    public final boolean l() {
        return this.O() != 0L;
    }

    @Override  // com.google.protobuf.t
    public final n m() {
        int v = this.w();
        int v1 = this.h;
        byte[] arr_b = this.e;
        if(v <= this.f - v1 && v > 0) {
            n n0 = o.d(arr_b, v1, v);
            this.h += v;
            return n0;
        }
        if(v == 0) {
            return o.b;
        }
        if(v < 0) {
            throw R1.f();
        }
        byte[] arr_b1 = this.K(v);
        if(arr_b1 != null) {
            return o.d(arr_b1, 0, arr_b1.length);
        }
        int v2 = this.h;
        int v3 = this.f - v2;
        this.j += this.f;
        this.h = 0;
        this.f = 0;
        ArrayList arrayList0 = this.L(v - v3);
        byte[] arr_b2 = new byte[v];
        System.arraycopy(arr_b, v2, arr_b2, 0, v3);
        for(Object object0: arrayList0) {
            System.arraycopy(((byte[])object0), 0, arr_b2, v3, ((byte[])object0).length);
            v3 += ((byte[])object0).length;
        }
        return new n(arr_b2);
    }

    @Override  // com.google.protobuf.t
    public final double n() {
        return Double.longBitsToDouble(this.N());
    }

    @Override  // com.google.protobuf.t
    public final int o() {
        return this.w();
    }

    @Override  // com.google.protobuf.t
    public final int p() {
        return this.M();
    }

    @Override  // com.google.protobuf.t
    public final long q() {
        return this.N();
    }

    @Override  // com.google.protobuf.t
    public final float r() {
        return Float.intBitsToFloat(this.M());
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
        return this.O();
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
        int v = this.h;
        int v1 = this.f;
        if(v1 != v) {
            byte[] arr_b = this.e;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.h = v + 1;
                return v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(v4 < 0) {
                    v5 = v4 ^ 0xFFFFFF80;
                    this.h = v3;
                    return v5;
                }
                int v6 = v + 3;
                int v7 = arr_b[v3] << 14 ^ v4;
                if(v7 >= 0) {
                    v5 = v7 ^ 0x3F80;
                    v3 = v6;
                    this.h = v3;
                    return v5;
                }
                int v8 = v + 4;
                int v9 = v7 ^ arr_b[v6] << 21;
                if(v9 < 0) {
                    v5 = 0xFFE03F80 ^ v9;
                    v3 = v8;
                    this.h = v3;
                    return v5;
                }
                v6 = v + 5;
                int v10 = arr_b[v8];
                int v11 = v9 ^ v10 << 28 ^ 0xFE03F80;
                if(v10 >= 0) {
                    v3 = v6;
                    this.h = v3;
                    return v11;
                }
                v8 = v + 6;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.h = v3;
                    return v11;
                }
                v6 = v + 7;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.h = v3;
                    return v11;
                }
                v8 = v + 8;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.h = v3;
                    return v11;
                }
                v6 = v + 9;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.h = v3;
                    return v11;
                }
                else if(arr_b[v6] >= 0) {
                    v3 = v + 10;
                    this.h = v3;
                    return v11;
                }
            }
        }
        return (int)this.P();
    }

    @Override  // com.google.protobuf.t
    public final int y() {
        return this.M();
    }

    @Override  // com.google.protobuf.t
    public final long z() {
        return this.N();
    }
}

