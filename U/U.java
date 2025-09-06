package U;

import Y.Q;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class u extends i implements n {
    public final b0 B;
    public final Q D;
    public b0 r;
    public int w;

    public u(b0 b00, Q q0, Continuation continuation0) {
        this.B = b00;
        this.D = q0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        b0 b01;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                b0 b00 = this.B;
                this.r = b00;
                this.w = 1;
                Object object1 = U.b0.w(this.D, this);
                if(object1 == a0) {
                    return a0;
                }
                b01 = b00;
                object0 = object1;
                break;
            }
            case 1: {
                b01 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b01.setValue(object0);
        return H.a;
    }
}

