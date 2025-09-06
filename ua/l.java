package Ua;

import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import oe.c;

public final class l extends c {
    public int B;
    public int D;
    public int E;
    public Object G;
    public final n I;
    public int M;
    public n r;
    public LoadPgnRes w;

    public l(n n0, c c0) {
        this.I = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.d(null, null, this);
    }
}

