package p0;

import androidx.collection.L;
import we.k;

public final class x extends d {
    public final d o;
    public final boolean p;
    public final boolean q;
    public k r;
    public k s;
    public final long t;

    public x(d d0, k k0, k k1, boolean z, boolean z1) {
        k k4;
        k k2;
        if(d0 == null) {
            k2 = m.i.e;
        }
        else {
            k2 = d0.y();
            if(k2 == null) {
                k2 = m.i.e;
            }
        }
        k k3 = m.l(k0, k2, z);
        if(d0 == null) {
            k4 = m.i.f;
        }
        else {
            k4 = d0.i();
            if(k4 == null) {
                k4 = m.i.f;
            }
        }
        k k5 = m.b(k1, k4);
        super(0L, l.e, k3, k5);
        this.o = d0;
        this.p = z;
        this.q = z1;
        this.r = this.e;
        this.s = this.f;
        this.t = 0x709E5L;
    }

    @Override  // p0.d
    public final void B(L l0) {
        q.h();
        throw null;
    }

    @Override  // p0.d
    public final d C(k k0, k k1) {
        k k2 = m.l(k0, this.r, true);
        k k3 = m.b(k1, this.s);
        return !this.p ? new x(this.D().C(null, k3), k2, k3, false, true) : this.D().C(k2, k3);
    }

    public final d D() {
        d d0 = this.o;
        return d0 == null ? m.i : d0;
    }

    @Override  // p0.d
    public final void c() {
        this.c = true;
        if(this.q) {
            d d0 = this.o;
            if(d0 != null) {
                d0.c();
            }
        }
    }

    @Override  // p0.h
    public final l d() {
        return this.D().d();
    }

    @Override  // p0.d
    public final k e() {
        return this.r;
    }

    @Override  // p0.d
    public final boolean f() {
        return this.D().f();
    }

    @Override  // p0.h
    public final long g() {
        return this.D().g();
    }

    @Override  // p0.d
    public final int h() {
        return this.D().h();
    }

    @Override  // p0.d
    public final k i() {
        return this.s;
    }

    @Override  // p0.d
    public final void k() {
        q.h();
        throw null;
    }

    @Override  // p0.d
    public final void l() {
        q.h();
        throw null;
    }

    @Override  // p0.d
    public final void m() {
        this.D().m();
    }

    @Override  // p0.d
    public final void n(t t0) {
        this.D().n(t0);
    }

    @Override  // p0.h
    public final void r(l l0) {
        q.h();
        throw null;
    }

    @Override  // p0.h
    public final void s(long v) {
        q.h();
        throw null;
    }

    @Override  // p0.d
    public final void t(int v) {
        this.D().t(v);
    }

    @Override  // p0.d
    public final h u(k k0) {
        k k1 = m.l(k0, this.r, true);
        return this.p ? this.D().u(k1) : m.h(this.D().u(null), k1, true);
    }

    @Override  // p0.d
    public final q w() {
        return this.D().w();
    }

    @Override  // p0.d
    public final L x() {
        return this.D().x();
    }

    @Override  // p0.d
    public final k y() {
        return this.r;
    }
}

