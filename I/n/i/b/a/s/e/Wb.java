package i.n.i.b.a.s.e;

import java.nio.charset.Charset;
import java.util.Arrays;
import va.e;

public final class wb {
    public byte[] a;
    public int b;
    public int c;
    public static final long[] d;

    static {
        wb.d = new long[]{0x80L, 0x40L, 0x20L, 16L, 8L, 4L, 2L, 1L};
    }

    public wb(int v) {
        this.a = new byte[v];
        this.c = v;
    }

    public wb(int v, boolean z) {
        if(v != 1) {
            super();
            this.a = new byte[8];
            return;
        }
        super();
        this.a = L7.g;
    }

    public wb(byte[] arr_b) {
        this.a = arr_b;
        this.c = arr_b.length;
    }

    public wb(byte[] arr_b, int v) {
        this.a = arr_b;
        this.c = v;
    }

    public long A() {
        int v = this.b;
        this.b = v + 4;
        return ((long)this.a[v + 3]) & 0xFFL | ((((long)this.a[v]) & 0xFFL) << 24 | (((long)this.a[v + 1]) & 0xFFL) << 16 | (((long)this.a[v + 2]) & 0xFFL) << 8);
    }

    public int B() {
        int v = this.b;
        this.b = v + 3;
        return this.a[v + 2] & 0xFF | ((this.a[v + 1] & 0xFF) << 8 | (this.a[v] & 0xFF) << 16);
    }

