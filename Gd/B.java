package gd;

import O.j;
import O.w;
import P.i;
import P.v;
import Yc.l;
import cd.X;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class b implements k {
    public final int a;
    public final B2 b;
    public final k c;

    public b(B2 b20, k k0, int v) {
        this.a = v;
        this.b = b20;
        this.c = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((w)object0), "$this$MelonLazyRow");
                X x1 = new X(this.b.b, 12);
                m0.b b1 = new m0.b(0xBEF78951, new l(this.b.b, 4, this.c), true);
                ((j)(((w)object0))).u(this.b.b.size(), null, x1, b1);
                return H.a;
            }
            case 1: {
                q.g(((v)object0), "$this$MelonLazyHorizontalGrid");
                X x2 = new X(this.b.b, 10);
                m0.b b2 = new m0.b(0x49456F69, new l(this.b.b, 2, this.c), true);
                ((i)(((v)object0))).t(this.b.b.size(), null, null, x2, b2);
                return H.a;
            }
            case 2: {
                q.g(((w)object0), "$this$MelonLazyRow");
                X x3 = new X(this.b.b, 11);
                m0.b b3 = new m0.b(0xBEF78951, new l(this.b.b, 3, this.c), true);
                ((j)(((w)object0))).u(this.b.b.size(), null, x3, b3);
                return H.a;
            }
            case 3: {
                q.g(((w)object0), "$this$MelonLazyRow");
                X x4 = new X(this.b.b, 13);
                m0.b b4 = new m0.b(0xBEF78951, new l(this.b.b, 5, this.c), true);
                ((j)(((w)object0))).u(this.b.b.size(), null, x4, b4);
                return H.a;
            }
            default: {
                q.g(((v)object0), "$this$MelonLazyHorizontalGrid");
                X x0 = new X(this.b.b, 14);
                m0.b b0 = new m0.b(0x49456F69, new l(this.b.b, 6, this.c), true);
                ((i)(((v)object0))).t(this.b.b.size(), null, null, x0, b0);
                return H.a;
            }
        }
    }
}

