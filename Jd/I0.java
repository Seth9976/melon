package jd;

import gd.Z3;

public final class i0 extends Z3 {
    public final boolean a;

    public i0(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i0 ? this.a == ((i0)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "UpdateRecentButtonVisible(visible=" + this.a + ")";
    }
}

