package gd;

import hb.f;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m6 extends i implements n {
    public int r;
    public final n6 w;

    public m6(n6 n60, Continuation continuation0) {
        this.w = n60;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m6(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m6)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s2;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                f f0 = this.w.b;
                String s = this.w.g;
                String s1 = this.w.j;
                int v = this.w.h;
                switch(v) {
                    case 0: {
                        s2 = "POP";
                        break;
                    }
                    case 1: {
                        s2 = "REG";
                        break;
                    }
                    default: {
                        s2 = v == 2 ? "NEW" : "POP";
                    }
                }
                this.r = 1;
                Object object1 = f0.i(s, s1, 100, s2, this);
                return object1 == a0 ? a0 : object1;
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

