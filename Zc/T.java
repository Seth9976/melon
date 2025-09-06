package zc;

import F.E;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.n;
import we.o;

public final class t implements o {
    public final a a;
    public final float b;
    public final List c;
    public final List d;
    public final float e;
    public final float f;
    public final List g;
    public final List h;

    public t(a a0, float f, List list0, List list1, float f1, float f2, List list2, List list3) {
        this.a = a0;
        this.b = f;
        this.c = list0;
        this.d = list1;
        this.e = f1;
        this.f = f2;
        this.g = list2;
        this.h = list3;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Integer)object2).getClass();
        q.g(((E)object0), "$this$AnimatedVisibility");
        a a0 = this.a;
        r0.q q0 = d.q(d.h(n.a, a0.a), this.b);
        List list0 = this.c;
        boolean z = ((p)(((l)object1))).i(list0);
        List list1 = this.d;
        boolean z1 = ((p)(((l)object1))).i(list1);
        float f = this.e;
        boolean z2 = ((p)(((l)object1))).d(f);
        float f1 = this.f;
        boolean z3 = ((p)(((l)object1))).d(f1);
        boolean z4 = ((p)(((l)object1))).g(a0);
        List list2 = this.g;
        boolean z5 = ((p)(((l)object1))).g(list2);
        List list3 = this.h;
        boolean z6 = ((p)(((l)object1))).g(list3);
        u u0 = ((p)(((l)object1))).N();
        if((z | z1 | z2 | z3 | z4 | z5 | z6) != 0 || u0 == k.a) {
            u0 = new u(list0, list1, f, f1, a0, list2, list3);
            ((p)(((l)object1))).l0(u0);
        }
        androidx.compose.foundation.q.b(q0, u0, ((p)(((l)object1))), 0);
        return H.a;
    }
}

