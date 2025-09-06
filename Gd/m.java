package gd;

import ie.H;
import we.a;
import we.k;

public final class m implements a {
    public final int a;
    public final k b;
    public final gd.k c;
    public final int d;

    public m(k k0, gd.k k1, int v, int v1) {
        this.a = v1;
        this.b = k0;
        this.c = k1;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            K2 k20 = new K2(this.c, this.d, 1);
            this.b.invoke(k20);
            return H.a;
        }
        K2 k21 = new K2(this.c, this.d, 0);
        this.b.invoke(k21);
        return H.a;
    }
}

