package k8;

import android.widget.TextView;
import androidx.lifecycle.f0;
import androidx.lifecycle.y;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.i;
import we.n;

public final class u0 extends i implements n {
    public final TextView B;
    public int r;
    public final MusicBrowserActivity w;

    public u0(MusicBrowserActivity musicBrowserActivity0, TextView textView0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = textView0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = SmartPlaylistServerSyncPreferencesRepository.INSTANCE.getMemberKeyFlow();
                Flow flow1 = SmartPlaylistServerSyncPreferencesRepository.INSTANCE.getVersionDateFlow();
                Flow flow2 = SmartPlaylistServerSyncPreferencesRepository.INSTANCE.getNotSentEditCount();
                s0 s00 = new s0(5, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                Flow flow3 = FlowKt.combine(flow0, flow1, flow2, EpPlayLogger.INSTANCE.getDebugReqInfo(), s00);
                y y0 = f0.f(this.w);
                K0 k00 = new K0("0", 0L, 0, null);
                StateFlow stateFlow0 = FlowKt.stateIn(flow3, y0, SharingStarted.Companion.getEagerly(), k00);
                t0 t00 = new t0(this.B, null);
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, t00, this) == a0 ? a0 : H.a;
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

