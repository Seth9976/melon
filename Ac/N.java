package ac;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class n {
    public final String a;
    public final String b;
    public final String c;
    public static final n d;

    static {
        n.d = new n("", "", "");
    }

    public n(String s, String s1, String s2) {
        q.g(s1, "ordNum");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n)) {
            return false;
        }
        if(!q.b(this.a, ((n)object0).a)) {
            return false;
        }
        return q.b(this.b, ((n)object0).b) ? q.b(this.c, ((n)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(d.o("DjMalrangTiaraInfo(recmdKey=", this.a, ", ordNum=", this.b, ", timestamp="), this.c, ")");
    }
}

