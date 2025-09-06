package va;

import com.iloen.melon.net.v6x.response.InformMyProfileRes.RESPONSE;
import oe.c;

public final class h1 extends c {
    public final j1 B;
    public int D;
    public RESPONSE r;
    public Object w;

    public h1(j1 j10, c c0) {
        this.B = j10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.p(null, this);
    }
}

