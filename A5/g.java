package a5;

import Z4.i;
import b5.e;
import kotlin.jvm.internal.q;

public final class g extends c {
    public final int b;

    static {
        q.f("WM-NetworkNotRoamingCtr", "tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
    }

    public g(e e0) {
        q.g(e0, "tracker");
        super(e0);
        this.b = 7;
    }

    @Override  // a5.e
    public final boolean b(d5.q q0) {
        q.g(q0, "workSpec");
        return q0.j.a == 4;
    }

    @Override  // a5.c
    public final int d() {
        return this.b;
    }

    @Override  // a5.c
    public final boolean e(Object object0) {
        q.g(((i)object0), "value");
        return !((i)object0).a || !((i)object0).d;
    }
}

