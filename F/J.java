package F;

import G.f;
import kotlin.jvm.internal.r;
import r1.l;
import we.n;

public final class j extends r implements n {
    public final int f;
    public static final j g;
    public static final j h;

    static {
        j.g = new j(2, 0);
        j.h = new j(2, 1);
    }

    public j(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.f != 0) {
            return ((L)object0) != ((L)object1) || ((L)object1) != L.c ? false : true;
        }
        l l0 = (l)object0;
        l l1 = (l)object1;
        return f.q(400.0f, 1, new l(0x100000001L));
    }
}

