package lc;

import ie.p;
import java.util.ArrayList;
import ne.a;
import oe.c;

public final class e extends c {
    public ArrayList B;
    public int D;
    public int E;
    public Object G;
    public final g I;
    public int M;
    public g r;
    public b w;

    public e(g g0, c c0) {
        this.I = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        Object object1 = g.c(this.I, this);
        return object1 == a.a ? object1 : new p(object1);
    }
}

