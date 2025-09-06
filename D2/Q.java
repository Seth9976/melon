package D2;

import android.content.Context;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import w8.T;
import we.n;

public final class q extends i implements n {
    public final Context B;
    public final f D;
    public int r;
    public final T w;

    public q(f f0, Context context0, Continuation continuation0, T t0) {
        this.w = t0;
        this.B = context0;
        this.D = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.D, this.B, continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                this.w.f(this.B, this.D, this);
                return a0;
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

