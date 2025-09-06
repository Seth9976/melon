package l1;

import A7.d;

public final class q {
    public final float a;
    public final float b;
    public static final q c;

    static {
        q.c = new q(1.0f, 0.0f);
    }

    public q(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q ? this.a == ((q)object0).a && this.b == ((q)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TextGeometricTransform(scaleX=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", skewX=");
        return d.m(stringBuilder0, this.b, ')');
    }
}

