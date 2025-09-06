package D0;

import A7.d;

public final class v extends A {
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public v(float f, float f1, float f2, float f3) {
        super(1);
        this.c = f;
        this.d = f1;
        this.e = f2;
        this.f = f3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        if(Float.compare(this.c, ((v)object0).c) != 0) {
            return false;
        }
        if(Float.compare(this.d, ((v)object0).d) != 0) {
            return false;
        }
        return Float.compare(this.e, ((v)object0).e) == 0 ? Float.compare(this.f, ((v)object0).f) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.f) + d.a(this.e, d.a(this.d, Float.hashCode(this.c) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RelativeQuadTo(dx1=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", dy1=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", dx2=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", dy2=");
        return d.m(stringBuilder0, this.f, ')');
    }
}

