package k8;

import Cb.h;
import Vb.t0;
import android.view.Window;
import androidx.lifecycle.f0;
import androidx.lifecycle.y;
import com.iloen.melon.MusicBrowserActivity;
import gd.M6;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.i;
import we.n;

public final class k1 extends i implements n {
    public final Window B;
    public int r;
    public final MusicBrowserActivity w;

    public k1(MusicBrowserActivity musicBrowserActivity0, Window window0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = window0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = FlowKt.asStateFlow(this.w.getPlaybackManager().b);
                t0 t00 = this.w.getPlayerRules();
                y y0 = f0.f(this.w);
                M6 m60 = new M6(14);
                StateFlow stateFlow1 = h.b(stateFlow0, t00.f, y0, m60);
                j1 j10 = new j1(this.w, this.B, null);
                this.r = 1;
                return FlowKt.collectLatest(stateFlow1, j10, this) == a0 ? a0 : H.a;
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

