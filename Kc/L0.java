package kc;

import com.iloen.melon.constants.AddPosition;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import ne.a;
import oe.i;
import sc.P0;
import sc.x;
import we.n;

public final class l0 extends i implements n {
    public final AddPosition B;
    public int r;
    public final b w;

    public l0(b b0, AddPosition addPosition0, Continuation continuation0) {
        this.w = b0;
        this.B = addPosition0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
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
                ((P0)object0).getClass();
                x x0 = new x(((P0)object0), this.B, null);
                H h1 = BuildersKt.withContext(NonCancellable.INSTANCE, x0, this);
                if(h1 != a0) {
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

