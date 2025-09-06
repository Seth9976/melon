package bc;

import Nb.z0;
import b3.E;
import oe.c;

public final class b extends c {
    public Object B;
    public final bc.c D;
    public int E;
    public E r;
    public z0 w;

    public b(bc.c c0, c c1) {
        this.D = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, null, 0, this);
    }
}

