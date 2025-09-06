package hd;

import Bc.c;
import ie.H;
import we.a;
import we.k;

public final class i0 implements a {
    public final int a;
    public final k b;
    public final c c;
    public final String d;

    public i0(k k0, c c0, String s, int v) {
        this.a = v;
        this.b = k0;
        this.c = c0;
        this.d = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                F0 f01 = new F0(this.c, this.d);
                this.b.invoke(f01);
                return H.a;
            }
            case 1: {
                G0 g00 = new G0(this.c, this.d);
                this.b.invoke(g00);
                return true;
            }
            default: {
                F0 f00 = new F0(this.c, this.d);
                this.b.invoke(f00);
                return H.a;
            }
        }
    }
}

