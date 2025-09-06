package gd;

import ie.H;
import we.a;
import we.k;

public final class l3 implements a {
    public final int a;
    public final k b;
    public final q3 c;
    public final int d;

    public l3(k k0, q3 q30, int v, int v1) {
        this.a = v1;
        this.b = k0;
        this.c = q30;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                k k1 = this.b;
                if(k1 != null) {
                    k1.invoke(new y3(this.c, this.d));
                }
                return H.a;
            }
            case 1: {
                k k2 = this.b;
                if(k2 != null) {
                    k2.invoke(new z3(this.c, this.d));
                }
                return H.a;
            }
            default: {
                k k0 = this.b;
                if(k0 != null) {
                    k0.invoke(new x3(this.c, this.d));
                }
                return H.a;
            }
        }
    }
}

