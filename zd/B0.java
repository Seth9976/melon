package zd;

import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.utils.MelonSettingInfo;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import qb.I;
import we.n;

public final class b0 extends i implements n {
    public final Q B;
    public final M D;
    public final AddPosition E;
    public final M G;
    public int r;
    public final c0 w;

    public b0(c0 c00, Q q0, M m0, AddPosition addPosition0, M m1, Continuation continuation0) {
        this.w = c00;
        this.B = q0;
        this.D = m0;
        this.E = addPosition0;
        this.G = m1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        AddPosition addPosition0;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                c0 c00 = this.w;
                I i0 = c00.a;
                i0.getClass();
                Q q0 = this.B;
                q.g(q0, "popupType");
                q.g(this.D, "itemId");
                switch(this.D.ordinal()) {
                    case 99: {
                        addPosition0 = AddPosition.c;
                        break;
                    }
                    case 100: {
                        addPosition0 = AddPosition.d;
                        break;
                    }
                    default: {
                        addPosition0 = AddPosition.b;
                    }
                }
                switch(this.G.ordinal()) {
                    case 24: {
                        MelonSettingInfo.setPlayListAddPosition(addPosition0);
                        ((d3)i0.j).v(addPosition0);
                        break;
                    }
                    case 25: {
                        MelonSettingInfo.setNormalPlayListAddPosition(addPosition0);
                        break;
                    }
                    case 27: {
                        MelonSettingInfo.setDjPlayListAddPosition(addPosition0);
                    }
                }
                Flow flow0 = i0.b(q0);
                this.r = 1;
                H h1 = flow0.collect(new Z(c00), this);
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

