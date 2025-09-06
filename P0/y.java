package p0;

import we.k;

public final class y extends h {
    public final h e;
    public final boolean f;
    public k g;
    public final long h;

    public y(h h0, k k0, boolean z) {
        super(0L, l.e);
        k k1;
        this.e = h0;
        this.f = z;
        if(h0 == null) {
            k1 = m.i.e;
        }
        else {
            k1 = h0.e();
            if(k1 == null) {
                k1 = m.i.e;
            }
        }
        this.g = m.l(k0, k1, false);
        this.h = 0x6EA9DL;
    }

    @Override  // p0.h
    public final void c() {
        this.c = true;
        if(this.f) {
            h h0 = this.e;
            if(h0 != null) {
                h0.c();
            }
        }
    }

    @Override  // p0.h
    public final l d() {
        return this.v().d();
    }

    @Override  // p0.h
    public final k e() {
        return this.g;
    }

    @Override  // p0.h
    public final boolean f() {
        return this.v().f();
    }

    @Override  // p0.h
    public final long g() {
        return this.v().g();
    }

    @Override  // p0.h
    public final k i() {
        return null;
    }

    @Override  // p0.h
    public final void k() {
        q.h();
        throw null;
    }

    @Override  // p0.h
    public final void l() {
        q.h();
        throw null;
    }

    @Override  // p0.h
    public final void m() {
        this.v().m();
    }

    @Override  // p0.h
    public final void n(t t0) {
        this.v().n(t0);
    }

    @Override  // p0.h
    public final h u(k k0) {
        k k1 = m.l(k0, this.g, true);
        return m.h(this.v().u(null), k1, true);
    }

    public final h v() {
        h h0 = this.e;
        return h0 == null ? m.i : h0;
    }
}

