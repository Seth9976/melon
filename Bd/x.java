package bd;

import G.f;
import Q.K;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class x extends i implements n {
    public final a0 B;
    public int r;
    public final K w;

    public x(K k0, a0 a00, Continuation continuation0) {
        this.w = k0;
        this.B = a00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(DelayKt.delay(1300L, this) == a0) {
                    return a0;
                }
                goto label_8;
            }
            case 1: {
                d5.n.D(object0);
            label_8:
                int v = this.w.j();
                G.a0 a00 = f.q(200.0f, 5, null);
                this.r = 2;
                if(K.g(this.w, v + 1, a00, this, 2) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v1 = ((K0)this.B).m();
        ((K0)this.B).n(v1 + 1);
        return H.a;
    }
}

