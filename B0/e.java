package b0;

import A7.d;
import r1.f;

public final class e {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public e(float f, float f1, float f2, float f3, float f4) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 != null && object0 instanceof e && f.a(this.a, ((e)object0).a) && f.a(this.b, ((e)object0).b) && f.a(this.c, ((e)object0).c) && f.a(this.d, ((e)object0).d) && f.a(this.e, ((e)object0).e);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.e) + d.a(this.d, d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F);
    }
}

