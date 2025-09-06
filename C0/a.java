package c0;

import N0.L;
import N0.O;
import N0.a0;
import Z.C;
import je.x;
import kotlin.jvm.internal.r;
import r1.b;
import we.o;

public final class a extends r implements o {
    public static final a f;

    static {
        a.f = new a(3);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = ((O)object0).z(c.a);
        a0 a00 = ((L)object1).O(b.i(v * 2, 0, ((r1.a)object2).a));
        int v1 = a00.b;
        int v2 = a00.a - v * 2;
        C c0 = new C(a00, v, 2);
        return ((O)object0).w(v2, v1, x.a, c0);
    }
}

