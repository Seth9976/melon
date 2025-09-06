package l2;

import kotlinx.coroutines.CompletableDeferred;
import oe.c;

public final class v extends c {
    public CompletableDeferred B;
    public Object D;
    public final M E;
    public int G;
    public Object r;
    public M w;

    public v(M m0, c c0) {
        this.E = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return M.c(this.E, null, this);
    }
}

