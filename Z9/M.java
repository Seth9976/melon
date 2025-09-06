package z9;

import java.util.List;
import oe.c;

public final class m extends c {
    public final F B;
    public int D;
    public List r;
    public Object w;

    public m(F f0, c c0) {
        this.B = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(null, this);
    }
}

