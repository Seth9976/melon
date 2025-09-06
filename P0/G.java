package p0;

import we.k;

public final class g extends h {
    public final k e;
    public int f;

    public g(long v, l l0, k k0) {
        super(v, l0);
        this.e = k0;
        this.f = 1;
    }

    @Override  // p0.h
    public final void c() {
        if(!this.c) {
            this.l();
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
        ++this.f;
    }

    @Override  // p0.h
    public final void l() {
        int v = this.f - 1;
        this.f = v;
        if(v == 0) {
            this.a();
        }
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
        m.d(this);
        return new f(this.b, this.a, m.l(k0, this.e, true), this);
    }
}

