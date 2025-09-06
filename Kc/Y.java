package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import kotlinx.coroutines.sync.Mutex;
import oe.c;
import we.k;

public final class y extends c {
    public Mutex B;
    public int D;
    public int E;
    public Object G;
    public final b I;
    public int M;
    public PlaylistId r;
    public k w;

    public y(b b0, c c0) {
        this.I = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.p(null, null, this);
    }
}

