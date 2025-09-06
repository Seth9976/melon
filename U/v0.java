package U;

import I.l0;
import Q0.e1;
import Q0.k0;
import Q0.y0;
import a1.g;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.ui.draw.a;
import f1.p;
import f1.x;
import kotlin.jvm.internal.r;
import r0.n;
import r0.q;
import we.o;
import y0.T;

public final class v0 extends r implements o {
    public final T f;
    public final f0 g;
    public final x h;
    public final p i;

    public v0(T t0, f0 f00, x x0, p p0) {
        this.f = t0;
        this.g = f00;
        this.h = x0;
        this.i = p0;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q q0;
        ((Number)object2).intValue();
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object1));
        p0.a0(0xFAF68513);
        boolean z = ((Boolean)p0.k(k0.w)).booleanValue();
        boolean z1 = p0.h(z);
        W.l l0 = p0.N();
        V v0 = k.a;
        if(z1 || l0 == v0) {
            l0 = new W.l(z);
            p0.l0(l0);
        }
        T t0 = this.f;
        boolean z2 = Long.compare(t0.a, 16L) != 0;
        if(((Boolean)((O0)((y0)(((e1)p0.k(k0.t)))).a).getValue()).booleanValue()) {
            f0 f00 = this.g;
            if(f00.b()) {
                x x0 = this.h;
                if(a1.T.b(x0.b) && z2) {
                    p0.a0(808460990);
                    g g0 = x0.a;
                    a1.T t1 = new a1.T(x0.b);
                    boolean z3 = p0.i(l0);
                    u0 u00 = p0.N();
                    if(z3 || u00 == v0) {
                        u00 = new u0(l0, null);
                        p0.l0(u00);
                    }
                    J.f(g0, t1, u00, p0);
                    boolean z4 = p0.i(l0);
                    boolean z5 = p0.i(this.i);
                    boolean z6 = p0.g(x0);
                    boolean z7 = p0.i(f00);
                    boolean z8 = p0.g(t0);
                    l0 l00 = p0.N();
                    if((z4 | z5 | z6 | z7 | z8) != 0 || l00 == v0) {
                        l0 l01 = new l0(l0, this.i, this.h, f00, t0, 1);
                        p0.l0(l01);
                        l00 = l01;
                    }
                    q0 = a.c(((q)object0), l00);
                    p0.p(false);
                    p0.p(false);
                    return q0;
                }
            }
            goto label_39;
        }
        else {
        label_39:
            p0.a0(0x304EDCFE);
            p0.p(false);
            q0 = n.a;
        }
        p0.p(false);
        return q0;
    }
}

