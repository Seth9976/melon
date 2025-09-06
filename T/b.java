package T;

import r1.c;
import r1.f;

public final class b implements a {
    public final float a;

    public b(float f) {
        this.a = f;
    }

    @Override  // T.a
    public final float a(long v, c c0) {
        return c0.Y(this.a);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof b && f.a(this.a, ((b)object0).a);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "CornerSize(size = " + this.a + ".dp)";
    }
}

