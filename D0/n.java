package d0;

import oe.c;

public final class n extends c {
    public Object B;
    public final p D;
    public int E;
    public p r;
    public float w;

    public n(p p0, c c0) {
        this.D = p0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.t0(0.0f, this);
    }
}

