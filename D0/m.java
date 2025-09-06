package d0;

import oe.c;

public final class m extends c {
    public int B;
    public Object r;
    public final p w;

    public m(p p0, c c0) {
        this.w = p0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.onPreFling-QWom1Mo(0L, this);
    }
}

