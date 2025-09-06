package I;

import A0.c;
import B2.o;
import De.I;
import G.f;
import H7.e;
import H7.h;
import I7.j;
import I7.m;
import Sf.l;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.media3.exoplayer.V;
import d5.n;
import e1.x;
import ea.d;
import ie.H;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.E;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import ne.a;
import org.json.JSONException;
import org.json.JSONObject;
import r1.q;
import w4.b;

public final class t0 {
    public boolean a;
    public final Object b;
    public final Object c;
    public final Object d;
    public Object e;
    public final Object f;
    public Object g;
    public Object h;

    public t0(g1 g10, c c0, P0 p00, r1.c c1) {
        this.b = g10;
        this.c = c0;
        this.d = p00;
        this.e = c1;
        this.f = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
        this.h = new d(2);
    }

    public t0(AssetManager assetManager0, Executor executor0, b b0, String s, File file0) {
        byte[] arr_b;
        this.a = false;
        this.b = executor0;
        this.c = b0;
        this.f = s;
        this.e = file0;
        int v = Build.VERSION.SDK_INT;
        if(v >= 0x1F) {
            arr_b = w4.c.d;
        }
        else {
            switch(v) {
                case 26: {
                    arr_b = w4.c.g;
                    break;
                }
                case 27: {
                    arr_b = w4.c.f;
                    break;
                }
                case 28: 
                case 29: 
                case 30: {
                    arr_b = w4.c.e;
                    break;
                }
                default: {
                    arr_b = null;
                }
            }
        }
        this.d = arr_b;
    }

    public t0(HttpURLConnection httpURLConnection0, j j0, I7.d d0, LinkedHashSet linkedHashSet0, m m0, ScheduledExecutorService scheduledExecutorService0) {
        this.c = httpURLConnection0;
        this.d = j0;
        this.e = d0;
        this.b = linkedHashSet0;
        this.f = m0;
        this.g = scheduledExecutorService0;
        this.h = new Random();
        this.a = false;
    }

    public static final float a(t0 t00, d1 d10, float f) {
        float f1 = ((g1)t00.b).c(f);
        long v = ((g1)t00.b).g(f1);
        long v1 = g1.a(d10.a, d10.a.j, v, 1);
        long v2 = ((g1)t00.b).d(v1);
        return ((g1)t00.b).f(v2);
    }

