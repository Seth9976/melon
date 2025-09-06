package jd;

import gd.Z3;
import java.util.List;
import kotlin.jvm.internal.q;

public final class c0 extends Z3 {
    public final List a;

    public c0(List list0) {
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c0 ? q.b(this.a, ((c0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "SendImage(list=" + this.a + ")";
    }
}

