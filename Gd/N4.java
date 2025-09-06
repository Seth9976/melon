package gd;

import ie.H;
import we.a;
import we.k;

public final class n4 implements a {
    public final int a;
    public final k b;
    public final q4 c;
    public final int d;

    public n4(k k0, q4 q40, int v, int v1) {
        this.a = v1;
        this.b = k0;
        this.c = q40;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                k k1 = this.b;
                if(k1 != null) {
                    k1.invoke(new x4(this.c, this.d));
                }
                return H.a;
            }
            case 1: {
                k k2 = this.b;
                if(k2 != null) {
                    k2.invoke(new y4(this.c, this.d));
                }
                return H.a;
            }
            default: {
                k k0 = this.b;
                if(k0 != null) {
                    k0.invoke(new w4(this.c, this.d));
                }
                return H.a;
            }
        }
    }
}

