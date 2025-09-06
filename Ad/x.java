package ad;

public final class x implements z {
    public final int a;

    public x(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x ? this.a == ((x)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "OnItemClick(index=" + this.a + ")";
    }
}

