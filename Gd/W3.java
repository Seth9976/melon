package gd;

import Ac.p0;
import java.util.List;
import kotlin.jvm.internal.q;

public final class w3 extends p0 {
    public final List a;

    public w3(List list0) {
        q.g(list0, "list");
        super();
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w3 ? q.b(this.a, ((w3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickOrderList(list=" + this.a + ")";
    }
}

