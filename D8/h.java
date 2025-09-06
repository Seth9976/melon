package D8;

import O.F;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class h extends i implements n {
    public final long B;
    public final F D;
    public int r;
    public Object w;

    public h(long v, F f0, Continuation continuation0) {
        this.B = v;
        this.D = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_11;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            F f0 = this.D;
            int v = f0.d.a();
            if(f0.h().n > v + 1) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new g(f0, v, null), 3, null);
            }
        label_11:
            if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                break;
            }
            this.w = coroutineScope0;
            this.r = 1;
            if(DelayKt.delay-VtjQ1oo(this.B, this) != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

