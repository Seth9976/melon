package Vc;

import ie.H;
import w0.h;
import we.a;

public final class p implements a {
    public final int a;
    public final h b;
    public final r c;

    public p(h h0, r r0, int v) {
        this.a = v;
        this.b = h0;
        this.c = r0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            s s0 = new s(this.c);
            this.c.b.invoke(s0);
            return H.a;
        }
        h.a(this.b);
        this.c.b.invoke(t.a);
        return H.a;
    }
}

