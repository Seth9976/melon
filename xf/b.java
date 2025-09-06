package xf;

import Me.c;
import kotlin.jvm.internal.q;
import we.k;

public final class b implements k {
    public final int a;
    public static final b b;

    static {
        b.b = new b(0);
    }

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.d(((c)object0));
            return d.l(((c)object0));
        }
        q.g(((Me.k)object0), "it");
        return ((Me.k)object0).e();
    }
}

