package gd;

import com.iloen.melon.custom.S0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class l2 extends i implements n {
    public int r;
    public final n2 w;

    public l2(n2 n20, Continuation continuation0) {
        this.w = n20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l2(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                S0 s00 = this.w.a;
                String s = this.w.c;
                if(s != null) {
                    this.r = 1;
                    Object object1 = s00.R(s, this);
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

