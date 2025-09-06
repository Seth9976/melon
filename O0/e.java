package o0;

import java.util.Map;
import kotlin.jvm.internal.r;
import we.k;

public final class e extends r implements k {
    public final int f;
    public static final e g;
    public static final e h;

    static {
        e.g = new e(1, 0);
        e.h = new e(1, 1);
    }

    public e(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.f != 0 ? object0 : new f(((Map)object0));
    }
}

