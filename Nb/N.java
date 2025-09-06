package Nb;

import com.melon.playback.MelonIntentService;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import y8.s;

public final class n extends i implements we.n {
    public int r;
    public final MelonIntentService w;

    public n(MelonIntentService melonIntentService0, Continuation continuation0) {
        this.w = melonIntentService0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                s s0 = this.w.i;
                if(s0 != null) {
                    this.r = 1;
                    return s0.r(this) == a0 ? a0 : H.a;
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

