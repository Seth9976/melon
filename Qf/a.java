package qf;

import Tf.v;
import d5.n;
import kotlin.jvm.internal.q;

public final class a {
    public final c a;
    public final e b;

    static {
        n.E(g.f);
    }

    public a(c c0, e e0) {
        q.g(c0, "packageName");
        super();
        this.a = c0;
        this.b = e0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a && q.b(this.a, ((a)object0).a) && this.b.equals(((a)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() + 0x20F) * 961;
    }

    @Override
    public final String toString() {
        return v.o0(this.a.a.a, '.', '/') + "/" + this.b;
    }
}

