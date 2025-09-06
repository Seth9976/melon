package Ff;

import Df.B;
import g0.e;
import ie.H;
import kotlin.jvm.internal.a;
import kotlin.jvm.internal.q;
import lf.T;
import we.k;

public final class j extends a implements k {
    public final int a;

    public j(int v, Object object0, Class class0, String s, String s1, int v1, int v2) {
        this.a = v2;
        super(v, v1, class0, object0, s, s1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            ((e)this.receiver).b(((W0.j)object0));
            return H.a;
        }
        q.g(((T)object0), "p0");
        return ((B)this.receiver).d(((T)object0), true);
    }
}

