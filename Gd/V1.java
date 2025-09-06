package gd;

import ie.H;
import we.a;
import we.k;

public final class v1 implements a {
    public final int a;
    public final k b;
    public final z1 c;

    public v1(k k0, z1 z10, int v) {
        this.a = v;
        this.b = k0;
        this.c = z10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                k k1 = this.b;
                if(k1 != null) {
                    k1.invoke(new I1(this.c));
                }
                return H.a;
            }
            case 1: {
                k k2 = this.b;
                if(k2 != null) {
                    k2.invoke(new H1(this.c));
                }
                return H.a;
            }
            case 2: {
                k k3 = this.b;
                if(k3 != null) {
                    k3.invoke(new L1(this.c));
                }
                return H.a;
            }
            case 3: {
                k k4 = this.b;
                if(k4 != null) {
                    k4.invoke(new F1(this.c));
                }
                return H.a;
            }
            default: {
                k k0 = this.b;
                if(k0 != null) {
                    k0.invoke(new E1(this.c));
                }
                return H.a;
            }
        }
    }
}

