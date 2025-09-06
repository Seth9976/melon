package zd;

import java.util.ArrayList;
import je.p;

public final class z0 extends D0 {
    public final String a;
    public final ArrayList b;

    public z0(String s, ArrayList arrayList0) {
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
        return this == object0 || object0 instanceof z0 && this.a.equals(((z0)object0).a) && this.b.equals(((z0)object0).b);
    }

    @Override  // zd.Q
    public final int g() {
        return 29;
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
        return "SnsChannelPopupType(title=" + this.a + ", list=" + this.b + ")";
    }
}

