package F;

import G.t0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k0;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class x extends i implements n {
    public final t0 B;
    public final b0 D;
    public int r;
    public Object w;

    public x(t0 t00, b0 b00, Continuation continuation0) {
        this.B = t00;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new x(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((k0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                k0 k00 = (k0)this.w;
                Flow flow0 = w.y(new v(this.B, 0));
                F.w w0 = new F.w(k00, this.B, this.D, 0);
                this.r = 1;
                return flow0.collect(w0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

