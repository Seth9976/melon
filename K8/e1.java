package k8;

import com.iloen.melon.MusicBrowserActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mb.q;
import mb.s;
import ne.a;
import oe.i;
import we.n;

public final class e1 extends i implements n {
    public int r;
    public final MusicBrowserActivity w;

    public e1(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
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
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                s s0 = this.w.getTokenCheckUseCase();
                this.r = 1;
                s0.getClass();
                return BuildersKt.withContext(Dispatchers.getIO(), new q(s0, null), this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

