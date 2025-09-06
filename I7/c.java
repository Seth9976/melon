package I7;

import B3.K;
import Ba.P;
import Ba.S;
import J0.w;
import J0.x;
import Me.k;
import Me.t;
import Me.y;
import Na.d;
import Na.e;
import P0.E0;
import P0.f;
import Q0.N;
import Q0.a1;
import Qf.a;
import T4.n;
import Ua.h;
import aa.b;
import android.app.RecoverableSecurityException;
import android.os.Parcel;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.s;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.D;
import b3.I;
import b3.i;
import c2.B0;
import c2.v;
import c2.y0;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.iloen.melon.net.v4x.response.AppBanerListRes;
import com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes;
import com.iloen.melon.net.v4x.response.OneHourChartGraphRes;
import com.iloen.melon.net.v6x.response.BannerRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.MainMusicMiddleBannerRes;
import e1.u;
import e3.p;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import k8.Y;
import kotlin.jvm.internal.q;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import r1.m;
import va.e0;
import va.o;
import y0.G;
import y0.M;
import y0.Q;
import y0.g;

public class c implements F8.c, t, a1, a, n, v, OnCanceledListener, OnFailureListener, OnSuccessListener, e9.a, Q {
    public final int a;
    public Object b;

    public c(int v) {
        this.a = v;
        switch(v) {
            case 3: {
                super();
                this.b = new s(null);
                return;
            }
            case 15: {
                super();
                this.b = new E0(f.b);  // 初始化器: Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V
                return;
            }
            default: {
                super();
                this.b = new CountDownLatch(1);
            }
        }
    }

    public c(int v, boolean z) {
        this.a = v;
        super();
    }

    public c(S s0) {
        this.a = 7;
        q.g(s0, "service");
        super();
        this.b = s0;
    }

