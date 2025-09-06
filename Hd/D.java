package hd;

import a1.g;
import kotlin.jvm.internal.q;
import y0.s;

public final class d {
    public final long a;
    public final g b;

    public d(long v, g g0) {
        this.a = v;
        this.b = g0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return s.d(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "DnaGraphEachDescriptionData(color=" + s.j(this.a) + ", genre=" + this.b + ")";
    }
}

