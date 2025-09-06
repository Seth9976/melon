package ed;

import java.util.List;
import kotlin.jvm.internal.q;
import we.n;

public final class k0 extends l0 {
    public final List a;
    public final n b;

    public k0(List list0, n n0) {
        q.g(list0, "data");
        super();
        this.a = list0;
        this.b = n0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k0)) {
            return false;
        }
        return q.b(this.a, ((k0)object0).a) ? q.b(this.b, ((k0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "TextBanner(data=" + this.a + ", clickAction=" + this.b + ")";
    }
}

