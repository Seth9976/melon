package androidx.compose.foundation;

import androidx.appcompat.app.o;
import r1.f;
import y0.T;

public final class y {
    public final float a;
    public final T b;

    public y(float f, T t0) {
        this.a = f;
        this.b = t0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof y && f.a(this.a, ((y)object0).a) && this.b.equals(((y)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BorderStroke(width=");
        o.v(this.a, stringBuilder0, ", brush=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

