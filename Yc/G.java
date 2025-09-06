package yc;

import I.Z0;
import androidx.compose.foundation.Q0;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final a0 B;
    public final a0 D;
    public int r;
    public final Q0 w;

    public g(Q0 q00, a0 a00, a0 a01, Continuation continuation0) {
        this.w = q00;
        this.B = a00;
        this.D = a01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        a0 a00 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                int v = ((K0)a00).m();
                this.r = 1;
                int v1 = this.w.g();
                if(Z0.e(this.w, ((float)(-v - v1)), this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v2 = ((K0)a00).m();
        ((K0)this.D).n(-v2);
        return H.a;
    }
}

