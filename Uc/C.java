package uc;

import com.iloen.melon.playback.playlist.add.LiveAddRequestPlayableListInfo;
import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oc.V;

public final class c extends oe.c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public LiveAddRequestPlayableListInfo I;
    public int M;
    public int N;
    public int S;
    public int T;
    public int V;
    public long W;
    public Object X;
    public final j Y;
    public int Z;
    public V r;
    public Mutex w;

    public c(j j0, oe.c c0) {
        this.Y = j0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.X = object0;
        this.Z |= 0x80000000;
        return this.Y.u(null, this);
    }
}

