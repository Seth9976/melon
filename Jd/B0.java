package jd;

import gd.Z3;

public final class b0 extends Z3 {
    public final int a;

    public b0(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b0 ? this.a == ((b0)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "SendCheerUpCount(cheerCount=" + this.a + ")";
    }
}

