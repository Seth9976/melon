package td;

import Ac.N;
import com.melon.ui.playermusic.d;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import ob.z;
import oe.i;
import we.n;

public final class g extends i implements n {
    public int r;
    public final d w;

    public g(d d0, Continuation continuation0) {
        this.w = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d d0 = this.w;
                z z0 = d0.h;
                if(z0 != null) {
                    Flow flow0 = z0.h();
                    N n0 = new N(d0, 28);
                    this.r = 1;
                    return flow0.collect(n0, this) == a0 ? a0 : H.a;
                }
                q.m("playerUseCase");
                throw null;
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

