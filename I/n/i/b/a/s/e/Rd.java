package i.n.i.b.a.s.e;

import U4.x;

public final class rd {
    public final Nd a;
    public final Nd b;

    public rd(Nd nd0, Nd nd1) {
        this.a = nd0;
        this.b = nd1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return rd.class == class0 && this.a.equals(((rd)object0).a) && this.b.equals(((rd)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[");
        stringBuilder0.append(this.a);
        return this.a.equals(this.b) ? x.m(stringBuilder0, "", "]") : x.m(stringBuilder0, ", " + this.b, "]");
    }
}

