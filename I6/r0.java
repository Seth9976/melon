package I6;

import java.util.Map.Entry;

public final class r0 extends b0 {
    public final transient Y d;
    public final transient Object[] e;
    public final transient int f;
    public final transient int g;

    public r0(Y y0, Object[] arr_object, int v, int v1) {
        this.d = y0;
        this.e = arr_object;
        this.f = v;
        this.g = v1;
    }

    @Override  // I6.O
    public final boolean contains(Object object0) {
        if(object0 instanceof Map.Entry) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            return object2 != null && object2.equals(this.d.get(object1));
        }
        return false;
    }

    @Override  // I6.O
    public final int d(int v, Object[] arr_object) {
        return this.b().d(v, arr_object);
    }

    @Override  // I6.O
    public final boolean i() {
        return true;
    }

    @Override  // I6.O
    public final G0 k() {
        return this.b().r(0);
    }

    @Override  // I6.b0
    public final V q() {
        return new q0(this);
    }

    @Override
    public final int size() {
        return this.g;
    }

    @Override  // I6.b0
    public Object writeReplace() {
        return super.writeReplace();
    }
}

