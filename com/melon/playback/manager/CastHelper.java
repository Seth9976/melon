package com.melon.playback.manager;

import Cb.i;
import Tf.o;
import Ub.d;
import Ub.f;
import Ub.g;
import Ub.h;
import Ub.j;
import Ub.l;
import Ub.r;
import Ub.t;
import Vd.w;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import b3.k;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.GooglePlayServiceUtils;
import d5.n;
import ic.b;
import ie.H;
import ie.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import l4.G;
import l4.O;
import l4.Q;
import org.jetbrains.annotations.NotNull;
import va.e;
import we.a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0007\b\tB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/melon/playback/manager/CastHelper;", "LUb/r;", "Lic/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Ua/h", "Ub/f", "Ub/g", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CastHelper implements r {
    public final Context a;
    public final LogU b;
    public final CoroutineDispatcher c;
    public final MainCoroutineDispatcher d;
    public final l e;
    public String f;
    public final AtomicReference g;
    public final Q h;
    public final G i;
    public final k j;
    public final h k;
    public final Ua.h l;
    public final f m;
    public final g n;
    public WeakReference o;
    public t p;

    @Inject
    public CastHelper(@NotNull Context context0) {
        q.g(context0, "context");
        H h0;
        super();
        this.a = context0;
        this.b = Companion.create$default(LogU.Companion, "CastHelper", false, Category.Playback, 2, null);
        this.c = Dispatchers.getIO();
        this.d = Dispatchers.getMain();
        this.e = new l(CoroutineExceptionHandler.Key, this);
        this.f = "";
        this.g = new AtomicReference();
        this.h = Q.d(context0);
        ArrayList arrayList0 = new ArrayList();
        if(!arrayList0.contains("com.google.android.gms.cast.CATEGORY_CAST/D109AB2A///ALLOW_IPV6")) {
            arrayList0.add("com.google.android.gms.cast.CATEGORY_CAST/D109AB2A///ALLOW_IPV6");
        }
        Bundle bundle0 = new Bundle();
        bundle0.putStringArrayList("controlCategories", arrayList0);
        this.i = new G(bundle0, arrayList0);
        this.j = new w(1).e();
        this.k = new h(this, context0);
        this.l = new Ua.h(this);
        this.m = new f(this);
        this.n = new g(this);
        try {
            if(GooglePlayServiceUtils.isEnable(context0)) {
                CastContext castContext0 = CastContext.getSharedInstance(context0);
                q.d(castContext0);
                this.e(castContext0);
            }
            h0 = H.a;
        }
        catch(Throwable throwable0) {
            h0 = n.t(throwable0);
        }
        Throwable throwable1 = p.a(h0);
        if(throwable1 != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.c.plus(this.e)), null, null, new Ub.k(this, throwable1, null), 3, null);
            LogU.error$default(this.b, e.b("CastHelper init error: ", throwable1.getMessage()), null, false, 6, null);
        }
    }

    @Override  // Ub.r
    public final ArrayList a() {
        this.h.getClass();
        ArrayList arrayList0 = Q.f();
        q.f(arrayList0, "getRoutes(...)");
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(this.i.e(((O)object0).k)) {
                arrayList1.add(object0);
            }
        }
        HashSet hashSet0 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for(Object object1: arrayList1) {
            String s = ((O)object1).c;
            q.f(s, "getId(...)");
            if(hashSet0.add(o.Z0(s, ":", s))) {
                arrayList2.add(object1);
            }
        }
        ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
        for(Object object2: arrayList2) {
            q.d(((O)object2));
            arrayList3.add(new b(((O)object2)));
        }
        ArrayList arrayList4 = je.p.Q0(arrayList3);
        O o0 = Q.g();
        q.f(o0, "getSelectedRoute(...)");
        if(o0.n == 1000) {
            arrayList4.add(new b(o0));
        }
        return arrayList4;
    }

    @Override  // Ub.r
    public final void b() {
        this.i(new d(this, 4));
    }

    @Override  // Ub.r
    public final void c(t t0) {
        this.p = t0;
    }

    public static final void d(CastHelper castHelper0, String s) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(castHelper0.c.plus(castHelper0.e)), null, null, new j(castHelper0, s, null), 3, null);
    }

    public final void e(CastContext castContext0) {
        castContext0.getSessionManager().addSessionManagerListener(this.l, CastSession.class);
        castContext0.addSessionTransferCallback(this.m);
        Q q0 = this.h;
        q0.getClass();
        h h0 = this.k;
        if(h0 == null) {
            throw new IllegalArgumentException("providerInstance must not be null");
        }
        Q.b();
        Q.c().a(h0, false);
        q0.a(this.i, this.n, 0);
        this.j(q0, null, "connectSessionListener");
    }

    public final void f(String s, a a0) {
        q.g(s, "reason");
        LogU.debug$default(this.b, "disconnect reason: " + s, null, false, 6, null);
        this.g.set(a0);
        this.h.getClass();
        Q.l(2);
    }

    public final void g(String s, String s1, String s2, CastSession castSession0) {
        String s5;
        String s4;
        String s3;
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.f.length() > 0) {
            i.a(stringBuilder0, this.f);
        }
        i.a(stringBuilder0, "payload: " + s + ", sessionInfo: " + s1);
        if(s2 != null) {
            i.a(stringBuilder0, "extra: " + s2);
        }
        if(castSession0 != null) {
            CastDevice castDevice0 = castSession0.getCastDevice();
            if(castDevice0 == null) {
                s3 = "Unknown Device";
            }
            else {
                s3 = castDevice0.getFriendlyName();
                if(s3 == null) {
                    s3 = "Unknown Device";
                }
            }
            i.a(stringBuilder0, "friendlyName: " + s3);
            CastDevice castDevice1 = castSession0.getCastDevice();
            if(castDevice1 == null) {
                s4 = "Unknown Model";
            }
            else {
                s4 = castDevice1.getModelName();
                if(s4 == null) {
                    s4 = "Unknown Model";
                }
            }
            i.a(stringBuilder0, "model: " + s4);
            CastDevice castDevice2 = castSession0.getCastDevice();
            if(castDevice2 == null) {
                s5 = "Unknown Version";
            }
            else {
                s5 = castDevice2.getDeviceVersion();
                if(s5 == null) {
                    s5 = "Unknown Version";
                }
            }
            i.a(stringBuilder0, "version: " + s5);
            String s6 = castSession0.getApplicationStatus();
            if(s6 == null) {
                s6 = "Unknown State";
            }
            i.a(stringBuilder0, "appStatus: " + s6);
        }
        this.f = stringBuilder0.toString();
    }

    public static void h(CastHelper castHelper0, String s, String s1, String s2, CastSession castSession0, int v) {
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            castSession0 = null;
        }
        castHelper0.g(s, s1, s2, castSession0);
    }

    public final Object i(a a0) {
        if(q.b(Looper.myLooper(), Looper.getMainLooper())) {
            return a0.invoke();
        }
        Ub.i i0 = new Ub.i(a0, null);
        return BuildersKt.runBlocking(this.d, i0);
    }

    public final void j(Q q0, O o0, String s) {
        LogU.debug$default(this.b, "updateRouteListingPreference fromCall: " + s, null, false, 6, null);
        this.i(new Dc.i(16, q0, o0));
    }
}

