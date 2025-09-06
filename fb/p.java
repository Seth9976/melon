package fb;

import com.iloen.melon.custom.S0;
import oe.c;

public final class p extends c {
    public int B;
    public Object r;
    public final S0 w;

    public p(S0 s00, c c0) {
        this.w = s00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.K(null, null, null, this);
    }
}

