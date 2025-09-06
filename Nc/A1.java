package Nc;

import ie.H;
import w0.h;
import we.a;

public final class a1 implements a {
    public final int a;
    public final h b;
    public final d1 c;

    public a1(h h0, d1 d10, int v) {
        this.a = v;
        this.b = h0;
        this.c = d10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            f1 f10 = new f1(this.c);
            this.c.d.invoke(f10);
            return H.a;
        }
        h.a(this.b);
        e1 e10 = new e1(this.c);
        this.c.d.invoke(e10);
        return H.a;
    }
}

