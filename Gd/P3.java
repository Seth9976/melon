package gd;

import java.util.List;
import kotlin.jvm.internal.q;

public final class p3 extends r3 {
    public final int a;
    public final List b;

    public p3(int v, List list0) {
        q.g(list0, "orderList");
        super();
        this.a = v;
        this.b = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p3)) {
            return false;
        }
        return this.a == ((p3)object0).a ? q.b(this.b, ((p3)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "HeaderItemUiState(orderIndex=" + this.a + ", orderList=" + this.b + ")";
    }
}

