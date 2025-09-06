package gd;

import Na.f;
import com.melon.ui.K4;
import dd.z;
import hd.z1;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ne.a;
import oe.i;
import we.n;

public final class x2 extends i implements n {
    public final y2 B;
    public int r;
    public Object w;

    public x2(y2 y20, Continuation continuation0) {
        this.B = y20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new x2(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        y2 y20 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new w2(y20, null), 3, null);
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
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        K4 k40 = y20.handleDefaultHttpResponseResult(((f)object0), new z(y20, 19));
        if(k40 != null) {
            y20.updateUiState(new z1(k40, 10));
        }
        return H.a;
    }
}

