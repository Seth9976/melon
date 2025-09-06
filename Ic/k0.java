package Ic;

import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;
import we.a;

public final class k0 implements a {
    public final int a;
    public final RESPONSE b;
    public final A0 c;

    public k0(RESPONSE albumInfoRes$RESPONSE0, A0 a00, int v) {
        this.a = v;
        this.b = albumInfoRes$RESPONSE0;
        this.c = a00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        A0 a00 = this.c;
        RESPONSE albumInfoRes$RESPONSE0 = this.b;
        if(this.a != 0) {
            Playable playable0 = Playable.from(albumInfoRes$RESPONSE0.albumInfo, a00.getMenuId(), null);
            q.f(playable0, "from(...)");
            return playable0;
        }
        Playable playable1 = Playable.from(albumInfoRes$RESPONSE0.albumInfo, a00.getMenuId(), null);
        q.f(playable1, "from(...)");
        return playable1;
    }
}