    public c(D d0) {
        this.a = 16;
        androidx.lifecycle.t t0 = d0.getLifecycle();
        super();
        this.b = t0;
    }

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public Object A(String s, String s1, oe.c c0) {
        Ta.a a0;
        if(c0 instanceof Ta.a) {
            a0 = (Ta.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Ta.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Ta.a(this, c0);
        }
        Serializable serializable0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    a0.B = 1;
                    serializable0 = ((b)this.b).a(s, s1, a0);
                    if(serializable0 == a1) {
                        return a1;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return new e(serializable0);
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object B(oe.c c0) {
        Sa.a a0;
        if(c0 instanceof Sa.a) {
            a0 = (Sa.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Sa.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Sa.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    a0.B = 1;
                    object0 = ((h)this.b).y(a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((FiveMinuteChartGraphRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object C(oe.c c0) {
        Qa.b b0;
        if(c0 instanceof Qa.b) {
            b0 = (Qa.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new Qa.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new Qa.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    b0.B = 1;
                    object0 = ((h)this.b).A(b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((MainMusicMiddleBannerRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object D(oe.c c0) {
        Qa.c c1;
        if(c0 instanceof Qa.c) {
            c1 = (Qa.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Qa.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Qa.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    c1.B = 1;
                    object0 = ((h)this.b).B(c1);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((BannerRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object E(oe.c c0) {
        Sa.b b0;
        if(c0 instanceof Sa.b) {
            b0 = (Sa.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new Sa.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new Sa.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    b0.B = 1;
                    object0 = ((h)this.b).C(b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((OneHourChartGraphRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object F(String s, String s1, String s2, String s3, String s4, oe.c c0) {
        Qa.d d0;
        if(c0 instanceof Qa.d) {
            d0 = (Qa.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new Qa.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new Qa.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    d0.B = 1;
                    object0 = ((h)this.b).H(s, s1, s2, s3, s4, "", String.valueOf(Math.random() * 10.0 + 1.0), d0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((AppBanerListRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object G(String s, String s1, oe.c c0) {
        Qa.e e0;
        if(c0 instanceof Qa.e) {
            e0 = (Qa.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new Qa.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new Qa.e(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    e0.B = 1;
                    object0 = ((h)this.b).I(s, s1, e0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((PromotionContentsBannerRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object H(String s, String s1, String s2, oe.c c0) {
        Ja.a a0;
        if(c0 instanceof Ja.a) {
            a0 = (Ja.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Ja.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Ja.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                d5.n.D(object0);
                a0.B = 1;
                object0 = ((P)((c)this.b).b).a(s, s1, s2, u.w(((e0)o.a()).j()), a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrNull(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrNull(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object I(String s, String s1, oe.c c0) {
        Ka.a a0;
        if(c0 instanceof Ka.a) {
            a0 = (Ka.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Ka.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Ka.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                d5.n.D(object0);
                a0.B = 1;
                object0 = ((S)((c)this.b).b).c(s, s1, a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object J(String s, oe.c c0) {
        Ka.b b0;
        if(c0 instanceof Ka.b) {
            b0 = (Ka.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new Ka.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new Ka.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                d5.n.D(object0);
                b0.B = 1;
                object0 = ((S)((c)this.b).b).a(s, b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object K(oe.c c0) {
        Qa.f f0;
        if(c0 instanceof Qa.f) {
            f0 = (Qa.f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new Qa.f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new Qa.f(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    f0.B = 1;
                    object0 = ((h)this.b).K(f0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return new e(((BannerRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object L(String s, String s1, oe.c c0) {
        Ka.c c1;
        if(c0 instanceof Ka.c) {
            c1 = (Ka.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Ka.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Ka.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                d5.n.D(object0);
                c1.B = 1;
                object0 = ((S)((c)this.b).b).b(s, s1, c1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public void M(int v, long v1) {
        T3.d d0 = (T3.d)this.b;
        switch(v) {
            case 0x5031: {
                if(v1 != 0L) {
                    throw I.a(null, "ContentEncodingOrder " + v1 + " not supported");
                }
                break;
            }
            case 20530: {
                if(v1 != 1L) {
                    throw I.a(null, "ContentEncodingScope " + v1 + " not supported");
                }
                break;
            }
            default: {
                boolean z = false;
                switch(v) {
                    case 0x83: {
                        d0.f(0x83);
                        d0.w.d = (int)v1;
                        return;
                    }
                    case 0x88: {
                        d0.f(0x88);
                        T3.c c0 = d0.w;
                        if(v1 == 1L) {
                            z = true;
                        }
                        c0.W = z;
                        return;
                    }
                    case 0x9B: {
                        d0.K = d0.k(v1);
                        return;
                    }
                    case 0x9F: {
                        d0.f(0x9F);
                        d0.w.P = (int)v1;
                        return;
                    }
                    case 0xB0: {
                        d0.f(0xB0);
                        d0.w.m = (int)v1;
                        return;
                    }
                    case 0xB3: {
                        d0.e(0xB3);
                        d0.E.c(d0.k(v1));
                        return;
                    }
                    case 0xBA: {
                        d0.f(0xBA);
                        d0.w.n = (int)v1;
                        return;
                    }
                    case 0xD7: {
                        d0.f(0xD7);
                        d0.w.c = (int)v1;
                        return;
                    }
                    case 0xE7: {
                        d0.D = d0.k(v1);
                        return;
                    }
                    case 0xEE: {
                        d0.R = (int)v1;
                        return;
                    }
                    case 0xF1: {
                        if(!d0.G) {
                            d0.e(0xF1);
                            d0.F.c(v1);
                            d0.G = true;
                            return;
                        }
                        break;
                    }
                    case 0xFB: {
                        d0.S = true;
                        return;
                    }
                    case 0x41E7: {
                        d0.f(0x41E7);
                        d0.w.g = (int)v1;
                        return;
                    }
                    case 16980: {
                        if(v1 != 3L) {
                            throw I.a(null, "ContentCompAlgo " + v1 + " not supported");
                        }
                        break;
                    }
                    case 17029: {
                        if(v1 < 1L || v1 > 2L) {
                            throw I.a(null, "DocTypeReadVersion " + v1 + " not supported");
                        }
                        break;
                    }
                    case 0x42F7: {
                        if(v1 != 1L) {
                            throw I.a(null, "EBMLReadVersion " + v1 + " not supported");
                        }
                        break;
                    }
                    case 18401: {
                        if(v1 != 5L) {
                            throw I.a(null, "ContentEncAlgo " + v1 + " not supported");
                        }
                        break;
                    }
                    case 18408: {
                        if(v1 != 1L) {
                            throw I.a(null, "AESSettingsCipherMode " + v1 + " not supported");
                        }
                        break;
                    }
                    case 21420: {
                        d0.z = v1 + d0.s;
                        return;
                    }
                    case 0x53B8: {
                        d0.f(0x53B8);
                        switch(((int)v1)) {
                            case 0: {
                                d0.w.x = 0;
                                return;
                            }
                            case 1: {
                                d0.w.x = 2;
                                return;
                            }
                            case 3: {
                                d0.w.x = 1;
                                return;
                            }
                        }
                        if(((int)v1) == 15) {
                            d0.w.x = 3;
                            return;
                        }
                        break;
                    }
                    case 0x54B0: {
                        d0.f(0x54B0);
                        d0.w.p = (int)v1;
                        return;
                    }
                    case 0x54B2: {
                        d0.f(0x54B2);
                        d0.w.r = (int)v1;
                        return;
                    }
                    case 21690: {
                        d0.f(21690);
                        d0.w.q = (int)v1;
                        return;
                    }
                    case 21930: {
                        d0.f(21930);
                        T3.c c1 = d0.w;
                        if(v1 == 1L) {
                            z = true;
                        }
                        c1.V = z;
                        return;
                    }
                    case 0x55B2: {
                        d0.f(0x55B2);
                        d0.w.y = true;
                        d0.w.o = (int)v1;
                        return;
                    }
                    case 0x55B9: {
                        d0.f(0x55B9);
                        switch(((int)v1)) {
                            case 1: {
                                d0.w.B = 2;
                                return;
                            }
                            case 2: {
                                d0.w.B = 1;
                                return;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                    case 0x55BA: {
                        d0.f(0x55BA);
                        int v2 = i.g(((int)v1));
                        if(v2 != -1) {
                            d0.w.A = v2;
                            return;
                        }
                        break;
                    }
                    case 0x55BB: {
                        d0.f(0x55BB);
                        d0.w.y = true;
                        int v3 = i.f(((int)v1));
                        if(v3 != -1) {
                            d0.w.z = v3;
                            return;
                        }
                        break;
                    }
                    case 0x55BC: {
                        d0.f(0x55BC);
                        d0.w.C = (int)v1;
                        return;
                    }
                    case 0x55BD: {
                        d0.f(0x55BD);
                        d0.w.D = (int)v1;
                        return;
                    }
                    case 0x55EE: {
                        d0.f(0x55EE);
                        d0.w.f = (int)v1;
                        return;
                    }
                    case 0x56AA: {
                        d0.f(0x56AA);
                        d0.w.S = v1;
                        return;
                    }
                    case 22203: {
                        d0.f(22203);
                        d0.w.T = v1;
                        return;
                    }
                    case 0x6264: {
                        d0.f(0x6264);
                        d0.w.Q = (int)v1;
                        return;
                    }
                    case 30114: {
                        d0.T = v1;
                        return;
                    }
                    case 30321: {
                        d0.f(30321);
                        switch(((int)v1)) {
                            case 0: {
                                d0.w.s = 0;
                                return;
                            }
                            case 1: {
                                d0.w.s = 1;
                                return;
                            }
                            case 2: {
                                d0.w.s = 2;
                                return;
                            }
                            case 3: {
                                d0.w.s = 3;
                                return;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                    case 2352003: {
                        d0.f(2352003);
                        d0.w.e = (int)v1;
                        return;
                    }
                    case 2807729: {
                        d0.t = v1;
                    }
                }
            }
        }
    }

    public J0.h N(x9.c c0, Q0.u u0) {
        boolean z;
        long v5;
        long v4;
        int v3;
        s s0 = (s)this.b;
        List list0 = (List)c0.b;
        s s1 = new s(list0.size());
        int v = list0.size();
        for(int v1 = 0; v1 < v; v1 = v3 + 1) {
            x x0 = (x)list0.get(v1);
            long v2 = x0.a;
            w w0 = (w)s0.b(v2);
            if(w0 == null) {
                v3 = v1;
                v4 = x0.b;
                v5 = x0.d;
                z = false;
            }
            else {
                v3 = v1;
                v5 = u0.H(w0.b);
                v4 = w0.a;
                z = w0.c;
            }
            J0.v v6 = new J0.v(x0.a, x0.b, x0.d, x0.e, x0.f, v4, v5, z, x0.g, x0.i, x0.j, x0.k);
            s1.f(x0.a, v6);
            if(x0.e) {
                s0.f(v2, new w(x0.b, x0.c, true));
            }
            else {
                s0.g(v2);
            }
        }
        return new J0.h(s1, c0);
    }

    public boolean O(P0.I i0) {
        if(!i0.H()) {
            M0.a.b("DepthSortedSet.remove called on an unattached node");
        }
        return ((E0)this.b).remove(i0);
    }

    public void P(int v) {
        ((WebSettingsBoundaryInterface)this.b).setForceDark(v);
    }

    public void Q() {
        ((WebSettingsBoundaryInterface)this.b).setForceDarkBehavior(1);
    }

    @Override  // Me.t
    public t a(List list0) {
        return this;
    }

    @Override  // Me.t
    public t b(k k0) {
        q.g(k0, "owner");
        return this;
    }

    @Override  // Me.t
    public Me.u build() {
        return (Jf.c)this.b;
    }

    @Override  // Me.t
    public t c(int v) {
        Y.r(v, "kind");
        return this;
    }

    @Override  // Me.t
    public t d() {
        return this;
    }

    @Override  // Me.t
    public t e(Ne.h h0) {
        q.g(h0, "additionalAnnotations");
        return this;
    }

    @Override  // Me.t
    public t f() {
        return this;
    }

    @Override  // Me.t
    public t g() {
        return this;
    }

    @Override  // T4.n
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        InvocationHandler invocationHandler0 = ((WebViewProviderFactoryBoundaryInterface)this.b).getDropDataProvider();
        return (DropDataContentProviderBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(DropDataContentProviderBoundaryInterface.class, invocationHandler0);
    }

    @Override  // T4.n
    public StaticsBoundaryInterface getStatics() {
        InvocationHandler invocationHandler0 = ((WebViewProviderFactoryBoundaryInterface)this.b).getStatics();
        return (StaticsBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(StaticsBoundaryInterface.class, invocationHandler0);
    }

    @Override  // T4.n
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        InvocationHandler invocationHandler0 = ((WebViewProviderFactoryBoundaryInterface)this.b).getWebkitToCompatConverter();
        return (WebkitToCompatConverterBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, invocationHandler0);
    }

    @Override  // Me.t
    public t h() {
        return this;
    }

    @Override  // y0.Q
    public M i(long v, m m0, r1.c c0) {
        return new G(((g)this.b));
    }

    @Override  // Qf.a
    public Iterable j(Object object0) {
        Le.o o0 = (Le.o)this.b;
        Collection collection0 = ((Me.e)object0).q().f();
        q.f(collection0, "getSupertypes(...)");
        Iterable iterable0 = new ArrayList();
        for(Object object1: collection0) {
            Me.h h0 = ((Hf.x)object1).w().e();
            Me.e e0 = null;
            Me.h h1 = h0 == null ? null : h0.a();
            Me.e e1 = h1 instanceof Me.e ? ((Me.e)h1) : null;
            if(e1 != null) {
                Me.e e2 = o0.f(e1);
                e0 = e2 == null ? e1 : e2;
            }
            if(e0 != null) {
                ((ArrayList)iterable0).add(e0);
            }
        }
        return iterable0;
    }

    @Override  // Me.t
    public t k(Me.o o0) {
        q.g(o0, "visibility");
        return this;
    }

    @Override  // Me.t
    public t l() {
        return this;
    }

    @Override  // Me.t
    public t m(y y0) {
        return this;
    }

    @Override  // Me.t
    public t n(Pe.u u0) {
        return this;
    }

    @Override  // Me.t
    public t o(qf.e e0) {
        q.g(e0, "name");
        return this;
    }

    @Override  // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        ((CountDownLatch)this.b).countDown();
    }

    @Override  // F8.c
    public boolean onEditDoneClick() {
        ((Qc.w)((Qc.f)this.b).getViewModel()).f(false);
        return false;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exception0) {
        ((CountDownLatch)this.b).countDown();
    }

    @Override  // e9.a
    public void onRemoveComplete(int v, Object object0) {
        Qc.w w0 = (Qc.w)this.b;
        w0.sendUiEvent(new Qc.n(w0.e));
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object object0) {
        ((CountDownLatch)this.b).countDown();
    }

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(RecoverableSecurityException recoverableSecurityException0) {
        q.g(recoverableSecurityException0, "exception");
        ((Qc.w)this.b).sendUiEvent(new Qc.m(recoverableSecurityException0));
    }

    @Override  // Me.t
    public t p() {
        return this;
    }

    @Override  // T4.n
    public String[] q() {
        return ((WebViewProviderFactoryBoundaryInterface)this.b).getSupportedFeatures();
    }

    @Override  // Me.t
    public t r(Hf.x x0) {
        q.g(x0, "type");
        return this;
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        y0 y00 = b00.a;
        CoordinatorLayout coordinatorLayout0 = (CoordinatorLayout)this.b;
        if(!Objects.equals(coordinatorLayout0.n, b00)) {
            coordinatorLayout0.n = b00;
            boolean z = true;
            boolean z1 = b00.d() > 0;
            coordinatorLayout0.o = z1;
            if(z1 || coordinatorLayout0.getBackground() != null) {
                z = false;
            }
            coordinatorLayout0.setWillNotDraw(z);
            if(!y00.o()) {
                int v1 = coordinatorLayout0.getChildCount();
                for(int v = 0; v < v1; ++v) {
                    View view1 = coordinatorLayout0.getChildAt(v);
                    if(view1.getFitsSystemWindows() && ((androidx.coordinatorlayout.widget.c)view1.getLayoutParams()).a != null && y00.o()) {
                        break;
                    }
                }
            }
            coordinatorLayout0.requestLayout();
        }
        return b00;
    }

    @Override  // Me.t
    public t t() {
        return this;
    }

    @Override
    public String toString() {
        return this.a == 15 ? ((E0)this.b).toString() : super.toString();
    }

    @Override  // Q0.a1
    public we.a u(AbstractComposeView abstractComposeView0) {
        return N.d(abstractComposeView0, ((androidx.lifecycle.t)this.b));
    }

    public void v(P0.I i0) {
        if(!i0.H()) {
            M0.a.b("DepthSortedSet.add called on an unattached node");
        }
        ((E0)this.b).add(i0);
    }

    public void w(int v, int v1, B3.s s0) {
        long v18;
        int v17;
        int v13;
        int v9;
        int v7;
        T3.d d0 = (T3.d)this.b;
        T3.f f0 = d0.b;
        SparseArray sparseArray0 = d0.c;
        p p0 = d0.k;
        p p1 = d0.i;
        if(v == 0xA1 || v == 0xA3) {
            if(d0.I == 0) {
                d0.O = (int)f0.b(s0, false, true, 8);
                d0.P = f0.c;
                d0.K = 0x8000000000000001L;
                d0.I = 1;
                p1.D(0);
            }
            Object object0 = sparseArray0.get(d0.O);
            if(((T3.c)object0) == null) {
                s0.skipFully(v1 - d0.P);
                d0.I = 0;
                return;
            }
            ((T3.c)object0).Y.getClass();
            if(d0.I == 1) {
                d0.i(s0, 3);
                int v2 = (p1.a[2] & 6) >> 1;
                if(v2 == 0) {
                    d0.M = 1;
                    int[] arr_v = d0.N;
                    if(arr_v == null) {
                        arr_v = new int[1];
                    }
                    else if(arr_v.length < 1) {
                        arr_v = new int[Math.max(arr_v.length * 2, 1)];
                    }
                    d0.N = arr_v;
                    arr_v[0] = v1 - d0.P - 3;
                    goto label_157;
                }
                else {
                    d0.i(s0, 4);
                    int v3 = (p1.a[3] & 0xFF) + 1;
                    d0.M = v3;
                    int[] arr_v1 = d0.N;
                    if(arr_v1 == null) {
                        arr_v1 = new int[v3];
                    }
                    else if(arr_v1.length < v3) {
                        arr_v1 = new int[Math.max(arr_v1.length * 2, v3)];
                    }
                    d0.N = arr_v1;
                    if(v2 == 2) {
                        Arrays.fill(arr_v1, 0, d0.M, (v1 - d0.P - 4) / d0.M);
                        goto label_157;
                    }
                    else if(v2 == 1) {
                        int v4 = 0;
                        int v5 = 0;
                        int v6;
                        for(v6 = 4; true; ++v6) {
                            v7 = d0.M - 1;
                            if(v4 >= v7) {
                                break;
                            }
                            d0.N[v4] = 0;
                            while(true) {
                                d0.i(s0, v6 + 1);
                                int v8 = p1.a[v6] & 0xFF;
                                int[] arr_v2 = d0.N;
                                v9 = arr_v2[v4] + v8;
                                arr_v2[v4] = v9;
                                if(v8 != 0xFF) {
                                    break;
                                }
                                ++v6;
                            }
                            v5 += v9;
                            ++v4;
                        }
                        d0.N[v7] = v1 - d0.P - v6 - v5;
                        goto label_157;
                    }
                    else {
                        if(v2 != 3) {
                            throw I.a(null, "Unexpected lacing value: " + v2);
                        }
                        int v10 = 0;
                        int v11 = 0;
                        int v12 = 4;
                        while(true) {
                            v13 = d0.M - 1;
                            if(v10 >= v13) {
                                goto label_156;
                            }
                            d0.N[v10] = 0;
                            int v14 = v12 + 1;
                            d0.i(s0, v14);
                            if(p1.a[v12] == 0) {
                                throw I.a(null, "No valid varint length mask found");
                            }
                            int v15 = 0;
                            while(true) {
                                if(v15 < 8) {
                                    int v16 = 1 << 7 - v15;
                                    if((p1.a[v12] & v16) == 0) {
                                        ++v15;
                                        continue;
                                    }
                                    else {
                                        v17 = v14 + v15;
                                        d0.i(s0, v17);
                                        v18 = (long)(p1.a[v12] & 0xFF & ~v16);
                                        while(v14 < v17) {
                                            v18 = v18 << 8 | ((long)(p1.a[v14] & 0xFF));
                                            ++v14;
                                        }
                                        if(v10 > 0) {
                                            v18 -= (1L << v15 * 7 + 6) - 1L;
                                        }
                                        break;
                                    }
                                }
                                v18 = 0L;
                                v17 = v14;
                                break;
                            }
                            if(v18 < 0xFFFFFFFF80000000L || v18 > 0x7FFFFFFFL) {
                                break;
                            }
                            int v19 = (int)v18;
                            int[] arr_v3 = d0.N;
                            if(v10 != 0) {
                                v19 += arr_v3[v10 - 1];
                            }
                            arr_v3[v10] = v19;
                            v11 += v19;
                            ++v10;
                            v12 = v17;
                        }
                        throw I.a(null, "EBML lacing sample size out of range.");
                    label_156:
                        d0.N[v13] = v1 - d0.P - v12 - v11;
                    label_157:
                        long v20 = d0.D;
                        d0.J = d0.k(((long)(p1.a[1] & 0xFF | p1.a[0] << 8))) + v20;
                        d0.Q = ((T3.c)object0).d == 2 || v == 0xA3 && (p1.a[2] & 0x80) == 0x80 ? 1 : 0;
                        d0.I = 2;
                        d0.L = 0;
                    }
                }
            }
            if(v == 0xA3) {
                int v21;
                while((v21 = d0.L) < d0.M) {
                    int v22 = d0.l(s0, ((T3.c)object0), d0.N[v21], false);
                    d0.g(((T3.c)object0), ((long)(d0.L * ((T3.c)object0).e / 1000)) + d0.J, d0.Q, v22, 0);
                    ++d0.L;
                }
                d0.I = 0;
                return;
            }
            int v23;
            while((v23 = d0.L) < d0.M) {
                int[] arr_v4 = d0.N;
                arr_v4[v23] = d0.l(s0, ((T3.c)object0), arr_v4[v23], ((boolean)1));
                ++d0.L;
            }
        }
        else {
            switch(v) {
                case 0xA5: {
                    goto label_46;
                }
                case 0x41ED: {
                    goto label_37;
                }
                case 0x4255: {
                    goto label_31;
                }
                case 18402: {
                    goto label_25;
                }
                case 0x53AB: {
                    goto label_20;
                }
                case 25506: {
                    goto label_14;
                }
                case 30322: {
                    goto label_8;
                }
            }
            throw I.a(null, "Unexpected id: " + v);
        label_8:
            d0.f(30322);
            T3.c c0 = d0.w;
            byte[] arr_b = new byte[v1];
            c0.w = arr_b;
            s0.readFully(arr_b, 0, v1);
            return;
        label_14:
            d0.f(25506);
            T3.c c1 = d0.w;
            byte[] arr_b1 = new byte[v1];
            c1.k = arr_b1;
            s0.readFully(arr_b1, 0, v1);
            return;
        label_20:
            Arrays.fill(p0.a, 0);
            s0.readFully(p0.a, 4 - v1, v1);
            p0.G(0);
            d0.y = (int)p0.w();
            return;
        label_25:
            byte[] arr_b2 = new byte[v1];
            s0.readFully(arr_b2, 0, v1);
            d0.f(18402);
            T3.c c2 = d0.w;
            c2.j = new K(1, arr_b2, 0, 0);
            return;
        label_31:
            d0.f(0x4255);
            T3.c c3 = d0.w;
            byte[] arr_b3 = new byte[v1];
            c3.i = arr_b3;
            s0.readFully(arr_b3, 0, v1);
            return;
        label_37:
            d0.f(0x41ED);
            T3.c c4 = d0.w;
            if(c4.g != 1685480259 && c4.g != 0x64767643) {
                s0.skipFully(v1);
                return;
            }
            byte[] arr_b4 = new byte[v1];
            c4.O = arr_b4;
            s0.readFully(arr_b4, 0, v1);
            return;
        label_46:
            if(d0.I == 2) {
                T3.c c5 = (T3.c)sparseArray0.get(d0.O);
                p p2 = d0.p;
                if(d0.R == 4 && "V_VP9".equals(c5.b)) {
                    p2.D(v1);
                    s0.readFully(p2.a, 0, v1);
                    return;
                }
                s0.skipFully(v1);
            }
        }
    }

    public void x(byte b) {
        ((Parcel)this.b).writeByte(b);
    }

    public void y(float f) {
        ((Parcel)this.b).writeFloat(f);
    }

    public void z(long v) {
        long v1 = r1.o.b(v);
        int v2 = 0;
        if(!r1.p.a(v1, 0L)) {
            if(r1.p.a(v1, 0x100000000L)) {
                v2 = 1;
            }
            else if(r1.p.a(v1, 0x200000000L)) {
                v2 = 2;
            }
        }
        this.x(((byte)v2));
        if(!r1.p.a(r1.o.b(v), 0L)) {
            this.y(r1.o.c(v));
        }
    }
}

