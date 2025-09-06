package ie;

import java.io.Serializable;
import kotlin.jvm.internal.q;

public final class m implements Serializable {
    public final Object a;
    public final Object b;

    public m(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        return q.b(this.a, ((m)object0).a) ? q.b(this.b, ((m)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "(" + this.a + ", " + this.b + ')';
    }
}

