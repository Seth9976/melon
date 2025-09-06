package e5;

import V4.j;
import V4.s;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

public final class c extends r implements a {
    public final int f;
    public final s g;
    public final String h;

    public c(s s0, String s1) {
        this.f = 1;
        this.g = s0;
        this.h = s1;
        super(0);
    }

    public c(String s, s s1) {
        this.f = 0;
        this.h = s;
        this.g = s1;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            q.f(this.g.j, "workManagerImpl.workDatabase");
            b b0 = new b(this.g.j, this.h, this.g, 1);
            this.g.j.runInTransaction(b0);
            j.b(this.g.i, this.g.j, this.g.l);
            return H.a;
        }
        q.f(this.g.j, "workManagerImpl.workDatabase");
        b b1 = new b(this.g.j, this.h, this.g, 0);
        this.g.j.runInTransaction(b1);
        j.b(this.g.i, this.g.j, this.g.l);
        return H.a;
    }
}

