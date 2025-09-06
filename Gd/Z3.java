package gd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class z3 extends p0 {
    public final q3 a;
    public final int b;

    public z3(q3 q30, int v) {
        q.g(q30, "uiState");
        super();
        this.a = q30;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z3)) {
            return false;
        }
        return q.b(this.a, ((z3)object0).a) ? this.b == ((z3)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "LongClickPlaylistItem(uiState=" + this.a + ", position=" + this.b + ")";
    }
}

