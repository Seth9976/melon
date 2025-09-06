package Q;

import androidx.compose.foundation.lazy.layout.z;
import r1.f;

public final class l implements m {
    public final float a;

    public l(float f) {
        this.a = f;
    }

    @Override  // Q.m
    public final int a(z z0, int v) {
        return z0.b.z(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l ? f.a(this.a, ((l)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }
}

