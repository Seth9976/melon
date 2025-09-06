package cd;

import ie.H;
import we.a;

public final class z implements a {
    public final int a;
    public final F b;

    public z(F f0, int v) {
        this.a = v;
        this.b = f0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            a a0 = this.b.a.j;
            if(a0 != null) {
                a0.invoke();
            }
            return H.a;
        }
        a a1 = this.b.a.i;
        if(a1 != null) {
            a1.invoke();
        }
        return H.a;
    }
}

