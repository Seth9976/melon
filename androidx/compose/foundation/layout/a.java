package androidx.compose.foundation.layout;

import B0.b;
import F.Q;
import M.Y;
import M.c0;
import M.f0;
import M.g0;
import M.i0;
import M.j0;
import r0.q;
import we.k;

public abstract class a {
    public static j0 a(float f, float f1, int v) {
        if((v & 1) != 0) {
            f = 0.0f;
        }
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        return new j0(f, f1, f, f1);
    }

    public static final j0 b(float f, float f1, float f2, float f3) {
        return new j0(f, f1, f2, f3);
    }

    public static j0 c(float f, float f1, float f2, float f3, int v) {
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
        return new j0(f, f1, f2, f3);
    }

    public static final q d(float f, q q0, boolean z) {
        return q0.then(new AspectRatioElement(f, z));
    }

    public static final boolean e(int v, int v1, long v2) {
        return v <= r1.a.h(v2) && r1.a.j(v2) <= v && (v1 <= r1.a.g(v2) && r1.a.i(v2) <= v1);
    }

    public static final q f(q q0, k k0) {
        return q0.then(new OffsetPxElement(k0, new Q(2, k0)));
    }

    public static final q g(q q0, float f, float f1) {
        return q0.then(new OffsetElement(f, f1, new c0(f, f1, 0)));
    }

    public static q h(q q0, float f, float f1, int v) {
        if((v & 1) != 0) {
            f = 0.0f;
        }
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        return a.g(q0, f, f1);
    }

    public static final q i(q q0, i0 i00) {
        return q0.then(new PaddingValuesElement(i00, new b(i00, 11)));
    }

    public static final q j(q q0, float f) {
        return q0.then(new PaddingElement(f, f, f, f, new g0(f)));
    }

    public static final q k(q q0, float f, float f1) {
        return q0.then(new PaddingElement(f, f1, f, f1, new c0(f, f1, 1)));
    }

    public static q l(q q0, float f, float f1, int v) {
        if((v & 1) != 0) {
            f = 0.0f;
        }
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        return a.k(q0, f, f1);
    }

    public static final q m(q q0, float f, float f1, float f2, float f3) {
        return q0.then(new PaddingElement(f, f1, f2, f3, new f0(f, f1, f2, f3)));
    }

    public static q n(q q0, float f, float f1, float f2, float f3, int v) {
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
        return a.m(q0, f, f1, f2, f3);
    }

    public static final q o() {
        return new IntrinsicWidthElement(Y.a, false);
    }

    public static final q p(q q0, Y y0) {
        return q0.then(new IntrinsicWidthElement(y0, true));
    }
}

