package Fd;

import B.a;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class i implements n {
    public final int a;
    public final D b;

    public i(D d0) {
        this.a = 1;
        super();
        this.b = d0;
    }

    public i(D d0, int v) {
        this.a = 0;
        super();
        this.b = d0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                G g0 = (G)a.r(((Y)this.b.getViewModel()).p, ((p)(((l)object0))), 0).getValue();
                this.b.s(g0, ((p)(((l)object0))), 0);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        ((Integer)object1).getClass();
        this.b.n(((l)object0), 7);
        return H.a;
    }
}

