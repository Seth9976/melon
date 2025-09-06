package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.List;
import java.util.Map;

public final class d {
    public final Uri a;
    public final Map b;
    public final List c;
    public final List d;

    public d(Uri uri0, Map map0, Ja ja0, Ja ja1, List list0, List list1) {
        this.a = uri0;
        this.b = map0;
        this.c = list0;
        this.d = list1;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d && this.a.equals(((d)object0).a) && L7.p(null, null) && L7.p(null, null) && this.c.equals(((d)object0).c) && this.d.equals(((d)object0).d);
    }

    @Override
    public final int hashCode() {
        return (this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0xE1781) * 961) * 0x1F;
    }
}

