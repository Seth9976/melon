package z7;

import A7.a;
import E9.g;
import Y6.o;
import Z6.i;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.e;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import jeb.synthetic.FIN;
import org.json.JSONException;
import org.json.JSONObject;
import y7.b;

public final class c implements d {
    public final e a;
    public final B7.d b;
    public final g c;
    public final j d;
    public final o e;
    public final h f;
    public final Object g;
    public final ExecutorService h;
    public final i i;
    public String j;
    public final HashSet k;
    public final ArrayList l;
    public static final Object m;

    static {
        c.m = new Object();
        new AtomicInteger(1);
    }

    public c(e e0, b b0, ExecutorService executorService0, i i0) {
        e0.a();
        B7.d d0 = new B7.d(e0.a, b0);
        g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.b = e0;
        if(w7.d.b == null) {
            w7.d.b = new w7.d(8);
        }
        w7.d d1 = w7.d.b;
        if(j.d == null) {
            j.d = new j(d1);
        }
        j j0 = j.d;
        o o0 = new o(new Y6.e(e0, 2));
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        super();
        this.g = new Object();
        this.k = new HashSet();
        this.l = new ArrayList();
        this.a = e0;
        this.b = d0;
        this.c = g0;
        this.d = j0;
        this.e = o0;
        this.f = h0;
        this.h = executorService0;
        this.i = i0;
    }

    public final void a() {
        A7.b b0;
        synchronized(c.m) {
            this.a.a();
            ea.c c0 = ea.c.d(this.a.a);
            try {
                b0 = this.c.z();
                if(b0.b == 1 || b0.b == 2) {
                    String s = this.f(b0);
                    a a0 = b0.a();
                    a0.b = s;
                    a0.c = 3;
                    b0 = a0.a();
                    this.c.t(b0);
                }
            }
            finally {
                if(c0 != null) {
                    c0.i();
                }
            }
        }
        this.i(b0);
        z7.b b1 = new z7.b(this, 2);
        this.i.execute(b1);
    }

