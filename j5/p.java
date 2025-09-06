package j5;

import N0.Z;
import N0.a0;
import ie.H;
import we.k;

public final class p implements k {
    public final int a;
    public final a0 b;

    public p(a0 a00, int v) {
        this.a = v;
        this.b = a00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            Z.g(((Z)object0), this.b, 0, 0);
            return H.a;
        }
        Z.e(((Z)object0), this.b, 0, 0);
        return H.a;
    }
}

