package r1;

import org.jetbrains.annotations.NotNull;

public abstract class b {
    public static final long a(int v, int v1, int v2, int v3) {
        if(((v2 < 0 ? 0 : 1) & ((v1 < v ? 0 : 1) & (v3 < v2 ? 0 : 1) & (v < 0 ? 0 : 1))) == 0) {
            i.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return b.h(v, v1, v2, v3);
    }

    public static long b(int v, int v1, int v2) {
        if((v2 & 2) != 0) {
            v = 0x7FFFFFFF;
        }
        if((v2 & 8) != 0) {
            v1 = 0x7FFFFFFF;
        }
        return b.a(0, v, 0, v1);
    }

    public static final int c(int v) {
        if(v < 0x1FFF) {
            return 13;
        }
        if(v < 0x7FFF) {
            return 15;
        }
        if(v < 0xFFFF) {
            return 16;
        }
        return v >= 0x3FFFF ? 0xFF : 18;
    }

    public static final long d(long v, long v1) {
        int v2 = (int)(v1 >> 0x20);
        int v3 = a.j(v);
        int v4 = a.h(v);
        if(v2 < v3) {
            v2 = v3;
        }
        if(v2 <= v4) {
            v4 = v2;
        }
        int v5 = (int)(v1 & 0xFFFFFFFFL);
        int v6 = a.i(v);
        int v7 = a.g(v);
        if(v5 < v6) {
            v5 = v6;
        }
        if(v5 <= v7) {
            v7 = v5;
        }
        return ((long)v4) << 0x20 | ((long)v7) & 0xFFFFFFFFL;
    }

    public static final long e(long v, long v1) {
        int v2 = a.j(v);
        int v3 = a.h(v);
        int v4 = a.i(v);
        int v5 = a.g(v);
        int v6 = a.j(v1) >= v2 ? a.j(v1) : v2;
        if(v6 > v3) {
            v6 = v3;
        }
        int v7 = a.h(v1);
        if(v7 >= v2) {
            v2 = v7;
        }
        if(v2 <= v3) {
            v3 = v2;
        }
        int v8 = a.i(v1) >= v4 ? a.i(v1) : v4;
        if(v8 > v5) {
            v8 = v5;
        }
        int v9 = a.g(v1);
        if(v9 >= v4) {
            v4 = v9;
        }
        if(v4 <= v5) {
            v5 = v4;
        }
        return b.a(v6, v3, v8, v5);
    }

    public static final int f(int v, long v1) {
        int v2 = a.i(v1);
        int v3 = a.g(v1);
        if(v < v2) {
            v = v2;
        }
        return v <= v3 ? v : v3;
    }

    public static final int g(int v, long v1) {
        int v2 = a.j(v1);
        int v3 = a.h(v1);
        if(v < v2) {
            v = v2;
        }
        return v <= v3 ? v : v3;
    }

    public static final long h(int v, int v1, int v2, int v3) {
        int v4 = v3 == 0x7FFFFFFF ? v2 : v3;
        int v5 = v1 == 0x7FFFFFFF ? v : v1;
        int v6 = b.c(v5);
        if(b.c(v4) + v6 > 0x1F) {
            b.j(v5, v4);
        }
        return ((long)(v1 + 1 & ~(v1 + 1 >> 0x1F))) << 33 | (((long)((v6 - 13 >> 1) + (v6 - 13 & 1))) | ((long)v) << 2) | ((long)v2) << v6 + 2 | ((long)(v3 + 1 & ~(v3 + 1 >> 0x1F))) << v6 + 33;
    }

    public static final long i(int v, int v1, long v2) {
        int v3 = a.j(v2) + v >= 0 ? a.j(v2) + v : 0;
        int v4 = a.h(v2);
        if(v4 != 0x7FFFFFFF) {
            v4 += v;
            if(v4 < 0) {
                v4 = 0;
            }
        }
        int v5 = a.i(v2) + v1 >= 0 ? a.i(v2) + v1 : 0;
        int v6 = a.g(v2);
        if(v6 == 0x7FFFFFFF) {
            return b.a(v3, v4, v5, 0x7FFFFFFF);
        }
        v6 += v1;
        return v6 >= 0 ? b.a(v3, v4, v5, v6) : b.a(v3, v4, v5, 0);
    }

    public static final void j(int v, int v1) {
        throw new IllegalArgumentException("Can\'t represent a width of " + v + " and height of " + v1 + " in Constraints");
    }

    @NotNull
    public static final Void k(int v) {
        throw new IllegalArgumentException("Can\'t represent a size of " + v + " in Constraints");
    }
}

