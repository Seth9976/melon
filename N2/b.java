package n2;

import oe.c;
import okio.BufferedSource;

public final class b extends c {
    public Object B;
    public final n2.c D;
    public int E;
    public Object r;
    public BufferedSource w;

    public b(n2.c c0, c c1) {
        this.D = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return n2.c.f(this.D, this);
    }
}

