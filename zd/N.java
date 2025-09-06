package zd;

import java.util.ArrayList;
import je.p;

public final class n extends y0 {
    public final ArrayList a;

    public n(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        return p.Q0(this.a);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n && this.a.equals(((n)object0).a);
    }

    @Override  // zd.Q
    public final int g() {
        return 98;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "CustomSimpleBottomSheetType(items=" + this.a + ")";
    }
}

