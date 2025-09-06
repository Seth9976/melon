package uc;

import Pd.i;
import androidx.appcompat.app.o;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.LiveAddRequestPlayableListInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import d5.n;
import d8.d;
import df.v;
import e1.b;
import e3.h;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.q;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import oc.A0;
import oc.Q;
import oc.S;
import oc.V;
import oc.W;
import oc.Z;
import oc.d0;
import oc.m;
import oc.t;
import oc.w;
import oc.z0;
import oe.c;

public final class j implements w, a {
    public final i a;
    public final LogU b;
    public final Mutex c;
    public final MutableStateFlow d;
    public final h e;

    public j(i i0) {
        this.a = i0;
        this.b = Companion.create$default(LogU.Companion, "LivePlaylist", false, null, 6, null);
        this.c = MutexKt.Mutex$default(false, 1, null);
        this.d = StateFlowKt.MutableStateFlow(k.d);
        this.e = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.w
    public final Object B(Continuation continuation0) {
        int v = this.c().b;
        boolean z = false;
        if(!((AppVisibilityManagerImpl)this.a).e) {
            PlayableData playableData0 = b.z(this.c());
            Playable playable0 = playableData0 == null ? null : playableData0.a;
            if(playable0 != null) {
                z = playable0.isLivePreView();
            }
        }
        return new oc.j(v, z);
    }

    @Override  // oc.H
    public final AddPosition C() {
        return AddPosition.b;
    }

    @Override  // oc.w
    public final Object a(String s, Continuation continuation0) {
        return H.a;
    }

    @Override  // oc.H
    public final Object b(c c0) {
        Mutex mutex1;
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.D;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.D = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.w;
        ne.a a0 = ne.a.a;
        switch(f0.D) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                f0.r = mutex0;
                f0.D = 1;
                if(mutex0.lock(null, f0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                break;
            }
            case 1: {
                mutex1 = f0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            return this.c();
        }
        finally {
            mutex1.unlock(null);
        }
    }

    public final k c() {
        return (k)this.d.getValue();
    }

    @Override  // oc.H
    public final MutableStateFlow d() {
        return this.d;
    }

    public final Object e(String s, we.n n0, c c0) {
        MutableStateFlow mutableStateFlow1;
        String s1;
        uc.i i0;
        if(c0 instanceof uc.i) {
            i0 = (uc.i)c0;
            int v = i0.E;
            if((v & 0x80000000) == 0) {
                i0 = new uc.i(this, c0);
            }
            else {
                i0.E = v ^ 0x80000000;
            }
        }
        else {
            i0 = new uc.i(this, c0);
        }
        Object object0 = i0.B;
        ne.a a0 = ne.a.a;
        switch(i0.E) {
            case 0: {
                n.D(object0);
                MutableStateFlow mutableStateFlow0 = this.d;
                Object object1 = mutableStateFlow0.getValue();
                i0.r = s;
                i0.w = mutableStateFlow0;
                i0.E = 1;
                Object object2 = n0.invoke(object1, i0);
                if(object2 == a0) {
                    return a0;
                }
                s1 = s;
                mutableStateFlow1 = mutableStateFlow0;
                object0 = object2;
                break;
            }
            case 1: {
                mutableStateFlow1 = i0.w;
                s1 = i0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogConstantsKt.debugOnlyDebugMode(this.b, "updateState() " + ((k)object0) + ", reason: " + s1);
        mutableStateFlow1.setValue(object0);
        return H.a;
    }

    @Override  // oc.w
    public final Object g(Continuation continuation0) {
        return new oc.f("Not Supported");
    }

    @Override  // oc.H
    public final PlaylistId getId() {
        return PlaylistId.LIVE;
    }

    @Override  // oc.H
    public final String getMenuId() {
        return "1000000558";
    }

    @Override  // oc.H
    public final Q getState() {
        return this.c();
    }

    @Override  // oc.w
    public final Object h(String s, boolean z, we.n n0, c c0) {
        A0 a00;
        String s11;
        DevLog devLog4;
        String s10;
        Mutex mutex11;
        long v18;
        Mutex mutex10;
        z0 z00;
        long v16;
        List list3;
        Mutex mutex9;
        String s8;
        DevLog devLog3;
        Object object5;
        Mutex mutex8;
        long v12;
        int v10;
        String s7;
        int v9;
        DevLog devLog2;
        String s6;
        int v8;
        int v7;
        List list1;
        Mutex mutex7;
        boolean z3;
        long v6;
        Mutex mutex6;
        ne.a a1;
        Object object4;
        Object object3;
        Mutex mutex5;
        Mutex mutex4;
        ArrayList arrayList0;
        List list0;
        long v5;
        DevLog devLog1;
        int v2;
        int v1;
        String s3;
        we.n n1;
        Mutex mutex2;
        Mutex mutex1;
        String s2;
        boolean z1;
        String s1;
        DevLog devLog0;
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.b0;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.b0 = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Object object0 = g0.Y;
        ne.a a0 = ne.a.a;
        switch(g0.b0) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), H0.b.f(mutex0.hashCode(), "Lock[", "]  try : ", "live_" + ("updatePlayable-" + s)), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("live_" + ("updatePlayable-" + s)));
                g0.r = n0;
                g0.w = "updatePlayable-" + s;
                g0.B = mutex0;
                g0.D = "live_" + ("updatePlayable-" + s);
                g0.E = devLog0;
                s1 = "";
                g0.G = "";
                g0.I = mutex0;
                z1 = z;
                g0.N = z1;
                g0.S = 0;
                g0.T = 0;
                g0.b0 = 1;
                if(mutex0.lock(null, g0) == a0) {
                    return a0;
                }
                s2 = "updatePlayable-" + s;
                mutex1 = mutex0;
                mutex2 = mutex1;
                n1 = n0;
                s3 = "live_" + ("updatePlayable-" + s);
                v1 = 0;
                v2 = 0;
                devLog1 = devLog0;
                goto label_61;
            }
            case 1: {
                int v3 = g0.S;
                boolean z2 = g0.N;
                Mutex mutex3 = g0.I;
                Object object1 = g0.G;
                devLog0 = g0.E;
                String s4 = g0.D;
                int v4 = g0.T;
                mutex1 = g0.B;
                String s5 = g0.w;
                n1 = g0.r;
                n.D(object0);
                mutex2 = mutex3;
                v1 = v4;
                v2 = v3;
                s3 = s4;
                s1 = object1;
                s2 = s5;
                z1 = z2;
                devLog1 = devLog0;
                try {
                label_61:
                    v5 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s3, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s3);
                    k k0 = this.c();
                    list0 = k0.a;
                    arrayList0 = new ArrayList(q.Q(10, k0.a));
                    for(Object object2: k0.a) {
                        arrayList0.add(((PlayableData)object2).a);
                    }
                    g0.r = null;
                    g0.w = s2;
                    g0.B = mutex1;
                    g0.D = s3;
                    g0.E = devLog1;
                    g0.G = s1;
                    mutex4 = mutex2;
                    g0.I = mutex4;
                    mutex5 = mutex1;
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex2;
                    mutex5 = mutex1;
                    goto label_238;
                }
                try {
                    g0.M = list0;
                    g0.N = z1;
                    g0.S = v2;
                    g0.T = v1;
                    g0.V = 0;
                    g0.X = v5;
                    g0.W = 0;
                    g0.b0 = 2;
                    object3 = n1.invoke(arrayList0, g0);
                }
                catch(Throwable throwable0) {
                    goto label_238;
                }
                if(object3 == a0) {
                    return a0;
                }
                object4 = object3;
                a1 = a0;
                mutex6 = mutex4;
                v6 = v5;
                z3 = z1;
                mutex7 = mutex5;
                list1 = list0;
                v7 = 0;
                v8 = 0;
                s6 = s3;
                devLog2 = devLog1;
                v9 = v2;
                s7 = s1;
                v10 = v1;
                goto label_153;
            }
            case 2: {
                try {
                    int v11 = g0.W;
                    v12 = g0.X;
                    int v13 = g0.V;
                    int v14 = g0.T;
                    int v15 = g0.S;
                    boolean z4 = g0.N;
                    mutex8 = g0.I;
                    object5 = g0.G;
                    devLog3 = g0.E;
                    s8 = g0.D;
                    mutex9 = g0.B;
                    List list2 = g0.M;
                    String s9 = g0.w;
                    n.D(object0);
                    mutex7 = mutex9;
                    list1 = list2;
                    v9 = v15;
                    a1 = a0;
                    z3 = z4;
                    devLog2 = devLog3;
                    s6 = s8;
                    mutex6 = mutex8;
                    v8 = v11;
                    v10 = v14;
                    s2 = s9;
                    v7 = v13;
                    object4 = object0;
                    s7 = object5;
                    v6 = v12;
                }
                catch(Throwable throwable0) {
                    s1 = object5;
                    mutex5 = mutex9;
                    v5 = v12;
                    devLog1 = devLog3;
                    mutex4 = mutex8;
                    s3 = s8;
                    goto label_238;
                }
                try {
                label_153:
                    list3 = (List)object4;
                    if(list3.isEmpty()) {
                        goto label_159;
                    }
                    goto label_179;
                }
                catch(Throwable throwable0) {
                    v16 = v6;
                    goto label_200;
                }
                try {
                label_159:
                    LogU.debug$default(this.b, s2 + " no updated items", null, false, 6, null);
                    z00 = new z0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex6;
                    mutex5 = mutex7;
                    s1 = s7;
                    devLog1 = devLog2;
                    s3 = s6;
                    v5 = v6;
                    goto label_238;
                }
                try {
                    long v17 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s7 + " Lock return : " + s6 + " (" + v17 + "ms)", null, false, 6, null);
                    devLog2.put("Lock[" + mutex7.hashCode() + "] " + s7 + " Lock return : " + s6 + " (" + v17 + "ms)");
                }
                catch(Throwable throwable1) {
                    mutex10 = mutex6;
                    mutex10.unlock(null);
                    throw throwable1;
                }
                mutex6.unlock(null);
                return z00;
                try {
                label_179:
                    v16 = v6;
                    uc.h h0 = new uc.h(list1, list3, this, null);
                    g0.r = null;
                    g0.w = null;
                    g0.B = mutex7;
                    g0.D = s6;
                    g0.E = devLog2;
                    g0.G = s7;
                    g0.I = mutex6;
                    g0.M = null;
                    g0.N = z3;
                    g0.S = v9;
                    g0.T = v10;
                    g0.V = v7;
                    v16 = v6;
                    g0.X = v16;
                    g0.W = v8;
                    g0.b0 = 3;
                    if(this.e(s2, h0, g0) == a1) {
                        return a1;
                    }
                    goto label_208;
                }
                catch(Throwable throwable0) {
                }
            label_200:
                mutex5 = mutex7;
                s1 = s7;
                v5 = v16;
                mutex4 = mutex6;
                devLog1 = devLog2;
                s3 = s6;
                goto label_238;
            label_208:
                mutex4 = mutex6;
                v18 = v16;
                mutex11 = mutex7;
                s10 = s7;
                devLog4 = devLog2;
                break;
            }
            case 3: {
                try {
                    v18 = g0.X;
                    mutex4 = g0.I;
                    s10 = g0.G;
                    devLog4 = g0.E;
                    s11 = g0.D;
                    mutex11 = g0.B;
                    n.D(object0);
                    s6 = s11;
                    break;
                }
                catch(Throwable throwable0) {
                    s3 = s11;
                    mutex5 = mutex11;
                    s1 = s10;
                    devLog1 = devLog4;
                    v5 = v18;
                    goto label_238;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            a00 = new A0(this.c());
            goto label_242;
        }
        catch(Throwable throwable0) {
            mutex5 = mutex11;
            s1 = s10;
            s3 = s6;
            devLog1 = devLog4;
            v5 = v18;
        }
        try {
        label_238:
            long v19 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v19 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v19 + "ms)");
            throw throwable0;
        label_242:
            long v20 = System.currentTimeMillis() - v18;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex11.hashCode() + "] " + s10 + " Lock return : " + s6 + " (" + v20 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex11.hashCode() + "] " + s10 + " Lock return : " + s6 + " (" + v20 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex10 = mutex4;
            mutex10.unlock(null);
            throw throwable1;
        }
        mutex4.unlock(null);
        return a00;
    }

    @Override  // oc.w
    public final Object i(List list0, c c0) {
        return new S("Not Supported", false);
    }

    @Override  // oc.H
    public final long k() {
        return 0L;
    }

    @Override  // oc.H
    public final int l() {
        return 0;
    }

    @Override  // oc.H
    public final boolean n() {
        PlayableData playableData0 = b.z(this.c());
        if(playableData0 != null) {
            return playableData0.a == null ? false : playableData0.a.isLivePreView();
        }
        return false;
    }

    @Override  // oc.H
    public final int p() {
        return 0;
    }

    @Override  // oc.w
    public final Object q(int v, int v1, c c0) {
        return new t("Not Supported");
    }

    @Override  // oc.w
    public final Object r(long v, Continuation continuation0) {
        return H.a;
    }

    @Override  // oc.w
    public final Object u(V v0, c c0) {
        Z z0;
        String s6;
        Mutex mutex9;
        Mutex mutex8;
        Mutex mutex7;
        DevLog devLog5;
        String s5;
        List list0;
        Mutex mutex6;
        DevLog devLog4;
        Mutex mutex5;
        long v18;
        W w0;
        int v15;
        LiveAddRequestPlayableListInfo liveAddRequestPlayableListInfo1;
        long v14;
        Mutex mutex4;
        int v13;
        int v12;
        int v11;
        String s4;
        DevLog devLog3;
        long v10;
        ne.a a2;
        Object object1;
        DevLog devLog2;
        String s3;
        int v9;
        LiveAddRequestPlayableListInfo liveAddRequestPlayableListInfo0;
        String s2;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        Mutex mutex3;
        long v8;
        LogU logU0;
        MutexLockUtil mutexLockUtil0;
        long v7;
        String s1;
        V v4;
        Mutex mutex2;
        int v3;
        int v2;
        String s;
        ne.a a1;
        DevLog devLog1;
        Mutex mutex1;
        uc.c c1;
        if(c0 instanceof uc.c) {
            c1 = (uc.c)c0;
            int v1 = c1.Z;
            if((v1 & 0x80000000) == 0) {
                c1 = new uc.c(this, c0);
            }
            else {
                c1.Z = v1 ^ 0x80000000;
            }
        }
        else {
            c1 = new uc.c(this, c0);
        }
        Object object0 = c1.X;
        ne.a a0 = ne.a.a;
        switch(c1.Z) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : live_add"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : live_add", devLog0);
                c1.r = v0;
                c1.w = mutex0;
                c1.B = "live_add";
                c1.D = devLog0;
                c1.E = "";
                c1.G = mutex0;
                c1.M = 0;
                c1.N = 0;
                c1.Z = 1;
                if(mutex0.lock(null, c1) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                devLog1 = devLog0;
                a1 = a0;
                s = "live_add";
                v2 = 0;
                v3 = 0;
                mutex2 = mutex1;
                v4 = v0;
                s1 = "";
                goto label_51;
            }
            case 1: {
                int v5 = c1.M;
                mutex2 = c1.G;
                s1 = c1.E;
                devLog1 = c1.D;
                s = c1.B;
                int v6 = c1.N;
                mutex1 = c1.w;
                v4 = c1.r;
                n.D(object0);
                a1 = a0;
                v2 = v6;
                v3 = v5;
                try {
                label_51:
                    v7 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                try {
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    logU0 = mutexLockUtil0.getLog();
                    v8 = v7;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                    v8 = v7;
                    devLog2 = devLog1;
                    v10 = v8;
                    goto label_222;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    uc.b b0 = new uc.b(v4, 0);
                    LogConstantsKt.buildDebug(this.b, true, b0);
                    addRequestPlayableListInfo0 = v4.c;
                    if(!(addRequestPlayableListInfo0 instanceof LiveAddRequestPlayableListInfo)) {
                        goto label_71;
                    }
                    else if(((LiveAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist().size() != 1) {
                        s2 = "Invalid Response Info";
                    }
                    else {
                        s2 = "";
                    }
                    goto label_72;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                    devLog2 = devLog1;
                    v10 = v8;
                    goto label_222;
                }
                try {
                    s2 = "Invalid Response Info";
                    goto label_72;
                label_71:
                    s2 = "Unavailable Response Info";
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                    devLog2 = devLog1;
                    v10 = v8;
                    goto label_222;
                }
                try {
                label_72:
                    if(s2.length() <= 0) {
                        liveAddRequestPlayableListInfo0 = (LiveAddRequestPlayableListInfo)addRequestPlayableListInfo0;
                        d.E(System.currentTimeMillis(), liveAddRequestPlayableListInfo0.getUserRequestedPlaylist());
                        c1.r = null;
                        c1.w = mutex1;
                        c1.B = s;
                        c1.D = devLog1;
                        c1.E = s1;
                        c1.G = mutex2;
                        c1.I = liveAddRequestPlayableListInfo0;
                        c1.M = v3;
                        c1.N = v2;
                        v9 = v3;
                        c1.S = 0;
                        mutex3 = mutex1;
                        s3 = s1;
                        goto label_93;
                    }
                    goto label_117;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                }
                devLog2 = devLog1;
                v10 = v8;
                goto label_222;
                try {
                label_93:
                    c1.W = v8;
                    c1.T = 0;
                    c1.V = 0;
                    c1.Z = 2;
                    object1 = v.k(liveAddRequestPlayableListInfo0.getUserRequestedPlaylist(), this.e, c1);
                    a2 = a1;
                }
                catch(Throwable throwable1) {
                    devLog2 = devLog1;
                    s1 = s3;
                    v10 = v8;
                    goto label_222;
                }
                if(object1 != a2) {
                    devLog3 = devLog1;
                    s4 = s;
                    v11 = 0;
                    v12 = 0;
                    v13 = 0;
                    mutex4 = mutex2;
                    v14 = v8;
                    liveAddRequestPlayableListInfo1 = liveAddRequestPlayableListInfo0;
                    v15 = v2;
                    goto label_163;
                }
                return a2;
                try {
                label_117:
                    w0 = new W(PlaylistId.LIVE, s2);
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                    devLog2 = devLog1;
                    v10 = v8;
                    goto label_222;
                }
                try {
                    long v16 = System.currentTimeMillis() - v8;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v16 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v16 + "ms)");
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                mutex2.unlock(null);
                return w0;
            }
            case 2: {
                try {
                    int v17 = c1.V;
                    v18 = c1.W;
                    int v19 = c1.S;
                    int v20 = c1.N;
                    int v21 = c1.M;
                    LiveAddRequestPlayableListInfo liveAddRequestPlayableListInfo2 = c1.I;
                    int v22 = c1.T;
                    mutex5 = c1.G;
                    s3 = c1.E;
                    devLog4 = c1.D;
                    s4 = c1.B;
                    mutex6 = c1.w;
                    n.D(object0);
                    v13 = v22;
                    v12 = v19;
                    v15 = v20;
                    v11 = v17;
                    mutex4 = mutex5;
                    v14 = v18;
                    liveAddRequestPlayableListInfo1 = liveAddRequestPlayableListInfo2;
                    object1 = object0;
                    devLog3 = devLog4;
                    mutex3 = mutex6;
                    a2 = a0;
                    v9 = v21;
                }
                catch(Throwable throwable1) {
                    mutex2 = mutex5;
                    s1 = s3;
                    devLog2 = devLog4;
                    s = s4;
                    mutex3 = mutex6;
                    v10 = v18;
                    goto label_222;
                }
                try {
                label_163:
                    list0 = (List)object1;
                    s5 = s4;
                    devLog5 = devLog3;
                }
                catch(Throwable throwable1) {
                    mutex7 = mutex4;
                    s5 = s4;
                    devLog5 = devLog3;
                    v10 = v14;
                    s1 = s3;
                    s = s5;
                    devLog2 = devLog5;
                    mutex2 = mutex7;
                    goto label_222;
                }
                try {
                    e e0 = new e(this, list0, v11, liveAddRequestPlayableListInfo1, null);
                    c1.r = null;
                    c1.w = mutex3;
                    c1.B = s5;
                    c1.D = devLog5;
                    c1.E = s3;
                    c1.G = mutex4;
                    c1.I = null;
                    c1.M = v9;
                    c1.N = v15;
                    c1.S = v12;
                    c1.W = v14;
                    c1.T = v13;
                    c1.V = v11;
                    c1.Z = 3;
                    if(BuildersKt.withContext(NonCancellable.INSTANCE, e0, c1) == a2) {
                        return a2;
                    }
                }
                catch(Throwable throwable1) {
                    mutex7 = mutex4;
                    v10 = v14;
                    s1 = s3;
                    s = s5;
                    devLog2 = devLog5;
                    mutex2 = mutex7;
                    goto label_222;
                }
                v10 = v14;
                mutex8 = mutex4;
                s1 = s3;
                mutex9 = mutex3;
                s6 = s5;
                devLog2 = devLog5;
                goto label_215;
            }
            case 3: {
                v10 = c1.W;
                List list1 = (List)c1.I;
                mutex8 = c1.G;
                s1 = c1.E;
                devLog2 = c1.D;
                s6 = c1.B;
                mutex9 = c1.w;
                try {
                    n.D(object0);
                label_215:
                    k k0 = this.c();
                    z0 = new Z(PlaylistId.LIVE, je.w.a, true, k0, 0L);
                    goto label_228;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex3 = mutex9;
        s = s6;
        mutex2 = mutex8;
        try {
        label_222:
            long v23 = System.currentTimeMillis() - v10;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex3.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v23 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex3.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v23 + "ms)");
            throw throwable1;
        }
        catch(Throwable throwable0) {
            mutex2.unlock(null);
            throw throwable0;
        }
        try {
        label_228:
            long v24 = System.currentTimeMillis() - v10;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex9.hashCode() + "] " + s1 + " Lock return : " + s6 + " (" + v24 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex9.hashCode() + "] " + s1 + " Lock return : " + s6 + " (" + v24 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex2 = mutex8;
            mutex2.unlock(null);
            throw throwable0;
        }
        mutex8.unlock(null);
        return z0;
    }

    @Override  // oc.w
    public final Object v(int v, long v1, boolean z, String s, Continuation continuation0) {
        if(!A8.b.d()) {
            throw new IllegalStateException("Not Supported");
        }
        return new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.H
    public final ListKeepOption x() {
        return ListKeepOption.c;
    }

    @Override  // oc.w
    public final Object z(Continuation continuation0) {
        return new m("Not Supported");
    }
}

