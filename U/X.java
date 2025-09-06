package U;

import O.m;
import Y.Q;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import f1.j;
import f1.y;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class x extends i implements n {
    public final b0 B;
    public final y D;
    public final Q E;
    public final j G;
    public int r;
    public final f0 w;

    public x(f0 f00, b0 b00, y y0, Q q0, j j0, Continuation continuation0) {
        this.w = f00;
        this.B = b00;
        this.D = y0;
        this.E = q0;
        this.G = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f0 f00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    Flow flow0 = w.y(new m(this.B, 3));
                    U.w w0 = new U.w(f00, this.D, this.E, this.G, 0);
                    this.r = 1;
                    if(flow0.collect(w0, this) == a0) {
                        return a0;
                    label_10:
                        d5.n.D(object0);
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    U.b0.k(f00);
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
        U.b0.k(f00);
        return H.a;
    }
}

