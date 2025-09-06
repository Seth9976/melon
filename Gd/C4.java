package gd;

import Pc.b;
import hb.f;
import ie.H;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class c4 extends i implements n {
    public int r;
    public final f4 w;

    public c4(f4 f40, Continuation continuation0) {
        this.w = f40;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c4(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        f4 f40 = this.w;
        b b0 = f40.a;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                f f0 = f40.c;
                int v = p.P0(b0.a).isEmpty() ? 1 : p.P0(b0.a).size();
                int v1 = f40.h;
                String s = "POWERDJ";
                int v2 = f40.i;
                if(v1 == 0) {
                    s = "ALL";
                }
                switch(v2) {
                    case 0: {
                        s1 = "ALL".equals(s) ? "POP" : "UDT";
                        break;
                    }
                    case 1: {
                        s1 = "REG";
                        break;
                    }
                    default: {
                        s1 = v2 != 2 || !"ALL".equals(s) ? "POP" : "UDT";
                    }
                }
                this.r = 1;
                Object object1 = f0.f(v, 100, (v1 == 0 ? "ALL" : "POWERDJ"), s1, this);
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

