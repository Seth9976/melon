package kc;

import com.melon.playlist.b;
import oe.c;

public final class j0 extends c {
    public Object B;
    public Object D;
    public final b E;
    public int G;
    public int r;
    public int w;

    public j0(b b0, c c0) {
        this.E = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.R(0, 0, this);
    }
}

