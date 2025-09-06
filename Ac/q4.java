package Ac;

import com.iloen.melon.custom.L0;
import oe.c;

public final class q4 extends c {
    public Object B;
    public final r4 D;
    public int E;
    public L0 r;
    public String w;

    public q4(r4 r40, c c0) {
        this.D = r40;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.onFetchStart(null, this);
    }
}

