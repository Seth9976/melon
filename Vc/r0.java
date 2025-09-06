package Vc;

import Pc.e;

public final class r0 implements e {
    public final int a;

    public r0(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r0 ? this.a == ((r0)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "OnPageChanged(page=" + this.a + ")";
    }
}

