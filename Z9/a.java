package z9;

import java.util.ArrayList;
import java.util.Iterator;
import oe.c;

public final class a extends c {
    public Iterator B;
    public Object D;
    public final z9.c E;
    public int G;
    public String r;
    public ArrayList w;

    public a(z9.c c0, c c1) {
        this.E = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.g(null, null, this);
    }
}

