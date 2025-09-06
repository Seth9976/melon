package Ac;

import Ad.v;
import F.s;
import Id.d;
import Lc.m;
import O.j;
import O.w;
import Uc.a;
import Yc.N;
import Zc.D;
import androidx.compose.foundation.S;
import androidx.fragment.app.I;
import com.melon.ui.K4;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import gd.E2;
import gd.O4;
import gd.S3;
import gd.l0;
import gd.v3;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;
import zd.c0;
import zd.n;

public final class b0 implements k {
    public final int a;
    public final ArrayList b;

    public b0(int v, ArrayList arrayList0) {
        this.a = v;
        this.b = arrayList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        boolean z = false;
        ArrayList arrayList0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((K4)object0), "it");
                return new a0(arrayList0);
            }
            case 1: {
                q.g(((K4)object0), "it");
                return new y0(arrayList0);
            }
            case 2: {
                q.g(((K4)object0), "it");
                return new m0(arrayList0);
            }
            case 3: {
                q.g(((K4)object0), "it");
                return new m0(arrayList0);
            }
            case 4: {
                q.g(((K4)object0), "it");
                return new m0(arrayList0);
            }
            case 5: {
                q.g(((K4)object0), "it");
                l4 l40 = ((K4)object0) instanceof l4 ? ((l4)(((K4)object0))) : null;
                return l40 != null ? l4.a(l40, null, arrayList0, 15) : ((K4)object0);
            }
            case 6: {
                q.g(((K4)object0), "it");
                l4 l41 = ((K4)object0) instanceof l4 ? ((l4)(((K4)object0))) : null;
                return l41 != null ? l4.a(l41, null, arrayList0, 15) : ((K4)object0);
            }
            case 7: {
                q.g(((K4)object0), "it");
                return new v(arrayList0);
            }
            case 8: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                ((j)(((w)object0))).u(arrayList0.size(), new J(23, new F(19), arrayList0), new s(1, arrayList0), new b(0xBEF78951, new d(0, arrayList0), true));
                return h0;
            }
            case 9: {
                q.g(((K4)object0), "it");
                return new m(arrayList0);
            }
            case 10: {
                q.g(((K4)object0), "it");
                return new N(arrayList0);
            }
            case 11: {
                q.g(((K4)object0), "it");
                return new D(arrayList0);
            }
            case 12: {
                q.g(((w)object0), "$this$MelonLazyRow");
                ((j)(((w)object0))).u(arrayList0.size(), new S(12, new a(15), arrayList0), new s(19, arrayList0), new b(0xBEF78951, new d(6, arrayList0), true));
                return h0;
            }
            case 13: {
                q.g(((K4)object0), "it");
                return new gd.S(arrayList0);
            }
            case 14: {
                q.g(((K4)object0), "it");
                return new gd.S(arrayList0);
            }
            case 15: {
                q.g(((K4)object0), "it");
                return new l0(arrayList0);
            }
            case 16: {
                q.g(((K4)object0), "it");
                return new l0(arrayList0);
            }
            case 17: {
                q.g(((K4)object0), "it");
                return new E2(arrayList0);
            }
            case 18: {
                q.g(((K4)object0), "it");
                return new v3(arrayList0);
            }
            case 19: {
                q.g(((K4)object0), "it");
                return new S3(arrayList0);
            }
            case 20: {
                q.g(((K4)object0), "it");
                return new O4(arrayList0);
            }
            case 21: {
                q.g(((K4)object0), "it");
                return new O4(arrayList0);
            }
            case 22: {
                q.g(((K4)object0), "it");
                return new O4(arrayList0);
            }
            case 23: {
                q.g(((I)object0), "it");
                if(((I)object0) instanceof MelonBottomSheetComposeDialogFragment && q.b(((c0)((MelonBottomSheetComposeDialogFragment)(((I)object0))).getViewModel()).i, new n(arrayList0))) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            default: {
                K4 k40 = (K4)object0;
                return new xd.k(arrayList0);
            }
        }
    }
}

