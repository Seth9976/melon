package kc;

import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import ed.w0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import sc.I0;
import sc.P0;
import we.n;

public final class d1 extends i implements n {
    public int r;
    public final b w;

    public d1(b b0, Continuation continuation0) {
        this.w = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h1;
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
                    LogU.debug$default(b0.l, "syncSmartWhenAppForeground()", null, false, 6, null);
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
                w0 w00 = new w0(22, b0, ((P0)object0));
                this.r = 3;
                if(((P0)object0).k) {
                    h1 = CoroutineScopeKt.coroutineScope(new I0(((P0)object0), w00, null), this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                }
                else {
                    LogU.debug$default(((P0)object0).i, "syncWhenAppForeground - skipped because not restored yet", null, false, 6, null);
                    h1 = h0;
                }
                if(h1 == a0) {
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

