package l2;

import d5.n;
import java.io.Serializable;
import java.util.Iterator;
import oe.c;

public final class f extends c {
    public Object B;
    public int D;
    public Serializable r;
    public Iterator w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.D |= 0x80000000;
        return n.k(null, null, this);
    }
}

