package I6;

public final class s0 extends b0 {
    public final transient Y d;
    public final transient t0 e;

    public s0(Y y0, t0 t00) {
        this.d = y0;
        this.e = t00;
    }

    @Override  // I6.b0
    public final V b() {
        return this.e;
    }

    @Override  // I6.O
    public final boolean contains(Object object0) {
        return this.d.get(object0) != null;
    }

    @Override  // I6.O
    public final int d(int v, Object[] arr_object) {
        return this.e.d(v, arr_object);
    }

    @Override  // I6.O
    public final boolean i() {
        return true;
    }

    @Override  // I6.O
    public final G0 k() {
        return this.e.r(0);
    }

    @Override
    public final int size() {
        return this.d.size();
    }

    @Override  // I6.b0
    public Object writeReplace() {
        return super.writeReplace();
    }
}

