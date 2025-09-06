package Ac;

import com.melon.ui.k1;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class r3 extends i implements n {
    public final L3 r;

    public r3(L3 l30, Continuation continuation0) {
        this.r = l30;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r3(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((r3)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        k1.startFetch$default(this.r, true, null, "CommentListViewModel", 2, null);
        return H.a;
    }
}

