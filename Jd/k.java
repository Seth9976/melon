package jd;

import Ad.C;

public final class K extends C {
    public final boolean a;

    public K(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof K ? this.a == ((K)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "UpdateEnableSwipe(enable=" + this.a + ")";
    }
}

