package Cc;

import A7.d;
import androidx.appcompat.app.o;
import we.a;

public final class r {
    public final int a;
    public final int b;
    public final a c;

    public r(int v, int v1, a a0) {
        this.a = v;
        this.b = v1;
        this.c = a0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof r && this.a == ((r)object0).a && this.b == ((r)object0).b && this.c.equals(((r)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "ButtonUiState(iconResId=", ", textResId=", ", clickAction=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

