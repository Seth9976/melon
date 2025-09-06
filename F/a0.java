package F;

import A7.d;

public final class a0 {
    public final float a;
    public final float b;
    public final long c;

    public a0(float f, float f1, long v) {
        this.a = f;
        this.b = f1;
        this.c = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a0)) {
            return false;
        }
        if(Float.compare(this.a, ((a0)object0).a) != 0) {
            return false;
        }
        return Float.compare(this.b, ((a0)object0).b) == 0 ? this.c == ((a0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.c) + d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "FlingInfo(initialVelocity=" + this.a + ", distance=" + this.b + ", duration=" + this.c + ')';
    }
}

