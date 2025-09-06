package hc;

import kotlin.jvm.internal.q;

public final class i {
    public final w a;
    public final h b;
    public final d c;

    public i(w w0, h h0, d d0) {
        this.a = w0;
        this.b = h0;
        this.c = d0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        if(!q.b(this.a, ((i)object0).a)) {
            return false;
        }
        return q.b(this.b, ((i)object0).b) ? q.b(this.c, ((i)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "ConnectionResult(remoteType=" + this.a + ", connection=" + this.b + ", action=" + this.c + ")";
    }
}

