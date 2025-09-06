package mb;

import oe.c;

public final class m extends c {
    public final n B;
    public int D;
    public String r;
    public Object w;

    public m(n n0, c c0) {
        this.B = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(null, this);
    }
}

