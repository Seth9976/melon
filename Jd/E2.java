package jd;

import Q.K;
import androidx.compose.runtime.b0;
import e.k;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e2 extends i implements n {
    public final K B;
    public final b0 D;
    public int r;
    public final q2 w;

    public e2(q2 q20, K k0, b0 b00, Continuation continuation0) {
        this.w = q20;
        this.B = k0;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e2(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                q2 q20 = this.w;
                int v = 0;
                int v1 = ((List)q20.b).isEmpty() ? 0 : ((List)q20.b).size() - 1;
                for(Object object1: ((Iterable)q20.b)) {
                    if(v >= 0) {
                        if(q.b(((jd.a)object1).a, q20.c)) {
                            v1 = v;
                        }
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                this.r = 1;
                if(K.t(this.B, v1, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.D.setValue(Boolean.FALSE);
        return H.a;
    }
}

