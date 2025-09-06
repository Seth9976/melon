package I;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class o extends i implements n {
    public final r B;
    public final n D;
    public int r;
    public Object w;

    public o(r r0, n n0, Continuation continuation0) {
        this.B = r0;
        this.D = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new o(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((F0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        b0 b00 = this.B.d;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                F0 f00 = (F0)this.w;
                ((O0)b00).setValue(Boolean.TRUE);
                try {
                    this.r = 1;
                    if(this.D.invoke(f00, this) == a0) {
                        return a0;
                    label_10:
                        d5.n.D(object0);
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    ((O0)b00).setValue(Boolean.FALSE);
                    throw throwable0;
                }
            }
            case 1: {
                goto label_10;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((O0)b00).setValue(Boolean.FALSE);
        return H.a;
    }
}

