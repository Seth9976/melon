package df;

import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class n implements k {
    public final int a;
    public final o b;

    public n(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((e)object0), "it");
            return this.b.O(((e)object0));
        }
        q.g(((e)object0), "it");
        return this.b.N(((e)object0));
    }
}

