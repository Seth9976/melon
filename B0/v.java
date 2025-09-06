package b0;

import N0.L;
import N0.O;
import N0.a0;
import Z.C;
import je.x;
import kotlin.jvm.internal.r;
import r1.a;
import r1.b;
import we.o;

public final class v extends r implements o {
    public static final v f;

    static {
        v.f = new v(3);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = ((O)object0).z(w.a);
        a0 a00 = ((L)object1).O(b.i(0, v * 2, ((a)object2).a));
        int v1 = a00.b - v * 2;
        int v2 = a00.a;
        C c0 = new C(a00, v, 1);
        return ((O)object0).w(v2, v1, x.a, c0);
    }
}

