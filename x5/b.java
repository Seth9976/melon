package X5;

import Q5.i;
import Q5.j;

public final class b {
    public final long a;
    public final j b;
    public final i c;

    public b(long v, j j0, i i0) {
        this.a = v;
        this.b = j0;
        this.c = i0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof b && this.a == ((b)object0).a && this.b.equals(((b)object0).b) && this.c.equals(((b)object0).c);
    }

    @Override
    public final int hashCode() {
        return ((((int)(this.a >>> 0x20 ^ this.a)) ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}

