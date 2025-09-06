package tc;

import com.iloen.melon.utils.log.DevLog;
import com.melon.playlist.station.CastData;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class r extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final x T;
    public int V;
    public CastData r;
    public Mutex w;

    public r(x x0, c c0) {
        this.T = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.j(null, this);
    }
}

