package androidx.lifecycle;

import kotlin.jvm.internal.q;

public final class k0 implements Runnable {
    public final F a;
    public final r b;
    public boolean c;

    public k0(F f0, r r0) {
        q.g(f0, "registry");
        q.g(r0, "event");
        super();
        this.a = f0;
        this.b = r0;
    }

    @Override
    public final void run() {
        if(!this.c) {
            this.a.f(this.b);
            this.c = true;
        }
    }
}

