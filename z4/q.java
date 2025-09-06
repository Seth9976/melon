package z4;

import androidx.room.S;
import oe.c;

public final class q extends c {
    public h B;
    public Object D;
    public final u E;
    public int G;
    public u r;
    public S w;

    public q(u u0, c c0) {
        this.E = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.e(null, this);
    }
}

