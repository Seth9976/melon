package cd;

import ie.H;
import we.a;

public final class h0 implements a {
    public final int a;
    public final j0 b;

    public h0(j0 j00, int v) {
        this.a = v;
        this.b = j00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            o0 o00 = new o0(this.b);
            this.b.c.invoke(o00);
            return H.a;
        }
        n0 n00 = new n0(this.b);
        this.b.c.invoke(n00);
        return H.a;
    }
}

