package u0;

import F.g;
import P0.D0;
import P0.f;
import P0.y;
import df.v;
import e.k;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import pc.t;
import r0.p;

public final class e extends p implements D0, y {
    public e a;
    public e b;
    public long c;

    @Override  // P0.D0
    public final Object f() {
        return d.a;
    }

    @Override  // P0.y
    public final void h(long v) {
        this.c = v;
    }

    public final boolean m0(t t0) {
        e e0 = this.a;
        if(e0 == null) {
            return this.b == null ? false : this.b.m0(t0);
        }
        return e0.m0(t0);
    }

    public final void n0(t t0) {
        e e0 = this.b;
        if(e0 == null) {
            e e1 = this.a;
            if(e1 != null) {
                e1.n0(t0);
            }
            return;
        }
        e0.n0(t0);
    }

    public final void o0(t t0) {
        e e0 = this.b;
        if(e0 != null) {
            e0.o0(t0);
        }
        e e1 = this.a;
        if(e1 != null) {
            e1.o0(t0);
        }
        this.a = null;
    }

    @Override  // r0.p
    public final void onDetach() {
        this.b = null;
        this.a = null;
    }

    public final void p0(t t0) {
        e e1;
        D0 d00;
        e e0 = this.a;
        if(e0 == null || !v.i(e0, k.u(t0))) {
            if(this.getNode().isAttached()) {
                H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                f.z(this, new g(h0, this, t0, 20));
                d00 = (D0)h0.a;
            }
            else {
                d00 = null;
            }
            e1 = (e)d00;
        }
        else {
            e1 = e0;
        }
        if(e1 != null && e0 == null) {
            e1.n0(t0);
            e1.p0(t0);
            e e2 = this.b;
            if(e2 != null) {
                e2.o0(t0);
            }
        }
        else if(e1 == null && e0 != null) {
            e e3 = this.b;
            if(e3 != null) {
                e3.n0(t0);
                e3.p0(t0);
            }
            e0.o0(t0);
        }
        else if(!q.b(e1, e0)) {
            if(e1 != null) {
                e1.n0(t0);
                e1.p0(t0);
            }
            if(e0 != null) {
                e0.o0(t0);
            }
        }
        else if(e1 == null) {
            e e4 = this.b;
            if(e4 != null) {
                e4.p0(t0);
            }
        }
        else {
            e1.p0(t0);
        }
        this.a = e1;
    }

    public final void q0(t t0) {
        e e0 = this.b;
        if(e0 == null) {
            e e1 = this.a;
            if(e1 != null) {
                e1.q0(t0);
            }
            return;
        }
        e0.q0(t0);
    }
}

