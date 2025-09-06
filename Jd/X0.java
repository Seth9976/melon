package jd;

import ie.H;
import kb.s;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class x0 extends i implements n {
    public int r;
    public final M0 w;

    public x0(M0 m00, Continuation continuation0) {
        this.w = m00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                M0 m00 = this.w;
                if(m00.j == m00.l) {
                    s s0 = m00.c;
                    String s1 = m00.g().f;
                    String s2 = "";
                    if(s1 == null) {
                        s1 = "";
                    }
                    String s3 = m00.g().a;
                    if(s3 != null) {
                        s2 = s3;
                    }
                    this.r = 1;
                    if(s0.n(s1, s2, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

