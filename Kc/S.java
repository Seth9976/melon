package kc;

import com.melon.playlist.b;
import oe.c;

public final class s extends c {
    public int B;
    public Object D;
    public final b E;
    public int G;
    public b r;
    public int w;

    public s(b b0, c c0) {
        this.E = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.m(this);
    }
}

