package b2;

import kotlin.jvm.internal.q;

public final class f extends e {
    public final Object c;

    public f(int v) {
        super(v, 0);
        this.c = new Object();
    }

    @Override  // b2.e
    public final Object acquire() {
        synchronized(this.c) {
            return super.acquire();
        }
    }

    @Override  // b2.e
    public final boolean release(Object object0) {
        q.g(object0, "instance");
        synchronized(this.c) {
            return super.release(object0);
        }
    }
}

