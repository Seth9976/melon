package ac;

import kotlin.jvm.internal.q;

public final class w {
    public final long a;
    public final m b;
    public final z c;
    public final p d;
    public static final w e;

    static {
        w.e = new w(0x8000000000000001L, m.p, z.e, p.j);
    }

    public w(long v, m m0, z z0, p p0) {
        q.g(m0, "contents");
        q.g(z0, "streaming");
        q.g(p0, "epPlay");
        super();
        this.a = v;
        this.b = m0;
        this.c = z0;
        this.d = p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w)) {
            return false;
        }
        if(this.a != ((w)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((w)object0).b)) {
            return false;
        }
        return q.b(this.c, ((w)object0).c) ? q.b(this.d, ((w)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + Long.hashCode(this.a) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "MelonAnalytics(createdTimeMs=" + this.a + ", contents=" + this.b + ", streaming=" + this.c + ", epPlay=" + this.d + ")";
    }
}

