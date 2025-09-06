package rb;

import oe.c;

public final class e extends c {
    public int B;
    public Object r;
    public final i w;

    public e(i i0, c c0) {
        this.w = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(0, null, this);
    }
}

