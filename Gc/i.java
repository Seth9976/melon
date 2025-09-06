package gc;

import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnBufferingStateChanged;

public final class i implements OnBufferingStateChanged {
    public final l a;
    public final S0 b;

    public i(S0 s00, l l0) {
        this.a = l0;
        this.b = s00;
    }

    @Override  // com.kakaoent.leonplayer.core.event.LeonPlayerEventListener$OnBufferingStateChanged
    public final void onChanged(boolean z) {
        LogConstantsKt.debugOnlyDebugMode(this.a.b, "onBufferingStateChanged() isBuffering: " + z);
        this.b.c0(this.a, z);
    }
}

