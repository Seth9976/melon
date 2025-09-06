package pb;

import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.playlist.PlaylistId;
import oe.c;

public final class z extends c {
    public PlaylistId B;
    public int D;
    public int E;
    public Object G;
    public final A I;
    public int M;
    public L0 r;
    public String w;

    public z(A a0, c c0) {
        this.I = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.a(this);
    }
}

