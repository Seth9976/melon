package gd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class y3 extends p0 {
    public final q3 a;
    public final int b;

    public y3(q3 q30, int v) {
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
        if(!(object0 instanceof y3)) {
            return false;
        }
        return q.b(this.a, ((y3)object0).a) ? this.b == ((y3)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickPlaylistItem(uiState=" + this.a + ", position=" + this.b + ")";
    }
}

