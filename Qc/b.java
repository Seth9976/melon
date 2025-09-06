package qc;

import oc.Q;
import we.a;

public final class b implements a {
    public final int a;
    public final n0 b;

    public b(n0 n00, int v) {
        this.a = v;
        this.b = n00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return !((D0)this.b.g.getValue()).g || this.b.p ? false : true;
            }
            case 1: {
                return this.b.p();
            }
            case 2: {
                return this.b.p();
            }
            case 3: {
                return (Q)this.b.g.getValue();
            }
            default: {
                return this.b.h;
            }
        }
    }
}

