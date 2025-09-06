package m1;

import Sf.m;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import je.u;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;

public final class n extends h implements we.n {
    public Object B;
    public final o D;
    public Iterator r;
    public int w;

    public n(o o0, Continuation continuation0) {
        this.D = o0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Iterator iterator1;
        m m1;
        a a0 = a.a;
        int v = this.w;
        o o0 = this.D;
        if(v != 0) {
            switch(v) {
                case 1: {
                    m m0 = (m)this.B;
                    d5.n.D(object0);
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object1: o0.c) {
                        u.T(arrayList0, ((o)object1).d);
                    }
                    m1 = m0;
                    iterator1 = arrayList0.iterator();
                    break;
                }
                case 2: {
                    iterator1 = this.r;
                    m1 = (m)this.B;
                    d5.n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            if(iterator1.hasNext()) {
                Object object2 = iterator1.next();
                this.B = m1;
                this.r = iterator1;
                this.w = 2;
                m1.a(((o)object2), this);
                return a0;
            }
            return H.a;
        }
        d5.n.D(object0);
        m m2 = (m)this.B;
        this.B = m2;
        this.w = 1;
        m2.a(o0, this);
        return a0;
    }
}

