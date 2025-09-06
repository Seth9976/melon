package androidx.compose.foundation.lazy.layout;

import N0.g0;
import N0.j0;
import O.m;
import android.view.View;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ea.a;
import ie.H;
import kotlin.jvm.internal.r;
import o0.c;
import r0.q;
import we.n;
import we.o;

public final class x extends r implements o {
    public final I f;
    public final q g;
    public final n h;
    public final b0 i;

    public x(I i0, q q0, n n0, b0 b00) {
        this.f = i0;
        this.g = q0;
        this.h = n0;
        this.i = b00;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Number)object2).intValue();
        p p0 = (p)(((l)object1));
        u u0 = p0.N();
        V v0 = k.a;
        if(u0 == v0) {
            u0 = new u(((c)object0), new m(this.i, 5));
            p0.l0(u0);
        }
        j0 j00 = p0.N();
        if(j00 == v0) {
            j00 = new j0(new a(u0));
            p0.l0(j00);
        }
        I i0 = this.f;
        if(i0 == null) {
            p0.a0(204710145);
        }
        else {
            p0.a0(204281539);
            p0.a0(0x649383);
            C c0 = c0.a;
            if(c0 == null) {
                p0.a0(0x485B21A8);
                View view0 = (View)p0.k(AndroidCompositionLocals_androidKt.f);
                boolean z = p0.g(view0);
                androidx.compose.foundation.lazy.layout.a a0 = p0.N();
                if(z || a0 == v0) {
                    a0 = new androidx.compose.foundation.lazy.layout.a(view0);
                    p0.l0(a0);
                }
                c0 = a0;
            }
            else {
                p0.a0(0x485A89AF);
            }
            p0.p(false);
            p0.p(false);
            Object[] arr_object = {i0, u0, j00, c0};
            boolean z1 = p0.g(i0);
            boolean z2 = p0.i(u0);
            boolean z3 = p0.i(j00);
            boolean z4 = p0.i(c0);
            w w0 = p0.N();
            if((z1 | z2 | z3 | z4) != 0 || w0 == v0) {
                w0 = new w(i0, u0, j00, c0);
                p0.l0(w0);
            }
            J.c(arr_object, w0, p0);
        }
        p0.p(false);
        q q0 = this.g;
        if(i0 != null) {
            q q1 = q0.then(new TraversablePrefetchStateModifierElement(i0));
            if(q1 != null) {
                q0 = q1;
            }
        }
        boolean z5 = p0.g(u0);
        n n0 = this.h;
        boolean z6 = p0.g(n0);
        B2.p p1 = p0.N();
        if(z5 || z6 || p1 == v0) {
            p1 = new B2.p(18, u0, n0);
            p0.l0(p1);
        }
        g0.b(j00, q0, p1, p0, 8);
        return H.a;
    }
}

