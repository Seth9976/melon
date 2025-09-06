package z0;

import A7.d;

public final class s {
    public final float a;
    public final float b;

    public s(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    public final float[] a() {
        return new float[]{this.a / this.b, 1.0f, (1.0f - this.a - this.b) / this.b};
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s)) {
            return false;
        }
        return Float.compare(this.a, ((s)object0).a) == 0 ? Float.compare(this.b, ((s)object0).b) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("WhitePoint(x=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", y=");
        return d.m(stringBuilder0, this.b, ')');
    }
}

