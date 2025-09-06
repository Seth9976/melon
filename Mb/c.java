package mb;

import ie.p;
import ne.a;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final f w;

    public c(f f0, oe.c c0) {
        this.w = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        Object object1 = this.w.a(this);
        return object1 == a.a ? object1 : new p(object1);
    }
}

