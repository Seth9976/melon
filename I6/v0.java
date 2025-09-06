package I6;

public final class v0 extends b0 {
    public final transient Object[] d;
    public final transient int e;
    public final transient Object[] f;
    public final transient int g;
    public final transient int h;
    public static final Object[] i;
    public static final v0 j;

    static {
        Object[] arr_object = new Object[0];
        v0.i = arr_object;
        v0.j = new v0(arr_object, 0, arr_object, 0, 0);
    }

    public v0(Object[] arr_object, int v, Object[] arr_object1, int v1, int v2) {
        this.d = arr_object;
        this.e = v;
        this.f = arr_object1;
        this.g = v1;
        this.h = v2;
    }

    @Override  // I6.O
    public final boolean contains(Object object0) {
        if(object0 != null) {
            Object[] arr_object = this.f;
            if(arr_object.length != 0) {
                for(int v = w.s(object0); true; v = v1 + 1) {
                    int v1 = v & this.g;
                    Object object1 = arr_object[v1];
                    if(object1 == null) {
                        return false;
                    }
                    if(object1.equals(object0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override  // I6.O
    public final int d(int v, Object[] arr_object) {
        System.arraycopy(this.d, 0, arr_object, v, this.h);
        return v + this.h;
    }

    @Override  // I6.O
    public final Object[] e() {
        return this.d;
    }

    @Override  // I6.O
    public final int f() {
        return this.h;
    }

    @Override  // I6.O
    public final int g() {
        return 0;
    }

    @Override  // I6.b0
    public final int hashCode() {
        return this.e;
    }

    @Override  // I6.O
    public final boolean i() {
        return false;
    }

    @Override  // I6.O
    public final G0 k() {
        return this.b().r(0);
    }

    @Override  // I6.b0
    public final V q() {
        return V.l(this.h, this.d);
    }

    @Override
    public final int size() {
        return this.h;
    }

    @Override  // I6.b0
    public Object writeReplace() {
        return super.writeReplace();
    }
}

