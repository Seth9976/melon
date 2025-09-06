package v0;

import P0.f;
import P0.n0;
import e1.n;
import gd.k4;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import pc.t;
import r0.p;
import r1.m;
import we.k;

public final class c extends p implements n0, P0.p, b {
    public final d a;
    public boolean b;
    public k c;

    public c(d d0, k k0) {
        this.a = d0;
        this.c = k0;
        d0.a = this;
    }

    @Override  // v0.b
    public final r1.c b() {
        return f.v(this).S;
    }

    @Override  // v0.b
    public final long c() {
        return n.E(f.t(this, 0x80).c);
    }

    @Override  // P0.p
    public final void draw(A0.d d0) {
        d d1 = this.a;
        if(!this.b) {
            d1.b = null;
            f.r(this, new k4(12, this, d1));
            if(d1.b == null) {
                throw Y.d("DrawResult not defined, did you forget to call onDraw?");
            }
            this.b = true;
        }
        t t0 = d1.b;
        q.d(t0);
        ((k)(((r)t0.b))).invoke(d0);
    }

    @Override  // v0.b
    public final m getLayoutDirection() {
        return f.v(this).T;
    }

    public final void m0() {
        this.b = false;
        this.a.b = null;
        f.m(this);
    }

    @Override  // P0.m
    public final void onDensityChange() {
        this.m0();
    }

    @Override  // P0.m
    public final void onLayoutDirectionChange() {
        this.m0();
    }

    @Override  // P0.p
    public final void onMeasureResultChanged() {
        this.m0();
    }

    @Override  // P0.n0
    public final void y() {
        this.m0();
    }
}

