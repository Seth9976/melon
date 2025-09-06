package g7;

import A7.d;
import java.util.Map;
import kotlin.jvm.internal.q;

public final class c {
    public final String a;
    public final long b;
    public final Map c;

    public c(String s, long v, Map map0) {
        q.g(map0, "additionalCustomKeys");
        super();
        this.a = s;
        this.b = v;
        this.c = map0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        if(!q.b(this.a, ((c)object0).a)) {
            return false;
        }
        return this.b == ((c)object0).b ? q.b(this.c, ((c)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.c(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return "EventMetadata(sessionId=" + this.a + ", timestamp=" + this.b + ", additionalCustomKeys=" + this.c + ')';
    }
}

