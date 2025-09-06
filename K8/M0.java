package k8;

import M6.B;
import com.iloen.melon.MusicBrowserActivity;
import ie.H;
import kc.K2;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public int r;
    public final MusicBrowserActivity w;

    public m0(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d3 d30 = (d3)this.w.getPlaylistManager();
                K2 k20 = new K2(d30, null);
                B b0 = ListenableFutureKt.future$default(d30.b, null, null, k20, 3, null);
                this.r = 1;
                return ListenableFutureKt.await(b0, this) == a0 ? a0 : H.a;
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

