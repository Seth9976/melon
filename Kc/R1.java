package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import oe.c;

public final class r1 extends c {
    public final t1 B;
    public int D;
    public PlaylistId r;
    public Object w;

    public r1(t1 t10, c c0) {
        this.B = t10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.d(null, this);
    }
}

