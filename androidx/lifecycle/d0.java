package androidx.lifecycle;

import E4.e;
import Q0.o0;
import kotlin.jvm.internal.q;

public final class d0 implements B, AutoCloseable {
    public final String a;
    public final c0 b;
    public boolean c;

    public d0(String s, c0 c00) {
        this.a = s;
        this.b = c00;
    }

    @Override
    public final void close() {
    }

    public final void f(e e0, t t0) {
        q.g(e0, "registry");
        q.g(t0, "lifecycle");
        if(this.c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.c = true;
        t0.a(this);
        e0.c(this.a, ((o0)this.b.b.f));
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        if(r0 == r.ON_DESTROY) {
            this.c = false;
            d0.getLifecycle().c(this);
        }
    }
}

