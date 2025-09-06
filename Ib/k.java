package ib;

import com.iloen.melon.sns.model.SharableMusicDna;
import oe.c;

public final class k extends c {
    public final m B;
    public int D;
    public SharableMusicDna r;
    public Object w;

    public k(m m0, c c0) {
        this.B = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(null, null, null, null, null, this);
    }
}

