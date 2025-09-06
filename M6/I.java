package M6;

import a.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class i extends a {
    public static final AtomicReferenceFieldUpdater g;
    public static final AtomicReferenceFieldUpdater h;
    public static final AtomicReferenceFieldUpdater i;
    public static final AtomicReferenceFieldUpdater j;
    public static final AtomicReferenceFieldUpdater k;

    static {
        i.g = AtomicReferenceFieldUpdater.newUpdater(p.class, Thread.class, "a");
        i.h = AtomicReferenceFieldUpdater.newUpdater(p.class, p.class, "b");
        i.i = AtomicReferenceFieldUpdater.newUpdater(q.class, p.class, "c");
        i.j = AtomicReferenceFieldUpdater.newUpdater(q.class, e.class, "b");
        i.k = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "a");
    }

    @Override  // a.a
    public final void K(p p0, p p1) {
        i.h.lazySet(p0, p1);
    }

    @Override  // a.a
    public final void L(p p0, Thread thread0) {
        i.g.lazySet(p0, thread0);
    }

    @Override  // a.a
    public final boolean l(h h0, e e0, e e1) {
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = i.j;
            if(atomicReferenceFieldUpdater0.compareAndSet(h0, e0, e1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(h0) == e0);
        return false;
    }

    @Override  // a.a
    public final boolean m(h h0, Object object0, Object object1) {
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = i.k;
            if(atomicReferenceFieldUpdater0.compareAndSet(h0, object0, object1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(h0) == object0);
        return false;
    }

    @Override  // a.a
    public final boolean n(q q0, p p0, p p1) {
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = i.i;
            if(atomicReferenceFieldUpdater0.compareAndSet(q0, p0, p1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(q0) == p0);
        return false;
    }

    @Override  // a.a
    public final e t(h h0) {
        return (e)i.j.getAndSet(h0, e.d);
    }

    @Override  // a.a
    public final p u(h h0) {
        return (p)i.i.getAndSet(h0, p.c);
    }
}

