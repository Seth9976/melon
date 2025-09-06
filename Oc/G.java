package oc;

public final class g implements h {
    public final int a;

    public g(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g ? this.a == ((g)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "IndexChanged(index=" + this.a + ")";
    }
}

