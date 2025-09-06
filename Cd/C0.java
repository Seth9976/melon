package cd;

import bd.s;
import com.melon.ui.K4;
import e;
import kotlin.jvm.internal.q;

public final class c0 implements K4 {
    public final s a;
    public final e b;

    public c0(s s0, e e0) {
        this.a = s0;
        this.b = e0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c0)) {
            return false;
        }
        return q.b(this.a, ((c0)object0).a) ? q.b(this.b, ((c0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        e e0 = this.b;
        if(e0 != null) {
            v = e0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "FlexibleLiveSlotUiState(headerUiState=" + this.a + ", itemUiState=" + this.b + ")";
    }
}

