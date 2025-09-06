package kd;

import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import jd.x2;
import we.k;
import we.n;

public final class i implements n {
    public final int a;
    public final k b;
    public final k c;
    public final long d;
    public final Object e;

    public i(List list0, k k0, long v, k k1, int v1) {
        this.a = 0;
        super();
        this.e = list0;
        this.b = k0;
        this.d = v;
        this.c = k1;
    }

    public i(x2 x20, k k0, k k1, long v, int v1) {
        this.a = 1;
        super();
        this.e = x20;
        this.b = k0;
        this.c = k1;
        this.d = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            G.a(((x2)this.e), this.b, this.c, this.d, ((l)object0), 1);
            return H.a;
        }
        ((Integer)object1).getClass();
        G.b(((List)this.e), this.b, this.d, this.c, ((l)object0), 1);
        return H.a;
    }
}

