package ld;

import Kd.b;
import Kd.c;
import Kd.d;
import Kd.e;
import Kd.g;
import ie.H;
import we.a;

public final class i implements a {
    public final int a;
    public final m b;
    public final g c;
    public final int d;

    public i(m m0, g g0, int v, int v1) {
        this.a = v1;
        this.b = m0;
        this.c = g0;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                c c0 = new c(this.c, this.d);
                this.b.sendUserEvent(c0);
                return H.a;
            }
            case 1: {
                d d0 = new d(this.c, this.d);
                this.b.sendUserEvent(d0);
                return H.a;
            }
            case 2: {
                Kd.a a1 = new Kd.a(this.c, this.d);
                this.b.sendUserEvent(a1);
                return H.a;
            }
            case 3: {
                b b0 = new b(this.c, this.d);
                this.b.sendUserEvent(b0);
                return true;
            }
            case 4: {
                d d1 = new d(this.c, this.d);
                this.b.sendUserEvent(d1);
                return true;
            }
            case 5: {
                e e0 = new e(this.c, this.d);
                this.b.sendUserEvent(e0);
                return true;
            }
            default: {
                Kd.a a0 = new Kd.a(this.c, this.d);
                this.b.sendUserEvent(a0);
                return true;
            }
        }
    }
}

