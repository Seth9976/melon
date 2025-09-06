package b;

import ie.H;
import kotlin.jvm.internal.r;
import we.a;

public final class p extends r implements a {
    public final int f;
    public final t g;

    public p(t t0, int v) {
        this.f = v;
        this.g = t0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                this.g.c();
                return H.a;
            }
            case 1: {
                this.g.b();
                return H.a;
            }
            default: {
                this.g.c();
                return H.a;
            }
        }
    }
}

