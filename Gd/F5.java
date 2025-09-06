package gd;

import ie.H;
import we.a;
import we.k;

public final class f5 implements a {
    public final int a;
    public final k b;
    public final j5 c;

    public f5(k k0, j5 j50, int v) {
        this.a = v;
        this.b = k0;
        this.c = j50;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            k k0 = this.b;
            if(k0 != null) {
                k0.invoke(new I5(this.c.c));
            }
            return H.a;
        }
        k k1 = this.b;
        if(k1 != null) {
            k1.invoke(new K5(this.c.c));
        }
        return H.a;
    }
}

