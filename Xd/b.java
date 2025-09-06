package xd;

import d5.v;
import ie.H;
import we.a;

public final class b implements a {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            return ((v)this.b).k(":memory:");
        }
        ((c)this.b).dismiss();
        return H.a;
    }
}

