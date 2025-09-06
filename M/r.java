package M;

import N0.L;
import N0.O;
import N0.Z;
import N0.a0;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import we.k;

public final class r extends kotlin.jvm.internal.r implements k {
    public final a0[] f;
    public final List g;
    public final O h;
    public final F i;
    public final F j;
    public final s k;

    public r(a0[] arr_a0, List list0, O o0, F f0, F f1, s s0) {
        this.f = arr_a0;
        this.g = list0;
        this.h = o0;
        this.i = f0;
        this.j = f1;
        this.k = s0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        a0[] arr_a0 = this.f;
        int v1 = 0;
        for(int v = 0; v1 < arr_a0.length; ++v) {
            a0 a00 = arr_a0[v1];
            q.e(a00, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            p.b(((Z)object0), a00, ((L)this.g.get(v)), this.h.getLayoutDirection(), this.i.a, this.j.a, this.k.a);
            ++v1;
        }
        return H.a;
    }
}

