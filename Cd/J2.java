package cd;

import ie.H;
import we.a;

public final class j2 implements a {
    public final int a;
    public final d2 b;
    public final String c;

    public j2(d2 d20, String s, int v) {
        this.a = v;
        this.b = d20;
        this.c = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            g2 g20 = new g2(this.b, this.c);
            this.b.b.invoke(g20);
            return H.a;
        }
        e2 e20 = new e2(this.b, this.c);
        this.b.b.invoke(e20);
        return H.a;
    }
}

