package gd;

import java.util.ArrayList;
import oe.c;

public final class w7 extends c {
    public ArrayList B;
    public int D;
    public Object E;
    public final O7 G;
    public int I;
    public h7 r;
    public String w;

    public w7(O7 o70, c c0) {
        this.G = o70;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.c(null, null, null, 0, this);
    }
}

