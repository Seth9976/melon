package pb;

import com.iloen.melon.playback.playlist.PlaylistId;
import oe.c;

public final class k extends c {
    public final l B;
    public int D;
    public PlaylistId r;
    public Object w;

    public k(l l0, c c0) {
        this.B = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.d(this);
    }
}

