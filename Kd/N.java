package kd;

import O.F;
import O.u;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;

public final class n extends i implements we.n {
    public final b0 B;
    public final b0 D;
    public int r;
    public final F w;

    public n(F f0, b0 b00, b0 b01, Continuation continuation0) {
        this.w = f0;
        this.B = b00;
        this.D = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.B;
    alab1:
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                int v = ((c0)b00.getValue()).ordinal();
                b0 b01 = this.D;
                switch(v) {
                    case 1: {
                        b01.setValue(Boolean.TRUE);
                        break alab1;
                    }
                    case 2: {
                        u u0 = this.w.h();
                        this.r = 1;
                        if(this.w.j(u0.n, 0, this) == a0) {
                            return a0;
                        }
                        break alab1;
                    }
                    default: {
                        b01.setValue(Boolean.FALSE);
                        break alab1;
                    }
                }
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b00.setValue(c0.a);
        return H.a;
    }
}

