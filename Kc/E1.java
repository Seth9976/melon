package kc;

import com.iloen.melon.playback.SpApiQueueManagerImpl;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import sc.I2;
import sc.J0;
import sc.P0;
import sc.S2;
import sc.l1;
import we.n;

public final class e1 extends i implements n {
    public int r;
    public final b w;

    public e1(b b0, Continuation continuation0) {
        this.w = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        b b0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = b0.y(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_13;
            }
            case 1: {
                d5.n.D(object0);
            label_13:
                if(((Boolean)object0).booleanValue()) {
                    LogU.debug$default(b0.l, "syncSmartWhenOpenPlaylistUI()", null, false, 6, null);
                    this.r = 2;
                    object0 = b0.b.h(false, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_20;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
            label_20:
                this.r = 3;
                if(((P0)object0).k) {
                    J0 j00 = new J0(((P0)object0), null);
                    S2 s20 = (S2)((P0)object0).e;
                    s20.getClass();
                    SpApiQueueManagerImpl spApiQueueManagerImpl0 = s20.d;
                    if(spApiQueueManagerImpl0.isEmpty()) {
                        l1 l10 = S2.u();
                        if(l10 == null) {
                            LogU.error$default(s20.a, "SyncWhenOpenPlaylistUI - userData is null", null, false, 6, null);
                        }
                        else {
                            spApiQueueManagerImpl0.enqueue(new I2(s20, l10, j00));
                        }
                    }
                    else {
                        LogU.debug$default(s20.a, "syncWhenOpenPlaylistUI skipped because queue is not empty.", null, false, 6, null);
                        spApiQueueManagerImpl0.start();
                    }
                }
                else {
                    LogU.debug$default(((P0)object0).i, "syncWhenOpenPlaylistUI - skipped because not restored yet", null, false, 6, null);
                }
                if(h0 == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

