package I7;

import E9.u;
import I6.G0;
import I6.Q;
import I6.V;
import I6.p0;
import M6.B;
import M6.H;
import U4.w;
import V4.G;
import V4.c;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ClientCertRequest;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.utils.g;
import androidx.fragment.app.I;
import androidx.fragment.app.L0;
import androidx.fragment.app.d;
import androidx.fragment.app.n;
import androidx.lifecycle.s;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.exoplayer.O;
import androidx.media3.exoplayer.X;
import androidx.media3.session.E0;
import androidx.media3.session.MediaSessionService;
import androidx.media3.session.h1;
import androidx.media3.session.k0;
import androidx.media3.session.n0;
import androidx.media3.session.o1;
import androidx.media3.session.s0;
import androidx.media3.session.s1;
import androidx.media3.session.t0;
import androidx.media3.session.t1;
import androidx.media3.session.v;
import androidx.media3.session.w0;
import androidx.media3.session.w1;
import androidx.media3.session.x0;
import androidx.media3.session.y0;
import androidx.media3.session.y1;
import b3.E;
import b3.S;
import b3.m0;
import com.facebook.appevents.iap.InAppPurchaseAutoLogger;
import com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion;
import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Task.Companion;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.NativeAppLoginMethodHandler;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.b;
import com.kakaoent.trevi.ad.webview.helper.ClientCertRequestDialog;
import d5.l;
import d5.t;
import e3.x;
import e7.o;
import i.n.i.b.a.s.e.G1;
import i.n.i.b.a.s.e.R1;
import i.n.i.b.a.s.e.c5;
import i.n.i.b.a.s.e.c9;
import i.n.i.b.a.s.e.e2;
import i.n.i.b.a.s.e.h9;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import s3.z;
import w1.j;
import w1.m;
import we.a;
import y.e;

