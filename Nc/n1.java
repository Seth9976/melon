package Nc;

import ie.H;
import w0.h;
import we.a;

public final class n1 implements a {
    public final int a;
    public final h b;
    public final p1 c;

    public n1(h h0, p1 p10, int v) {
        this.a = v;
        this.b = h0;
        this.c = p10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            r1 r10 = new r1(this.c);
            this.c.c.invoke(r10);
            return H.a;
        }
        h.a(this.b);
        p1 p10 = this.c;
        if(p10 != null) {
            q1 q10 = new q1(p10);
            p10.c.invoke(q10);
        }
        return H.a;
    }
}

