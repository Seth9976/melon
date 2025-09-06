package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import java.util.List;
import oe.c;

public final class l1 extends c {
    public List B;
    public Object D;
    public final b E;
    public int G;
    public PlaylistId r;
    public List w;

    public l1(b b0, c c0) {
        this.E = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.k0(null, null, this);
    }
}

