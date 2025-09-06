package gd;

public final class c7 extends d7 {
    public final int a;

    public c7(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c7 ? this.a == ((c7)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "SortBarItem(currentSortIndex=" + this.a + ")";
    }
}

