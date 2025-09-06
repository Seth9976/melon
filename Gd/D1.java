package gd;

import ie.H;
import we.a;
import we.k;

public final class d1 implements a {
    public final int a;
    public final k b;
    public final f1 c;

    public d1(k k0, f1 f10, int v) {
        this.a = v;
        this.b = k0;
        this.c = f10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            k k0 = this.b;
            if(k0 != null) {
                k0.invoke(new j1(this.c));
            }
            return H.a;
        }
        k k1 = this.b;
        if(k1 != null) {
            k1.invoke(new k1(this.c));
        }
        return H.a;
    }
}

