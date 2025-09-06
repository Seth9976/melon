package Ac;

import Pc.e;
import kotlin.jvm.internal.q;

public final class y3 implements e {
    public final A3 a;
    public final int b;

    public y3(A3 a30, int v) {
        this.a = a30;
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
        return "ClickItem(sortData=" + this.a + ", index=" + this.b + ")";
    }
}

