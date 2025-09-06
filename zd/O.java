package zd;

import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;

public final class o extends D0 {
    public final String a;
    public final ArrayList b;

    public o(String s, ArrayList arrayList0) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = arrayList0;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        return p.Q0(this.b);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof o && q.b(this.a, ((o)object0).a) && this.b.equals(((o)object0).b);
    }

    @Override  // zd.Q
    public final int g() {
        return 99;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override  // zd.Q
    public final String r() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "CustomTitleBottomSheetType(title=" + this.a + ", items=" + this.b + ")";
    }
}

