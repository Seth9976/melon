package hd;

import ie.H;
import we.a;
import we.k;

public final class n0 implements a {
    public final int a;
    public final k b;
    public final Bc.a c;
    public final String d;

    public n0(k k0, Bc.a a0, String s, int v) {
        this.a = v;
        this.b = k0;
        this.c = a0;
        this.d = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                p0 p00 = new p0(this.c, this.d);
                this.b.invoke(p00);
                return H.a;
            }
            case 1: {
                p0 p01 = new p0(this.c, this.d);
                this.b.invoke(p01);
                return H.a;
            }
            default: {
                q0 q00 = new q0(this.c, this.d);
                this.b.invoke(q00);
                return true;
            }
        }
    }
}

