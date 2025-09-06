package gd;

import com.iloen.melon.custom.L0;
import oe.c;

public final class a3 extends c {
    public Object B;
    public final e3 D;
    public int E;
    public L0 r;
    public String w;

    public a3(e3 e30, c c0) {
        this.D = e30;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.onFetchStart(null, this);
    }
}

