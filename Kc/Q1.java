package kc;

import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import oe.c;

public final class q1 extends c {
    public final t1 B;
    public int D;
    public AddPlay r;
    public Object w;

    public q1(t1 t10, c c0) {
        this.B = t10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.c(null, false, this);
    }
}

