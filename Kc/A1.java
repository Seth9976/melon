package kc;

import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import sc.P0;
import we.n;

public final class a1 extends i implements n {
    public int r;
    public final b w;

    public a1(b b0, Continuation continuation0) {
        this.w = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b b0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = b0.y(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_12;
            }
            case 1: {
                d5.n.D(object0);
            label_12:
                if(((Boolean)object0).booleanValue()) {
                    LogU.debug$default(b0.l, "syncSmartByAppDataFromUserSelectPopup()", null, false, 6, null);
                    this.r = 2;
                    object0 = b0.b.h(false, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_19;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
            label_19:
                this.r = 3;
                if(((P0)object0).a0(this) == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

