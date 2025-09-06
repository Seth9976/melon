package j0;

import T3.e;
import je.g;
import k0.a;

public class b extends g {
    public final j a;
    public final int b;
    public static final b c;

    static {
        b.c = new b(j.e, 0);
    }

    public b(j j0, int v) {
        this.a = j0;
        this.b = v;
    }

    public final b a(Object object0, a a0) {
        e e0 = this.a.u((object0 == null ? 0 : object0.hashCode()), object0, a0, 0);
        return e0 == null ? this : new b(((j)e0.b), this.b + e0.a);
    }

    @Override
    public boolean containsKey(Object object0) {
        return object0 == null ? this.a.d(0, 0, null) : this.a.d(object0.hashCode(), 0, object0);
    }

    @Override
    public Object get(Object object0) {
        return object0 == null ? this.a.g(0, 0, null) : this.a.g(object0.hashCode(), 0, object0);
    }
}

