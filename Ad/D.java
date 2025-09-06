package ad;

import F.s;
import Ld.p;
import O.j;
import O.w;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class d implements k {
    public final ArrayList a;
    public final int b;
    public final int c;
    public final int d;
    public final a e;

    public d(ArrayList arrayList0, int v, int v1, int v2, a j$a0) {
        this.a = arrayList0;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = j$a0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((w)object0), "$this$MelonLazyColumn");
        p p0 = new p(27, new Uc.a(11), this.a);
        s s0 = new s(18, this.a);
        b b0 = new b(0xBEF78951, new h(this.a, this.b, this.c, this.d, this.e), true);
        ((j)(((w)object0))).u(this.a.size(), p0, s0, b0);
        return H.a;
    }
}

