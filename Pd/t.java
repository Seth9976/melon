package pd;

import android.widget.SeekBar;
import android.widget.TextView;
import com.melon.ui.playback.VideoControllerHelper;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class t extends i implements n {
    public final SeekBar B;
    public final TextView D;
    public final TextView E;
    public int r;
    public final VideoControllerHelper w;

    public t(SeekBar seekBar0, TextView textView0, TextView textView1, VideoControllerHelper videoControllerHelper0, Continuation continuation0) {
        this.w = videoControllerHelper0;
        this.B = seekBar0;
        this.D = textView0;
        this.E = textView1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.B, this.D, this.E, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.distinctUntilChanged(new s(this.w.n, 0));
                q q0 = new q(this.B, this.D, this.E, this.w, null);
                this.r = 1;
                return FlowKt.collectLatest(flow0, q0, this) == a0 ? a0 : H.a;
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

