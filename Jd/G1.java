package jd;

import Ad.C;

public final class g1 extends C {
    public final boolean a;

    public g1(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g1 ? this.a == ((g1)object0).a : false;
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

