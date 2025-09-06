package pd;

import Ub.t;
import android.view.View;
import com.iloen.melon.playback.StateView;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.playback.VideoControllerHelper;
import e.k;
import ic.a;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class o extends i implements n {
    public final StateView B;
    public Object r;
    public final VideoControllerHelper w;

    public o(VideoControllerHelper videoControllerHelper0, StateView stateView0, Continuation continuation0) {
        this.w = videoControllerHelper0;
        this.B = stateView0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new o(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((o)this.create(((a)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        a a0 = (a)this.r;
        d5.n.D(object0);
        VideoControllerHelper videoControllerHelper0 = this.w;
        LogConstantsKt.debugOnlyDebugMode(videoControllerHelper0.b, "collectRemoteConnectState() state: " + a0);
        boolean z = k.A(new a[]{a.c, a.d}).contains(a0);
        boolean z1 = NetUtils.isConnected();
        this.B.setEnabled(z1);
        this.B.setChecked(z);
        View view0 = this.B.getView();
        String s = videoControllerHelper0.a.getString((z ? 0x7F130BD7 : 0x7F130BD6));  // string:talkback_player_remoteconnect_on_state "외부기기 연결됨, 변경"
        if(z) {
            s1 = (String)((t)videoControllerHelper0.g).i.getValue();
            if(s1 == null) {
                s1 = "";
            }
        }
        else {
            s1 = null;
        }
        ViewUtils.setContentDescriptionWithButtonClassName(view0, s, s1);
        return H.a;
    }
}

