package hf;

import H0.b;

public final class d {
    public final g a;
    public final e b;
    public final boolean c;
    public final boolean d;
    public static final d e;

    static {
        d.e = new d(null, false);
    }

    public d(g g0, e e0, boolean z, boolean z1) {
        this.a = g0;
        this.b = e0;
        this.c = z;
        this.d = z1;
    }

    public d(g g0, boolean z) {
        this(g0, null, z, false);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        if(this.a != ((d)object0).a) {
            return false;
        }
        if(this.b != ((d)object0).b) {
            return false;
        }
        return this.c == ((d)object0).c ? this.d == ((d)object0).d : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        e e0 = this.b;
        if(e0 != null) {
            v = e0.hashCode();
        }
        return Boolean.hashCode(this.d) + A7.d.e((v1 * 0x1F + v) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("JavaTypeQualifiers(nullability=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", mutability=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", definitelyNotNull=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", isNullabilityQualifierForWarning=");
        return b.k(stringBuilder0, this.d, ')');
    }
}

