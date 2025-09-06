package u1;

import N0.Z;
import N0.v;
import P0.I;
import P0.r0;
import Q0.u;
import android.view.WindowInsets;
import c2.B0;
import c2.W;
import ie.H;
import kotlin.jvm.internal.r;
import r1.l;
import we.k;

public final class c extends r implements k {
    public final int f;
    public final o g;
    public final I h;

    public c(o o0, I i0, int v) {
        this.f = v;
        this.g = o0;
        this.h = i0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                u u0 = ((r0)object0) instanceof u ? ((u)(((r0)object0))) : null;
                o o1 = this.g;
                if(u0 != null) {
                    u0.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(o1, this.h);
                    u0.getAndroidViewsHandler$ui_release().addView(o1);
                    u0.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(this.h, o1);
                    o1.setImportantForAccessibility(1);
                    W.o(o1, new Q0.k(u0, this.h, u0));
                }
                if(o1.getView().getParent() != o1) {
                    o1.addView(o1.getView());
                }
                return H.a;
            }
            case 1: {
                Z z0 = (Z)object0;
                j.f(this.g, this.h);
                return H.a;
            }
            default: {
                o o0 = this.g;
                j.f(o0, this.h);
                ((u)o0.c).N = true;
                int v = o0.n[0];
                int v1 = o0.n[1];
                o0.getView().getLocationOnScreen(o0.n);
                long v2 = o0.o;
                long v3 = ((v)object0).l();
                o0.o = v3;
                B0 b00 = o0.r;
                if(b00 != null && (v != o0.n[0] || v1 != o0.n[1] || !l.b(v2, v3))) {
                    WindowInsets windowInsets0 = o0.g(b00).g();
                    if(windowInsets0 != null) {
                        o0.getView().dispatchApplyWindowInsets(windowInsets0);
                    }
                }
                return H.a;
            }
        }
    }
}

