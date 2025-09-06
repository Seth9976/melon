package gd;

import Cb.j;
import E9.h;
import Na.f;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.AppBanerListRes.RESPONSE;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.K4;
import com.melon.ui.f1;
import com.melon.ui.g1;
import hd.z1;
import ie.H;
import java.util.List;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class y6 extends i implements n {
    public C6 B;
    public int D;
    public int E;
    public int G;
    public Object I;
    public final C6 M;
    public final g1 N;
    public L0 r;
    public String w;

    public y6(C6 c60, g1 g10, Continuation continuation0) {
        this.M = c60;
        this.N = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y6(this.M, this.N, continuation0);
        continuation1.I = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y6)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        L0 l00;
        String s;
        Object object1;
        int v3;
        C6 c62;
        String s3;
        int v2;
        L0 l01;
        String s2;
        Object object2;
        int v7;
        C6 c64;
        int v6;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.I;
        a a0 = a.a;
        C6 c60 = this.M;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                l00 = c60.getProgressUpdater();
                s1 = "MelonDjTagHubTabViewModel";
                g1 g10 = this.N;
                if(l00 != null) {
                    l00.a("MelonDjTagHubTabViewModel true", true);
                    if(g10 instanceof f1) {
                        try {
                            s3 = "MelonDjTagHubTabViewModel";
                            Deferred[] arr_deferred1 = {BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getDefault(), null, new v6(c60, null), 2, null), BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getDefault(), null, new w6(c60, null), 2, null)};
                            this.I = null;
                            this.r = l00;
                            this.w = "MelonDjTagHubTabViewModel";
                            this.B = c60;
                            this.D = 0;
                            this.E = 0;
                            this.G = 3;
                            object1 = AwaitKt.awaitAll(arr_deferred1, this);
                            if(object1 == a0) {
                                return a0;
                            }
                            c62 = c60;
                            v3 = 0;
                            v2 = 0;
                        label_101:
                            f f2 = (f)((List)object1).get(0);
                            f f3 = (f)((List)object1).get(1);
                            kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            HttpResponse httpResponse1 = (HttpResponse)h.H(f2);
                            if(httpResponse1 != null) {
                                ResponseBase responseBase1 = httpResponse1.getResponse();
                                h1.a = responseBase1 instanceof RESPONSE ? ((RESPONSE)responseBase1) : null;
                                j.b(httpResponse1.notification, false, 3);
                            }
                            K4 k41 = c62.handleDefaultHttpResponseResult(f3, new l(27, h1, c62));
                            if(k41 != null) {
                                c62.updateUiState(new z1(k41, 10));
                            }
                            if(((e0)c62.d).m()) {
                                q.f("N10030", "code(...)");
                                Flow flow1 = c62.c.g("N10030", c62.g, "like");
                                this.I = null;
                                this.r = l00;
                                this.w = s3;
                                this.B = null;
                                this.D = v2;
                                this.E = v3;
                                this.G = 4;
                                if(C6.c(c62, flow1, this) != a0) {
                                    s1 = s3;
                                    goto label_132;
                                }
                                return a0;
                            }
                            else {
                                s1 = s3;
                            }
                            goto label_132;
                        }
                        catch(Throwable throwable0) {
                            s = s3;
                        }
                        Y.v(s, " false", l00, false);
                        throw throwable0;
                    }
                label_132:
                    Y.v(s1, " false", l00, false);
                }
                else if(g10 instanceof f1) {
                    Deferred[] arr_deferred = {BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getDefault(), null, new v6(c60, null), 2, null), BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getDefault(), null, new w6(c60, null), 2, null)};
                    this.I = null;
                    this.r = null;
                    this.w = null;
                    this.B = c60;
                    this.D = 0;
                    this.E = 0;
                    this.G = 1;
                    object2 = AwaitKt.awaitAll(arr_deferred, this);
                    if(object2 == a0) {
                        return a0;
                    }
                    c64 = c60;
                    v7 = 0;
                    v6 = 0;
                label_62:
                    f f0 = (f)((List)object2).get(0);
                    f f1 = (f)((List)object2).get(1);
                    kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    HttpResponse httpResponse0 = (HttpResponse)h.H(f0);
                    if(httpResponse0 != null) {
                        ResponseBase responseBase0 = httpResponse0.getResponse();
                        h0.a = responseBase0 instanceof RESPONSE ? ((RESPONSE)responseBase0) : null;
                        j.b(httpResponse0.notification, false, 3);
                    }
                    K4 k40 = c64.handleDefaultHttpResponseResult(f1, new l(27, h0, c64));
                    if(k40 != null) {
                        c64.updateUiState(new z1(k40, 10));
                    }
                    if(((e0)c64.d).m()) {
                        q.f("N10030", "code(...)");
                        Flow flow0 = c64.c.g("N10030", c64.g, "like");
                        this.I = null;
                        this.r = null;
                        this.w = null;
                        this.B = null;
                        this.D = v6;
                        this.E = v7;
                        this.G = 2;
                        if(C6.c(c64, flow0, this) == a0) {
                            return a0;
                        }
                    }
                }
                break;
            }
            case 1: {
                int v4 = this.E;
                int v5 = this.D;
                C6 c63 = this.B;
                d5.n.D(object0);
                v6 = v5;
                c64 = c63;
                v7 = v4;
                object2 = object0;
                goto label_62;
            }
            case 2: {
                Deferred deferred1 = (Deferred)this.B;
                d5.n.D(object0);
                break;
            }
            case 3: {
                try {
                    int v = this.E;
                    int v1 = this.D;
                    C6 c61 = this.B;
                    s2 = this.w;
                    l01 = this.r;
                    d5.n.D(object0);
                    v2 = v1;
                    l00 = l01;
                    s3 = s2;
                    c62 = c61;
                    v3 = v;
                    object1 = object0;
                    goto label_101;
                }
                catch(Throwable throwable0) {
                    s = s2;
                    l00 = l01;
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
            }
            case 4: {
                Deferred deferred0 = (Deferred)this.B;
                s = this.w;
                l00 = this.r;
                try {
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
                s1 = s;
                goto label_132;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((e0)c60.d).m()) {
            Job job0 = c60.j;
            if(job0 != null) {
                DefaultImpls.cancel$default(job0, null, 1, null);
            }
            c60.j = BuildersKt__Builders_commonKt.launch$default(f0.h(c60), Dispatchers.getDefault(), null, new x6(c60, null), 2, null);
        }
        return H.a;
    }
}

