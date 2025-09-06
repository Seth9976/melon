package M;

import S1.d;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import androidx.collection.L;
import c2.B0;
import c2.j;
import java.util.WeakHashMap;
import p0.m;

public final class y0 {
    public final a a;
    public final a b;
    public final a c;
    public final a d;
    public final a e;
    public final a f;
    public final a g;
    public final a h;
    public final a i;
    public final v0 j;
    public final t0 k;
    public final v0 l;
    public final v0 m;
    public final v0 n;
    public final v0 o;
    public final v0 p;
    public final v0 q;
    public final v0 r;
    public final boolean s;
    public int t;
    public final T u;
    public static final WeakHashMap v;

    static {
        y0.v = new WeakHashMap();
    }

    public y0(View view0) {
        this.a = b.b(4, "captionBar");
        a a0 = b.b(0x80, "displayCutout");
        this.b = a0;
        a a1 = b.b(8, "ime");
        this.c = a1;
        a a2 = b.b(0x20, "mandatorySystemGestures");
        this.d = a2;
        this.e = b.b(2, "navigationBars");
        boolean z = true;
        this.f = b.b(1, "statusBars");
        a a3 = b.b(0x207, "systemBars");
        this.g = a3;
        a a4 = b.b(16, "systemGestures");
        this.h = a4;
        a a5 = b.b(0x40, "tappableElement");
        this.i = a5;
        v0 v00 = new v0(new X(0, 0, 0, 0), "waterfall");
        this.j = v00;
        this.k = new t0(new t0(a3, a1), a0);
        new t0(new t0(new t0(a5, a2), a4), v00);
        this.l = b.c(4, "captionBarIgnoringVisibility");
        this.m = b.c(2, "navigationBarsIgnoringVisibility");
        this.n = b.c(1, "statusBarsIgnoringVisibility");
        this.o = b.c(0x207, "systemBarsIgnoringVisibility");
        this.p = b.c(0x40, "tappableElementIgnoringVisibility");
        this.q = b.c(8, "imeAnimationTarget");
        this.r = b.c(8, "imeAnimationSource");
        ViewParent viewParent0 = view0.getParent();
        Boolean boolean0 = null;
        View view1 = viewParent0 instanceof View ? ((View)viewParent0) : null;
        Object object0 = view1 == null ? null : view1.getTag(0x7F0A0318);  // id:consume_window_insets_tag
        if(object0 instanceof Boolean) {
            boolean0 = (Boolean)object0;
        }
        if(boolean0 != null) {
            z = boolean0.booleanValue();
        }
        this.s = z;
        this.u = new T(this);
    }

    public static void a(y0 y00, B0 b00) {
        boolean z = false;
        y00.a.f(b00, 0);
        y00.c.f(b00, 0);
        y00.b.f(b00, 0);
        y00.e.f(b00, 0);
        y00.f.f(b00, 0);
        y00.g.f(b00, 0);
        y00.h.f(b00, 0);
        y00.i.f(b00, 0);
        y00.d.f(b00, 0);
        X x0 = c.n(b00.a.h(4));
        y00.l.f(x0);
        X x1 = c.n(b00.a.h(2));
        y00.m.f(x1);
        X x2 = c.n(b00.a.h(1));
        y00.n.f(x2);
        X x3 = c.n(b00.a.h(0x207));
        y00.o.f(x3);
        X x4 = c.n(b00.a.h(0x40));
        y00.p.f(x4);
        j j0 = b00.a.f();
        if(j0 != null) {
            X x5 = c.n((Build.VERSION.SDK_INT < 30 ? d.e : d.d(P1.b.h(j0.a))));
            y00.j.f(x5);
        }
        synchronized(m.b) {
            L l0 = m.i.h;
            if(l0 != null && l0.h()) {
                z = true;
            }
        }
        if(z) {
            m.a();
        }
    }
}

