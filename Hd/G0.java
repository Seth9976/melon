package hd;

import Bc.i;
import androidx.compose.runtime.l;
import ie.H;
import we.a;
import we.n;

public final class g0 implements n {
    public final int a;
    public final i b;
    public final a c;

    public g0(i i0, a a0, int v, int v1) {
        this.a = v1;
        this.b = i0;
        this.c = a0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).getClass();
        switch(this.a) {
            case 0: {
                hd.a.d(this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            case 1: {
                hd.a.c(this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            default: {
                hd.a.b(this.b, this.c, ((l)object0), 1);
                return H.a;
            }
        }
    }
}

