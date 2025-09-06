package pc;

import java.util.List;
import oe.c;

public final class f0 extends c {
    public Object B;
    public final y0 D;
    public int E;
    public E0 r;
    public List w;

    public f0(y0 y00, c c0) {
        this.D = y00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return y0.a(this.D, null, this);
    }
}

