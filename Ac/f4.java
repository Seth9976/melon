package Ac;

import b9.d;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.JobKt;
import oe.i;
import we.n;

public final class f4 extends i implements n {
    public Object r;
    public final h4 w;

    public f4(h4 h40, Continuation continuation0) {
        this.w = h40;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f4(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((f4)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1 = this.r;
        d5.n.D(object0);
        JobKt.ensureActive(this.getContext());
        h4 h40 = this.w;
        LogU.debug$default(h40.d, "EventShareManager: " + ((y4)object1), null, false, 6, null);
        if(d.h == null) {
            d.h = new d();
        }
        d d0 = d.h;
        if(d0 != null) {
            d0.e = h40;
            d0.b(h40.i);
            return H.a;
        }
        q.m("mInstance");
        throw null;
    }
}

