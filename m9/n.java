package m9;

import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import ie.H;
import kotlin.jvm.internal.q;
import q8.h;
import we.k;

public final class n implements k {
    public final int a;
    public final MixUpPlaylistViewImpLogHelper b;

    public n(MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0, int v) {
        this.a = v;
        this.b = mixUpPlaylistViewImpLogHelper0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0 = this.b;
        if(this.a != 0) {
            q.g(((h)object0), "$this$track");
            ((h)object0).a = mixUpPlaylistViewImpLogHelper0.c(0x7F130F18);  // string:tiara_mixup_play_waiting_list_view "재생대기목록_노출"
            return h0;
        }
        q.g(((h)object0), "$this$track");
        ((h)object0).a = mixUpPlaylistViewImpLogHelper0.c(0x7F130F1A);  // string:tiara_mixup_playing_list_view "재생목록_노출"
        return h0;
    }
}

