package I;

import A7.d;
import x0.b;

public final class h0 {
    public final long a;
    public final long b;
    public final boolean c;

    public h0(long v, long v1, boolean z) {
        this.a = v;
        this.b = v1;
        this.c = z;
    }

    public final h0 a(h0 h00) {
        return new h0(b.g(this.a, h00.a), Math.max(this.b, h00.b), this.c);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h0 && b.b(this.a, ((h0)object0).a) && this.b == ((h0)object0).b && this.c == ((h0)object0).c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.c(Long.hashCode(this.a) * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MouseWheelScrollDelta(value=");
        stringBuilder0.append(b.i(this.a));
        stringBuilder0.append(", timeMillis=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", shouldApplyImmediately=");
        return H0.b.k(stringBuilder0, this.c, ')');
    }
}

