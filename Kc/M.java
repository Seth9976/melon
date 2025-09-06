package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import oe.c;

public final class m extends c {
    public final b B;
    public int D;
    public PlaylistId r;
    public Object w;

    public m(b b0, c c0) {
        this.B = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.l(null, this);
    }
}

