package Ge;

import Df.r;
import kotlin.jvm.internal.q;
import lf.I;
import we.n;

public final class u implements n {
    public final int a;
    public static final u b;
    public static final u c;

    static {
        u.b = new u(0);
        u.c = new u(1);
    }

    public u(int v) {
        this.a = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            q.g(((r)object0), "$this$deserializeToDescriptor");
            q.g(((I)object1), "proto");
            return ((r)object0).f(((I)object1), true);
        }
        q.g(((r)object0), "$this$deserializeToDescriptor");
        q.g(((I)object1), "proto");
        return ((r)object0).f(((I)object1), true);
    }
}

