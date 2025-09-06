package Cc;

import android.net.Uri;
import oe.c;

public final class w2 extends c {
    public final x2 B;
    public int D;
    public Uri r;
    public Object w;

    public w2(x2 x20, c c0) {
        this.B = x20;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(null, this);
    }
}

