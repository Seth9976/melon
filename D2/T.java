package D2;

import android.content.Context;
import ie.H;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import w8.T;
import we.n;

public final class t extends i implements n {
    public final T B;
    public final Context D;
    public final f E;
    public int r;
    public Object w;

    public t(f f0, Context context0, Continuation continuation0, T t0) {
        this.B = t0;
        this.D = context0;
        this.E = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t(this.E, this.D, continuation0, this.B);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ProducerScope producerScope0 = (ProducerScope)this.w;
                s s0 = new s(new AtomicReference(null), producerScope0);
                q q0 = new q(this.E, this.D, null, this.B);
                this.r = 1;
                return BuildersKt.withContext(s0, q0, this) == a0 ? a0 : H.a;
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

