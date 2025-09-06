package cd;

import ie.H;
import w0.h;
import we.a;

public final class o implements a {
    public final int a;
    public final h b;
    public final b c;

    public o(h h0, b b0, int v) {
        this.a = v;
        this.b = h0;
        this.c = b0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            f f0 = new f(this.c);
            this.c.e.invoke(f0);
            return H.a;
        }
        h.a(this.b);
        c c0 = new c(this.c);
        this.c.e.invoke(c0);
        return H.a;
    }
}

