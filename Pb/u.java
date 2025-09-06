package pb;

import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.playlist.PlaylistId;
import oe.c;

public final class u extends c {
    public PlaylistId B;
    public int D;
    public int E;
    public Object G;
    public final v I;
    public int M;
    public L0 r;
    public String w;

    public u(v v0, c c0) {
        this.I = v0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.a(this);
    }
}

