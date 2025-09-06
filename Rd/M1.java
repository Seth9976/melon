package rd;

import com.iloen.melon.playback.Playable;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import ne.a;
import oe.i;
import we.k;

public final class m1 extends i implements k {
    public final Playable B;
    public int r;
    public final K1 w;

    public m1(Playable playable0, Continuation continuation0, K1 k10) {
        this.w = k10;
        this.B = playable0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new m1(this.B, continuation0, this.w);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((m1)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                l1 l10 = new l1(this.B, null);
                this.r = 1;
                object0 = BuildersKt.withContext(this.w.a, l10, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.f(object0, "withContext(...)");
        return object0;
    }
}

