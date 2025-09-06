package E9;

import A8.M;
import B1.i;
import H7.e;
import L7.d;
import M6.u;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.media3.exoplayer.f;
import coil.memory.MemoryCache.Key;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.iloen.melon.net.v4x.response.DjThemeListPlystSearchRes;
import com.iloen.melon.net.v4x.response.DjThemeListRelTagSearchRes;
import com.iloen.melon.net.v5x.response.DjThemeListRecmTagRes;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes;
import com.iloen.melon.userstore.VolatileDatabase_Impl;
import com.iloen.melon.utils.StringUtils;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import d5.m;
import d5.n;
import d5.v;
import hb.A;
import hb.w;
import hb.x;
import hb.y;
import hb.z;
import i.n.i.b.a.s.e.P3;
import ie.H;
import ie.p;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import je.C;
import kotlin.jvm.internal.q;
import m3.h;
import m3.k;
import m3.o;
import ne.a;
import oe.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t5.j;
import t5.s;
import td.m0;
import w3.l;
import x9.b;

public final class g implements o {
    public Object a;
    public Object b;
    public static volatile g c;

    public g(int v) {
        if(v != 7) {
            super();
            this.a = new HashMap();
            this.b = new HashSet();
            this.A("ro.product.name", Build.PRODUCT);
            this.a("ro.product.name");
            this.A("ro.product.model", Build.MODEL);
            this.a("ro.product.model");
            this.A("ro.build.version.sdk", "33");
            this.a("ro.build.version.sdk");
            this.A("ro.product.board", Build.BOARD);
            this.a("ro.product.board");
            this.A("ro.hardware", Build.HARDWARE);
            this.a("ro.hardware");
            this.A("ro.product.manufacturer", Build.MANUFACTURER);
            this.a("ro.product.manufacturer");
            String[] arr_s = Build.SUPPORTED_ABIS;
            int v1 = 0;
            if(arr_s != null && arr_s.length >= 1) {
                this.A("ro.product.cpu.abi", arr_s[0]);
                this.a("ro.product.cpu.abi");
                if(arr_s.length >= 2) {
                    this.a("ro.product.cpu.abi2");
                    this.A("ro.product.cpu.abi2", arr_s[1]);
                }
            }
            if(this.g("ro.product.model").equals("AFTS") && this.g("ro.hardware").equals("mt8173")) {
                String s = this.g("ro.build.version.sdk");
                if(!s.equals("")) {
                    v1 = Integer.parseInt(s);
                }
                if(v1 >= 21) {
                    this.A("player.codec.mediaTekPlayReady", "yes");
                }
            }
            return;
        }
        super();
        this.a = new Handler(Looper.getMainLooper());
    }

    public g(B1.g g0, int v) {
        this.a = g0;
        String s = "top";
        if(v != 0) {
            if(v == 1) {
                s = "bottom";
            }
            else {
                Log.e("CCL", "horizontalAnchorIndexToAnchorName: Unknown horizontal index");
            }
        }
        this.b = s;
    }

