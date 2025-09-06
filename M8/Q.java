package m8;

import A8.l;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.L0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.DialogClose;
import com.iloen.melon.utils.Navigator;
import ie.H;
import k8.Y;
import k8.b;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import mb.f;
import mb.k;
import mb.o;
import ne.a;
import oe.i;
import va.e0;
import va.h0;
import va.i0;
import va.u1;
import we.n;

public final class q extends i implements n {
    public Object B;
    public f D;
    public BaseActivity E;
    public int G;
    public int I;
    public int M;
    public final BaseActivity N;
    public final String S;
    public final o T;
    public final k V;
    public final f W;
    public L0 r;
    public String w;

    public q(BaseActivity baseActivity0, String s, o o0, k k0, f f0, Continuation continuation0) {
        this.N = baseActivity0;
        this.S = s;
        this.T = o0;
        this.V = k0;
        this.W = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.N, this.S, this.T, this.V, this.W, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        BaseActivity baseActivity9;
        Object object2;
        l l2;
        BaseActivity baseActivity8;
        k k5;
        BaseActivity baseActivity6;
        f f5;
        int v6;
        BaseActivity baseActivity5;
        Object object1;
        f f4;
        BaseActivity baseActivity4;
        k k3;
        BaseActivity baseActivity1;
        int v1;
        int v;
        String s2;
        int v3;
        L0 l01;
        f f1;
        k k1;
        int v2;
        String s1;
        L0 l00;
        int v5;
        int v4;
        BaseActivity baseActivity2;
        f f0;
        k k0;
        BaseActivity baseActivity0;
        a a0 = a.a;
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                baseActivity0 = this.N;
                k8.a a1 = baseActivity0.getBlockingProgressDialogManage();
                u1 u10 = this.T.a;
                String s = this.S;
                k0 = this.V;
                f0 = this.W;
                if(a1 != null) {
                    ((b)a1).a("Kakao.kt true", true);
                    if(s == null) {
                        baseActivity2 = baseActivity0;
                        f1 = f0;
                        l01 = a1;
                        v4 = 0;
                        s1 = "Kakao.kt";
                        v5 = 0;
                        goto label_145;
                    }
                    else {
                        try {
                            this.r = a1;
                            this.w = "Kakao.kt";
                            this.B = k0;
                            this.D = f0;
                            this.E = baseActivity0;
                            this.G = 0;
                            this.I = 0;
                            this.M = 5;
                            if(u10.a.d(s, this) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            l00 = a1;
                            s1 = "Kakao.kt";
                            Y.v(s1, " false", l00, false);
                            throw throwable0;
                        }
                        v2 = 0;
                        k1 = k0;
                        f1 = f0;
                        l01 = a1;
                        v3 = 0;
                        s2 = "Kakao.kt";
                        goto label_140;
                    }
                }
                else if(s != null) {
                    this.r = null;
                    this.w = null;
                    this.B = k0;
                    this.D = f0;
                    this.E = baseActivity0;
                    this.G = 0;
                    this.I = 0;
                    this.M = 1;
                    if(u10.a.d(s, this) == a0) {
                        return a0;
                    }
                    v = 0;
                    v1 = 0;
                    baseActivity1 = baseActivity0;
                    goto label_67;
                }
                else {
                    v = 0;
                    v1 = 0;
                    baseActivity1 = baseActivity0;
                    goto label_67;
                }
                break;
            }
            case 1: {
                v = this.I;
                v1 = this.G;
                baseActivity1 = this.E;
                f f2 = this.D;
                k k2 = (k)this.B;
                d5.n.D(object0);
                f0 = f2;
                k0 = k2;
            label_67:
                EventBusHelper.post(new DialogClose());
                this.r = null;
                this.w = null;
                this.B = k0;
                this.D = f0;
                this.E = baseActivity1;
                this.G = v1;
                this.I = v;
                this.M = 2;
                if(((e0)k0).z("Kakao integration", false, this) == a0) {
                    return a0;
                }
                k3 = (e0)k0;
                goto label_88;
            }
            case 2: {
                v = this.I;
                v1 = this.G;
                BaseActivity baseActivity3 = this.E;
                f f3 = this.D;
                k k4 = (k)this.B;
                d5.n.D(object0);
                baseActivity1 = baseActivity3;
                k3 = k4;
                f0 = f3;
            label_88:
                this.r = null;
                this.w = null;
                this.B = k3;
                this.D = f0;
                this.E = baseActivity1;
                this.G = v1;
                this.I = v;
                this.M = 3;
                if(DelayKt.delay(5000L, this) == a0) {
                    return a0;
                }
                baseActivity4 = baseActivity1;
                f4 = f0;
                goto label_106;
            }
            case 3: {
                v = this.I;
                v1 = this.G;
                baseActivity4 = this.E;
                f4 = this.D;
                k3 = (k)this.B;
                d5.n.D(object0);
            label_106:
                l l0 = f4.a.c();
                if(l0 != null) {
                    this.r = null;
                    this.w = null;
                    this.B = baseActivity4;
                    this.D = null;
                    this.E = null;
                    this.G = v1;
                    this.I = v;
                    this.M = 4;
                    object1 = k.b(k3, l0, this);
                    if(object1 == a0) {
                        return a0;
                    }
                    baseActivity5 = baseActivity4;
                    goto label_124;
                }
                break;
            }
            case 4: {
                l l1 = (l)this.D;
                baseActivity5 = (BaseActivity)this.B;
                d5.n.D(object0);
                object1 = object0;
            label_124:
                if(((i0)object1) instanceof h0) {
                    baseActivity5.goToHome();
                    Navigator.openMainMusicAndClearStack();
                    return H.a;
                }
                break;
            }
            case 5: {
                v3 = this.I;
                v2 = this.G;
                baseActivity0 = this.E;
                f1 = this.D;
                k1 = (k)this.B;
                s2 = this.w;
                l01 = this.r;
                try {
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    s1 = s2;
                    l00 = l01;
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            label_140:
                v4 = v2;
                baseActivity2 = baseActivity0;
                v5 = v3;
                s1 = s2;
                k0 = k1;
                try {
                label_145:
                    EventBusHelper.post(new DialogClose());
                    this.r = l01;
                    this.w = s1;
                    this.B = k0;
                    this.D = f1;
                    this.E = baseActivity2;
                    this.G = v4;
                    this.I = v5;
                    this.M = 6;
                    if(((e0)k0).z("Kakao integration", false, this) == a0) {
                        return a0;
                    }
                    v6 = v4;
                    f5 = f1;
                    baseActivity6 = baseActivity2;
                    k5 = (e0)k0;
                    goto label_178;
                }
                catch(Throwable throwable0) {
                    l00 = l01;
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 6: {
                int v7 = this.I;
                v6 = this.G;
                BaseActivity baseActivity7 = this.E;
                f5 = this.D;
                k k6 = (k)this.B;
                String s3 = this.w;
                L0 l02 = this.r;
                try {
                    s1 = s3;
                    d5.n.D(object0);
                    baseActivity6 = baseActivity7;
                    k5 = k6;
                    v5 = v7;
                    s1 = s3;
                    l01 = l02;
                }
                catch(Throwable throwable0) {
                    l00 = l02;
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_178:
                    this.r = l01;
                    this.w = s1;
                    this.B = k5;
                    this.D = f5;
                    this.E = baseActivity6;
                    this.G = v6;
                    this.I = v5;
                    this.M = 7;
                    if(DelayKt.delay(5000L, this) == a0) {
                        return a0;
                    }
                    baseActivity8 = baseActivity6;
                    l00 = l01;
                    l2 = f5.a.c();
                    goto label_210;
                }
                catch(Throwable throwable0) {
                }
                l00 = l01;
                Y.v(s1, " false", l00, false);
                throw throwable0;
            }
            case 7: {
                int v8 = this.I;
                int v9 = this.G;
                baseActivity8 = this.E;
                f f6 = this.D;
                k5 = (k)this.B;
                String s4 = this.w;
                L0 l03 = this.r;
                try {
                    s1 = s4;
                    l00 = l03;
                    d5.n.D(object0);
                    v5 = v8;
                    s1 = s4;
                    v6 = v9;
                    l00 = l03;
                    l2 = f6.a.c();
                label_210:
                    if(l2 != null) {
                        this.r = l00;
                        this.w = s1;
                        this.B = baseActivity8;
                        this.D = null;
                        this.E = null;
                        this.G = v6;
                        this.I = v5;
                        this.M = 8;
                        object2 = k.b(k5, l2, this);
                        if(object2 == a0) {
                            return a0;
                        }
                        baseActivity9 = baseActivity8;
                        goto label_230;
                    }
                    goto label_237;
                }
                catch(Throwable throwable0) {
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 8: {
                l l3 = (l)this.D;
                baseActivity9 = (BaseActivity)this.B;
                s1 = this.w;
                l00 = this.r;
                try {
                    d5.n.D(object0);
                    object2 = object0;
                label_230:
                    if(((i0)object2) instanceof h0) {
                        baseActivity9.goToHome();
                        Navigator.openMainMusicAndClearStack();
                    }
                }
                catch(Throwable throwable0) {
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            label_237:
                Y.v(s1, " false", l00, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

