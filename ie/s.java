package ie;

import java.io.Serializable;
import kotlin.jvm.internal.q;

public final class s implements Serializable {
    public final Object a;
    public final Object b;
    public final Object c;

    public s(Object object0, Object object1, Object object2) {
        this.a = object0;
        this.b = object1;
        this.c = object2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s)) {
            return false;
        }
        if(!q.b(this.a, ((s)object0).a)) {
            return false;
        }
        return q.b(this.b, ((s)object0).b) ? q.b(this.c, ((s)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        Object object0 = this.c;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ')';
    }
}

