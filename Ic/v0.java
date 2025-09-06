package Ic;

import Jc.A;
import Pc.e;
import com.iloen.melon.utils.MelonSettingInfo;
import com.melon.ui.F4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class v0 extends i implements n {
    public final e r;
    public final A0 w;

    public v0(A0 a00, e e0, Continuation continuation0) {
        this.r = e0;
        this.w = a00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v0(this.w, this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((v0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        A a0;
        d5.n.D(object0);
        boolean z = MelonSettingInfo.isUseInstantPlay();
        A0 a00 = this.w;
        e e0 = this.r;
        if(z) {
            a0 = new A(((c0)e0).a);
        }
        else {
            String s = a00.getMenuId();
            a0 = new F4(((c0)e0).a, s);
        }
        a00.sendUiEvent(a0);
        return H.a;
    }
}

