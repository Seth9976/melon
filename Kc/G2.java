package kc;

import com.iloen.melon.CommonPlytSettingPreferences;
import ie.H;
import k8.d;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class g2 extends i implements n {
    public Object r;
    public final boolean w;

    public g2(boolean z, Continuation continuation0) {
        this.w = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g2(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g2)this.create(((CommonPlytSettingPreferences)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CommonPlytSettingPreferences commonPlytSettingPreferences0 = (CommonPlytSettingPreferences)this.r;
        d5.n.D(object0);
        d d0 = (d)commonPlytSettingPreferences0.toBuilder();
        d0.d();
        ((CommonPlytSettingPreferences)d0.b).setIsShuffle(this.w);
        return d0.a();
    }
}

