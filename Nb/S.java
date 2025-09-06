package Nb;

import androidx.media3.session.b;
import oe.c;

public final class s extends c {
    public int B;
    public Object D;
    public final h0 E;
    public int G;
    public b[] r;
    public b[] w;

    public s(h0 h00, c c0) {
        this.E = h00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.d(this);
    }
}

