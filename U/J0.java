package U;

import B0.b;
import F.d;
import F.e;
import I.B;
import I.C;
import I.Z0;
import J0.y;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.G;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public final t0 B;
    public int r;
    public final y w;

    public j0(y y0, t0 t00, Continuation continuation0) {
        this.w = y0;
        this.B = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                l0 l00 = new l0(this.B, 0);
                m0 m00 = new m0(this.B, 0);
                m0 m01 = new m0(this.B, 1);
                e e0 = new e(this.B, 13);
                d d0 = new d(l00, 2);
                b b0 = new b(m00, 6);
                G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                C c0 = new C(B.f, g0, null, d0, e0, m01, b0, null);
                H h1 = Z0.c(this.w, c0, this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

