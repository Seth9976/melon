package gd;

public final class i6 extends Z3 {
    public final int a;

    public i6(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i6 ? this.a == ((i6)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "SelectSortType(sortType=" + this.a + ")";
    }
}

