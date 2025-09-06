package y0;

public final class x {
    public final int a;

    public x(int v) {
        this.a = v;
    }

    public static String a(int v) {
        return "CompositingStrategy(value=" + v + ')';
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof x && this.a == ((x)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return x.a(this.a);
    }
}

