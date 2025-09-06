package Ic;

import Ac.p0;

public final class e0 extends p0 {
    public final boolean a;
    public final int b;

    public e0(boolean z, int v) {
        this.a = z;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e0)) {
            return false;
        }
        return this.a == ((e0)object0).a ? this.b == ((e0)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + Boolean.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "UpdateLike(isLike=" + this.a + ", likeCount=" + this.b + ")";
    }
}

