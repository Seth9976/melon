package jc;

import De.I;
import kotlin.jvm.internal.q;
import va.e;

public final class d {
    public final String a;
    public final long b;

    public d(String s) {
        q.g(s, "message");
        super();
        this.a = s;
        this.b = System.currentTimeMillis();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? this.b == ((d)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return e.c(I.b0(this.b), " ", this.a);
    }
}