    public final A7.b b(A7.b b0) {
        B7.c c0;
        B7.d d0 = this.b;
        this.a.a();
        String s = this.a.c.a;
        String s1 = b0.a;
        this.a.a();
        String s2 = this.a.c.g;
        String s3 = b0.d;
        B7.e e0 = d0.c;
        if(!e0.a()) {
            throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
        }
        URL uRL0 = B7.d.a(("projects/" + s2 + "/installations/" + s1 + "/authTokens:generate"));
        int v = 0;
        while(v <= 1) {
            TrafficStats.setThreadStatsTag(0x8003);
            HttpURLConnection httpURLConnection0 = d0.c(uRL0, s);
            try {
                httpURLConnection0.setRequestMethod("POST");
                httpURLConnection0.addRequestProperty("Authorization", "FIS_v2 " + s3);
                httpURLConnection0.setDoOutput(true);
                B7.d.h(httpURLConnection0);
                int v2 = httpURLConnection0.getResponseCode();
                e0.b(v2);
                if(v2 >= 200 && v2 < 300) {
                    c0 = B7.d.f(httpURLConnection0);
                    goto label_46;
                }
                B7.d.b(httpURLConnection0, null, s, s2);
                switch(v2) {
                    case 401: 
                    case 404: {
                        B7.b b2 = B7.c.a();
                        b2.a = 3;
                        c0 = b2.f();
                        goto label_46;
                    }
                    case 429: {
                        throw new z7.e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
                    label_29:
                        if(v2 < 500 || v2 >= 600) {
                            Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                            B7.b b1 = B7.c.a();
                            b1.a = 2;
                            c0 = b1.f();
                            goto label_46;
                        }
                        break;
                    }
                    default: {
                        goto label_29;
                    }
                }
            }
            catch(AssertionError | IOException unused_ex) {
            }
            finally {
                httpURLConnection0.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
            ++v;
            continue;
        label_46:
            switch(e0.b.b(c0.c)) {
                case 0: {
                    this.d.getClass();
                    TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
                    this.d.a.getClass();
                    long v3 = timeUnit0.toSeconds(System.currentTimeMillis());
                    a a0 = b0.a();
                    a0.d = c0.a;
                    a0.g = c0.b;
                    a0.h = v3;
                    return a0.a();
                }
                case 1: {
                    a a1 = b0.a();
                    a1.f = "BAD CONFIG";
                    a1.c = 5;
                    return a1.a();
                }
                case 2: {
                    synchronized(this) {
                        this.j = null;
                    }
                    a a2 = b0.a();
                    a2.c = 2;
                    return a2.a();
                }
                default: {
                    throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
                }
            }
        }
        throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
    }

    public final Task c() {
        String s;
        this.e();
        synchronized(this) {
            s = this.j;
        }
        if(s != null) {
            return Tasks.forResult(s);
        }
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        z7.g g0 = new z7.g(taskCompletionSource0);
        synchronized(this.g) {
            this.l.add(g0);
        }
        z7.b b0 = new z7.b(this, 0);
        this.h.execute(b0);
        return taskCompletionSource0.getTask();
    }

    public final Task d() {
        this.e();
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        f f0 = new f(this.d, taskCompletionSource0);
        synchronized(this.g) {
            this.l.add(f0);
        }
        z7.b b0 = new z7.b(this, 1);
        this.h.execute(b0);
        return taskCompletionSource0.getTask();
    }

    public final void e() {
        this.a.a();
        Preconditions.checkNotEmpty(this.a.c.b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        this.a.a();
        Preconditions.checkNotEmpty(this.a.c.g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        this.a.a();
        Preconditions.checkNotEmpty(this.a.c.a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        this.a.a();
        Preconditions.checkArgument(this.a.c.b.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        this.a.a();
        Preconditions.checkArgument(j.c.matcher(this.a.c.a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String f(A7.b b0) {
        String s;
        this.a.a();
        if(this.a.b.equals("CHIME_ANDROID_SDK")) {
        label_4:
            if(b0.b == 1) {
                A7.c c0 = (A7.c)this.e.get();
                synchronized(c0.a) {
                    synchronized(c0.a) {
                        s = c0.a.getString("|S|id", null);
                    }
                    if(s == null) {
                        s = c0.a();
                    }
                }
                if(TextUtils.isEmpty(s)) {
                    this.f.getClass();
                    return "c45W0rehSK-K2KLjR_jUef";
                }
                return s;
            }
        }
        else {
            this.a.a();
            if("[DEFAULT]".equals(this.a.b)) {
                goto label_4;
            }
        }
        this.f.getClass();
        return "c45W0rehSK-K2KLjR_jUef";
    }

    public final A7.b g(A7.b b0) {
        B7.a a1;
        B7.a a0;
        String s = null;
        if(b0.a != null && b0.a.length() == 11) {
            A7.c c0 = (A7.c)this.e.get();
            SharedPreferences sharedPreferences0 = c0.a;
            __monitor_enter(sharedPreferences0);
            int v = FIN.finallyOpen$NT();
            String[] arr_s = A7.c.c;
            int v1 = 0;
            while(true) {
                if(v1 >= 4) {
                    FIN.finallyCodeBegin$NT(v);
                    __monitor_exit(sharedPreferences0);
                    FIN.finallyCodeEnd$NT(v);
                    break;
                }
                String s1 = c0.a.getString("|T|" + c0.b + "|" + arr_s[v1], null);
                if(s1 != null && !s1.isEmpty()) {
                    if(s1.startsWith("{")) {
                        try {
                            s = new JSONObject(s1).getString("token");
                            goto label_15;
                        label_14:
                            s = s1;
                        }
                        catch(JSONException unused_ex) {
                        }
                    }
                    else {
                        goto label_14;
                    }
                label_15:
                    FIN.finallyExec$NT(v);
                    break;
                }
                ++v1;
            }
        }
        B7.d d0 = this.b;
        this.a.a();
        String s2 = this.a.c.a;
        String s3 = b0.a;
        this.a.a();
        String s4 = this.a.c.g;
        this.a.a();
        String s5 = this.a.c.b;
        B7.e e0 = d0.c;
        if(!e0.a()) {
            throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
        }
        URL uRL0 = B7.d.a(("projects/" + s4 + "/installations"));
        int v2 = 0;
        while(v2 <= 1) {
            TrafficStats.setThreadStatsTag(0x8001);
            HttpURLConnection httpURLConnection0 = d0.c(uRL0, s2);
            try {
                httpURLConnection0.setRequestMethod("POST");
                httpURLConnection0.setDoOutput(true);
                if(s != null) {
                    httpURLConnection0.addRequestProperty("x-goog-fis-android-iid-migration-auth", s);
                }
                B7.d.g(httpURLConnection0, s3, s5);
                int v3 = httpURLConnection0.getResponseCode();
                e0.b(v3);
                boolean z = v3 < 200 || v3 >= 300 ? false : true;
                if(z) {
                    a0 = B7.d.e(httpURLConnection0);
                    goto label_51;
                }
                goto label_54;
            }
            catch(AssertionError | IOException unused_ex) {
                goto label_66;
            }
            catch(Throwable throwable0) {
                goto label_65;
            }
        label_51:
            httpURLConnection0.disconnect();
            TrafficStats.clearThreadStatsTag();
            goto label_76;
            try {
            label_54:
                B7.d.b(httpURLConnection0, s5, s2, s4);
                if(v3 == 429) {
                    throw new z7.e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
                }
            }
            catch(AssertionError | IOException unused_ex) {
                goto label_66;
            }
            catch(Throwable throwable0) {
                goto label_65;
            }
            if(v3 < 500 || v3 >= 600) {
                try {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    a1 = new B7.a(null, null, null, null, 2);
                    goto label_73;
                label_65:
                    goto label_70;
                }
                catch(AssertionError | IOException unused_ex) {
                }
                catch(Throwable throwable0) {
                    goto label_65;
                }
            }
        label_66:
            httpURLConnection0.disconnect();
            TrafficStats.clearThreadStatsTag();
            ++v2;
            continue;
        label_70:
            httpURLConnection0.disconnect();
            TrafficStats.clearThreadStatsTag();
            throw throwable0;
        label_73:
            httpURLConnection0.disconnect();
            TrafficStats.clearThreadStatsTag();
            a0 = a1;
        label_76:
            switch(e0.b.b(a0.e)) {
                case 0: {
                    this.d.getClass();
                    TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
                    this.d.a.getClass();
                    long v4 = timeUnit0.toSeconds(System.currentTimeMillis());
                    a a2 = b0.a();
                    a2.b = a0.b;
                    a2.c = 4;
                    a2.d = a0.d.a;
                    a2.e = a0.c;
                    a2.g = a0.d.b;
                    a2.h = v4;
                    return a2.a();
                }
                case 1: {
                    a a3 = b0.a();
                    a3.f = "BAD CONFIG";
                    a3.c = 5;
                    return a3.a();
                }
                default: {
                    throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
                }
            }
        }
        throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
    }

    public final void h(Exception exception0) {
        synchronized(this.g) {
            Iterator iterator0 = this.l.iterator();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                if(((z7.i)object1).a(exception0)) {
                    iterator0.remove();
                }
            }
        }
    }

    public final void i(A7.b b0) {
        synchronized(this.g) {
            Iterator iterator0 = this.l.iterator();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                if(((z7.i)object1).b(b0)) {
                    iterator0.remove();
                }
            }
        }
    }
}

