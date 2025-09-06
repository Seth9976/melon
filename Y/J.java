package Y;

import e1.b;
import r0.e;
import r1.m;
import v1.p;

public final class j implements p {
    public final e a;
    public final k b;
    public long c;

    public j(e e0, k k0) {
        this.a = e0;
        this.b = k0;
        this.c = 0L;
    }

    @Override  // v1.p
    public final long a(r1.k k0, long v, m m0, long v1) {
        long v2 = this.b.a();
        if((0x7FFFFFFF7FFFFFFFL & v2) == 0x7FC000007FC00000L) {
            v2 = this.c;
        }
        this.c = v2;
        return r1.j.c(r1.j.c(k0.a(), b.J(v2)), this.a.a(v1, 0L, m0));
    }
}

