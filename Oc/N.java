package oc;

public final class n implements o {
    public final int a;

    public n(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n ? this.a == ((n)object0).a : false;
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

