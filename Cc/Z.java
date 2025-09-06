package Cc;

import A7.d;
import androidx.appcompat.app.o;

public final class z {
    public final int a;
    public final int b;
    public final float c;
    public static final z d;

    static {
        z.d = new z(0, 0, 0.0f);
    }

    public z(int v, int v1, float f) {
        this.a = v;
        this.b = v1;
        this.c = f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z)) {
            return false;
        }
        if(this.a != ((z)object0).a) {
            return false;
        }
        return this.b == ((z)object0).b ? Float.compare(this.c, ((z)object0).c) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.c) + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "CircleOffsetAndAlphaState(offsetXPx=", ", offsetYPx=", ", alpha=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

