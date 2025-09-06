package W5;

import N5.d;
import java.util.HashMap;

public final class a {
    public final Z5.a a;
    public final HashMap b;

    public a(Z5.a a0, HashMap hashMap0) {
        this.a = a0;
        this.b = hashMap0;
    }

    public final long a(d d0, long v, int v1) {
        long v2 = this.a.f();
        b b0 = (b)this.b.get(d0);
        return b0.a <= 1L ? Math.min(Math.max(((long)(Math.pow(3.0, v1 - 1) * ((double)b0.a) * Math.max(1.0, 9.21034 / Math.log(2L * ((long)(v1 - 1)))))), v - v2), b0.b) : Math.min(Math.max(((long)(Math.pow(3.0, v1 - 1) * ((double)b0.a) * Math.max(1.0, 9.21034 / Math.log(b0.a * ((long)(v1 - 1)))))), v - v2), b0.b);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof a && this.a.equals(((a)object0).a) && this.b.equals(((a)object0).b);
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.b + "}";
    }
}

