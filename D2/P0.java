package D2;

import android.content.Context;
import oe.c;

public final class p0 extends c {
    public Object B;
    public final C D;
    public int E;
    public Context r;
    public int w;

    public p0(C c0, c c1) {
        this.D = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, 0, this);
    }
}

