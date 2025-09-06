package hd;

import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import w0.h;
import we.a;
import we.k;

public final class d0 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final H d;

    public d0(h h0, k k0, H h1, int v) {
        this.a = v;
        this.b = h0;
        this.c = k0;
        this.d = h1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            Object object0 = this.d.a;
            q.d(object0);
            this.c.invoke(object0);
            return ie.H.a;
        }
        h.a(this.b);
        Object object1 = this.d.a;
        q.d(object1);
        this.c.invoke(object1);
        return ie.H.a;
    }
}

