package ac;

import U4.x;
import Vb.i;
import kotlin.jvm.internal.q;
import we.a;

public final class z {
    public final String a;
    public final a b;
    public final String c;
    public final int d;
    public static final z e;

    static {
        z.e = new z("", new i(7), "", -1);
    }

    public z(String s, a a0, String s1, int v) {
        q.g(s, "loggingToken");
        super();
        this.a = s;
        this.b = a0;
        this.c = s1;
        this.d = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z)) {
            return false;
        }
        if(!q.b(this.a, ((z)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((z)object0).b)) {
            return false;
        }
        return q.b(this.c, ((z)object0).c) ? this.d == ((z)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return this.d + x.b((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        return "StreamingAnalytics(loggingToken=" + this.a + ", acquireServerIp=" + this.b + ", playToken=" + this.c + ", pollingInterval=" + this.d + ")";
    }
}

