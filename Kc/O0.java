package kc;

import com.iloen.melon.playback.Playable;
import com.melon.playlist.b;
import oc.w;
import oe.c;

public final class o0 extends c {
    public w B;
    public Playable D;
    public Object E;
    public final b G;
    public int I;
    public boolean r;
    public boolean w;

    public o0(b b0, c c0) {
        this.G = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return b.j(this.G, false, false, this);
    }
}

