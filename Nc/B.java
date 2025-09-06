package nc;

import we.a;

public final class b implements a {
    public final int a;
    public final u0 b;

    public b(u0 u00, int v) {
        this.a = v;
        this.b = u00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return !((C0)this.b.h.getValue()).f || this.b.o ? false : true;
            }
            case 1: {
                return this.b.p();
            }
            default: {
                return this.b.p();
            }
        }
    }
}

