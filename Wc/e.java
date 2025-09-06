package wc;

import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;
import we.a;

public final class e implements a {
    public final int a;
    public final RESPONSE b;
    public final w c;

    public e(RESPONSE albumInfoRes$RESPONSE0, w w0, int v) {
        this.a = v;
        this.b = albumInfoRes$RESPONSE0;
        this.c = w0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        w w0 = this.c;
        RESPONSE albumInfoRes$RESPONSE0 = this.b;
        if(this.a != 0) {
            Playable playable0 = Playable.from(albumInfoRes$RESPONSE0.albumInfo, w0.getMenuId(), null);
            q.f(playable0, "from(...)");
            return playable0;
        }
        Playable playable1 = Playable.from(albumInfoRes$RESPONSE0.albumInfo, w0.getMenuId(), null);
        q.f(playable1, "from(...)");
        return playable1;
    }
}

