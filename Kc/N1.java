package kc;

import com.melon.playlist.b;
import com.melon.playlist.station.CastData;
import oe.c;

public final class n1 extends c {
    public final b B;
    public int D;
    public CastData r;
    public Object w;

    public n1(b b0, c c0) {
        this.B = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.l0(null, this);
    }
}

