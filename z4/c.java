package z4;

import d5.v;
import h7.u0;
import we.a;

public final class c implements a {
    public final int a;
    public final v b;
    public final String c;

    public c(v v0, String s, int v1) {
        this.a = v1;
        this.b = v0;
        this.c = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            return this.b.k(this.c);
        }
        G4.a a0 = this.b.k(this.c);
        u0.w("PRAGMA query_only = 1", a0);
        return a0;
    }
}

