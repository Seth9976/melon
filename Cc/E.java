package Cc;

import ie.H;
import we.a;
import we.k;

public final class e implements a {
    public final int a;
    public final k b;
    public final int c;

    public e(k k0, int v, int v1) {
        this.a = v1;
        this.b = k0;
        this.c = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            k k0 = this.b;
            if(k0 != null) {
                k0.invoke(this.c);
            }
            return H.a;
        }
        k k1 = this.b;
        if(k1 != null) {
            k1.invoke(this.c);
        }
        return H.a;
    }
}

