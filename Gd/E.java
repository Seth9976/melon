package gd;

import O.j;
import O.w;
import P.i;
import P.v;
import Yc.l;
import androidx.compose.foundation.S;
import cd.X;
import com.iloen.melon.custom.B1;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class e implements k {
    public final int a;
    public final List b;
    public final k c;

    public e(List list0, int v, k k0) {
        this.a = v;
        this.b = list0;
        this.c = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((v)object0), "$this$MelonLazyHorizontalGrid");
                X x0 = new X(this.b, 9);
                b b1 = new b(0x49456F69, new l(this.b, 1, this.c), true);
                ((i)(((v)object0))).t(this.b.size(), null, null, x0, b1);
                return H.a;
            }
            case 1: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                S s0 = new S(25, new B1(13), this.b);
                X x1 = new X(this.b, 16);
                b b2 = new b(0xBEF78951, new l(this.b, 7, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), s0, x1, b2);
                return H.a;
            }
            case 2: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                S s1 = new S(26, new B1(14), this.b);
                X x2 = new X(this.b, 17);
                b b3 = new b(0xBEF78951, new l(this.b, 8, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), s1, x2, b3);
                return H.a;
            }
            case 3: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                S s2 = new S(28, new B1(16), this.b);
                X x3 = new X(this.b, 19);
                b b4 = new b(0xBEF78951, new l(this.b, 10, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), s2, x3, b4);
                return H.a;
            }
            case 4: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                y1 y11 = new y1(3, new B1(21), this.b);
                X x4 = new X(this.b, 23);
                b b5 = new b(0xBEF78951, new l(this.b, 14, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), y11, x4, b5);
                return H.a;
            }
            case 5: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                y1 y12 = new y1(4, new B1(22), this.b);
                X x5 = new X(this.b, 24);
                b b6 = new b(0xBEF78951, new l(this.b, 15, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), y12, x5, b6);
                return H.a;
            }
            case 6: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                y1 y13 = new y1(6, new B1(24), this.b);
                X x6 = new X(this.b, 25);
                b b7 = new b(0xBEF78951, new l(this.b, 16, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), y13, x6, b7);
                return H.a;
            }
            case 7: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                y1 y14 = new y1(7, new B1(28), this.b);
                X x7 = new X(this.b, 26);
                b b8 = new b(0xBEF78951, new l(this.b, 17, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), y14, x7, b8);
                return H.a;
            }
            default: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                y1 y10 = new y1(21, new M6(15), this.b);
                hd.w w0 = new hd.w(this.b, 7);
                b b0 = new b(0xBEF78951, new l(this.b, 20, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), y10, w0, b0);
                return H.a;
            }
        }
    }
}

