package d5;

import U4.D;
import kotlin.jvm.internal.q;

public final class o {
    public String a;
    public D b;

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o)) {
            return false;
        }
        return q.b(this.a, ((o)object0).a) ? this.b == ((o)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "IdAndState(id=" + this.a + ", state=" + this.b + ')';
    }
}

