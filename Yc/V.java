package yc;

import gd.Z3;

public final class v extends Z3 {
    public final int a;

    public v(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v ? this.a == ((v)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "ClickTab(tabIndex=" + this.a + ")";
    }
}

