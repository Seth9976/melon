package jd;

import G.a0;
import androidx.compose.foundation.Q0;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final b0 B;
    public int r;
    public final Q0 w;

    public e(Q0 q00, b0 b00, Continuation continuation0) {
        this.w = q00;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(((Boolean)b00.getValue()).booleanValue()) {
                    int v = ((K0)this.w.d).m();
                    this.r = 1;
                    a0 a00 = new a0(null, 7);
                    if(this.w.f(v, a00, this) == a0) {
                        return a0;
                    }
                    b00.setValue(Boolean.FALSE);
                    return H.a;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                b00.setValue(Boolean.FALSE);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

