package s3;

import b3.E;
import b3.b;
import b3.m0;
import b3.o0;
import b3.p0;

public final class t extends p0 {
    public final E e;

    public t(E e0) {
        this.e = e0;
    }

    @Override  // b3.p0
    public final int b(Object object0) {
        return object0 == s.h ? 0 : -1;
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        Object object0 = null;
        Integer integer0 = z ? 0 : null;
        if(z) {
            object0 = s.h;
        }
        m00.i(integer0, object0, 0, 0x8000000000000001L, 0L, b.f, true);
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return 1;
    }

    @Override  // b3.p0
    public final Object l(int v) {
        return s.h;
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        o00.b(o0.q, this.e, null, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, false, true, null, 0L, 0x8000000000000001L, 0, 0, 0L);
        o00.k = true;
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        return 1;
    }
}

