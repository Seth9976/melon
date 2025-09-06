package G;

import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import we.n;

public final class q0 extends i implements n {
    public Object B;
    public final t0 D;
    public float r;
    public int w;

    public q0(t0 t00, Continuation continuation0) {
        this.D = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope1;
        float f;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.B;
                f = f.m(coroutineScope0.getCoroutineContext());
                coroutineScope1 = coroutineScope0;
                break;
            }
            case 1: {
                f = this.r;
                coroutineScope1 = (CoroutineScope)this.B;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(CoroutineScopeKt.isActive(coroutineScope1)) {
            p0 p00 = new p0(this.D, f);
            this.B = coroutineScope1;
            this.r = f;
            this.w = 1;
            if(w.l(this.getContext()).c(p00, this) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }
}

