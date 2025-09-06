package I6;

import java.io.Serializable;

public final class x0 extends n0 implements Serializable {
    public final n0 a;
    private static final long serialVersionUID;

    public x0(n0 n00) {
        this.a = n00;
    }

    @Override  // I6.n0
    public final n0 a() {
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
        return object0 instanceof x0 ? this.a.equals(((x0)object0).a) : false;
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

