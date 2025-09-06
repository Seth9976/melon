package B9;

import Bd.D;
import Bd.M;
import Bd.P;
import Fc.s;
import Fc.t;
import I.t0;
import I6.p0;
import I7.n;
import I7.p;
import N5.d;
import Pc.e;
import U4.l;
import U4.o;
import Uc.Q;
import X5.h;
import X5.i;
import Y5.b;
import Y6.c;
import Y6.f;
import Y6.u;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import android.view.View;
import androidx.lifecycle.f0;
import androidx.media3.session.D0;
import androidx.media3.session.M0;
import androidx.media3.session.N0;
import androidx.media3.session.O;
import androidx.media3.session.b0;
import androidx.media3.session.h1;
import androidx.media3.session.i1;
import androidx.media3.session.k1;
import androidx.media3.session.m;
import androidx.media3.session.n0;
import androidx.media3.session.t1;
import androidx.media3.session.v0;
import androidx.media3.session.w0;
import androidx.media3.session.y;
import androidx.recyclerview.widget.RecyclerView;
import b3.E;
import b3.G;
import b3.L;
import b3.N;
import b3.T;
import b3.u0;
import c2.B0;
import c2.v;
import com.android.billingclient.api.Purchase;
import com.android.volley.Response.Listener;
import com.facebook.appevents.internal.FileDownloadTask.Callback;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager.TaskHandler.Companion;
import com.facebook.appevents.ml.ModelManager.TaskHandler;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseCommonRegistrar;
import com.iloen.melon.net.v6x.response.GoogleIapPurchaseRes.RESPONSE;
import com.iloen.melon.net.v6x.response.GoogleIapPurchaseRes;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes.RESPONSE.RECNTPLYLSTLIST;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.template.TemplateImageLoader.CaptureStateListener;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.T0;
import e3.j;
import ie.H;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import w1.k;
import y7.a;

public final class g implements h, b, f, D0, M0, O, b0, v, Listener, Callback, Continuation, SuccessContinuation, CaptureStateListener, com.melon.ui.M0, j, k, a {
    public final int a;
    public final Object b;
    public final Object c;

