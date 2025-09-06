package x1;

import B1.g;
import d5.f;
import d5.m;
import java.util.List;
import kotlin.jvm.internal.q;

public final class r implements k {
    public final g a;
    public final m b;

    public r(g g0) {
        this.a = g0;
        this.b = new m(1);
    }

    @Override  // x1.k
    public final void a(s s0, List list0) {
        f.S(this.a, s0, this.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!r.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.constraintlayout.compose.RawConstraintSet");
        return q.b(this.a, ((r)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

