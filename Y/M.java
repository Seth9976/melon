package Y;

import H0.b;
import kotlin.jvm.internal.q;

public final class m {
    public final l a;
    public final l b;
    public final boolean c;

    public m(l l0, l l1, boolean z) {
        this.a = l0;
        this.b = l1;
        this.c = z;
    }

    public static m a(m m0, l l0, l l1, boolean z, int v) {
        if((v & 1) != 0) {
            l0 = m0.a;
        }
        if((v & 2) != 0) {
            l1 = m0.b;
        }
        m0.getClass();
        return new m(l0, l1, z);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        if(!q.b(this.a, ((m)object0).a)) {
            return false;
        }
        return q.b(this.b, ((m)object0).b) ? this.c == ((m)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Selection(start=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", end=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", handlesCrossed=");
        return b.k(stringBuilder0, this.c, ')');
    }
}