    public g(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public g(Executor executor0, we.a a0) {
        this.a = 12;
        super();
        this.b = executor0;
        this.c = (r)a0;
    }

    @Override  // com.melon.ui.M0
    public void a(boolean z, boolean z1) {
        Object object0 = this.c;
        Object object1 = this.b;
        switch(this.a) {
            case 1: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((P)object1)), null, null, new M(((P)object1), z, z1, ((DjMalrangInfo)object0), null), 3, null);
                return;
            }
            case 2: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((P)object1)), null, null, new Bd.O(z, z1, ((P)object1), ((D)(((e)object0))).b, null), 3, null);
                return;
            }
            default: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((Q)object1)), null, null, new Uc.P(((Q)object1), z, z1, ((T0)(((e)object0))).b, ((T0)(((e)object0))).a, "", null), 3, null);
            }
        }
    }

    @Override  // X5.h
    public Object apply(Object object0) {
        X5.j j0 = (X5.j)this.b;
        Q5.j j1 = (Q5.j)this.c;
        X5.a a0 = j0.d;
        ArrayList arrayList0 = j0.l(((SQLiteDatabase)object0), j1, a0.b);
        d[] arr_d = d.values();
        for(int v = 0; v < arr_d.length; ++v) {
            d d0 = arr_d[v];
            if(d0 != j1.c) {
                int v1 = a0.b - arrayList0.size();
                if(v1 <= 0) {
                    break;
                }
                arrayList0.addAll(j0.l(((SQLiteDatabase)object0), j1.b(d0), v1));
            }
        }
        HashMap hashMap0 = new HashMap();
        StringBuilder stringBuilder0 = new StringBuilder("event_id IN (");
        for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
            stringBuilder0.append(((X5.b)arrayList0.get(v2)).a);
            if(v2 < arrayList0.size() - 1) {
                stringBuilder0.append(',');
            }
        }
        stringBuilder0.append(')');
        try(Cursor cursor0 = ((SQLiteDatabase)object0).query("event_metadata", new String[]{"event_id", "name", "value"}, stringBuilder0.toString(), null, null, null, null)) {
            while(true) {
                if(!cursor0.moveToNext()) {
                    break;
                }
                long v3 = cursor0.getLong(0);
                Set set0 = (Set)hashMap0.get(v3);
                if(set0 == null) {
                    set0 = new HashSet();
                    hashMap0.put(v3, set0);
                }
                set0.add(new i(cursor0.getString(1), cursor0.getString(2)));
            }
        }
        ListIterator listIterator0 = arrayList0.listIterator();
        while(listIterator0.hasNext()) {
            X5.b b0 = (X5.b)listIterator0.next();
            long v4 = b0.a;
            if(hashMap0.containsKey(v4)) {
                Q5.h h0 = b0.c.c();
                for(Object object1: ((Set)hashMap0.get(v4))) {
                    h0.a(((i)object1).a, ((i)object1).b);
                }
                Q5.i i0 = h0.b();
                listIterator0.set(new X5.b(v4, b0.b, i0));
            }
        }
        return arrayList0;
    }

    @Override  // w1.k
    public Object attachCompleter(w1.j j0) {
        Executor executor0 = (Executor)this.b;
        r r0 = (r)this.c;
        AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
        o o0 = new o(atomicBoolean0, 1);
        w1.o o1 = j0.c;
        if(o1 != null) {
            o1.addListener(o0, l.a);
        }
        executor0.execute(new I7.k(atomicBoolean0, j0, ((we.a)r0)));
        return H.a;
    }

    @Override  // androidx.media3.session.b0
    public void b(androidx.media3.session.Q q0) {
        int v2;
        int v1;
        Object object0 = this.c;
        Object object1 = this.b;
        if(this.a != 26) {
            androidx.media3.session.v v0 = q0.a;
            if(q0.isConnected()) {
                boolean z = Objects.equals(q0.s, ((N)object0));
                boolean z1 = Objects.equals(q0.r, ((t1)object1));
                if(!z || !z1) {
                    q0.r = (t1)object1;
                    boolean z2 = true;
                    if(z) {
                        v1 = 0;
                    }
                    else {
                        q0.s = (N)object0;
                        N n0 = q0.u;
                        N n1 = androidx.media3.session.Q.c0(((N)object0), q0.t);
                        q0.u = n1;
                        v1 = !n1.equals(n0);
                    }
                    if(!z1 || v1 != 0) {
                        p0 p00 = q0.q;
                        p0 p01 = androidx.media3.session.Q.u0(q0.p, q0.o, ((t1)object1), q0.u);
                        q0.q = p01;
                        v2 = !p01.equals(p00);
                    }
                    else {
                        v2 = 0;
                    }
                    if(v1 != 0) {
                        y y0 = new y(q0, 14);
                        q0.h.g(13, y0);
                    }
                    if(!z1) {
                        v0.getClass();
                        e3.b.j(Looper.myLooper() == v0.e.getLooper());
                        v0.d.s();
                    }
                    if(v2 != 0) {
                        v0.getClass();
                        if(Looper.myLooper() != v0.e.getLooper()) {
                            z2 = false;
                        }
                        e3.b.j(z2);
                        v0.d.getClass();
                        v0.d.a();
                    }
                }
            }
            return;
        }
        k1 k10 = (k1)object1;
        i1 i10 = (i1)object0;
        if(q0.isConnected()) {
            k1 k11 = q0.B;
            if(k11 != null) {
                i1 i11 = q0.C;
                if(i11 != null) {
                    Pair pair0 = h1.e(k11, i11, k10, i10, q0.u);
                    k10 = (k1)pair0.first;
                    i10 = (i1)pair0.second;
                }
            }
            Integer integer0 = null;
            q0.B = null;
            q0.C = null;
            if(!q0.j.isEmpty()) {
                q0.B = k10;
                q0.C = i10;
                return;
            }
            k1 k12 = q0.n;
            k1 k13 = (k1)h1.e(k12, i1.c, k10, i10, q0.u).first;
            q0.n = k13;
            Integer integer1 = !k12.d.equals(k10.d) || !k12.e.equals(k10.e) ? k13.f : null;
            Integer integer2 = Objects.equals(k12.s(), k13.s()) ? null : k13.b;
            Integer integer3 = k12.j.equals(k13.j) ? null : k13.k;
            int v3 = k13.u;
            if(k12.u != v3 || k12.t != k13.t) {
                integer0 = v3;
            }
            q0.q0(k12, k13, integer3, integer0, integer1, integer2);
        }
    }

    @Override  // Y6.f
    public Object c(u u0) {
        if(this.a != 5) {
            try {
                Trace.beginSection(((String)this.b));
                return ((c)this.c).f.c(u0);
            }
            finally {
                Trace.endSection();
            }
        }
        String s = (String)this.b;
        Context context0 = (Context)u0.get(Context.class);
        switch(((com.google.android.exoplayer2.upstream.cache.a)this.c).a) {
            case 6: {
                return context0.getApplicationInfo() == null ? new G7.a(s, "") : new G7.a(s, "35");
            }
            case 7: {
                ApplicationInfo applicationInfo0 = context0.getApplicationInfo();
                return applicationInfo0 == null ? new G7.a(s, "") : new G7.a(s, String.valueOf(applicationInfo0.minSdkVersion));
            }
            case 8: {
                if(context0.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                    return new G7.a(s, "tv");
                }
                if(context0.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                    return new G7.a(s, "watch");
                }
                if(context0.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                    return new G7.a(s, "auto");
                }
                return context0.getPackageManager().hasSystemFeature("android.hardware.type.embedded") ? new G7.a(s, "embedded") : new G7.a(s, "");
            }
            default: {
                String s1 = context0.getPackageManager().getInstallerPackageName("com.iloen.melon");
                return s1 == null ? new G7.a(s, "") : new G7.a(s, FirebaseCommonRegistrar.a(s1));
            }
        }
    }

    @Override  // androidx.media3.session.O
    public void d(m m0, int v) {
        switch(this.a) {
            case 20: {
                m0.Z(((androidx.media3.session.Q)this.b).c, v, ((Surface)this.c));
                return;
            }
            case 21: {
                Bundle bundle1 = new Bundle();
                bundle1.putFloat("0", ((L)this.c).a);
                bundle1.putFloat("1", ((L)this.c).b);
                m0.V(((androidx.media3.session.Q)this.b).c, v, bundle1);
                return;
            }
            case 22: {
                Bundle bundle2 = ((G)this.c).c();
                m0.b0(((androidx.media3.session.Q)this.b).c, v, bundle2);
                return;
            }
            case 23: {
                Bundle bundle3 = ((u0)this.c).c();
                m0.B0(((androidx.media3.session.Q)this.b).c, v, bundle3);
                return;
            }
            default: {
                Bundle bundle0 = ((E)this.c).d(true);
                m0.l0(((androidx.media3.session.Q)this.b).c, v, bundle0, true);
            }
        }
    }

    @Override  // Y5.b
    public Object execute() {
        if(this.a != 14) {
            W5.h h0 = (W5.h)this.b;
            for(Object object0: ((HashMap)this.c).entrySet()) {
                long v = (long)(((int)(((Integer)((Map.Entry)object0).getValue()))));
                String s = (String)((Map.Entry)object0).getKey();
                ((X5.j)h0.i).m(v, T5.c.g, s);
            }
            return null;
        }
        Iterable iterable0 = (Iterable)this.c;
        X5.j j0 = (X5.j)((W5.h)this.b).c;
        j0.getClass();
        if(iterable0.iterator().hasNext()) {
            j0.h().compileStatement("DELETE FROM events WHERE _id in " + X5.j.o(iterable0)).execute();
        }
        return null;
    }

    @Override  // androidx.media3.session.M0
    public void f(w0 w00) {
        T t0 = (T)this.c;
        n0 n00 = ((N0)this.b).g;
        E e0 = n00.t.o0();
        if(e0 == null) {
            return;
        }
        n00.B(w00, e0.a, t0);
    }

    @Override  // y7.a
    public void g(y7.b b0) {
        ((a)this.b).g(b0);
        ((a)this.c).g(b0);
    }

    @Override  // androidx.media3.session.D0
    public void h(v0 v00, int v) {
        String s = (String)this.c;
        Collection collection0 = (Collection)((n0)this.b).H.a().get(v00);
        if(collection0 != null && collection0.contains(s)) {
            v00.p(v, s);
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 19) {
            E e0 = ((k1)((E9.u)this.b).a).s();
            ((b3.P)object0).t(((int)(((Integer)this.c))), e0);
            return;
        }
        ((b3.P)object0).t(((int)(((Integer)this.c))), ((E)this.b));
    }

    @Override  // com.iloen.melon.utils.template.TemplateImageLoader$CaptureStateListener
    public void onCaptureComplete(Bitmap bitmap0) {
        q.g(bitmap0, "bitmap");
        Boolean boolean0 = ((RECNTPLYLSTLIST)this.c).isMelonLogo;
        q.f(boolean0, "isMelonLogo");
        ((B9.k)this.b).b.b(boolean0.booleanValue());
        ((B9.k)this.b).b.setImageBitmap(bitmap0);
    }

    @Override  // com.facebook.appevents.internal.FileDownloadTask$Callback
    public void onComplete(File file0) {
        Companion.execute$lambda$1$lambda$0(((TaskHandler)this.b), ((Model)this.c), file0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        Y8.d d0 = (Y8.d)this.b;
        Purchase purchase0 = (Purchase)this.c;
        d0.e();
        RESPONSE googleIapPurchaseRes$RESPONSE0 = ((GoogleIapPurchaseRes)object0).response;
        if(googleIapPurchaseRes$RESPONSE0 != null) {
            String s = googleIapPurchaseRes$RESPONSE0.link.returnUrl;
            LogU.Companion.d("BillingClientLifecycle", "requestConfirmPurchase() needConsumption:" + googleIapPurchaseRes$RESPONSE0.needConsumption + ", returnUrl:" + s);
            Y8.e e0 = new Y8.e(1000, s);
            d0.c.postValue(e0);
            if(googleIapPurchaseRes$RESPONSE0.needConsumption) {
                d0.a(purchase0);
            }
            return;
        }
        LogU.Companion.d("BillingClientLifecycle", "requestConfirmPurchase() response is null");
        Y8.d.b(d0, 2001);
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        t t0 = (t)this.c;
        q.g(view0, "v");
        S1.d d0 = b00.a.g(647);
        q.f(d0, "getInsets(...)");
        view0.setPadding(0, d0.b, 0, 0);
        RecyclerView recyclerView0 = ((J8.D)this.b).d;
        for(int v = recyclerView0.getItemDecorationCount() - 1; -1 < v; --v) {
            recyclerView0.removeItemDecorationAt(v);
        }
        recyclerView0.addItemDecoration(new s(ScreenUtils.dipToPixel(t0.getContext(), 10.0f), ScreenUtils.dipToPixel(t0.getContext(), 6.0f), t0.getResources().getDimensionPixelSize(0x7F0700AD) + d0.d));  // dimen:cover_screen_bottom_margin
        return b00;
    }

    @Override  // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object object0) {
        Void void0 = (Void)object0;
        synchronized(((I7.d)this.b)) {
            ((I7.d)this.b).c = Tasks.forResult(((I7.f)this.c));
        }
        return Tasks.forResult(((I7.f)this.c));
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        int v;
        Integer integer0;
        InputStream inputStream2;
        InputStream inputStream1;
        Object object0;
        switch(this.a) {
            case 7: {
                return ((I7.j)this.b).b(task0, 0L, ((HashMap)this.c));
            }
            case 8: {
                I7.j j0 = (I7.j)this.b;
                Date date0 = (Date)this.c;
                j0.getClass();
                if(task0.isSuccessful()) {
                    synchronized(j0.h.b) {
                        j0.h.a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date0.getTime()).apply();
                        return task0;
                    }
                }
                Exception exception0 = task0.getException();
                if(exception0 != null) {
                    if(exception0 instanceof H7.g) {
                        synchronized(j0.h.b) {
                            j0.h.a.edit().putInt("last_fetch_status", 2).apply();
                            return task0;
                        }
                    }
                    object0 = j0.h.b;
                    synchronized(object0) {
                        j0.h.a.edit().putInt("last_fetch_status", 1).apply();
                    }
                    __monitor_exit(object0);
                }
                try {
                    return task0;
                }
                catch(Throwable throwable1) {
                    __monitor_exit(object0);
                    throw throwable1;
                }
            }
            default: {
                n n0 = (n)this.b;
                Task task1 = (Task)this.c;
                Clock clock0 = n0.p;
                boolean z = true;
                InputStream inputStream0 = null;
                try {
                    if(!task1.isSuccessful()) {
                        throw new IOException(task1.getException());
                    }
                    HttpURLConnection httpURLConnection0 = (HttpURLConnection)task1.getResult();
                    n0.f = httpURLConnection0;
                    inputStream1 = httpURLConnection0.getInputStream();
                }
                catch(IOException iOException0) {
                    inputStream1 = null;
                    inputStream2 = null;
                    integer0 = null;
                    goto label_42;
                }
                catch(Throwable throwable0) {
                    inputStream2 = null;
                    integer0 = null;
                    goto label_64;
                }
                try {
                    inputStream2 = null;
                    inputStream2 = n0.f.getErrorStream();
                }
                catch(IOException iOException0) {
                    integer0 = null;
                    goto label_42;
                }
                catch(Throwable throwable0) {
                    integer0 = null;
                    goto label_63;
                }
                try {
                    integer0 = null;
                    v = n0.f.getResponseCode();
                    integer0 = v;
                    if(v == 200) {
                        synchronized(n0) {
                            n0.c = 8;
                        }
                        n0.q.e(0, p.f);
                        t0 t00 = n0.j(n0.f);
                        n0.g = t00;
                        t00.f();
                    }
                    goto label_78;
                }
                catch(IOException iOException0) {
                    try {
                    label_42:
                        if(n0.e) {
                            synchronized(n0) {
                                n0.c = 8;
                            }
                        }
                        else {
                            Log.d("FirebaseRemoteConfig", "Exception connecting to real-time RC backend. Retrying the connection...", iOException0);
                        }
                    }
                    catch(Throwable throwable0) {
                        goto label_63;
                    }
                    n0.b(inputStream1, inputStream2);
                    synchronized(n0) {
                        n0.b = false;
                    }
                    if(!n0.e && (integer0 == null || n.d(((int)integer0)))) {
                        n0.k(new Date(clock0.currentTimeMillis()));
                    }
                    else {
                        z = false;
                    }
                    if(z || ((int)integer0) == 200) {
                        n0.h();
                    }
                    else {
                        new H7.h(((int)integer0), (((int)integer0) == 403 ? n.f(n0.f.getErrorStream()) : String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", integer0)), 0);
                        n0.g();
                    }
                    n0.f = null;
                    n0.g = null;
                    return Tasks.forResult(null);
                }
                catch(Throwable throwable0) {
                }
            label_63:
                inputStream0 = inputStream1;
            label_64:
                n0.b(inputStream0, inputStream2);
                synchronized(n0) {
                    n0.b = false;
                    if(!n0.e && (integer0 == null || n.d(((int)integer0)))) {
                        n0.k(new Date(clock0.currentTimeMillis()));
                    }
                    else {
                        z = false;
                    }
                    if(z || ((int)integer0) == 200) {
                        n0.h();
                    }
                    else {
                        new H7.h(((int)integer0), (((int)integer0) == 403 ? n.f(n0.f.getErrorStream()) : String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", integer0)), 0);
                        n0.g();
                    }
                    throw throwable0;
                label_78:
                    n0.b(inputStream1, inputStream2);
                    __monitor_enter(n0);
                    n0.b = false;
                }
                if(!n0.e && n.d(v)) {
                    n0.k(new Date(clock0.currentTimeMillis()));
                }
                else {
                    z = false;
                }
                if(z || v == 200) {
                    n0.h();
                }
                else {
                    new H7.h(v, (v == 403 ? n.f(n0.f.getErrorStream()) : String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", integer0)), 0);
                    n0.g();
                }
                n0.f = null;
                n0.g = null;
                return Tasks.forResult(null);
            }
        }
    }
}

