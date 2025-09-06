package s0;

import X0.n;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;
import x0.c;

public final class j {
    public final List a;
    public c b;
    public final k c;
    public final int d;

    static {
    }

    public j(List list0, k k0) {
        this.a = list0;
        this.b = null;
        this.c = k0;
        this.d = n.a.addAndGet(1);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j)) {
            return false;
        }
        if(!q.b(this.a, ((j)object0).a)) {
            return false;
        }
        return q.b(this.b, ((j)object0).b) ? this.c == ((j)object0).c : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        k k0 = this.c;
        if(k0 != null) {
            v1 = k0.hashCode();
        }
        return (v * 0x1F + v2) * 0x1F + v1;
    }
}

