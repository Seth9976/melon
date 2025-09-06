package D2;

import oe.c;

public final class k0 extends c {
    public final m0 B;
    public int D;
    public m0 r;
    public Object w;

    public k0(m0 m00, c c0) {
        this.B = m00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return m0.a(this.B, null, this);
    }
}

