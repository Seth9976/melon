package wc;

import Ic.c0;
import Jc.A;
import Pc.e;
import com.iloen.melon.utils.MelonSettingInfo;
import com.melon.ui.F4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class q extends i implements n {
    public final e r;
    public final w w;

    public q(e e0, Continuation continuation0, w w0) {
        this.r = e0;
        this.w = w0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.r, continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        A a0;
        d5.n.D(object0);
        boolean z = MelonSettingInfo.isUseInstantPlay();
        w w0 = this.w;
        e e0 = this.r;
        if(z) {
            a0 = new A(((c0)e0).a);
        }
        else {
            String s = w0.getMenuId();
            a0 = new F4(((c0)e0).a, s);
        }
        w0.sendUiEvent(a0);
        return H.a;
    }
}

