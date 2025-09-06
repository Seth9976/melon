package gd;

public final class r7 extends Z3 {
    public final int a;

    public r7(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r7 ? this.a == ((r7)object0).a : false;
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

