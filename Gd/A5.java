package gd;

import Pc.e;
import com.google.firebase.b;
import com.iloen.melon.types.StringIds;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import p8.f;
import we.n;

public final class a5 extends i implements n {
    public final d5 B;
    public int r;
    public final e w;

    public a5(e e0, d5 d50, Continuation continuation0) {
        this.w = e0;
        this.B = d50;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a5(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a5)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Flow flow1;
        a a0 = a.a;
        H h0 = H.a;
        e e0 = this.w;
        d5 d50 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                J4 j40 = ((U4)e0).a;
                if(StringIds.a(j40.a, StringIds.i)) {
                    String s = d50.getMenuId();
                    q.f("N10022", "code(...)");
                    Flow flow0 = H8.q.s(d50.d, !j40.g, "-1", s, "N10022", null, null, 0x30);
                    this.r = 1;
                    H h1 = flow0.collect(new c5(d50), this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 != a0) {
                        goto label_35;
                    }
                    return a0;
                }
                else {
                    String s1 = j40.a;
                    if(s1 != null) {
                        String s2 = d50.getMenuId();
                        this.r = 2;
                        flow1 = d50.e.a(s1, s2, !j40.g);
                        if(flow1 == a0) {
                            return a0;
                        }
                        goto label_29;
                    }
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                flow1 = object0;
            label_29:
                this.r = 3;
                H h2 = flow1.collect(new b5(d50, ((U4)e0).a.a), this);
                if(h2 != a0) {
                    h2 = h0;
                }
                if(h2 == a0) {
                    return a0;
                }
            label_35:
                f f0 = d50.e();
                if(f0 != null) {
                    b.O(f0, d50.d(), null, d50.b.a(0x7F130ED4), ActionKind.Like, null, ((U4)e0).b, null, null, null, ((U4)e0).a.c, null, !((U4)e0).a.g, d50.g, 1490);  // string:tiara_melon_dj_layer1_list "리스트"
                }
                break;
            }
            case 1: 
            case 3: {
                d5.n.D(object0);
                goto label_35;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

