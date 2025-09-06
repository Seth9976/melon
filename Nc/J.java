package nc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class j extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final u0 T;
    public int V;
    public PlaylistId r;
    public Mutex w;

    public j(u0 u00, c c0) {
        this.T = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.E(null, this);
    }
}

