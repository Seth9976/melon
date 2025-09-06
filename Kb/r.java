package kb;

import com.iloen.melon.utils.network.NetUtils;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import l2.M;
import l2.a0;
import ne.a;
import oe.i;
import we.o;

public final class r extends i implements o {
    public Object B;
    public final int r;
    public int w;

    public r(int v, int v1, Continuation continuation0) {
        this.r = v1;
        super(v, continuation0);
    }

    public r(M m0, Continuation continuation0) {
        this.r = 1;
        this.B = m0;
        super(3, continuation0);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.r) {
            case 0: {
                Throwable throwable0 = (Throwable)object1;
                r r1 = new r(3, 0, ((Continuation)object2));
                r1.B = (FlowCollector)object0;
                return r1.invokeSuspend(H.a);
            }
            case 1: {
                FlowCollector flowCollector0 = (FlowCollector)object0;
                Throwable throwable1 = (Throwable)object1;
                return new r(((M)this.B), ((Continuation)object2)).invokeSuspend(H.a);
            }
            default: {
                ((Boolean)object1).getClass();
                r r0 = new r(3, 2, ((Continuation)object2));
                r0.B = (a0)object0;
                return r0.invokeSuspend(H.a);
            }
        }
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        switch(this.r) {
            case 0: {
                FlowCollector flowCollector0 = (FlowCollector)this.B;
                a a1 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        if(!NetUtils.isConnected()) {
                            this.B = null;
                            this.w = 1;
                            return flowCollector0.emit(F.a, this) != a1 ? H.a : a1;
                        }
                        this.B = null;
                        this.w = 2;
                        return flowCollector0.emit(E.a, this) != a1 ? H.a : a1;
                    }
                    case 1: 
                    case 2: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 1: {
                a a2 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        this.w = 1;
                        return M.b(((M)this.B), this) != a2 ? H.a : a2;
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
            default: {
                a a0 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        this.w = 1;
                        object0 = ((a0)this.B).c(this);
                        return object0 == a0 ? a0 : object0;
                    }
                    case 1: {
                        n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }
    }
}

