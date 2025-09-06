package pb;

import oe.c;
import x9.a;

public final class m extends c {
    public final a B;
    public int D;
    public String r;
    public Object w;

    public m(a a0, c c0) {
        this.B = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.C(null, this);
    }
}

