package df;

import Se.n;
import kotlin.jvm.internal.q;
import qf.e;

public final class r {
    public final e a;
    public final n b;

    public r(e e0, n n0) {
        q.g(e0, "name");
        super();
        this.a = e0;
        this.b = n0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof r && q.b(this.a, ((r)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

