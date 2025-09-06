package J2;

import androidx.appcompat.app.o;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import r1.f;

public final class p {
    public final float a;
    public final List b;

    static {
        new p(0.0f, 3);
    }

    public p(float f, int v) {
        if((v & 1) != 0) {
            f = 0.0f;
        }
        this(f, w.a);
    }

    public p(float f, List list0) {
        this.a = f;
        this.b = list0;
    }

    public final p a(p p0) {
        ArrayList arrayList0 = je.p.A0(this.b, p0.b);
        return new p(this.a + p0.a, arrayList0);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p && f.a(this.a, ((p)object0).a) && q.b(this.b, ((p)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PaddingDimension(dp=");
        o.v(this.a, stringBuilder0, ", resourceIds=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

