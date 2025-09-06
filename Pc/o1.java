package pc;

import oe.c;

public final class o1 extends c {
    public Object B;
    public final p1 D;
    public int E;
    public String r;
    public String w;

    public o1(p1 p10, c c0) {
        this.D = p10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.h(null, null, this);
    }
}

