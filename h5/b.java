package h5;

import java.io.Serializable;
import java.util.HashMap;

public final class b implements Serializable, Comparable {
    public long a;
    public a b;
    public byte c;
    public static final char[] d = null;
    public static final HashMap e = null;
    private static final long serialVersionUID = 0x894CE0F4F2FAC371L;

    static {
        b.d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        b.e = new HashMap();
        for(int v = 0; v < 0x20; ++v) {
            b.e.put(Character.valueOf(b.d[v]), v);
        }
    }

    public final void a(double f, double[] arr_f) {
        double f1 = (arr_f[0] + arr_f[1]) / 2.0;
        if(f >= f1) {
            this.c = (byte)(this.c + 1);
            this.a = this.a << 1 | 1L;
            arr_f[0] = f1;
            return;
        }
        this.c = (byte)(this.c + 1);
        this.a <<= 1;
        arr_f[1] = f1;
    }

    public static String b(double f, double f1) {
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.a = 0L;
        b0.c = 0;
        new c(f, f1);
        double[] arr_f = {-90.0, 90.0};
        double[] arr_f1 = {-180.0, 180.0};
        for(int v = 1; b0.c < 30; v ^= 1) {
            if(v == 0) {
                b0.a(f, arr_f);
            }
            else {
                b0.a(f1, arr_f1);
            }
        }
        double f2 = arr_f[0];
        double f3 = arr_f1[0];
        new c(f2, f3);
        double f4 = arr_f[1];
        double f5 = arr_f1[1];
        new c(f4, f5);
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.c = Math.min(f3, f5);
        a0.d = Math.max(f3, f5);
        a0.a = Math.min(f2, f4);
        a0.b = Math.max(f2, f4);
        b0.b = a0;
        b0.a <<= 34;
        return b0.c();
    }

    public final String c() {
        if(this.c % 5 != 0) {
            throw new IllegalStateException("Cannot convert a geohash to base32 if the precision is not a multiple of 5.");
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        long v = this.a;
        int v1 = (int)Math.ceil(((double)this.c) / 5.0);
        for(int v2 = 0; v2 < v1; ++v2) {
            stringBuilder0.append(b.d[((int)((0xF800000000000000L & v) >>> 59))]);
            v <<= 5;
        }
        return stringBuilder0.toString();
    }

    @Override
    public final int compareTo(Object object0) {
        int v = Long.compare(this.a ^ 0x8000000000000000L, 0x8000000000000000L ^ ((b)object0).a);
        return v == 0 ? Integer.compare(this.c, ((b)object0).c) : v;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof b && ((b)object0).c == this.c && ((b)object0).a == this.a;
    }

    @Override
    public final int hashCode() {
        return (0x20F + ((int)(this.a ^ this.a >>> 0x20))) * 0x1F + this.c;
    }

    @Override
    public final String toString() {
        return this.c % 5 == 0 ? Long.toBinaryString(this.a) + " -> " + this.b + " -> " + this.c() : String.format("%s -> %s, bits: %d", Long.toBinaryString(this.a), this.b, this.c);
    }
}

