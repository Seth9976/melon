package n5;

import k5.g;
import k5.z;
import kotlin.jvm.internal.q;

public final class m extends e {
    public final z a;
    public final String b;
    public final g c;

    public m(z z0, String s, g g0) {
        this.a = z0;
        this.b = s;
        this.c = g0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof m && q.b(this.a, ((m)object0).a) && q.b(this.b, ((m)object0).b) && this.c == ((m)object0).c;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.c.hashCode() + v * 961 : this.c.hashCode() + (v * 0x1F + this.b.hashCode()) * 0x1F;
    }
}

