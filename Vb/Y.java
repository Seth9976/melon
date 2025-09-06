package Vb;

import Yb.k;
import android.net.Uri;
import oe.c;

public final class y extends c {
    public Object B;
    public final o0 D;
    public int E;
    public Uri r;
    public k w;

    public y(o0 o00, c c0) {
        this.D = o00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c1(null, this);
    }
}

