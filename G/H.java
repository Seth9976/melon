package G;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class h extends i implements n {
    public final e B;
    public final b0 D;
    public final b0 E;
    public int r;
    public final Object w;

    public h(Object object0, e e0, b0 b00, b0 b01, Continuation continuation0) {
        this.w = object0;
        this.B = e0;
        this.D = b00;
        this.E = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        e e0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Object object1 = ((O0)e0.e).getValue();
                if(!q.b(this.w, object1)) {
                    Object object2 = this.D.getValue();
                    this.r = 1;
                    if(e.c(this.B, this.w, ((o)object2), null, this, 12) == a0) {
                        return a0;
                    }
                    goto label_12;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
            label_12:
                k k0 = (k)this.E.getValue();
                if(k0 != null) {
                    k0.invoke(e0.d());
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

