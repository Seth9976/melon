package Nb;

import Qb.z;
import com.melon.playback.MelonIntentService;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;
import y8.s;

public final class m extends i implements n {
    public final MelonIntentService r;
    public final boolean w;

    public m(MelonIntentService melonIntentService0, boolean z, Continuation continuation0) {
        this.r = melonIntentService0;
        this.w = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        s s0 = this.r.i;
        if(s0 != null) {
            ((z)s0.a).t(this.w);
            return H.a;
        }
        q.m("playerUseCase");
        throw null;
    }
}

