package hf;

import H0.b;
import kotlin.jvm.internal.q;

public final class h {
    public final g a;
    public final boolean b;

    public h(g g0) {
        this.a = g0;
        this.b = false;
    }

    public h(g g0, boolean z) {
        this.a = g0;
        this.b = z;
    }

    public static h a(h h0, g g0, boolean z, int v) {
        if((v & 1) != 0) {
            g0 = h0.a;
        }
        if((v & 2) != 0) {
            z = h0.b;
        }
        h0.getClass();
        q.g(g0, "qualifier");
        return new h(g0, z);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        return this.a == ((h)object0).a ? this.b == ((h)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("NullabilityQualifierWithMigrationStatus(qualifier=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isForWarningOnly=");
        return b.k(stringBuilder0, this.b, ')');
    }
}

