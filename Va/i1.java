package va;

import A8.q;
import com.iloen.melon.net.v4x.response.LoginLoginRes.Response;
import oe.c;

public final class i1 extends c {
    public Object B;
    public final j1 D;
    public int E;
    public q r;
    public Response w;

    public i1(j1 j10, c c0) {
        this.D = j10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return j1.b(this.D, null, this);
    }
}

