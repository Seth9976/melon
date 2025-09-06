package gc;

import U4.F;
import Vb.o0;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.melon.playback.manager.WakeLockManager;
import com.melon.playback.manager.WifiLockManager;
import ie.H;
import ie.r;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class s extends i implements n {
    public int r;
    public final o0 w;

    public s(o0 o00, Continuation continuation0) {
        this.w = o00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s(this.w, continuation0);
        continuation1.r = ((Number)object0).intValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((s)this.create(((Number)object0).intValue(), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v = this.r;
        d5.n.D(object0);
        r r0 = this.w.r;
        r r1 = this.w.q;
        LogConstantsKt.infoOnlyDebugMode(this.w.l, "updateWakeAndWifiLock() " + F.a0(v));
        switch(v) {
            case 2: 
            case 3: {
                WakeLockManager wakeLockManager1 = (WakeLockManager)r1.getValue();
                wakeLockManager1.c = true;
                wakeLockManager1.a();
                WifiLockManager wifiLockManager1 = (WifiLockManager)r0.getValue();
                wifiLockManager1.c = true;
                wifiLockManager1.a();
                return H.a;
            }
            case 1: 
            case 4: {
                WakeLockManager wakeLockManager0 = (WakeLockManager)r1.getValue();
                wakeLockManager0.c = false;
                wakeLockManager0.a();
                WifiLockManager wifiLockManager0 = (WifiLockManager)r0.getValue();
                wifiLockManager0.c = false;
                wifiLockManager0.a();
                return H.a;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
}

