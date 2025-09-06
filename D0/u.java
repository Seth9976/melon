package D0;

import A7.d;

public final class u extends A {
    public final float c;
    public final float d;

    public u(float f, float f1) {
        super(3);
        this.c = f;
        this.d = f1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        return Float.compare(this.c, ((u)object0).c) == 0 ? Float.compare(this.d, ((u)object0).d) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.d) + Float.hashCode(this.c) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RelativeMoveTo(dx=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", dy=");
        return d.m(stringBuilder0, this.d, ')');
    }
}

