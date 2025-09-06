package e3;

public final class q {
    public final int a;
    public final int b;
    public static final q c;

    static {
        q.c = new q(-1, -1);
        new q(0, 0);
    }

    public q(int v, int v1) {
        b.c((v == -1 || v >= 0) && (v1 == -1 || v1 >= 0));
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        return this == object0 ? true : object0 instanceof q && this.a == ((q)object0).a && this.b == ((q)object0).b;
    }

    @Override
    public final int hashCode() {
        return (this.a >>> 16 | this.a << 16) ^ this.b;
    }

    @Override
    public final String toString() {
        return this.a + "x" + this.b;
    }
}

