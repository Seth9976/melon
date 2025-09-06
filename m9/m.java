package m9;

import Bd.w;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import com.kakao.tiara.data.ContentList;
import ie.H;
import kotlin.jvm.internal.q;
import p8.s;
import q8.h;
import q8.j;
import we.k;

public final class m implements k {
    public final int a;
    public final MixUpPlaylistViewImpLogHelper b;
    public final s c;
    public final ContentList d;

    public m(MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0, s s0, ContentList contentList0, int v) {
        this.a = v;
        this.b = mixUpPlaylistViewImpLogHelper0;
        this.c = s0;
        this.d = contentList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        ContentList contentList0 = this.d;
        s s0 = this.c;
        MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0 = this.b;
        if(this.a != 0) {
            q.g(((j)object0), "$this$tiaraViewLogBuilder");
            new n(mixUpPlaylistViewImpLogHelper0, 0).invoke(((h)((j)object0).b));
            ((j)object0).c(new w(s0, 14));
            ((j)object0).d(new o(((j)object0), contentList0, s0, 0));
            return h0;
        }
        q.g(((j)object0), "$this$tiaraViewLogBuilder");
        new n(mixUpPlaylistViewImpLogHelper0, 1).invoke(((h)((j)object0).b));
        ((j)object0).c(new w(s0, 15));
        ((j)object0).d(new o(((j)object0), contentList0, s0, 1));
        return h0;
    }
}

