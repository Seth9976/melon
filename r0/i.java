package r0;

import A7.d;
import r1.m;

public final class i implements e {
    public final float a;
    public final float b;

    public i(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override  // r0.e
    public final long a(long v, long v1, m m0) {
        return ((long)Math.round((this.b + 1.0f) * (((float)(((int)(v1 & 0xFFFFFFFFL)) - ((int)(v & 0xFFFFFFFFL)))) / 2.0f))) & 0xFFFFFFFFL | ((long)Math.round(((m0 == m.a ? this.a : this.a * -1.0f) + 1.0f) * (((float)(((int)(v1 >> 0x20)) - ((int)(v >> 0x20)))) / 2.0f))) << 0x20;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        return Float.compare(this.a, ((i)object0).a) == 0 ? Float.compare(this.b, ((i)object0).b) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BiasAlignment(horizontalBias=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", verticalBias=");
        return d.m(stringBuilder0, this.b, ')');
    }
}

