package Vc;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class m0 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final h0 d;

    public m0(h h0, k k0, h0 h00, int v) {
        this.a = v;
        this.b = h0;
        this.c = k0;
        this.d = h00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            k k0 = this.c;
            if(k0 != null) {
                k0.invoke(new k0(this.d));
            }
            return H.a;
        }
        h.a(this.b);
        k k1 = this.c;
        if(k1 != null) {
            k1.invoke(new j0(this.d));
        }
        return H.a;
    }
}

