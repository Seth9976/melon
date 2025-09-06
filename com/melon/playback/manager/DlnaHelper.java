package com.melon.playback.manager;

import Hc.k;
import K8.b;
import L8.a;
import L8.s;
import M8.d;
import Nc.f;
import Ub.n;
import Ub.o;
import Ub.r;
import Ub.t;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import com.iloen.melon.net.NetworkStatusManager;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import gd.k4;
import hc.i;
import hc.u;
import ic.c;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/melon/playback/manager/DlnaHelper;", "LUb/r;", "Lic/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DlnaHelper implements r {
    public final Context a;
    public final LogU b;
    public final long c;
    public final int d;
    public final CoroutineDispatcher e;
    public t f;
    public final ie.r g;
    public Job h;
    public s i;
    public b j;
    public String k;
    public final ie.r l;
    public final ie.r m;
    public final o n;

    @Inject
    public DlnaHelper(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = Companion.create$default(LogU.Companion, "DlnaHelper", false, Category.Playback, 2, null);
        this.c = 5000L;
        this.d = 0xFFFF;
        this.e = Dispatchers.getIO();
        this.g = g.Q(new k(26));
        this.k = "";
        this.l = g.Q(new k(27));
        this.m = g.Q(new f(this, 15));
        this.n = new o(this);
    }

    @Override  // Ub.r
    public final ArrayList a() {
        ArrayList arrayList1;
        this.b();
        a a0 = this.h();
        d d0 = (d)this.m.getValue();
        a0.d.getClass();
        q.g(d0, "listener");
        ArrayList arrayList0 = a0.d.d;
        if(!arrayList0.contains(d0)) {
            arrayList0.add(d0);
        }
        this.h = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.e), null, null, new n(this, null), 3, null);
        a a1 = this.h();
        synchronized(a1.d.c) {
            Iterable iterable0 = a1.d.c.values();
            arrayList1 = new ArrayList(je.q.Q(10, iterable0));
            for(Object object0: iterable0) {
                arrayList1.add(((M8.b)object0).a);
            }
        }
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object1: arrayList1) {
            arrayList2.add(new c(((M8.a)object1)));
        }
        return arrayList2;
    }

    @Override  // Ub.r
    public final void b() {
        LogU.info$default(this.b, "stopSearch()", null, false, 6, null);
        a a0 = this.h();
        d d0 = (d)this.m.getValue();
        a0.d.getClass();
        q.g(d0, "listener");
        a0.d.d.remove(d0);
        Job job0 = this.h;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.h = null;
    }

    @Override  // Ub.r
    public final void c(t t0) {
        this.f = t0;
    }

    public static final void d(DlnaHelper dlnaHelper0) {
        LogU.info$default(dlnaHelper0.b, "findLocalIp()", null, false, 6, null);
        ConnectivityManager connectivityManager0 = (ConnectivityManager)dlnaHelper0.a.getSystemService("connectivity");
        InetAddress inetAddress0 = null;
        try {
            if(connectivityManager0 != null) {
                LinkProperties linkProperties0 = connectivityManager0.getLinkProperties(NetworkStatusManager.INSTANCE.getCurrentNetwork());
                if(linkProperties0 != null) {
                    List list0 = linkProperties0.getLinkAddresses();
                    if(list0 != null) {
                        for(Object object0: list0) {
                            LinkAddress linkAddress0 = (LinkAddress)object0;
                            if(!linkAddress0.getAddress().isLoopbackAddress()) {
                                String s = linkAddress0.getAddress().getHostAddress();
                                if(s != null && Tf.o.E0(s, ':', 0, 6) < 0) {
                                    inetAddress0 = linkAddress0.getAddress();
                                }
                            }
                        }
                    }
                }
            }
            if(inetAddress0 != null) {
                String s1 = inetAddress0.getHostAddress();
                if(s1 != null) {
                    dlnaHelper0.k = s1;
                }
            }
        }
        catch(Exception exception0) {
            LogU.error$default(dlnaHelper0.b, "findLocalIp() - Error", exception0, false, 4, null);
        }
    }

    public static final void e(DlnaHelper dlnaHelper0) {
        synchronized(dlnaHelper0) {
            LogU.info$default(dlnaHelper0.b, "initializeControlPointManager()", null, false, 6, null);
            long v1 = System.currentTimeMillis();
            if(!dlnaHelper0.h().b.get()) {
                dlnaHelper0.h().a();
                dlnaHelper0.h().c();
            }
            LogConstantsKt.debug(dlnaHelper0.b, "initializeControlPointManager() :: end", v1);
        }
    }

    public final void f() {
        LogU.info$default(this.b, "destroyController()", null, false, 6, null);
        s s0 = this.i;
        if(s0 != null) {
            LogU.info$default(s0.d, "terminate()", null, false, 6, null);
            s0.c("Terminate");
            s0.d("Terminate");
            M8.a.c(s0.a);
            J0.f f0 = new J0.f(s0.a.b, 3);
            ((pc.t)s0.a.b.b.b).C(new k4(8, s0.a.b, f0));
        }
        this.i = null;
        t t0 = this.f;
        if(t0 != null) {
            hc.g g0 = new hc.g("destroyController");
            t0.i(new i(u.a, g0, hc.c.a));
            return;
        }
        q.m("connectionListener");
        throw null;
    }

    public final void g(String s, we.a a0) {
        q.g(s, "reason");
        LogU.info$default(this.b, "disconnect() - " + s, null, false, 6, null);
        this.f();
        LogU.info$default(this.b, "shutdownLocalServer()", null, false, 6, null);
        b b0 = this.j;
        if(b0 != null) {
            try {
                File file0 = b0.c;
                if(file0.exists()) {
                    File[] arr_file = file0.listFiles();
                    if(arr_file != null && arr_file.length > 0) {
                        for(int v = 0; v < arr_file.length; ++v) {
                            arr_file[v].delete();
                        }
                    }
                }
                b0.a.close();
                b0.b.join();
            }
            catch(IOException | InterruptedException unused_ex) {
            }
        }
        this.j = null;
    }

    public final a h() {
        return (a)this.g.getValue();
    }

    public final M8.a i() {
        return this.i == null ? null : this.i.a;
    }
}

