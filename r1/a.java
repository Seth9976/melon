package r1;

import androidx.appcompat.app.o;

public final class a {
    public final long a;

    public a(long v) {
        this.a = v;
    }

    public static long a(long v, int v1, int v2, int v3, int v4, int v5) {
        if((v5 & 1) != 0) {
            v1 = a.j(v);
        }
        if((v5 & 2) != 0) {
            v2 = a.h(v);
        }
        if((v5 & 4) != 0) {
            v3 = a.i(v);
        }
        if((v5 & 8) != 0) {
            v4 = a.g(v);
        }
        if(v2 < v1 || v4 < v3 || v1 < 0 || v3 < 0) {
            i.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return b.h(v1, v2, v3, v4);
    }

    public static final boolean b(long v, long v1) {
        return v == v1;
    }

    public static final boolean c(long v) {
        int v1 = ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1);
        return (((int)(v >> v1 + 46)) & (1 << 18 - v1) - 1) != 0;
    }

    public static final boolean d(long v) {
        return (((int)(v >> 33)) & (1 << ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1) + 13) - 1) != 0;
    }

    public static final boolean e(long v) {
        int v1 = ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1);
        int v2 = (1 << 18 - v1) - 1;
        int v3 = ((int)(v >> v1 + 46)) & v2;
        return (((int)(v >> v1 + 15)) & v2) == (v3 == 0 ? 0x7FFFFFFF : v3 - 1);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a && this.a == ((a)object0).a;
    }

    public static final boolean f(long v) {
        int v1 = (1 << ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1) + 13) - 1;
        int v2 = ((int)(v >> 33)) & v1;
        return (((int)(v >> 2)) & v1) == (v2 == 0 ? 0x7FFFFFFF : v2 - 1);
    }

    public static final int g(long v) {
        int v1 = ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1);
        int v2 = ((int)(v >> v1 + 46)) & (1 << 18 - v1) - 1;
        return v2 == 0 ? 0x7FFFFFFF : v2 - 1;
    }

    public static final int h(long v) {
        int v1 = ((int)(v >> 33)) & (1 << ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1) + 13) - 1;
        return v1 == 0 ? 0x7FFFFFFF : v1 - 1;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public static final int i(long v) {
        int v1 = ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1);
        return ((int)(v >> v1 + 15)) & (1 << 18 - v1) - 1;
    }

    public static final int j(long v) {
        return ((int)(v >> 2)) & (1 << ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1) + 13) - 1;
    }

    public static final boolean k(long v) {
        int v1 = 1;
        int v2 = ((((int)(3L & v)) & 2) >> 1) * 3 + ((((int)(3L & v)) & 1) << 1);
        if((((int)(v >> v2 + 46)) & (1 << 18 - v2) - 1) - 1 != 0) {
            v1 = 0;
        }
        return ((((int)(v >> 33)) & (1 << v2 + 13) - 1) - 1 == 0 ? 1 : 0) | v1;
    }

    public static String l(long v) {
        int v1 = a.h(v);
        String s = "Infinity";
        String s1 = v1 == 0x7FFFFFFF ? "Infinity" : String.valueOf(v1);
        int v2 = a.g(v);
        if(v2 != 0x7FFFFFFF) {
            s = String.valueOf(v2);
        }
        StringBuilder stringBuilder0 = new StringBuilder("Constraints(minWidth = ");
        stringBuilder0.append(a.j(v));
        stringBuilder0.append(", maxWidth = ");
        stringBuilder0.append(s1);
        stringBuilder0.append(", minHeight = ");
        stringBuilder0.append(a.i(v));
        stringBuilder0.append(", maxHeight = ");
        return o.r(stringBuilder0, s, ')');
    }

    @Override
    public final String toString() {
        return a.l(this.a);
    }
}

