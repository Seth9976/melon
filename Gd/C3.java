package gd;

import Pc.e;
import com.google.firebase.b;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import p8.f;
import we.n;

public final class c3 extends i implements n {
    public final e B;
    public int r;
    public final e3 w;

    public c3(e3 e30, e e0, Continuation continuation0) {
        this.w = e30;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c3(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c3)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Flow flow0;
        a a0 = a.a;
        H h0 = H.a;
        e e0 = this.B;
        e3 e30 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = e30.getMenuId();
                this.r = 1;
                flow0 = e30.b.a((((Y2)e0).a.b == null ? "" : ((Y2)e0).a.b), s, !((Y2)e0).a.f);
                if(flow0 == a0) {
                    return a0;
                }
                goto label_14;
            }
            case 1: {
                d5.n.D(object0);
                flow0 = object0;
            label_14:
                this.r = 2;
                H h1 = flow0.collect(new d3(e30, ((Y2)e0).b, ((Y2)e0).a), this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                goto label_21;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
    label_21:
        f f0 = e30.e();
        if(f0 != null) {
            b.O(f0, e30.d(), null, e30.e.a(0x7F130ED7), ActionKind.Like, null, 0, null, null, null, ((Y2)e0).a.c, null, !((Y2)e0).a.f, ((Y2)e0).b, 0x5F2);  // string:tiara_melon_dj_layer1_power_dj "파워DJ"
        }
        return h0;
    }
}

