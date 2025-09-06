package I6;

public final class o0 extends M {
    public final transient Object d;
    public final transient Object[] e;
    public final transient int f;
    public final transient int g;
    public final transient o0 h;
    public static final o0 i;

    static {
        o0.i = new o0();
    }

    public o0() {
        this.d = null;
        this.e = new Object[0];
        this.f = 0;
        this.g = 0;
        this.h = this;
    }

    public o0(Object object0, Object[] arr_object, int v, o0 o00) {
        this.d = object0;
        this.e = arr_object;
        this.f = 1;
        this.g = v;
        this.h = o00;
    }

    public o0(Object[] arr_object, int v) {
        this.e = arr_object;
        this.g = v;
        this.f = 0;
        int v1 = v < 2 ? 0 : b0.l(v);
        Object object0 = u0.h(arr_object, v, v1, 0);
        if(object0 instanceof Object[]) {
            throw ((W)((Object[])object0)[2]).a();
        }
        this.d = object0;
        Object object1 = u0.h(arr_object, v, v1, 1);
        if(object1 instanceof Object[]) {
            throw ((W)((Object[])object1)[2]).a();
        }
        this.h = new o0(object1, arr_object, v, this);
    }

    @Override  // I6.Y
    public final r0 b() {
        return new r0(this, this.e, this.f, this.g);
    }

    @Override  // I6.Y
    public final s0 c() {
        return new s0(this, new t0(this.e, this.f, this.g));
    }

    @Override  // I6.Y
    public final Object get(Object object0) {
        Object object1 = u0.i(this.d, this.e, this.g, this.f, object0);
        return object1 == null ? null : object1;
    }

    @Override
    public final int size() {
        return this.g;
    }

    @Override  // I6.M
    public Object writeReplace() {
        return super.writeReplace();
    }
}

