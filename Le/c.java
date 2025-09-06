package Le;

import kotlin.jvm.internal.q;
import qf.b;

public final class c {
    public final b a;
    public final b b;
    public final b c;

    public c(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
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
        return q.b(this.b, ((c)object0).b) ? q.b(this.c, ((c)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
    }
}

