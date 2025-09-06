package l2;

import com.google.firebase.messaging.u;
import oe.c;

public final class j extends c {
    public final u B;
    public int D;
    public u r;
    public Object w;

    public j(u u0, c c0) {
        this.B = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.e(this);
    }
}

