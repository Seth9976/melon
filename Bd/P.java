package bd;

import ie.H;
import w0.h;
import we.a;

public final class p implements a {
    public final int a;
    public final h b;
    public final s c;

    public p(h h0, s s0, int v) {
        this.a = v;
        this.b = h0;
        this.c = s0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            a a0 = this.c.i;
            if(a0 != null) {
                a0.invoke();
            }
            return H.a;
        }
        h.a(this.b);
        a a1 = this.c.j;
        if(a1 != null) {
            a1.invoke();
        }
        return H.a;
    }
}

