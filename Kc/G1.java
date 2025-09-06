package kc;

import com.iloen.melon.playback.Playable;
import com.melon.playlist.b;
import oe.c;

public final class g1 extends c {
    public boolean B;
    public Object D;
    public final b E;
    public int G;
    public Playable r;
    public int w;

    public g1(b b0, c c0) {
        this.E = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.g0(null, null, 0, false, this);
    }
}

