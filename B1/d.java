package b1;

import H0.b;

public final class d {
    public final int a;
    public final int b;
    public final boolean c;

    public d(int v, int v1, boolean z) {
        this.a = v;
        this.b = v1;
        this.c = z;
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
        return this.b == ((d)object0).b ? this.c == ((d)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + A7.d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BidiRun(start=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", end=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isRtl=");
        return b.k(stringBuilder0, this.c, ')');
    }
}

