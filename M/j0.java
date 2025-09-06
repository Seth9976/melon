package M;

import A7.d;
import N.a;
import androidx.appcompat.app.o;
import r1.f;
import r1.m;

public final class j0 implements i0 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public j0(float f, float f1, float f2, float f3) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        int v = 0;
        int v1 = Float.compare(f, 0.0f) < 0 ? 0 : 1;
        if(f3 >= 0.0f) {
            v = 1;
        }
        if((v1 & (f1 >= 0.0f ? 1 : 0) & (f2 >= 0.0f ? 1 : 0) & v) == 0) {
            a.a("Padding must be non-negative");
        }
    }

    @Override  // M.i0
    public final float a() {
        return this.d;
    }

    @Override  // M.i0
    public final float b(m m0) {
        return m0 == m.a ? this.a : this.c;
    }

    @Override  // M.i0
    public final float c(m m0) {
        return m0 == m.a ? this.c : this.a;
    }

    @Override  // M.i0
    public final float d() {
        return this.b;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof j0 && f.a(this.a, ((j0)object0).a) && f.a(this.b, ((j0)object0).b) && f.a(this.c, ((j0)object0).c) && f.a(this.d, ((j0)object0).d);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.d) + d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PaddingValues(start=");
        o.v(this.a, stringBuilder0, ", top=");
        o.v(this.b, stringBuilder0, ", end=");
        o.v(this.c, stringBuilder0, ", bottom=");
        stringBuilder0.append(f.b(this.d));
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

