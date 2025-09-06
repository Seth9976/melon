package ad;

import Na.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ne.a;
import oe.i;
import we.n;

public final class b0 extends i implements n {
    public Deferred B;
    public Deferred D;
    public Deferred E;
    public q0 G;
    public int I;
    public Object M;
    public final q0 N;
    public Deferred r;
    public Deferred w;

    public b0(q0 q00, Continuation continuation0) {
        this.N = q00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b0(this.N, continuation0);
        continuation1.M = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Deferred deferred9;
        Deferred deferred8;
        Deferred deferred7;
        Deferred deferred6;
        q0 q01;
        Object object1;
        Deferred deferred5;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.M;
        a a0 = a.a;
        q0 q00 = this.N;
        switch(this.I) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new W(q00, null), 3, null);
                Deferred deferred1 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new Y(q00, null), 3, null);
                Deferred deferred2 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new Z(q00, null), 3, null);
                Deferred deferred3 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new X(q00, null), 3, null);
                Deferred deferred4 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new V(q00, null), 3, null);
                deferred5 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new a0(q00, null), 3, null);
                this.M = coroutineScope0;
                this.r = deferred1;
                this.w = deferred2;
                this.B = deferred3;
                this.D = deferred4;
                this.E = deferred5;
                this.G = q00;
                this.I = 1;
                object1 = deferred0.await(this);
                if(object1 == a0) {
                    return a0;
                }
                q01 = q00;
                deferred6 = deferred1;
                deferred7 = deferred2;
                deferred8 = deferred3;
                deferred9 = deferred4;
                break;
            }
            case 1: {
                q01 = this.G;
                deferred5 = this.E;
                Deferred deferred10 = this.D;
                Deferred deferred11 = this.B;
                deferred7 = this.w;
                Deferred deferred12 = this.r;
                d5.n.D(object0);
                deferred8 = deferred11;
                deferred6 = deferred12;
                deferred9 = deferred10;
                object1 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q01.handleDefaultHttpResponseResult(((b)object1), new T(q00, coroutineScope0, deferred6, deferred7, deferred8, deferred9, deferred5, 0));
        return H.a;
    }
}

