package x1;

import B1.g;
import De.l;
import De.w;
import U4.x;
import W.p;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.t;

public final class d {
    public final Object a;
    public final g b;
    public final e c;
    public final p d;
    public final E9.g e;
    public final p f;
    public final E9.g g;
    public final c h;
    public final c i;
    public final c j;
    public static final w[] k;

    static {
        t t0 = new t(d.class, "width", "getWidth()Landroidx/constraintlayout/compose/Dimension;", 0);
        l l0 = x.c(d.class, "height", "getHeight()Landroidx/constraintlayout/compose/Dimension;", 0, I.a);
        l l1 = x.c(d.class, "visibility", "getVisibility()Landroidx/constraintlayout/compose/Visibility;", 0, I.a);
        l l2 = x.c(d.class, "scaleX", "getScaleX()F", 0, I.a);
        l l3 = x.c(d.class, "scaleY", "getScaleY()F", 0, I.a);
        l l4 = x.c(d.class, "rotationX", "getRotationX()F", 0, I.a);
        l l5 = x.c(d.class, "rotationY", "getRotationY()F", 0, I.a);
        l l6 = x.c(d.class, "rotationZ", "getRotationZ()F", 0, I.a);
        l l7 = x.c(d.class, "translationX", "getTranslationX-D9Ej5fM()F", 0, I.a);
        l l8 = x.c(d.class, "translationY", "getTranslationY-D9Ej5fM()F", 0, I.a);
        l l9 = x.c(d.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0, I.a);
        l l10 = x.c(d.class, "pivotX", "getPivotX()F", 0, I.a);
        l l11 = x.c(d.class, "pivotY", "getPivotY()F", 0, I.a);
        l l12 = x.c(d.class, "horizontalChainWeight", "getHorizontalChainWeight()F", 0, I.a);
        l l13 = x.c(d.class, "verticalChainWeight", "getVerticalChainWeight()F", 0, I.a);
        d.k = new w[]{I.a.e(t0), l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13};
    }

    public d(Object object0, g g0) {
        this.a = object0;
        this.b = g0;
        this.c = new e("parent");
        this.d = new p(g0, -2);
        this.e = new E9.g(g0, 0);
        this.f = new p(g0, -1);
        this.g = new E9.g(g0, 1);
        this.h = new c(this, new n(null, "wrap"));
        this.i = new c(this, new n(null, "wrap"));
        this.j = new c(this);
    }

    public static void a(d d0, f f0, f f1) {
        d0.e.u(f0, 0.0f, 0.0f);
        d0.g.u(f1, 0.0f, 0.0f);
        d0.b.getClass();
        B1.e e0 = new B1.e(1.0f);
        d0.b.A("vBias", e0);
    }

    public static void b(d d0, x1.g g0, x1.g g1, float f, float f1, float f2, int v) {
        if((v & 4) != 0) {
            f = 0.0f;
        }
        if((v & 16) != 0) {
            f1 = 0.0f;
        }
        d0.d.k(g0, f, f1);
        d0.f.k(g1, 0.0f, 0.0f);
        d0.b.getClass();
        B1.e e0 = new B1.e(f2);
        d0.b.A("hRtlBias", e0);
    }

    public final void c(n n0) {
        this.i.setValue(this, d.k[1], n0);
    }

    public final void d(n n0) {
        this.h.setValue(this, d.k[0], n0);
    }
}

