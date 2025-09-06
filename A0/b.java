package a0;

import A0.d;
import B0.a;
import K.o;
import P0.K;
import P0.f;
import P0.l;
import P0.y;
import X.k;
import android.view.View;
import androidx.collection.G;
import androidx.compose.material.ripple.RippleContainer;
import androidx.compose.material.ripple.RippleHostView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import e1.n;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import r0.p;
import y0.c;
import y0.q;
import y0.u;

public final class b extends p implements l, P0.p, y, h {
    public final K.l a;
    public final boolean b;
    public final float c;
    public final u d;
    public final r e;
    public a f;
    public float g;
    public long h;
    public boolean i;
    public final G j;
    public RippleContainer k;
    public RippleHostView l;

    public b(K.l l0, boolean z, float f, u u0, we.a a0) {
        this.a = l0;
        this.b = z;
        this.c = f;
        this.d = u0;
        this.e = (r)a0;
        this.h = 0L;
        this.j = new G();
    }

    @Override  // a0.h
    public final void O() {
        this.l = null;
        f.m(this);
    }

    @Override  // P0.p
    public final void draw(d d0) {
        ((K)d0).a();
        a a0 = this.f;
        if(a0 != null) {
            a0.a(((K)d0), this.g, this.d.invoke-0d7_KjU());
        }
        q q0 = ((K)d0).a.b.h();
        RippleHostView rippleHostView0 = this.l;
        if(rippleHostView0 != null) {
            long v = this.h;
            int v1 = ye.a.V(this.g);
            long v2 = this.d.invoke-0d7_KjU();
            rippleHostView0.e(v1, v, ((a0.f)((we.a)this.e).invoke()).d, v2);
            rippleHostView0.draw(c.a(q0));
        }
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override  // P0.y
    public final void h(long v) {
        this.i = true;
        r1.c c0 = f.v(this).S;
        this.h = n.E(v);
        this.g = Float.isNaN(this.c) ? g.a(c0, this.b, this.h) : c0.Y(this.c);
        G g0 = this.j;
        Object[] arr_object = g0.a;
        int v1 = g0.b;
        for(int v2 = 0; v2 < v1; ++v2) {
            this.m0(((K.q)arr_object[v2]));
        }
        g0.c();
    }

    public final void m0(K.q q0) {
        if(q0 instanceof o) {
            long v = this.h;
            float f = this.g;
            RippleContainer rippleContainer0 = this.k;
            if(rippleContainer0 == null) {
                rippleContainer0 = E9.h.m(E9.h.n(((View)f.i(this, AndroidCompositionLocals_androidKt.f))));
                this.k = rippleContainer0;
                kotlin.jvm.internal.q.d(rippleContainer0);
            }
            RippleHostView rippleHostView0 = rippleContainer0.a(this);
            int v1 = ye.a.V(f);
            long v2 = this.d.invoke-0d7_KjU();
            float f1 = ((a0.f)((we.a)this.e).invoke()).d;
            k k0 = new k(this, 4);
            rippleHostView0.b(((o)q0), this.b, v, v1, v2, f1, k0);
            this.l = rippleHostView0;
            f.m(this);
            return;
        }
        if(q0 instanceof K.p) {
            K.p p0 = (K.p)q0;
            RippleHostView rippleHostView1 = this.l;
            if(rippleHostView1 != null) {
                rippleHostView1.d();
            }
        }
        else if(q0 instanceof K.n) {
            K.n n0 = (K.n)q0;
            RippleHostView rippleHostView2 = this.l;
            if(rippleHostView2 != null) {
                rippleHostView2.d();
            }
        }
    }

    @Override  // r0.p
    public final void onAttach() {
        BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new j(this, null), 3, null);
    }

    @Override  // r0.p
    public final void onDetach() {
        RippleContainer rippleContainer0 = this.k;
        if(rippleContainer0 != null) {
            this.O();
            d5.c c0 = rippleContainer0.d;
            RippleHostView rippleHostView0 = (RippleHostView)((LinkedHashMap)c0.b).get(this);
            if(rippleHostView0 != null) {
                rippleHostView0.c();
                LinkedHashMap linkedHashMap0 = (LinkedHashMap)c0.b;
                RippleHostView rippleHostView1 = (RippleHostView)linkedHashMap0.get(this);
                if(rippleHostView1 != null) {
                    h h0 = (h)((LinkedHashMap)c0.c).remove(rippleHostView1);
                }
                linkedHashMap0.remove(this);
                rippleContainer0.c.add(rippleHostView0);
            }
        }
    }
}

