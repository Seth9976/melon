package e3;

import I6.b0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import va.e;
import y5.a;

public final class p {
    public byte[] a;
    public int b;
    public int c;
    public static final char[] d;
    public static final char[] e;
    public static final b0 f;

    static {
        p.d = new char[]{'\r', '\n'};
        p.e = new char[]{'\n'};
        p.f = b0.o(5, new Object[]{StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE});
    }

    public p() {
        this.a = x.f;
    }

    public p(int v) {
        this.a = new byte[v];
        this.c = v;
    }

    public p(byte[] arr_b) {
        this.a = arr_b;
        this.c = arr_b.length;
    }

    public p(byte[] arr_b, int v) {
        this.a = arr_b;
        this.c = v;
    }

    public final int A() {
        int v = this.b;
        this.b = v + 2;
        return this.a[v + 1] & 0xFF | (this.a[v] & 0xFF) << 8;
    }

    public final long B() {
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

    public final Charset C() {
        if(this.a() >= 3) {
            int v = this.b;
            if(this.a[v] == -17 && this.a[v + 1] == -69 && this.a[v + 2] == -65) {
                this.b = v + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if(this.a() >= 2) {
            byte[] arr_b = this.a;
            int v1 = this.b;
            int v2 = arr_b[v1];
            if(v2 == -2 && arr_b[v1 + 1] == -1) {
                this.b = v1 + 2;
                return StandardCharsets.UTF_16BE;
            }
            if(v2 == -1 && arr_b[v1 + 1] == -2) {
                this.b = v1 + 2;
                return StandardCharsets.UTF_16LE;
            }
        }
        return null;
    }

    public final void D(int v) {
        this.E((this.a.length >= v ? this.a : new byte[v]), v);
    }

    public final void E(byte[] arr_b, int v) {
        this.a = arr_b;
        this.c = v;
        this.b = 0;
    }

    public final void F(int v) {
        b.c(v >= 0 && v <= this.a.length);
        this.c = v;
    }

    public final void G(int v) {
        b.c(v >= 0 && v <= this.c);
        this.b = v;
    }

    public final void H(int v) {
        this.G(this.b + v);
    }

    public final int a() {
        return this.c - this.b;
    }

    public final void b(int v) {
        byte[] arr_b = this.a;
        if(v > arr_b.length) {
            this.a = Arrays.copyOf(arr_b, v);
        }
    }

    public final char c(Charset charset0) {
        b.d(p.f.contains(charset0), "Unsupported charset: " + charset0);
        return (char)(this.d(charset0) >> 16);
    }

    public final int d(Charset charset0) {
        int v5;
        int v4;
        int v2;
        int v = 2;
        boolean z = false;
        if((charset0.equals(StandardCharsets.UTF_8) || charset0.equals(StandardCharsets.US_ASCII)) && this.a() >= 1) {
            long v1 = (long)(this.a[this.b] & 0xFF);
            a.l("Out of range: %s", v1, ((long)(((char)(((int)v1))))) == v1);
            v2 = (byte)(((char)(((int)v1))));
            v = 1;
        }
        else {
            if((charset0.equals(StandardCharsets.UTF_16) || charset0.equals(StandardCharsets.UTF_16BE)) && this.a() >= 2) {
                byte[] arr_b = this.a;
                int v3 = this.b;
                v4 = arr_b[v3];
                v5 = arr_b[v3 + 1];
            }
            else if(charset0.equals(StandardCharsets.UTF_16LE) && this.a() >= 2) {
                byte[] arr_b1 = this.a;
                int v6 = this.b;
                v4 = arr_b1[v6 + 1];
                v5 = arr_b1[v6];
            }
            else {
                return 0;
            }
            v2 = (byte)(((char)(v5 & 0xFF | v4 << 8)));
        }
        if(((long)(((char)(((int)(((long)v2))))))) == ((long)v2)) {
            z = true;
        }
        a.l("Out of range: %s", ((long)v2), z);
        return (((char)(((int)(((long)v2))))) << 16) + v;
    }

    public final void e(byte[] arr_b, int v, int v1) {
        System.arraycopy(this.a, this.b, arr_b, v, v1);
        this.b += v1;
    }

    public final char f(char[] arr_c, Charset charset0) {
        int v = this.d(charset0);
        if(v != 0) {
            for(int v1 = 0; v1 < arr_c.length; ++v1) {
                if(arr_c[v1] == ((char)(v >> 16))) {
                    this.b += v & 0xFFFF;
                    return (char)(v >> 16);
                }
            }
        }
        return '\u0000';
    }

    public final int g() {
        int v = this.b;
        this.b = v + 4;
        return this.a[v + 3] & 0xFF | ((this.a[v + 1] & 0xFF) << 16 | (this.a[v] & 0xFF) << 24 | (this.a[v + 2] & 0xFF) << 8);
    }

    public final String h(Charset charset0) {
        int v;
        b.d(p.f.contains(charset0), "Unsupported charset: " + charset0);
        if(this.a() == 0) {
            return null;
        }
        Charset charset1 = StandardCharsets.US_ASCII;
        if(!charset0.equals(charset1)) {
            this.C();
        }
        if(charset0.equals(StandardCharsets.UTF_8) || charset0.equals(charset1)) {
            v = 1;
        }
        else {
            if(!charset0.equals(StandardCharsets.UTF_16) && !charset0.equals(StandardCharsets.UTF_16LE) && !charset0.equals(StandardCharsets.UTF_16BE)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset0);
            }
            v = 2;
        }
        int v1;
        for(v1 = this.b; true; v1 += v) {
            int v2 = this.c;
            if(v1 >= v2 - (v - 1)) {
                v1 = v2;
                break;
            }
            if((charset0.equals(StandardCharsets.UTF_8) || charset0.equals(StandardCharsets.US_ASCII)) && x.J(this.a[v1]) || (charset0.equals(StandardCharsets.UTF_16) || charset0.equals(StandardCharsets.UTF_16BE)) && (this.a[v1] == 0 && x.J(this.a[v1 + 1])) || charset0.equals(StandardCharsets.UTF_16LE) && (this.a[v1 + 1] == 0 && x.J(this.a[v1]))) {
                break;
            }
        }
        String s = this.s(v1 - this.b, charset0);
        if(this.b != this.c && this.f(p.d, charset0) == 13) {
            this.f(p.e, charset0);
        }
        return s;
    }

    public final int i() {
        int v = this.b;
        this.b = v + 4;
        return (this.a[v + 3] & 0xFF) << 24 | ((this.a[v + 1] & 0xFF) << 8 | this.a[v] & 0xFF | (this.a[v + 2] & 0xFF) << 16);
    }

    public final long j() {
        int v = this.b;
        this.b = v + 8;
        return (((long)this.a[v + 7]) & 0xFFL) << 56 | (((long)this.a[v]) & 0xFFL | (((long)this.a[v + 1]) & 0xFFL) << 8 | (((long)this.a[v + 2]) & 0xFFL) << 16 | (((long)this.a[v + 3]) & 0xFFL) << 24 | (((long)this.a[v + 4]) & 0xFFL) << 0x20 | (((long)this.a[v + 5]) & 0xFFL) << 40 | (((long)this.a[v + 6]) & 0xFFL) << 0x30);
    }

    public final short k() {
        int v = this.b;
        this.b = v + 2;
        return (short)((this.a[v + 1] & 0xFF) << 8 | this.a[v] & 0xFF);
    }

    public final long l() {
        int v = this.b;
        this.b = v + 4;
        return (((long)this.a[v + 3]) & 0xFFL) << 24 | (((long)this.a[v]) & 0xFFL | (((long)this.a[v + 1]) & 0xFFL) << 8 | (((long)this.a[v + 2]) & 0xFFL) << 16);
    }

    public final int m() {
        int v = this.i();
        if(v < 0) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public final int n() {
        int v = this.b;
        this.b = v + 2;
        return (this.a[v + 1] & 0xFF) << 8 | this.a[v] & 0xFF;
    }

    public final long o() {
        int v = this.b;
        this.b = v + 8;
        return ((long)this.a[v + 7]) & 0xFFL | ((((long)this.a[v]) & 0xFFL) << 56 | (((long)this.a[v + 1]) & 0xFFL) << 0x30 | (((long)this.a[v + 2]) & 0xFFL) << 40 | (((long)this.a[v + 3]) & 0xFFL) << 0x20 | (((long)this.a[v + 4]) & 0xFFL) << 24 | (((long)this.a[v + 5]) & 0xFFL) << 16 | (((long)this.a[v + 6]) & 0xFFL) << 8);
    }

    public final String p() {
        if(this.a() == 0) {
            return null;
        }
        int v;
        for(v = this.b; v < this.c && this.a[v] != 0; ++v) {
        }
        String s = new String(this.a, this.b, v - this.b, StandardCharsets.UTF_8);
        this.b = v;
        if(v < this.c) {
            this.b = v + 1;
        }
        return s;
    }

    public final String q(int v) {
        if(v == 0) {
            return "";
        }
        int v1 = this.b + v - 1;
        String s = new String(this.a, this.b, (v1 >= this.c || this.a[v1] != 0 ? v : v - 1), StandardCharsets.UTF_8);
        this.b += v;
        return s;
    }

    public final short r() {
        int v = this.b;
        this.b = v + 2;
        return (short)(this.a[v + 1] & 0xFF | (this.a[v] & 0xFF) << 8);
    }

    public final String s(int v, Charset charset0) {
        String s = new String(this.a, this.b, v, charset0);
        this.b += v;
        return s;
    }

    public final int t() {
        return this.u() << 21 | this.u() << 14 | this.u() << 7 | this.u();
    }

    public final int u() {
        int v = this.b;
        this.b = v + 1;
        return this.a[v] & 0xFF;
    }

    public final int v() {
        int v = this.b;
        this.b = v + 4;
        return this.a[v + 1] & 0xFF | (this.a[v] & 0xFF) << 8;
    }

    public final long w() {
        int v = this.b;
        this.b = v + 4;
        return ((long)this.a[v + 3]) & 0xFFL | ((((long)this.a[v]) & 0xFFL) << 24 | (((long)this.a[v + 1]) & 0xFFL) << 16 | (((long)this.a[v + 2]) & 0xFFL) << 8);
    }

    public final int x() {
        int v = this.b;
        this.b = v + 3;
        return this.a[v + 2] & 0xFF | ((this.a[v + 1] & 0xFF) << 8 | (this.a[v] & 0xFF) << 16);
    }

    public final int y() {
        int v = this.g();
        if(v < 0) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public final long z() {
        long v = this.o();
        if(v < 0L) {
            throw new IllegalStateException(e.a(v, "Top bit not zero: "));
        }
        return v;
    }
}

