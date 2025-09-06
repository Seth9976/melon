package D2;

import B2.k;
import C2.e;
import L2.j;
import M2.a;
import M2.h;
import U4.F;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import d5.n;
import ie.H;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import je.x;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import oe.c;
import p0.d;
import p0.m;
import w8.T;

public final class p extends j {
    public final T d;
    public final f e;
    public final a f;
    public final O0 g;
    public final boolean h;
    public final b0 i;
    public final b0 j;
    public Object k;
    public final CompletableJob l;
    public final MutableStateFlow m;

    public p(T t0, f f0, Bundle bundle0, int v) {
        if((v & 4) != 0) {
            bundle0 = null;
        }
        super(F.p(f0.a));
        this.d = t0;
        this.e = f0;
        this.f = M2.f.a;
        this.g = t0.c;
        this.h = true;
        if(0x80000000 <= f0.a && f0.a < -1) {
            throw new IllegalArgumentException("If the AppWidgetSession is not created for a bound widget, you must provide a lambda action receiver");
        }
        this.i = w.r(null, V.c);
        this.j = w.r(bundle0, V.c);
        this.k = x.a;
        this.l = JobKt__JobKt.Job$default(null, 1, null);
        this.m = StateFlowKt.MutableStateFlow(null);
    }

    @Override  // L2.j
    public final Object a(Context context0, k k0, c c0) {
        Throwable throwable0;
        Context context2;
        p p0;
        k k2;
        D2.k k1;
        if(c0 instanceof D2.k) {
            k1 = (D2.k)c0;
            int v = k1.G;
            if((v & 0x80000000) == 0) {
                k1 = new D2.k(this, c0);
            }
            else {
                k1.G = v ^ 0x80000000;
            }
        }
        else {
            k1 = new D2.k(this, c0);
        }
        Object object0 = k1.D;
        ne.a a0 = ne.a.a;
        switch(k1.G) {
            case 0: {
                n.D(object0);
                if(d5.f.U(k0)) {
                    return false;
                }
                q.e(k0, "null cannot be cast to non-null type androidx.glance.appwidget.RemoteViewsRoot");
                G0 g00 = (G0)k0;
                k1.r = this;
                k1.w = context0;
                k1.B = k0;
                k1.G = 1;
                object0 = r0.g.b(context0, this.e.a, k1);
                if(object0 != a0) {
                    context2 = context0;
                    p0 = this;
                    k2 = k0;
                label_38:
                    r0 r00 = (r0)object0;
                    Object object1 = context2.getSystemService("appwidget");
                    q.e(object1, "null cannot be cast to non-null type android.appwidget.AppWidgetManager");
                    AppWidgetManager appWidgetManager0 = (AppWidgetManager)object1;
                    try {
                        p0.getClass();
                        f f0 = p0.e;
                        AppWidgetProviderInfo appWidgetProviderInfo0 = appWidgetManager0.getAppWidgetInfo(f0.a);
                        if(appWidgetProviderInfo0 == null) {
                            throw new IllegalArgumentException(("No app widget info for " + f0.a).toString());
                        }
                        ComponentName componentName0 = appWidgetProviderInfo0.provider;
                        x1.a.J(((G0)k2));
                        p0.k = x1.a.S(k2);
                        int v1 = r00.a(k2);
                        RemoteViews remoteViews0 = y5.a.W(context2, f0.a, ((G0)k2), r00, v1, componentName0);
                        if(p0.h) {
                            appWidgetManager0.updateAppWidget(f0.a, remoteViews0);
                        }
                        p0.m.setValue(remoteViews0);
                        goto label_80;
                    }
                    catch(CancellationException unused_ex) {
                    }
                    catch(Throwable throwable1) {
                        goto label_64;
                    }
                    k1.r = null;
                    k1.w = null;
                    k1.B = null;
                    k1.G = 3;
                    if(r00.b(k1) != a0) {
                        S0.a();
                        return true;
                    }
                    return a0;
                    try {
                    label_64:
                        p0.e(context2, throwable1);
                    }
                    catch(Throwable throwable0) {
                        k1.r = throwable0;
                        k1.w = null;
                        k1.B = null;
                        k1.G = 5;
                        if(r00.b(k1) != a0) {
                            S0.a();
                            throw throwable0;
                        }
                        break;
                    }
                    k1.r = null;
                    k1.w = null;
                    k1.B = null;
                    k1.G = 4;
                    if(r00.b(k1) != a0) {
                        S0.a();
                        return true;
                    }
                    return a0;
                label_80:
                    k1.r = null;
                    k1.w = null;
                    k1.B = null;
                    k1.G = 2;
                    if(r00.b(k1) != a0) {
                        S0.a();
                        return true;
                    }
                }
                break;
            }
            case 1: {
                k2 = k1.B;
                Context context1 = k1.w;
                p0 = (p)k1.r;
                n.D(object0);
                context2 = context1;
                goto label_38;
            }
            case 2: 
            case 3: 
            case 4: {
                n.D(object0);
                S0.a();
                return true;
            }
            case 5: {
                throwable0 = (Throwable)k1.r;
                n.D(object0);
                S0.a();
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    @Override  // L2.j
    public final Object b(Context context0, Object object0, c c0) {
        p p0;
        l l0;
        if(c0 instanceof l) {
            l0 = (l)c0;
            int v = l0.D;
            if((v & 0x80000000) == 0) {
                l0 = new l(this, c0);
            }
            else {
                l0.D = v ^ 0x80000000;
            }
        }
        else {
            l0 = new l(this, c0);
        }
        Object object1 = l0.w;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        H h1 = null;
        switch(l0.D) {
            case 0: {
                n.D(object1);
                String s = this.a;
                if(!(object0 instanceof i)) {
                    goto label_30;
                }
                h h2 = this.d.b;
                if(h2 == null) {
                    p0 = this;
                    object1 = null;
                    break;
                label_30:
                    if(object0 instanceof D2.h) {
                        p0.h h3 = m.k();
                        d d0 = h3 instanceof d ? ((d)h3) : null;
                        if(d0 != null) {
                            d d1 = d0.C(null, null);
                            if(d1 != null) {
                                try {
                                    p0.h h4 = d1.j();
                                    try {
                                        ((androidx.compose.runtime.O0)this.j).setValue(((D2.h)object0).a);
                                    }
                                    catch(Throwable throwable0) {
                                        p0.h.q(h4);
                                        throw throwable0;
                                    }
                                    p0.h.q(h4);
                                    d1.w().c();
                                    return h0;
                                }
                                finally {
                                    d1.c();
                                }
                            }
                        }
                        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
                    }
                    if(object0 instanceof g) {
                        p0.h h5 = m.k();
                        d d2 = h5 instanceof d ? ((d)h5) : null;
                        if(d2 != null) {
                            d d3 = d2.C(null, null);
                            if(d3 != null) {
                                try {
                                    p0.h h6 = d3.j();
                                    try {
                                        List list0 = (List)((Map)this.k).get(((g)object0).a);
                                        if(list0 != null) {
                                            for(Object object2: list0) {
                                                ((e)object2).b.invoke();
                                            }
                                            h1 = h0;
                                        }
                                    }
                                    finally {
                                        p0.h.q(h6);
                                    }
                                    d3.w().c();
                                }
                                finally {
                                    d3.c();
                                }
                                if(h1 != null) {
                                    return h0;
                                }
                                Log.w("AppWidgetSession", A7.d.n(new StringBuilder("Triggering Action("), ((g)object0).a, ") for session(", s, ") failed"));
                                return h0;
                            }
                        }
                        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
                    }
                    if(!(object0 instanceof D2.j)) {
                        throw new IllegalArgumentException("Sent unrecognized event type " + object0.getClass() + " to AppWidgetSession");
                    }
                    CompletableJob completableJob0 = ((D2.j)object0).a;
                    if(completableJob0.isActive()) {
                        completableJob0.complete();
                    }
                    return h0;
                }
                else {
                    l0.r = this;
                    l0.D = 1;
                    object1 = ((M2.f)this.f).c(context0, h2, s, l0);
                    if(object1 == a0) {
                        return a0;
                    }
                    p0 = this;
                }
                break;
            }
            case 1: {
                p0 = l0.r;
                n.D(object1);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        p0.h h7 = m.k();
        d d4 = h7 instanceof d ? ((d)h7) : null;
        if(d4 != null) {
            d d5 = d4.C(null, null);
            if(d5 != null) {
                try {
                    p0.h h8 = d5.j();
                    try {
                        ((androidx.compose.runtime.O0)p0.i).setValue(object1);
                    }
                    catch(Throwable throwable1) {
                        p0.h.q(h8);
                        throw throwable1;
                    }
                    p0.h.q(h8);
                    d5.w().c();
                    return h0;
                }
                finally {
                    d5.c();
                }
            }
        }
        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
    }

    public final void e(Context context0, Throwable throwable0) {
        Log.e("GlanceAppWidget", "Error in Glance App Widget", throwable0);
        if(!this.h) {
            throw throwable0;
        }
        this.d.getClass();
        RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", 0x7F0D0323);  // layout:glance_error_layout
        AppWidgetManager.getInstance(context0).updateAppWidget(this.e.a, remoteViews0);
    }

    public final Object f(c c0) {
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v = o0.D;
            if((v & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.D = v ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Object object0 = o0.w;
        ne.a a0 = ne.a.a;
        switch(o0.D) {
            case 0: {
                n.D(object0);
                D2.j j0 = new D2.j(JobKt.Job(this.l));
                o0.r = j0;
                o0.D = 1;
                return this.d(j0, o0) == a0 ? a0 : j0.a;
            }
            case 1: {
                D2.j j1 = o0.r;
                n.D(object0);
                return j1.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

