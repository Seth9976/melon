package pb;

import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.Playable;
import kb.D;
import oe.c;

public final class g extends c {
    public Object B;
    public final D D;
    public int E;
    public Playable r;
    public L0 w;

    public g(D d0, c c0) {
        this.D = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.l(null, null, this);
    }
}

