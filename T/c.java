package T;

import x0.e;

public final class c implements a {
    public final float a;

    public c(float f) {
        this.a = f;
        if(f >= 0.0f && f <= 100.0f) {
            return;
        }
        L.a.a("The percent should be in the range of [0, 100]");
    }

    @Override  // T.a
    public final float a(long v, r1.c c0) {
        return this.a / 100.0f * e.c(v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? Float.compare(this.a, ((c)object0).a) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "CornerSize(size = " + this.a + "%)";
    }
}

