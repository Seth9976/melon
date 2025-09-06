package M2;

import oe.c;

public final class d extends c {
    public int B;
    public Object r;
    public final f w;

    public d(f f0, c c0) {
        this.w = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(null, null, null, this);
    }
}

