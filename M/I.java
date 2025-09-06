package M;

import kotlin.jvm.internal.r;
import r1.m;
import we.n;

public final class i extends r implements n {
    public final int f;
    public static final i g;

    static {
        i.g = new i(2, 0);
    }

    public i(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return this.f == 0 ? Math.round(((((m)object1) == m.a ? -1.0f : 1.0f) + 1.0f) * (((float)((Number)object0).intValue()) / 2.0f)) : Math.round(((((m)object1) == m.a ? 0.0f : -0.0f) + 1.0f) * (((float)((Number)object0).intValue()) / 2.0f));
    }
}

