package w8;

import D2.f;
import android.content.Context;
import oe.c;

public final class h0 extends c {
    public Object B;
    public final k0 D;
    public int E;
    public Context r;
    public f w;

    public h0(k0 k00, c c0) {
        this.D = k00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.e(null, null, this);
    }
}

