package pb;

import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.playlist.PlaylistId;
import oe.c;

public final class s extends c {
    public String B;
    public PlaylistId D;
    public boolean E;
    public int G;
    public int I;
    public int M;
    public Object N;
    public final t S;
    public int T;
    public String r;
    public L0 w;

    public s(t t0, c c0) {
        this.S = t0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.N = object0;
        this.T |= 0x80000000;
        return this.S.a(0, null, this, false);
    }
}

