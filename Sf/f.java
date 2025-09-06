package sf;

import Hf.P;
import Hf.b0;
import Hf.x;
import kotlin.jvm.internal.q;
import we.k;

public final class f implements k {
    public final int a;
    public final g b;

    public f(g g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.d(((x)object0));
            return this.b.X(((x)object0));
        }
        q.g(((P)object0), "it");
        if(((P)object0).c()) {
            return "*";
        }
        x x0 = ((P)object0).b();
        q.f(x0, "getType(...)");
        String s = this.b.X(x0);
        return ((P)object0).a() == b0.c ? s : ((P)object0).a() + ' ' + s;
    }
}

