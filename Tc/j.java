package tc;

import com.iloen.melon.playback.playlist.add.StationAddRequestPlayableListInfo;
import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class j extends c {
    public DevLog B;
    public Object D;
    public Mutex E;
    public Object G;
    public StationAddRequestPlayableListInfo I;
    public int M;
    public int N;
    public int S;
    public int T;
    public int V;
    public long W;
    public Object X;
    public final x Y;
    public int Z;
    public Mutex r;
    public String w;

    public j(x x0, c c0) {
        this.Y = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.X = object0;
        this.Z |= 0x80000000;
        return this.Y.e(this);
    }
}

