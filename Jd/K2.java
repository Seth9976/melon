package jd;

import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class k2 extends i implements n {
    public final a0 r;
    public final q2 w;

    public k2(a0 a00, q2 q20, Continuation continuation0) {
        this.r = a00;
        this.w = q20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k2(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        K0 k00 = (K0)this.r;
        int v = k00.m();
        q2 q20 = this.w;
        if(v >= ((List)q20.b).size()) {
            k00.n(((List)q20.b).size() - 1);
        }
        return H.a;
    }
}

