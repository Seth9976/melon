package gd;

import ea.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m1 extends i implements n {
    public int r;
    public final r1 w;

    public m1(r1 r10, Continuation continuation0) {
        this.w = r10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                b b0 = this.w.b;
                int v = this.w.a.b();
                String s = this.w.g;
                if(s != null) {
                    this.r = 1;
                    Object object1 = b0.h(v, 100, s, this);
                    return object1 == a0 ? a0 : object1;
                }
                q.m("brandDjKey");
                throw null;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

