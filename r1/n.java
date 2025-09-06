package r1;

import A7.d;
import s1.a;

public final class n implements a {
    public final float a;

    public n(float f) {
        this.a = f;
    }

    @Override  // s1.a
    public final float a(float f) {
        return f / this.a;
    }

    @Override  // s1.a
    public final float b(float f) {
        return f * this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n ? Float.compare(this.a, ((n)object0).a) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return d.m(new StringBuilder("LinearFontScaleConverter(fontScale="), this.a, ')');
    }
}

