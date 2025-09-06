package T;

import E9.h;

public abstract class e {
    public static final d a;

    static {
        e.a = e.a(50);
    }

    public static final d a(int v) {
        c c0 = h.a(v);
        return new d(c0, c0, c0, c0);
    }

    public static final d b(float f) {
        b b0 = new b(f);
        return new d(b0, b0, b0, b0);
    }

    public static final d c(float f, float f1, float f2, float f3) {
        return new d(new b(f), new b(f1), new b(f2), new b(f3));
    }

    public static d d(float f, float f1, float f2, float f3, int v) {
        if((v & 1) != 0) {
            f = 0.0f;
        }
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        if((v & 4) != 0) {
            f2 = 0.0f;
        }
        if((v & 8) != 0) {
            f3 = 0.0f;
        }
        return e.c(f, f1, f2, f3);
    }

    public static final d e() {
        return e.a;
    }
}

