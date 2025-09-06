package Ua;

import com.melon.net.res.v3.CommentConfig;
import ie.p;
import ne.a;
import oe.c;

public final class y extends c {
    public final N B;
    public int D;
    public CommentConfig r;
    public Object w;

    public y(N n0, c c0) {
        this.B = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        Object object1 = this.B.e(0, null, 0, null, this);
        return object1 == a.a ? object1 : new p(object1);
    }
}

