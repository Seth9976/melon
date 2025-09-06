package gd;

import com.melon.ui.f1;
import oe.c;

public final class l6 extends c {
    public final n6 B;
    public int D;
    public f1 r;
    public Object w;

    public l6(n6 n60, c c0) {
        this.B = n60;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.c(null, this);
    }
}

