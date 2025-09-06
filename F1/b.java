package f1;

import a1.K;
import a1.T;
import a1.g;
import d5.l;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;
import y0.F;

public final class b extends r implements k {
    public final int f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;

    static {
        b.g = new b(1, 0);
        b.h = new b(1, 1);
        b.i = new b(1, 2);
        b.j = new b(1, 3);
        b.k = new b(1, 4);
        b.l = new b(1, 5);
        b.m = new b(1, 6);
    }

    public b(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        T t0;
        g g0;
        H h0 = H.a;
        switch(this.f) {
            case 0: {
                F f0 = (F)object0;
                return h0;
            }
            case 1: {
                F f1 = (F)object0;
                return h0;
            }
            case 2: {
                q.e(object0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                Object object1 = ((List)object0).get(0);
                l l0 = K.a;
                if(q.b(object1, Boolean.FALSE)) {
                    g0 = null;
                }
                else if(object1 != null) {
                    g0 = (g)((k)l0.c).invoke(object1);
                }
                else {
                    g0 = null;
                }
                q.d(g0);
                Object object2 = ((List)object0).get(1);
                l l1 = K.p;
                if(q.b(object2, Boolean.FALSE)) {
                    t0 = null;
                }
                else if(object2 != null) {
                    t0 = (T)((k)l1.c).invoke(object2);
                }
                else {
                    t0 = null;
                }
                q.d(t0);
                return new x(g0, t0.a, null);
            }
            case 3: {
                List list0 = (List)object0;
                return h0;
            }
            case 4: {
                i i1 = (i)object0;
                return h0;
            }
            case 5: {
                List list1 = (List)object0;
                return h0;
            }
            default: {
                i i0 = (i)object0;
                return h0;
            }
        }
    }
}

