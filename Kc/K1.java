package kc;

import com.melon.playlist.b;
import java.util.Iterator;
import oe.c;

public final class k1 extends c {
    public Object B;
    public final b D;
    public int E;
    public Iterator r;
    public int w;

    public k1(b b0, c c0) {
        this.D = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.j0(this);
    }
}

