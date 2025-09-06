package ac;

import U4.x;
import k8.Y;

public final class c implements d {
    public final long a;
    public final long b;

    public c(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        return this.a == ((c)object0).a ? this.b == ((c)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.o(this.a, "SetRangeAB(positionA=", ", positionB=");
        return x.h(this.b, ")", stringBuilder0);
    }
}

