package F;

import G.D;
import kotlin.jvm.internal.r;
import we.k;

public final class l0 {
    public final r a;
    public final D b;

    public l0(D d0, k k0) {
        this.a = (r)k0;
        this.b = d0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof l0 && this.a.equals(((l0)object0).a) && this.b.equals(((l0)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Slide(slideOffset=" + this.a + ", animationSpec=" + this.b + ')';
    }
}

