package androidx.fragment.app;

import e.b;
import java.util.concurrent.atomic.AtomicReference;

public final class y extends b {
    public final AtomicReference a;
    public final f.b b;

    public y(AtomicReference atomicReference0, f.b b0) {
        this.a = atomicReference0;
        this.b = b0;
    }

    @Override  // e.b
    public final f.b a() {
        return this.b;
    }

    @Override  // e.b
    public final void b(Object object0) {
        b b0 = (b)this.a.get();
        if(b0 == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        b0.b(object0);
    }

    @Override  // e.b
    public final void c() {
        b b0 = (b)this.a.getAndSet(null);
        if(b0 != null) {
            b0.c();
        }
    }
}

