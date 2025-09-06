package pb;

import com.iloen.melon.playback.Playable;
import oe.c;

public final class w extends c {
    public final x B;
    public int D;
    public Playable r;
    public Object w;

    public w(x x0, c c0) {
        this.B = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(null, this);
    }
}

