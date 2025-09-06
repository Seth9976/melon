package M6;

import a.a;

public final class j extends a {
    @Override  // a.a
    public final void K(p p0, p p1) {
        p0.b = p1;
    }

    @Override  // a.a
    public final void L(p p0, Thread thread0) {
        p0.a = thread0;
    }

    @Override  // a.a
    public final boolean l(h h0, e e0, e e1) {
        synchronized(h0) {
            if(h0.b == e0) {
                h0.b = e1;
                return true;
            }
        }
        return false;
    }

    @Override  // a.a
    public final boolean m(h h0, Object object0, Object object1) {
        synchronized(h0) {
            if(h0.a == object0) {
                h0.a = object1;
                return true;
            }
        }
        return false;
    }

    @Override  // a.a
    public final boolean n(q q0, p p0, p p1) {
        synchronized(q0) {
            if(q0.c == p0) {
                q0.c = p1;
                return true;
            }
        }
        return false;
    }

    @Override  // a.a
    public final e t(h h0) {
        e e1;
        e e0 = e.d;
        synchronized(h0) {
            e1 = h0.b;
            if(e1 != e0) {
                h0.b = e0;
            }
        }
        return e1;
    }

    @Override  // a.a
    public final p u(h h0) {
        p p1;
        p p0 = p.c;
        synchronized(h0) {
            p1 = h0.c;
            if(p1 != p0) {
                h0.c = p0;
            }
        }
        return p1;
    }
}

