package gd;

import Ac.m4;
import java.util.List;
import kotlin.jvm.internal.q;

public final class l0 extends m4 {
    public final List a;

    public l0(List list0) {
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l0 ? q.b(this.a, ((l0)object0).a) : false;
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

