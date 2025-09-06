package q2;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import l2.i;
import we.n;

public final class d implements i {
    public final i a;

    public d(i i0) {
        this.a = i0;
    }

    @Override  // l2.i
    public final Object a(n n0, Continuation continuation0) {
        c c0 = new c(n0, null);
        return this.a.a(c0, continuation0);
    }

    @Override  // l2.i
    public final Flow getData() {
        return this.a.getData();
    }
}

