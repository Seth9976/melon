package gc;

import A9.f;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.LeonPlayerHelperKt;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnTimedMetaData;
import com.kakaoent.leonplayer.core.model.data.player.LeonTimedMeta;
import d5.n;
import ie.H;
import ie.p;
import kotlin.jvm.internal.q;

public final class j implements OnTimedMetaData {
    public final l a;

    public j(l l0) {
        this.a = l0;
    }

    @Override  // com.kakaoent.leonplayer.core.event.LeonPlayerEventListener$OnTimedMetaData
    public final void onTimedMetaData(LeonTimedMeta leonTimedMeta0) {
        H h0;
        q.g(leonTimedMeta0, "leonTimedMeta");
        try {
            f.b(LeonPlayerHelperKt.toTimedMeta(leonTimedMeta0));
            h0 = H.a;
        }
        catch(Throwable throwable0) {
            h0 = n.t(throwable0);
        }
        if(p.a(h0) != null) {
            LogU.error$default(this.a.b, "onTimedMetaData() Failed to parse leonTimedMeta " + leonTimedMeta0, null, false, 6, null);
        }
    }
}