    public static final Object b(t0 t00, g1 g10, h0 h00, float f, float f1, oe.c c0) {
        g1 g11;
        float f3;
        t0 t01;
        E e1;
        k0 k00;
        t00.getClass();
        if(c0 instanceof k0) {
            k00 = (k0)c0;
            int v = k00.I;
            if((v & 0x80000000) == 0) {
                k00 = new k0(t00, c0);
            }
            else {
                k00.I = v ^ 0x80000000;
            }
        }
        else {
            k00 = new k0(t00, c0);
        }
        Object object0 = k00.E;
        a a0 = a.a;
        H h0 = H.a;
        switch(k00.I) {
            case 0: {
                kotlin.jvm.internal.H h1 = H0.b.p(object0);
                h1.a = h00;
                t00.k(h00);
                h0 h01 = t0.j(((Channel)t00.f));
                if(h01 != null) {
                    t00.k(h01);
                    h1.a = ((h0)h1.a).a(h01);
                }
                E e0 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
                float f2 = g10.f(g10.d(((h0)h1.a).a));
                e0.a = f2;
                if(!g0.a(f2)) {
                    kotlin.jvm.internal.H h2 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h2.a = f.b(0.0f, 0.0f, 30);
                    m0 m00 = new m0(e0, h2, h1, f, t00, f1, g10, null);
                    k00.r = t00;
                    k00.w = g10;
                    k00.B = e0;
                    k00.D = f1;
                    k00.I = 1;
                    if(t00.l(g10, m00, k00) == a0) {
                        return a0;
                    }
                    e1 = e0;
                    t01 = t00;
                    f3 = f1;
                    g11 = g10;
                    goto label_47;
                }
                break;
            }
            case 1: {
                f3 = k00.D;
                e1 = k00.B;
                g11 = k00.w;
                t01 = k00.r;
                n.D(object0);
            label_47:
                d d0 = (d)t01.h;
                long v1 = x.x(((K0.d)d0.a).d(3.402823E+38f), ((K0.d)d0.b).d(3.402823E+38f));
                if(v1 == 0L) {
                    float f4 = g11.c(Math.signum(e1.a)) * Math.min(Math.abs(e1.a) / 100.0f, f3) * 1000.0f;
                    if(f4 == 0.0f) {
                        v1 = 0L;
                    }
                    else {
                        v1 = g11.d == u0.b ? x.x(f4, 0.0f) : x.x(0.0f, f4);
                    }
                }
                q q0 = new q(v1);
                k00.r = null;
                k00.w = null;
                k00.B = null;
                k00.I = 2;
                ((P0)t01.d).invoke(q0, k00);
                if(h0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    public static final Object c(t0 t00, kotlin.jvm.internal.H h0, E e0, g1 g10, kotlin.jvm.internal.H h1, long v, oe.c c0) {
        E e1;
        kotlin.jvm.internal.H h3;
        kotlin.jvm.internal.H h2;
        g1 g11;
        n0 n00;
        if(c0 instanceof n0) {
            n00 = (n0)c0;
            int v1 = n00.I;
            if((v1 & 0x80000000) == 0) {
                n00 = new n0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                n00.I = v1 ^ 0x80000000;
            }
        }
        else {
            n00 = new n0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = n00.G;
        a a0 = a.a;
        switch(n00.I) {
            case 0: {
                n.D(object0);
                if(v < 0L) {
                    return false;
                }
                o0 o00 = new o0(t00, null);
                n00.r = t00;
                n00.w = h0;
                n00.B = e0;
                g11 = g10;
                n00.D = g11;
                h2 = h1;
                n00.E = h2;
                n00.I = 1;
                object0 = TimeoutKt.withTimeoutOrNull(v, o00, n00);
                if(object0 == a0) {
                    return a0;
                }
                h3 = h0;
                e1 = e0;
                break;
            }
            case 1: {
                kotlin.jvm.internal.H h4 = n00.E;
                g1 g12 = n00.D;
                e1 = n00.B;
                h3 = n00.w;
                t0 t01 = n00.r;
                n.D(object0);
                h2 = h4;
                g11 = g12;
                t00 = t01;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((h0)object0) != null) {
            h3.a = new h0(((h0)object0).a, ((h0)object0).b, ((h0)h3.a).c);
            e1.a = g11.f(g11.d(((h0)object0).a));
            h2.a = f.b(0.0f, 0.0f, 30);
            t00.k(((h0)object0));
            return Boolean.valueOf(!g0.a(e1.a));
        }
        return Boolean.valueOf(((boolean)0));
    }

    public void d(int v, long v1) {
        if(v == 0) {
            new h("Unable to fetch the latest version of the template.");
            this.h();
            return;
        }
        int v2 = ((Random)this.h).nextInt(4);
        ((ScheduledExecutorService)this.g).schedule(new I7.b(this, v, v1), ((long)v2), TimeUnit.SECONDS);
    }

    public void e(InputStream inputStream0) {
        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0, "utf-8"));
        String s = "";
        String s1;
        while((s1 = bufferedReader0.readLine()) != null) {
            s = s + s1;
            if(s1.contains("}")) {
                int v = s.indexOf(0x7B);
                int v1 = s.lastIndexOf(0x7D);
                s = v >= 0 && v1 >= 0 && v < v1 ? s.substring(v, v1 + 1) : "";
                if(!s.isEmpty()) {
                    try {
                        JSONObject jSONObject0 = new JSONObject(s);
                        if(jSONObject0.has("featureDisabled") && jSONObject0.getBoolean("featureDisabled")) {
                            new h("The server is temporarily unavailable. Try again in a few minutes.");
                            ((m)this.f).a();
                            break;
                        }
                        synchronized(this) {
                        }
                        if(((LinkedHashSet)this.b).isEmpty()) {
                            break;
                        }
                        if(jSONObject0.has("latestTemplateVersionNumber")) {
                            long v3 = ((j)this.d).h.a.getLong("last_template_version", 0L);
                            long v4 = jSONObject0.getLong("latestTemplateVersionNumber");
                            if(v4 > v3) {
                                this.d(3, v4);
                            }
                        }
                    }
                    catch(JSONException jSONException0) {
                        new e("Unable to parse config update message.", jSONException0.getCause());  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                        this.h();
                        Log.e("FirebaseRemoteConfig", "Unable to parse latest config update message.", jSONException0);
                    }
                    s = "";
                }
            }
        }
        bufferedReader0.close();
    }

    public void f() {
        InputStream inputStream0;
        HttpURLConnection httpURLConnection0 = (HttpURLConnection)this.c;
        if(httpURLConnection0 != null) {
            try {
                try {
                    inputStream0 = null;
                    inputStream0 = httpURLConnection0.getInputStream();
                    this.e(inputStream0);
                    goto label_19;
                }
                catch(IOException iOException0) {
                }
                if(!this.a) {
                    Log.d("FirebaseRemoteConfig", "Real-time connection was closed due to an exception.", iOException0);
                }
            }
            catch(Throwable throwable0) {
                goto label_13;
            }
            if(inputStream0 != null) {
                try {
                    inputStream0.close();
                }
                catch(IOException iOException1) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", iOException1);
                }
                return;
            label_13:
                if(inputStream0 != null) {
                    try {
                        inputStream0.close();
                    }
                    catch(IOException iOException2) {
                        Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", iOException2);
                    }
                }
                throw throwable0;
            label_19:
                if(inputStream0 != null) {
                    try {
                        inputStream0.close();
                    }
                    catch(IOException iOException1) {
                        Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", iOException1);
                    }
                }
            }
        }
    }

    public FileInputStream g(AssetManager assetManager0, String s) {
        try {
            return assetManager0.openFd(s).createInputStream();
        }
        catch(FileNotFoundException fileNotFoundException0) {
            String s1 = fileNotFoundException0.getMessage();
            if(s1 != null && s1.contains("compressed")) {
                ((b)this.c).c();
            }
            return null;
        }
    }

    public void h() {
        synchronized(this) {
            for(Object object0: ((LinkedHashSet)this.b)) {
                ((m)object0).a();
            }
        }
    }

    public void i(Serializable serializable0, int v) {
        V v1 = new V(this, v, serializable0, 9);
        ((Executor)this.b).execute(v1);
    }

    public static h0 j(Channel channel0) {
        h0 h00 = null;
        l l0 = I.P(new q0(new o(channel0, 5), null));
        while(l0.hasNext()) {
            h0 h01 = (h0)l0.next();
            if(h00 != null) {
                h01 = h00.a(h01);
            }
            h00 = h01;
        }
        return h00;
    }

    public void k(h0 h00) {
        d d0 = (d)this.h;
        ((K0.d)d0.a).b(h00.b, Float.intBitsToFloat(((int)(h00.a >> 0x20))));
        ((K0.d)d0.b).b(h00.b, Float.intBitsToFloat(((int)(h00.a & 0xFFFFFFFFL))));
    }

    public Object l(g1 g10, m0 m00, oe.c c0) {
        t0 t00;
        r0 r00;
        if(c0 instanceof r0) {
            r00 = (r0)c0;
            int v = r00.D;
            if((v & 0x80000000) == 0) {
                r00 = new r0(this, c0);
            }
            else {
                r00.D = v ^ 0x80000000;
            }
        }
        else {
            r00 = new r0(this, c0);
        }
        Object object0 = r00.w;
        a a0 = a.a;
        switch(r00.D) {
            case 0: {
                n.D(object0);
                this.a = true;
                s0 s00 = new s0(g10, m00, null);
                r00.r = this;
                r00.D = 1;
                if(SupervisorKt.supervisorScope(s00, r00) == a0) {
                    return a0;
                }
                t00 = this;
                break;
            }
            case 1: {
                t00 = r00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        t00.a = false;
        return H.a;
    }
}

