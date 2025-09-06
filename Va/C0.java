package va;

import com.iloen.melon.LoginUser;
import ie.H;
import k8.s;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class c0 extends i implements n {
    public final boolean B;
    public int r;
    public final e0 w;

    public c0(e0 e00, boolean z, Continuation continuation0) {
        this.w = e00;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                s s0 = (s)((j1)this.w.b).f.toBuilder();
                s0.m(this.B);
                ((j1)this.w.b).f = (LoginUser)s0.a();
                H h1 = ((j1)this.w.b).b.h(this.B, this);
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

