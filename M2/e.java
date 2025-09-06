package M2;

import oe.c;
import oe.i;

public final class e extends c {
    public final f B;
    public int D;
    public i r;
    public Object w;

    public e(f f0, c c0) {
        this.B = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.d(null, null, null, null, this);
    }
}

