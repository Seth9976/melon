package pc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import oe.c;
import z9.F;

public final class q1 extends c {
    public Collection B;
    public Iterator D;
    public Object E;
    public boolean G;
    public int I;
    public int M;
    public Object N;
    public final w1 S;
    public int T;
    public List r;
    public F w;

    public q1(w1 w10, c c0) {
        this.S = w10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.N = object0;
        this.T |= 0x80000000;
        return this.S.a(null, this);
    }
}

