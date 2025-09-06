package ad;

public final class y implements z {
    public final int a;

    public y(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y ? this.a == ((y)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "OnItemShown(index=" + this.a + ")";
    }
}

