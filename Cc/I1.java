package Cc;

import A0.d;
import A0.f;
import O.j;
import O.w;
import P.i;
import P.v;
import P0.K;
import Uc.a;
import androidx.compose.foundation.S;
import androidx.compose.runtime.b0;
import cd.X;
import cd.h1;
import cd.x1;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import wc.u;
import we.k;
import y0.s;

public final class i1 implements k {
    public final int a;
    public final b0 b;
    public final b0 c;

    public i1(b0 b00, b0 b01, int v) {
        this.a = v;
        this.b = b00;
        this.c = b01;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "$this$drawWithContent");
                ((K)(((d)object0))).a();
                if(((Boolean)this.b.getValue()).booleanValue()) {
                    if(((Boolean)this.c.getValue()).booleanValue()) {
                        e0.O(((d)object0), true);
                    }
                    e0.O(((d)object0), false);
                }
                return H.a;
            }
            case 1: {
                q.g(((w)object0), "$this$MelonLazyRow");
                List list0 = (List)this.b.getValue();
                ((j)(((w)object0))).u(list0.size(), new S(17, new a(20), list0), new X(list0, 5), new b(0xBEF78951, new h1(list0, this.c, 0), true));
                return H.a;
            }
            case 2: {
                q.g(((v)object0), "$this$LazyHorizontalGrid");
                List list1 = (List)this.b.getValue();
                if(list1 == null) {
                    list1 = je.w.a;
                }
                ((i)(((v)object0))).t(list1.size(), new S(18, new x1(this.c, 0), list1), null, new X(list1, 6), new b(0x49456F69, new h1(list1, this.c, 1), true));
                return H.a;
            }
            default: {
                q.g(((d)object0), "$this$drawWithContent");
                A0.b b0 = ((K)(((d)object0))).a;
                ((K)(((d)object0))).a();
                b0 b00 = this.b;
                if(((Boolean)b00.getValue()).booleanValue()) {
                    long v = s.b;
                    s s0 = new s(s.c(v, 1.0f));
                    long v1 = s.f;
                    f.f0(((d)object0), u.e(e.k.A(new s[]{s0, new s(v1)}), Float.intBitsToFloat(((int)(b0.c() >> 0x20))) - ((float)ViewUtilsKt.dpToPx(30)), Float.intBitsToFloat(((int)(b0.c() >> 0x20))), 8), 0L, 0L, 0.0f, null, 62);
                    if(((Boolean)b00.getValue()).booleanValue() && ((Boolean)this.c.getValue()).booleanValue()) {
                        f.f0(((d)object0), u.e(e.k.A(new s[]{new s(v1), new s(s.c(v, 1.0f))}), 0.0f, ((float)ViewUtilsKt.dpToPx(30)), 8), 0L, 0L, 0.0f, null, 62);
                    }
                }
                return H.a;
            }
        }
    }
}

