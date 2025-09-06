package ob;

import com.iloen.melon.playback.playlist.PlaylistId;
import oe.c;

public final class q extends c {
    public int B;
    public Object D;
    public final z E;
    public int G;
    public PlaylistId r;
    public int w;

    public q(z z0, c c0) {
        this.E = z0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.p(null, 0, this);
    }
}

