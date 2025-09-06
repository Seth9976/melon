package x1;

import A7.d;
import kotlin.jvm.internal.q;

public final class g {
    public final Object a;
    public final int b;
    public final o c;

    public g(Object object0, int v, o o0) {
        this.a = object0;
        this.b = v;
        this.c = o0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(!q.b(this.a, ((g)object0).a)) {
            return false;
        }
        return this.b == ((g)object0).b ? q.b(this.c, ((g)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "VerticalAnchor(id=" + this.a + ", index=" + this.b + ", reference=" + this.c + ')';
    }
}

