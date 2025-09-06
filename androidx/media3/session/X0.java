package androidx.media3.session;

import B.a;
import I6.V;
import je.w;

public final class x0 {
    public final V a;
    public final int b;
    public final long c;

    public x0() {
        this.a = V.p(w.a);
        this.b = -1;
        this.c = 0x8000000000000001L;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x0 ? this.a.equals(((x0)object0).a) && this.b.equals(((x0)object0).b) && this.c.equals(((x0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return a.P(this.c) + (this.a.hashCode() * 0x1F + this.b) * 0x1F;
    }
}

