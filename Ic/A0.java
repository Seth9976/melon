package Ic;

import Ac.p0;
import Jc.c0;
import kotlin.jvm.internal.q;

public final class a0 extends p0 {
    public final c0 a;
    public final int b;

    public a0(c0 c00, int v) {
        q.g(c00, "uiState");
        super();
        this.a = c00;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a0)) {
            return false;
        }
        return q.b(this.a, ((a0)object0).a) ? this.b == ((a0)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickVideoItem(uiState=" + this.a + ", position=" + this.b + ")";
    }
}

