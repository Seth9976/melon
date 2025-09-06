package i.n.i.b.a.s.e;

import java.util.Map.Entry;

public final class H5 extends Qb {
    public final transient K5 c;
    public final transient Object[] d;
    public final transient int e;

    public H5(K5 k50, Object[] arr_object, int v) {
        this.c = k50;
        this.d = arr_object;
        this.e = v;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int a(int v, Object[] arr_object) {
        return this.b().a(v, arr_object);
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean contains(Object object0) {
        if(object0 instanceof Map.Entry) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            return object2 != null && object2.equals(this.c.get(object1));
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean g() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Ea i() {
        return this.b().o(0);
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final h9 p() {
        return new G5(this);
    }

    @Override
    public final int size() {
        return this.e;
    }
}

