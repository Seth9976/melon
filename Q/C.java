package Q;

import java.util.List;
import kg.p;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

public final class c extends r implements a {
    public final int f;
    public final List g;

    public c(List list0) {
        this.f = 0;
        this.g = list0;
        super(0);
    }

    public c(p p0, long v, List list0) {
        this.f = 1;
        this.g = list0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            throw null;
        }
        Object object0 = this.g.get(2);
        q.e(object0, "null cannot be cast to non-null type kotlin.Int");
        return (Integer)object0;
    }
}

