package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import oe.c;
import oe.i;

public final class i1 extends c {
    public i B;
    public Object D;
    public boolean E;
    public boolean G;
    public Object I;
    public final b M;
    public int N;
    public PlaylistId r;
    public String w;

    public i1(b b0, c c0) {
        this.M = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.i0(null, null, false, false, null, this);
    }
}

