package hc;

import ac.o;

public final class q implements s {
    public final L8.s a;
    public final o b;

    public q(L8.s s0, o o0) {
        kotlin.jvm.internal.q.g(s0, "controller");
        super();
        this.a = s0;
        this.b = o0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        return kotlin.jvm.internal.q.b(this.a, ((q)object0).a) ? kotlin.jvm.internal.q.b(this.b, ((q)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Dlna(controller=" + this.a + ", contentsInfo=" + this.b + ")";
    }
}

