package I8;

import U4.x;
import androidx.appcompat.app.o;
import java.util.List;
import je.w;

public final class p {
    public final Object a;
    public final Object b;
    public final List c;
    public static final p d;

    static {
        p.d = new p(w.a, w.a, w.a);
    }

    public p(List list0, List list1, List list2) {
        this.a = list0;
        this.b = list1;
        this.c = list2;
    }

    public final int a() {
        return this.c.size() + (((List)this.b).size() + ((List)this.a).size());
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p && this.a.equals(((p)object0).a) && this.b.equals(((p)object0).b) && this.c.equals(((p)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.t(((List)this.a).size(), ((List)this.b).size(), "Result [Insert: ", ", Update: ", ", Delete: ");
        return x.g(this.c.size(), "]", stringBuilder0);
    }
}

