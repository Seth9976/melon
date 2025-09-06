package gd;

import Cb.j;
import E9.h;
import Na.f;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v5x.response.DjThemeListLikeTagRes.RESPONSE;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.K4;
import h7.u0;
import hd.z1;
import ie.H;
import java.util.List;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class y8 extends i implements n {
    public D8 B;
    public int D;
    public final D8 E;
    public L0 r;
    public String w;

    public y8(D8 d80, Continuation continuation0) {
        this.E = d80;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y8(this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y8)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D8 d82;
        String s;
        L0 l01;
        Object object2;
        D8 d81;
        a a0 = a.a;
        RESPONSE djThemeListLikeTagRes$RESPONSE0 = null;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                D8 d80 = this.E;
                L0 l00 = d80.getProgressUpdater();
                if(l00 == null) {
                    Deferred[] arr_deferred = {u0.j(d80, Dispatchers.getIO(), new x8(d80, null), 2), u0.j(d80, Dispatchers.getIO(), new w8(d80, null), 2)};
                    this.r = null;
                    this.w = null;
                    this.B = d80;
                    this.D = 1;
                    Object object1 = AwaitKt.awaitAll(arr_deferred, this);
                    if(object1 == a0) {
                        return a0;
                    }
                    d81 = d80;
                    object0 = object1;
                    goto label_39;
                }
                else {
                    l00.a("MelonDjThemeGenreViewModel true", true);
                    try {
                        Deferred[] arr_deferred1 = {u0.j(d80, Dispatchers.getIO(), new x8(d80, null), 2), u0.j(d80, Dispatchers.getIO(), new w8(d80, null), 2)};
                        this.r = l00;
                        this.w = "MelonDjThemeGenreViewModel";
                        this.B = d80;
                        this.D = 2;
                        object2 = AwaitKt.awaitAll(arr_deferred1, this);
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        s = "MelonDjThemeGenreViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable0;
                    }
                    if(object2 == a0) {
                        return a0;
                    }
                    d82 = d80;
                    object0 = object2;
                    l01 = l00;
                    s = "MelonDjThemeGenreViewModel";
                    goto label_57;
                }
                break;
            }
            case 1: {
                d81 = this.B;
                d5.n.D(object0);
            label_39:
                f f0 = (f)((List)object0).get(0);
                f f1 = (f)((List)object0).get(1);
                kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                HttpResponse httpResponse0 = (HttpResponse)h.H(f0);
                if(httpResponse0 != null) {
                    ResponseBase responseBase0 = httpResponse0.getResponse();
                    if(responseBase0 instanceof RESPONSE) {
                        djThemeListLikeTagRes$RESPONSE0 = (RESPONSE)responseBase0;
                    }
                    h0.a = djThemeListLikeTagRes$RESPONSE0;
                    j.b(httpResponse0.notification, false, 3);
                }
                K4 k40 = d81.handleDefaultHttpResponseResult(f1, new R7(3, h0, d81));
                if(k40 != null) {
                    d81.updateUiState(new z1(k40, 10));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    d82 = this.B;
                    s = this.w;
                    l01 = this.r;
                    d5.n.D(object0);
                label_57:
                    f f2 = (f)((List)object0).get(0);
                    f f3 = (f)((List)object0).get(1);
                    kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    HttpResponse httpResponse1 = (HttpResponse)h.H(f2);
                    if(httpResponse1 != null) {
                        ResponseBase responseBase1 = httpResponse1.getResponse();
                        if(responseBase1 instanceof RESPONSE) {
                            djThemeListLikeTagRes$RESPONSE0 = (RESPONSE)responseBase1;
                        }
                        h1.a = djThemeListLikeTagRes$RESPONSE0;
                        j.b(httpResponse1.notification, false, 3);
                    }
                    K4 k41 = d82.handleDefaultHttpResponseResult(f3, new R7(3, h1, d82));
                    if(k41 != null) {
                        d82.updateUiState(new z1(k41, 10));
                    }
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l01, false);
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

