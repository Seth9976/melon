package kc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import oe.c;

public final class f1 extends c {
    public d B;
    public Object D;
    public final b E;
    public int G;
    public PlaylistId r;
    public Playable w;

    public f1(b b0, c c0) {
        this.E = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.h0(null, null, this);
    }
}

