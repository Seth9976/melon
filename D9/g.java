package d9;

import M6.B;
import com.iloen.melon.utils.log.LogU;
import e.k;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final h B;
    public h r;
    public int w;

    public g(h h0, Continuation continuation0) {
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        h h1;
        a a0 = a.a;
        h h0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)h0.f).r();
                this.r = h0;
                this.w = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                h1 = h0;
                break;
            }
            case 1: {
                h1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        h1.e(k.p(((oc.H)object0)));
        LogU.debug$default(h0.b, "updatePlayable() - playable:" + (h0.m == null ? null : ""), null, false, 6, null);
        return H.a;
    }
}

