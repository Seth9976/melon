package Ve;

public final class z extends E {
    public final double a;

    public z(double f) {
        this.a = f;
    }

    @Override  // Ve.E
    public final Object a() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof z ? Double.compare(this.a, ((z)object0).a) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Double.hashCode(this.a);
    }
}

