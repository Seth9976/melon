package rf;

public final class e {
    public final Object a;
    public final int b;

    public e(Object object0, int v) {
        this.a = object0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof e ? this.a == ((e)object0).a && this.b == ((e)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.a) * 0xFFFF + this.b;
    }
}

