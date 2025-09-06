package H;

import L.a;
import x0.b;

public final class l extends m {
    public final long a;

    public l(long v) {
        this.a = v;
        if((v & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            return;
        }
        a.c("ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.");
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof l ? b.b(this.a, ((l)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "Open(offset=" + b.i(this.a) + ')';
    }
}

