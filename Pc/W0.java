package pc;

import Ac.F2;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.util.List;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.k;

public final class w0 extends i implements k {
    public final List B;
    public int r;
    public final y0 w;

    public w0(y0 y00, List list0, Continuation continuation0) {
        this.w = y00;
        this.B = list0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new w0(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((w0)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        y0 y00 = this.w;
        switch(this.r) {
            case 0: {
                n.D(object0);
                F2 f20 = new F2(FlowKt.catch(y00.e.getData(), new i0(1, null, y00)), 29);
                this.r = 1;
                object0 = FlowKt.first(f20, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return (List)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((c)object0) instanceof pc.a) {
            this.r = 2;
            object0 = y0.a(y00, this.B, this);
            return object0 == a0 ? a0 : ((List)object0);
        }
        LogU.error$default(y00.f, "takeNextRecommendSong: mixUpInfo is null", null, false, 6, null);
        return w.a;
    }
}

