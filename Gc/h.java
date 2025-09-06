package gc;

import H0.b;
import Yb.u;
import android.app.Service;
import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnPlayerStateChanged;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Completion;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Error;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Prepared;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState;
import kotlin.jvm.internal.q;

public final class h implements OnPlayerStateChanged {
    public final l a;
    public final S0 b;
    public final Service c;

    public h(l l0, S0 s00, Service service0) {
        this.a = l0;
        this.b = s00;
        this.c = service0;
    }

    @Override  // com.kakaoent.leonplayer.core.event.LeonPlayerEventListener$OnPlayerStateChanged
    public final void onChanged(LeonPlayerState leonPlayerState0) {
        q.g(leonPlayerState0, "state");
        l l0 = this.a;
        LogConstantsKt.debugOnlyDebugMode(l0.b, "onPlayerStateChanged() state: " + leonPlayerState0);
        boolean z = leonPlayerState0.equals(Completion.INSTANCE);
        S0 s00 = this.b;
        if(z) {
            s00.d0(l0);
            return;
        }
        if(leonPlayerState0.equals(Prepared.INSTANCE)) {
            if(l0.d.compareAndSet(true, false)) {
                s00.f0(l0);
            }
        }
        else if(leonPlayerState0 instanceof Error) {
            LogU.error$default(l0.b, b.f(((Error)leonPlayerState0).getCode(), "onPlayerStateChanged() error code: ", " message: ", ((Error)leonPlayerState0).getMessage()), null, false, 6, null);
            String s = "비디오 재생 중 문제가 발생했습니다.\n잠시 후 다시 시도해 주세요.(" + ((Error)leonPlayerState0).getCode() + ")";
            LogU.error$default(l0.b, "handleError() error: " + ((Error)leonPlayerState0) + " message: " + s, null, false, 6, null);
            ((S0)l0.a).e0(l0, new u(s, ((Error)leonPlayerState0)), s);
        }
    }
}

