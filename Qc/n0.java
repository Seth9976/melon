package qc;

import A3.g;
import Kb.c;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.LocalDownloadablePlaylist;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.SetRepeatResult.Success;
import com.melon.playlist.interfaces.SetRepeatResult;
import com.melon.playlist.interfaces.SetShuffleResult.Failure.SelectRepeatOn;
import com.melon.playlist.interfaces.SetShuffleResult;
import d5.n;
import e3.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import k8.Y;
import kc.r2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import me.i;
import oc.A0;
import oc.A;
import oc.B;
import oc.C;
import oc.D;
import oc.M;
import oc.O;
import oc.Q;
import oc.S;
import oc.T;
import oc.b0;
import oc.d;
import oc.e0;
import oc.e;
import oc.g0;
import oc.j;
import oc.k0;
import oc.l0;
import oc.o0;
import oc.t0;
import oc.w;
import oc.x;
import oc.y0;
import oc.y;
import oc.z0;
import oc.z;
import pc.t;

public final class n0 implements LocalDownloadablePlaylist, A, B, w, x, y, z, a {
    public final CoroutineDispatcher a;
    public final C0 b;
    public final c c;
    public final LogU d;
    public final Mutex e;
    public boolean f;
    public final MutableStateFlow g;
    public long h;
    public final LinkedList i;
    public final int j;
    public g k;
    public final lc.a l;
    public final h m;
    public final lc.h n;
    public final qc.w o;
    public boolean p;
    public final r2 q;
    public final t r;
    public final o s;

    public n0(CoroutineDispatcher coroutineDispatcher0, C0 c00, c c0, boolean z) {
        q.g(c00, "repository");
        super();
        this.a = coroutineDispatcher0;
        this.b = c00;
        this.c = c0;
        this.d = new LogU("MusicPlaylistImpl");
        this.e = MutexKt.Mutex$default(false, 1, null);
        boolean z1 = MelonSettingInfo.isOfflineModeNP();
        this.g = StateFlowKt.MutableStateFlow(new D0(je.w.a, -1, M.a, false, t0.b, je.w.a, z1));
        this.h = -1L;
        this.i = new LinkedList();
        this.j = 2000;
        this.l = new lc.a("MusicPlaylistImpl");
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        new LogU("MusicPlaylistImpl");
        this.m = h0;
        lc.h h1 = new lc.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        new LogU("MusicPlaylistImpl");
        this.n = h1;
        qc.w w0 = new qc.w();  // 初始化器: Ljava/lang/Object;-><init>()V
        new LogU("MusicPlaylistImpl");
        this.o = w0;
        this.p = z;
        this.q = new r2("MusicPlaylistImpl", new b(this, 0), 6);
        this.r = new t(this, 3);
        this.s = new o(this, PlaylistId.MUSIC, 0);
    }

