package gd;

import A7.d;
import java.util.List;
import kotlin.jvm.internal.q;
import va.e;

public final class z extends B {
    public final String a;
    public final String b;
    public final Object c;

    public z(String s, String s1, List list0) {
        this.a = s;
        this.b = s1;
        this.c = list0;
    }

    public final List a() {
        return this.c;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof z && q.b(this.a, ((z)object0).a) && q.b(this.b, ((z)object0).b) && this.c.equals(((z)object0).c);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return this.c.hashCode() + (v1 * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        return e.d(d.o("DjHomeTagSubContentListItem(tabTitle=", this.a, ", tabTagTypeCode=", this.b, ", tagList="), this.c, ")");
    }
}

