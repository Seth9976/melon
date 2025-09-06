package z4;

import java.io.Serializable;
import oe.c;

public final class s extends c {
    public int B;
    public Object D;
    public final u E;
    public int G;
    public Object r;
    public Serializable w;

    public s(u u0, c c0) {
        this.E = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.g(null, null, this);
    }
}

