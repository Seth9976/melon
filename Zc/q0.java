package Zc;

import java.util.List;
import oe.c;

public final class q0 extends c {
    public Object B;
    public final t0 D;
    public int E;
    public List r;
    public Y w;

    public q0(t0 t00, c c0) {
        this.D = t00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return t0.d(this.D, this);
    }
}

