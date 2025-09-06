package gc;

import com.iloen.melon.custom.S0;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnSeekComplete;

public final class k implements OnSeekComplete {
    public final S0 a;
    public final l b;

    public k(S0 s00, l l0) {
        this.a = s00;
        this.b = l0;
    }

    @Override  // com.kakaoent.leonplayer.core.event.LeonPlayerEventListener$OnSeekComplete
    public final void onSeekComplete() {
        this.a.g0(this.b);
    }
}

