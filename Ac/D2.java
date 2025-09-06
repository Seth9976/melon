package Ac;

import com.melon.net.res.v3.CommentConfig;
import oe.c;

public final class d2 extends c {
    public final g2 B;
    public int D;
    public CommentConfig r;
    public Object w;

    public d2(g2 g20, c c0) {
        this.B = g20;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.h(this);
    }
}

