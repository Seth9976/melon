package J2;

public final class j {
    public final int a;

    public j(int v) {
        this.a = v;
    }

    public static String a(int v) {
        return "ContentScale(value=" + v + ')';
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof j && this.a == ((j)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return j.a(this.a);
    }
}

