package nc;

import Kb.c;
import Ya.g;
import androidx.appcompat.app.o;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.ReplaceDefaultPlaylistException;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.SetRepeatResult.Success;
import com.melon.playlist.interfaces.SetShuffleResult.Failure.SelectRepeatOn;
import d5.n;
import e3.h;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import je.p;
import je.w;
import k8.Y;
import k8.a;
import kb.D;
import kc.r2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import oc.A0;
import oc.C;
import oc.M;
import oc.O;
import oc.Q;
import oc.S;
import oc.U;
import oc.V;
import oc.Z;
import oc.b0;
import oc.d;
import oc.e0;
import oc.j;
import oc.k0;
import oc.v;
import oc.z0;
import oe.i;

public final class u0 implements D0 {
    public final CoroutineDispatcher a;
    public final B0 b;
    public final a c;
    public final g d;
    public final c e;
    public final LogU f;
    public final Mutex g;
    public final MutableStateFlow h;
    public long i;
    public final LinkedList j;
    public final lc.a k;
    public final h l;
    public final lc.h m;
    public A3.g n;
    public boolean o;
    public final r2 p;
    public final D q;

    public u0(CoroutineDispatcher coroutineDispatcher0, B0 b00, a a0, g g0, c c0, boolean z) {
        q.g(b00, "repository");
        q.g(a0, "blockingProgressDialogManage");
        super();
        this.a = coroutineDispatcher0;
        this.b = b00;
        this.c = a0;
        this.d = g0;
        this.e = c0;
        this.f = Companion.create$default(LogU.Companion, "DrawerPlaylistImpl", false, Category.UI, 2, null);
        this.g = MutexKt.Mutex$default(false, 1, null);
        this.h = StateFlowKt.MutableStateFlow(new C0(w.a, -1, M.a, w.a, false, false, null, true, PlaylistId.DRAWER));
        this.i = -1L;
        this.j = new LinkedList();
        this.k = new lc.a("DrawerPlaylistImpl");
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        new LogU("DrawerPlaylistImpl");
        this.l = h0;
        lc.h h1 = new lc.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        new LogU("DrawerPlaylistImpl");
        this.m = h1;
        this.o = z;
        this.p = new r2("DrawerPlaylistImpl", new b(this, 0), 6);
        this.q = new D(this, 21);
    }

