package kc;

import com.melon.playlist.b;
import oc.d;
import oe.c;

public final class w extends c {
    public Object B;
    public final b D;
    public int E;
    public Object r;
    public d w;

    public w(b b0, c c0) {
        this.D = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.o(this);
    }
}

