package pd;

import Xb.j;
import kotlin.jvm.internal.q;

public final class g {
    public final d a;
    public final j b;

    public g(d d0, j j0) {
        this.a = d0;
        this.b = j0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        return q.b(this.a, ((g)object0).a) ? q.b(this.b, ((g)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        j j0 = this.b;
        if(j0 != null) {
            v = j0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "PlaybackUiState(foregroundUi=" + this.a + ", pendingEvent=" + this.b + ")";
    }
}

