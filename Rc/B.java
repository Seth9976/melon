package rc;

import com.iloen.melon.playback.playlist.add.MusicWaveAddRequestPlayableListInfo;
import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oc.V;
import oe.c;

public final class b extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public MusicWaveAddRequestPlayableListInfo I;
    public int M;
    public int N;
    public long S;
    public Object T;
    public final m V;
    public int W;
    public V r;
    public Mutex w;

    public b(m m0, c c0) {
        this.V = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.T = object0;
        this.W |= 0x80000000;
        return this.V.u(null, this);
    }
}

