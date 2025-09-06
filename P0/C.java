package p0;

import F.Q;
import G.d0;
import we.k;

public final class c extends d {
    @Override  // p0.d
    public final d C(k k0, k k1) {
        return (d)(((h)m.f(new d0(3, new b(k0, k1, 0)))));
    }

    @Override  // p0.d
    public final void c() {
        synchronized(m.b) {
            this.o();
        }
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
        m.a();
    }

    @Override  // p0.d
    public final h u(k k0) {
        return (g)(((h)m.f(new d0(3, new Q(3, k0)))));
    }

    @Override  // p0.d
    public final q w() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }
}

