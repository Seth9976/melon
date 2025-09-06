package mb;

import oe.c;

public final class a extends c {
    public final b B;
    public int D;
    public va.b r;
    public Object w;

    public a(b b0, c c0) {
        this.B = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(this);
    }
}

