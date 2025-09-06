package kd;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.G;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class z extends i implements n {
    public final b0 B;
    public final b0 D;
    public int r;
    public final G w;

    public z(G g0, b0 b00, b0 b01, Continuation continuation0) {
        this.w = g0;
        this.B = b00;
        this.D = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        if(this.r != 0 && this.r != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        d5.n.D(object0);
        while(true) {
            G g0 = this.w;
            long v = g0.a;
            if(v <= 0L) {
                break;
            }
            this.B.setValue(v + "s");
            --g0.a;
            this.r = 1;
            if(DelayKt.delay(1000L, this) == a0) {
                return a0;
            }
        }
        this.D.setValue(Boolean.FALSE);
        return H.a;
    }
}

