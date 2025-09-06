package p0;

import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.r;
import we.k;

public final class a extends r implements k {
    public final int f;
    public static final a g;
    public static final a h;

    static {
        a.g = new a(1, 0);
        a.h = new a(1, 1);
    }

    public a(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            l l0 = (l)object0;
            return H.a;
        }
        synchronized(m.b) {
            Object object2 = m.h;
            int v1 = ((Collection)object2).size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((k)((List)object2).get(v2)).invoke(object0);
            }
            return H.a;
        }
    }
}

