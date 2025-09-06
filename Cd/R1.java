package cd;

import A7.d;
import kotlin.jvm.internal.q;

public final class r1 implements u1 {
    public final q1 a;
    public final int b;
    public final a c;

    public r1(q1 q10, int v, a a0) {
        q.g(a0, "albumType");
        super();
        this.a = q10;
        this.b = v;
        this.c = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r1)) {
            return false;
        }
        if(!q.b(this.a, ((r1)object0).a)) {
            return false;
        }
        return this.b == ((r1)object0).b ? this.c == ((r1)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "OnItemClick(uiState=" + this.a + ", index=" + this.b + ", albumType=" + this.c + ")";
    }
}

