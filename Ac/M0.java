package Ac;

import java.util.List;
import kotlin.jvm.internal.q;

public final class m0 extends n0 {
    public final List a;

    public m0(List list0) {
        q.g(list0, "list");
        super();
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m0 ? q.b(this.a, ((m0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(list=" + this.a + ")";
    }
}

