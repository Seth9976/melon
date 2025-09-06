package F;

import G.e;
import r1.l;

public final class g0 {
    public final e a;
    public long b;

    public g0(e e0, long v) {
        this.a = e0;
        this.b = v;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g0 && this.a.equals(((g0)object0).a) && l.b(this.b, ((g0)object0).b);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "AnimData(anim=" + this.a + ", startSize=" + l.c(this.b) + ')';
    }
}

