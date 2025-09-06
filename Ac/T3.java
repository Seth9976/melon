package Ac;

import Pc.e;
import kotlin.jvm.internal.q;

public final class t3 implements e {
    public final u3 a;
    public final int b;

    public t3(u3 u30, int v) {
        this.a = u30;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t3)) {
            return false;
        }
        return q.b(this.a, ((t3)object0).a) ? this.b == ((t3)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickFilter(filterData=" + this.a + ", index=" + this.b + ")";
    }
}

