package ld;

import gd.Z3;

public final class d extends Z3 {
    public final int a;

    public d(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? this.a == ((d)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "ClickFilter(filterIndex=" + this.a + ")";
    }
}

