package m1;

import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.r;
import we.n;

public final class a extends r implements n {
    public final int f;
    public static final a g;
    public static final a h;
    public static final a i;

    static {
        a.g = new a(2, 0);
        a.h = new a(2, 1);
        a.i = new a(2, 2);
    }

    public a(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                int v1 = ((Number)object1).intValue();
                if(!((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
            case 1: {
                int v2 = ((Number)object1).intValue();
                if(!((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                if(!((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
        }
    }
}