    public int C() {
        int v = this.p();
        if(v < 0) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public long a() {
        long v = this.w();
        if(v < 0L) {
            throw new IllegalStateException(e.a(v, "Top bit not zero: "));
        }
        return v;
    }

    public int b() {
        int v = this.b;
        this.b = v + 2;
        return this.a[v + 1] & 0xFF | (this.a[v] & 0xFF) << 8;
    }

    public long c() {
        int v3;
        int v2;
        long v = (long)this.a[this.b];
        int v1 = 7;
        while(true) {
            v2 = 1;
            if(v1 >= 0) {
                if((((long)(1 << v1)) & v) == 0L) {
                    if(v1 < 6) {
                        v &= (long)((1 << v1) - 1);
                        v3 = 7 - v1;
                        break;
                    }
                    if(v1 == 7) {
                        v3 = 1;
                        break;
                    }
                }
                else {
                    --v1;
                    continue;
                }
            }
            v3 = 0;
            break;
        }
        if(v3 == 0) {
            throw new NumberFormatException(e.a(v, "Invalid UTF-8 sequence first byte: "));
        }
        while(v2 < v3) {
            int v4 = this.a[this.b + v2];
            if((v4 & 0xC0) != 0x80) {
                throw new NumberFormatException(e.a(v, "Invalid UTF-8 sequence continuation byte: "));
            }
            v = v << 6 | ((long)(v4 & 0x3F));
            ++v2;
        }
        this.b += v3;
        return v;
    }

    public int d() {
        return this.c - this.b;
    }

    public long e(i5 i50, boolean z, boolean z1, int v) {
        int v3;
        byte[] arr_b = this.a;
        if(this.b == 0) {
            if(!i50.f(arr_b, 0, 1, z)) {
                return -1L;
            }
            int v1 = arr_b[0] & 0xFF;
            for(int v2 = 0; true; ++v2) {
                v3 = -1;
                if(v2 >= 8) {
                    break;
                }
                if((wb.d[v2] & ((long)v1)) != 0L) {
                    v3 = v2 + 1;
                    break;
                }
            }
            this.c = v3;
            if(v3 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.b = 1;
        }
        int v4 = this.c;
        if(v4 > v) {
            this.b = 0;
            return -2L;
        }
        if(v4 != 1) {
            i50.q(arr_b, 1, v4 - 1);
        }
        this.b = 0;
        return wb.f(arr_b, this.c, z1);
    }

    public static long f(byte[] arr_b, int v, boolean z) {
        long v1 = ((long)arr_b[0]) & 0xFFL;
        if(z) {
            v1 &= ~wb.d[v - 1];
        }
        for(int v2 = 1; v2 < v; ++v2) {
            v1 = v1 << 8 | ((long)arr_b[v2]) & 0xFFL;
        }
        return v1;
    }

    public String g(int v, Charset charset0) {
        String s = new String(this.a, this.b, v, charset0);
        this.b += v;
        return s;
    }

    public void h(int v) {
        byte[] arr_b = this.a;
        if(v > arr_b.length) {
            this.a = Arrays.copyOf(arr_b, v);
        }
    }

    public void i(int v, byte[] arr_b) {
        this.a = arr_b;
        this.c = v;
        this.b = 0;
    }

    public void j(byte[] arr_b, int v, int v1) {
        System.arraycopy(this.a, this.b, arr_b, v, v1);
        this.b += v1;
    }

    public String k(int v) {
        if(v == 0) {
            return "";
        }
        int v1 = this.b + v - 1;
        String s = new String(this.a, this.b, (v1 >= this.c || this.a[v1] != 0 ? v : v - 1), b9.c);
        this.b += v;
        return s;
    }

    public void l(int v) {
        this.i(v, (this.a.length >= v ? this.a : new byte[v]));
    }

    public void m(int v) {
        M7.u(v >= 0 && v <= this.a.length);
        this.c = v;
    }

    public void n(int v) {
        M7.u(v >= 0 && v <= this.c);
        this.b = v;
    }

    public void o(int v) {
        this.n(this.b + v);
    }

    public int p() {
        int v = this.b;
        this.b = v + 4;
        return this.a[v + 3] & 0xFF | ((this.a[v + 1] & 0xFF) << 16 | (this.a[v] & 0xFF) << 24 | (this.a[v + 2] & 0xFF) << 8);
    }

    public String q() {
        if(this.d() == 0) {
            return null;
        }
        int v = this.b;
    alab1:
        while(v < this.c) {
            switch(this.a[v]) {
                case 10: 
                case 13: {
                    break alab1;
                }
                default: {
                    ++v;
                }
            }
        }
        int v1 = this.b;
        if(v - v1 >= 3 && (this.a[v1] == -17 && this.a[v1 + 1] == -69 && this.a[v1 + 2] == -65)) {
            this.b = v1 + 3;
        }
        String s = new String(this.a, this.b, v - this.b, b9.c);
        this.b = v;
        int v2 = this.c;
        if(v != v2) {
            byte[] arr_b = this.a;
            if(arr_b[v] == 13) {
                this.b = v + 1;
                if(v + 1 != v2) {
                    goto label_18;
                }
            }
            else {
            label_18:
                int v3 = this.b;
                if(arr_b[v3] == 10) {
                    this.b = v3 + 1;
                }
            }
        }
        return s;
    }

    public int r() {
        int v = this.b;
        this.b = v + 4;
        return (this.a[v + 3] & 0xFF) << 24 | ((this.a[v + 1] & 0xFF) << 8 | this.a[v] & 0xFF | (this.a[v + 2] & 0xFF) << 16);
    }

    public short s() {
        int v = this.b;
        this.b = v + 2;
        return (short)((this.a[v + 1] & 0xFF) << 8 | this.a[v] & 0xFF);
    }

    public long t() {
        int v = this.b;
        this.b = v + 4;
        return (((long)this.a[v + 3]) & 0xFFL) << 24 | (((long)this.a[v]) & 0xFFL | (((long)this.a[v + 1]) & 0xFFL) << 8 | (((long)this.a[v + 2]) & 0xFFL) << 16);
    }

    public int u() {
        int v = this.r();
        if(v < 0) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public int v() {
        int v = this.b;
        this.b = v + 2;
        return (this.a[v + 1] & 0xFF) << 8 | this.a[v] & 0xFF;
    }

    public long w() {
        int v = this.b;
        this.b = v + 8;
        return ((long)this.a[v + 7]) & 0xFFL | ((((long)this.a[v]) & 0xFFL) << 56 | (((long)this.a[v + 1]) & 0xFFL) << 0x30 | (((long)this.a[v + 2]) & 0xFFL) << 40 | (((long)this.a[v + 3]) & 0xFFL) << 0x20 | (((long)this.a[v + 4]) & 0xFFL) << 24 | (((long)this.a[v + 5]) & 0xFFL) << 16 | (((long)this.a[v + 6]) & 0xFFL) << 8);
    }

    public String x() {
        if(this.d() == 0) {
            return null;
        }
        int v;
        for(v = this.b; v < this.c && this.a[v] != 0; ++v) {
        }
        String s = new String(this.a, this.b, v - this.b, b9.c);
        this.b = v;
        if(v < this.c) {
            this.b = v + 1;
        }
        return s;
    }

    public int y() {
        return this.z() << 21 | this.z() << 14 | this.z() << 7 | this.z();
    }

    public int z() {
        int v = this.b;
        this.b = v + 1;
        return this.a[v] & 0xFF;
    }
}

