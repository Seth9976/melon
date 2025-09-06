package If;

import Hf.L;
import Hf.a0;
import Hf.d;
import Hf.x;
import kotlin.jvm.internal.q;

public final class l implements k {
    public final e c;
    public final tf.k d;

    public l() {
        this.c = e.a;
        this.d = new tf.k(tf.k.d);
    }

    public final boolean a(x x0, x x1) {
        q.g(x0, "a");
        q.g(x1, "b");
        return d.h(g.l(false, null, this.c, 6), x0.I(), x1.I());
    }

    public final boolean b(x x0, x x1) {
        q.g(x0, "subtype");
        q.g(x1, "supertype");
        L l0 = g.l(true, null, this.c, 6);
        a0 a00 = x0.I();
        a0 a01 = x1.I();
        return a00 == a01 ? true : d.f(l0, a00, a01);
    }
}

