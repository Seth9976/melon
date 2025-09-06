package gd;

import Na.f;
import com.melon.ui.K4;
import dd.z;
import hd.z1;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class n1 extends i implements n {
    public final r1 B;
    public int r;
    public Object w;

    public n1(r1 r10, Continuation continuation0) {
        this.B = r10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        r1 r10 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new m1(r10, null), 3, null);
                this.w = null;
                this.r = 1;
                object0 = deferred0.await(this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        K4 k40 = r10.handleDefaultHttpResponseResult(((f)object0), new z(r10, 16));
        if(k40 != null) {
            r10.updateUiState(new z1(k40, 10));
        }
        if(((e0)r10.e).m()) {
            String s = r10.j;
            if(s != null) {
                q.f("N10006", "code(...)");
                Flow flow0 = r10.c.g("N10006", s, "fan");
                this.w = null;
                this.r = 2;
                if(r1.c(r10, flow0, s, this) == a0) {
                    return a0;
                }
            }
        }
        return H.a;
    }
}