    @Override  // oc.x
    public final Object A(boolean z, oe.c c0) {
        oc.D d1;
        oc.D d0;
        MutexLockUtil mutexLockUtil0;
        long v2;
        Mutex mutex2;
        A a3;
        String s1;
        String s;
        ne.a a2;
        DevLog devLog1;
        Mutex mutex1;
        boolean z1;
        A a0;
        if(c0 instanceof A) {
            a0 = (A)c0;
            int v = a0.N;
            if((v & 0x80000000) == 0) {
                a0 = new A(this, c0);
            }
            else {
                a0.N = v ^ 0x80000000;
            }
        }
        else {
            a0 = new A(this, c0);
        }
        Object object0 = a0.I;
        ne.a a1 = ne.a.a;
        switch(a0.N) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_onNetworkConnectionChanged"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_onNetworkConnectionChanged", devLog0);
                a0.w = mutex0;
                a0.B = "drawer_onNetworkConnectionChanged";
                a0.D = devLog0;
                a0.E = "";
                a0.G = mutex0;
                a0.r = z;
                a0.N = 1;
                if(mutex0.lock(null, a0) == a1) {
                    return a1;
                }
                z1 = z;
                mutex1 = mutex0;
                devLog1 = devLog0;
                a2 = a1;
                s = "";
                s1 = "drawer_onNetworkConnectionChanged";
                a3 = a0;
                mutex2 = mutex1;
                goto label_50;
            }
            case 1: {
                z1 = a0.r;
                Mutex mutex3 = a0.G;
                String s2 = a0.E;
                DevLog devLog2 = a0.D;
                String s3 = a0.B;
                Mutex mutex4 = a0.w;
                n.D(object0);
                devLog1 = devLog2;
                mutex1 = mutex4;
                a2 = a1;
                s = s2;
                a3 = a0;
                mutex2 = mutex3;
                s1 = s3;
                try {
                label_50:
                    v2 = System.currentTimeMillis();
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1);
                    if(!((C0)this.h.getValue()).f) {
                        goto label_82;
                    }
                    if(this.o == z1) {
                        LogU.debug$default(this.f, "onNetworkConnectionChanged() skipped because already isConnected: " + z1, null, false, 6, null);
                        d0 = new oc.D("Already isConnected: " + z1);
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
                long v3 = System.currentTimeMillis() - v2;
                LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v3 + "ms)", null, false, 6, null);
                devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v3 + "ms)");
                return d0;
                try {
                label_64:
                    this.o = z1;
                    LogU.debug$default(this.f, "onNetworkConnectionChanged() isConnected: " + z1, null, false, 6, null);
                }
                catch(Throwable throwable0) {
                    goto label_86;
                }
                long v4 = System.currentTimeMillis() - v2;
                LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v4 + "ms)", null, false, 6, null);
                devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v4 + "ms)");
                a3.w = null;
                a3.B = null;
                a3.D = null;
                a3.E = null;
                a3.G = null;
                a3.r = z1;
                a3.N = 2;
                object0 = this.T("onNetworkConnectionChanged", a3);
                if(object0 == a2) {
                    return a2;
                    try {
                    label_82:
                        LogU.debug$default(this.f, "onNetworkConnectionChanged() skipped because not in offline mode", null, false, 6, null);
                        d1 = new oc.D();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    catch(Throwable throwable0) {
                    label_86:
                        long v5 = System.currentTimeMillis() - v2;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v5 + "ms)", null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v5 + "ms)");
                        throw throwable0;
                    }
                    long v6 = System.currentTimeMillis() - v2;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v6 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v6 + "ms)");
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
        if(((C0)object0) != null) {
            LogU.debug$default(this.f, "onNetworkConnectionChanged() updated album image", null, false, 6, null);
            return new C(((C0)object0));
        }
        LogU.debug$default(this.f, "onNetworkConnectionChanged() skipped because no updated song", null, false, 6, null);
        return new oc.D();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.w
    public final Object B(Continuation continuation0) {
        j j1;
        Mutex mutex2;
        j j0;
        int v1;
        Mutex mutex0;
        z z0;
        if(continuation0 instanceof z) {
            z0 = (z)continuation0;
            int v = z0.G;
            if((v & 0x80000000) == 0) {
                z0 = new z(this, ((oe.c)continuation0));
            }
            else {
                z0.G = v ^ 0x80000000;
            }
        }
        else {
            z0 = new z(this, ((oe.c)continuation0));
        }
        Object object0 = z0.D;
        ne.a a0 = ne.a.a;
        switch(z0.G) {
            case 0: {
                n.D(object0);
                mutex0 = this.g;
                z0.r = mutex0;
                v1 = 0;
                z0.B = 0;
                z0.G = 1;
                if(mutex0.lock(null, z0) == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                v1 = z0.B;
                Mutex mutex1 = z0.r;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_25:
                    j0 = this.H();
                    z0.r = mutex0;
                    z0.w = j0;
                    z0.B = v1;
                    z0.G = 2;
                    if(this.P(j0.a, 0L, false, "nextWhenPlayCompleted", true, z0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                mutex2 = mutex0;
                j1 = j0;
                break;
            }
            case 2: {
                try {
                    j1 = z0.w;
                    mutex2 = z0.r;
                    n.D(object0);
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
        return j1;
    }

    @Override  // oc.H
    public final AddPosition C() {
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        q.f(addPosition0, "getPlayListAddPosition(...)");
        return addPosition0;
    }

    public final S D(List list0, C0 c00) {
        this.m.getClass();
        if(lc.h.i(c00) && (!(list0 instanceof Collection) || !list0.isEmpty())) {
            for(Object object0: list0) {
                if(lc.h.a(((Number)object0).intValue(), c00)) {
                    return new S("Can\'t Remove Select Repeat Song", false);
                }
                if(false) {
                    break;
                }
            }
        }
        this.k.getClass();
        return lc.a.b(list0, c00);
    }

    public final Object E(PlaylistId playlistId0, oe.c c0) {
        oc.b b0;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        String s3;
        Mutex mutex2;
        int v2;
        PlaylistId playlistId1;
        DevLog devLog1;
        int v1;
        String s1;
        Mutex mutex1;
        String s;
        nc.j j0;
        if(c0 instanceof nc.j) {
            j0 = (nc.j)c0;
            int v = j0.V;
            if((v & 0x80000000) == 0) {
                j0 = new nc.j(this, c0);
            }
            else {
                j0.V = v ^ 0x80000000;
            }
        }
        else {
            j0 = new nc.j(this, c0);
        }
        Object object0 = j0.S;
        ne.a a0 = ne.a.a;
        switch(j0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_clear"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_clear", devLog0);
                j0.r = playlistId0;
                j0.w = mutex0;
                j0.B = "drawer_clear";
                j0.D = devLog0;
                s = "";
                j0.E = "";
                j0.G = mutex0;
                j0.I = 0;
                j0.M = 0;
                j0.V = 1;
                if(mutex0.lock(null, j0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                s1 = "drawer_clear";
                v1 = 0;
                devLog1 = devLog0;
                playlistId1 = playlistId0;
                v2 = 0;
                mutex2 = mutex1;
                goto label_53;
            }
            case 1: {
                int v3 = j0.M;
                int v4 = j0.I;
                mutex1 = j0.G;
                Object object1 = j0.E;
                DevLog devLog2 = j0.D;
                String s2 = j0.B;
                Mutex mutex3 = j0.w;
                playlistId1 = j0.r;
                n.D(object0);
                v1 = v4;
                s1 = s2;
                devLog1 = devLog2;
                s = object1;
                v2 = v3;
                mutex2 = mutex3;
                try {
                label_53:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                        j0.r = null;
                        j0.w = mutex2;
                        j0.B = s1;
                        j0.D = devLog1;
                        j0.E = s;
                        j0.G = mutex1;
                        j0.I = v1;
                        j0.M = v2;
                        j0.N = v5;
                        j0.V = 2;
                        object0 = this.F(playlistId1, true, j0);
                    }
                    catch(Throwable throwable1) {
                        s3 = s;
                        goto label_97;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex4 = mutex2;
                    v6 = v5;
                    s3 = s;
                    mutex5 = mutex1;
                    b0 = (oc.b)object0;
                    goto label_103;
                    try {
                    label_78:
                        v6 = j0.N;
                        mutex5 = j0.G;
                        s3 = j0.E;
                        devLog1 = j0.D;
                        s1 = j0.B;
                        mutex4 = j0.w;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex1 = mutex5;
                        mutex2 = mutex4;
                        v5 = v6;
                        goto label_97;
                    }
                    try {
                        b0 = (oc.b)object0;
                        goto label_103;
                    }
                    catch(Throwable throwable1) {
                        mutex1 = mutex5;
                        v5 = v6;
                        mutex2 = mutex4;
                    }
                label_97:
                    long v7 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v7 + "ms)");
                    throw throwable1;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                goto label_78;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        throw throwable0;
        try {
        label_103:
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex4.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v8 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex1 = mutex5;
            mutex1.unlock(null);
            throw throwable0;
        }
        mutex5.unlock(null);
        return b0;
    }

    public final Object F(PlaylistId playlistId0, boolean z, oe.c c0) {
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
                m m0 = new m(this, playlistId0, z, null);
                k0.B = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, m0, k0);
                return object0 == a0 ? a0 : new oc.b(((C0)object0));
            }
            case 1: {
                n.D(object0);
                return new oc.b(((C0)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object G(boolean z, oe.c c0) {
        nc.o o0;
        if(c0 instanceof nc.o) {
            o0 = (nc.o)c0;
            int v = o0.B;
            if((v & 0x80000000) == 0) {
                o0 = new nc.o(this, c0);
            }
            else {
                o0.B = v ^ 0x80000000;
            }
        }
        else {
            o0 = new nc.o(this, c0);
        }
        Object object0 = o0.r;
        ne.a a0 = ne.a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                nc.q q0 = new nc.q(null, this, z);
                o0.B = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, q0, o0) == a0 ? a0 : d.a;
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

    public final j H() {
        C0 c00 = (C0)this.h.getValue();
        this.m.getClass();
        boolean z = lc.h.i(c00);
        int v = c00.b;
        if(z) {
            return new j(lc.h.c(c00), true);
        }
        A3.g g0 = this.n;
        h h0 = this.l;
        if(g0 != null) {
            if(c00.c == M.b && g0.s(v)) {
                this.n = this.n == null ? null : this.n.b(v);
            }
            b b0 = new b(this, 1);
            A3.g g1 = this.n;
            q.d(g1);
            boolean z1 = g1.s(v);
            h0.getClass();
            return h.q(c00, b0, z1);
        }
        b b1 = new b(this, 2);
        this.k.getClass();
        boolean z2 = lc.a.f(v, c00);
        h0.getClass();
        return h.q(c00, b1, z2);
    }

    public final C0 I() {
        return (C0)this.h.getValue();
    }

    public final Object J(List list0, DrawerPlaylistInfo drawerPlaylistInfo0, boolean z, oe.c c0) {
        u0 u03;
        u0 u02;
        int v1;
        boolean z1;
        DrawerPlaylistInfo drawerPlaylistInfo1;
        List list1;
        s s0;
        if(c0 instanceof s) {
            s0 = (s)c0;
            int v = s0.N;
            if((v & 0x80000000) == 0) {
                s0 = new s(this, c0);
            }
            else {
                s0.N = v ^ 0x80000000;
            }
        }
        else {
            s0 = new s(this, c0);
        }
        Object object0 = s0.I;
        ne.a a0 = ne.a.a;
        switch(s0.N) {
            case 0: {
                n.D(object0);
                u0 u01 = new u0(this.a, this.b, this.c, this.d, this.e, this.o);
                s0.r = list0;
                s0.w = drawerPlaylistInfo0;
                s0.B = u01;
                s0.D = u01;
                s0.E = z;
                s0.G = 0;
                s0.N = 1;
                if(u01.V(drawerPlaylistInfo0, "makeViewTypeDrawerPlaylist", s0) == a0) {
                    return a0;
                }
                list1 = list0;
                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                z1 = z;
                v1 = 0;
                u02 = u01;
                u03 = u02;
                break;
            }
            case 1: {
                v1 = s0.G;
                boolean z2 = s0.E;
                u0 u04 = s0.D;
                u02 = s0.B;
                DrawerPlaylistInfo drawerPlaylistInfo2 = s0.w;
                List list2 = s0.r;
                n.D(object0);
                z1 = z2;
                u03 = u04;
                drawerPlaylistInfo1 = drawerPlaylistInfo2;
                list1 = list2;
                break;
            }
            case 2: {
                u0 u00 = s0.B;
                n.D(object0);
                return u00;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d8.d.E(System.currentTimeMillis(), list1);
        t t0 = new t(u03, list1, drawerPlaylistInfo1, z1, null);
        s0.r = null;
        s0.w = null;
        s0.B = u02;
        s0.D = null;
        s0.E = z1;
        s0.G = v1;
        s0.N = 2;
        return u03.U("makeViewTypeDrawerPlaylist", t0, s0) == a0 ? a0 : u02;
    }

    public final Object K(oe.c c0) {
        Mutex mutex3;
        DevLog devLog1;
        Mutex mutex2;
        Mutex mutex1;
        String s1;
        DevLog devLog0;
        String s;
        Mutex mutex0;
        long v1;
        DevLog devLog4;
        String s4;
        String s3;
        int v11;
        int v10;
        Mutex mutex8;
        Mutex mutex7;
        int v9;
        int v8;
        DevLog devLog3;
        long v7;
        DrawerPlaylistInfo drawerPlaylistInfo1;
        Mutex mutex6;
        Mutex mutex5;
        String s2;
        DevLog devLog2;
        Object object1;
        Mutex mutex4;
        int v6;
        DrawerPlaylistInfo drawerPlaylistInfo0;
        int v5;
        int v4;
        int v3;
        long v2;
        Mutex mutex9;
        String s5;
        DevLog devLog5;
        Object object2;
        long v13;
        int v20;
        int v19;
        String s6;
        F0 f01;
        G0 g00;
        long v23;
        Mutex mutex12;
        F0 f00;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        long v21;
        Object object4;
        nc.D d0;
        if(c0 instanceof nc.D) {
            d0 = (nc.D)c0;
            int v = d0.X;
            if((v & 0x80000000) == 0) {
                d0 = new nc.D(this, c0);
            }
            else {
                d0.X = v ^ 0x80000000;
            }
        }
        else {
            d0 = new nc.D(this, c0);
        }
        Object object0 = d0.V;
        ne.a a0 = ne.a.a;
        switch(d0.X) {
            case 0: {
                n.D(object0);
                Mutex mutex11 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex11.hashCode(), "Lock[", "]  try : drawer_refresh"), null, false, 6, null);
                DevLog devLog7 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex11.hashCode(), "]  try : drawer_refresh", devLog7);
                d0.r = mutex11;
                d0.w = "drawer_refresh";
                d0.B = devLog7;
                d0.D = "";
                d0.E = mutex11;
                d0.I = 0;
                d0.M = 0;
                d0.X = 1;
                if(mutex11.lock(null, d0) != a0) {
                    devLog1 = devLog7;
                    s6 = "drawer_refresh";
                    s = "";
                    v20 = 0;
                    mutex7 = mutex11;
                    mutex3 = mutex7;
                    v19 = 0;
                    try {
                    label_121:
                        v7 = System.currentTimeMillis();
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s + " Lock obtain : " + s6, null, false, 6, null);
                        devLog1.put("Lock[" + mutex7.hashCode() + "] " + s + " Lock obtain : " + s6);
                        Flow flow0 = DrawerPlaylistPreferencesRepository.INSTANCE.getDrawerPlytInfo();
                        d0.r = mutex7;
                        d0.w = s6;
                        d0.B = devLog1;
                        d0.D = s;
                        d0.E = mutex3;
                        d0.I = v20;
                        d0.M = v19;
                        d0.N = 0;
                        d0.T = v7;
                        d0.S = 0;
                        d0.X = 2;
                        object4 = FlowKt.firstOrNull(flow0, d0);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex7;
                        v1 = v7;
                        s1 = s6;
                        goto label_304;
                    }
                    if(object4 != a0) {
                        v5 = v20;
                        s1 = s6;
                        v9 = 0;
                        mutex8 = mutex3;
                        devLog3 = devLog1;
                        v4 = v19;
                        object0 = object4;
                        v8 = 0;
                        try {
                        label_152:
                            drawerPlaylistInfo1 = (DrawerPlaylistInfo)object0;
                            if(drawerPlaylistInfo1 == null || drawerPlaylistInfo1.getMenuId().length() <= 0) {
                                goto label_296;
                            }
                        }
                        catch(Throwable throwable0) {
                            devLog1 = devLog3;
                            v21 = v7;
                            mutex3 = mutex8;
                            goto label_302;
                        }
                        try {
                            DrawerPlaylist playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(drawerPlaylistInfo1, drawerPlaylistInfo1.getMenuId(), null);
                            d0.r = mutex7;
                            d0.w = s1;
                            d0.B = devLog3;
                            d0.D = s;
                            d0.E = mutex8;
                            d0.G = drawerPlaylistInfo1;
                            d0.I = v5;
                            d0.M = v4;
                            d0.N = v8;
                            d0.T = v7;
                            d0.S = v9;
                            d0.X = 3;
                            object0 = playDataForSeverContent$DrawerPlaylist0.getPlayableList(d0);
                        }
                        catch(Throwable throwable1) {
                            s4 = s;
                            drawerPlaylistInfo0 = drawerPlaylistInfo1;
                            v10 = v5;
                            v11 = v4;
                            s3 = s1;
                            devLog4 = devLog3;
                            goto label_205;
                        }
                        if(object0 != a0) {
                            v3 = v8;
                            mutex6 = mutex8;
                            mutex5 = mutex7;
                            v6 = v9;
                            try {
                            label_188:
                                mutex8 = mutex6;
                                v8 = v3;
                                mutex7 = mutex5;
                                addRequestPlayableListInfo0 = (AddRequestPlayableListInfo)object0;
                                mutex8 = mutex6;
                                v8 = v3;
                                mutex7 = mutex5;
                                v9 = v6;
                                goto label_221;
                            }
                            catch(Throwable throwable1) {
                                s4 = s;
                                drawerPlaylistInfo0 = drawerPlaylistInfo1;
                                v10 = v5;
                                v11 = v4;
                                s3 = s1;
                                devLog4 = devLog3;
                                v9 = v6;
                            }
                            try {
                            label_205:
                                s = s4;
                                addRequestPlayableListInfo0 = n.t(throwable1);
                                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                                s = s4;
                                devLog3 = devLog4;
                                s1 = s3;
                                v4 = v11;
                                v5 = v10;
                            }
                            catch(Throwable throwable0) {
                                mutex1 = mutex7;
                                v1 = v7;
                                devLog1 = devLog4;
                                s1 = s3;
                                mutex3 = mutex8;
                                goto label_304;
                            }
                        label_221:
                            if(addRequestPlayableListInfo0 instanceof ie.o) {
                                addRequestPlayableListInfo0 = null;
                            }
                            if(addRequestPlayableListInfo0 == null) {
                                try {
                                    f00 = new F0("get from server failed");
                                }
                                catch(Throwable throwable0) {
                                    devLog1 = devLog3;
                                    mutex1 = mutex7;
                                    mutex3 = mutex8;
                                    v1 = v7;
                                    goto label_304;
                                }
                                try {
                                    long v22 = System.currentTimeMillis() - v7;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v22 + "ms)", null, false, 6, null);
                                    devLog3.put("Lock[" + mutex7.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v22 + "ms)");
                                }
                                catch(Throwable throwable2) {
                                    mutex3 = mutex8;
                                    mutex3.unlock(null);
                                    throw throwable2;
                                }
                                mutex8.unlock(null);
                                return f00;
                            }
                            try {
                                mutex2 = mutex8;
                                if(addRequestPlayableListInfo0.getUserRequestedPlaylist().isEmpty()) {
                                    goto label_248;
                                }
                                goto label_253;
                            }
                            catch(Throwable throwable0) {
                                mutex12 = mutex7;
                                v23 = v7;
                                devLog1 = devLog3;
                                v1 = v23;
                                mutex1 = mutex12;
                                mutex3 = mutex2;
                                goto label_304;
                            }
                            try {
                            label_248:
                                long v24 = System.currentTimeMillis() - v7;
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v24 + "ms)", null, false, 6, null);
                                devLog3.put("Lock[" + mutex7.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v24 + "ms)");
                            }
                            catch(Throwable throwable2) {
                                mutex3 = mutex2;
                                mutex3.unlock(null);
                                throw throwable2;
                            }
                            mutex2.unlock(null);
                            return E0.a;
                            try {
                            label_253:
                                mutex12 = mutex7;
                                v23 = v7;
                                F f0 = new F(addRequestPlayableListInfo0, drawerPlaylistInfo1, null, this);
                                mutex12 = mutex7;
                                d0.r = mutex12;
                                d0.w = s1;
                                d0.B = devLog3;
                                d0.D = s;
                                d0.E = mutex2;
                                d0.G = null;
                                d0.I = v5;
                                d0.M = v4;
                                d0.N = v8;
                                v23 = v7;
                                d0.T = v23;
                                d0.S = v9;
                                d0.X = 4;
                                if(BuildersKt.withContext(NonCancellable.INSTANCE, f0, d0) == a0) {
                                    return a0;
                                }
                            }
                            catch(Throwable throwable0) {
                                devLog1 = devLog3;
                                v1 = v23;
                                mutex1 = mutex12;
                                mutex3 = mutex2;
                                goto label_304;
                            }
                            mutex1 = mutex12;
                            devLog0 = devLog3;
                            v1 = v23;
                            try {
                                g00 = new G0(((Q)this.h.getValue()));
                                goto label_287;
                            }
                            catch(Throwable throwable0) {
                                devLog1 = devLog0;
                            }
                            mutex3 = mutex2;
                            goto label_304;
                            try {
                            label_287:
                                long v25 = System.currentTimeMillis() - v1;
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v25 + "ms)", null, false, 6, null);
                                devLog0.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v25 + "ms)");
                            }
                            catch(Throwable throwable2) {
                                mutex3 = mutex2;
                                mutex3.unlock(null);
                                throw throwable2;
                            }
                            mutex2.unlock(null);
                            return g00;
                            try {
                            label_296:
                                devLog1 = devLog3;
                                v21 = v7;
                                mutex3 = mutex8;
                                f01 = new F0("et from local failed");
                                goto label_308;
                            }
                            catch(Throwable throwable0) {
                            }
                        label_302:
                            mutex1 = mutex7;
                            v1 = v21;
                            try {
                            label_304:
                                long v26 = System.currentTimeMillis() - v1;
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v26 + "ms)", null, false, 6, null);
                                devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v26 + "ms)");
                                throw throwable0;
                            label_308:
                                long v27 = System.currentTimeMillis() - v21;
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v27 + "ms)", null, false, 6, null);
                                devLog1.put("Lock[" + mutex7.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v27 + "ms)");
                            }
                            catch(Throwable throwable2) {
                                mutex3.unlock(null);
                                throw throwable2;
                            }
                            mutex3.unlock(null);
                            return f01;
                        }
                    }
                }
                break;
            }
            case 1: {
                int v17 = d0.M;
                int v18 = d0.I;
                mutex3 = d0.E;
                Object object3 = d0.D;
                DevLog devLog6 = d0.B;
                s6 = d0.w;
                Mutex mutex10 = d0.r;
                n.D(object0);
                mutex7 = mutex10;
                v19 = v17;
                v20 = v18;
                s = object3;
                devLog1 = devLog6;
                goto label_121;
            }
            case 2: {
                try {
                    int v12 = d0.S;
                    v13 = d0.T;
                    int v14 = d0.M;
                    int v15 = d0.I;
                    mutex3 = d0.E;
                    int v16 = d0.N;
                    object2 = d0.D;
                    devLog5 = d0.B;
                    s5 = d0.w;
                    mutex9 = d0.r;
                    n.D(object0);
                    v8 = v16;
                    v9 = v12;
                    v5 = v15;
                    v4 = v14;
                    s1 = s5;
                    mutex7 = mutex9;
                    mutex8 = mutex3;
                    s = object2;
                    devLog3 = devLog5;
                    v7 = v13;
                    goto label_152;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex9;
                    v1 = v13;
                    s = object2;
                    devLog1 = devLog5;
                    s1 = s5;
                    goto label_304;
                }
            }
            case 3: {
                try {
                    v2 = d0.T;
                    v3 = d0.N;
                    v4 = d0.M;
                    v5 = d0.I;
                    drawerPlaylistInfo0 = d0.G;
                    v6 = d0.S;
                    mutex4 = d0.E;
                    object1 = d0.D;
                    devLog2 = d0.B;
                    s2 = d0.w;
                    mutex5 = d0.r;
                    n.D(object0);
                    mutex6 = mutex4;
                    drawerPlaylistInfo1 = drawerPlaylistInfo0;
                    s = object1;
                    v7 = v2;
                    devLog3 = devLog2;
                    s1 = s2;
                    goto label_188;
                }
                catch(Throwable throwable1) {
                    v8 = v3;
                    v9 = v6;
                    mutex7 = mutex5;
                    mutex8 = mutex4;
                    v10 = v5;
                    v11 = v4;
                    s3 = s2;
                    v7 = v2;
                    s4 = object1;
                    devLog4 = devLog2;
                    goto label_205;
                }
            }
            case 4: {
                try {
                    v1 = d0.T;
                    mutex0 = d0.E;
                    s = d0.D;
                    devLog0 = d0.B;
                    s1 = d0.w;
                    mutex1 = d0.r;
                    n.D(object0);
                    mutex2 = mutex0;
                    g00 = new G0(((Q)this.h.getValue()));
                    goto label_287;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog0;
                    mutex3 = mutex0;
                    goto label_304;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object L(List list0, G g0) {
        MutableStateFlow mutableStateFlow0 = this.h;
        DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)mutableStateFlow0.getValue()).g;
        if(drawerPlaylistInfo0 == null) {
            return new S("No Playlist Info", false);
        }
        String s = drawerPlaylistInfo0.getContsId();
        if(s == null) {
            s = "";
        }
        String s1 = drawerPlaylistInfo0.isDj() ? "M20002" : "M20001";
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            Playable playable0 = (Playable)p.n0(((Number)object0).intValue(), e1.b.B(((Q)mutableStateFlow0.getValue())));
            Integer integer0 = playable0 == null ? null : new Integer(playable0.getSongid());
            if(integer0 != null) {
                arrayList0.add(integer0);
            }
        }
        String s2 = p.q0(arrayList0, ",", null, null, null, 62);
        if(s.length() == 0) {
            return new S("playlist Seq invalid", false);
        }
        if(list0.isEmpty()) {
            return new S("indices is empty", false);
        }
        J j0 = new J(this, s, s1, s2, list0, null);
        return BuildersKt.withContext(NonCancellable.INSTANCE, j0, g0);
    }

    public final Object M(C0 c00, oe.c c0) {
        C0 c02;
        String s4;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        String s3;
        int v2;
        C0 c01;
        Mutex mutex2;
        Mutex mutex1;
        int v1;
        String s1;
        String s;
        DevLog devLog1;
        K k0;
        if(c0 instanceof K) {
            k0 = (K)c0;
            int v = k0.V;
            if((v & 0x80000000) == 0) {
                k0 = new K(this, c0);
            }
            else {
                k0.V = v ^ 0x80000000;
            }
        }
        else {
            k0 = new K(this, c0);
        }
        Object object0 = k0.S;
        ne.a a0 = ne.a.a;
        switch(k0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_replace"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_replace", devLog0);
                k0.r = c00;
                k0.w = mutex0;
                k0.B = "drawer_replace";
                k0.D = devLog0;
                k0.E = "";
                k0.G = mutex0;
                k0.I = 0;
                k0.M = 0;
                k0.V = 1;
                if(mutex0.lock(null, k0) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                s = "drawer_replace";
                s1 = "";
                v1 = 0;
                mutex1 = mutex0;
                mutex2 = mutex1;
                c01 = c00;
                v2 = 0;
                goto label_52;
            }
            case 1: {
                int v3 = k0.M;
                int v4 = k0.I;
                mutex2 = k0.G;
                s1 = k0.E;
                DevLog devLog2 = k0.D;
                String s2 = k0.B;
                Mutex mutex3 = k0.w;
                c01 = k0.r;
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
                        nc.M m0 = new nc.M(this, c01, null);
                        k0.r = null;
                        k0.w = mutex1;
                        k0.B = s;
                        k0.D = devLog1;
                        k0.E = s1;
                        k0.G = mutex2;
                        k0.I = v1;
                        k0.M = v2;
                        k0.N = v5;
                        k0.V = 2;
                        object0 = BuildersKt.withContext(NonCancellable.INSTANCE, m0, k0);
                    }
                    catch(Throwable throwable1) {
                        s3 = s1;
                        goto label_100;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex4 = mutex1;
                    v6 = v5;
                    mutex5 = mutex2;
                    s3 = s1;
                    s4 = s;
                    c02 = (C0)object0;
                    goto label_106;
                    try {
                    label_79:
                        v6 = k0.N;
                        mutex5 = k0.G;
                        s3 = k0.E;
                        devLog1 = k0.D;
                        s4 = k0.B;
                        mutex4 = k0.w;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex2 = mutex5;
                        s = s4;
                        mutex1 = mutex4;
                        v5 = v6;
                        goto label_100;
                    }
                    try {
                        c02 = (C0)object0;
                        goto label_106;
                    }
                    catch(Throwable throwable1) {
                        mutex1 = mutex4;
                        v5 = v6;
                        s = s4;
                        mutex2 = mutex5;
                    }
                label_100:
                    long v7 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v7 + "ms)");
                    throw throwable1;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                goto label_79;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
        try {
        label_106:
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex4.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v8 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw throwable0;
        }
        mutex5.unlock(null);
        return c02;
    }

    public final Object N(DrawerPlaylistInfo drawerPlaylistInfo0, String s, long v, oe.c c0) {
        long v55;
        long v54;
        String s15;
        DrawerPlaylistInfo drawerPlaylistInfo8;
        int v53;
        Mutex mutex19;
        Mutex mutex18;
        long v52;
        int v51;
        String s14;
        List list8;
        DevLog devLog6;
        int v50;
        List list7;
        lc.h h2;
        Mutex mutex17;
        Flow flow0;
        int v49;
        List list6;
        Iterator iterator0;
        int v48;
        List list5;
        ie.o o0;
        DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0;
        int v46;
        LogU logU0;
        Mutex mutex2;
        long v3;
        Mutex mutex1;
        String s2;
        DevLog devLog0;
        String s1;
        Mutex mutex0;
        long v2;
        Object object2;
        Mutex mutex6;
        ne.a a1;
        int v17;
        String s4;
        int v16;
        int v15;
        List list2;
        long v14;
        int v13;
        long v12;
        Mutex mutex5;
        int v11;
        lc.h h1;
        DrawerPlaylistInfo drawerPlaylistInfo2;
        Mutex mutex4;
        String s3;
        DevLog devLog1;
        Object object1;
        Mutex mutex3;
        long v5;
        int v28;
        int v27;
        int v26;
        Object object4;
        Mutex mutex9;
        long v25;
        String s6;
        DevLog devLog3;
        ne.a a2;
        List list4;
        DrawerPlaylistInfo drawerPlaylistInfo3;
        Mutex mutex8;
        String s5;
        DevLog devLog2;
        Object object3;
        Mutex mutex7;
        long v23;
        DrawerPlaylistInfo drawerPlaylistInfo6;
        long v39;
        int v38;
        int v37;
        ne.a a3;
        DrawerPlaylistInfo drawerPlaylistInfo5;
        Object object6;
        String s11;
        int v36;
        Mutex mutex12;
        String s10;
        long v35;
        String s9;
        DrawerPlaylistInfo drawerPlaylistInfo4;
        int v34;
        int v32;
        int v30;
        long v29;
        int v45;
        long v44;
        Mutex mutex15;
        int v43;
        N n0;
        if(c0 instanceof N) {
            n0 = (N)c0;
            int v1 = n0.d0;
            if((v1 & 0x80000000) == 0) {
                n0 = new N(this, c0);
            }
            else {
                n0.d0 = v1 ^ 0x80000000;
            }
        }
        else {
            n0 = new N(this, c0);
        }
        Object object0 = n0.b0;
        ne.a a0 = ne.a.a;
        switch(n0.d0) {
            case 0: {
                n.D(object0);
                Mutex mutex16 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex16.hashCode(), "Lock[", "]  try : drawer_resetWithDrawerPlaylistInfo"), null, false, 6, null);
                DevLog devLog5 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex16.hashCode(), "]  try : drawer_resetWithDrawerPlaylistInfo", devLog5);
                n0.r = drawerPlaylistInfo0;
                s9 = s;
                n0.w = s9;
                n0.B = mutex16;
                n0.D = "drawer_resetWithDrawerPlaylistInfo";
                n0.E = devLog5;
                s11 = "";
                n0.G = "";
                n0.I = mutex16;
                v44 = v;
                n0.S = v44;
                n0.V = 0;
                n0.W = 0;
                n0.d0 = 1;
                if(mutex16.lock(null, n0) == a0) {
                    return a0;
                }
                drawerPlaylistInfo6 = drawerPlaylistInfo0;
                mutex15 = mutex16;
                mutex0 = mutex15;
                s10 = "drawer_resetWithDrawerPlaylistInfo";
                devLog0 = devLog5;
                v45 = 0;
                v43 = 0;
                break;
            }
            case 1: {
                int v40 = n0.V;
                long v41 = n0.S;
                Mutex mutex13 = n0.I;
                s11 = n0.G;
                devLog0 = n0.E;
                int v42 = n0.W;
                String s12 = n0.D;
                Mutex mutex14 = n0.B;
                String s13 = n0.w;
                DrawerPlaylistInfo drawerPlaylistInfo7 = n0.r;
                n.D(object0);
                v43 = v40;
                s10 = s12;
                drawerPlaylistInfo6 = drawerPlaylistInfo7;
                s9 = s13;
                mutex0 = mutex13;
                mutex15 = mutex14;
                v44 = v41;
                v45 = v42;
                break;
            }
            case 2: {
                try {
                    v29 = n0.T;
                    v30 = n0.W;
                    int v31 = n0.V;
                    v32 = n0.X;
                    long v33 = n0.S;
                    v34 = n0.Y;
                    Mutex mutex10 = n0.I;
                    Object object5 = n0.G;
                    DevLog devLog4 = n0.E;
                    String s7 = n0.D;
                    Mutex mutex11 = n0.B;
                    String s8 = n0.w;
                    drawerPlaylistInfo4 = n0.r;
                    s9 = s8;
                    v35 = v33;
                    devLog0 = devLog4;
                    s10 = s7;
                    mutex12 = mutex11;
                    v36 = v31;
                    s11 = object5;
                    mutex0 = mutex10;
                    n.D(object0);
                    s9 = s8;
                    v35 = v33;
                    devLog0 = devLog4;
                    s10 = s7;
                    object6 = object0;
                    mutex12 = mutex11;
                    v36 = v31;
                    s11 = object5;
                    mutex0 = mutex10;
                    drawerPlaylistInfo5 = drawerPlaylistInfo4;
                    a3 = a0;
                    v37 = v30;
                    v38 = v34;
                    v39 = v29;
                    goto label_248;
                }
                catch(Throwable throwable1) {
                    drawerPlaylistInfo6 = drawerPlaylistInfo4;
                    a3 = a0;
                    v37 = v30;
                    v38 = v34;
                    v39 = v29;
                    drawerAddRequestPlayableListInfo0 = n.t(throwable1);
                    goto label_262;
                }
            }
            case 3: {
                try {
                    int v18 = n0.Z;
                    int v19 = n0.Y;
                    int v20 = n0.X;
                    int v21 = n0.W;
                    int v22 = n0.V;
                    v23 = n0.T;
                    long v24 = n0.S;
                    List list3 = n0.M;
                    mutex7 = n0.I;
                    object3 = n0.G;
                    devLog2 = n0.E;
                    s5 = n0.D;
                    mutex8 = n0.B;
                    drawerPlaylistInfo3 = n0.r;
                    n.D(object0);
                    mutex5 = mutex7;
                    list4 = list3;
                    a2 = a0;
                    devLog3 = devLog2;
                    s6 = s5;
                    v14 = v24;
                    v25 = v23;
                    mutex9 = mutex8;
                    object4 = object0;
                    v26 = v18;
                    v11 = v20;
                    v27 = v22;
                    s4 = object3;
                    v15 = v21;
                    v28 = v19;
                    goto label_337;
                }
                catch(Throwable throwable0) {
                    mutex0 = mutex7;
                    s1 = object3;
                    devLog0 = devLog2;
                    s2 = s5;
                    mutex2 = mutex8;
                    v3 = v23;
                    goto label_470;
                }
            }
            case 4: {
                try {
                    int v4 = n0.Y;
                    v5 = n0.T;
                    int v6 = n0.X;
                    int v7 = n0.W;
                    int v8 = n0.V;
                    int v9 = n0.Z;
                    long v10 = n0.S;
                    lc.h h0 = n0.N;
                    List list1 = n0.M;
                    mutex3 = n0.I;
                    object1 = n0.G;
                    devLog1 = n0.E;
                    s3 = n0.D;
                    mutex4 = n0.B;
                    DrawerPlaylistInfo drawerPlaylistInfo1 = n0.r;
                    n.D(object0);
                    drawerPlaylistInfo2 = drawerPlaylistInfo1;
                    h1 = h0;
                    v11 = v6;
                    devLog0 = devLog1;
                    mutex5 = mutex3;
                    v12 = v5;
                    v13 = v9;
                    v14 = v10;
                    list2 = list1;
                    v15 = v7;
                    v16 = v8;
                    s4 = object1;
                    s2 = s3;
                    v17 = v4;
                    a1 = a0;
                    mutex6 = mutex4;
                    object2 = object0;
                    goto label_386;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex4;
                    v3 = v5;
                    s1 = object1;
                    devLog0 = devLog1;
                    s2 = s3;
                    mutex0 = mutex3;
                    goto label_470;
                }
            }
            case 5: {
                v2 = n0.T;
                List list0 = (List)n0.N;
                mutex0 = n0.I;
                s1 = n0.G;
                devLog0 = n0.E;
                s2 = n0.D;
                mutex1 = n0.B;
                try {
                    n.D(object0);
                    goto label_460;
                }
                catch(Throwable throwable0) {
                    v3 = v2;
                    mutex2 = mutex1;
                    goto label_470;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v39 = System.currentTimeMillis();
        }
        catch(Throwable throwable2) {
            mutex0.unlock(null);
            throw throwable2;
        }
        try {
            logU0 = MutexLockUtil.INSTANCE.getLog();
            v46 = mutex15.hashCode();
        }
        catch(Throwable throwable0) {
            mutex12 = mutex15;
            goto label_257;
        }
        try {
            LogU.debug$default(logU0, "Lock[" + v46 + "] " + s11 + " Lock obtain : " + s10, null, false, 6, null);
            devLog0.put("Lock[" + mutex15.hashCode() + "] " + s11 + " Lock obtain : " + s10);
        }
        catch(Throwable throwable0) {
            mutex12 = mutex15;
            goto label_257;
        }
        try {
            mutex12 = mutex15;
            v36 = v43;
            DrawerPlaylist playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(drawerPlaylistInfo6, drawerPlaylistInfo6.getMenuId(), null);
            n0.r = drawerPlaylistInfo6;
            n0.w = s9;
            n0.B = mutex15;
            n0.D = s10;
            n0.E = devLog0;
            n0.G = s11;
            n0.I = mutex0;
            n0.S = v44;
            v36 = v43;
            n0.V = v36;
            mutex12 = mutex15;
            n0.W = v45;
            n0.X = 0;
            n0.T = v39;
            n0.Y = 0;
            n0.Z = 0;
            n0.d0 = 2;
            a3 = a0;
            object6 = playDataForSeverContent$DrawerPlaylist0.getPlayableList(n0);
            a3 = a0;
        }
        catch(Throwable throwable1) {
            v37 = v45;
            v35 = v44;
            v38 = 0;
            v32 = 0;
            drawerAddRequestPlayableListInfo0 = n.t(throwable1);
            goto label_262;
        }
        if(object6 != a3) {
            v37 = v45;
            v35 = v44;
            drawerPlaylistInfo5 = drawerPlaylistInfo6;
            v38 = 0;
            v32 = 0;
            try {
            label_248:
                q.e(object6, "null cannot be cast to non-null type com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo");
                drawerPlaylistInfo6 = drawerPlaylistInfo5;
                drawerAddRequestPlayableListInfo0 = (DrawerAddRequestPlayableListInfo)object6;
                drawerPlaylistInfo6 = drawerPlaylistInfo5;
                goto label_262;
            }
            catch(Throwable throwable1) {
            }
            try {
                drawerAddRequestPlayableListInfo0 = n.t(throwable1);
                goto label_262;
            }
            catch(Throwable throwable0) {
            }
        label_257:
            s2 = s10;
            s1 = s11;
            v3 = v39;
            mutex2 = mutex12;
            goto label_470;
        label_262:
            v14 = v35;
            DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo1 = drawerAddRequestPlayableListInfo0;
            s1 = s11;
            mutex2 = mutex12;
            s2 = s10;
            if(drawerAddRequestPlayableListInfo1 instanceof ie.o) {
                drawerAddRequestPlayableListInfo1 = null;
            }
            if(drawerAddRequestPlayableListInfo1 == null) {
                try {
                    o0 = n.t(new Exception("Failed to get list data from server"));
                }
                catch(Throwable throwable0) {
                    v3 = v39;
                    goto label_470;
                }
                try {
                    long v47 = System.currentTimeMillis() - v39;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v47 + "ms)", null, false, 6, null);
                    devLog0.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v47 + "ms)");
                }
                catch(Throwable throwable2) {
                    mutex0.unlock(null);
                    throw throwable2;
                }
                mutex0.unlock(null);
                return o0;
            }
            try {
                if(drawerAddRequestPlayableListInfo1.getUserRequestedPlaylist().isEmpty()) {
                    v3 = v39;
                    mutex17 = mutex0;
                    throw new ReplaceDefaultPlaylistException("get empty list from server");
                }
                list5 = drawerAddRequestPlayableListInfo1.getUserRequestedPlaylist();
                v48 = 0;
                iterator0 = list5.iterator();
            label_284:
                while(!iterator0.hasNext()) {
                    goto label_295;
                }
            }
            catch(Throwable throwable0) {
                v3 = v39;
                goto label_470;
            }
            try {
                iterator0.next();
                list6 = list5;
                if(q.b("", s9)) {
                    goto label_297;
                }
            }
            catch(Throwable throwable0) {
                v3 = v39;
                goto label_470;
            }
            try {
                ++v48;
                list5 = list6;
                goto label_284;
            label_295:
                list6 = list5;
                v48 = -1;
            label_297:
                v49 = v48 >= 0 ? v48 : 0;
                flow0 = DrawerPlaylistPreferencesRepository.INSTANCE.getDrawerPlytInfo();
                n0.r = drawerPlaylistInfo6;
                n0.w = null;
                n0.B = mutex2;
                n0.D = s2;
                n0.E = devLog0;
                n0.G = s1;
                n0.I = mutex0;
                n0.M = list6;
                n0.S = v14;
                n0.V = v36;
                n0.W = v37;
                n0.X = v32;
                mutex17 = mutex0;
                n0.T = v39;
                v3 = v39;
            }
            catch(Throwable throwable0) {
                v3 = v39;
                goto label_470;
            }
            try {
                n0.Y = v38;
                n0.Z = v49;
                n0.d0 = 3;
                object4 = FlowKt.firstOrNull(flow0, n0);
                if(object4 != a3) {
                    goto label_323;
                }
                return a3;
            }
            catch(Throwable throwable0) {
                goto label_469;
            }
        label_323:
            list4 = list6;
            v26 = v49;
            a2 = a3;
            mutex9 = mutex2;
            drawerPlaylistInfo3 = drawerPlaylistInfo6;
            v11 = v32;
            s4 = s1;
            s6 = s2;
            v15 = v37;
            mutex5 = mutex17;
            v28 = v38;
            v27 = v36;
            devLog3 = devLog0;
            v25 = v3;
            try {
            label_337:
                if(q.b(object4, drawerPlaylistInfo3)) {
                    goto label_345;
                }
                else {
                    goto label_407;
                }
                goto label_423;
            }
            catch(Throwable throwable0) {
                devLog0 = devLog3;
                s2 = s6;
                s1 = s4;
                v3 = v25;
                mutex2 = mutex9;
                mutex0 = mutex5;
                goto label_470;
            }
            try {
            label_345:
                h2 = this.m;
                n0.r = drawerPlaylistInfo3;
                n0.w = null;
                n0.B = mutex9;
                n0.D = s6;
                n0.E = devLog3;
                n0.G = s4;
                n0.I = mutex5;
                n0.M = list4;
                n0.N = h2;
                n0.S = v14;
                n0.V = v27;
                n0.W = v15;
                n0.X = v11;
                n0.T = v25;
                drawerPlaylistInfo2 = drawerPlaylistInfo3;
                n0.Y = v28;
                v17 = v28;
                n0.Z = v26;
                v12 = v25;
                n0.d0 = 4;
                object2 = this.b.c(n0);
                a1 = a2;
            }
            catch(Throwable throwable0) {
                s2 = s6;
                s1 = s4;
                devLog0 = devLog3;
                v3 = v12;
                mutex2 = mutex9;
                mutex0 = mutex5;
                goto label_470;
            }
            if(object2 == a1) {
                return a1;
            }
            v16 = v27;
            devLog0 = devLog3;
            v13 = v26;
            h1 = h2;
            s2 = s6;
            mutex6 = mutex9;
            list2 = list4;
            try {
            label_386:
                h1.getClass();
                list7 = lc.h.f(((List)object2), v13, list2);
                v50 = v15;
                devLog6 = devLog0;
                list8 = list2;
                s14 = s2;
                v51 = v13;
                v52 = v14;
                mutex18 = mutex5;
                mutex19 = mutex6;
                v53 = v11;
                drawerPlaylistInfo8 = drawerPlaylistInfo2;
                s15 = s4;
                v54 = v12;
                goto label_423;
            }
            catch(Throwable throwable0) {
                mutex0 = mutex5;
                s1 = s4;
                v3 = v12;
                mutex2 = mutex6;
                goto label_470;
            }
        label_407:
            v17 = v28;
            a1 = a2;
            list7 = w.a;
            v52 = v14;
            v51 = v26;
            mutex18 = mutex5;
            v50 = v15;
            mutex19 = mutex9;
            s14 = s6;
            devLog6 = devLog3;
            v16 = v27;
            list8 = list4;
            drawerPlaylistInfo8 = drawerPlaylistInfo3;
            s15 = s4;
            v54 = v25;
            v53 = v11;
            try {
            label_423:
                v55 = v54;
                P p0 = new P(v51, v52, drawerPlaylistInfo8, list8, list7, null, this);
                n0.r = null;
                n0.w = null;
                n0.B = mutex19;
                n0.D = s14;
                n0.E = devLog6;
                n0.G = s15;
                n0.I = mutex18;
                n0.M = null;
                n0.N = null;
                n0.S = v52;
                n0.V = v16;
                n0.W = v50;
                n0.X = v53;
                v55 = v54;
                n0.T = v55;
                n0.Y = v17;
                n0.Z = v51;
                n0.d0 = 5;
                if(BuildersKt.withContext(NonCancellable.INSTANCE, p0, n0) == a1) {
                    return a1;
                }
            }
            catch(Throwable throwable0) {
                v3 = v55;
                s2 = s14;
                mutex0 = mutex18;
                s1 = s15;
                devLog0 = devLog6;
                mutex2 = mutex19;
                goto label_470;
            }
            v2 = v55;
            mutex1 = mutex19;
            s2 = s14;
            mutex0 = mutex18;
            s1 = s15;
            devLog0 = devLog6;
            try {
            label_460:
                long v56 = System.currentTimeMillis() - v2;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v56 + "ms)", null, false, 6, null);
                devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v56 + "ms)");
            }
            catch(Throwable throwable2) {
                mutex0.unlock(null);
                throw throwable2;
            }
            mutex0.unlock(null);
            return H.a;
            try {
                v3 = v39;
                mutex17 = mutex0;
                throw new ReplaceDefaultPlaylistException("get empty list from server");
            }
            catch(Throwable throwable0) {
            label_469:
                mutex0 = mutex17;
            }
            try {
            label_470:
                long v57 = System.currentTimeMillis() - v3;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v57 + "ms)", null, false, 6, null);
                devLog0.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s2 + " (" + v57 + "ms)");
                throw throwable0;
            }
            catch(Throwable throwable2) {
                mutex0.unlock(null);
                throw throwable2;
            }
        }
        return a3;
    }

    public final Object O(oe.c c0) {
        Mutex mutex21;
        Mutex mutex20;
        Mutex mutex19;
        long v39;
        Mutex mutex18;
        List list0;
        DevLog devLog9;
        String s13;
        String s12;
        Mutex mutex17;
        DrawerPlaylistInfo drawerPlaylistInfo6;
        String s11;
        int v38;
        Mutex mutex16;
        int v37;
        int v36;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        Mutex mutex15;
        Object object10;
        Mutex mutex14;
        DrawerPlaylistInfo drawerPlaylistInfo5;
        String s10;
        long v34;
        int v33;
        long v31;
        long v30;
        DevLog devLog8;
        Mutex mutex13;
        int v29;
        String s9;
        ne.a a1;
        DrawerPlaylist playDataForSeverContent$DrawerPlaylist0;
        long v28;
        long v27;
        Mutex mutex12;
        Mutex mutex11;
        String s8;
        DevLog devLog7;
        Object object9;
        Mutex mutex10;
        Number number0;
        DrawerPlaylistInfo drawerPlaylistInfo3;
        long v23;
        int v22;
        DevLog devLog6;
        int v21;
        String s7;
        Mutex mutex9;
        int v20;
        Object object8;
        String s6;
        String s5;
        DevLog devLog5;
        DrawerPlaylistInfo drawerPlaylistInfo1;
        Object object5;
        DrawerPlaylistInfo drawerPlaylistInfo0;
        Mutex mutex7;
        String s4;
        Object object4;
        DevLog devLog4;
        long v15;
        int v10;
        int v9;
        DevLog devLog3;
        String s3;
        Object object3;
        int v8;
        int v7;
        long v6;
        Mutex mutex6;
        DevLog devLog2;
        Mutex mutex5;
        Object object2;
        Mutex mutex4;
        int v5;
        LogU logU0;
        long v4;
        int v2;
        Mutex mutex2;
        int v1;
        String s1;
        String s;
        DevLog devLog1;
        Mutex mutex1;
        nc.Q q0;
        if(c0 instanceof nc.Q) {
            q0 = (nc.Q)c0;
            int v = q0.Z;
            if((v & 0x80000000) == 0) {
                q0 = new nc.Q(this, c0);
            }
            else {
                q0.Z = v ^ 0x80000000;
            }
        }
        else {
            q0 = new nc.Q(this, c0);
        }
        Object object0 = q0.X;
        ne.a a0 = ne.a.a;
        B0 b00 = this.b;
        switch(q0.Z) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_restore"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_restore", devLog0);
                q0.r = mutex0;
                q0.w = "drawer_restore";
                q0.B = devLog0;
                q0.D = "";
                q0.E = mutex0;
                q0.M = 0;
                q0.N = 0;
                q0.Z = 1;
                if(mutex0.lock(null, q0) != a0) {
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s = "drawer_restore";
                    s1 = "";
                    v1 = 0;
                    mutex2 = mutex1;
                    v2 = 0;
                    goto label_48;
                }
                return a0;
            }
            case 1: {
                v1 = q0.M;
                mutex2 = q0.E;
                Object object1 = q0.D;
                devLog1 = q0.B;
                String s2 = q0.w;
                int v3 = q0.N;
                Mutex mutex3 = q0.r;
                n.D(object0);
                s = s2;
                s1 = object1;
                mutex1 = mutex3;
                v2 = v3;
                try {
                label_48:
                    v4 = System.currentTimeMillis();
                    logU0 = MutexLockUtil.INSTANCE.getLog();
                    v5 = mutex1.hashCode();
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex1;
                    goto label_74;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + v5 + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    mutex4 = mutex1;
                    Flow flow0 = DrawerPlaylistPreferencesRepository.INSTANCE.getDrawerPlytInfo();
                    mutex4 = mutex1;
                    q0.r = mutex4;
                    q0.w = s;
                    q0.B = devLog1;
                    q0.D = s1;
                    q0.E = mutex2;
                    q0.M = v1;
                    q0.N = v2;
                    q0.S = 0;
                    q0.V = v4;
                    q0.T = 0;
                    q0.Z = 2;
                    object2 = FlowKt.firstOrNull(flow0, q0);
                    goto label_79;
                }
                catch(Throwable throwable0) {
                }
            label_74:
                mutex5 = mutex2;
                devLog2 = devLog1;
                mutex6 = mutex4;
                v6 = v4;
                goto label_438;
            label_79:
                if(object2 != a0) {
                    v7 = v1;
                    mutex6 = mutex4;
                    v6 = v4;
                    v8 = v2;
                    object3 = object2;
                    s3 = s;
                    devLog3 = devLog1;
                    v9 = 0;
                    mutex5 = mutex2;
                    v10 = 0;
                    goto label_120;
                }
                return a0;
            }
            case 2: {
                try {
                    int v11 = q0.T;
                    int v12 = q0.S;
                    int v13 = q0.N;
                    int v14 = q0.M;
                    mutex5 = q0.E;
                    v15 = q0.V;
                    devLog4 = q0.B;
                    object4 = q0.D;
                    s4 = q0.w;
                    mutex7 = q0.r;
                    n.D(object0);
                    v9 = v12;
                    object3 = object0;
                    mutex6 = mutex7;
                    devLog3 = devLog4;
                    v6 = v15;
                    v8 = v13;
                    v10 = v11;
                    s1 = object4;
                    s3 = s4;
                    v7 = v14;
                }
                catch(Throwable throwable0) {
                    devLog2 = devLog4;
                    s1 = object4;
                    s = s4;
                    mutex6 = mutex7;
                    v6 = v15;
                    goto label_438;
                }
                try {
                label_120:
                    if(((DrawerPlaylistInfo)object3) == null || ((DrawerPlaylistInfo)object3).getMenuId().length() <= 0) {
                        throw new ReplaceDefaultPlaylistException("get from local failed");
                    }
                    q0.r = mutex6;
                    q0.w = s3;
                    q0.B = devLog3;
                    q0.D = s1;
                    q0.E = mutex5;
                    q0.G = (DrawerPlaylistInfo)object3;
                    q0.M = v7;
                    q0.N = v8;
                    q0.S = v9;
                    q0.V = v6;
                    q0.T = v10;
                    drawerPlaylistInfo0 = (DrawerPlaylistInfo)object3;
                    q0.Z = 3;
                    object5 = b00.a(q0);
                }
                catch(Throwable throwable0) {
                    devLog2 = devLog3;
                    s = s3;
                    goto label_438;
                }
                if(object5 != a0) {
                    Object object6 = object5;
                    drawerPlaylistInfo1 = drawerPlaylistInfo0;
                    goto label_178;
                    try {
                        throw new ReplaceDefaultPlaylistException("get from local failed");
                        try {
                        label_145:
                            int v16 = q0.T;
                            int v17 = q0.S;
                            int v18 = q0.N;
                            int v19 = q0.M;
                            DrawerPlaylistInfo drawerPlaylistInfo2 = q0.G;
                            v15 = q0.V;
                            Object object7 = q0.D;
                            Mutex mutex8 = q0.E;
                            devLog5 = q0.B;
                            s5 = q0.w;
                            mutex7 = q0.r;
                            s1 = object7;
                            mutex5 = mutex8;
                            n.D(object0);
                            v7 = v19;
                            devLog3 = devLog5;
                            v9 = v17;
                            s1 = object7;
                            v10 = v16;
                            drawerPlaylistInfo1 = drawerPlaylistInfo2;
                            mutex5 = mutex8;
                            s3 = s5;
                            mutex6 = mutex7;
                            v6 = v15;
                            object6 = object0;
                            v8 = v18;
                        }
                        catch(Throwable throwable0) {
                            devLog2 = devLog5;
                            s = s5;
                            mutex6 = mutex7;
                            v6 = v15;
                            goto label_438;
                        }
                    label_178:
                        s6 = (String)object6;
                        q0.r = mutex6;
                        q0.w = s3;
                        q0.B = devLog3;
                        q0.D = s1;
                        q0.E = mutex5;
                        q0.G = drawerPlaylistInfo1;
                        q0.I = s6;
                        q0.M = v7;
                        q0.N = v8;
                        q0.S = v9;
                        q0.V = v6;
                        q0.T = v10;
                        q0.Z = 4;
                        object8 = b00.b(q0);
                        goto label_198;
                    }
                    catch(Throwable throwable0) {
                    }
                    devLog2 = devLog3;
                    s = s3;
                    goto label_438;
                }
                return a0;
            }
            case 3: {
                goto label_145;
            label_198:
                if(object8 != a0) {
                    try {
                        v20 = v9;
                        mutex9 = mutex5;
                        s7 = s6;
                        v21 = v8;
                        devLog6 = devLog3;
                        v22 = v7;
                        v23 = v6;
                        drawerPlaylistInfo3 = drawerPlaylistInfo1;
                        number0 = (Number)object8;
                        goto label_246;
                        try {
                        label_210:
                            v23 = q0.V;
                            int v24 = q0.S;
                            int v25 = q0.N;
                            v22 = q0.M;
                            s7 = q0.I;
                            DrawerPlaylistInfo drawerPlaylistInfo4 = q0.G;
                            int v26 = q0.T;
                            mutex10 = q0.E;
                            object9 = q0.D;
                            devLog7 = q0.B;
                            s8 = q0.w;
                            mutex11 = q0.r;
                            n.D(object0);
                            drawerPlaylistInfo3 = drawerPlaylistInfo4;
                            mutex6 = mutex11;
                            mutex9 = mutex10;
                            devLog6 = devLog7;
                            v20 = v24;
                            s1 = object9;
                            s3 = s8;
                            v21 = v25;
                            v10 = v26;
                        }
                        catch(Throwable throwable0) {
                            mutex5 = mutex10;
                            s1 = object9;
                            devLog2 = devLog7;
                            s = s8;
                            mutex6 = mutex11;
                            v6 = v23;
                            goto label_438;
                        }
                        number0 = (Number)object0;
                        goto label_246;
                    }
                    catch(Throwable throwable0) {
                    }
                    mutex12 = mutex9;
                    goto label_361;
                }
                return a0;
            }
            case 4: {
                goto label_210;
                try {
                label_246:
                    v27 = number0.longValue();
                }
                catch(Throwable throwable0) {
                    v6 = v23;
                    mutex12 = mutex9;
                    devLog2 = devLog6;
                    s = s3;
                    mutex5 = mutex12;
                    goto label_438;
                }
                try {
                    v28 = v27;
                    mutex12 = mutex9;
                    playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(drawerPlaylistInfo3, drawerPlaylistInfo3.getMenuId(), null);
                    q0.r = mutex6;
                    q0.w = s3;
                    q0.B = devLog6;
                    q0.D = s1;
                    q0.E = mutex9;
                    q0.G = drawerPlaylistInfo3;
                    q0.I = s7;
                    q0.M = v22;
                    q0.N = v21;
                    q0.S = v20;
                    q0.V = v23;
                    q0.T = v10;
                    mutex12 = mutex9;
                    q0.W = v28;
                }
                catch(Throwable throwable1) {
                    a1 = a0;
                    goto label_347;
                }
                try {
                    q0.Z = 5;
                    a1 = a0;
                    object0 = playDataForSeverContent$DrawerPlaylist0.getPlayableList(q0);
                    a1 = a0;
                }
                catch(Throwable throwable1) {
                    goto label_347;
                }
                if(object0 == a1) {
                    return a1;
                }
                s9 = s3;
                v29 = v10;
                mutex13 = mutex12;
                devLog8 = devLog6;
                v30 = v23;
                goto label_329;
            }
            case 5: {
                try {
                    v29 = q0.T;
                    v31 = q0.V;
                    int v32 = q0.S;
                    v33 = q0.N;
                    v34 = q0.W;
                    s10 = q0.I;
                    int v35 = q0.M;
                    drawerPlaylistInfo5 = q0.G;
                    mutex14 = q0.E;
                    object10 = q0.D;
                    devLog8 = q0.B;
                    s9 = q0.w;
                    mutex15 = q0.r;
                    v20 = v32;
                    v22 = v35;
                    n.D(object0);
                    a1 = a0;
                    v28 = v34;
                    mutex6 = mutex15;
                    drawerPlaylistInfo3 = drawerPlaylistInfo5;
                    s7 = s10;
                    mutex13 = mutex14;
                    v20 = v32;
                    v22 = v35;
                    v30 = v31;
                    s1 = object10;
                    v21 = v33;
                }
                catch(Throwable throwable1) {
                    devLog6 = devLog8;
                    mutex12 = mutex14;
                    a1 = a0;
                    v28 = v34;
                    mutex6 = mutex15;
                    drawerPlaylistInfo3 = drawerPlaylistInfo5;
                    s3 = s9;
                    s7 = s10;
                    v10 = v29;
                    v23 = v31;
                    s1 = object10;
                    v21 = v33;
                    goto label_347;
                }
                try {
                label_329:
                    addRequestPlayableListInfo0 = (AddRequestPlayableListInfo)object0;
                    v36 = v29;
                    v37 = v20;
                    mutex16 = mutex13;
                    v38 = v21;
                    s11 = s9;
                    drawerPlaylistInfo6 = drawerPlaylistInfo3;
                    mutex17 = mutex6;
                    s12 = s1;
                    s13 = s7;
                    devLog9 = devLog8;
                    goto label_366;
                }
                catch(Throwable throwable1) {
                    v10 = v29;
                    s3 = s9;
                    mutex12 = mutex13;
                    v23 = v30;
                    devLog6 = devLog8;
                }
                try {
                label_347:
                    addRequestPlayableListInfo0 = n.t(throwable1);
                    drawerPlaylistInfo6 = drawerPlaylistInfo3;
                    mutex17 = mutex6;
                    s12 = s1;
                    s13 = s7;
                    devLog9 = devLog6;
                    v30 = v23;
                    v37 = v20;
                    v36 = v10;
                    v38 = v21;
                    s11 = s3;
                    mutex16 = mutex12;
                    goto label_366;
                }
                catch(Throwable throwable0) {
                }
            label_361:
                v6 = v23;
                devLog2 = devLog6;
                s = s3;
                mutex5 = mutex12;
                goto label_438;
                try {
                label_366:
                    if(addRequestPlayableListInfo0 instanceof ie.o) {
                        addRequestPlayableListInfo0 = null;
                    }
                    if(addRequestPlayableListInfo0 != null) {
                        if(!addRequestPlayableListInfo0.getUserRequestedPlaylist().isEmpty()) {
                            list0 = addRequestPlayableListInfo0.getUserRequestedPlaylist();
                            goto label_376;
                        }
                        mutex18 = mutex17;
                        v39 = v30;
                        throw new ReplaceDefaultPlaylistException("get empty list from server");
                    }
                    mutex18 = mutex17;
                    v39 = v30;
                    throw new ReplaceDefaultPlaylistException("get from server failed");
                }
                catch(Throwable throwable0) {
                    mutex18 = mutex17;
                    v39 = v30;
                    goto label_413;
                }
                try {
                label_376:
                    mutex18 = mutex17;
                    v39 = v30;
                    d8.d.E(System.currentTimeMillis(), list0);
                    mutex18 = mutex17;
                    v39 = v30;
                    T t0 = new T(this, addRequestPlayableListInfo0, drawerPlaylistInfo6, s13, v28, null);
                    q0.r = mutex18;
                    q0.w = s11;
                    q0.B = devLog9;
                    q0.D = s12;
                    q0.E = mutex16;
                    q0.G = null;
                    q0.I = null;
                    q0.M = v22;
                    q0.N = v38;
                    q0.S = v37;
                    q0.V = v39;
                    q0.T = v36;
                    q0.W = v28;
                    q0.Z = 6;
                    object0 = BuildersKt.withContext(NonCancellable.INSTANCE, t0, q0);
                    if(object0 == a1) {
                        return a1;
                    }
                    v6 = v39;
                    mutex19 = mutex16;
                    mutex20 = mutex18;
                    s1 = s12;
                    devLog2 = devLog9;
                    s = s11;
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_413:
                s1 = s12;
                devLog2 = devLog9;
                s = s11;
                v6 = v39;
                mutex5 = mutex16;
                mutex6 = mutex18;
                goto label_438;
            }
            case 6: {
                try {
                    v6 = q0.V;
                    mutex19 = q0.E;
                    s1 = q0.D;
                    devLog2 = q0.B;
                    s = q0.w;
                    mutex20 = q0.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex19;
                    mutex6 = mutex20;
                }
                goto label_438;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            C0 c00 = (C0)object0;
            goto label_445;
        }
        catch(Throwable throwable0) {
            mutex5 = mutex19;
            mutex6 = mutex20;
        }
        try {
        label_438:
            long v40 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v40 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex6.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v40 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable2) {
            mutex21 = mutex5;
            mutex21.unlock(null);
            throw throwable2;
        }
        try {
        label_445:
            long v41 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex20.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v41 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex20.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v41 + "ms)");
        }
        catch(Throwable throwable2) {
            mutex21 = mutex19;
            mutex21.unlock(null);
            throw throwable2;
        }
        mutex19.unlock(null);
        return H.a;
    }

    public final Object P(int v, long v1, boolean z, String s, boolean z1, oe.c c0) {
        W w0;
        if(c0 instanceof W) {
            w0 = (W)c0;
            int v2 = w0.D;
            if((v2 & 0x80000000) == 0) {
                w0 = new W(this, c0);
            }
            else {
                w0.D = v2 ^ 0x80000000;
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
                nc.Y y0 = new nc.Y(this, z, v, v1, z1, s, null);
                w0.r = v1;
                w0.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, y0, w0);
                return object0 == a0 ? a0 : new e0(((C0)object0), v1);
            }
            case 1: {
                long v3 = w0.r;
                n.D(object0);
                return new e0(((C0)object0), v3);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object Q(M m0, oe.c c0) {
        d0 d00;
        if(c0 instanceof d0) {
            d00 = (d0)c0;
            int v = d00.D;
            if((v & 0x80000000) == 0) {
                d00 = new d0(this, c0);
            }
            else {
                d00.D = v ^ 0x80000000;
            }
        }
        else {
            d00 = new d0(this, c0);
        }
        Object object0 = d00.w;
        ne.a a0 = ne.a.a;
        switch(d00.D) {
            case 0: {
                n.D(object0);
                f0 f00 = new f0(this, m0, null);
                d00.r = m0;
                d00.D = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, f00, d00) == a0 ? a0 : new Success(m0);
            }
            case 1: {
                m0 = d00.r;
                n.D(object0);
                return new Success(m0);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object R(List list0, boolean z, oe.c c0) {
        h0 h00;
        if(c0 instanceof h0) {
            h00 = (h0)c0;
            int v = h00.D;
            if((v & 0x80000000) == 0) {
                h00 = new h0(this, c0);
            }
            else {
                h00.D = v ^ 0x80000000;
            }
        }
        else {
            h00 = new h0(this, c0);
        }
        Object object0 = h00.w;
        ne.a a0 = ne.a.a;
        switch(h00.D) {
            case 0: {
                n.D(object0);
                kotlin.jvm.internal.C c1 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
                c1.a = true;
                j0 j00 = new j0(this, list0, c1, z, null);
                h00.r = c1;
                h00.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, j00, h00);
                return object0 == a0 ? a0 : new k0(((C0)object0), this.i, c1.a);
            }
            case 1: {
                kotlin.jvm.internal.C c2 = h00.r;
                n.D(object0);
                return new k0(((C0)object0), this.i, c2.a);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object S(boolean z, oe.c c0) {
        l0 l00;
        if(c0 instanceof l0) {
            l00 = (l0)c0;
            int v = l00.D;
            if((v & 0x80000000) == 0) {
                l00 = new l0(this, c0);
            }
            else {
                l00.D = v ^ 0x80000000;
            }
        }
        else {
            l00 = new l0(this, c0);
        }
        Object object0 = l00.w;
        ne.a a0 = ne.a.a;
        switch(l00.D) {
            case 0: {
                n.D(object0);
                n0 n00 = new n0(null, this, z);
                l00.r = z;
                l00.D = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, n00, l00) == a0 ? a0 : new com.melon.playlist.interfaces.SetShuffleResult.Success(z);
            }
            case 1: {
                z = l00.r;
                n.D(object0);
                return new com.melon.playlist.interfaces.SetShuffleResult.Success(z);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object T(String s, oe.c c0) {
        C0 c00;
        Mutex mutex5;
        long v6;
        Mutex mutex4;
        Object object2;
        int v2;
        Mutex mutex1;
        String s2;
        String s1;
        DevLog devLog1;
        int v1;
        Mutex mutex0;
        o0 o00;
        if(c0 instanceof o0) {
            o00 = (o0)c0;
            int v = o00.V;
            if((v & 0x80000000) == 0) {
                o00 = new o0(this, c0);
            }
            else {
                o00.V = v ^ 0x80000000;
            }
        }
        else {
            o00 = new o0(this, c0);
        }
        Object object0 = o00.S;
        ne.a a0 = ne.a.a;
        switch(o00.V) {
            case 0: {
                n.D(object0);
                ArrayList arrayList0 = e1.b.B(this.I());
                if(arrayList0.isEmpty()) {
                    return null;
                }
                o00.r = s;
                o00.V = 1;
                if(this.p.e(arrayList0, s, o00) == a0) {
                    return a0;
                }
                goto label_23;
            }
            case 1: {
                s = o00.r;
                n.D(object0);
            label_23:
                mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), H0.b.f(mutex0.hashCode(), "Lock[", "]  try : ", "drawer_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("drawer_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s));
                o00.r = null;
                o00.w = mutex0;
                o00.B = "drawer_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s;
                o00.D = devLog0;
                o00.E = "";
                o00.G = mutex0;
                v1 = 0;
                o00.I = 0;
                o00.M = 0;
                o00.V = 2;
                if(mutex0.lock(null, o00) != a0) {
                    devLog1 = devLog0;
                    s1 = "";
                    s2 = "drawer_updateAlbumImageWhenIsActiveOfflineModeChanged_" + s;
                    mutex1 = mutex0;
                    v2 = 0;
                    goto label_60;
                }
                return a0;
            }
            case 2: {
                int v3 = o00.I;
                Mutex mutex2 = o00.G;
                Object object1 = o00.E;
                DevLog devLog2 = o00.D;
                String s3 = o00.B;
                int v4 = o00.M;
                Mutex mutex3 = o00.w;
                n.D(object0);
                mutex0 = mutex2;
                devLog1 = devLog2;
                s1 = object1;
                s2 = s3;
                v1 = v3;
                mutex1 = mutex3;
                v2 = v4;
                try {
                label_60:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s2, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s2);
                        p0 p00 = new p0(this, null);
                        o00.r = null;
                        o00.w = mutex1;
                        o00.B = s2;
                        o00.D = devLog1;
                        o00.E = s1;
                        o00.G = mutex0;
                        o00.I = v1;
                        o00.M = v2;
                        o00.N = v5;
                        o00.V = 3;
                        object2 = this.U("updateAlbumImageWhenIsActiveOfflineModeChanged", p00, o00);
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v6 = v5;
                        goto label_98;
                    }
                    if(object2 == a0) {
                        return a0;
                    }
                    mutex5 = mutex0;
                    mutex4 = mutex1;
                    v6 = v5;
                    object0 = object2;
                    c00 = (C0)object0;
                    goto label_104;
                    try {
                    label_87:
                        v6 = o00.N;
                        mutex5 = o00.G;
                        s1 = o00.E;
                        devLog1 = o00.D;
                        s2 = o00.B;
                        mutex4 = o00.w;
                        n.D(object0);
                        c00 = (C0)object0;
                        goto label_104;
                    }
                    catch(Throwable throwable1) {
                        mutex0 = mutex5;
                    }
                label_98:
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
                goto label_87;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex0.unlock(null);
        throw throwable0;
        try {
        label_104:
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
        return c00;
    }

    public final Object U(String s, we.n n0, Continuation continuation0) {
        s0 s00;
        if(continuation0 instanceof s0) {
            s00 = (s0)continuation0;
            int v = s00.B;
            if((v & 0x80000000) == 0) {
                s00 = new s0(this, continuation0);
            }
            else {
                s00.B = v ^ 0x80000000;
            }
        }
        else {
            s00 = new s0(this, continuation0);
        }
        Object object0 = s00.r;
        ne.a a0 = ne.a.a;
        MutableStateFlow mutableStateFlow0 = this.h;
        switch(s00.B) {
            case 0: {
                n.D(object0);
                LogU.debug$default(this.f, "updateState() fromCall: " + s, null, false, 6, null);
                Object object1 = mutableStateFlow0.getValue();
                s00.B = 1;
                object0 = n0.invoke(object1, s00);
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
        mutableStateFlow0.setValue(((C0)object0));
        return (C0)object0;
    }

    public final Object V(DrawerPlaylistInfo drawerPlaylistInfo0, String s, oe.c c0) {
        t0 t00 = new t0(this, s, drawerPlaylistInfo0, null);
        Object object0 = BuildersKt.withContext(this.a, t00, c0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Override  // oc.w
    public final Object a(String s, Continuation continuation0) {
        Mutex mutex1;
        String s1;
        nc.C c0;
        if(continuation0 instanceof nc.C) {
            c0 = (nc.C)continuation0;
            int v = c0.E;
            if((v & 0x80000000) == 0) {
                c0 = new nc.C(this, ((oe.c)continuation0));
            }
            else {
                c0.E = v ^ 0x80000000;
            }
        }
        else {
            c0 = new nc.C(this, ((oe.c)continuation0));
        }
        Object object0 = c0.B;
        ne.a a0 = ne.a.a;
        switch(c0.E) {
            case 0: {
                n.D(object0);
                c0.r = s;
                Mutex mutex0 = this.g;
                c0.w = mutex0;
                c0.E = 1;
                if(mutex0.lock(null, c0) == a0) {
                    return a0;
                }
                s1 = s;
                mutex1 = mutex0;
                break;
            }
            case 1: {
                mutex1 = c0.w;
                s1 = c0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object1 = null;
        try {
            for(Object object2: p.Q0(this.j)) {
                if(q.b("", s1)) {
                    object1 = object2;
                    break;
                }
            }
        }
        finally {
            mutex1.unlock(null);
        }
        if(((Playable)object1) != null) {
            ((Playable)object1).setMenuid(this.getMenuId());
            return H.a;
        }
        LogU.error$default(this.f, "processAfterLogging() failed. trackId: " + s1, null, false, 6, null);
        return H.a;
    }

    @Override  // oc.H
    public final Object b(oe.c c0) {
        Mutex mutex1;
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.D;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.D = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.w;
        ne.a a0 = ne.a.a;
        switch(r0.D) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                r0.r = mutex0;
                r0.D = 1;
                if(mutex0.lock(null, r0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                break;
            }
            case 1: {
                mutex1 = r0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            return (C0)this.h.getValue();
        }
        finally {
            mutex1.unlock(null);
        }
    }

    @Override  // oc.z
    public final Object c(List list0, oe.c c0) {
        Mutex mutex7;
        long v5;
        Mutex mutex6;
        Mutex mutex5;
        Mutex mutex4;
        oc.l0 l00;
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
        g0 g00;
        if(c0 instanceof g0) {
            g00 = (g0)c0;
            int v = g00.V;
            if((v & 0x80000000) == 0) {
                g00 = new g0(this, c0);
            }
            else {
                g00.V = v ^ 0x80000000;
            }
        }
        else {
            g00 = new g0(this, c0);
        }
        Object object0 = g00.S;
        ne.a a0 = ne.a.a;
        switch(g00.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_setSelectRepeat"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_setSelectRepeat", devLog0);
                g00.r = list0;
                g00.w = mutex0;
                g00.B = "drawer_setSelectRepeat";
                g00.D = devLog0;
                g00.E = "";
                g00.G = mutex0;
                v1 = 0;
                g00.I = 0;
                g00.M = 0;
                g00.V = 1;
                if(mutex0.lock(null, g00) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                s = "drawer_setSelectRepeat";
                s1 = "";
                list1 = list0;
                mutex2 = mutex1;
                devLog1 = devLog0;
                v2 = 0;
                goto label_50;
            }
            case 1: {
                v2 = g00.M;
                int v3 = g00.I;
                mutex1 = g00.G;
                s1 = g00.E;
                DevLog devLog2 = g00.D;
                String s2 = g00.B;
                mutex2 = g00.w;
                list1 = g00.r;
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
                    goto label_109;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    O o0 = (O)this.h.getValue();
                    try {
                        this.m.getClass();
                        l00 = lc.h.b(list1, o0);
                    }
                    catch(Throwable throwable0) {
                        mutex3 = mutex2;
                        mutex5 = mutex3;
                        mutex6 = mutex1;
                        v5 = v4;
                        goto label_109;
                    }
                    if(l00 == null) {
                        g00.r = null;
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
                    v5 = v4;
                    goto label_109;
                }
                try {
                label_75:
                    g00.w = mutex3;
                    g00.B = s;
                    g00.D = devLog1;
                    g00.E = s1;
                    g00.G = mutex1;
                    g00.I = v1;
                    g00.M = v2;
                    g00.N = v4;
                    g00.V = 2;
                    object0 = this.R(list1, true, g00);
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex3;
                    mutex6 = mutex1;
                    v5 = v4;
                    goto label_109;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex5 = mutex3;
                mutex6 = mutex1;
                v5 = v4;
                mutex4 = mutex6;
                v4 = v5;
                l00 = (oc.l0)object0;
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
            v5 = g00.N;
            mutex6 = g00.G;
            s1 = g00.E;
            devLog1 = g00.D;
            s = g00.B;
            mutex5 = g00.w;
            n.D(object0);
            mutex4 = mutex6;
            v4 = v5;
            l00 = (oc.l0)object0;
            goto label_116;
        }
        catch(Throwable throwable0) {
        }
        try {
        label_109:
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
        label_116:
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
        return l00;
    }

    @Override  // oc.H
    public final MutableStateFlow d() {
        return this.h;
    }

    @Override  // oc.z
    public final O e() {
        return (C0)this.h.getValue();
    }

    public static final Object f(u0 u00, String s, i i0) {
        MutableStateFlow mutableStateFlow0 = u00.h;
        boolean z = ((C0)mutableStateFlow0.getValue()).f;
        H h0 = H.a;
        if(!z) {
            LogU.debug$default(u00.f, "checkCanServiceOfflineCache(): ifOffline is false", null, false, 6, null);
            return h0;
        }
        DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)mutableStateFlow0.getValue()).g;
        String s1 = "";
        String s2 = drawerPlaylistInfo0 == null ? null : k9.h.a(drawerPlaylistInfo0.getResponseType(), new String[]{(drawerPlaylistInfo0.getContsId() == null ? "" : drawerPlaylistInfo0.getContsId()), (drawerPlaylistInfo0.getSeedContsId() == null ? "" : drawerPlaylistInfo0.getSeedContsId()), (drawerPlaylistInfo0.getSeedContsTypeCode() == null ? "" : drawerPlaylistInfo0.getSeedContsTypeCode())});
        if(s2 != null) {
            s1 = s2;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, u00.j));
        Iterator iterator0 = u00.j.iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
            arrayList0.add("");
        }
        Object object0 = u00.e.b(s1, arrayList0, "DrawerPlaylistImpl: " + s, i0);
        return object0 == ne.a.a ? object0 : h0;
    }

    @Override  // oc.w
    public final Object g(Continuation continuation0) {
        oc.g g0;
        int v3;
        Mutex mutex2;
        int v2;
        int v1;
        Mutex mutex0;
        y y0;
        if(continuation0 instanceof y) {
            y0 = (y)continuation0;
            int v = y0.G;
            if((v & 0x80000000) == 0) {
                y0 = new y(this, ((oe.c)continuation0));
            }
            else {
                y0.G = v ^ 0x80000000;
            }
        }
        else {
            y0 = new y(this, ((oe.c)continuation0));
        }
        Object object0 = y0.D;
        ne.a a0 = ne.a.a;
        switch(y0.G) {
            case 0: {
                n.D(object0);
                mutex0 = this.g;
                y0.r = mutex0;
                v1 = 0;
                y0.w = 0;
                y0.G = 1;
                if(mutex0.lock(null, y0) == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                v1 = y0.w;
                Mutex mutex1 = y0.r;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_25:
                    v2 = this.p();
                    y0.r = mutex0;
                    y0.w = v1;
                    y0.B = v2;
                    y0.G = 2;
                    if(this.P(v2, 0L, false, "next", true, y0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    break;
                }
                mutex2 = mutex0;
                v3 = v2;
                g0 = new oc.g(v3);
                goto label_47;
            }
            case 2: {
                try {
                    v3 = y0.B;
                    mutex2 = y0.r;
                    n.D(object0);
                    g0 = new oc.g(v3);
                    goto label_47;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_47:
        mutex2.unlock(null);
        return g0;
    }

    @Override  // oc.H
    public final PlaylistId getId() {
        return PlaylistId.DRAWER;
    }

    @Override  // oc.H
    public final String getMenuId() {
        DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)this.h.getValue()).g;
        String s = drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getMenuId();
        return s == null ? "" : s;
    }

    @Override  // oc.H
    public final Q getState() {
        return this.I();
    }

    @Override  // oc.w
    public final Object h(String s, boolean z, we.n n0, oe.c c0) {
        A0 a00;
        String s12;
        DevLog devLog5;
        Mutex mutex9;
        long v17;
        z0 z00;
        Mutex mutex8;
        String s11;
        List list0;
        Mutex mutex7;
        String s9;
        DevLog devLog4;
        Object object3;
        Mutex mutex6;
        long v12;
        int v10;
        String s8;
        DevLog devLog3;
        int v9;
        boolean z3;
        Mutex mutex5;
        long v8;
        Mutex mutex4;
        int v7;
        String s7;
        String s6;
        int v6;
        ne.a a1;
        Object object2;
        long v5;
        DevLog devLog1;
        Mutex mutex1;
        int v2;
        int v1;
        String s3;
        String s2;
        we.n n1;
        String s1;
        boolean z1;
        Mutex mutex0;
        q0 q00;
        if(c0 instanceof q0) {
            q00 = (q0)c0;
            int v = q00.Z;
            if((v & 0x80000000) == 0) {
                q00 = new q0(this, c0);
            }
            else {
                q00.Z = v ^ 0x80000000;
            }
        }
        else {
            q00 = new q0(this, c0);
        }
        Object object0 = q00.X;
        ne.a a0 = ne.a.a;
        switch(q00.Z) {
            case 0: {
                n.D(object0);
                mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), H0.b.f(mutex0.hashCode(), "Lock[", "]  try : ", "drawer_" + ("updatePlayable-" + s)), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("drawer_" + ("updatePlayable-" + s)));
                q00.r = n0;
                q00.w = "updatePlayable-" + s;
                q00.B = mutex0;
                q00.D = "drawer_" + ("updatePlayable-" + s);
                q00.E = devLog0;
                q00.G = "";
                q00.I = mutex0;
                z1 = z;
                q00.M = z1;
                q00.N = 0;
                q00.S = 0;
                q00.Z = 1;
                if(mutex0.lock(null, q00) == a0) {
                    return a0;
                }
                s1 = "updatePlayable-" + s;
                n1 = n0;
                s2 = "";
                s3 = "drawer_" + ("updatePlayable-" + s);
                v1 = 0;
                v2 = 0;
                mutex1 = mutex0;
                devLog1 = devLog0;
                goto label_61;
            }
            case 1: {
                int v3 = q00.N;
                boolean z2 = q00.M;
                Mutex mutex2 = q00.I;
                Object object1 = q00.G;
                DevLog devLog2 = q00.E;
                String s4 = q00.D;
                int v4 = q00.S;
                Mutex mutex3 = q00.B;
                String s5 = q00.w;
                n1 = q00.r;
                n.D(object0);
                z1 = z2;
                s2 = object1;
                v2 = v4;
                v1 = v3;
                devLog1 = devLog2;
                mutex0 = mutex2;
                s3 = s4;
                mutex1 = mutex3;
                s1 = s5;
                try {
                label_61:
                    v5 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex0.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s2 + " Lock obtain : " + s3, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s2 + " Lock obtain : " + s3);
                    ArrayList arrayList0 = e1.b.B(this.I());
                    q00.r = null;
                    q00.w = s1;
                    q00.B = mutex1;
                    q00.D = s3;
                    q00.E = devLog1;
                    q00.G = s2;
                    q00.I = mutex0;
                    q00.M = z1;
                    q00.N = v1;
                    q00.S = v2;
                    q00.T = 0;
                    q00.W = v5;
                    q00.V = 0;
                    q00.Z = 2;
                    object2 = n1.invoke(arrayList0, q00);
                    a1 = a0;
                }
                catch(Throwable throwable1) {
                    goto label_223;
                }
                if(object2 == a1) {
                    return a1;
                }
                v6 = v2;
                s6 = s3;
                s7 = s1;
                v7 = v1;
                mutex4 = mutex1;
                v8 = v5;
                mutex5 = mutex0;
                z3 = z1;
                v9 = 0;
                devLog3 = devLog1;
                s8 = s2;
                v10 = 0;
                goto label_135;
            }
            case 2: {
                try {
                    int v11 = q00.V;
                    v12 = q00.W;
                    int v13 = q00.S;
                    int v14 = q00.N;
                    boolean z4 = q00.M;
                    int v15 = q00.T;
                    mutex6 = q00.I;
                    object3 = q00.G;
                    devLog4 = q00.E;
                    s9 = q00.D;
                    mutex7 = q00.B;
                    String s10 = q00.w;
                    n.D(object0);
                    z3 = z4;
                    devLog3 = devLog4;
                    a1 = a0;
                    mutex5 = mutex6;
                    mutex4 = mutex7;
                    v6 = v13;
                    v10 = v11;
                    s6 = s9;
                    v9 = v15;
                    s8 = object3;
                    s7 = s10;
                    v7 = v14;
                    object2 = object0;
                    v8 = v12;
                }
                catch(Throwable throwable1) {
                    s2 = object3;
                    mutex1 = mutex7;
                    v5 = v12;
                    devLog1 = devLog4;
                    s3 = s9;
                    mutex0 = mutex6;
                    goto label_223;
                }
                try {
                label_135:
                    list0 = (List)object2;
                    if(list0.isEmpty()) {
                        goto label_143;
                    }
                    goto label_163;
                }
                catch(Throwable throwable1) {
                    s11 = s6;
                    mutex8 = mutex5;
                    v5 = v8;
                    goto label_186;
                }
                try {
                label_143:
                    LogU.debug$default(this.f, s7 + ", no updated items", null, false, 6, null);
                    z00 = new z0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable1) {
                    mutex0 = mutex5;
                    v5 = v8;
                    s2 = s8;
                    mutex1 = mutex4;
                    devLog1 = devLog3;
                    s3 = s6;
                    goto label_223;
                }
                try {
                    long v16 = System.currentTimeMillis() - v8;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s8 + " Lock return : " + s6 + " (" + v16 + "ms)", null, false, 6, null);
                    devLog3.put("Lock[" + mutex4.hashCode() + "] " + s8 + " Lock return : " + s6 + " (" + v16 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex0 = mutex5;
                    mutex0.unlock(null);
                    throw throwable0;
                }
                mutex5.unlock(null);
                return z00;
                try {
                label_163:
                    s11 = s6;
                    mutex8 = mutex5;
                    v5 = v8;
                    r0 r00 = new r0(z3, this, list0, s7, null);
                    q00.r = null;
                    q00.w = null;
                    q00.B = mutex4;
                    q00.D = s11;
                    q00.E = devLog3;
                    q00.G = s8;
                    q00.I = mutex5;
                    q00.M = z3;
                    q00.N = v7;
                    q00.S = v6;
                    q00.T = v9;
                    mutex8 = mutex5;
                    v5 = v8;
                    q00.W = v5;
                    q00.V = v10;
                    q00.Z = 3;
                    object0 = this.U(s7, r00, q00);
                    goto label_192;
                }
                catch(Throwable throwable1) {
                }
            label_186:
                mutex0 = mutex8;
                s2 = s8;
                mutex1 = mutex4;
                devLog1 = devLog3;
                s3 = s11;
                goto label_223;
            label_192:
                if(object0 == a1) {
                    return a1;
                }
                v17 = v5;
                s2 = s8;
                mutex9 = mutex4;
                devLog5 = devLog3;
                s12 = s11;
                break;
            }
            case 3: {
                try {
                    v17 = q00.W;
                    mutex8 = q00.I;
                    s2 = q00.G;
                    devLog5 = q00.E;
                    s12 = q00.D;
                    mutex9 = q00.B;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex9;
                    mutex0 = mutex8;
                    devLog1 = devLog5;
                    s3 = s12;
                    v5 = v17;
                    goto label_223;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            a00 = new A0(((C0)object0));
            goto label_229;
        }
        catch(Throwable throwable1) {
            mutex1 = mutex9;
            devLog1 = devLog5;
            s3 = s12;
            v5 = v17;
            mutex0 = mutex8;
        }
        try {
        label_223:
            long v18 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s2 + " Lock return : " + s3 + " (" + v18 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s2 + " Lock return : " + s3 + " (" + v18 + "ms)");
            throw throwable1;
        }
        catch(Throwable throwable0) {
            mutex0.unlock(null);
            throw throwable0;
        }
        try {
        label_229:
            long v19 = System.currentTimeMillis() - v17;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex9.hashCode() + "] " + s2 + " Lock return : " + s12 + " (" + v19 + "ms)", null, false, 6, null);
            devLog5.put("Lock[" + mutex9.hashCode() + "] " + s2 + " Lock return : " + s12 + " (" + v19 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex0 = mutex8;
            mutex0.unlock(null);
            throw throwable0;
        }
        mutex8.unlock(null);
        return a00;
    }

    @Override  // oc.w
    public final Object i(List list0, oe.c c0) {
        Mutex mutex4;
        String s3;
        U u0;
        Mutex mutex3;
        LogU logU0;
        Mutex mutex2;
        List list1;
        Mutex mutex1;
        int v2;
        int v1;
        String s1;
        String s;
        DevLog devLog1;
        G g0;
        if(c0 instanceof G) {
            g0 = (G)c0;
            int v = g0.V;
            if((v & 0x80000000) == 0) {
                g0 = new G(this, c0);
            }
            else {
                g0.V = v ^ 0x80000000;
            }
        }
        else {
            g0 = new G(this, c0);
        }
        Object object0 = g0.S;
        ne.a a0 = ne.a.a;
        switch(g0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_remove"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_remove", devLog0);
                g0.r = list0;
                g0.w = mutex0;
                g0.B = "drawer_remove";
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
                s = "drawer_remove";
                s1 = "";
                v1 = 0;
                v2 = 0;
                mutex1 = mutex0;
                list1 = list0;
                mutex2 = mutex1;
                goto label_51;
            }
            case 1: {
                v1 = g0.M;
                int v3 = g0.I;
                mutex1 = g0.G;
                Object object1 = g0.E;
                DevLog devLog2 = g0.D;
                String s2 = g0.B;
                mutex2 = g0.w;
                list1 = g0.r;
                n.D(object0);
                devLog1 = devLog2;
                s1 = object1;
                s = s2;
                v2 = v3;
                try {
                label_51:
                    long v4 = System.currentTimeMillis();
                    try {
                        logU0 = MutexLockUtil.INSTANCE.getLog();
                    }
                    catch(Throwable throwable1) {
                        mutex3 = mutex2;
                        goto label_82;
                    }
                    try {
                        LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                        u0 = this.D(list1, ((C0)this.h.getValue()));
                        if(u0 == null) {
                            g0.r = null;
                            mutex3 = mutex2;
                            goto label_70;
                        }
                        else {
                            s3 = s;
                            mutex4 = mutex2;
                        }
                        goto label_114;
                    }
                    catch(Throwable throwable1) {
                        mutex3 = mutex2;
                        goto label_82;
                    }
                    try {
                    label_70:
                        g0.w = mutex3;
                        g0.B = s;
                        g0.D = devLog1;
                        g0.E = s1;
                        g0.G = mutex1;
                        g0.I = v2;
                        g0.M = v1;
                        g0.N = v4;
                        g0.V = 2;
                        object0 = this.L(list1, g0);
                        goto label_87;
                    }
                    catch(Throwable throwable1) {
                    }
                label_82:
                    mutex4 = mutex3;
                    Mutex mutex5 = mutex1;
                    String s4 = s;
                    long v5 = v4;
                    goto label_107;
                label_87:
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex4 = mutex3;
                    mutex5 = mutex1;
                    s4 = s;
                    v5 = v4;
                    goto label_101;
                    try {
                    label_94:
                        v5 = g0.N;
                        mutex5 = g0.G;
                        s1 = g0.E;
                        devLog1 = g0.D;
                        s4 = g0.B;
                        mutex4 = g0.w;
                        n.D(object0);
                    label_101:
                        u0 = (U)object0;
                        s3 = s4;
                        mutex1 = mutex5;
                        v4 = v5;
                        goto label_114;
                    }
                    catch(Throwable throwable1) {
                    }
                    try {
                    label_107:
                        long v6 = System.currentTimeMillis() - v5;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
                        devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s4 + " (" + v6 + "ms)");
                        throw throwable1;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex5;
                        break;
                    }
                label_114:
                    long v7 = System.currentTimeMillis() - v4;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v7 + "ms)");
                    goto label_121;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_94;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        throw throwable0;
    label_121:
        mutex1.unlock(null);
        return u0;
    }

    public final Object j(DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0, oe.c c0) {
        DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo1;
        kotlin.jvm.internal.C c1;
        nc.d d0;
        if(c0 instanceof nc.d) {
            d0 = (nc.d)c0;
            int v = d0.E;
            if((v & 0x80000000) == 0) {
                d0 = new nc.d(this, c0);
            }
            else {
                d0.E = v ^ 0x80000000;
            }
        }
        else {
            d0 = new nc.d(this, c0);
        }
        Object object0 = d0.B;
        ne.a a0 = ne.a.a;
        switch(d0.E) {
            case 0: {
                n.D(object0);
                kotlin.jvm.internal.F f0 = new kotlin.jvm.internal.F();  // 初始化器: Ljava/lang/Object;-><init>()V
                c1 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
                f f1 = new f(drawerAddRequestPlayableListInfo0, drawerAddRequestPlayableListInfo0.getPlaylistInfo(), null, c1, f0, this);
                d0.r = drawerAddRequestPlayableListInfo0;
                d0.w = c1;
                d0.E = 1;
                if(BuildersKt.withContext(NonCancellable.INSTANCE, f1, d0) == a0) {
                    return a0;
                }
                drawerAddRequestPlayableListInfo1 = drawerAddRequestPlayableListInfo0;
                break;
            }
            case 1: {
                kotlin.jvm.internal.C c2 = d0.w;
                DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo2 = d0.r;
                n.D(object0);
                c1 = c2;
                drawerAddRequestPlayableListInfo1 = drawerAddRequestPlayableListInfo2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object1 = this.h.getValue();
        return new Z(PlaylistId.DRAWER, drawerAddRequestPlayableListInfo1.getUserRequestedPlaylist(), c1.a, ((C0)object1), this.i);
    }

    @Override  // oc.H
    public final long k() {
        return this.i;
    }

    @Override  // oc.H
    public final int l() {
        C0 c00 = (C0)this.h.getValue();
        this.m.getClass();
        if(lc.h.i(c00)) {
            return lc.h.d(c00);
        }
        A3.g g0 = this.n;
        if(g0 != null) {
            return g0.n(c00.b);
        }
        this.k.getClass();
        return lc.a.e(c00);
    }

    @Override  // oc.A
    public final Object m(boolean z, oe.c c0) {
        Mutex mutex2;
        Throwable throwable1;
        Object object1;
        int v1;
        Mutex mutex0;
        nc.k0 k00;
        if(c0 instanceof nc.k0) {
            k00 = (nc.k0)c0;
            int v = k00.G;
            if((v & 0x80000000) == 0) {
                k00 = new nc.k0(this, c0);
            }
            else {
                k00.G = v ^ 0x80000000;
            }
        }
        else {
            k00 = new nc.k0(this, c0);
        }
        Object object0 = k00.D;
        ne.a a0 = ne.a.a;
        switch(k00.G) {
            case 0: {
                n.D(object0);
                mutex0 = this.g;
                k00.w = mutex0;
                k00.r = z;
                v1 = 0;
                k00.B = 0;
                k00.G = 1;
                if(mutex0.lock(null, k00) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                int v2 = k00.B;
                boolean z1 = k00.r;
                Mutex mutex1 = k00.w;
                n.D(object0);
                v1 = v2;
                z = z1;
                mutex0 = mutex1;
                try {
                label_29:
                    O o0 = (O)this.h.getValue();
                    this.m.getClass();
                    if(!lc.h.i(o0)) {
                        k00.w = mutex0;
                        k00.r = z;
                        k00.B = v1;
                        k00.G = 2;
                        object1 = this.S(z, k00);
                        goto label_42;
                    }
                    goto label_47;
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
            label_42:
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                mutex2 = mutex0;
                break;
            label_47:
                mutex0.unlock(null);
                return SelectRepeatOn.a;
            }
            case 2: {
                try {
                    mutex2 = k00.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return object0;
    }

    @Override  // oc.y
    public final Object o(M m0, oe.c c0) {
        Mutex mutex2;
        Throwable throwable1;
        Object object1;
        int v1;
        Mutex mutex0;
        c0 c00;
        if(c0 instanceof c0) {
            c00 = (c0)c0;
            int v = c00.G;
            if((v & 0x80000000) == 0) {
                c00 = new c0(this, c0);
            }
            else {
                c00.G = v ^ 0x80000000;
            }
        }
        else {
            c00 = new c0(this, c0);
        }
        Object object0 = c00.D;
        ne.a a0 = ne.a.a;
        switch(c00.G) {
            case 0: {
                n.D(object0);
                c00.r = m0;
                mutex0 = this.g;
                c00.w = mutex0;
                v1 = 0;
                c00.B = 0;
                c00.G = 1;
                if(mutex0.lock(null, c00) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                int v2 = c00.B;
                Mutex mutex1 = c00.w;
                M m1 = c00.r;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                m0 = m1;
                try {
                label_29:
                    O o0 = (O)this.h.getValue();
                    this.m.getClass();
                    if(!lc.h.i(o0)) {
                        c00.r = null;
                        c00.w = mutex0;
                        c00.B = v1;
                        c00.G = 2;
                        object1 = this.Q(m0, c00);
                        goto label_42;
                    }
                    goto label_47;
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
            label_42:
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                mutex2 = mutex0;
                break;
            label_47:
                mutex0.unlock(null);
                return com.melon.playlist.interfaces.SetRepeatResult.Failure.SelectRepeatOn.a;
            }
            case 2: {
                try {
                    mutex2 = c00.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return object0;
    }

    @Override  // oc.H
    public final int p() {
        C0 c00 = (C0)this.h.getValue();
        this.m.getClass();
        if(lc.h.i(c00)) {
            return lc.h.c(c00);
        }
        A3.g g0 = this.n;
        if(g0 != null) {
            return g0.m(c00.b);
        }
        this.k.getClass();
        return lc.a.d(c00);
    }

    @Override  // oc.w
    public final Object q(int v, int v1, oe.c c0) {
        long v15;
        v v14;
        long v13;
        Mutex mutex4;
        int v12;
        LogU logU0;
        Mutex mutex2;
        int v6;
        int v5;
        String s1;
        DevLog devLog1;
        Mutex mutex1;
        int v4;
        int v3;
        String s;
        u u0;
        if(c0 instanceof u) {
            u0 = (u)c0;
            int v2 = u0.W;
            if((v2 & 0x80000000) == 0) {
                u0 = new u(this, c0);
            }
            else {
                u0.W = v2 ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, c0);
        }
        Object object0 = u0.T;
        ne.a a0 = ne.a.a;
        switch(u0.W) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_move"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_move", devLog0);
                u0.E = mutex0;
                u0.G = "drawer_move";
                u0.I = devLog0;
                s = "";
                u0.M = "";
                u0.N = mutex0;
                v3 = v;
                u0.r = v3;
                v4 = v1;
                u0.w = v4;
                u0.B = 0;
                u0.D = 0;
                u0.W = 1;
                if(mutex0.lock(null, u0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                devLog1 = devLog0;
                s1 = "drawer_move";
                v5 = 0;
                v6 = 0;
                mutex2 = mutex1;
                goto label_57;
            }
            case 1: {
                int v7 = u0.D;
                int v8 = u0.B;
                int v9 = u0.w;
                int v10 = u0.r;
                mutex2 = u0.N;
                s = u0.M;
                DevLog devLog2 = u0.I;
                String s2 = u0.G;
                Mutex mutex3 = u0.E;
                n.D(object0);
                mutex1 = mutex3;
                v5 = v7;
                v4 = v9;
                v3 = v10;
                s1 = s2;
                v6 = v8;
                devLog1 = devLog2;
                try {
                label_57:
                    long v11 = System.currentTimeMillis();
                    try {
                        logU0 = MutexLockUtil.INSTANCE.getLog();
                        v12 = mutex1.hashCode();
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v13 = v11;
                        goto label_99;
                    }
                    try {
                        LogU.debug$default(logU0, "Lock[" + v12 + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1);
                        C0 c00 = (C0)this.h.getValue();
                        this.m.getClass();
                        if(lc.h.i(c00)) {
                            v14 = new oc.t("In Select Repeat Mode");
                        }
                        else {
                            this.k.getClass();
                            v14 = lc.a.a(v3, v4, c00);
                        }
                        if(v14 == null) {
                            u0.E = mutex1;
                            u0.G = s1;
                            u0.I = devLog1;
                            u0.M = s;
                            u0.N = mutex2;
                            u0.r = v3;
                            u0.w = v4;
                            u0.B = v6;
                            u0.D = v5;
                            mutex4 = mutex1;
                            v13 = v11;
                            goto label_93;
                        }
                        else {
                            v15 = v11;
                        }
                        goto label_133;
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v13 = v11;
                        goto label_99;
                    }
                    try {
                    label_93:
                        u0.S = v13;
                        u0.W = 2;
                        x x0 = new x(this, v3, v4, null);
                        object0 = BuildersKt.withContext(NonCancellable.INSTANCE, x0, u0);
                        goto label_104;
                    }
                    catch(Throwable throwable1) {
                    }
                label_99:
                    Mutex mutex5 = mutex4;
                    Mutex mutex6 = mutex2;
                    String s3 = s1;
                    String s4 = s;
                    goto label_126;
                label_104:
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex5 = mutex4;
                    mutex6 = mutex2;
                    s3 = s1;
                    s4 = s;
                    goto label_118;
                    try {
                    label_111:
                        v13 = u0.S;
                        mutex6 = u0.N;
                        s4 = u0.M;
                        devLog1 = u0.I;
                        s3 = u0.G;
                        mutex5 = u0.E;
                        n.D(object0);
                    label_118:
                        mutex1 = mutex5;
                        v15 = v13;
                        s = s4;
                        s1 = s3;
                        mutex2 = mutex6;
                        v14 = (v)object0;
                        goto label_133;
                    }
                    catch(Throwable throwable1) {
                    }
                    try {
                    label_126:
                        long v16 = System.currentTimeMillis() - v13;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s4 + " Lock return : " + s3 + " (" + v16 + "ms)", null, false, 6, null);
                        devLog1.put("Lock[" + mutex5.hashCode() + "] " + s4 + " Lock return : " + s3 + " (" + v16 + "ms)");
                        throw throwable1;
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex6;
                        break;
                    }
                label_133:
                    long v17 = System.currentTimeMillis() - v15;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v17 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v17 + "ms)");
                    goto label_140;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_111;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_140:
        mutex2.unlock(null);
        return v14;
    }

    @Override  // oc.w
    public final Object r(long v, Continuation continuation0) {
        Mutex mutex1;
        nc.U u0;
        if(continuation0 instanceof nc.U) {
            u0 = (nc.U)continuation0;
            int v1 = u0.E;
            if((v1 & 0x80000000) == 0) {
                u0 = new nc.U(this, ((oe.c)continuation0));
            }
            else {
                u0.E = v1 ^ 0x80000000;
            }
        }
        else {
            u0 = new nc.U(this, ((oe.c)continuation0));
        }
        Object object0 = u0.B;
        ne.a a0 = ne.a.a;
        switch(u0.E) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                u0.w = mutex0;
                u0.r = v;
                u0.E = 1;
                if(mutex0.lock(null, u0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                break;
            }
            case 1: {
                v = u0.r;
                mutex1 = u0.w;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            this.i = v;
            this.b.e(v, "saveTimePositionMs");
            return H.a;
        }
        finally {
            mutex1.unlock(null);
        }
    }

    public final Object s(DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0, oe.c c0) {
        nc.g g0;
        if(c0 instanceof nc.g) {
            g0 = (nc.g)c0;
            int v = g0.D;
            if((v & 0x80000000) == 0) {
                g0 = new nc.g(this, c0);
            }
            else {
                g0.D = v ^ 0x80000000;
            }
        }
        else {
            g0 = new nc.g(this, c0);
        }
        Object object0 = g0.w;
        ne.a a0 = ne.a.a;
        switch(g0.D) {
            case 0: {
                n.D(object0);
                nc.i i0 = new nc.i(drawerAddRequestPlayableListInfo0, null, this);
                g0.r = drawerAddRequestPlayableListInfo0;
                g0.D = 1;
                if(BuildersKt.withContext(NonCancellable.INSTANCE, i0, g0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                drawerAddRequestPlayableListInfo0 = g0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object1 = this.h.getValue();
        return new Z(PlaylistId.DRAWER, drawerAddRequestPlayableListInfo0.getUserRequestedPlaylist(), true, ((C0)object1), this.i);
    }

    @Override  // oc.z
    public final Object t(oe.c c0) {
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
        nc.n n0;
        if(c0 instanceof nc.n) {
            n0 = (nc.n)c0;
            int v = n0.T;
            if((v & 0x80000000) == 0) {
                n0 = new nc.n(this, c0);
            }
            else {
                n0.T = v ^ 0x80000000;
            }
        }
        else {
            n0 = new nc.n(this, c0);
        }
        Object object0 = n0.N;
        ne.a a0 = ne.a.a;
        switch(n0.T) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_clearSelectRepeat"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_clearSelectRepeat", devLog0);
                n0.r = mutex0;
                n0.w = "drawer_clearSelectRepeat";
                n0.B = devLog0;
                n0.D = "";
                n0.E = mutex0;
                v1 = 0;
                n0.G = 0;
                n0.I = 0;
                n0.T = 1;
                if(mutex0.lock(null, n0) == a0) {
                    return a0;
                }
                try {
                    mutex1 = mutex0;
                    s = "drawer_clearSelectRepeat";
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
                int v4 = n0.I;
                int v5 = n0.G;
                mutex1 = n0.E;
                s1 = n0.D;
                DevLog devLog2 = n0.B;
                String s2 = n0.w;
                Mutex mutex3 = n0.r;
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
                    goto label_114;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    C0 c00 = this.I();
                    this.m.getClass();
                    if(lc.h.i(c00)) {
                        n0.r = mutex2;
                        n0.w = s;
                        n0.B = devLog1;
                        n0.D = s1;
                        n0.E = mutex1;
                        n0.G = v2;
                        n0.I = v1;
                        mutex4 = mutex2;
                        v6 = v3;
                        n0.M = v6;
                        n0.T = 2;
                        object0 = this.G(true, n0);
                        goto label_85;
                    }
                    goto label_90;
                }
                catch(Throwable throwable1) {
                    mutex4 = mutex2;
                    v6 = v3;
                    mutex5 = mutex4;
                    mutex6 = mutex1;
                    goto label_114;
                }
                try {
                    n0.M = v6;
                    n0.T = 2;
                    object0 = this.G(true, n0);
                }
                catch(Throwable throwable1) {
                    mutex5 = mutex4;
                    mutex6 = mutex1;
                    goto label_114;
                }
            label_85:
                if(object0 == a0) {
                    return a0;
                }
                mutex5 = mutex4;
                mutex6 = mutex1;
                goto label_118;
                try {
                label_90:
                    c1 = new oc.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable1) {
                    mutex5 = mutex2;
                    mutex6 = mutex1;
                    v6 = v3;
                    goto label_114;
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
                    v6 = n0.M;
                    mutex6 = n0.E;
                    s1 = n0.D;
                    devLog1 = n0.B;
                    s = n0.w;
                    mutex5 = n0.r;
                    n.D(object0);
                    goto label_118;
                }
                catch(Throwable throwable1) {
                }
                try {
                label_114:
                    long v8 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v8 + "ms)");
                    throw throwable1;
                label_118:
                    long v9 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)");
                    goto label_126;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1 = mutex6;
        mutex1.unlock(null);
        throw throwable0;
    label_126:
        mutex6.unlock(null);
        return object0;
    }

    @Override  // oc.w
    public final Object u(V v0, oe.c c0) {
        DevLog devLog2;
        Mutex mutex5;
        Mutex mutex2;
        DevLog devLog1;
        b0 b00;
        oc.W w1;
        oc.W w0;
        Object object2;
        long v9;
        String s3;
        Mutex mutex4;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        long v8;
        LogU logU0;
        MutexLockUtil mutexLockUtil0;
        long v7;
        ne.a a0;
        Object object0;
        nc.c c1;
        MutableStateFlow mutableStateFlow0 = this.h;
        if(c0 instanceof nc.c) {
            c1 = (nc.c)c0;
            int v1 = c1.V;
            if((v1 & 0x80000000) == 0) {
                c1 = new nc.c(this, c0);
            }
            else {
                c1.V = v1 ^ 0x80000000;
            }
        }
        else {
            c1 = new nc.c(this, c0);
        }
        try {
            object0 = c1.S;
            a0 = ne.a.a;
            switch(c1.V) {
                case 0: {
                    goto label_14;
                }
                case 1: {
                    goto label_39;
                }
                case 2: {
                    goto label_134;
                }
                case 3: {
                    goto label_148;
                }
            }
        }
        catch(Throwable throwable0) {
            devLog1 = devLog2;
            mutex2 = mutex5;
            v8 = v9;
            goto label_169;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_14:
        n.D(object0);
        Mutex mutex0 = this.g;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_add"), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_add", devLog0);
        c1.r = v0;
        c1.w = mutex0;
        c1.B = "drawer_add";
        c1.D = devLog0;
        c1.E = "";
        c1.G = mutex0;
        c1.I = 0;
        c1.M = 0;
        c1.V = 1;
        if(mutex0.lock(null, c1) == a0) {
            return a0;
        }
        devLog1 = devLog0;
        String s = "";
        Mutex mutex1 = mutex0;
        String s1 = "drawer_add";
        int v2 = 0;
        int v3 = 0;
        V v4 = v0;
        mutex2 = mutex1;
        goto label_53;
    label_39:
        int v5 = c1.M;
        int v6 = c1.I;
        mutex2 = c1.G;
        Object object1 = c1.E;
        devLog1 = c1.D;
        String s2 = c1.B;
        Mutex mutex3 = c1.w;
        v4 = c1.r;
        n.D(object0);
        v2 = v5;
        s = object1;
        v3 = v6;
        mutex1 = mutex3;
        s1 = s2;
        try {
        label_53:
            v7 = System.currentTimeMillis();
        }
        catch(Throwable throwable1) {
            mutex2.unlock(null);
            throw throwable1;
        }
        try {
            mutexLockUtil0 = MutexLockUtil.INSTANCE;
            logU0 = mutexLockUtil0.getLog();
        }
        catch(Throwable throwable0) {
            v8 = v7;
            mutex4 = mutex1;
            s3 = s1;
            goto label_169;
        }
        try {
            LogU.debug$default(logU0, "Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1);
            O o0 = (O)mutableStateFlow0.getValue();
            this.m.getClass();
            if(lc.h.i(o0)) {
                goto label_122;
            }
            addRequestPlayableListInfo0 = v4.c;
            if(!(addRequestPlayableListInfo0 instanceof DrawerAddRequestPlayableListInfo)) {
                goto label_116;
            }
            if(q.b(((C0)mutableStateFlow0.getValue()).g, ((DrawerAddRequestPlayableListInfo)addRequestPlayableListInfo0).getPlaylistInfo())) {
                goto label_72;
            }
            else {
                goto label_90;
            }
            goto label_173;
        }
        catch(Throwable throwable0) {
            v8 = v7;
            mutex4 = mutex1;
            s3 = s1;
            goto label_169;
        }
        try {
        label_72:
            c1.r = null;
            c1.w = mutex1;
            c1.B = s1;
            c1.D = devLog1;
            c1.E = s;
            c1.G = mutex2;
            c1.I = v3;
            c1.M = v2;
            v8 = v7;
            c1.N = v8;
            c1.V = 2;
            object0 = this.j(((DrawerAddRequestPlayableListInfo)addRequestPlayableListInfo0), c1);
            if(object0 == a0) {
                return a0;
            }
            mutex4 = mutex1;
            s3 = s1;
            v9 = v8;
            b00 = (b0)object0;
            goto label_173;
        label_90:
            v8 = v7;
            c1.r = null;
            c1.w = mutex1;
            c1.B = s1;
            c1.D = devLog1;
            c1.E = s;
            c1.G = mutex2;
            c1.I = v3;
            c1.M = v2;
            c1.N = v8;
            c1.V = 3;
            object2 = this.s(((DrawerAddRequestPlayableListInfo)addRequestPlayableListInfo0), c1);
        }
        catch(Throwable throwable0) {
            mutex4 = mutex1;
            s3 = s1;
            goto label_169;
        }
        if(object2 == a0) {
            return a0;
        }
        mutex4 = mutex1;
        object0 = object2;
        mutex5 = mutex2;
        s3 = s1;
        v9 = v8;
        devLog2 = devLog1;
        b00 = (b0)object0;
        devLog1 = devLog2;
        mutex2 = mutex5;
        goto label_173;
        try {
        label_116:
            w0 = new oc.W(PlaylistId.DRAWER, "Invalid AddRequest");
        }
        catch(Throwable throwable0) {
            mutex4 = mutex1;
            s3 = s1;
            v8 = v7;
            goto label_169;
        }
        try {
            long v10 = System.currentTimeMillis() - v7;
            LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v10 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v10 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex2.unlock(null);
            throw throwable1;
        }
        mutex2.unlock(null);
        return w0;
        try {
        label_122:
            w1 = new oc.W(PlaylistId.DRAWER, "In Select Repeat Mode");
        }
        catch(Throwable throwable0) {
            mutex4 = mutex1;
            s3 = s1;
            v8 = v7;
            goto label_169;
        }
        try {
            long v11 = System.currentTimeMillis() - v7;
            LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v11 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v11 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex2.unlock(null);
            throw throwable1;
        }
        mutex2.unlock(null);
        return w1;
        try {
        label_134:
            v9 = c1.N;
            mutex5 = c1.G;
            s = c1.E;
            devLog2 = c1.D;
            s3 = c1.B;
            mutex4 = c1.w;
            n.D(object0);
            devLog1 = devLog2;
            mutex2 = mutex5;
        }
        catch(Throwable throwable0) {
            devLog1 = devLog2;
            mutex2 = mutex5;
            v8 = v9;
            goto label_169;
        }
        try {
            b00 = (b0)object0;
            goto label_173;
        }
        catch(Throwable throwable0) {
            v8 = v9;
            goto label_169;
        }
        try {
        label_148:
            v9 = c1.N;
            mutex5 = c1.G;
            s = c1.E;
            devLog2 = c1.D;
            s3 = c1.B;
            mutex4 = c1.w;
            n.D(object0);
        }
        catch(Throwable throwable0) {
            devLog1 = devLog2;
            mutex2 = mutex5;
            v8 = v9;
            goto label_169;
        }
        try {
            b00 = (b0)object0;
            devLog1 = devLog2;
            mutex2 = mutex5;
            goto label_173;
        }
        catch(Throwable throwable0) {
            v8 = v9;
            devLog1 = devLog2;
            mutex2 = mutex5;
        }
        try {
        label_169:
            long v12 = System.currentTimeMillis() - v8;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s + " Lock return : " + s3 + " (" + v12 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex4.hashCode() + "] " + s + " Lock return : " + s3 + " (" + v12 + "ms)");
            throw throwable0;
        label_173:
            long v13 = System.currentTimeMillis() - v9;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s + " Lock return : " + s3 + " (" + v13 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex4.hashCode() + "] " + s + " Lock return : " + s3 + " (" + v13 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex2.unlock(null);
            throw throwable1;
        }
        mutex2.unlock(null);
        return b00;
    }

    @Override  // oc.w
    public final Object v(int v, long v1, boolean z, String s, Continuation continuation0) {
        String s12;
        oc.f0 f00;
        long v32;
        Mutex mutex9;
        DevLog devLog6;
        String s11;
        Object object3;
        long v31;
        String s10;
        oc.d0 d00;
        String s9;
        Mutex mutex8;
        String s8;
        long v30;
        Mutex mutex7;
        String s6;
        DevLog devLog5;
        Mutex mutex6;
        Object object2;
        int v18;
        int v17;
        int v16;
        ne.a a2;
        boolean z3;
        DevLog devLog4;
        long v15;
        int v22;
        int v21;
        int v20;
        long v19;
        DevLog devLog3;
        Mutex mutex5;
        long v14;
        Mutex mutex4;
        int v13;
        LogU logU0;
        long v12;
        Mutex mutex2;
        DevLog devLog1;
        String s3;
        boolean z1;
        int v7;
        int v6;
        ne.a a1;
        Mutex mutex1;
        String s2;
        long v5;
        int v4;
        String s1;
        nc.V v2;
        lc.h h0 = this.m;
        if(continuation0 instanceof nc.V) {
            v2 = (nc.V)continuation0;
            int v3 = v2.b0;
            if((v3 & 0x80000000) == 0) {
                v2 = new nc.V(this, ((oe.c)continuation0));
            }
            else {
                v2.b0 = v3 ^ 0x80000000;
            }
        }
        else {
            v2 = new nc.V(this, ((oe.c)continuation0));
        }
        Object object0 = v2.Y;
        ne.a a0 = ne.a.a;
        MutableStateFlow mutableStateFlow0 = this.h;
        switch(v2.b0) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_setCurrent"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_setCurrent", devLog0);
                v2.N = s;
                v2.S = mutex0;
                v2.T = "drawer_setCurrent";
                v2.V = devLog0;
                s1 = "";
                v2.W = "";
                v2.X = mutex0;
                v4 = v;
                v2.r = v4;
                v2.G = v1;
                v2.M = z;
                v2.w = 0;
                v2.B = 0;
                v2.b0 = 1;
                if(mutex0.lock(null, v2) == a0) {
                    return a0;
                }
                v5 = v1;
                s2 = s;
                mutex1 = mutex0;
                a1 = a0;
                v6 = 0;
                v7 = 0;
                z1 = z;
                s3 = "drawer_setCurrent";
                devLog1 = devLog0;
                mutex2 = mutex1;
                goto label_70;
            }
            case 1: {
                int v8 = v2.w;
                boolean z2 = v2.M;
                long v9 = v2.G;
                int v10 = v2.r;
                mutex2 = v2.X;
                int v11 = v2.B;
                Object object1 = v2.W;
                DevLog devLog2 = v2.V;
                String s4 = v2.T;
                Mutex mutex3 = v2.S;
                String s5 = v2.N;
                n.D(object0);
                a1 = a0;
                v5 = v9;
                v7 = v11;
                s1 = object1;
                s3 = s4;
                mutex1 = mutex3;
                s2 = s5;
                v6 = v8;
                z1 = z2;
                v4 = v10;
                devLog1 = devLog2;
                try {
                label_70:
                    v12 = System.currentTimeMillis();
                    logU0 = MutexLockUtil.INSTANCE.getLog();
                    v13 = mutex1.hashCode();
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex1;
                    v14 = v12;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    goto label_263;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + v13 + "] " + s1 + " Lock obtain : " + s3, null, false, 6, null);
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
                    v14 = v12;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    goto label_263;
                }
                try {
                label_92:
                    if(lc.h.a(v4, ((O)mutableStateFlow0.getValue()))) {
                    label_123:
                        mutex4 = mutex1;
                        devLog4 = devLog1;
                        a2 = a1;
                        v15 = v5;
                        z3 = z1;
                        v19 = v12;
                        v20 = v4;
                        v21 = 0;
                        v22 = 0;
                    }
                    else {
                        v2.N = s2;
                        v2.S = mutex1;
                        v2.T = s3;
                        v2.V = devLog1;
                        v2.W = s1;
                        v2.X = mutex2;
                        v2.r = v4;
                        v15 = v5;
                        v2.G = v15;
                        v2.M = z1;
                        v2.w = v6;
                        v2.B = v7;
                        v2.D = 0;
                        devLog4 = devLog1;
                        v14 = v12;
                        v2.I = v14;
                        z3 = z1;
                        v2.E = 0;
                        v2.b0 = 2;
                        mutex4 = mutex1;
                        try {
                            a2 = a1;
                            if(this.G(true, v2) == a2) {
                                return a2;
                            }
                        }
                        catch(Throwable throwable0) {
                            mutex5 = mutex2;
                            devLog3 = devLog4;
                            goto label_263;
                        }
                        v16 = v4;
                        v17 = 0;
                        v18 = 0;
                        goto label_179;
                    }
                    goto label_183;
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex1;
                    devLog4 = devLog1;
                    v14 = v12;
                }
                mutex5 = mutex2;
                devLog3 = devLog4;
                goto label_263;
            }
            case 2: {
                try {
                    int v23 = v2.E;
                    int v24 = v2.D;
                    int v25 = v2.B;
                    int v26 = v2.w;
                    boolean z4 = v2.M;
                    long v27 = v2.I;
                    long v28 = v2.G;
                    object2 = v2.W;
                    mutex6 = v2.X;
                    devLog5 = v2.V;
                    s6 = v2.T;
                    mutex7 = v2.S;
                    int v29 = v2.r;
                    String s7 = v2.N;
                    v14 = v27;
                    n.D(object0);
                    s2 = s7;
                    v16 = v29;
                    mutex4 = mutex7;
                    v18 = v24;
                    z3 = z4;
                    devLog4 = devLog5;
                    s3 = s6;
                    v7 = v25;
                    a2 = a0;
                    v6 = v26;
                    v17 = v23;
                    v14 = v27;
                    mutex2 = mutex6;
                    s1 = object2;
                    v15 = v28;
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
                v19 = v14;
                v21 = v18;
                v20 = v16;
                v22 = v17;
                try {
                label_183:
                    v30 = v19;
                    s8 = s3;
                    devLog3 = devLog4;
                    mutex8 = mutex4;
                    s9 = s1;
                    Q q0 = (Q)mutableStateFlow0.getValue();
                    d00 = this.k.c(v20, q0);
                }
                catch(Throwable throwable0) {
                    s10 = s8;
                    v31 = v30;
                    goto label_218;
                }
                if(d00 == null) {
                    try {
                        v2.N = null;
                        v2.S = mutex8;
                        v2.T = s8;
                        v2.V = devLog3;
                        v2.W = s9;
                        v2.X = mutex2;
                        v2.r = v20;
                        v2.G = v15;
                        v2.M = z3;
                        v2.w = v6;
                        v2.B = v7;
                        v2.D = v21;
                        v2.I = v30;
                        v2.E = v22;
                        v2.b0 = 3;
                        s10 = s8;
                        v31 = v30;
                        object3 = this.P(v20, v15, z3, s2, true, v2);
                        goto label_224;
                    }
                    catch(Throwable throwable0) {
                    }
                label_218:
                    s1 = s9;
                    mutex4 = mutex8;
                    mutex5 = mutex2;
                    s3 = s10;
                    v14 = v31;
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
                    v32 = v31;
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
            v32 = v2.I;
            mutex5 = v2.X;
            s11 = v2.W;
            devLog6 = v2.V;
            s12 = v2.T;
            mutex9 = v2.S;
            n.D(object0);
            s10 = s12;
        }
        catch(Throwable throwable0) {
            s1 = s11;
            mutex4 = mutex9;
            devLog3 = devLog6;
            v14 = v32;
            s3 = s12;
            goto label_263;
        }
        try {
        label_249:
            devLog3 = devLog6;
            f00 = (oc.f0)object0;
            v30 = v32;
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
            v14 = v32;
        }
        try {
        label_263:
            long v33 = System.currentTimeMillis() - v14;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v33 + "ms)", null, false, 6, null);
            devLog3.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v33 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw throwable1;
        }
        try {
        label_270:
            long v34 = System.currentTimeMillis() - v30;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex8.hashCode() + "] " + s9 + " Lock return : " + s8 + " (" + v34 + "ms)", null, false, 6, null);
            devLog3.put("Lock[" + mutex8.hashCode() + "] " + s9 + " Lock return : " + s8 + " (" + v34 + "ms)");
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
        C0 c00;
        boolean z6;
        oc.g0 g01;
        oc.g0 g00;
        boolean z4;
        DevLog devLog3;
        Mutex mutex6;
        String s5;
        String s4;
        ne.a a2;
        long v6;
        String s3;
        Mutex mutex5;
        LogU logU0;
        MutexLockUtil mutexLockUtil0;
        long v3;
        Mutex mutex2;
        boolean z2;
        int v2;
        int v1;
        String s1;
        Mutex mutex1;
        DevLog devLog1;
        ne.a a1;
        String s;
        nc.Z z1;
        MutableStateFlow mutableStateFlow0 = this.h;
        if(continuation0 instanceof nc.Z) {
            z1 = (nc.Z)continuation0;
            int v = z1.V;
            if((v & 0x80000000) == 0) {
                z1 = new nc.Z(this, continuation0);
            }
            else {
                z1.V = v ^ 0x80000000;
            }
        }
        else {
            z1 = new nc.Z(this, continuation0);
        }
        Object object0 = z1.S;
        ne.a a0 = ne.a.a;
        switch(z1.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.g;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : drawer_setOfflineMode"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : drawer_setOfflineMode", devLog0);
                z1.w = mutex0;
                z1.B = "drawer_setOfflineMode";
                z1.D = devLog0;
                s = "";
                z1.E = "";
                z1.G = mutex0;
                z1.r = z;
                z1.I = 0;
                z1.M = 0;
                z1.V = 1;
                if(mutex0.lock(null, z1) == a0) {
                    return a0;
                }
                try {
                    a1 = a0;
                    devLog1 = devLog0;
                    mutex1 = mutex0;
                    s1 = "drawer_setOfflineMode";
                    v1 = 0;
                    v2 = 0;
                    z2 = z;
                    mutex2 = mutex1;
                    v3 = System.currentTimeMillis();
                    goto label_60;
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
            }
            case 1: {
                int v4 = z1.M;
                int v5 = z1.I;
                boolean z3 = z1.r;
                Mutex mutex3 = z1.G;
                Object object1 = z1.E;
                DevLog devLog2 = z1.D;
                String s2 = z1.B;
                Mutex mutex4 = z1.w;
                n.D(object0);
                v1 = v4;
                v2 = v5;
                s = object1;
                s1 = s2;
                mutex1 = mutex3;
                mutex2 = mutex4;
                z2 = z3;
                a1 = a0;
                devLog1 = devLog2;
                try {
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
                try {
                label_60:
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    logU0 = mutexLockUtil0.getLog();
                }
                catch(Throwable throwable1) {
                    mutex5 = mutex2;
                    s3 = s1;
                    v6 = v3;
                    goto label_98;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                    if(((C0)mutableStateFlow0.getValue()).f != z2) {
                        LogU.debug$default(this.f, "setOfflineMode() isOfflineMode: " + z2, null, false, 6, null);
                        DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)mutableStateFlow0.getValue()).g;
                        if(drawerPlaylistInfo0 != null) {
                            nc.b0 b00 = new nc.b0(this, z2, drawerPlaylistInfo0, null);
                            z1.w = mutex2;
                            z1.B = s1;
                            z1.D = devLog1;
                            z1.E = s;
                            z1.G = mutex1;
                            z1.r = z2;
                            z1.I = v2;
                            z1.M = v1;
                            s3 = s1;
                            mutex5 = mutex2;
                            v6 = v3;
                            goto label_92;
                        }
                        goto label_109;
                    }
                    goto label_115;
                }
                catch(Throwable throwable1) {
                    mutex5 = mutex2;
                    s3 = s1;
                    v6 = v3;
                    goto label_98;
                }
                try {
                label_92:
                    z1.N = v6;
                    z1.V = 2;
                    a2 = a1;
                    if(BuildersKt.withContext(NonCancellable.INSTANCE, b00, z1) == a2) {
                        return a2;
                    }
                    goto label_103;
                }
                catch(Throwable throwable1) {
                }
            label_98:
                s4 = s3;
                s5 = s;
                mutex6 = mutex1;
                devLog3 = devLog1;
                goto label_150;
            label_103:
                s4 = s3;
                s5 = s;
                mutex6 = mutex1;
                z4 = z2;
                devLog3 = devLog1;
                goto label_154;
                try {
                label_109:
                    g00 = new oc.g0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable1) {
                    goto label_119;
                }
                try {
                    long v7 = System.currentTimeMillis() - v3;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v7 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
                mutex1.unlock(null);
                return g00;
                try {
                label_115:
                    LogU.debug$default(this.f, "setOfflineMode() skipped because already isOfflineMode: " + z2, null, false, 6, null);
                    g01 = new oc.g0("Already isOfflineMode: " + z2);
                }
                catch(Throwable throwable1) {
                label_119:
                    mutex5 = mutex2;
                    mutex6 = mutex1;
                    s5 = s;
                    s4 = s1;
                    devLog3 = devLog1;
                    v6 = v3;
                    goto label_150;
                }
                try {
                    long v8 = System.currentTimeMillis() - v3;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v8 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v8 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
                mutex1.unlock(null);
                return g01;
            }
            case 2: {
                try {
                    boolean z5 = z1.r;
                    mutex6 = z1.G;
                    s5 = z1.E;
                    devLog3 = z1.D;
                    s4 = z1.B;
                    long v9 = z1.N;
                    Mutex mutex7 = z1.w;
                    mutex5 = mutex7;
                    v6 = v9;
                    n.D(object0);
                    mutex5 = mutex7;
                    v6 = v9;
                    z4 = z5;
                    a2 = a0;
                    goto label_154;
                }
                catch(Throwable throwable1) {
                }
                try {
                label_150:
                    long v10 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v10 + "ms)", null, false, 6, null);
                    devLog3.put("Lock[" + mutex5.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v10 + "ms)");
                    throw throwable1;
                label_154:
                    long v11 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v11 + "ms)", null, false, 6, null);
                    devLog3.put("Lock[" + mutex5.hashCode() + "] " + s5 + " Lock return : " + s4 + " (" + v11 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex6;
                    mutex1.unlock(null);
                    throw throwable0;
                }
                mutex6.unlock(null);
                z1.w = null;
                z1.B = null;
                z1.D = null;
                z1.E = null;
                z1.G = null;
                z1.r = z4;
                z1.V = 3;
                Object object2 = this.T("setOfflineMode", z1);
                if(object2 == a2) {
                    return a2;
                }
                z6 = z4;
                object0 = object2;
                goto label_179;
            }
            case 3: {
                boolean z7 = z1.r;
                n.D(object0);
                z6 = z7;
                a2 = a0;
            label_179:
                c00 = (C0)object0;
                if(c00 == null) {
                    z1.w = null;
                    z1.r = z6;
                    z1.V = 4;
                    object0 = this.b(z1);
                    return object0 == a2 ? a2 : new oc.h0(((C0)object0));
                }
                break;
            }
            case 4: {
                C0 c01 = (C0)z1.w;
                n.D(object0);
                c00 = (C0)object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new oc.h0(c00);
    }

    @Override  // oc.H
    public final ListKeepOption x() {
        ListKeepOption listKeepOption0 = MelonSettingInfo.getCurrentListKeepOption();
        q.f(listKeepOption0, "getCurrentListKeepOption(...)");
        return listKeepOption0;
    }

    @Override  // oc.x
    public final MutableStateFlow y() {
        return this.h;
    }

    @Override  // oc.w
    public final Object z(Continuation continuation0) {
        oc.n n0;
        int v3;
        Mutex mutex2;
        int v2;
        int v1;
        Mutex mutex0;
        B b0;
        if(continuation0 instanceof B) {
            b0 = (B)continuation0;
            int v = b0.G;
            if((v & 0x80000000) == 0) {
                b0 = new B(this, ((oe.c)continuation0));
            }
            else {
                b0.G = v ^ 0x80000000;
            }
        }
        else {
            b0 = new B(this, ((oe.c)continuation0));
        }
        Object object0 = b0.D;
        ne.a a0 = ne.a.a;
        switch(b0.G) {
            case 0: {
                n.D(object0);
                mutex0 = this.g;
                b0.r = mutex0;
                v1 = 0;
                b0.w = 0;
                b0.G = 1;
                if(mutex0.lock(null, b0) == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                v1 = b0.w;
                Mutex mutex1 = b0.r;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_25:
                    v2 = this.l();
                    b0.r = mutex0;
                    b0.w = v1;
                    b0.B = v2;
                    b0.G = 2;
                    if(this.P(v2, 0L, false, "previous", true, b0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    break;
                }
                mutex2 = mutex0;
                v3 = v2;
                n0 = new oc.n(v3);
                goto label_47;
            }
            case 2: {
                try {
                    v3 = b0.B;
                    mutex2 = b0.r;
                    n.D(object0);
                    n0 = new oc.n(v3);
                    goto label_47;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_47:
        mutex2.unlock(null);
        return n0;
    }
}

