package androidx.compose.foundation.layout;

import F.e;
import M.C;
import r0.g;
import r0.h;
import r0.i;
import r0.q;

public abstract class d {
    public static final FillElement a;
    public static final FillElement b;
    public static final FillElement c;
    public static final WrapContentElement d;
    public static final WrapContentElement e;
    public static final WrapContentElement f;
    public static final WrapContentElement g;
    public static final WrapContentElement h;
    public static final WrapContentElement i;

    static {
        d.a = new FillElement(C.b, 1.0f, "fillMaxWidth");
        d.b = new FillElement(C.a, 1.0f, "fillMaxHeight");
        d.c = new FillElement(C.c, 1.0f, "fillMaxSize");
        e e0 = new e(r0.d.n, 7);
        d.d = new WrapContentElement(C.b, false, e0, r0.d.n, "wrapContentWidth");
        e e1 = new e(r0.d.m, 7);
        d.e = new WrapContentElement(C.b, false, e1, r0.d.m, "wrapContentWidth");
        e e2 = new e(r0.d.k, 5);
        d.f = new WrapContentElement(C.a, false, e2, r0.d.k, "wrapContentHeight");
        e e3 = new e(r0.d.j, 5);
        d.g = new WrapContentElement(C.a, false, e3, r0.d.j, "wrapContentHeight");
        e e4 = new e(r0.d.e, 6);
        d.h = new WrapContentElement(C.c, false, e4, r0.d.e, "wrapContentSize");
        e e5 = new e(r0.d.a, 6);
        d.i = new WrapContentElement(C.c, false, e5, r0.d.a, "wrapContentSize");
    }

    public static final q a(q q0, float f, float f1) {
        return q0.then(new UnspecifiedConstraintsElement(f, f1));
    }

    public static q b(q q0, float f, float f1, int v) {
        if((v & 1) != 0) {
            f = NaNf;
        }
        if((v & 2) != 0) {
            f1 = NaNf;
        }
        return d.a(q0, f, f1);
    }

    public static final q c(q q0, float f) {
        return f == 1.0f ? q0.then(d.b) : q0.then(new FillElement(C.a, f, "fillMaxHeight"));
    }

    public static q d(q q0) {
        return d.c(q0, 1.0f);
    }

    public static q e(q q0) {
        return q0.then(d.c);
    }

    public static final q f(q q0, float f) {
        return f == 1.0f ? q0.then(d.a) : q0.then(new FillElement(C.b, f, "fillMaxWidth"));
    }

    public static q g(q q0) {
        return d.f(q0, 1.0f);
    }

    public static final q h(q q0, float f) {
        return q0.then(new SizeElement(0.0f, f, 0.0f, f, true, 5));
    }

    public static final q i(q q0, float f, float f1) {
        return q0.then(new SizeElement(0.0f, f, 0.0f, f1, true, 5));
    }

    public static q j(q q0, float f, float f1, int v) {
        if((v & 1) != 0) {
            f = NaNf;
        }
        if((v & 2) != 0) {
            f1 = NaNf;
        }
        return d.i(q0, f, f1);
    }

    public static final q k(q q0, float f) {
        return q0.then(new SizeElement(0.0f, f, 0.0f, f, false, 5));
    }

    public static q l(q q0, float f, float f1, float f2, float f3, int v) {
        float f4 = (v & 2) == 0 ? f1 : NaNf;
        float f5 = (v & 4) == 0 ? f2 : NaNf;
        return (v & 8) == 0 ? q0.then(new SizeElement(f, f4, f5, f3, false)) : q0.then(new SizeElement(f, f4, f5, NaNf, false));
    }

    public static final q m(q q0, float f) {
        return q0.then(new SizeElement(f, 0.0f, f, 0.0f, false, 10));
    }

    public static final q n(q q0, float f) {
        return q0.then(new SizeElement(f, f, f, f, true));
    }

    public static final q o(q q0, float f, float f1) {
        return q0.then(new SizeElement(f, f1, f, f1, true));
    }

    public static final q p(q q0, float f, float f1, float f2, float f3) {
        return q0.then(new SizeElement(f, f1, f2, f3, true));
    }

    public static final q q(q q0, float f) {
        return q0.then(new SizeElement(f, 0.0f, f, 0.0f, true, 10));
    }

    public static final q r(q q0, float f, float f1) {
        return q0.then(new SizeElement(f, 0.0f, f1, 0.0f, true, 10));
    }

    public static q s(q q0, float f, float f1, int v) {
        if((v & 1) != 0) {
            f = NaNf;
        }
        if((v & 2) != 0) {
            f1 = NaNf;
        }
        return d.r(q0, f, f1);
    }

    public static q t(q q0, int v) {
        h h0 = r0.d.k;
        boolean z = (v & 2) == 0;
        if(h0.equals(h0) && !z) {
            return q0.then(d.f);
        }
        if(h0.equals(r0.d.j) && !z) {
            return q0.then(d.g);
        }
        e e0 = new e(h0, 5);
        return q0.then(new WrapContentElement(C.a, z, e0, h0, "wrapContentHeight"));
    }

    public static q u(q q0, int v) {
        i i0 = r0.d.e;
        boolean z = (v & 2) == 0;
        if(i0.equals(i0) && !z) {
            return q0.then(d.h);
        }
        if(i0.equals(r0.d.a) && !z) {
            return q0.then(d.i);
        }
        e e0 = new e(i0, 6);
        return q0.then(new WrapContentElement(C.c, z, e0, i0, "wrapContentSize"));
    }

    public static q v(q q0, g g0, int v) {
        g g1 = (v & 1) == 0 ? g0 : r0.d.n;
        if(g1.equals(r0.d.n)) {
            return q0.then(d.d);
        }
        if(g1.equals(r0.d.m)) {
            return q0.then(d.e);
        }
        e e0 = new e(g1, 7);
        return q0.then(new WrapContentElement(C.b, false, e0, g1, "wrapContentWidth"));
    }
}

