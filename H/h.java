package H;

import V4.u;
import r1.k;
import r1.m;
import v1.p;

public final class h implements p {
    public final long a;

    public h(long v) {
        this.a = v;
    }

    @Override  // v1.p
    public final long a(k k0, long v, m m0, long v1) {
        int v2 = k0.a + ((int)(this.a >> 0x20));
        return m0 == m.a ? ((long)u.h(v2, ((int)(v1 >> 0x20)), ((int)(v >> 0x20)), true)) << 0x20 | ((long)u.h(k0.b + ((int)(this.a & 0xFFFFFFFFL)), ((int)(v1 & 0xFFFFFFFFL)), ((int)(v & 0xFFFFFFFFL)), true)) & 0xFFFFFFFFL : ((long)u.h(v2, ((int)(v1 >> 0x20)), ((int)(v >> 0x20)), false)) << 0x20 | ((long)u.h(k0.b + ((int)(this.a & 0xFFFFFFFFL)), ((int)(v1 & 0xFFFFFFFFL)), ((int)(v & 0xFFFFFFFFL)), true)) & 0xFFFFFFFFL;
    }
}

