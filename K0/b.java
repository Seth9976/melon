package k0;

import Sf.i;
import java.util.Iterator;
import je.k;

public final class b extends k implements h0.b {
    public final Object a;
    public final Object b;
    public final j0.b c;
    public static final b d;

    static {
        b.d = new b(l0.b.a, l0.b.a, j0.b.c);
    }

    public b(Object object0, Object object1, j0.b b0) {
        this.a = object0;
        this.b = object1;
        this.c = b0;
    }

    @Override  // je.a
    public final boolean contains(Object object0) {
        return this.c.containsKey(object0);
    }

    @Override  // je.a
    public final int getSize() {
        this.c.getClass();
        return this.c.b;
    }

    @Override
    public final Iterator iterator() {
        return new i(this.a, this.c);
    }
}

