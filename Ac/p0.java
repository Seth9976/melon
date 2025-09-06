package Ac;

import a.a;
import androidx.compose.runtime.l;
import d3.g;
import ie.H;
import r0.q;
import we.n;

public final class P0 implements n {
    public final int a;
    public final q b;
    public final String c;
    public final String d;

    public P0(q q0, String s, String s1, int v, int v1) {
        this.a = v1;
        this.b = q0;
        this.c = s;
        this.d = s1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).getClass();
        switch(this.a) {
            case 0: {
                o1.e(this.b, this.c, this.d, ((l)object0), 1);
                return H.a;
            }
            case 1: {
                a.d(this.b, this.c, this.d, ((l)object0), 7);
                return H.a;
            }
            default: {
                g.j(this.b, this.c, this.d, ((l)object0), 1);
                return H.a;
            }
        }
    }
}

