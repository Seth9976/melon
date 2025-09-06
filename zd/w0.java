package zd;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class w0 extends D0 {
    public final String a;
    public final Object b;

    public w0(String s, List list0) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = list0;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        return new ArrayList();
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof w0 && q.b(this.a, ((w0)object0).a) && this.b.equals(((w0)object0).b);
    }

    @Override  // zd.Q
    public final int g() {
        return 35;
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
        return "RecommendContentsPopupType(title=" + this.a + ", list=" + this.b + ")";
    }
}

