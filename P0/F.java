package p0;

import we.k;

public final class f extends h {
    public final k e;
    public final h f;

    public f(long v, l l0, k k0, h h0) {
        super(v, l0);
        this.e = k0;
        this.f = h0;
        h0.k();
    }

    @Override  // p0.h
    public final void c() {
        h h0 = this.f;
        if(!this.c) {
            if(this.b != h0.g()) {
                this.a();
            }
            h0.l();
            this.c = true;
            synchronized(m.b) {
                this.o();
            }
        }
    }

    @Override  // p0.h
    public final k e() {
        return this.e;
    }

    @Override  // p0.h
    public final boolean f() {
        return true;
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
    }

    @Override  // p0.h
    public final void n(t t0) {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override  // p0.h
    public final h u(k k0) {
        return new f(this.b, this.a, m.l(k0, this.e, true), this.f);
    }
}

