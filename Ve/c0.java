package Ve;

import kotlin.jvm.internal.q;

public final class c0 {
    public final e0 a;
    public final Z b;
    public static final c0 c;

    static {
        c0.c = new c0(null, null);
    }

    public c0(e0 e00, Z z0) {
        this.a = e00;
        this.b = z0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c0)) {
            return false;
        }
        return this.a == ((c0)object0).a ? q.b(this.b, ((c0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Z z0 = this.b;
        if(z0 != null) {
            v = z0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "KmTypeProjection(variance=" + this.a + ", type=" + this.b + ')';
    }
}

