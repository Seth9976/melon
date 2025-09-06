package p8;

import com.iloen.melon.utils.log.LogU;
import ea.d;
import oe.c;

public final class v extends c {
    public final d B;
    public int D;
    public LogU r;
    public Object w;

    public v(d d0, c c0) {
        this.B = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.e(this);
    }
}

