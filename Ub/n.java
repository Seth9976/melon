package Ub;

import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.playback.manager.DlnaHelper;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;

public final class n extends i implements we.n {
    public final DlnaHelper B;
    public int r;
    public Object w;

    public n(DlnaHelper dlnaHelper0, Continuation continuation0) {
        this.B = dlnaHelper0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    DlnaHelper.d(this.B);
                    if(!this.B.h().b.get()) {
                        DlnaHelper.e(this.B);
                        goto label_10;
                    label_9:
                        d5.n.D(object0);
                    }
                    while(true) {
                    label_10:
                        if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                            return H.a;
                        }
                        DlnaHelper dlnaHelper0 = this.B;
                        synchronized(dlnaHelper0) {
                            LogU.info$default(dlnaHelper0.b, "search()", null, false, 6, null);
                            long v1 = System.currentTimeMillis();
                            if(dlnaHelper0.h().b.get()) {
                                dlnaHelper0.h().b();
                            }
                            LogConstantsKt.debug(dlnaHelper0.b, "search() :: end", v1);
                        }
                        this.w = coroutineScope0;
                        this.r = 1;
                        if(DelayKt.delay(this.B.c, this) == a0) {
                            return a0;
                        }
                    }
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_9;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.B.b, "search() - Task terminated : " + exception0.getMessage(), null, false, 6, null);
        return H.a;
    }
}

