package dc;

import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final long b;

    public a(String s, long v) {
        this.a = s;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        return q.b(this.a, ((a)object0).a) ? this.b == ((a)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "NetworkEvent(eventName=" + this.a + ", timeMs=" + this.b + ")";
    }
}