public final class k implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public k(t0 t00, v v0, String s, Bundle bundle0) {
        this.a = 15;
        super();
        this.c = v0;
        this.b = s;
        this.d = bundle0;
    }

    public k(o o0, Throwable throwable0) {
        this.a = 28;
        Map map0 = Collections.EMPTY_MAP;
        super();
        this.c = o0;
        this.b = throwable0;
        this.d = map0;
    }

    public k(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        this.d = object2;
        super();
    }

    public k(Object object0, Object object1, String s, int v) {
        this.a = v;
        this.c = object0;
        this.d = object1;
        this.b = s;
        super();
    }

    public k(AtomicBoolean atomicBoolean0, j j0, a a0) {
        this.a = 3;
        super();
        this.c = atomicBoolean0;
        this.b = j0;
        this.d = (r)a0;
    }

    @Override
    public final void run() {
        Object object3;
        boolean z = true;
        Bitmap bitmap0 = null;
        switch(this.a) {
            case 0: {
                ((BiConsumer)this.c).accept(((String)this.b), ((f)this.d));
                return;
            }
            case 1: {
                ClientCertRequestDialog.b(((Activity)this.c), ((String)this.b), ((ClientCertRequest)this.d));
                return;
            }
            case 2: {
                j j0 = (j)this.b;
                a a1 = (a)this.d;
                if(!((AtomicBoolean)this.c).get()) {
                    try {
                        j0.a(a1.invoke());
                        return;
                    }
                    catch(Throwable throwable0) {
                        j0.c(throwable0);
                    }
                }
                return;
            }
            case 3: {
                j j1 = (j)this.b;
                r r0 = (r)this.d;
                if(!((AtomicBoolean)this.c).get()) {
                    try {
                        j1.a(((a)r0).invoke());
                        return;
                    }
                    catch(Throwable throwable1) {
                        j1.c(throwable1);
                    }
                }
                return;
            }
            case 4: {
                V4.f f0 = (V4.f)this.c;
                m m0 = (m)this.b;
                G g0 = (G)this.d;
                try {
                    z = ((Boolean)m0.b.get()).booleanValue();
                }
                catch(InterruptedException | ExecutionException unused_ex) {
                }
                synchronized(f0.k) {
                    d5.j j2 = t.i(g0.a);
                    String s = j2.a;
                    if(f0.c(s) == g0) {
                        f0.b(s);
                    }
                    w.e().a("WM-Processor", "f " + s + " executed; reschedule = " + z);
                    for(Object object1: f0.j) {
                        ((c)object1).e(j2, z);
                    }
                }
                return;
            }
            case 5: {
                ((V4.f)((ea.a)this.c).a).f(((V4.k)this.b), ((l)this.d));
                return;
            }
            case 6: {
                androidx.lifecycle.t t0 = (androidx.lifecycle.t)this.c;
                androidx.car.app.utils.a a2 = (androidx.car.app.utils.a)this.d;
                String s1 = (String)this.b;
                try {
                    if(t0 != null && t0.b().compareTo(s.c) >= 0) {
                        a2.a();
                        return;
                    }
                    Log.w("CarApp.Dispatch", "Lifecycle is not at least created when dispatching " + a2);
                    return;
                }
                catch(e e0) {
                }
                Log.e("CarApp.Dispatch", "Serialization failure in " + s1, e0);
                return;
            }
            case 7: {
                IOnDoneCallback iOnDoneCallback0 = (IOnDoneCallback)this.c;
                String s2 = (String)this.b;
                androidx.car.app.utils.a a3 = (androidx.car.app.utils.a)this.d;
                try {
                    g.d((s2 + " onSuccess"), new H7.c(iOnDoneCallback0, a3.a(), s2, 10));
                    return;
                }
                catch(RuntimeException runtimeException0) {
                    g.f(iOnDoneCallback0, s2, runtimeException0);
                    throw new RuntimeException(runtimeException0);
                }
                catch(e e1) {
                    g.f(iOnDoneCallback0, s2, e1);
                    return;
                }
            }
            case 8: {
                q.g(((ViewGroup)this.c), "$container");
                q.g(((d)this.d), "this$0");
                ((ViewGroup)this.c).endViewTransition(((View)this.b));
                ((d)this.d).c.a.c(((d)this.d));
                return;
            }
            case 9: {
                I i0 = ((L0)this.c).c;
                I i1 = ((L0)this.b).c;
                q.g(i0, "inFragment");
                q.g(i1, "outFragment");
                if(((n)this.d).o) {
                    i1.getEnterTransitionCallback();
                    return;
                }
                i0.getEnterTransitionCallback();
                return;
            }
            case 10: {
                z z1 = (z)this.d;
                p0 p00 = ((Q)this.b).g();
                u u0 = ((O)this.c).c.d;
                S s3 = ((O)this.c).c.g;
                s3.getClass();
                u0.getClass();
                u0.b = V.p(p00);
                if(!p00.isEmpty()) {
                    u0.e = (z)p00.get(0);
                    z1.getClass();
                    u0.f = z1;
                }
                if(((z)u0.d) == null) {
                    u0.d = u.u(s3, ((V)u0.b), ((z)u0.e), ((m0)u0.a));
                }
                u0.I(s3.getCurrentTimeline());
                return;
            }
            case 11: {
                ((i3.e)((X)this.c).b.i).k(((int)(((Integer)((Pair)this.b).first))), ((z)((Pair)this.b).second), ((Exception)this.d));
                return;
            }
            case 12: {
                B b0 = (B)this.c;
                H h0 = (H)this.b;
                E e2 = (E)this.d;
                try {
                    bitmap0 = (Bitmap)b.D(b0);
                }
                catch(CancellationException | ExecutionException cancellationException0) {
                    e3.b.n(cancellationException0, "MLSLegacyStub", "failed to get bitmap");
                }
                h0.k(androidx.media3.session.q.a(e2, bitmap0));
                return;
            }
            case 13: {
                k0 k00 = (k0)this.c;
                w0 w00 = (w0)this.d;
                String s4 = (String)this.b;
                if(k00.l.u(w00, 50002)) {
                    k00.n.D(w00, s4);
                }
                return;
            }
            case 14: {
                ((n0)this.c).getClass();
                ((w0)this.d).d.getClass();
                ((n0)this.c).G.c(((String)this.b), ((w0)this.d));
                ((n0)this.c).H.c(((w0)this.d).d, ((String)this.b));
                return;
            }
            case 15: {
                v v1 = (v)this.c;
                String s5 = (String)this.b;
                Bundle bundle0 = (Bundle)this.d;
                v1.h0();
                androidx.media3.session.u u1 = v1.c;
                G0 g00 = (u1.isConnected() ? u1.W() : t1.b).a.k();
                while(g00.hasNext()) {
                    Object object2 = g00.next();
                    s1 s10 = (s1)object2;
                    if(s10.a == 0 && s10.b.equals(s5)) {
                        bitmap0 = s10;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
                if(bitmap0 != null) {
                    v1.h0();
                    if((u1.isConnected() ? u1.W() : t1.b).a.contains(bitmap0)) {
                        B b1 = v1.g0(new s1(s5, bundle0), Bundle.EMPTY);
                        b1.addListener(new M6.u(0, b1, new B3.q(s5, 4)), M6.s.a);
                    }
                }
                return;
            }
            case 16: {
                ((n0)this.c).getClass();
                ((Runnable)this.b).run();
                ((n0)this.c).g.c.h(((w0)this.d));
                return;
            }
            case 17: {
                E9.m m1 = (E9.m)this.c;
                w0 w01 = (w0)this.b;
                KeyEvent keyEvent0 = (KeyEvent)this.d;
                n0 n00 = (n0)m1.c;
                if(n00.k(w01)) {
                    n00.b(keyEvent0, false);
                }
                else {
                    w01.a.getClass();
                    n00.h.getClass();
                    E0 e00 = new E0(n00.h, 6);
                    n00.h.G(1, e00, w01.a, true);
                }
                m1.b = null;
                return;
            }
            case 18: {
                MediaSessionService mediaSessionService0 = (MediaSessionService)this.c;
                t0 t00 = (t0)this.b;
                y0 y00 = (y0)this.d;
                n0 n01 = y00.a;
                MediaSessionService mediaSessionService1 = t00.a;
                HashMap hashMap0 = t00.g;
                if(!hashMap0.containsKey(y00)) {
                    s0 s00 = new s0(mediaSessionService1, y00);
                    Bundle bundle1 = new Bundle();
                    bundle1.putBoolean("androidx.media3.session.MediaNotificationManager", true);
                    y1 y10 = n01.j;
                    y10.getClass();
                    x.u();
                    Bundle bundle2 = new Bundle(bundle1);
                    Looper looper0 = Looper.getMainLooper();
                    looper0.getClass();
                    androidx.media3.session.x x0 = new androidx.media3.session.x(looper0);
                    if(y10.a.e()) {
                        bitmap0 = new ea.d(new DataSourceBitmapLoader(mediaSessionService1));
                    }
                    v v2 = new v(mediaSessionService1, y10, bundle2, s00, looper0, x0, ((ea.d)bitmap0));
                    x.P(new Handler(looper0), new androidx.media3.session.s(x0, v2, 0));
                    hashMap0.put(y00, x0);
                    x0.addListener(new D5.a(t00, x0, s00, y00, 11), t00.e);
                }
                n01.w = new androidx.lifecycle.b(mediaSessionService0, 3);
                return;
            }
            case 19: {
                n0 n02 = (n0)this.c;
                androidx.media3.exoplayer.x x1 = (androidx.media3.exoplayer.x)this.b;
                x0 x00 = (x0)this.d;
                if(!n02.l()) {
                    o1 o10 = n02.t;
                    x1.getClass();
                    h1.f(o10, x00);
                }
                return;
            }
            case 20: {
                InAppPurchaseAutoLogger.startIapLogging$lambda$1(((kotlin.jvm.internal.H)this.c), ((BillingClientVersion)this.b), ((Context)this.d));
                return;
            }
            case 21: {
                Companion.call$lambda$2(((CancellationToken)this.c), ((TaskCompletionSource)this.b), ((Callable)this.d));
                return;
            }
            case 22: {
                CustomTabLoginMethodHandler.a(((CustomTabLoginMethodHandler)this.c), ((Request)this.b), ((Bundle)this.d));
                return;
            }
            case 23: {
                NativeAppLoginMethodHandler.a(((NativeAppLoginMethodHandler)this.c), ((Request)this.b), ((Bundle)this.d));
                return;
            }
            case 24: {
                EventDispatcher.c(((EventDispatcher)this.c), ((MediaSourceEventListener)this.b), ((MediaLoadData)this.d));
                return;
            }
            case 25: {
                B b2 = (B)this.c;
                H h1 = (H)this.b;
                M6.r r1 = (M6.r)this.d;
                try {
                    object3 = b.D(b2);
                }
                catch(CancellationException unused_ex) {
                    h1.cancel(false);
                    return;
                }
                catch(ExecutionException executionException0) {
                    Throwable throwable2 = executionException0.getCause();
                    if(throwable2 != null) {
                        executionException0 = throwable2;
                    }
                    h1.l(executionException0);
                    return;
                }
                catch(RuntimeException | Error runtimeException1) {
                    h1.l(runtimeException1);
                    return;
                }
                try {
                    h1.m(r1.apply(object3));
                }
                catch(Throwable throwable3) {
                    h1.l(throwable3);
                }
                return;
            }
            case 26: {
                H h2 = (H)this.c;
                A3.m m2 = (A3.m)this.b;
                w1 w10 = (w1)this.d;
                if(!(h2.a instanceof M6.a)) {
                    try {
                        m2.run();
                        h2.k(w10);
                        return;
                    }
                    catch(Throwable throwable4) {
                        h2.l(throwable4);
                    }
                }
                return;
            }
            case 27: {
                String s6 = (String)this.b;
                String s7 = (String)this.d;
                e7.k k0 = ((o)this.c).g;
                k0.getClass();
                try {
                    ((A3.c)k0.d.d).m(s6, s7);
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    if(k0.a != null && (2 & k0.a.getApplicationInfo().flags) != 0) {
                        throw illegalArgumentException0;
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                }
                return;
            }
            case 28: {
                Throwable throwable5 = (Throwable)this.b;
                Map map0 = Collections.EMPTY_MAP;
                e7.k k1 = ((o)this.c).g;
                Thread thread0 = Thread.currentThread();
                k1.getClass();
                long v3 = System.currentTimeMillis();
                if(k1.n == null || !k1.n.e.get()) {
                    String s8 = k1.e();
                    if(s8 == null) {
                        Log.w("FirebaseCrashlytics", "Tried to write a non-fatal exception while no session was open.", null);
                        return;
                    }
                    g7.c c0 = new g7.c(s8, v3 / 1000L, map0);
                    H8.q q0 = k1.m;
                    q0.getClass();
                    if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Persisting non-fatal event for session " + s8, null);
                    }
                    q0.q(throwable5, thread0, "error", c0, false);
                }
                return;
            }
            default: {
                e2 e20 = (e2)this.d;
                ((c9)this.b).c = true;
                c5 c50 = h9.r(((c9)this.b).b, ((c9)this.b).a);
                R1 r10 = ((G1)this.c).c.c;
                Bf.a a0 = ((G1)this.c).c.f;
                a0.getClass();
                r10.getClass();
                r10.b = h9.q(c50);
                if(!c50.isEmpty()) {
                    r10.e = (e2)c50.get(0);
                    e20.getClass();
                    r10.f = e20;
                }
                if(((e2)r10.d) == null) {
                    r10.d = R1.a(a0, ((h9)r10.b), ((e2)r10.e), ((i.n.i.b.a.s.e.g)r10.a));
                }
                r10.c(a0.d1());
            }
        }
    }
}

