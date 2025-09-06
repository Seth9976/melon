package R8;

import java.util.Iterator;
import oe.c;

public final class j extends c {
    public final l B;
    public int D;
    public Iterator r;
    public Object w;

    public j(l l0, c c0) {
        this.B = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.j(this);
    }
}

