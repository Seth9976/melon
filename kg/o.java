package kg;

import kotlin.jvm.internal.r;
import we.a;

public final class o extends r implements a {
    public final int f;
    public final p g;

    public o(p p0, int v) {
        this.f = v;
        this.g = p0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return je.p.P0(this.g.c.values());
            }
            case 1: {
                return je.p.P0(this.g.d.values());
            }
            default: {
                return new kg.r(this.g);
            }
        }
    }
}