    public g(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    public g(String s, Bundle bundle0) {
        if(s == null) {
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }
        this.a = s;
        this.b = bundle0;
    }

    public void A(String s, String s1) {
        synchronized(this) {
            if(!((HashSet)this.b).contains(s)) {
                ((HashMap)this.a).put(s, s1);
                return;
            }
        }
        throw new IllegalStateException("key " + s + " is not modifiable");
    }

    public void a(String s) {
        synchronized(this) {
            if(((HashMap)this.a).containsKey(s)) {
                ((HashSet)this.b).add(s);
            }
        }
    }

    public Object b(String s, String s1, c c0) {
        String s3;
        ie.o o0;
        w w0;
        if(c0 instanceof w) {
            w0 = (w)c0;
            int v = w0.D;
            if((v & 0x80000000) == 0) {
                w0 = new w(this, c0);
            }
            else {
                w0.D = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(this, c0);
        }
        Object object0 = w0.w;
        a a0 = a.a;
        H h0 = H.a;
        switch(w0.D) {
            case 0: {
                n.D(object0);
                try {
                    w0.D = 1;
                    x9.c c1 = ((ha.a)((v)this.a).b).a;
                    if(c1 != null) {
                        E9.w.N(((VolatileDatabase_Impl)c1.b), false, true, new m0(c1, s, s1, 4));
                    }
                    if(h0 == a0) {
                        return a0;
                    }
                    break;
                label_23:
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                o0 = n.t(throwable0);
                goto label_29;
            }
            case 1: {
                goto label_23;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o0 = h0;
    label_29:
        Throwable throwable1 = p.a(o0);
        if(throwable1 != null) {
            d5.c c2 = (d5.c)this.b;
            String s2 = "reason : " + throwable1.getCause() + " error message : " + throwable1.getMessage();
            w0.r = o0;
            w0.D = 2;
            if(s2 == null || s2.length() == 0 || s2.length() <= 4000) {
                s3 = s2;
            }
            else {
                s3 = s2.substring(0, 4000);
                q.f(s3, "substring(...)");
            }
            String s4 = StringUtils.getEncodeUTF8(s3);
            H h1 = ((na.c)c2.b).a(M.l + "/app?t=CRS&l=V&m=" + s4, "CRS", "V", s2, w0);
            if(h1 != a.a) {
                h1 = h0;
            }
            if(h1 == a0) {
                return a0;
            }
        }
        return h0;
    }

    public void c() {
        String s = (String)this.a;
        try {
            FileStore fileStore0 = (FileStore)this.b;
            fileStore0.getClass();
            new File(fileStore0.c, s).createNewFile();
        }
        catch(IOException iOException0) {
            Log.e("FirebaseCrashlytics", "Error creating marker: " + s, iOException0);
        }
    }

    @Override  // m3.o
    public l createPlaylistParser() {
        return new b(((o)this.a).createPlaylistParser(), ((List)this.b));
    }

    @Override  // m3.o
    public l d(k k0, h h0) {
        return new b(((o)this.a).d(k0, h0), ((List)this.b));
    }

    public void e(f f0) {
        synchronized(f0) {
        }
        Handler handler0 = (Handler)this.a;
        if(handler0 != null) {
            handler0.post(new P3(11, this, f0));
        }
    }

    public Future f(Callable callable0, long v, Runnable runnable0) {
        try {
            if(((ExecutorService)this.b) == null) {
                this.b = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            }
            Future future0 = ((ExecutorService)this.b).submit(callable0);
            u u0 = new u(13, future0, runnable0);
            if(Thread.interrupted()) {
                return future0;
            }
            ((Handler)this.a).postDelayed(u0, ((long)(((double)v) * 0.95)));
            return future0;
        }
        catch(Exception exception0) {
            y5.a.Y("AsyncExecutor", "Async task throws exception " + exception0);
            return null;
        }
    }

    public String g(String s) {
        synchronized(this) {
            String s1 = (String)((HashMap)this.a).get(s);
            if(s1 == null) {
                s1 = "";
            }
            return s1;
        }
    }

    public d h(I7.f f0) {
        I7.f f2;
        String s3;
        String s2;
        I7.f f1;
        String s1;
        String s;
        JSONObject jSONObject0;
        JSONArray jSONArray0 = f0.g;
        long v = f0.f;
        HashSet hashSet0 = new HashSet();
        int v1 = 0;
        while(v1 < jSONArray0.length()) {
            try {
                jSONObject0 = jSONArray0.getJSONObject(v1);
                s = jSONObject0.getString("rolloutId");
                JSONArray jSONArray1 = jSONObject0.getJSONArray("affectedParameterKeys");
                if(jSONArray1.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", s, jSONArray1));
                }
                s1 = jSONArray1.optString(0, "");
                f1 = ((I7.d)this.a).c();
                s2 = null;
                s3 = null;
                if(f1 != null) {
                    goto label_15;
                }
                goto label_16;
            }
            catch(JSONException jSONException0) {
                throw new e("Exception parsing rollouts metadata to create RolloutsState.", jSONException0);  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
            }
            try {
            label_15:
                s3 = f1.b.getString(s1);
            }
            catch(JSONException unused_ex) {
            }
            try {
            label_16:
                if(s3 == null) {
                    f2 = ((I7.d)this.b).c();
                    if(f2 != null) {
                        goto label_19;
                    }
                    goto label_20;
                }
                goto label_21;
            }
            catch(JSONException jSONException0) {
                throw new e("Exception parsing rollouts metadata to create RolloutsState.", jSONException0);  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
            }
            try {
            label_19:
                s2 = f2.b.getString(s1);
            }
            catch(JSONException unused_ex) {
            }
        label_20:
            s3 = s2 == null ? "" : s2;
            try {
            label_21:
                L7.b b0 = new L7.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                if(s == null) {
                    throw new NullPointerException("Null rolloutId");
                }
                b0.a = s;
                String s4 = jSONObject0.getString("variantId");
                if(s4 == null) {
                    throw new NullPointerException("Null variantId");
                }
                b0.b = s4;
                if(s1 == null) {
                    throw new NullPointerException("Null parameterKey");
                }
                b0.c = s1;
                b0.d = s3;
                b0.e = v;
                b0.f = (byte)(b0.f | 1);
                hashSet0.add(b0.a());
                ++v1;
                continue;
            }
            catch(JSONException jSONException0) {
            }
            throw new e("Exception parsing rollouts metadata to create RolloutsState.", jSONException0);  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        return new d(hashSet0);
    }

    public Object i(String s, c c0) {
        x x0;
        if(c0 instanceof x) {
            x0 = (x)c0;
            int v = x0.B;
            if((v & 0x80000000) == 0) {
                x0 = new x(this, c0);
            }
            else {
                x0.B = v ^ 0x80000000;
            }
        }
        else {
            x0 = new x(this, c0);
        }
        Object object0 = x0.r;
        a a0 = a.a;
        switch(x0.B) {
            case 0: {
                n.D(object0);
                try {
                    x0.B = 1;
                    object0 = ((v)this.a).l(s, x0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((DjTagSearchAutoCompleteRes)object0));
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
        return new Na.d(exception0);
    }

    public r5.a j(j j0, MemoryCache.Key memoryCache$Key0, u5.g g0, u5.f f0) {
        r5.a a0;
        Object object0 = j0.b;
        if(j0.q.a) {
            r5.b b0 = (r5.b)((i5.n)this.a).c.getValue();
            if(b0 == null) {
                a0 = null;
            }
            else {
                a0 = b0.a.a(memoryCache$Key0);
                if(a0 == null) {
                    a0 = b0.b.a(memoryCache$Key0);
                }
            }
            if(a0 != null) {
                Bitmap bitmap0 = a0.a;
                x5.k k0 = (x5.k)this.b;
                Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
                if(bitmap$Config0 == null) {
                    bitmap$Config0 = Bitmap.Config.ARGB_8888;
                }
                if(!m.p(j0, bitmap$Config0)) {
                    if(k0 == null) {
                        return null;
                    }
                    x5.k.a("MemoryCacheService", 3, object0 + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
                    return null;
                }
                Object object1 = a0.b.get("coil#is_sampled");
                Boolean boolean0 = object1 instanceof Boolean ? ((Boolean)object1) : null;
                boolean z = boolean0 == null ? false : boolean0.booleanValue();
                if(!q.b(g0, u5.g.c)) {
                    String s = (String)memoryCache$Key0.b.get("coil#transformation_size");
                    if(s != null) {
                        return s.equals(g0.toString()) ? a0 : null;
                    }
                    int v = bitmap0.getWidth();
                    int v1 = bitmap0.getHeight();
                    e1.m m0 = g0.a;
                    e1.m m1 = g0.b;
                    int v2 = m0 instanceof u5.a ? ((u5.a)m0).e : 0x7FFFFFFF;
                    int v3 = m1 instanceof u5.a ? ((u5.a)m1).e : 0x7FFFFFFF;
                    boolean z1 = false;
                    double f1 = df.v.r(v, v1, v2, v3, f0);
                    if(x5.e.a(j0)) {
                        double f2 = f1 > 1.0 ? 1.0 : f1;
                        z1 = true;
                        if(Math.abs(((double)v2) - ((double)v) * f2) > 1.0 && Math.abs(((double)v3) - f2 * ((double)v1)) > 1.0) {
                            goto label_44;
                        }
                        return a0;
                    }
                    else if(v2 != 0x80000000 && v2 != 0x7FFFFFFF && Math.abs(v2 - v) > 1 || v3 != 0x80000000 && v3 != 0x7FFFFFFF && Math.abs(v3 - v1) > 1) {
                    label_44:
                        if(Double.compare(f1, 1.0) != 0 && !z1) {
                            if(k0 == null) {
                                return null;
                            }
                            x5.k.a("MemoryCacheService", 3, object0 + ": Cached image\'s request size (" + v + ", " + v1 + ") does not exactly match the requested size (" + m0 + ", " + m1 + ", " + f0 + ").", null);
                            return null;
                        }
                        if(f1 > 1.0 && z) {
                            if(k0 != null) {
                                x5.k.a("MemoryCacheService", 3, object0 + ": Cached image\'s request size (" + v + ", " + v1 + ") is smaller than the requested size (" + m0 + ", " + m1 + ", " + f0 + ").", null);
                                return null;
                            }
                            return null;
                        }
                    }
                }
                else if(z) {
                    if(k0 == null) {
                        return null;
                    }
                    x5.k.a("MemoryCacheService", 3, object0 + ": Requested original size, but cached image is sampled.", null);
                    return null;
                }
                return a0;
            }
        }
        return null;
    }

    public Object k(String s, c c0) {
        ga.l l0;
        if(c0 instanceof ga.l) {
            l0 = (ga.l)c0;
            int v = l0.B;
            if((v & 0x80000000) == 0) {
                l0 = new ga.l(this, c0);
            }
            else {
                l0.B = v ^ 0x80000000;
            }
        }
        else {
            l0 = new ga.l(this, c0);
        }
        Object object0 = l0.r;
        a a0 = a.a;
        switch(l0.B) {
            case 0: {
                n.D(object0);
                l0.B = 1;
                object0 = ((Ba.d)this.b).b(s, l0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object l(String s, c c0) {
        ga.m m0;
        if(c0 instanceof ga.m) {
            m0 = (ga.m)c0;
            int v = m0.B;
            if((v & 0x80000000) == 0) {
                m0 = new ga.m(this, c0);
            }
            else {
                m0.B = v ^ 0x80000000;
            }
        }
        else {
            m0 = new ga.m(this, c0);
        }
        Object object0 = m0.r;
        a a0 = a.a;
        switch(m0.B) {
            case 0: {
                n.D(object0);
                m0.B = 1;
                object0 = ((Ba.d)this.b).d(s, m0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object m(String s, c c0) {
        ga.n n0;
        if(c0 instanceof ga.n) {
            n0 = (ga.n)c0;
            int v = n0.B;
            if((v & 0x80000000) == 0) {
                n0 = new ga.n(this, c0);
            }
            else {
                n0.B = v ^ 0x80000000;
            }
        }
        else {
            n0 = new ga.n(this, c0);
        }
        Object object0 = n0.r;
        a a0 = a.a;
        switch(n0.B) {
            case 0: {
                n.D(object0);
                n0.B = 1;
                object0 = ((Ca.c)this.a).b(s, n0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object n(int v, int v1, String s, c c0) {
        ga.o o0;
        if(c0 instanceof ga.o) {
            o0 = (ga.o)c0;
            int v2 = o0.B;
            if((v2 & 0x80000000) == 0) {
                o0 = new ga.o(this, c0);
            }
            else {
                o0.B = v2 ^ 0x80000000;
            }
        }
        else {
            o0 = new ga.o(this, c0);
        }
        Object object0 = o0.r;
        a a0 = a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                o0.B = 1;
                object0 = ((Ca.c)this.a).a(s, v, v1, o0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public File o() {
        if(((File)this.a) == null) {
            synchronized(this) {
                if(((File)this.a) == null) {
                    com.google.firebase.e e0 = (com.google.firebase.e)this.b;
                    e0.a();
                    this.a = new File(e0.a.getFilesDir(), "PersistedInstallation." + ((com.google.firebase.e)this.b).d() + ".json");
                }
            }
        }
        return (File)this.a;
    }

    public Object p(int v, int v1, String s, String s1, String s2, c c0) {
        y y0;
        if(c0 instanceof y) {
            y0 = (y)c0;
            int v2 = y0.B;
            if((v2 & 0x80000000) == 0) {
                y0 = new y(this, c0);
            }
            else {
                y0.B = v2 ^ 0x80000000;
            }
        }
        else {
            y0 = new y(this, c0);
        }
        Object object0 = y0.r;
        a a0 = a.a;
        switch(y0.B) {
            case 0: {
                n.D(object0);
                try {
                    y0.B = 1;
                    object0 = ((v)this.a).J(v, v1, s, s1, s2, y0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((DjThemeListPlystSearchRes)object0));
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
        return new Na.d(exception0);
    }

    public Object q(c c0) {
        z z0;
        if(c0 instanceof z) {
            z0 = (z)c0;
            int v = z0.B;
            if((v & 0x80000000) == 0) {
                z0 = new z(this, c0);
            }
            else {
                z0.B = v ^ 0x80000000;
            }
        }
        else {
            z0 = new z(this, c0);
        }
        Object object0 = z0.r;
        a a0 = a.a;
        switch(z0.B) {
            case 0: {
                n.D(object0);
                try {
                    z0.B = 1;
                    object0 = ((v)this.a).K("5", z0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((DjThemeListRecmTagRes)object0));
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
        return new Na.d(exception0);
    }

    public static g r() {
        if(g.c == null) {
            Class class0 = g.class;
            synchronized(class0) {
                if(g.c == null) {
                    g.c = new g(0);
                }
            }
        }
        return g.c;
    }

    public Object s(String s, c c0) {
        A a0;
        if(c0 instanceof A) {
            a0 = (A)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new A(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new A(this, c0);
        }
        Object object0 = a0.r;
        a a1 = a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = ((v)this.a).L(s, a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((DjThemeListRelTagSearchRes)object0));
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
        return new Na.d(exception0);
    }

    public void t(A7.b b0) {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("Fid", b0.a);
            jSONObject0.put("Status", e0.b.b(b0.b));
            jSONObject0.put("AuthToken", b0.c);
            jSONObject0.put("RefreshToken", b0.d);
            jSONObject0.put("TokenCreationEpochInSecs", b0.f);
            jSONObject0.put("ExpiresInSecs", b0.e);
            jSONObject0.put("FisError", b0.g);
            com.google.firebase.e e0 = (com.google.firebase.e)this.b;
            e0.a();
            File file0 = File.createTempFile("PersistedInstallation", "tmp", e0.a.getFilesDir());
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
            fileOutputStream0.write(jSONObject0.toString().getBytes("UTF-8"));
            fileOutputStream0.close();
            file0.renameTo(this.o());
        }
        catch(JSONException | IOException unused_ex) {
        }
    }

    public void u(x1.f f0, float f1, float f2) {
        int v = f0.b;
        String s = "top";
        if(v != 0) {
            if(v == 1) {
                s = "bottom";
            }
            else {
                Log.e("CCL", "horizontalAnchorIndexToAnchorName: Unknown horizontal index");
            }
        }
        B1.a a0 = new B1.a(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
        a0.k(i.k(f0.a.toString()));
        a0.k(i.k(s));
        a0.k(new B1.e(f1));
        a0.k(new B1.e(f2));
        ((B1.g)this.a).A(((String)this.b), a0);
    }

    public static void v(g g0, x1.f f0, float f1, int v) {
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        g0.u(f0, f1, 0.0f);
    }

    public MemoryCache.Key w(j j0, Object object0, t5.o o0, i5.c c0) {
        je.x x0;
        String s;
        MemoryCache.Key memoryCache$Key0 = j0.e;
        List list0 = j0.i;
        if(memoryCache$Key0 != null) {
            return memoryCache$Key0;
        }
        List list1 = ((i5.n)this.a).j.c;
        int v = list1.size();
        for(int v1 = 0; true; ++v1) {
            s = null;
            if(v1 >= v) {
                break;
            }
            ie.m m0 = (ie.m)list1.get(v1);
            p5.b b0 = (p5.b)m0.a;
            Class class0 = object0.getClass();
            if(((Class)m0.b).isAssignableFrom(class0)) {
                q.e(b0, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String s1 = b0.a(object0, o0);
                if(s1 != null) {
                    s = s1;
                    break;
                }
            }
        }
        if(s == null) {
            return null;
        }
        Map map0 = j0.A.a;
        if(map0.isEmpty()) {
            x0 = je.x.a;
        }
        else {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            for(Object object1: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object1;
                String s2 = ((t5.p)map$Entry0.getValue()).b;
                if(s2 != null) {
                    linkedHashMap0.put(map$Entry0.getKey(), s2);
                }
            }
            x0 = linkedHashMap0;
        }
        if(list0.isEmpty() && x0.isEmpty()) {
            return new MemoryCache.Key(s);
        }
        LinkedHashMap linkedHashMap1 = C.a0(x0);
        if(!list0.isEmpty()) {
            if(list0.size() <= 0) {
                linkedHashMap1.put("coil#transformation_size", o0.d.toString());
                return new MemoryCache.Key(s, linkedHashMap1);
            }
            list0.get(0).getClass();
            throw new ClassCastException();
        }
        return new MemoryCache.Key(s, linkedHashMap1);
    }

    public static s x(o5.l l0, j j0, MemoryCache.Key memoryCache$Key0, r5.a a0) {
        BitmapDrawable bitmapDrawable0 = new BitmapDrawable(j0.a.getResources(), a0.a);
        k5.g g0 = k5.g.a;
        Object object0 = a0.b.get("coil#disk_cache_key");
        Boolean boolean0 = null;
        Object object1 = a0.b.get("coil#is_sampled");
        if(object1 instanceof Boolean) {
            boolean0 = (Boolean)object1;
        }
        boolean z = false;
        boolean z1 = boolean0 == null ? false : boolean0.booleanValue();
        if(l0 != null && l0.g) {
            z = true;
        }
        return new s(bitmapDrawable0, j0, g0, memoryCache$Key0, (object0 instanceof String ? ((String)object0) : null), z1, z);
    }

    public void y(Z1.g g0) {
        Y1.d d0 = (Y1.d)this.b;
        I7.c c0 = (I7.c)this.a;
        int v = g0.b;
        if(v == 0) {
            d0.execute(new u(7, c0, g0.a));
            return;
        }
        d0.execute(new Z1.a(c0, v, 0));
    }

    public A7.b z() {
        JSONObject jSONObject0;
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        byte[] arr_b = new byte[0x4000];
        try(FileInputStream fileInputStream0 = new FileInputStream(this.o())) {
            int v;
            while((v = fileInputStream0.read(arr_b, 0, 0x4000)) >= 0) {
                byteArrayOutputStream0.write(arr_b, 0, v);
            }
            jSONObject0 = new JSONObject(byteArrayOutputStream0.toString());
        }
        catch(IOException | JSONException unused_ex) {
            jSONObject0 = new JSONObject();
        }
        String s = jSONObject0.optString("Fid", null);
        int v1 = jSONObject0.optInt("Status", 0);
        String s1 = jSONObject0.optString("AuthToken", null);
        String s2 = jSONObject0.optString("RefreshToken", null);
        long v2 = jSONObject0.optLong("TokenCreationEpochInSecs", 0L);
        long v3 = jSONObject0.optLong("ExpiresInSecs", 0L);
        String s3 = jSONObject0.optString("FisError", null);
        int v4 = e0.b.c(5)[v1];
        if(v4 == 0) {
            throw new NullPointerException("Null registrationStatus");
        }
        return new A7.b(s, v4, s1, s2, v3, v2, s3);
    }
}

