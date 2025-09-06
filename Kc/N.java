package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import oe.c;

public final class n extends c {
    public Object B;
    public final b D;
    public int E;
    public PlaylistId r;
    public PlaylistId w;

    public n(b b0, c c0) {
        this.D = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return b.b(this.D, null, this);
    }
}

