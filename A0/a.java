package a0;

import A0.b;
import O.m;
import P0.K;
import X.k;
import android.view.ViewGroup;
import androidx.compose.foundation.g0;
import androidx.compose.material.ripple.RippleContainer;
import androidx.compose.material.ripple.RippleHostView;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w0;
import androidx.compose.runtime.w;
import java.util.LinkedHashMap;
import y0.c;
import y0.q;
import y0.s;

public final class a implements h, g0, w0 {
    public final B0.a a;
    public final boolean b;
    public final float c;
    public final b0 d;
    public final b0 e;
    public final ViewGroup f;
    public RippleContainer g;
    public final b0 h;
    public final b0 i;
    public long j;
    public int k;
    public final k l;

    public a(b0 b00, b0 b01, ViewGroup viewGroup0) {
        this.a = new B0.a(true, new m(b01, 4));
        this.b = true;
        this.c = NaNf;
        this.d = b00;
        this.e = b01;
        this.f = viewGroup0;
        this.h = w.s(null);
        this.i = w.s(Boolean.TRUE);
        this.j = 0L;
        this.k = -1;
        this.l = new k(this, 3);
    }

    @Override  // a0.h
    public final void O() {
        ((O0)this.h).setValue(null);
    }

    @Override  // androidx.compose.foundation.g0
    public final void a(K k0) {
        int v1;
        b b0 = k0.a;
        this.j = b0.c();
        float f = this.c;
        if(Float.isNaN(f)) {
            long v = b0.c();
            v1 = ye.a.V(g.a(k0, this.b, v));
        }
        else {
            v1 = b0.z(f);
        }
        this.k = v1;
        long v2 = ((s)this.d.getValue()).a;
        float f1 = ((f)this.e.getValue()).d;
        k0.a();
        float f2 = Float.isNaN(f) ? g.a(k0, true, b0.c()) : k0.Y(f);
        this.a.a(k0, f2, v2);
        q q0 = b0.b.h();
        ((Boolean)((O0)this.i).getValue()).booleanValue();
        Object object0 = ((O0)this.h).getValue();
        if(((RippleHostView)object0) != null) {
            long v3 = b0.c();
            ((RippleHostView)object0).e(this.k, v3, f1, v2);
            ((RippleHostView)object0).draw(c.a(q0));
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
        RippleContainer rippleContainer0 = this.g;
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

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        RippleContainer rippleContainer0 = this.g;
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

