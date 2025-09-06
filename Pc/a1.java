package pc;

import oe.c;

public final class a1 extends c {
    public Object B;
    public final b1 D;
    public int E;
    public String r;
    public String w;

    public a1(b1 b10, c c0) {
        this.D = b10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.h(null, null, this);
    }
}

