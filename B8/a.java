package b8;

import androidx.appcompat.app.o;

public final class a {
    public final int[] a;
    public final int[] b;
    public final b c;
    public final int d;
    public final int e;
    public final int f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;

    static {
        a.g = new a(4201, 0x1000, 1);
        a.h = new a(0x409, 0x400, 1);
        a.i = new a(67, 0x40, 1);
        a.j = new a(19, 16, 1);
        a.k = new a(285, 0x100, 0);
        a.l = new a(301, 0x100, 1);
    }

    public a(int v, int v1, int v2) {
        this.e = v;
        this.d = v1;
        this.f = v2;
        this.a = new int[v1];
        this.b = new int[v1];
        int v3 = 1;
        for(int v4 = 0; v4 < v1; ++v4) {
            this.a[v4] = v3;
            v3 <<= 1;
            v3 = v3 < v1 ? v3 << 1 : (v3 ^ v) & v1 - 1;
        }
        for(int v5 = 0; v5 < v1 - 1; ++v5) {
            this.b[this.a[v5]] = v5;
        }
        this.c = new b(this, new int[]{0});
    }

    public final int a(int v, int v1) {
        return v == 0 || v1 == 0 ? 0 : this.a[(this.b[v] + this.b[v1]) % (this.d - 1)];
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GF(0x");
        stringBuilder0.append(Integer.toHexString(this.e));
        stringBuilder0.append(',');
        return o.q(stringBuilder0, this.d, ')');
    }
}

