package v1;

import Q0.t0;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final m B;
    public int r;
    public Object w;

    public e(m m0, Continuation continuation0) {
        this.B = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                coroutineScope0 = (CoroutineScope)this.w;
                goto label_14;
            }
            case 1: {
                coroutineScope0 = (CoroutineScope)this.w;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            m m0 = this.B;
            int v = m0.V[0];
            int v1 = m0.V[1];
            m0.l.getLocationOnScreen(m0.V);
            if(v != m0.V[0] || v1 != m0.V[1]) {
                m0.k();
            }
        label_14:
            if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                return H.a;
            }
            d d0 = d.g;
            this.w = coroutineScope0;
            this.r = 1;
            if(this.getContext().get(t0.b) != null) {
                throw new ClassCastException();
            }
        }
        while(w.l(this.getContext()).c(d0, this) != a0);
        return a0;
    }
}

