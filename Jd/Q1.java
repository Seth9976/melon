package jd;

import com.iloen.melon.custom.L0;
import oe.c;

public final class q1 extends c {
    public Object B;
    public final u1 D;
    public int E;
    public L0 r;
    public String w;

    public q1(u1 u10, c c0) {
        this.D = u10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.onFetchStart(null, this);
    }
}

