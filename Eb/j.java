package eb;

import com.melon.net.res.common.ResponseBase;
import oe.c;

public final class j extends c {
    public Object B;
    public final n D;
    public int E;
    public String r;
    public ResponseBase w;

    public j(n n0, c c0) {
        this.D = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c(null, null, this);
    }
}

