package ed;

import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class g0 extends l0 {
    public final String a;
    public final a b;
    public final ArrayList c;
    public final b d;

    public g0(String s, a a0, ArrayList arrayList0, b b0) {
        this.a = s;
        this.b = a0;
        this.c = arrayList0;
        this.d = b0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g0 && this.a.equals(((g0)object0).a) && this.b.equals(((g0)object0).b) && this.c.equals(((g0)object0).c) && q.b(this.d, ((g0)object0).d);
    }

    @Override
    public final int hashCode() {
        int v = H0.b.a(this.c, (this.b.a.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F);
        return this.d == null ? v : v + this.d.hashCode();
    }

    @Override
    public final String toString() {
        return "ArchiveThemeContainer(title=" + this.a + ", allShowData=" + this.b + ", list=" + this.c + ", banner=" + this.d + ")";
    }
}

