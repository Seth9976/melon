package r0;

import A7.d;
import r1.m;

public final class g {
    public final float a;

    public g(float f) {
        this.a = f;
    }

    public final int a(int v, int v1, m m0) {
        return Math.round(((m0 == m.a ? this.a : this.a * -1.0f) + 1.0f) * (((float)(v1 - v)) / 2.0f));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g ? Float.compare(this.a, ((g)object0).a) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return d.m(new StringBuilder("Horizontal(bias="), this.a, ')');
    }
}

