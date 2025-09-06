package Ze;

import ie.i;
import kotlin.jvm.internal.q;

public final class r {
    public final z a;
    public final i b;
    public final z c;
    public static final r d;

    static {
        r.d = new r(z.d, 6);
    }

    public r(z z0, int v) {
        this(z0, ((v & 2) == 0 ? null : new i(1, 0, 0)), z0);
    }

    public r(z z0, i i0, z z1) {
        this.a = z0;
        this.b = i0;
        this.c = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r)) {
            return false;
        }
        if(this.a != ((r)object0).a) {
            return false;
        }
        return q.b(this.b, ((r)object0).b) ? this.c == ((r)object0).c : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.c.hashCode() + v * 961 : this.c.hashCode() + (v * 0x1F + this.b.c) * 0x1F;
    }

    @Override
    public final String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.a + ", sinceVersion=" + this.b + ", reportLevelAfter=" + this.c + ')';
    }
}

