package n1;

import G.L;
import kotlin.jvm.internal.q;

public final class h {
    public final L a;
    public final r b;

    public h(L l0, r r0) {
        this.a = l0;
        this.b = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        return q.b(this.a, ((h)object0).a) ? q.b(this.b, ((h)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "InfiniteTransitionSearchInfo(infiniteTransition=" + this.a + ", toolingState=" + this.b + ')';
    }
}

