package Ea;

import java.util.Iterator;
import kotlin.jvm.internal.F;
import oe.c;

public final class d extends c {
    public int B;
    public Object D;
    public final e E;
    public int G;
    public F r;
    public Iterator w;

    public d(e e0, c c0) {
        this.E = e0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.d(null, this);
    }
}

