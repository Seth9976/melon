package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import oe.c;

public final class h0 extends c {
    public int B;
    public int D;
    public Object E;
    public final b G;
    public int I;
    public PlaylistId r;
    public Object w;

    public h0(b b0, c c0) {
        this.G = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.Q(null, 0, 0, this);
    }
}

