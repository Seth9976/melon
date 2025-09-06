package gd;

import E9.h;
import Na.f;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.HttpResponse;
import com.melon.ui.t4;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;
import x9.b;

public final class o5 extends i implements n {
    public p5 B;
    public int D;
    public final p5 E;
    public final String G;
    public final boolean I;
    public L0 r;
    public String w;

    public o5(p5 p50, String s, boolean z, Continuation continuation0) {
        this.E = p50;
        this.G = s;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o5(this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o5)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s3;
        L0 l01;
        Object object2;
        Object object1;
        String s;
        p5 p50 = this.E;
        b b0 = p50.a;
        a a0 = a.a;
        i5 i50 = i5.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                L0 l00 = p50.getProgressUpdater();
                s = "MelonDjSubscriptionFailViewModel";
                String s1 = "N";
                String s2 = this.G;
                boolean z = this.I;
                if(l00 == null) {
                    if(z) {
                        s1 = "Y";
                    }
                    this.r = null;
                    this.w = null;
                    this.B = p50;
                    this.D = 1;
                    object1 = b0.t(s2, s1, this);
                    if(object1 == a0) {
                        return a0;
                    }
                    goto label_41;
                }
                else {
                    l00.a("MelonDjSubscriptionFailViewModel true", true);
                    if(z) {
                        s1 = "Y";
                    }
                    try {
                        this.r = l00;
                        this.w = "MelonDjSubscriptionFailViewModel";
                        this.B = p50;
                        this.D = 2;
                        object2 = b0.t(s2, s1, this);
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        s3 = s;
                        Y.v(s3, " false", l01, false);
                        throw throwable0;
                    }
                    if(object2 == a0) {
                        return a0;
                    }
                    l01 = l00;
                    goto label_54;
                }
                break;
            }
            case 1: {
                p50 = this.B;
                d5.n.D(object0);
                object1 = object0;
            label_41:
                if(((HttpResponse)h.H(((f)object1))) != null) {
                    p50.sendUiEvent(new t4(p50.b.a(0x7F130663)));  // string:melondj_subscription_result_initialization_msg "신청 결과가 확인되어 신청 내용이 초기화되었습니다."
                    p50.sendUiEvent(i50);
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    p50 = this.B;
                    s3 = this.w;
                    l01 = this.r;
                    d5.n.D(object0);
                    s = s3;
                    object2 = object0;
                }
                catch(Throwable throwable0) {
                    Y.v(s3, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_54:
                    if(((HttpResponse)h.H(((f)object2))) != null) {
                        p50.sendUiEvent(new t4(p50.b.a(0x7F130663)));  // string:melondj_subscription_result_initialization_msg "신청 결과가 확인되어 신청 내용이 초기화되었습니다."
                        p50.sendUiEvent(i50);
                    }
                }
                catch(Throwable throwable0) {
                    s3 = s;
                    Y.v(s3, " false", l01, false);
                    throw throwable0;
                }
                Y.v(s, " false", l01, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

