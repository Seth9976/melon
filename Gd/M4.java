package gd;

import B2.p;
import Cc.P;
import F.s;
import O.j;
import O.w;
import P.i;
import P.v;
import com.iloen.melon.custom.B1;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class m4 implements k {
    public final int a;
    public final ArrayList b;
    public final k c;

    public m4(ArrayList arrayList0, k k0, int v) {
        this.a = v;
        this.b = arrayList0;
        this.c = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((v)object0), "$this$MelonLazyVerticalGrid");
            M6 m60 = new M6(2);
            P p0 = new P(25);
            y1 y10 = new y1(10, m60, this.b);
            p p1 = new p(20, p0, this.b);
            s s0 = new s(25, this.b);
            b b0 = new b(0x49456F69, new Z7(this.b, this.c, this.b, 0), true);
            ((i)(((v)object0))).t(this.b.size(), y10, p1, s0, b0);
            return H.a;
        }
        q.g(((w)object0), "$this$MelonLazyColumn");
        y1 y11 = new y1(5, new B1(23), this.b);
        s s1 = new s(24, this.b);
        b b1 = new b(0xBEF78951, new a2(this.b, this.c, 2), true);
        ((j)(((w)object0))).u(this.b.size(), y11, s1, b1);
        return H.a;
    }
}

