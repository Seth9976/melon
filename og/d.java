package og;

import jg.h;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class d extends r implements k {
    public final int f;
    public static final d g;
    public static final d h;

    static {
        d.g = new d(1, 0);
        d.h = new d(1, 1);
    }

    public d(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            q.g(((h)object0), "$receiver");
            return false;
        }
        q.g(((h)object0), "$receiver");
        return false;
    }
}

