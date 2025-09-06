package oc;

import kotlin.jvm.internal.q;

public final class t implements v {
    public final String a;

    public t(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t ? q.b(this.a, ((t)object0).a) : false;
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

