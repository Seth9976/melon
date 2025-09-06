package Dc;

public final class w {
    public final v a;
    public final float b;

    public w(v v0, float f) {
        this.a = v0;
        this.b = f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w)) {
            return false;
        }
        return this.a == ((w)object0).a ? Float.compare(this.b, ((w)object0).b) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ScrollJobInfo(direction=" + this.a + ", speedMultiplier=" + this.b + ")";
    }
}