    @Override  // oc.x
    public final Object A(boolean z, oe.c c0) {
        D d1;
        D d0;
        MutexLockUtil mutexLockUtil0;
        long v4;
        Mutex mutex2;
        v v2;
        String s1;
        String s;
        ne.a a1;
        DevLog devLog1;
        Mutex mutex1;
        boolean z1;
        v v0;
        if(c0 instanceof v) {
            v0 = (v)c0;
            int v1 = v0.N;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(this, c0);
            }
            else {
                v0.N = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(this, c0);
        }
        Object object0 = v0.I;
        ne.a a0 = ne.a.a;
        switch(v0.N) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_onNetworkConnectionChanged"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_onNetworkConnectionChanged", devLog0);
                v0.w = mutex0;
                v0.B = "music_onNetworkConnectionChanged";
                v0.D = devLog0;
                v0.E = "";
                v0.G = mutex0;
                v0.r = z;
                v0.N = 1;
                if(mutex0.lock(null, v0) == a0) {
                    return a0;
                }
                z1 = z;
                mutex1 = mutex0;
                devLog1 = devLog0;
                a1 = a0;
                s = "";
                s1 = "music_onNetworkConnectionChanged";
                v2 = v0;
                mutex2 = mutex1;
                goto label_50;
            }
            case 1: {
                z1 = v0.r;
                Mutex mutex3 = v0.G;
                String s2 = v0.E;
                DevLog devLog2 = v0.D;
                String s3 = v0.B;
                Mutex mutex4 = v0.w;
                n.D(object0);
                devLog1 = devLog2;
                mutex1 = mutex4;
                a1 = a0;
                s = s2;
                v2 = v0;
                mutex2 = mutex3;
                s1 = s3;
                try {
                label_50:
                    v4 = System.currentTimeMillis();
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1);
                    if(!((D0)this.g.getValue()).g) {
                        goto label_82;
                    }
                    if(this.p == z1) {
                        LogU.debug$default(this.d, "onNetworkConnectionChanged() skipped because already isConnected: " + z1, null, false, 6, null);
                        d0 = new D("Already isConnected: " + z1);
                        goto label_59;
                    }
                    goto label_64;
                }
                catch(Throwable throwable0) {
                    goto label_86;
                }
                finally {
                    mutex2.unlock(null);
                }
            label_59:
                long v5 = System.currentTimeMillis() - v4;
                LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v5 + "ms)", null, false, 6, null);
                devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v5 + "ms)");
                return d0;
                try {
                label_64:
                    this.p = z1;
                    LogU.debug$default(this.d, "onConnectionChanged() isConnected: " + z1, null, false, 6, null);
                }
                catch(Throwable throwable0) {
                    goto label_86;
                }
                long v6 = System.currentTimeMillis() - v4;
                LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v6 + "ms)", null, false, 6, null);
                devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v6 + "ms)");
                v2.w = null;
                v2.B = null;
                v2.D = null;
                v2.E = null;
                v2.G = null;
                v2.r = z1;
                v2.N = 2;
                object0 = this.P("onNetworkConnectionChanged", v2);
                if(object0 == a1) {
                    return a1;
                    try {
                    label_82:
                        LogU.debug$default(this.d, "onNetworkConnectionChanged() skipped because not in offline mode", null, false, 6, null);
                        d1 = new D();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    catch(Throwable throwable0) {
                    label_86:
                        long v7 = System.currentTimeMillis() - v4;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v7 + "ms)", null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v7 + "ms)");
                        throw throwable0;
                    }
                    long v8 = System.currentTimeMillis() - v4;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v8 + "ms)");
                    return d1;
                }
                goto label_97;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
    label_97:
        if(((D0)object0) != null) {
            LogU.debug$default(this.d, "onNetworkConnectionChanged() updated album image", null, false, 6, null);
            return new C(((D0)object0));
        }
        LogU.debug$default(this.d, "onNetworkConnectionChanged() skipped because no updated song", null, false, 6, null);
        return new D();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.w
    public final Object B(Continuation continuation0) {
        long v4;
        j j1;
        DevLog devLog4;
        Mutex mutex7;
        String s5;
        Mutex mutex6;
        String s4;
        j j0;
        Mutex mutex5;
        DevLog devLog3;
        String s3;
        long v3;
        int v2;
        DevLog devLog1;
        String s1;
        String s;
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        u u0;
        if(continuation0 instanceof u) {
            u0 = (u)continuation0;
            int v = u0.V;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, ((oe.c)continuation0));
            }
            else {
                u0.V = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, ((oe.c)continuation0));
        }
        Object object0 = u0.S;
        ne.a a0 = ne.a.a;
        switch(u0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_nextWhenPlayCompleted"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_nextWhenPlayCompleted", devLog0);
                u0.r = mutex0;
                u0.w = "music_nextWhenPlayCompleted";
                u0.B = devLog0;
                u0.D = "";
                u0.E = mutex0;
                u0.I = 0;
                u0.M = 0;
                u0.V = 1;
                if(mutex0.lock(null, u0) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    mutex2 = mutex1;
                    s = "music_nextWhenPlayCompleted";
                    s1 = "";
                    devLog1 = devLog0;
                    v2 = 0;
                    goto label_49;
                }
                return a0;
            }
            case 1: {
                v2 = u0.M;
                v1 = u0.I;
                Mutex mutex3 = u0.E;
                Object object1 = u0.D;
                DevLog devLog2 = u0.B;
                String s2 = u0.w;
                Mutex mutex4 = u0.r;
                n.D(object0);
                s = s2;
                mutex1 = mutex3;
                devLog1 = devLog2;
                s1 = object1;
                mutex2 = mutex4;
                try {
                label_49:
                    v3 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    s3 = s1;
                    devLog3 = devLog1;
                    mutex5 = mutex2;
                    j0 = this.G();
                    u0.r = mutex2;
                    u0.w = s;
                    u0.B = devLog1;
                    u0.D = s1;
                    u0.E = mutex1;
                    u0.G = j0;
                    u0.I = v1;
                    u0.M = v2;
                    u0.N = v3;
                    u0.V = 2;
                    s3 = s1;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    if(this.L(j0.a, 0L, false, "next", true, u0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    s4 = s;
                    mutex6 = mutex1;
                    s5 = s3;
                    mutex7 = mutex5;
                    devLog4 = devLog3;
                    goto label_98;
                }
                j1 = j0;
                s4 = s;
                v4 = v3;
                mutex6 = mutex1;
                s5 = s3;
                mutex7 = mutex5;
                devLog4 = devLog3;
                goto label_102;
            }
            case 2: {
                try {
                    v4 = u0.N;
                    j1 = u0.G;
                    mutex6 = u0.E;
                    s5 = u0.D;
                    devLog4 = u0.B;
                    s4 = u0.w;
                    mutex7 = u0.r;
                    n.D(object0);
                    goto label_102;
                }
                catch(Throwable throwable0) {
                    v3 = v4;
                }
                try {
                label_98:
                    long v5 = System.currentTimeMillis() - v3;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v5 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v5 + "ms)");
                    throw throwable0;
                label_102:
                    long v6 = System.currentTimeMillis() - v4;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v6 + "ms)");
                    goto label_109;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex6.unlock(null);
        throw throwable1;
    label_109:
        mutex6.unlock(null);
        return j1;
    }

    @Override  // oc.H
    public final AddPosition C() {
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        q.f(addPosition0, "getPlayListAddPosition(...)");
        return addPosition0;
    }

    public final oc.t D(int v, int v1, D0 d00) {
        if(!q.b(((D0)this.g.getValue()).e, t0.b)) {
            return new oc.t("Not MyPreference Sort");
        }
        this.n.getClass();
        if(lc.h.i(d00)) {
            return new oc.t("In Select Repeat Mode");
        }
        this.l.getClass();
        return lc.a.a(v, v1, d00);
    }

    public final S E(List list0, D0 d00) {
        this.n.getClass();
        if(lc.h.i(d00) && (!(list0 instanceof Collection) || !list0.isEmpty())) {
            for(Object object0: list0) {
                if(lc.h.a(((Number)object0).intValue(), d00)) {
                    return new S("Can\'t Remove Select Repeat Song", false);
                }
                if(false) {
                    break;
                }
            }
        }
        this.l.getClass();
        return lc.a.b(list0, d00);
    }

    public final Object F(boolean z, oe.c c0) {
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.B;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.B = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.r;
        ne.a a0 = ne.a.a;
        switch(k0.B) {
            case 0: {
                n.D(object0);
                m m0 = new m(null, this, z);
                k0.B = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, m0, k0) == a0 ? a0 : d.a;
            }
            case 1: {
                n.D(object0);
                return d.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final j G() {
        D0 d00 = (D0)this.g.getValue();
        this.n.getClass();
        boolean z = lc.h.i(d00);
        int v = d00.b;
        if(z) {
            return new j(lc.h.c(d00), true);
        }
        g g0 = this.k;
        h h0 = this.m;
        if(g0 != null) {
            if(d00.c == M.b && g0.s(v)) {
                this.k = this.k == null ? null : this.k.b(v);
            }
            b b0 = new b(this, 1);
            g g1 = this.k;
            q.d(g1);
            boolean z1 = g1.s(v);
            h0.getClass();
            return h.q(d00, b0, z1);
        }
        b b1 = new b(this, 2);
        this.l.getClass();
        boolean z2 = lc.a.f(v, d00);
        h0.getClass();
        return h.q(d00, b1, z2);
    }

    public final D0 H() {
        return (D0)this.g.getValue();
    }

    public final Object I(int v, int v1, boolean z, oe.c c0) {
        qc.q q0;
        if(c0 instanceof qc.q) {
            q0 = (qc.q)c0;
            int v2 = q0.B;
            if((v2 & 0x80000000) == 0) {
                q0 = new qc.q(this, c0);
            }
            else {
                q0.B = v2 ^ 0x80000000;
            }
        }
        else {
            q0 = new qc.q(this, c0);
        }
        Object object0 = q0.r;
        ne.a a0 = ne.a.a;
        switch(q0.B) {
            case 0: {
                n.D(object0);
                s s0 = new s(this, v, v1, z, null);
                q0.B = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, s0, q0);
                return object0 == a0 ? a0 : new oc.u(((D0)object0));
            }
            case 1: {
                n.D(object0);
                return new oc.u(((D0)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object J(List list0, boolean z, oe.c c0) {
        j j1;
        H h3;
        kotlin.jvm.internal.C c7;
        int v1;
        kotlin.jvm.internal.C c5;
        kotlin.jvm.internal.C c4;
        H h1;
        boolean z1;
        qc.C c1;
        if(c0 instanceof qc.C) {
            c1 = (qc.C)c0;
            int v = c1.N;
            if((v & 0x80000000) == 0) {
                c1 = new qc.C(this, c0);
            }
            else {
                c1.N = v ^ 0x80000000;
            }
        }
        else {
            c1 = new qc.C(this, c0);
        }
        Object object0 = c1.I;
        ne.a a0 = ne.a.a;
        switch(c1.N) {
            case 0: {
                H h0 = H0.b.p(object0);
                h0.a = new ArrayList();
                kotlin.jvm.internal.C c2 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
                kotlin.jvm.internal.C c3 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
                z1 = z;
                E e0 = new E(this, list0, h0, c2, c3, z1, null);
                c1.r = h0;
                c1.w = c2;
                c1.B = c3;
                c1.E = z1;
                c1.G = 0;
                c1.N = 1;
                if(BuildersKt.withContext(NonCancellable.INSTANCE, e0, c1) == a0) {
                    return a0;
                }
                h1 = h0;
                c4 = c2;
                c5 = c3;
                v1 = 0;
                goto label_40;
            }
            case 1: {
                v1 = c1.G;
                boolean z2 = c1.E;
                c5 = c1.B;
                kotlin.jvm.internal.C c6 = c1.w;
                H h2 = c1.r;
                n.D(object0);
                c4 = c6;
                h1 = h2;
                z1 = z2;
            label_40:
                if(!e1.b.D(this.H()) && c5.a) {
                    j j0 = this.G();
                    c1.r = h1;
                    c1.w = c4;
                    c1.B = null;
                    c1.D = j0;
                    c1.E = z1;
                    c1.G = v1;
                    c1.N = 2;
                    if(this.L(j0.a, 0L, false, "remove", z1, c1) == a0) {
                        return a0;
                    }
                    c7 = c4;
                    h3 = h1;
                    j1 = j0;
                    v1 = !j1.b;
                    c4 = c7;
                    h1 = h3;
                    break;
                }
                break;
            }
            case 2: {
                j1 = c1.D;
                c7 = c1.w;
                h3 = c1.r;
                n.D(object0);
                v1 = !j1.b;
                c4 = c7;
                h1 = h3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        List list1 = (List)h1.a;
        boolean z3 = c4.a;
        return v1 == 0 ? new T(list1, z3, false, ((Q)this.g.getValue()), this.h) : new T(list1, z3, true, ((Q)this.g.getValue()), this.h);
    }

    public final Object K(oe.c c0) {
        String s3;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        int v2;
        Mutex mutex2;
        Mutex mutex1;
        int v1;
        String s1;
        String s;
        DevLog devLog1;
        F f0;
        if(c0 instanceof F) {
            f0 = (F)c0;
            int v = f0.T;
            if((v & 0x80000000) == 0) {
                f0 = new F(this, c0);
            }
            else {
                f0.T = v ^ 0x80000000;
            }
        }
        else {
            f0 = new F(this, c0);
        }
        Object object0 = f0.N;
        ne.a a0 = ne.a.a;
        switch(f0.T) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_restore"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_restore", devLog0);
                f0.r = mutex0;
                f0.w = "music_restore";
                f0.B = devLog0;
                f0.D = "";
                f0.E = mutex0;
                f0.G = 0;
                f0.I = 0;
                f0.T = 1;
                if(mutex0.lock(null, f0) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                s = "music_restore";
                s1 = "";
                v1 = 0;
                mutex1 = mutex0;
                mutex2 = mutex1;
                v2 = 0;
                goto label_50;
            }
            case 1: {
                int v3 = f0.I;
                int v4 = f0.G;
                mutex2 = f0.E;
                Object object1 = f0.D;
                DevLog devLog2 = f0.B;
                String s2 = f0.w;
                Mutex mutex3 = f0.r;
                n.D(object0);
                mutex1 = mutex3;
                v2 = v3;
                devLog1 = devLog2;
                s1 = object1;
                s = s2;
                v1 = v4;
                try {
                label_50:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                        qc.H h0 = new qc.H(this, null);
                        f0.r = mutex1;
                        f0.w = s;
                        f0.B = devLog1;
                        f0.D = s1;
                        f0.E = mutex2;
                        f0.G = v1;
                        f0.I = v2;
                        f0.M = v5;
                        f0.T = 2;
                        if(BuildersKt.withContext(NonCancellable.INSTANCE, h0, f0) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v6 = v5;
                        goto label_86;
                    }
                    mutex4 = mutex1;
                    v6 = v5;
                    mutex5 = mutex2;
                    s3 = s;
                    break;
                    try {
                    label_75:
                        v6 = f0.M;
                        mutex5 = f0.E;
                        s1 = f0.D;
                        devLog1 = f0.B;
                        s3 = f0.w;
                        mutex4 = f0.r;
                        n.D(object0);
                        break;
                    }
                    catch(Throwable throwable1) {
                        s = s3;
                        mutex2 = mutex5;
                    }
                label_86:
                    long v7 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)");
                    throw throwable1;
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
            }
            case 2: {
                goto label_75;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v8 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw throwable0;
        }
        mutex5.unlock(null);
        return ie.H.a;
    }

    public final Object L(int v, long v1, boolean z, String s, boolean z1, oe.c c0) {
        K k0;
        if(c0 instanceof K) {
            k0 = (K)c0;
            int v2 = k0.D;
            if((v2 & 0x80000000) == 0) {
                k0 = new K(this, c0);
            }
            else {
                k0.D = v2 ^ 0x80000000;
            }
        }
        else {
            k0 = new K(this, c0);
        }
        Object object0 = k0.w;
        ne.a a0 = ne.a.a;
        switch(k0.D) {
            case 0: {
                n.D(object0);
                qc.M m0 = new qc.M(this, z, v, v1, z1, s, null);
                k0.r = v1;
                k0.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, m0, k0);
                return object0 == a0 ? a0 : new e0(((D0)object0), v1);
            }
            case 1: {
                long v3 = k0.r;
                n.D(object0);
                return new e0(((D0)object0), v3);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object M(M m0, oe.c c0) {
        qc.S s0;
        if(c0 instanceof qc.S) {
            s0 = (qc.S)c0;
            int v = s0.D;
            if((v & 0x80000000) == 0) {
                s0 = new qc.S(this, c0);
            }
            else {
                s0.D = v ^ 0x80000000;
            }
        }
        else {
            s0 = new qc.S(this, c0);
        }
        Object object0 = s0.w;
        ne.a a0 = ne.a.a;
        switch(s0.D) {
            case 0: {
                n.D(object0);
                U u0 = new U(this, m0, null);
                s0.r = m0;
                s0.D = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, u0, s0) == a0 ? a0 : new Success(m0);
            }
            case 1: {
                m0 = s0.r;
                n.D(object0);
                return new Success(m0);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object N(List list0, boolean z, oe.c c0) {
        W w0;
        if(c0 instanceof W) {
            w0 = (W)c0;
            int v = w0.D;
            if((v & 0x80000000) == 0) {
                w0 = new W(this, c0);
            }
            else {
                w0.D = v ^ 0x80000000;
            }
        }
        else {
            w0 = new W(this, c0);
        }
        Object object0 = w0.w;
        ne.a a0 = ne.a.a;
        switch(w0.D) {
            case 0: {
                n.D(object0);
                kotlin.jvm.internal.C c1 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
                c1.a = true;
                qc.Y y0 = new qc.Y(this, list0, c1, z, null);
                w0.r = c1;
                w0.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, y0, w0);
                return object0 == a0 ? a0 : new k0(((D0)object0), this.h, c1.a);
            }
            case 1: {
                kotlin.jvm.internal.C c2 = w0.r;
                n.D(object0);
                return new k0(((D0)object0), this.h, c2.a);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object O(boolean z, oe.c c0) {
        a0 a00;
        if(c0 instanceof a0) {
            a00 = (a0)c0;
            int v = a00.D;
            if((v & 0x80000000) == 0) {
                a00 = new a0(this, c0);
            }
            else {
                a00.D = v ^ 0x80000000;
            }
        }
        else {
            a00 = new a0(this, c0);
        }
        Object object0 = a00.w;
        ne.a a0 = ne.a.a;
        switch(a00.D) {
            case 0: {
                n.D(object0);
                c0 c00 = new c0(null, this, z);
                a00.r = z;
                a00.D = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, c00, a00) == a0 ? a0 : new com.melon.playlist.interfaces.SetShuffleResult.Success(z);
            }
            case 1: {
                z = a00.r;
                n.D(object0);
                return new com.melon.playlist.interfaces.SetShuffleResult.Success(z);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object P(String s, oe.c c0) {
        D0 d00;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        Object object3;
        int v2;
        Mutex mutex1;
        String s2;
        String s1;
        DevLog devLog1;
        int v1;
        Mutex mutex0;
        i0 i00;
        if(c0 instanceof i0) {
            i00 = (i0)c0;
            int v = i00.V;
            if((v & 0x80000000) == 0) {
                i00 = new i0(this, c0);
            }
            else {
                i00.V = v ^ 0x80000000;
            }
        }
        else {
            i00 = new i0(this, c0);
        }
        Object object0 = i00.S;
        ne.a a0 = ne.a.a;
        switch(i00.V) {
            case 0: {
                n.D(object0);
                ArrayList arrayList0 = e1.b.B(this.H());
                ArrayList arrayList1 = new ArrayList();
                for(Object object1: arrayList0) {
                    if(!((Playable)object1).isOriginLocal()) {
                        arrayList1.add(object1);
                    }
                }
                if(arrayList1.isEmpty()) {
                    return null;
                }
                i00.r = s;
                i00.V = 1;
                if(this.q.e(arrayList1, s, i00) == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                s = i00.r;
                n.D(object0);
            label_30:
                mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), H0.b.f(mutex0.hashCode(), "Lock[", "]  try : ", "music_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("music_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s));
                i00.r = null;
                i00.w = mutex0;
                i00.B = "music_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s;
                i00.D = devLog0;
                i00.E = "";
                i00.G = mutex0;
                v1 = 0;
                i00.I = 0;
                i00.M = 0;
                i00.V = 2;
                if(mutex0.lock(null, i00) != a0) {
                    devLog1 = devLog0;
                    s1 = "";
                    s2 = "music_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s;
                    mutex1 = mutex0;
                    v2 = 0;
                    goto label_67;
                }
                return a0;
            }
            case 2: {
                int v3 = i00.I;
                Mutex mutex2 = i00.G;
                Object object2 = i00.E;
                DevLog devLog2 = i00.D;
                String s3 = i00.B;
                int v4 = i00.M;
                Mutex mutex3 = i00.w;
                n.D(object0);
                mutex0 = mutex2;
                devLog1 = devLog2;
                s1 = object2;
                s2 = s3;
                v1 = v3;
                mutex1 = mutex3;
                v2 = v4;
                try {
                label_67:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s2, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s2);
                        j0 j00 = new j0(this, null);
                        i00.r = null;
                        i00.w = mutex1;
                        i00.B = s2;
                        i00.D = devLog1;
                        i00.E = s1;
                        i00.G = mutex0;
                        i00.I = v1;
                        i00.M = v2;
                        i00.N = v5;
                        i00.V = 3;
                        object3 = this.Q(j00, i00);
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v6 = v5;
                        goto label_105;
                    }
                    if(object3 == a0) {
                        return a0;
                    }
                    mutex5 = mutex0;
                    mutex4 = mutex1;
                    v6 = v5;
                    object0 = object3;
                    d00 = (D0)object0;
                    goto label_111;
                    try {
                    label_94:
                        v6 = i00.N;
                        mutex5 = i00.G;
                        s1 = i00.E;
                        devLog1 = i00.D;
                        s2 = i00.B;
                        mutex4 = i00.w;
                        n.D(object0);
                        d00 = (D0)object0;
                        goto label_111;
                    }
                    catch(Throwable throwable1) {
                        mutex0 = mutex5;
                    }
                label_105:
                    long v7 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v7 + "ms)");
                    throw throwable1;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 3: {
                goto label_94;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex0.unlock(null);
        throw throwable0;
        try {
        label_111:
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v8 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex0 = mutex5;
            mutex0.unlock(null);
            throw throwable0;
        }
        mutex5.unlock(null);
        return d00;
    }

    public final Object Q(we.n n0, Continuation continuation0) {
        m0 m00;
        if(continuation0 instanceof m0) {
            m00 = (m0)continuation0;
            int v = m00.B;
            if((v & 0x80000000) == 0) {
                m00 = new m0(this, continuation0);
            }
            else {
                m00.B = v ^ 0x80000000;
            }
        }
        else {
            m00 = new m0(this, continuation0);
        }
        Object object0 = m00.r;
        ne.a a0 = ne.a.a;
        MutableStateFlow mutableStateFlow0 = this.g;
        switch(m00.B) {
            case 0: {
                n.D(object0);
                Object object1 = mutableStateFlow0.getValue();
                m00.B = 1;
                object0 = n0.invoke(object1, m00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutableStateFlow0.setValue(((D0)object0));
        return (D0)object0;
    }

    @Override  // oc.w
    public final Object a(String s, Continuation continuation0) {
        Mutex mutex2;
        String s3;
        String s2;
        Mutex mutex1;
        String s1;
        DevLog devLog0;
        qc.y y0;
        if(continuation0 instanceof qc.y) {
            y0 = (qc.y)continuation0;
            int v = y0.N;
            if((v & 0x80000000) == 0) {
                y0 = new qc.y(this, ((oe.c)continuation0));
            }
            else {
                y0.N = v ^ 0x80000000;
            }
        }
        else {
            y0 = new qc.y(this, ((oe.c)continuation0));
        }
        Object object0 = y0.I;
        ne.a a0 = ne.a.a;
        switch(y0.N) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_processAfterLogging"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_processAfterLogging", devLog0);
                y0.r = s;
                y0.w = mutex0;
                s1 = "music_processAfterLogging";
                y0.B = "music_processAfterLogging";
                y0.D = devLog0;
                y0.E = "";
                y0.G = mutex0;
                y0.N = 1;
                if(mutex0.lock(null, y0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                s2 = s;
                s3 = "";
                mutex2 = mutex1;
                break;
            }
            case 1: {
                mutex1 = y0.G;
                s3 = y0.E;
                devLog0 = y0.D;
                s1 = y0.B;
                mutex2 = y0.w;
                s2 = y0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object1 = null;
        try {
            long v2 = System.currentTimeMillis();
            try {
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s3 + " Lock obtain : " + s1, null, false, 6, null);
                devLog0.put("Lock[" + mutex2.hashCode() + "] " + s3 + " Lock obtain : " + s1);
                for(Object object2: this.i) {
                    if(q.b("", s2)) {
                        object1 = object2;
                        break;
                    }
                }
            }
            finally {
                long v4 = System.currentTimeMillis() - v2;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v4 + "ms)", null, false, 6, null);
                devLog0.put("Lock[" + mutex2.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v4 + "ms)");
            }
        }
        finally {
            mutex1.unlock(null);
        }
        if(((Playable)object1) != null) {
            ((Playable)object1).setMenuid("1000000558");
            ((Playable)object1).setPlayCount(((Playable)object1).getPlayCount() + 1);
            List list0 = e.k.z(((Playable)object1));
            this.b.h("processAfterLogging", list0);
            return ie.H.a;
        }
        LogU.error$default(this.d, "processAfterLogging() failed. trackId: " + s2, null, false, 6, null);
        return ie.H.a;
    }

    @Override  // oc.H
    public final Object b(oe.c c0) {
        D0 d00;
        long v2;
        String s1;
        String s;
        DevLog devLog1;
        Mutex mutex2;
        Mutex mutex1;
        qc.n n0;
        if(c0 instanceof qc.n) {
            n0 = (qc.n)c0;
            int v = n0.M;
            if((v & 0x80000000) == 0) {
                n0 = new qc.n(this, c0);
            }
            else {
                n0.M = v ^ 0x80000000;
            }
        }
        else {
            n0 = new qc.n(this, c0);
        }
        Object object0 = n0.G;
        ne.a a0 = ne.a.a;
        switch(n0.M) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_getStateSafely"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_getStateSafely", devLog0);
                n0.r = mutex0;
                n0.w = "music_getStateSafely";
                n0.B = devLog0;
                n0.D = "";
                n0.E = mutex0;
                n0.M = 1;
                if(mutex0.lock(null, n0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                mutex2 = mutex1;
                devLog1 = devLog0;
                s = "music_getStateSafely";
                s1 = "";
                break;
            }
            case 1: {
                mutex2 = n0.E;
                s1 = n0.D;
                devLog1 = n0.B;
                s = n0.w;
                mutex1 = n0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v2 = System.currentTimeMillis();
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
            d00 = (D0)this.g.getValue();
        }
        catch(Throwable throwable0) {
            long v3 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)");
            throw throwable0;
        }
        finally {
            mutex2.unlock(null);
        }
        long v4 = System.currentTimeMillis() - v2;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v4 + "ms)", null, false, 6, null);
        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v4 + "ms)");
        return d00;
    }

    @Override  // oc.z
    public final Object c(List list0, oe.c c0) {
        Mutex mutex7;
        long v6;
        Mutex mutex6;
        Mutex mutex5;
        Mutex mutex4;
        l0 l00;
        Mutex mutex3;
        LogU logU0;
        long v5;
        int v3;
        DevLog devLog1;
        Mutex mutex2;
        List list1;
        String s1;
        String s;
        Mutex mutex1;
        int v2;
        V v0;
        if(c0 instanceof V) {
            v0 = (V)c0;
            int v1 = v0.V;
            if((v1 & 0x80000000) == 0) {
                v0 = new V(this, c0);
            }
            else {
                v0.V = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new V(this, c0);
        }
        Object object0 = v0.S;
        ne.a a0 = ne.a.a;
        switch(v0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_setSelectRepeat"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_setSelectRepeat", devLog0);
                v0.r = list0;
                v0.w = mutex0;
                v0.B = "music_setSelectRepeat";
                v0.D = devLog0;
                v0.E = "";
                v0.G = mutex0;
                v2 = 0;
                v0.I = 0;
                v0.M = 0;
                v0.V = 1;
                if(mutex0.lock(null, v0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                s = "music_setSelectRepeat";
                s1 = "";
                list1 = list0;
                mutex2 = mutex1;
                devLog1 = devLog0;
                v3 = 0;
                goto label_50;
            }
            case 1: {
                v3 = v0.M;
                int v4 = v0.I;
                mutex1 = v0.G;
                s1 = v0.E;
                DevLog devLog2 = v0.D;
                String s2 = v0.B;
                mutex2 = v0.w;
                list1 = v0.r;
                n.D(object0);
                s = s2;
                devLog1 = devLog2;
                v2 = v4;
                try {
                label_50:
                    v5 = System.currentTimeMillis();
                    logU0 = MutexLockUtil.INSTANCE.getLog();
                }
                catch(Throwable throwable0) {
                    mutex3 = mutex2;
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v6 = v5;
                    goto label_109;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    O o0 = (O)this.g.getValue();
                    try {
                        this.n.getClass();
                        l00 = lc.h.b(list1, o0);
                    }
                    catch(Throwable throwable0) {
                        mutex3 = mutex2;
                        mutex5 = mutex3;
                        mutex6 = mutex1;
                        v6 = v5;
                        goto label_109;
                    }
                    if(l00 == null) {
                        v0.r = null;
                        mutex3 = mutex2;
                        goto label_75;
                    }
                    else {
                        mutex4 = mutex1;
                        mutex5 = mutex2;
                    }
                    goto label_116;
                }
                catch(Throwable throwable0) {
                    mutex3 = mutex2;
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v6 = v5;
                    goto label_109;
                }
                try {
                label_75:
                    v0.w = mutex3;
                    v0.B = s;
                    v0.D = devLog1;
                    v0.E = s1;
                    v0.G = mutex1;
                    v0.I = v2;
                    v0.M = v3;
                    v0.N = v5;
                    v0.V = 2;
                    object0 = this.N(list1, true, v0);
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v6 = v5;
                    goto label_109;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex5 = mutex3;
                mutex6 = mutex1;
                v6 = v5;
                mutex4 = mutex6;
                v5 = v6;
                l00 = (l0)object0;
                goto label_116;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v6 = v0.N;
            mutex6 = v0.G;
            s1 = v0.E;
            devLog1 = v0.D;
            s = v0.B;
            mutex5 = v0.w;
            n.D(object0);
            mutex4 = mutex6;
            v5 = v6;
            l00 = (l0)object0;
            goto label_116;
        }
        catch(Throwable throwable0) {
        }
        try {
        label_109:
            long v7 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex7 = mutex6;
            mutex7.unlock(null);
            throw throwable1;
        }
        try {
        label_116:
            long v8 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex7 = mutex4;
            mutex7.unlock(null);
            throw throwable1;
        }
        mutex4.unlock(null);
        return l00;
    }

    @Override  // oc.H
    public final MutableStateFlow d() {
        return this.g;
    }

    @Override  // oc.z
    public final O e() {
        return (D0)this.g.getValue();
    }

    public static final Object f(n0 n00, oe.c c0) {
        qc.A a0;
        if(c0 instanceof qc.A) {
            a0 = (qc.A)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new qc.A(n00, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new qc.A(n00, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                qc.B b0 = new qc.B(n00, null);
                a0.B = 1;
                object0 = n00.Q(b0, a0);
                if(object0 == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        D0 d00 = (D0)object0;
        return ie.H.a;
    }

    @Override  // oc.w
    public final Object g(Continuation continuation0) {
        oc.g g0;
        long v5;
        DevLog devLog4;
        String s5;
        Mutex mutex7;
        Mutex mutex6;
        String s4;
        int v4;
        Mutex mutex5;
        DevLog devLog3;
        String s3;
        long v3;
        int v2;
        DevLog devLog1;
        String s1;
        String s;
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        qc.t t0;
        if(continuation0 instanceof qc.t) {
            t0 = (qc.t)continuation0;
            int v = t0.V;
            if((v & 0x80000000) == 0) {
                t0 = new qc.t(this, ((oe.c)continuation0));
            }
            else {
                t0.V = v ^ 0x80000000;
            }
        }
        else {
            t0 = new qc.t(this, ((oe.c)continuation0));
        }
        Object object0 = t0.S;
        ne.a a0 = ne.a.a;
        switch(t0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_next"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_next", devLog0);
                t0.r = mutex0;
                t0.w = "music_next";
                t0.B = devLog0;
                t0.D = "";
                t0.E = mutex0;
                t0.G = 0;
                t0.I = 0;
                t0.V = 1;
                if(mutex0.lock(null, t0) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    mutex2 = mutex1;
                    s = "music_next";
                    s1 = "";
                    devLog1 = devLog0;
                    v2 = 0;
                    goto label_49;
                }
                return a0;
            }
            case 1: {
                v2 = t0.I;
                v1 = t0.G;
                Mutex mutex3 = t0.E;
                Object object1 = t0.D;
                DevLog devLog2 = t0.B;
                String s2 = t0.w;
                Mutex mutex4 = t0.r;
                n.D(object0);
                s = s2;
                mutex1 = mutex3;
                devLog1 = devLog2;
                s1 = object1;
                mutex2 = mutex4;
                try {
                label_49:
                    v3 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    s3 = s1;
                    devLog3 = devLog1;
                    mutex5 = mutex2;
                    v4 = this.p();
                    t0.r = mutex2;
                    t0.w = s;
                    t0.B = devLog1;
                    t0.D = s1;
                    t0.E = mutex1;
                    t0.G = v1;
                    t0.I = v2;
                    t0.N = v3;
                    t0.M = v4;
                    t0.V = 2;
                    mutex5 = mutex2;
                    s3 = s1;
                    devLog3 = devLog1;
                    if(this.L(v4, 0L, false, "next", true, t0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    s4 = s;
                    mutex6 = mutex1;
                    mutex7 = mutex5;
                    s5 = s3;
                    devLog4 = devLog3;
                    goto label_98;
                }
                s4 = s;
                v5 = v3;
                mutex6 = mutex1;
                mutex7 = mutex5;
                s5 = s3;
                devLog4 = devLog3;
                g0 = new oc.g(v4);
                goto label_102;
            }
            case 2: {
                try {
                    v4 = t0.M;
                    v5 = t0.N;
                    mutex6 = t0.E;
                    s5 = t0.D;
                    devLog4 = t0.B;
                    s4 = t0.w;
                    mutex7 = t0.r;
                    n.D(object0);
                    g0 = new oc.g(v4);
                    goto label_102;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v3 = v5;
        try {
        label_98:
            long v6 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v6 + "ms)");
            throw throwable0;
        label_102:
            long v7 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v7 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v7 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex6.unlock(null);
            throw throwable1;
        }
        mutex6.unlock(null);
        return g0;
    }

    @Override  // oc.H
    public final PlaylistId getId() {
        return PlaylistId.MUSIC;
    }

    @Override  // oc.H
    public final String getMenuId() {
        return "1000000558";
    }

    @Override  // oc.H
    public final Q getState() {
        return this.H();
    }

    @Override  // oc.w
    public final Object h(String s, boolean z, we.n n0, oe.c c0) {
        A0 a00;
        List list1;
        String s12;
        z0 z00;
        Mutex mutex10;
        List list0;
        Mutex mutex9;
        Mutex mutex8;
        String s10;
        DevLog devLog3;
        Object object3;
        Mutex mutex7;
        long v11;
        int v9;
        String s9;
        int v8;
        DevLog devLog2;
        String s8;
        int v7;
        boolean z3;
        ne.a a1;
        int v6;
        Mutex mutex6;
        String s7;
        String s6;
        Object object2;
        Mutex mutex5;
        long v5;
        int v2;
        Mutex mutex2;
        int v1;
        we.n n1;
        Mutex mutex1;
        String s3;
        String s2;
        boolean z1;
        String s1;
        DevLog devLog0;
        qc.k0 k00;
        if(c0 instanceof qc.k0) {
            k00 = (qc.k0)c0;
            int v = k00.b0;
            if((v & 0x80000000) == 0) {
                k00 = new qc.k0(this, c0);
            }
            else {
                k00.b0 = v ^ 0x80000000;
            }
        }
        else {
            k00 = new qc.k0(this, c0);
        }
        Object object0 = k00.Y;
        ne.a a0 = ne.a.a;
        switch(k00.b0) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), H0.b.f(mutex0.hashCode(), "Lock[", "]  try : ", "music_" + ("updatePlayable-" + s)), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("music_" + ("updatePlayable-" + s)));
                k00.r = n0;
                k00.w = "updatePlayable-" + s;
                k00.B = mutex0;
                k00.D = "music_" + ("updatePlayable-" + s);
                k00.E = devLog0;
                s1 = "";
                k00.G = "";
                k00.I = mutex0;
                z1 = z;
                k00.N = z1;
                k00.S = 0;
                k00.T = 0;
                k00.b0 = 1;
                if(mutex0.lock(null, k00) == a0) {
                    return a0;
                }
                s2 = "music_" + ("updatePlayable-" + s);
                s3 = "updatePlayable-" + s;
                mutex1 = mutex0;
                n1 = n0;
                v1 = 0;
                mutex2 = mutex1;
                v2 = 0;
                goto label_61;
            }
            case 1: {
                int v3 = k00.S;
                boolean z2 = k00.N;
                Mutex mutex3 = k00.I;
                Object object1 = k00.G;
                DevLog devLog1 = k00.E;
                String s4 = k00.D;
                int v4 = k00.T;
                Mutex mutex4 = k00.B;
                String s5 = k00.w;
                n1 = k00.r;
                n.D(object0);
                v1 = v3;
                s3 = s5;
                s2 = s4;
                s1 = object1;
                z1 = z2;
                mutex2 = mutex3;
                devLog0 = devLog1;
                v2 = v4;
                mutex1 = mutex4;
                try {
                label_61:
                    v5 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s2, null, false, 6, null);
                    devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s2);
                    mutex5 = mutex1;
                    ArrayList arrayList0 = e1.b.B(((Q)this.g.getValue()));
                    k00.r = null;
                    k00.w = s3;
                    k00.B = mutex1;
                    k00.D = s2;
                    k00.E = devLog0;
                    k00.G = s1;
                    k00.I = mutex2;
                    k00.N = z1;
                    k00.S = v1;
                    k00.T = v2;
                    mutex5 = mutex1;
                    k00.V = 0;
                    k00.X = v5;
                    k00.W = 0;
                    k00.b0 = 2;
                    object2 = n1.invoke(arrayList0, k00);
                }
                catch(Throwable throwable1) {
                    s6 = s1;
                    s7 = s2;
                    mutex9 = mutex5;
                    goto label_215;
                }
                if(object2 == a0) {
                    return a0;
                }
                mutex6 = mutex2;
                v6 = v1;
                a1 = a0;
                z3 = z1;
                v7 = 0;
                s8 = s2;
                devLog2 = devLog0;
                v8 = v2;
                s9 = s3;
                v9 = 0;
                goto label_135;
            }
            case 2: {
                try {
                    int v10 = k00.W;
                    v11 = k00.X;
                    int v12 = k00.T;
                    int v13 = k00.S;
                    boolean z4 = k00.N;
                    int v14 = k00.V;
                    mutex7 = k00.I;
                    object3 = k00.G;
                    devLog3 = k00.E;
                    s10 = k00.D;
                    mutex8 = k00.B;
                    String s11 = k00.w;
                    n.D(object0);
                    mutex5 = mutex8;
                    a1 = a0;
                    z3 = z4;
                    mutex6 = mutex7;
                    v5 = v11;
                    v8 = v12;
                    v9 = v10;
                    v6 = v13;
                    s8 = s10;
                    v7 = v14;
                    s1 = object3;
                    s9 = s11;
                    object2 = object0;
                    devLog2 = devLog3;
                }
                catch(Throwable throwable1) {
                    mutex2 = mutex7;
                    s6 = object3;
                    mutex9 = mutex8;
                    devLog0 = devLog3;
                    s7 = s10;
                    break;
                }
                try {
                label_135:
                    list0 = (List)object2;
                    if(list0.isEmpty()) {
                        goto label_142;
                    }
                    goto label_161;
                }
                catch(Throwable throwable1) {
                    v11 = v5;
                    mutex10 = mutex5;
                    goto label_183;
                }
                try {
                label_142:
                    LogU.debug$default(this.d, s9 + ", no updated items", null, false, 6, null);
                    z00 = new z0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    goto label_152;
                }
                catch(Throwable throwable1) {
                    mutex2 = mutex6;
                    s6 = s1;
                    devLog0 = devLog2;
                    s7 = s8;
                }
                mutex9 = mutex5;
                goto label_215;
                try {
                label_152:
                    long v15 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s8 + " (" + v15 + "ms)", null, false, 6, null);
                    devLog2.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s8 + " (" + v15 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex6;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                mutex6.unlock(null);
                return z00;
                try {
                label_161:
                    mutex10 = mutex5;
                    v11 = v5;
                    qc.l0 l00 = new qc.l0(z3, this, list0, s9, null);
                    k00.r = null;
                    k00.w = s9;
                    k00.B = mutex10;
                    k00.D = s8;
                    k00.E = devLog2;
                    k00.G = s1;
                    k00.I = mutex6;
                    k00.M = list0;
                    k00.N = z3;
                    k00.S = v6;
                    k00.T = v8;
                    k00.V = v7;
                    v11 = v5;
                    k00.X = v11;
                    k00.W = v9;
                    k00.b0 = 3;
                    object0 = this.Q(l00, k00);
                    goto label_190;
                }
                catch(Throwable throwable1) {
                }
            label_183:
                v5 = v11;
                mutex2 = mutex6;
                s6 = s1;
                devLog0 = devLog2;
                s7 = s8;
                mutex9 = mutex10;
                goto label_215;
            label_190:
                if(object0 == a1) {
                    return a1;
                }
                s12 = s9;
                mutex2 = mutex6;
                s6 = s1;
                devLog0 = devLog2;
                s7 = s8;
                mutex9 = mutex10;
                list1 = list0;
                goto label_209;
            }
            case 3: {
                try {
                    v11 = k00.X;
                    list1 = k00.M;
                    mutex2 = k00.I;
                    s6 = k00.G;
                    devLog0 = k00.E;
                    s7 = k00.D;
                    mutex9 = k00.B;
                    s12 = k00.w;
                    n.D(object0);
                label_209:
                    D0 d00 = (D0)object0;
                    this.b.h(s12, list1);
                    a00 = new A0(((D0)object0));
                    goto label_219;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v5 = v11;
        try {
        label_215:
            long v16 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex9.hashCode() + "] " + s6 + " Lock return : " + s7 + " (" + v16 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex9.hashCode() + "] " + s6 + " Lock return : " + s7 + " (" + v16 + "ms)");
            throw throwable1;
        label_219:
            long v17 = System.currentTimeMillis() - v11;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex9.hashCode() + "] " + s6 + " Lock return : " + s7 + " (" + v17 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex9.hashCode() + "] " + s6 + " Lock return : " + s7 + " (" + v17 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex2.unlock(null);
            throw throwable0;
        }
        mutex2.unlock(null);
        return a00;
    }

    @Override  // oc.w
    public final Object i(List list0, oe.c c0) {
        Mutex mutex7;
        long v5;
        Mutex mutex6;
        Mutex mutex5;
        Mutex mutex4;
        oc.U u0;
        Mutex mutex3;
        LogU logU0;
        long v4;
        int v2;
        DevLog devLog1;
        Mutex mutex2;
        List list1;
        String s1;
        String s;
        Mutex mutex1;
        int v1;
        qc.z z0;
        if(c0 instanceof qc.z) {
            z0 = (qc.z)c0;
            int v = z0.V;
            if((v & 0x80000000) == 0) {
                z0 = new qc.z(this, c0);
            }
            else {
                z0.V = v ^ 0x80000000;
            }
        }
        else {
            z0 = new qc.z(this, c0);
        }
        Object object0 = z0.S;
        ne.a a0 = ne.a.a;
        switch(z0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_remove"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_remove", devLog0);
                z0.r = list0;
                z0.w = mutex0;
                z0.B = "music_remove";
                z0.D = devLog0;
                z0.E = "";
                z0.G = mutex0;
                v1 = 0;
                z0.I = 0;
                z0.M = 0;
                z0.V = 1;
                if(mutex0.lock(null, z0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                s = "music_remove";
                s1 = "";
                list1 = list0;
                mutex2 = mutex1;
                devLog1 = devLog0;
                v2 = 0;
                goto label_50;
            }
            case 1: {
                v2 = z0.M;
                int v3 = z0.I;
                mutex1 = z0.G;
                s1 = z0.E;
                DevLog devLog2 = z0.D;
                String s2 = z0.B;
                mutex2 = z0.w;
                list1 = z0.r;
                n.D(object0);
                s = s2;
                devLog1 = devLog2;
                v1 = v3;
                try {
                label_50:
                    v4 = System.currentTimeMillis();
                    logU0 = MutexLockUtil.INSTANCE.getLog();
                }
                catch(Throwable throwable0) {
                    mutex3 = mutex2;
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v5 = v4;
                    goto label_103;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    u0 = this.E(list1, ((D0)this.g.getValue()));
                    if(u0 == null) {
                        z0.r = null;
                        mutex3 = mutex2;
                        goto label_69;
                    }
                    else {
                        mutex4 = mutex1;
                        mutex5 = mutex2;
                    }
                    goto label_110;
                }
                catch(Throwable throwable0) {
                    mutex3 = mutex2;
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v5 = v4;
                    goto label_103;
                }
                try {
                label_69:
                    z0.w = mutex3;
                    z0.B = s;
                    z0.D = devLog1;
                    z0.E = s1;
                    z0.G = mutex1;
                    z0.I = v1;
                    z0.M = v2;
                    z0.N = v4;
                    z0.V = 2;
                    object0 = this.J(list1, true, z0);
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v5 = v4;
                    goto label_103;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex5 = mutex3;
                mutex6 = mutex1;
                v5 = v4;
                mutex4 = mutex6;
                v4 = v5;
                u0 = (oc.U)object0;
                goto label_110;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v5 = z0.N;
            mutex6 = z0.G;
            s1 = z0.E;
            devLog1 = z0.D;
            s = z0.B;
            mutex5 = z0.w;
            n.D(object0);
            mutex4 = mutex6;
            v4 = v5;
            u0 = (oc.U)object0;
            goto label_110;
        }
        catch(Throwable throwable0) {
        }
        try {
        label_103:
            long v6 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v6 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v6 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex7 = mutex6;
            mutex7.unlock(null);
            throw throwable1;
        }
        try {
        label_110:
            long v7 = System.currentTimeMillis() - v4;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex7 = mutex4;
            mutex7.unlock(null);
            throw throwable1;
        }
        mutex4.unlock(null);
        return u0;
    }

    public static final Object j(n0 n00, y0 y00, boolean z, oe.c c0) {
        f0 f00;
        if(c0 instanceof f0) {
            f00 = (f0)c0;
            int v = f00.B;
            if((v & 0x80000000) == 0) {
                f00 = new f0(n00, c0);
            }
            else {
                f00.B = v ^ 0x80000000;
            }
        }
        else {
            f00 = new f0(n00, c0);
        }
        Object object0 = f00.r;
        ne.a a0 = ne.a.a;
        switch(f00.B) {
            case 0: {
                n.D(object0);
                h0 h00 = new h0(n00, y00, z, null);
                f00.B = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, h00, f00);
                return object0 == a0 ? a0 : new oc.n0(((D0)object0));
            }
            case 1: {
                n.D(object0);
                return new oc.n0(((D0)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // oc.H
    public final long k() {
        return this.h;
    }

    @Override  // oc.H
    public final int l() {
        D0 d00 = (D0)this.g.getValue();
        this.n.getClass();
        if(lc.h.i(d00)) {
            return lc.h.d(d00);
        }
        g g0 = this.k;
        if(g0 != null) {
            return g0.n(d00.b);
        }
        this.l.getClass();
        return lc.a.e(d00);
    }

    @Override  // oc.A
    public final Object m(boolean z, oe.c c0) {
        Mutex mutex5;
        long v6;
        String s3;
        Mutex mutex4;
        long v7;
        SetShuffleResult setShuffleResult0;
        int v2;
        int v1;
        String s1;
        String s;
        Mutex mutex2;
        DevLog devLog1;
        Mutex mutex1;
        boolean z2;
        Z z1;
        if(c0 instanceof Z) {
            z1 = (Z)c0;
            int v = z1.V;
            if((v & 0x80000000) == 0) {
                z1 = new Z(this, c0);
            }
            else {
                z1.V = v ^ 0x80000000;
            }
        }
        else {
            z1 = new Z(this, c0);
        }
        Object object0 = z1.S;
        ne.a a0 = ne.a.a;
        switch(z1.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_setShuffle"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_setShuffle", devLog0);
                z1.w = mutex0;
                z1.B = "music_setShuffle";
                z1.D = devLog0;
                z1.E = "";
                z1.G = mutex0;
                z2 = z;
                z1.r = z2;
                z1.I = 0;
                z1.M = 0;
                z1.V = 1;
                if(mutex0.lock(null, z1) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                devLog1 = devLog0;
                mutex2 = mutex1;
                s = "music_setShuffle";
                s1 = "";
                v1 = 0;
                v2 = 0;
                goto label_52;
            }
            case 1: {
                int v3 = z1.M;
                int v4 = z1.I;
                z2 = z1.r;
                mutex1 = z1.G;
                s1 = z1.E;
                DevLog devLog2 = z1.D;
                String s2 = z1.B;
                Mutex mutex3 = z1.w;
                n.D(object0);
                mutex2 = mutex3;
                v1 = v3;
                v2 = v4;
                devLog1 = devLog2;
                s = s2;
                try {
                label_52:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                        O o0 = (O)this.g.getValue();
                        this.n.getClass();
                        if(lc.h.i(o0)) {
                            setShuffleResult0 = SelectRepeatOn.a;
                            v7 = v5;
                        }
                        else {
                            z1.w = mutex2;
                            z1.B = s;
                            z1.D = devLog1;
                            z1.E = s1;
                            z1.G = mutex1;
                            z1.r = z2;
                            z1.I = v2;
                            z1.M = v1;
                            z1.N = v5;
                            z1.V = 2;
                            object0 = this.O(z2, z1);
                            if(object0 == a0) {
                                return a0;
                            }
                            mutex4 = mutex2;
                            s3 = s;
                            v6 = v5;
                            mutex5 = mutex1;
                            goto label_95;
                        }
                        goto label_108;
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex2;
                        s3 = s;
                        goto label_104;
                    }
                    try {
                    label_83:
                        v6 = z1.N;
                        mutex5 = z1.G;
                        s1 = z1.E;
                        devLog1 = z1.D;
                        s3 = z1.B;
                        mutex4 = z1.w;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex1 = mutex5;
                        v5 = v6;
                        goto label_104;
                    }
                    try {
                    label_95:
                        mutex1 = mutex5;
                        setShuffleResult0 = (SetShuffleResult)object0;
                        mutex1 = mutex5;
                        v7 = v6;
                        s = s3;
                        mutex2 = mutex4;
                        goto label_108;
                    }
                    catch(Throwable throwable1) {
                        v5 = v6;
                    }
                label_104:
                    long v8 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v8 + "ms)");
                    throw throwable1;
                label_108:
                    long v9 = System.currentTimeMillis() - v7;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)");
                    goto label_115;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_83;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        throw throwable0;
    label_115:
        mutex1.unlock(null);
        return setShuffleResult0;
    }

    @Override  // oc.y
    public final Object o(M m0, oe.c c0) {
        String s4;
        String s3;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        SetRepeatResult setRepeatResult0;
        int v2;
        M m1;
        Mutex mutex2;
        Mutex mutex1;
        int v1;
        String s1;
        String s;
        DevLog devLog1;
        qc.Q q0;
        if(c0 instanceof qc.Q) {
            q0 = (qc.Q)c0;
            int v = q0.V;
            if((v & 0x80000000) == 0) {
                q0 = new qc.Q(this, c0);
            }
            else {
                q0.V = v ^ 0x80000000;
            }
        }
        else {
            q0 = new qc.Q(this, c0);
        }
        Object object0 = q0.S;
        ne.a a0 = ne.a.a;
        switch(q0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_setRepeat"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_setRepeat", devLog0);
                q0.r = m0;
                q0.w = mutex0;
                q0.B = "music_setRepeat";
                q0.D = devLog0;
                q0.E = "";
                q0.G = mutex0;
                q0.I = 0;
                q0.M = 0;
                q0.V = 1;
                if(mutex0.lock(null, q0) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                s = "music_setRepeat";
                s1 = "";
                v1 = 0;
                mutex1 = mutex0;
                mutex2 = mutex1;
                m1 = m0;
                v2 = 0;
                goto label_52;
            }
            case 1: {
                int v3 = q0.M;
                int v4 = q0.I;
                mutex2 = q0.G;
                s1 = q0.E;
                DevLog devLog2 = q0.D;
                String s2 = q0.B;
                Mutex mutex3 = q0.w;
                m1 = q0.r;
                n.D(object0);
                s = s2;
                v1 = v4;
                devLog1 = devLog2;
                v2 = v3;
                mutex1 = mutex3;
                try {
                label_52:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                        O o0 = (O)this.g.getValue();
                        this.n.getClass();
                        if(lc.h.i(o0)) {
                            setRepeatResult0 = com.melon.playlist.interfaces.SetRepeatResult.Failure.SelectRepeatOn.a;
                        }
                        else {
                            q0.r = null;
                            q0.w = mutex1;
                            q0.B = s;
                            q0.D = devLog1;
                            q0.E = s1;
                            q0.G = mutex2;
                            q0.I = v1;
                            q0.M = v2;
                            q0.N = v5;
                            q0.V = 2;
                            object0 = this.M(m1, q0);
                            if(object0 == a0) {
                                return a0;
                            }
                            mutex4 = mutex1;
                            v6 = v5;
                            mutex5 = mutex2;
                            s3 = s1;
                            s4 = s;
                            goto label_94;
                        }
                        goto label_110;
                    }
                    catch(Throwable throwable1) {
                        s3 = s1;
                        goto label_106;
                    }
                    try {
                    label_82:
                        v6 = q0.N;
                        mutex5 = q0.G;
                        s3 = q0.E;
                        devLog1 = q0.D;
                        s4 = q0.B;
                        mutex4 = q0.w;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex2 = mutex5;
                        s = s4;
                        goto label_104;
                    }
                    try {
                    label_94:
                        s = s4;
                        mutex2 = mutex5;
                        setRepeatResult0 = (SetRepeatResult)object0;
                        v5 = v6;
                        s1 = s3;
                        s = s4;
                        mutex2 = mutex5;
                        mutex1 = mutex4;
                        goto label_110;
                    }
                    catch(Throwable throwable1) {
                    }
                label_104:
                    mutex1 = mutex4;
                    v5 = v6;
                label_106:
                    long v7 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v7 + "ms)");
                    throw throwable1;
                label_110:
                    long v8 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)");
                    goto label_117;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_82;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_117:
        mutex2.unlock(null);
        return setRepeatResult0;
    }

    @Override  // oc.H
    public final int p() {
        D0 d00 = (D0)this.g.getValue();
        this.n.getClass();
        if(lc.h.i(d00)) {
            return lc.h.c(d00);
        }
        g g0 = this.k;
        if(g0 != null) {
            return g0.m(d00.b);
        }
        this.l.getClass();
        return lc.a.d(d00);
    }

    @Override  // oc.w
    public final Object q(int v, int v1, oe.c c0) {
        DevLog devLog3;
        String s3;
        Mutex mutex5;
        long v13;
        oc.v v12;
        Mutex mutex2;
        int v6;
        String s1;
        int v5;
        DevLog devLog1;
        Mutex mutex1;
        int v4;
        int v3;
        String s;
        p p0;
        if(c0 instanceof p) {
            p0 = (p)c0;
            int v2 = p0.W;
            if((v2 & 0x80000000) == 0) {
                p0 = new p(this, c0);
            }
            else {
                p0.W = v2 ^ 0x80000000;
            }
        }
        else {
            p0 = new p(this, c0);
        }
        Object object0 = p0.T;
        ne.a a0 = ne.a.a;
        switch(p0.W) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_move"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_move", devLog0);
                p0.E = mutex0;
                p0.G = "music_move";
                p0.I = devLog0;
                s = "";
                p0.M = "";
                p0.N = mutex0;
                v3 = v;
                p0.r = v3;
                v4 = v1;
                p0.w = v4;
                p0.B = 0;
                p0.D = 0;
                p0.W = 1;
                if(mutex0.lock(null, p0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                devLog1 = devLog0;
                v5 = 0;
                s1 = "music_move";
                v6 = 0;
                mutex2 = mutex1;
                goto label_58;
            }
            case 1: {
                int v7 = p0.D;
                int v8 = p0.B;
                int v9 = p0.w;
                int v10 = p0.r;
                Mutex mutex3 = p0.N;
                s = p0.M;
                DevLog devLog2 = p0.I;
                String s2 = p0.G;
                Mutex mutex4 = p0.E;
                n.D(object0);
                mutex2 = mutex4;
                v6 = v7;
                mutex1 = mutex3;
                v3 = v10;
                v5 = v8;
                v4 = v9;
                devLog1 = devLog2;
                s1 = s2;
                try {
                label_58:
                    long v11 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                        v12 = this.D(v3, v4, ((D0)this.g.getValue()));
                        if(v12 == null) {
                            p0.E = mutex2;
                            p0.G = s1;
                            p0.I = devLog1;
                            p0.M = s;
                            p0.N = mutex1;
                            p0.r = v3;
                            p0.w = v4;
                            p0.B = v5;
                            p0.D = v6;
                            p0.S = v11;
                            p0.W = 2;
                            object0 = this.I(v3, v4, true, p0);
                            goto label_83;
                        }
                        else {
                            v13 = v11;
                        }
                        goto label_120;
                    }
                    catch(Throwable throwable1) {
                        mutex5 = mutex2;
                        s3 = s;
                        devLog3 = devLog1;
                        goto label_116;
                    }
                label_83:
                    if(object0 == a0) {
                        return a0;
                    }
                    Mutex mutex6 = mutex1;
                    mutex5 = mutex2;
                    s3 = s;
                    String s4 = s1;
                    long v14 = v11;
                    devLog3 = devLog1;
                    goto label_105;
                    try {
                    label_92:
                        v14 = p0.S;
                        mutex6 = p0.N;
                        s3 = p0.M;
                        devLog3 = p0.I;
                        s4 = p0.G;
                        mutex5 = p0.E;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        s1 = s4;
                        mutex1 = mutex6;
                        v11 = v14;
                        goto label_116;
                    }
                    try {
                    label_105:
                        v13 = v14;
                        devLog1 = devLog3;
                        s1 = s4;
                        mutex1 = mutex6;
                        s = s3;
                        v12 = (oc.v)object0;
                        mutex2 = mutex5;
                        goto label_120;
                    }
                    catch(Throwable throwable1) {
                        v11 = v14;
                        s1 = s4;
                    }
                label_116:
                    long v15 = System.currentTimeMillis() - v11;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v15 + "ms)", null, false, 6, null);
                    devLog3.put("Lock[" + mutex5.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v15 + "ms)");
                    throw throwable1;
                label_120:
                    long v16 = System.currentTimeMillis() - v13;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v16 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v16 + "ms)");
                    goto label_127;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_92;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        throw throwable0;
    label_127:
        mutex1.unlock(null);
        return v12;
    }

    @Override  // oc.w
    public final Object r(long v, Continuation continuation0) {
        long v5;
        Mutex mutex2;
        Mutex mutex1;
        long v2;
        String s1;
        String s;
        DevLog devLog0;
        I i0;
        if(continuation0 instanceof I) {
            i0 = (I)continuation0;
            int v1 = i0.N;
            if((v1 & 0x80000000) == 0) {
                i0 = new I(this, ((oe.c)continuation0));
            }
            else {
                i0.N = v1 ^ 0x80000000;
            }
        }
        else {
            i0 = new I(this, ((oe.c)continuation0));
        }
        Object object0 = i0.I;
        ne.a a0 = ne.a.a;
        switch(i0.N) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_saveTimePositionMs"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_saveTimePositionMs", devLog0);
                i0.w = mutex0;
                s = "music_saveTimePositionMs";
                i0.B = "music_saveTimePositionMs";
                i0.D = devLog0;
                s1 = "";
                i0.E = "";
                i0.G = mutex0;
                v2 = v;
                i0.r = v2;
                i0.N = 1;
                if(mutex0.lock(null, i0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                mutex2 = mutex1;
                break;
            }
            case 1: {
                long v3 = i0.r;
                mutex2 = i0.G;
                s1 = i0.E;
                devLog0 = i0.D;
                s = i0.B;
                mutex1 = i0.w;
                n.D(object0);
                v2 = v3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v5 = System.currentTimeMillis();
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
            devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
            this.h = v2;
            this.b.g(v2, "saveTimePositionMs");
        }
        catch(Throwable throwable0) {
            long v6 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v6 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v6 + "ms)");
            throw throwable0;
        }
        finally {
            mutex2.unlock(null);
        }
        long v7 = System.currentTimeMillis() - v5;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
        devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)");
        return ie.H.a;
    }

    @Override  // oc.B
    public final Object s(y0 y00, oe.c c0) {
        String s4;
        String s3;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        o0 o00;
        int v2;
        y0 y01;
        Mutex mutex2;
        Mutex mutex1;
        int v1;
        String s1;
        String s;
        DevLog devLog1;
        d0 d00;
        if(c0 instanceof d0) {
            d00 = (d0)c0;
            int v = d00.V;
            if((v & 0x80000000) == 0) {
                d00 = new d0(this, c0);
            }
            else {
                d00.V = v ^ 0x80000000;
            }
        }
        else {
            d00 = new d0(this, c0);
        }
        Object object0 = d00.S;
        ne.a a0 = ne.a.a;
        switch(d00.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_setSortType"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_setSortType", devLog0);
                d00.r = y00;
                d00.w = mutex0;
                d00.B = "music_setSortType";
                d00.D = devLog0;
                d00.E = "";
                d00.G = mutex0;
                d00.I = 0;
                d00.M = 0;
                d00.V = 1;
                if(mutex0.lock(null, d00) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                s = "music_setSortType";
                s1 = "";
                v1 = 0;
                mutex1 = mutex0;
                mutex2 = mutex1;
                y01 = y00;
                v2 = 0;
                goto label_52;
            }
            case 1: {
                int v3 = d00.M;
                int v4 = d00.I;
                mutex2 = d00.G;
                s1 = d00.E;
                DevLog devLog2 = d00.D;
                String s2 = d00.B;
                Mutex mutex3 = d00.w;
                y01 = d00.r;
                n.D(object0);
                s = s2;
                v1 = v4;
                devLog1 = devLog2;
                v2 = v3;
                mutex1 = mutex3;
                try {
                label_52:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                        if(y01 instanceof y0) {
                            O o0 = (O)this.g.getValue();
                            this.n.getClass();
                            if(lc.h.i(o0)) {
                                o00 = new oc.m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                                goto label_86;
                            }
                            else {
                                qc.e0 e00 = new qc.e0(this, y01, null);
                                d00.r = null;
                                d00.w = mutex1;
                                d00.B = s;
                                d00.D = devLog1;
                                d00.E = s1;
                                d00.G = mutex2;
                                d00.I = v1;
                                d00.M = v2;
                                d00.N = v5;
                                d00.V = 2;
                                object0 = BuildersKt.withContext(this.a, e00, d00);
                                if(object0 == a0) {
                                    return a0;
                                }
                                mutex4 = mutex1;
                                v6 = v5;
                                mutex5 = mutex2;
                                s3 = s1;
                                s4 = s;
                                goto label_100;
                            }
                        }
                        else {
                            o00 = new oc.m0();  // 初始化器: Ljava/lang/Object;-><init>()V
                            goto label_86;
                        }
                        goto label_116;
                    }
                    catch(Throwable throwable1) {
                        s3 = s1;
                        goto label_112;
                    }
                label_86:
                    long v7 = v5;
                    goto label_116;
                    try {
                    label_88:
                        v6 = d00.N;
                        mutex5 = d00.G;
                        s3 = d00.E;
                        devLog1 = d00.D;
                        s4 = d00.B;
                        mutex4 = d00.w;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex2 = mutex5;
                        s = s4;
                        goto label_110;
                    }
                    try {
                    label_100:
                        s = s4;
                        mutex2 = mutex5;
                        o00 = (o0)object0;
                        v7 = v6;
                        s1 = s3;
                        s = s4;
                        mutex2 = mutex5;
                        mutex1 = mutex4;
                        goto label_116;
                    }
                    catch(Throwable throwable1) {
                    }
                label_110:
                    mutex1 = mutex4;
                    v5 = v6;
                label_112:
                    long v8 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v8 + "ms)");
                    throw throwable1;
                label_116:
                    long v9 = System.currentTimeMillis() - v7;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)");
                    goto label_123;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_88;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_123:
        mutex2.unlock(null);
        return o00;
    }

    @Override  // oc.z
    public final Object t(oe.c c0) {
        e e0;
        oc.c c1;
        Mutex mutex6;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        LogU logU0;
        MutexLockUtil mutexLockUtil0;
        long v3;
        Mutex mutex2;
        int v2;
        DevLog devLog1;
        String s1;
        String s;
        Mutex mutex1;
        int v1;
        qc.j j0;
        if(c0 instanceof qc.j) {
            j0 = (qc.j)c0;
            int v = j0.T;
            if((v & 0x80000000) == 0) {
                j0 = new qc.j(this, c0);
            }
            else {
                j0.T = v ^ 0x80000000;
            }
        }
        else {
            j0 = new qc.j(this, c0);
        }
        Object object0 = j0.N;
        ne.a a0 = ne.a.a;
        switch(j0.T) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_clearSelectRepeat"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_clearSelectRepeat", devLog0);
                j0.r = mutex0;
                j0.w = "music_clearSelectRepeat";
                j0.B = devLog0;
                j0.D = "";
                j0.E = mutex0;
                v1 = 0;
                j0.G = 0;
                j0.I = 0;
                j0.T = 1;
                if(mutex0.lock(null, j0) == a0) {
                    return a0;
                }
                try {
                    mutex1 = mutex0;
                    s = "music_clearSelectRepeat";
                    s1 = "";
                    devLog1 = devLog0;
                    v2 = 0;
                    mutex2 = mutex1;
                    v3 = System.currentTimeMillis();
                    goto label_51;
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
            }
            case 1: {
                int v4 = j0.I;
                int v5 = j0.G;
                mutex1 = j0.E;
                s1 = j0.D;
                DevLog devLog2 = j0.B;
                String s2 = j0.w;
                Mutex mutex3 = j0.r;
                n.D(object0);
                mutex2 = mutex3;
                v2 = v5;
                s = s2;
                devLog1 = devLog2;
                v1 = v4;
                try {
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
                try {
                label_51:
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    logU0 = mutexLockUtil0.getLog();
                }
                catch(Throwable throwable1) {
                    mutex4 = mutex2;
                    v6 = v3;
                    mutex5 = mutex4;
                    mutex6 = mutex1;
                    break;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    D0 d00 = this.H();
                    this.n.getClass();
                    if(lc.h.i(d00)) {
                        j0.r = mutex2;
                        j0.w = s;
                        j0.B = devLog1;
                        j0.D = s1;
                        j0.E = mutex1;
                        j0.G = v2;
                        j0.I = v1;
                        mutex4 = mutex2;
                        v6 = v3;
                        j0.M = v6;
                        j0.T = 2;
                        object0 = this.F(true, j0);
                        goto label_85;
                    }
                    goto label_90;
                }
                catch(Throwable throwable1) {
                    mutex4 = mutex2;
                    v6 = v3;
                    mutex5 = mutex4;
                    mutex6 = mutex1;
                    break;
                }
                try {
                    j0.M = v6;
                    j0.T = 2;
                    object0 = this.F(true, j0);
                }
                catch(Throwable throwable1) {
                    mutex5 = mutex4;
                    mutex6 = mutex1;
                    break;
                }
            label_85:
                if(object0 == a0) {
                    return a0;
                }
                mutex5 = mutex4;
                mutex6 = mutex1;
                e0 = (e)object0;
                goto label_119;
                try {
                label_90:
                    c1 = new oc.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable1) {
                    mutex5 = mutex2;
                    mutex6 = mutex1;
                    v6 = v3;
                    break;
                }
                try {
                    long v7 = System.currentTimeMillis() - v3;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
                mutex1.unlock(null);
                return c1;
            }
            case 2: {
                try {
                    v6 = j0.M;
                    mutex6 = j0.E;
                    s1 = j0.D;
                    devLog1 = j0.B;
                    s = j0.w;
                    mutex5 = j0.r;
                    n.D(object0);
                    e0 = (e)object0;
                    goto label_119;
                }
                catch(Throwable throwable1) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)");
            throw throwable1;
        label_119:
            long v9 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex1 = mutex6;
            mutex1.unlock(null);
            throw throwable0;
        }
        mutex6.unlock(null);
        return e0;
    }

    @Override  // oc.w
    public final Object u(oc.V v0, oe.c c0) {
        String s3;
        long v8;
        b0 b00;
        int v4;
        oc.V v3;
        Mutex mutex2;
        Mutex mutex1;
        int v2;
        String s1;
        String s;
        DevLog devLog1;
        qc.g g0;
        if(c0 instanceof qc.g) {
            g0 = (qc.g)c0;
            int v1 = g0.V;
            if((v1 & 0x80000000) == 0) {
                g0 = new qc.g(this, c0);
            }
            else {
                g0.V = v1 ^ 0x80000000;
            }
        }
        else {
            g0 = new qc.g(this, c0);
        }
        Object object0 = g0.S;
        ne.a a0 = ne.a.a;
        switch(g0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_add"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_add", devLog0);
                g0.r = v0;
                g0.w = mutex0;
                g0.B = "music_add";
                g0.D = devLog0;
                g0.E = "";
                g0.G = mutex0;
                g0.I = 0;
                g0.M = 0;
                g0.V = 1;
                if(mutex0.lock(null, g0) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                s = "music_add";
                s1 = "";
                v2 = 0;
                mutex1 = mutex0;
                mutex2 = mutex1;
                v3 = v0;
                v4 = 0;
                goto label_52;
            }
            case 1: {
                int v5 = g0.M;
                int v6 = g0.I;
                mutex2 = g0.G;
                s1 = g0.E;
                DevLog devLog2 = g0.D;
                String s2 = g0.B;
                Mutex mutex3 = g0.w;
                v3 = g0.r;
                n.D(object0);
                s = s2;
                v2 = v6;
                devLog1 = devLog2;
                v4 = v5;
                mutex1 = mutex3;
                try {
                label_52:
                    long v7 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                        O o0 = (O)this.g.getValue();
                        this.n.getClass();
                        if(lc.h.i(o0)) {
                            b00 = new oc.W(PlaylistId.MUSIC, "In Select Repeat Mode");
                            v8 = v7;
                        }
                        else {
                            i i0 = NonCancellable.INSTANCE.plus(this.a);
                            qc.h h0 = new qc.h(this, v3, null);
                            g0.r = null;
                            g0.w = mutex1;
                            g0.B = s;
                            g0.D = devLog1;
                            g0.E = s1;
                            g0.G = mutex2;
                            g0.I = v2;
                            g0.M = v4;
                            g0.N = v7;
                            g0.V = 2;
                            object0 = BuildersKt.withContext(i0, h0, g0);
                            goto label_78;
                        }
                        goto label_114;
                    }
                    catch(Throwable throwable1) {
                        s3 = s1;
                        goto label_110;
                    }
                label_78:
                    if(object0 == a0) {
                        return a0;
                    }
                    Mutex mutex4 = mutex1;
                    long v9 = v7;
                    Mutex mutex5 = mutex2;
                    s3 = s1;
                    String s4 = s;
                    goto label_98;
                    try {
                    label_86:
                        v9 = g0.N;
                        mutex5 = g0.G;
                        s3 = g0.E;
                        devLog1 = g0.D;
                        s4 = g0.B;
                        mutex4 = g0.w;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex2 = mutex5;
                        s = s4;
                        goto label_108;
                    }
                    try {
                    label_98:
                        s = s4;
                        mutex2 = mutex5;
                        b00 = (b0)object0;
                        v8 = v9;
                        s1 = s3;
                        s = s4;
                        mutex2 = mutex5;
                        mutex1 = mutex4;
                        goto label_114;
                    }
                    catch(Throwable throwable1) {
                    }
                label_108:
                    mutex1 = mutex4;
                    v7 = v9;
                label_110:
                    long v10 = System.currentTimeMillis() - v7;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v10 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v10 + "ms)");
                    throw throwable1;
                label_114:
                    long v11 = System.currentTimeMillis() - v8;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v11 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v11 + "ms)");
                    goto label_121;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_86;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_121:
        mutex2.unlock(null);
        return b00;
    }

    @Override  // com.iloen.melon.playback.playlist.LocalDownloadablePlaylist
    public final Object updateSolMetaDataBase(Continuation continuation0) {
        Object object0 = this.s.updateSolMetaDataBase(continuation0);
        return object0 == ne.a.a ? object0 : ie.H.a;
    }

    @Override  // oc.w
    public final Object v(int v, long v1, boolean z, String s, Continuation continuation0) {
        String s12;
        oc.f0 f00;
        long v31;
        Mutex mutex9;
        DevLog devLog6;
        String s11;
        Object object3;
        long v30;
        String s10;
        oc.d0 d00;
        String s9;
        Mutex mutex8;
        String s8;
        long v29;
        Mutex mutex7;
        String s6;
        DevLog devLog5;
        Mutex mutex6;
        Object object2;
        int v17;
        int v16;
        int v15;
        ne.a a2;
        boolean z3;
        DevLog devLog4;
        long v14;
        int v21;
        int v20;
        int v19;
        long v18;
        DevLog devLog3;
        Mutex mutex5;
        long v13;
        Mutex mutex4;
        int v12;
        LogU logU0;
        long v11;
        Mutex mutex2;
        DevLog devLog1;
        String s3;
        boolean z1;
        int v6;
        int v5;
        ne.a a1;
        Mutex mutex1;
        String s2;
        long v4;
        int v3;
        String s1;
        J j0;
        lc.h h0 = this.n;
        if(continuation0 instanceof J) {
            j0 = (J)continuation0;
            int v2 = j0.b0;
            if((v2 & 0x80000000) == 0) {
                j0 = new J(this, ((oe.c)continuation0));
            }
            else {
                j0.b0 = v2 ^ 0x80000000;
            }
        }
        else {
            j0 = new J(this, ((oe.c)continuation0));
        }
        Object object0 = j0.Y;
        ne.a a0 = ne.a.a;
        MutableStateFlow mutableStateFlow0 = this.g;
        switch(j0.b0) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_setCurrent"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_setCurrent", devLog0);
                j0.N = s;
                j0.S = mutex0;
                j0.T = "music_setCurrent";
                j0.V = devLog0;
                s1 = "";
                j0.W = "";
                j0.X = mutex0;
                v3 = v;
                j0.r = v3;
                j0.G = v1;
                j0.M = z;
                j0.w = 0;
                j0.B = 0;
                j0.b0 = 1;
                if(mutex0.lock(null, j0) == a0) {
                    return a0;
                }
                v4 = v1;
                s2 = s;
                mutex1 = mutex0;
                a1 = a0;
                v5 = 0;
                v6 = 0;
                z1 = z;
                s3 = "music_setCurrent";
                devLog1 = devLog0;
                mutex2 = mutex1;
                goto label_70;
            }
            case 1: {
                int v7 = j0.w;
                boolean z2 = j0.M;
                long v8 = j0.G;
                int v9 = j0.r;
                mutex2 = j0.X;
                int v10 = j0.B;
                Object object1 = j0.W;
                DevLog devLog2 = j0.V;
                String s4 = j0.T;
                Mutex mutex3 = j0.S;
                String s5 = j0.N;
                n.D(object0);
                a1 = a0;
                v4 = v8;
                v6 = v10;
                s1 = object1;
                s3 = s4;
                mutex1 = mutex3;
                s2 = s5;
                v5 = v7;
                z1 = z2;
                v3 = v9;
                devLog1 = devLog2;
                try {
                label_70:
                    v11 = System.currentTimeMillis();
                    logU0 = MutexLockUtil.INSTANCE.getLog();
                    v12 = mutex1.hashCode();
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex1;
                    v13 = v11;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    goto label_263;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + v12 + "] " + s1 + " Lock obtain : " + s3, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s3);
                    O o0 = (O)mutableStateFlow0.getValue();
                    h0.getClass();
                    if(lc.h.i(o0)) {
                        goto label_92;
                    }
                    else {
                        goto label_123;
                    }
                    goto label_183;
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex1;
                    v13 = v11;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    goto label_263;
                }
                try {
                label_92:
                    if(lc.h.a(v3, ((O)mutableStateFlow0.getValue()))) {
                    label_123:
                        mutex4 = mutex1;
                        devLog4 = devLog1;
                        a2 = a1;
                        v14 = v4;
                        z3 = z1;
                        v18 = v11;
                        v19 = v3;
                        v20 = 0;
                        v21 = 0;
                    }
                    else {
                        j0.N = s2;
                        j0.S = mutex1;
                        j0.T = s3;
                        j0.V = devLog1;
                        j0.W = s1;
                        j0.X = mutex2;
                        j0.r = v3;
                        v14 = v4;
                        j0.G = v14;
                        j0.M = z1;
                        j0.w = v5;
                        j0.B = v6;
                        j0.D = 0;
                        devLog4 = devLog1;
                        v13 = v11;
                        j0.I = v13;
                        z3 = z1;
                        j0.E = 0;
                        j0.b0 = 2;
                        mutex4 = mutex1;
                        try {
                            a2 = a1;
                            if(this.F(true, j0) == a2) {
                                return a2;
                            }
                        }
                        catch(Throwable throwable0) {
                            mutex5 = mutex2;
                            devLog3 = devLog4;
                            goto label_263;
                        }
                        v15 = v3;
                        v16 = 0;
                        v17 = 0;
                        goto label_179;
                    }
                    goto label_183;
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex1;
                    devLog4 = devLog1;
                    v13 = v11;
                }
                mutex5 = mutex2;
                devLog3 = devLog4;
                goto label_263;
            }
            case 2: {
                try {
                    int v22 = j0.E;
                    int v23 = j0.D;
                    int v24 = j0.B;
                    int v25 = j0.w;
                    boolean z4 = j0.M;
                    long v26 = j0.I;
                    long v27 = j0.G;
                    object2 = j0.W;
                    mutex6 = j0.X;
                    devLog5 = j0.V;
                    s6 = j0.T;
                    mutex7 = j0.S;
                    int v28 = j0.r;
                    String s7 = j0.N;
                    v13 = v26;
                    n.D(object0);
                    s2 = s7;
                    v15 = v28;
                    mutex4 = mutex7;
                    v17 = v23;
                    z3 = z4;
                    devLog4 = devLog5;
                    s3 = s6;
                    v6 = v24;
                    a2 = a0;
                    v5 = v25;
                    v16 = v22;
                    v13 = v26;
                    mutex2 = mutex6;
                    s1 = object2;
                    v14 = v27;
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex6;
                    mutex4 = mutex7;
                    s1 = object2;
                    devLog3 = devLog5;
                    s3 = s6;
                    goto label_263;
                }
            label_179:
                v18 = v13;
                v20 = v17;
                v19 = v15;
                v21 = v16;
                try {
                label_183:
                    v29 = v18;
                    s8 = s3;
                    devLog3 = devLog4;
                    mutex8 = mutex4;
                    s9 = s1;
                    Q q0 = (Q)mutableStateFlow0.getValue();
                    d00 = this.l.c(v19, q0);
                }
                catch(Throwable throwable0) {
                    s10 = s8;
                    v30 = v29;
                    goto label_218;
                }
                if(d00 == null) {
                    try {
                        j0.N = null;
                        j0.S = mutex8;
                        j0.T = s8;
                        j0.V = devLog3;
                        j0.W = s9;
                        j0.X = mutex2;
                        j0.r = v19;
                        j0.G = v14;
                        j0.M = z3;
                        j0.w = v5;
                        j0.B = v6;
                        j0.D = v20;
                        j0.I = v29;
                        j0.E = v21;
                        j0.b0 = 3;
                        s10 = s8;
                        v30 = v29;
                        object3 = this.L(v19, v14, z3, s2, true, j0);
                        goto label_224;
                    }
                    catch(Throwable throwable0) {
                    }
                label_218:
                    s1 = s9;
                    mutex4 = mutex8;
                    mutex5 = mutex2;
                    s3 = s10;
                    v13 = v30;
                    goto label_263;
                label_224:
                    if(object3 == a2) {
                        return a2;
                    }
                    object0 = object3;
                    s11 = s9;
                    devLog6 = devLog3;
                    mutex9 = mutex8;
                    mutex5 = mutex2;
                    v31 = v30;
                    goto label_249;
                }
                else {
                    f00 = d00;
                }
                goto label_270;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v31 = j0.I;
            mutex5 = j0.X;
            s11 = j0.W;
            devLog6 = j0.V;
            s12 = j0.T;
            mutex9 = j0.S;
            n.D(object0);
            s10 = s12;
        }
        catch(Throwable throwable0) {
            s1 = s11;
            mutex4 = mutex9;
            devLog3 = devLog6;
            v13 = v31;
            s3 = s12;
            goto label_263;
        }
        try {
        label_249:
            devLog3 = devLog6;
            f00 = (oc.f0)object0;
            v29 = v31;
            mutex2 = mutex5;
            s9 = s11;
            devLog3 = devLog6;
            mutex8 = mutex9;
            s8 = s10;
            goto label_270;
        }
        catch(Throwable throwable0) {
            mutex4 = mutex9;
            s3 = s10;
            s1 = s11;
            v13 = v31;
        }
        try {
        label_263:
            long v32 = System.currentTimeMillis() - v13;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v32 + "ms)", null, false, 6, null);
            devLog3.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v32 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw throwable1;
        }
        try {
        label_270:
            long v33 = System.currentTimeMillis() - v29;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex8.hashCode() + "] " + s9 + " Lock return : " + s8 + " (" + v33 + "ms)", null, false, 6, null);
            devLog3.put("Lock[" + mutex8.hashCode() + "] " + s9 + " Lock return : " + s8 + " (" + v33 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex2.unlock(null);
            throw throwable1;
        }
        mutex2.unlock(null);
        return f00;
    }

    @Override  // oc.x
    public final Object w(boolean z, Continuation continuation0) {
        D0 d01;
        boolean z3;
        DevLog devLog5;
        Mutex mutex9;
        long v9;
        String s6;
        ne.a a2;
        N n2;
        P p0;
        Mutex mutex8;
        String s5;
        long v7;
        String s4;
        DevLog devLog4;
        Mutex mutex7;
        g0 g00;
        Mutex mutex6;
        long v6;
        DevLog devLog3;
        Mutex mutex5;
        String s3;
        LogU logU0;
        MutexLockUtil mutexLockUtil0;
        long v3;
        Mutex mutex2;
        int v2;
        DevLog devLog1;
        N n1;
        int v1;
        String s1;
        String s;
        ne.a a1;
        Mutex mutex1;
        boolean z1;
        N n0;
        if(continuation0 instanceof N) {
            n0 = (N)continuation0;
            int v = n0.V;
            if((v & 0x80000000) == 0) {
                n0 = new N(this, continuation0);
            }
            else {
                n0.V = v ^ 0x80000000;
            }
        }
        else {
            n0 = new N(this, continuation0);
        }
        Object object0 = n0.S;
        ne.a a0 = ne.a.a;
        switch(n0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_setOfflineMode"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_setOfflineMode", devLog0);
                n0.w = mutex0;
                n0.B = "music_setOfflineMode";
                n0.D = devLog0;
                n0.E = "";
                n0.G = mutex0;
                n0.r = z;
                n0.I = 0;
                n0.M = 0;
                n0.V = 1;
                if(mutex0.lock(null, n0) == a0) {
                    return a0;
                }
                try {
                    z1 = z;
                    mutex1 = mutex0;
                    a1 = a0;
                    s = "";
                    s1 = "music_setOfflineMode";
                    v1 = 0;
                    n1 = n0;
                    devLog1 = devLog0;
                    v2 = 0;
                    mutex2 = mutex1;
                    v3 = System.currentTimeMillis();
                    goto label_60;
                }
                catch(Throwable throwable0) {
                    mutex8 = mutex1;
                    mutex8.unlock(null);
                    throw throwable0;
                }
            }
            case 1: {
                int v4 = n0.M;
                int v5 = n0.I;
                z1 = n0.r;
                Mutex mutex3 = n0.G;
                Object object1 = n0.E;
                DevLog devLog2 = n0.D;
                String s2 = n0.B;
                Mutex mutex4 = n0.w;
                n.D(object0);
                mutex1 = mutex3;
                n1 = n0;
                a1 = a0;
                s = object1;
                devLog1 = devLog2;
                mutex2 = mutex4;
                v1 = v4;
                v2 = v5;
                s1 = s2;
                try {
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex8 = mutex1;
                    mutex8.unlock(null);
                    throw throwable0;
                }
                try {
                label_60:
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    logU0 = mutexLockUtil0.getLog();
                }
                catch(Throwable throwable1) {
                    s3 = s;
                    mutex5 = mutex1;
                    devLog3 = devLog1;
                    v6 = v3;
                    mutex6 = mutex2;
                    goto label_128;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                    if(((D0)this.g.getValue()).g == z1) {
                        goto label_79;
                    }
                    goto label_99;
                }
                catch(Throwable throwable1) {
                    s3 = s;
                    mutex6 = mutex2;
                    mutex5 = mutex1;
                    devLog3 = devLog1;
                    v6 = v3;
                    goto label_128;
                }
                try {
                label_79:
                    LogU.debug$default(this.d, "setOfflineMode() skipped because already isOfflineMode: " + z1, null, false, 6, null);
                    g00 = new g0("Already isOfflineMode: " + z1);
                }
                catch(Throwable throwable1) {
                    mutex7 = mutex1;
                    devLog4 = devLog1;
                    s4 = s1;
                    mutex6 = mutex2;
                    v7 = v3;
                    s5 = s;
                    goto label_167;
                }
                try {
                    long v8 = System.currentTimeMillis() - v3;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v8 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex8 = mutex1;
                    mutex8.unlock(null);
                    throw throwable0;
                }
                mutex1.unlock(null);
                return g00;
                try {
                label_99:
                    mutex5 = mutex1;
                    LogU.debug$default(this.d, "setOfflineMode() isOfflineMode: " + z1, null, false, 6, null);
                    s3 = s;
                    mutex6 = mutex2;
                    p0 = new P(null, this, z1);
                    n2 = n1;
                    mutex6 = mutex2;
                    n2.w = mutex6;
                    n2.B = s1;
                    n2.D = devLog1;
                    n2.E = s;
                    n2.G = mutex5;
                    n2.r = z1;
                    n2.I = v2;
                    n2.M = v1;
                    devLog3 = devLog1;
                    s3 = s;
                    v6 = v3;
                    goto label_122;
                }
                catch(Throwable throwable1) {
                }
                devLog3 = devLog1;
                v6 = v3;
                goto label_128;
                try {
                label_122:
                    n2.N = v6;
                    n2.V = 2;
                    object0 = BuildersKt.withContext(NonCancellable.INSTANCE, p0, n2);
                    a2 = a1;
                    goto label_134;
                }
                catch(Throwable throwable1) {
                }
            label_128:
                mutex7 = mutex5;
                v7 = v6;
                s4 = s1;
                s5 = s3;
                devLog4 = devLog3;
                goto label_167;
            label_134:
                if(object0 == a2) {
                    return a2;
                }
                s6 = s1;
                s5 = s3;
                v9 = v6;
                mutex7 = mutex5;
                mutex9 = mutex6;
                devLog5 = devLog3;
                goto label_160;
            }
            case 2: {
                try {
                    boolean z2 = n0.r;
                    mutex7 = n0.G;
                    s5 = n0.E;
                    devLog4 = n0.D;
                    s4 = n0.B;
                    v9 = n0.N;
                    mutex9 = n0.w;
                    n.D(object0);
                    a2 = a0;
                    s6 = s4;
                    n2 = n0;
                    devLog5 = devLog4;
                    z1 = z2;
                }
                catch(Throwable throwable1) {
                    mutex6 = mutex9;
                    v7 = v9;
                    goto label_167;
                }
                try {
                label_160:
                    D0 d00 = (D0)object0;
                    goto label_171;
                }
                catch(Throwable throwable1) {
                    devLog4 = devLog5;
                    s4 = s6;
                    v7 = v9;
                    mutex6 = mutex9;
                }
                try {
                label_167:
                    long v10 = System.currentTimeMillis() - v7;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v10 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex6.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v10 + "ms)");
                    throw throwable1;
                label_171:
                    long v11 = System.currentTimeMillis() - v9;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex9.hashCode() + "] " + s5 + " Lock return : " + s6 + " (" + v11 + "ms)", null, false, 6, null);
                    devLog5.put("Lock[" + mutex9.hashCode() + "] " + s5 + " Lock return : " + s6 + " (" + v11 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex8 = mutex7;
                    mutex8.unlock(null);
                    throw throwable0;
                }
                mutex7.unlock(null);
                n2.w = null;
                n2.B = null;
                n2.D = null;
                n2.E = null;
                n2.G = null;
                n2.r = z1;
                n2.V = 3;
                object0 = this.P("setOfflineMode", n2);
                if(object0 == a2) {
                    return a2;
                }
                z3 = z1;
                goto label_195;
            }
            case 3: {
                z3 = n0.r;
                n.D(object0);
                n2 = n0;
                a2 = a0;
            label_195:
                d01 = (D0)object0;
                if(d01 == null) {
                    n2.w = null;
                    n2.r = z3;
                    n2.V = 4;
                    object0 = this.b(n2);
                    return object0 == a2 ? a2 : new oc.h0(((D0)object0));
                }
                break;
            }
            case 4: {
                D0 d02 = (D0)n0.w;
                n.D(object0);
                d01 = (D0)object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new oc.h0(d01);
    }

    @Override  // oc.H
    public final ListKeepOption x() {
        ListKeepOption listKeepOption0 = MelonSettingInfo.getCurrentListKeepOption();
        q.f(listKeepOption0, "getCurrentListKeepOption(...)");
        return listKeepOption0;
    }

    @Override  // oc.x
    public final MutableStateFlow y() {
        return this.g;
    }

    @Override  // oc.w
    public final Object z(Continuation continuation0) {
        oc.n n0;
        long v5;
        DevLog devLog4;
        String s5;
        Mutex mutex7;
        Mutex mutex6;
        String s4;
        int v4;
        Mutex mutex5;
        DevLog devLog3;
        String s3;
        long v3;
        int v2;
        DevLog devLog1;
        String s1;
        String s;
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        qc.x x0;
        if(continuation0 instanceof qc.x) {
            x0 = (qc.x)continuation0;
            int v = x0.V;
            if((v & 0x80000000) == 0) {
                x0 = new qc.x(this, ((oe.c)continuation0));
            }
            else {
                x0.V = v ^ 0x80000000;
            }
        }
        else {
            x0 = new qc.x(this, ((oe.c)continuation0));
        }
        Object object0 = x0.S;
        ne.a a0 = ne.a.a;
        switch(x0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "Lock[", "]  try : music_previous"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : music_previous", devLog0);
                x0.r = mutex0;
                x0.w = "music_previous";
                x0.B = devLog0;
                x0.D = "";
                x0.E = mutex0;
                x0.G = 0;
                x0.I = 0;
                x0.V = 1;
                if(mutex0.lock(null, x0) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    mutex2 = mutex1;
                    s = "music_previous";
                    s1 = "";
                    devLog1 = devLog0;
                    v2 = 0;
                    goto label_49;
                }
                return a0;
            }
            case 1: {
                v2 = x0.I;
                v1 = x0.G;
                Mutex mutex3 = x0.E;
                Object object1 = x0.D;
                DevLog devLog2 = x0.B;
                String s2 = x0.w;
                Mutex mutex4 = x0.r;
                n.D(object0);
                s = s2;
                mutex1 = mutex3;
                devLog1 = devLog2;
                s1 = object1;
                mutex2 = mutex4;
                try {
                label_49:
                    v3 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    s3 = s1;
                    devLog3 = devLog1;
                    mutex5 = mutex2;
                    v4 = this.l();
                    x0.r = mutex2;
                    x0.w = s;
                    x0.B = devLog1;
                    x0.D = s1;
                    x0.E = mutex1;
                    x0.G = v1;
                    x0.I = v2;
                    x0.N = v3;
                    x0.M = v4;
                    x0.V = 2;
                    mutex5 = mutex2;
                    s3 = s1;
                    devLog3 = devLog1;
                    if(this.L(v4, 0L, false, "previous", true, x0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    s4 = s;
                    mutex6 = mutex1;
                    mutex7 = mutex5;
                    s5 = s3;
                    devLog4 = devLog3;
                    goto label_98;
                }
                s4 = s;
                v5 = v3;
                mutex6 = mutex1;
                mutex7 = mutex5;
                s5 = s3;
                devLog4 = devLog3;
                n0 = new oc.n(v4);
                goto label_102;
            }
            case 2: {
                try {
                    v4 = x0.M;
                    v5 = x0.N;
                    mutex6 = x0.E;
                    s5 = x0.D;
                    devLog4 = x0.B;
                    s4 = x0.w;
                    mutex7 = x0.r;
                    n.D(object0);
                    n0 = new oc.n(v4);
                    goto label_102;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v3 = v5;
        try {
        label_98:
            long v6 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v6 + "ms)");
            throw throwable0;
        label_102:
            long v7 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v7 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v7 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex6.unlock(null);
            throw throwable1;
        }
        mutex6.unlock(null);
        return n0;
    }
}

