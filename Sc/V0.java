package sc;

import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.y0;
import oe.i;
import we.n;

public final class v0 extends i implements n {
    public final y0 B;
    public final boolean D;
    public final Object E;
    public int r;
    public final P0 w;

    public v0(P0 p00, y0 y00, boolean z, List list0, Continuation continuation0) {
        this.w = p00;
        this.B = y00;
        this.D = z;
        this.E = list0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v0(this.w, this.B, this.D, ((List)this.E), continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        P0 p00 = this.w;
        f1 f10 = p00.d;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                u0 u00 = new u0(p00, this.B, null);
                this.r = 1;
                object0 = p00.e0(u00, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(this.D) {
            f10.i(((g1)object0).e, "setSortType");
            Object object1 = this.E;
            if(!((Collection)object1).isEmpty()) {
                f10.g("setSortType-playCountUpdate", ((List)object1));
            }
        }
        return object0;
    }
}

