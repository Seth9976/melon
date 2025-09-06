package gd;

import Pc.e;
import com.iloen.melon.types.StringIds;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class r0 extends i implements n {
    public final u0 B;
    public int r;
    public final e w;

    public r0(e e0, u0 u00, Continuation continuation0) {
        this.w = e0;
        this.B = u00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Flow flow1;
        a a0 = a.a;
        H h0 = H.a;
        u0 u00 = this.B;
        e e0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                boolean z = ((n0)e0).c;
                String s = ((n0)e0).a;
                if(StringIds.a(s, StringIds.i)) {
                    String s1 = u00.getMenuId();
                    q.f("N10022", "code(...)");
                    Flow flow0 = H8.q.s(u00.c, !z, "-1", s1, "N10022", null, null, 0x30);
                    this.r = 1;
                    H h1 = flow0.collect(new t0(u00), this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 == a0) {
                        return a0;
                    }
                }
                else {
                    String s2 = u00.getMenuId();
                    this.r = 2;
                    flow1 = u00.d.a(s, s2, ((boolean)(true ^ z)));
                    if(flow1 == a0) {
                        return a0;
                    }
                    goto label_30;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            case 2: {
                d5.n.D(object0);
                flow1 = object0;
            label_30:
                this.r = 3;
                H h2 = flow1.collect(new s0(u00, ((n0)e0).a), this);
                if(h2 != a0) {
                    h2 = h0;
                }
                if(h2 == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

