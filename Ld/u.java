package ld;

import Jc.A;
import Kd.c;
import Kd.f;
import Kd.h;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonSettingInfo;
import com.melon.ui.F4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class u extends i implements n {
    public final f r;
    public final x w;

    public u(f f0, x x0, Continuation continuation0) {
        this.r = f0;
        this.w = x0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        x x0 = this.w;
        String s = x0.getMenuId();
        Playable playable0 = h.b(((c)this.r).a, s);
        A a0 = MelonSettingInfo.isUseInstantPlay() ? new A(playable0) : new F4(playable0, x0.getMenuId());
        x0.sendUiEvent(a0);
        return H.a;
    }
}

