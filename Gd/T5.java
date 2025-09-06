package gd;

import ie.H;
import we.a;
import we.k;

public final class t5 implements a {
    public final int a;
    public final k b;
    public final F5 c;

    public t5(k k0, F5 f50, int v) {
        this.a = v;
        this.b = k0;
        this.c = f50;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                k k1 = this.b;
                if(k1 != null) {
                    k1.invoke(new I5(this.c.e));
                }
                return H.a;
            }
            case 1: {
                k k2 = this.b;
                if(k2 != null) {
                    k2.invoke(new K5(this.c.e));
                }
                return H.a;
            }
            default: {
                k k0 = this.b;
                if(k0 != null) {
                    k0.invoke(new I5(this.c.e));
                }
                return H.a;
            }
        }
    }
}

