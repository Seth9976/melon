package kd;

import J0.L;
import J0.o;
import J0.v;
import O.F;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.h;
import we.a;
import we.n;

public final class t extends h implements n {
    public final F B;
    public final b0 D;
    public final a E;
    public int r;
    public Object w;

    public t(F f0, b0 b00, a a0, Continuation continuation0) {
        this.B = f0;
        this.D = b00;
        this.E = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return ne.a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        L l0 = (L)this.w;
        ne.a a0 = ne.a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_17;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            for(Object object1: ((Iterable)((J0.n)object0).a)) {
                v v0 = (v)object1;
                if(!v0.d && v0.h && !v0.b() && !this.B.h.b()) {
                    b0 b00 = this.D;
                    if(!((Boolean)b00.getValue()).booleanValue()) {
                        b00.setValue(Boolean.FALSE);
                        this.E.invoke();
                    }
                }
            }
        label_17:
            this.w = l0;
            this.r = 1;
            object0 = l0.a(o.a, this);
        }
        while(object0 != a0);
        return a0;
    }
}

