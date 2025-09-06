package ac;

import A7.d;

public final class l {
    public final long a;
    public final int b;
    public final int c;

    public l(int v, int v1, long v2) {
        this.a = v2;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        if(this.a != ((l)object0).a) {
            return false;
        }
        return this.b == ((l)object0).b ? this.c == ((l)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, Long.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "CastContentsInfo(duration=" + this.a + ", onAirFlag=" + this.b + ", adultFlag=" + this.c + ")";
    }
}

