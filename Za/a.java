package Za;

import oe.c;

public final class a extends c {
    public int B;
    public Object r;
    public final b w;

    public a(b b0, c c0) {
        this.w = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(null, null, null, null, null, this);
    }
}

