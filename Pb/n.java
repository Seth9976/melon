package pb;

import java.util.ArrayList;
import oc.w;
import oe.c;

public final class n extends c {
    public Object B;
    public final q D;
    public int E;
    public w r;
    public ArrayList w;

    public n(q q0, c c0) {
        this.D = q0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(null, this);
    }
}

