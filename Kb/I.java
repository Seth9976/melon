package kb;

import oe.c;

public final class i extends c {
    public s B;
    public String D;
    public int E;
    public int G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final s T;
    public int V;
    public String r;
    public String w;

    public i(s s0, c c0) {
        this.T = s0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.j(null, null, this);
    }
}

