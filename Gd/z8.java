package gd;

import Pc.e;
import android.content.Context;
import com.google.firebase.b;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import p8.g;
import we.n;

public final class z8 extends i implements n {
    public int B;
    public final e D;
    public final D8 E;
    public D8 r;
    public e w;

    public z8(e e0, D8 d80, Continuation continuation0) {
        this.D = e0;
        this.E = d80;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z8(this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z8)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D8 d81;
        e e1;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                e e0 = this.D;
                h8 h80 = ((n8)e0).a;
                String s = h80.a;
                if(s != null) {
                    D8 d80 = this.E;
                    String s1 = d80.getMenuId();
                    q.f("N10030", "code(...)");
                    Flow flow0 = H8.q.s(d80.b, !h80.e, s, s1, "N10030", null, null, 0x30);
                    this.r = d80;
                    this.w = e0;
                    this.B = 1;
                    H h1 = flow0.collect(new C8(d80, h80.b, h80.a), this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 == a0) {
                        return a0;
                    }
                    e1 = e0;
                    d81 = d80;
                    goto label_27;
                }
                break;
            }
            case 1: {
                e1 = this.w;
                d81 = this.r;
                d5.n.D(object0);
            label_27:
                g g0 = d81.d();
                StringProviderImpl stringProviderImpl0 = d81.d;
                if(g0 != null) {
                    Context context0 = d81.c();
                    String s2 = stringProviderImpl0.a(0x7F130ED9);  // string:tiara_melon_dj_layer1_recommend_tag "오늘의 추천 태그"
                    String s3 = stringProviderImpl0.a(0x7F130D41);  // string:tiara_click_copy_like "좋아요"
                    b.O(g0, context0, null, s2, ActionKind.Like, s3, 0, null, null, null, null, ((n8)e1).a.b, !((n8)e1).a.e, ((n8)e1).b + 1, 994);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

