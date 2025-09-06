package kc;

import com.iloen.melon.CommonPlytSettingPreferences;
import i.n.i.b.a.s.e.M3;
import ie.H;
import k8.d;
import kotlin.coroutines.Continuation;
import oc.M;
import oe.i;
import we.n;

public final class e2 extends i implements n {
    public Object r;
    public final M w;

    public e2(M m0, Continuation continuation0) {
        this.w = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e2(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e2)this.create(((CommonPlytSettingPreferences)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v = 1;
        CommonPlytSettingPreferences commonPlytSettingPreferences0 = (CommonPlytSettingPreferences)this.r;
        d5.n.D(object0);
        int v1 = this.w.ordinal();
        if(v1 == 0) {
            v = 0;
        }
        else if(v1 != 1) {
            v = 2;
            if(v1 != 2) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        d d0 = (d)commonPlytSettingPreferences0.toBuilder();
        d0.d();
        ((CommonPlytSettingPreferences)d0.b).setRepeatMode(v);
        return d0.a();
    }
}

