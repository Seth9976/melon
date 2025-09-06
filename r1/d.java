package r1;

public final class d implements c {
    public final float a;
    public final float b;

    public d(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override  // r1.c
    public final float W() {
        return this.b;
    }

    @Override  // r1.c
    public final float b() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return Float.compare(this.a, ((d)object0).a) == 0 ? Float.compare(this.b, ((d)object0).b) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DensityImpl(density=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", fontScale=");
        return A7.d.m(stringBuilder0, this.b, ')');
    }
}

