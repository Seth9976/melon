package F;

import A7.d;
import G.x0;
import y0.U;

public final class e0 {
    public final float a;
    public final long b;
    public final x0 c;

    public e0(float f, long v, x0 x00) {
        this.a = f;
        this.b = v;
        this.c = x00;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e0 && Float.compare(this.a, ((e0)object0).a) == 0 && U.a(this.b, ((e0)object0).b) && this.c.equals(((e0)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.c(Float.hashCode(this.a) * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return "Scale(scale=" + this.a + ", transformOrigin=" + U.d(this.b) + ", animationSpec=" + this.c + ')';
    }
}

