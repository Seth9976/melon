package Q7;

import M7.B;
import M7.b;
import O7.a;
import android.os.Build.VERSION;
import android.os.Build;
import android.util.Log;
import ie.H;
import ie.m;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import je.C;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import me.i;
import oe.c;

public final class d implements n {
    public final z7.d a;
    public final b b;
    public final f c;
    public final a d;
    public final Mutex e;

    public d(i i0, z7.d d0, b b0, f f0, a a0) {
        q.g(i0, "backgroundDispatcher");
        q.g(d0, "firebaseInstallationsApi");
        q.g(b0, "appInfo");
        q.g(f0, "configsFetcher");
        q.g(a0, "lazySettingsCache");
        super();
        this.a = d0;
        this.b = b0;
        this.c = f0;
        this.d = a0;
        this.e = MutexKt.Mutex$default(false, 1, null);
    }

    @Override  // Q7.n
    public final Boolean a() {
        g g0 = this.e().b;
        if(g0 != null) {
            return g0.a;
        }
        q.m("sessionConfigs");
        throw null;
    }

    @Override  // Q7.n
    public final Uf.b b() {
        g g0 = this.e().b;
        if(g0 != null) {
            return g0.c == null ? null : new Uf.b(x1.a.P(((int)g0.c), Uf.d.d));
        }
        q.m("sessionConfigs");
        throw null;
    }

    @Override  // Q7.n
    public final Double c() {
        g g0 = this.e().b;
        if(g0 != null) {
            return g0.b;
        }
        q.m("sessionConfigs");
        throw null;
    }

    @Override  // Q7.n
    public final Object d(Continuation continuation0) {
        Mutex mutex2;
        H h1;
        String s;
        d d0;
        Mutex mutex1;
        Q7.a a0;
        if(continuation0 instanceof Q7.a) {
            a0 = (Q7.a)continuation0;
            int v = a0.E;
            if((v & 0x80000000) == 0) {
                a0 = new Q7.a(this, ((c)continuation0));
            }
            else {
                a0.E = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Q7.a(this, ((c)continuation0));
        }
        Object object0 = a0.B;
        ne.a a1 = ne.a.a;
        H h0 = H.a;
        switch(a0.E) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.e;
                if(!mutex0.isLocked() && !this.e().b()) {
                    return h0;
                }
                a0.r = this;
                a0.w = mutex0;
                a0.E = 1;
                if(mutex0.lock(null, a0) == a1) {
                    return a1;
                }
                mutex1 = mutex0;
                d0 = this;
                goto label_28;
            }
            case 1: {
                mutex1 = a0.w;
                d0 = (d)a0.r;
                d5.n.D(object0);
                try {
                label_28:
                    if(!d0.e().b()) {
                        Log.d("SessionConfigFetcher", "Remote settings cache not expired. Using cached values.");
                        goto label_30;
                    }
                    goto label_32;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    mutex2.unlock(null);
                    throw throwable0;
                }
            label_30:
                mutex1.unlock(null);
                return h0;
                try {
                label_32:
                    a0.r = d0;
                    a0.w = mutex1;
                    a0.E = 2;
                    object0 = B.c.a(d0.a, a0);
                    if(object0 != a1) {
                        goto label_41;
                    }
                    return a1;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                goto label_41;
            }
            case 2: {
                mutex1 = a0.w;
                d0 = (d)a0.r;
                try {
                    d5.n.D(object0);
                label_41:
                    s = ((B)object0).a;
                    if(s.equals("")) {
                        Log.w("SessionConfigFetcher", "Error getting Firebase Installation ID. Skipping this Session Event.");
                        goto label_44;
                    }
                    goto label_46;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    mutex2.unlock(null);
                    throw throwable0;
                }
            label_44:
                mutex1.unlock(null);
                return h0;
                try {
                label_46:
                    m m0 = new m("X-Crashlytics-Installation-ID", s);
                    String s1 = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                    d0.getClass();
                    m m1 = new m("X-Crashlytics-Device-Model", d.f(s1));
                    String s2 = Build.VERSION.INCREMENTAL;
                    q.f(s2, "INCREMENTAL");
                    m m2 = new m("X-Crashlytics-OS-Build-Version", d.f(s2));
                    String s3 = Build.VERSION.RELEASE;
                    q.f(s3, "RELEASE");
                    m m3 = new m("X-Crashlytics-OS-Display-Version", d.f(s3));
                    d0.b.getClass();
                    Map map0 = C.S(new m[]{m0, m1, m2, m3, new m("X-Crashlytics-API-Client-Version", "2.1.2")});
                    Log.d("SessionConfigFetcher", "Fetching settings from server.");
                    Q7.b b0 = new Q7.b(d0, null);
                    Q7.c c0 = new Q7.c(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    a0.r = mutex1;
                    a0.w = null;
                    a0.E = 3;
                    e e0 = new e(d0.c, map0, b0, c0, null);
                    h1 = BuildersKt.withContext(d0.c.b, e0, a0);
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                if(h1 != a1) {
                    h1 = h0;
                }
                if(h1 == a1) {
                    return a1;
                }
                mutex2 = mutex1;
                break;
            }
            case 3: {
                mutex2 = (Mutex)a0.r;
                try {
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                mutex2.unlock(null);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return h0;
    }

    public final Q7.m e() {
        Object object0 = this.d.get();
        q.f(object0, "lazySettingsCache.get()");
        return (Q7.m)object0;
    }

    public static String f(String s) {
        Pattern pattern0 = Pattern.compile("/");
        q.f(pattern0, "compile(...)");
        String s1 = pattern0.matcher(s).replaceAll("");
        q.f(s1, "replaceAll(...)");
        return s1;
    }
}

