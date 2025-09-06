package androidx.room;

import ie.H;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.n;

public final class b0 extends i implements n {
    public final a B;
    public int r;
    public final h0 w;

    public b0(h0 h00, a a0, Continuation continuation0) {
        this.w = h00;
        this.B = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        a a1 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    this.r = 1;
                    object0 = h0.b(this.w, this);
                    if(object0 == a0) {
                        return a0;
                    label_9:
                        d5.n.D(object0);
                    }
                    Set set0 = (Set)object0;
                    goto label_15;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 1: {
                goto label_9;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a1.invoke();
        throw throwable0;
    label_15:
        a1.invoke();
        return H.a;
    }
}

