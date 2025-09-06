package gd;

import com.iloen.melon.userstore.VolatileDatabase_Impl;
import d5.v;
import ie.H;
import java.util.List;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import sd.j;
import we.n;
import x9.c;

public final class y7 extends i implements n {
    public int r;
    public final O7 w;

    public y7(O7 o70, Continuation continuation0) {
        this.w = o70;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y7(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y7)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                c c0 = ((ha.a)((v)this.w.b.a).b).a;
                if(c0 == null) {
                    list0 = w.a;
                }
                else {
                    list0 = (List)E9.w.N(((VolatileDatabase_Impl)c0.b), true, false, new j(20));
                    if(list0 == null) {
                        list0 = w.a;
                    }
                }
                return list0 == a0 ? a0 : list0;
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

