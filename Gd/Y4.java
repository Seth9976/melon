package gd;

import kotlin.jvm.internal.q;

public final class y4 extends Z3 {
    public final q4 a;
    public final int b;

    public y4(q4 q40, int v) {
        q.g(q40, "uiState");
        super();
        this.a = q40;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof y4)) {
            return false;
        }
        return q.b(this.a, ((y4)object0).a) ? this.b == ((y4)object0).b : false;
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

