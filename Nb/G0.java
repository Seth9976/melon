package Nb;

import androidx.media3.session.w0;
import androidx.media3.session.y0;
import oe.c;

public final class g0 extends c {
    public Object B;
    public final h0 D;
    public int E;
    public w0 r;
    public y0 w;

    public g0(h0 h00, c c0) {
        this.D = h00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return h0.c(this.D, null, this);
    }
}

