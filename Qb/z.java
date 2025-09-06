package qb;

import com.iloen.melon.net.v6x.response.MyMusicPlaylistDeleteRes;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class z extends i implements n {
    public final I B;
    public final String D;
    public int r;
    public Object w;

    public z(I i0, String s, Continuation continuation0) {
        this.B = i0;
        this.D = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        FlowCollector flowCollector0 = (FlowCollector)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = u.w(((e0)this.B.h).j());
                this.w = flowCollector0;
                this.r = 1;
                object0 = this.B.f.c(this.D, s, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        p p0 = new p(((MyMusicPlaylistDeleteRes)object0).notification);
        this.w = null;
        this.r = 2;
        return flowCollector0.emit(p0, this) == a0 ? a0 : H.a;
    }
}

