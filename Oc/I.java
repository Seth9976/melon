package oc;

import kotlin.jvm.internal.q;

public final class i implements l {
    public final String a;

    public i(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? q.b(this.a, ((i)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Failure(reason=" + this.a + ")";
    }
}

