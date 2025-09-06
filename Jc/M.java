package jc;

import java.util.List;
import je.p;
import kotlin.jvm.internal.q;

public final class m {
    public final List a;
    public final boolean b;

    public m(List list0, boolean z) {
        q.g(list0, "memberKeyList");
        super();
        this.a = list0;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        return q.b(this.a, ((m)object0).a) ? this.b == ((m)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "State(" + ("memberKeyList=[" + p.q0(this.a, ",", null, null, null, 62) + "], ") + ("enable=" + this.b) + ")";
    }
}

