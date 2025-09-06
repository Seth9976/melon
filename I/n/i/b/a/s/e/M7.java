package i.n.i.b.a.s.e;

import java.io.Serializable;

public final class m7 extends o4 implements Serializable {
    public final o4 a;

    public m7(o4 o40) {
        this.a = o40;
    }

    @Override  // i.n.i.b.a.s.e.o4
    public final o4 a() {
        return this.a;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return this.a.compare(object1, object0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof m7 ? this.a.equals(((m7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return -this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a + ".reverse()";
    }
}

