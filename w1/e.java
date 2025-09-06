package w1;

import df.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class e extends v {
    public final AtomicReferenceFieldUpdater e;
    public final AtomicReferenceFieldUpdater f;
    public final AtomicReferenceFieldUpdater g;
    public final AtomicReferenceFieldUpdater h;
    public final AtomicReferenceFieldUpdater i;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4) {
        this.e = atomicReferenceFieldUpdater0;
        this.f = atomicReferenceFieldUpdater1;
        this.g = atomicReferenceFieldUpdater2;
        this.h = atomicReferenceFieldUpdater3;
        this.i = atomicReferenceFieldUpdater4;
    }

    @Override  // df.v
    public final void H(h h0, h h1) {
        this.f.lazySet(h0, h1);
    }

    @Override  // df.v
    public final void I(h h0, Thread thread0) {
        this.e.lazySet(h0, thread0);
    }

    @Override  // df.v
    public final boolean o(i i0, d d0, d d1) {
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = this.h;
            if(atomicReferenceFieldUpdater0.compareAndSet(i0, d0, d1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(i0) == d0);
        return false;
    }

    @Override  // df.v
    public final boolean p(i i0, Object object0, Object object1) {
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = this.i;
            if(atomicReferenceFieldUpdater0.compareAndSet(i0, object0, object1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(i0) == object0);
        return false;
    }

    @Override  // df.v
    public final boolean q(i i0, h h0, h h1) {
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = this.g;
            if(atomicReferenceFieldUpdater0.compareAndSet(i0, h0, h1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(i0) == h0);
        return false;
    }
}

