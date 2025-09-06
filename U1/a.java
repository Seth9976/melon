package u1;

import N0.Z;
import Q0.s;
import X0.x;
import android.view.View;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class a extends r implements k {
    public final int f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;

    static {
        a.g = new a(1, 0);
        a.h = new a(1, 1);
        a.i = new a(1, 2);
        a.j = new a(1, 3);
        a.k = new a(1, 4);
        a.l = new a(1, 5);
    }

    public a(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                Q4.a a0 = (Q4.a)object0;
                return H.a;
            }
            case 1: {
                Q4.a a1 = (Q4.a)object0;
                return H.a;
            }
            case 2: {
                ((i)object0).getHandler().post(new s(3, ((i)object0).w));
                return H.a;
            }
            case 3: {
                Z z0 = (Z)object0;
                return H.a;
            }
            case 4: {
                x x0 = (x)object0;
                return H.a;
            }
            default: {
                View view0 = (View)object0;
                return H.a;
            }
        }
    }
}

