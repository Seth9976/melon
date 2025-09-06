package M;

import N0.M;
import N0.N;
import N0.O;
import java.util.List;
import je.x;
import r1.a;

public final class o implements M {
    public final int a;
    public static final o b;
    public static final o c;

    static {
        o.b = new o(0);
        o.c = new o(1);
    }

    public o(int v) {
        this.a = v;
        super();
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        int v1 = 0;
        if(this.a != 0) {
            int v2 = a.f(v) ? a.h(v) : 0;
            if(a.e(v)) {
                v1 = a.g(v);
            }
            return o0.w(v2, v1, x.a, n.k);
        }
        return o0.w(a.j(v), a.i(v), x.a, n.g);
    }
}

