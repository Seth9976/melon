package eb;

import com.melon.ui.h0;
import oe.c;

public final class h extends c {
    public Object B;
    public final n D;
    public int E;
    public Q0.n r;
    public h0 w;

    public h(n n0, c c0) {
        this.D = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, null, null, null, this);
    }
}

