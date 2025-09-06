package S2;

import kotlin.jvm.internal.q;

public final class d extends c {
    public d(int v) {
        this(a.b);
    }

    public d(c c0) {
        q.g(c0, "initialExtras");
        q.g(c0.a, "initialExtras");
        super();
        this.a.putAll(c0.a);
    }

    @Override  // S2.c
    public final Object a(b b0) {
        return this.a.get(b0);
    }
}

