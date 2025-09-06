package r0;

import A7.d;

public final class h {
    public final float a;

    public h(float f) {
        this.a = f;
    }

    public final int a(int v, int v1) {
        return Math.round((this.a + 1.0f) * (((float)(v1 - v)) / 2.0f));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h ? Float.compare(this.a, ((h)object0).a) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return d.m(new StringBuilder("Vertical(bias="), this.a, ')');
    }
}

