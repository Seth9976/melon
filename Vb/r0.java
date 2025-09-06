package Vb;

import ac.d;
import kotlin.jvm.internal.q;

public final class r0 {
    public final d a;

    public r0(d d0) {
        this.a = d0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r0 ? q.b(this.a, ((r0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ABRangeRepeatStateChanged(state=" + this.a + ")";
    }
}

