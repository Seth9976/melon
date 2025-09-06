package Nb;

import M6.B;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.playback.FloatingLyricService;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class c extends i implements n {
    public int r;
    public final FloatingLyricService w;

    public c(FloatingLyricService floatingLyricService0, Continuation continuation0) {
        this.w = floatingLyricService0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        FloatingLyricService floatingLyricService0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)(((s2)floatingLyricService0.a.getValue()))).e();
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ClassUtils.equals(floatingLyricService0.m, ((Playable)object0));
        LogU.Companion.d("FloatingLyricService", "loadLyric()");
        ViewUtils.showWhen(floatingLyricService0.e, true);
        floatingLyricService0.m = (Playable)object0;
        return H.a;
    }
}

