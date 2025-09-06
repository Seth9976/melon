package androidx.glance.appwidget.protobuf;

import androidx.datastore.preferences.protobuf.m;
import java.io.InputStream;
import java.util.ArrayList;

public final class k extends m {
    public final InputStream c;
    public final byte[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public k(InputStream inputStream0) {
        this.j = 0x7FFFFFFF;
        B.a(inputStream0, "input");
        this.c = inputStream0;
        this.d = new byte[0x1000];
        this.e = 0;
        this.g = 0;
        this.i = 0;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int A() {
        if(this.c()) {
            this.h = 0;
            return 0;
        }
        int v = this.K();
        this.h = v;
        if(v >>> 3 == 0) {
            throw new D("Protocol message contained an invalid tag (zero).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        return v;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int B() {
        return this.K();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long C() {
        return this.L();
    }

    public final byte[] F(int v) {
        byte[] arr_b = this.G(v);
        if(arr_b != null) {
            return arr_b;
        }
        int v1 = this.g;
        int v2 = this.e - v1;
        this.i += this.e;
        this.g = 0;
        this.e = 0;
        ArrayList arrayList0 = this.H(v - v2);
        byte[] arr_b1 = new byte[v];
        System.arraycopy(this.d, v1, arr_b1, 0, v2);
        for(Object object0: arrayList0) {
            System.arraycopy(((byte[])object0), 0, arr_b1, v2, ((byte[])object0).length);
            v2 += ((byte[])object0).length;
        }
        return arr_b1;
    }

    public final byte[] G(int v) {
        int v7;
        if(v == 0) {
            return B.b;
        }
        if(v < 0) {
            throw D.d();
        }
        int v1 = this.i;
        int v2 = this.g;
        int v3 = v1 + v2 + v;
        if(v3 - 0x7FFFFFFF > 0) {
            throw new D("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v4 = this.j;
        if(v3 <= v4) {
            int v5 = this.e - v2;
            int v6 = v - v5;
            InputStream inputStream0 = this.c;
            if(v6 >= 0x1000) {
                try {
                    if(v6 > inputStream0.available()) {
                        return null;
                    }
                }
                catch(D d0) {
                    d0.a = true;
                    throw d0;
                }
            }
            byte[] arr_b = new byte[v];
            System.arraycopy(this.d, this.g, arr_b, 0, v5);
            this.i += this.e;
            this.g = 0;
            this.e = 0;
            while(v5 < v) {
                try {
                    v7 = inputStream0.read(arr_b, v5, v - v5);
                }
                catch(D d1) {
                    d1.a = true;
                    throw d1;
                }
                if(v7 == -1) {
                    throw D.e();
                }
                this.i += v7;
                v5 += v7;
            }
            return arr_b;
        }
        this.P(v4 - v1 - v2);
        throw D.e();
    }

    public final ArrayList H(int v) {
        ArrayList arrayList0 = new ArrayList();
        while(v > 0) {
            int v1 = Math.min(v, 0x1000);
            byte[] arr_b = new byte[v1];
            for(int v2 = 0; v2 < v1; v2 += v3) {
                int v3 = this.c.read(arr_b, v2, v1 - v2);
                if(v3 == -1) {
                    throw D.e();
                }
                this.i += v3;
            }
            v -= v1;
            arrayList0.add(arr_b);
        }
        return arrayList0;
    }

    public final int I() {
        int v = this.g;
        if(this.e - v < 4) {
            this.O(4);
            v = this.g;
        }
        this.g = v + 4;
        return (this.d[v + 3] & 0xFF) << 24 | (this.d[v] & 0xFF | (this.d[v + 1] & 0xFF) << 8 | (this.d[v + 2] & 0xFF) << 16);
    }

    public final long J() {
        int v = this.g;
        if(this.e - v < 8) {
            this.O(8);
            v = this.g;
        }
        this.g = v + 8;
        return (((long)this.d[v + 7]) & 0xFFL) << 56 | (((long)this.d[v]) & 0xFFL | (((long)this.d[v + 1]) & 0xFFL) << 8 | (((long)this.d[v + 2]) & 0xFFL) << 16 | (((long)this.d[v + 3]) & 0xFFL) << 24 | (((long)this.d[v + 4]) & 0xFFL) << 0x20 | (((long)this.d[v + 5]) & 0xFFL) << 40 | (((long)this.d[v + 6]) & 0xFFL) << 0x30);
    }

    public final int K() {
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
            if(this.g == this.e) {
                this.O(1);
            }
            int v2 = this.g;
            this.g = v2 + 1;
            int v3 = this.d[v2];
            v |= ((long)(v3 & 0x7F)) << v1;
            if((v3 & 0x80) == 0) {
                return v;
            }
        }
        throw D.c();
    }

    public final void N() {
        int v = this.e + this.f;
        this.e = v;
        int v1 = this.i + v;
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
        if(!this.Q(v)) {
            throw v <= 0x7FFFFFFF - this.i - this.g ? D.e() : new D("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
    }

    public final void P(int v) {
        int v12;
        long v9;
        int v1 = this.e;
        int v2 = this.g;
        if(v <= v1 - v2 && v >= 0) {
            this.g = v2 + v;
            return;
        }
        InputStream inputStream0 = this.c;
        if(v < 0) {
            throw D.d();
        }
        int v3 = this.i;
        int v4 = v3 + v2;
        int v5 = this.j;
        if(v4 + v <= v5) {
            this.i = v4;
            int v6 = v1 - v2;
            this.e = 0;
            this.g = 0;
            try {
                while(v6 < v) {
                    try {
                        long v8 = (long)(v - v6);
                        v9 = inputStream0.skip(v8);
                        int v10 = Long.compare(v9, 0L);
                    }
                    catch(D d0) {
                        d0.a = true;
                        throw d0;
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
                this.i += v6;
                this.N();
            }
            if(v6 < v) {
                int v11 = this.e - this.g;
                this.g = this.e;
                this.O(1);
                while(true) {
                    v12 = v - v11;
                    int v13 = this.e;
                    if(v12 <= v13) {
                        break;
                    }
                    v11 += v13;
                    this.g = v13;
                    this.O(1);
                }
                this.g = v12;
            }
            return;
        }
        this.P(v5 - v3 - v2);
        throw D.e();
    }

    public final boolean Q(int v) {
        int v3;
        InputStream inputStream0 = this.c;
        int v1 = this.g;
        int v2 = this.e;
        if(v1 + v <= v2) {
            throw new IllegalStateException("refillBuffer() called when " + v + " bytes were already available in buffer");
        }
        if(v <= 0x7FFFFFFF - this.i - v1 && this.i + v1 + v <= this.j) {
            byte[] arr_b = this.d;
            if(v1 > 0) {
                if(v2 > v1) {
                    System.arraycopy(arr_b, v1, arr_b, 0, v2 - v1);
                }
                this.i += v1;
                this.e -= v1;
                this.g = 0;
            }
            try {
                v3 = inputStream0.read(arr_b, this.e, Math.min(arr_b.length - this.e, 0x7FFFFFFF - this.i - this.e));
            }
            catch(D d0) {
                d0.a = true;
                throw d0;
            }
            if(v3 == 0 || v3 < -1 || v3 > arr_b.length) {
                throw new IllegalStateException(inputStream0.getClass() + "#read(byte[]) returned invalid result: " + v3 + "\nThe InputStream implementation is buggy.");
            }
            if(v3 > 0) {
                this.e += v3;
                this.N();
                return this.e < v ? this.Q(v) : true;
            }
        }
        return false;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void a(int v) {
        if(this.h != v) {
            throw new D("Protocol message end-group tag did not match expected tag.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int b() {
        return this.i + this.g;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final boolean c() {
        return this.g == this.e && !this.Q(1);
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void h(int v) {
        this.j = v;
        this.N();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int i(int v) {
        if(v < 0) {
            throw D.d();
        }
        int v1 = this.i + this.g + v;
        if(v1 < 0) {
            throw new D("Failed to parse the message.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v2 = this.j;
        if(v1 > v2) {
            throw D.e();
        }
        this.j = v1;
        this.N();
        return v2;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final boolean j() {
        return this.L() != 0L;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final h l() {
        int v = this.K();
        int v1 = this.g;
        byte[] arr_b = this.d;
        if(v <= this.e - v1 && v > 0) {
            h h0 = i.d(arr_b, v1, v);
            this.g += v;
            return h0;
        }
        if(v == 0) {
            return i.b;
        }
        if(v < 0) {
            throw D.d();
        }
        byte[] arr_b1 = this.G(v);
        if(arr_b1 != null) {
            return i.d(arr_b1, 0, arr_b1.length);
        }
        int v2 = this.g;
        int v3 = this.e - v2;
        this.i += this.e;
        this.g = 0;
        this.e = 0;
        ArrayList arrayList0 = this.H(v - v3);
        byte[] arr_b2 = new byte[v];
        System.arraycopy(arr_b, v2, arr_b2, 0, v3);
        for(Object object0: arrayList0) {
            System.arraycopy(((byte[])object0), 0, arr_b2, v3, ((byte[])object0).length);
            v3 += ((byte[])object0).length;
        }
        return new h(arr_b2);
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final double m() {
        return Double.longBitsToDouble(this.J());
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int n() {
        return this.K();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int o() {
        return this.I();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long p() {
        return this.J();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final float q() {
        return Float.intBitsToFloat(this.I());
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int r() {
        return this.K();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long t() {
        return this.L();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int u() {
        return this.I();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long v() {
        return this.J();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final int w() {
        int v = this.K();
        return -(v & 1) ^ v >>> 1;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final long x() {
        long v = this.L();
        return -(v & 1L) ^ v >>> 1;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final String y() {
        int v = this.K();
        byte[] arr_b = this.d;
        if(v > 0) {
            int v1 = this.g;
            if(v <= this.e - v1) {
                String s = new String(arr_b, v1, v, B.a);
                this.g += v;
                return s;
            }
        }
        if(v == 0) {
            return "";
        }
        if(v < 0) {
            throw D.d();
        }
        if(v <= this.e) {
            this.O(v);
            String s1 = new String(arr_b, this.g, v, B.a);
            this.g += v;
            return s1;
        }
        return new String(this.F(v), B.a);
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final String z() {
        int v = this.K();
        int v1 = this.g;
        int v2 = this.e;
        byte[] arr_b = this.d;
        if(v <= v2 - v1 && v > 0) {
            this.g = v1 + v;
            return l0.a.t(arr_b, v1, v);
        }
        if(v == 0) {
            return "";
        }
        if(v < 0) {
            throw D.d();
        }
        if(v <= v2) {
            this.O(v);
            this.g = v;
            return l0.a.t(arr_b, v1, v);
        }
        arr_b = this.F(v);
        return l0.a.t(arr_b, v1, v);
    }
}

