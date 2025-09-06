package Dd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class u1 extends p0 {
    public final String a;

    public u1(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u1 ? q.b(this.a, ((u1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "App(appVal=" + this.a + ")";
    }
}

