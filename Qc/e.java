package qc;

import d5.n;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import sc.P0;
import sc.h;
import we.o;

public final class e extends i implements o {
    public int B;
    public final Object D;
    public Object E;
    public final int r;
    public int w;

    public e(Object object0, Continuation continuation0, int v) {
        this.r = v;
        this.D = object0;
        super(3, continuation0);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = ((Number)object0).intValue();
        switch(this.r) {
            case 0: {
                e e1 = new e(((n0)this.D), ((Continuation)object2), 0);
                e1.B = v;
                e1.E = (List)object1;
                return e1.invokeSuspend(H.a);
            }
            case 1: {
                e e2 = new e(((n0)this.D), ((Continuation)object2), 1);
                e2.B = v;
                e2.E = (String)object1;
                return e2.invokeSuspend(H.a);
            }
            case 2: {
                e e3 = new e(((P0)this.D), ((Continuation)object2), 2);
                e3.B = v;
                e3.E = (List)object1;
                return e3.invokeSuspend(H.a);
            }
            default: {
                e e0 = new e(((P0)this.D), ((Continuation)object2), 3);
                e0.B = v;
                e0.E = (String)object1;
                return e0.invokeSuspend(H.a);
            }
        }
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        switch(this.r) {
            case 0: {
                int v1 = this.B;
                List list0 = (List)this.E;
                a a1 = a.a;
                H h0 = H.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        this.E = null;
                        this.B = v1;
                        this.w = 1;
                        qc.i i0 = new qc.i(((n0)this.D), list0, v1, null);
                        H h1 = ((n0)this.D).Q(i0, this);
                        if(h1 != a1) {
                            h1 = h0;
                        }
                        if(h1 == a1) {
                            return a1;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h0;
            }
            case 1: {
                int v2 = this.B;
                String s1 = (String)this.E;
                a a2 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        this.E = null;
                        this.B = v2;
                        this.w = 1;
                        return ((n0)this.D).L(v2, 0L, false, s1, true, this) != a2 ? H.a : a2;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 2: {
                int v3 = this.B;
                List list1 = (List)this.E;
                a a3 = a.a;
                H h2 = H.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        this.E = null;
                        this.B = v3;
                        this.w = 1;
                        h h3 = new h(((P0)this.D), list1, v3, null);
                        H h4 = ((P0)this.D).e0(h3, this);
                        if(h4 != a3) {
                            h4 = h2;
                        }
                        if(h4 == a3) {
                            return a3;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h2;
            }
            default: {
                int v = this.B;
                String s = (String)this.E;
                a a0 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        this.E = null;
                        this.B = v;
                        this.w = 1;
                        return ((P0)this.D).W(v, 0L, false, s, true, this) != a0 ? H.a : a0;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }
    }
}

