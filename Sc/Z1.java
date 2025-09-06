package sc;

import H0.b;
import androidx.appcompat.app.o;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.playback.SpApiQueueBaseTask;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import we.a;

public final class z1 extends SpApiQueueBaseTask {
    public final int a;
    public final S2 b;
    public final l1 c;
    public final boolean d;
    public final Object e;

    public z1(String s, S2 s20, l1 l10, boolean z) {
        this.a = 0;
        this.e = s;
        this.b = s20;
        this.c = l10;
        this.d = z;
        super(1, s);
    }

    public z1(S2 s20, l1 l10, h1 h10, boolean z) {
        this.a = 1;
        this.b = s20;
        this.c = l10;
        this.e = h10;
        this.d = z;
        super(1, "UpdateAllToServer");
    }

    @Override  // com.iloen.melon.playback.SpApiQueueBaseTask
    public final Object execute(Continuation continuation0) {
        PlaylistsSmartEditRes playlistsSmartEditRes1;
        DevLog devLog8;
        int v21;
        int v20;
        int v19;
        Mutex mutex10;
        a a5;
        S2 s27;
        String s9;
        DevLog devLog6;
        long v18;
        S2 s26;
        Object object1;
        int v17;
        String s8;
        Mutex mutex9;
        long v16;
        l1 l13;
        DevLog devLog5;
        String s7;
        String s6;
        x1 x10;
        PlaylistsSmartEditRes playlistsSmartEditRes0;
        Mutex mutex5;
        int v8;
        int v7;
        int v6;
        int v5;
        l1 l11;
        long v4;
        S2 s23;
        Mutex mutex3;
        a a2;
        long v3;
        S2 s22;
        Object object0;
        o2 o20;
        S2 s21;
        String s3;
        String s2;
        DevLog devLog2;
        Mutex mutex2;
        long v2;
        long v1;
        DevLog devLog1;
        String s1;
        String s;
        M2 m20;
        if(this.a != 0) {
            if(continuation0 instanceof M2) {
                m20 = (M2)continuation0;
                int v = m20.X;
                if((v & 0x80000000) == 0) {
                    m20 = new M2(this, continuation0);
                }
                else {
                    m20.X = v ^ 0x80000000;
                }
            }
            else {
                m20 = new M2(this, continuation0);
            }
            a a0 = m20.V;
            ne.a a1 = ne.a.a;
            switch(m20.X) {
                case 0: {
                    n.D(a0);
                    S2 s20 = this.b;
                    Mutex mutex1 = s20.e;
                    s = "UpdateAllToServer";
                    h1 h10 = (h1)this.e;
                    s1 = "";
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex1.hashCode(), "ReentrantLock[", "]  try : UpdateAllToServer"), null, false, 6, null);
                    MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    devLog1 = DevLog.Companion.get("MutexLockUtil");
                    ReentrantMutexContextKey reentrantMutexContextKey1 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex1.hashCode(), "]  try : UpdateAllToServer", devLog1, mutex1);
                    g g0 = m20.getContext().get(reentrantMutexContextKey1);
                    l1 l10 = this.c;
                    boolean z = this.d;
                    if(g0 == null) {
                        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                        L2 l20 = new L2(mutex1, null, mutex1, devLog1, s20, l10, h10, z, this);
                        m20.r = null;
                        m20.w = null;
                        m20.B = null;
                        m20.D = null;
                        m20.E = null;
                        m20.G = null;
                        m20.I = 0;
                        m20.M = 0;
                        m20.X = 3;
                        a0 = BuildersKt.withContext(reentrantMutexContextElement0, l20, m20);
                        if(a0 != a1) {
                            return a0;
                        }
                    }
                    else {
                        try {
                            v1 = System.currentTimeMillis();
                            LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : UpdateAllToServer", null, false, 6, null);
                            devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : UpdateAllToServer");
                        }
                        catch(Throwable throwable0) {
                            v2 = v1;
                            mutex2 = mutex1;
                            devLog2 = devLog1;
                            s2 = "UpdateAllToServer";
                            s3 = "";
                            goto label_216;
                        }
                        try {
                            s20.r();
                            m20.r = mutex1;
                            m20.w = "UpdateAllToServer";
                            m20.B = s20;
                            m20.D = l10;
                            m20.E = devLog1;
                            m20.G = "";
                            m20.I = 0;
                            m20.M = 0;
                            m20.N = 0;
                            m20.T = v1;
                            m20.S = 0;
                            m20.X = 1;
                        }
                        catch(Exception exception0) {
                            v2 = v1;
                            s21 = s20;
                            goto label_81;
                        }
                        catch(Throwable throwable0) {
                            v2 = v1;
                            mutex2 = mutex1;
                            devLog2 = devLog1;
                            s2 = "UpdateAllToServer";
                            s3 = "";
                            goto label_216;
                        }
                        try {
                            try {
                                s21 = s20;
                                v2 = v1;
                                o20 = new o2(s20, l10, h10, z, null);
                                s21 = s20;
                                v2 = v1;
                            }
                            catch(Exception exception0) {
                                v2 = v1;
                                goto label_81;
                            }
                            try {
                                object0 = TimeoutKt.withTimeout(3000L, o20, m20);
                                goto label_94;
                            }
                            catch(Exception exception0) {
                            }
                        label_81:
                            mutex2 = mutex1;
                            s22 = s21;
                            devLog2 = devLog1;
                            s2 = "UpdateAllToServer";
                            s3 = "";
                            v3 = v2;
                            a0 = S2.f(s22, this, exception0);
                            break;
                        }
                        catch(Throwable throwable0) {
                            mutex2 = mutex1;
                            devLog2 = devLog1;
                            s2 = "UpdateAllToServer";
                            s3 = "";
                            goto label_216;
                        }
                    label_94:
                        if(object0 != a1) {
                            a2 = object0;
                            mutex3 = mutex1;
                            s23 = s21;
                            v4 = v2;
                            l11 = l10;
                            v5 = 0;
                            v6 = 0;
                            v7 = 0;
                            v8 = 0;
                            goto label_158;
                        }
                    }
                    return a1;
                }
                case 1: {
                    int v9 = m20.S;
                    v4 = m20.T;
                    int v10 = m20.N;
                    int v11 = m20.M;
                    int v12 = m20.I;
                    String s4 = m20.G;
                    a2 = a0;
                    DevLog devLog3 = (DevLog)m20.E;
                    l1 l12 = (l1)m20.D;
                    S2 s24 = m20.B;
                    String s5 = m20.w;
                    Mutex mutex4 = m20.r;
                    try {
                        n.D(a2);
                        v8 = v12;
                        s23 = s24;
                        s1 = s4;
                        s = s5;
                        mutex3 = mutex4;
                        l11 = l12;
                        v5 = v11;
                        devLog1 = devLog3;
                        v7 = v10;
                        v6 = v9;
                    }
                    catch(Exception exception0) {
                        mutex2 = mutex4;
                        v3 = v4;
                        s3 = s4;
                        devLog2 = devLog3;
                        s22 = s24;
                        s2 = s5;
                        a0 = S2.f(s22, this, exception0);
                        break;
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex4;
                        v2 = v4;
                        s3 = s4;
                        devLog2 = devLog3;
                        s2 = s5;
                        goto label_216;
                    }
                    try {
                        try {
                        label_158:
                            mutex5 = mutex3;
                            playlistsSmartEditRes0 = (PlaylistsSmartEditRes)a2;
                            m20.r = mutex3;
                            m20.w = s;
                            m20.B = s23;
                            m20.D = devLog1;
                            m20.E = s1;
                            mutex5 = mutex3;
                        }
                        catch(Exception exception0) {
                            mutex5 = mutex3;
                            goto label_180;
                        }
                        try {
                            m20.G = null;
                            m20.I = v8;
                            m20.M = v5;
                            m20.N = v7;
                            m20.T = v4;
                            m20.S = v6;
                            m20.X = 2;
                            a0 = S2.e(s23, this, l11, playlistsSmartEditRes0, m20);
                            goto label_194;
                        }
                        catch(Exception exception0) {
                        }
                    label_180:
                        v3 = v4;
                        s22 = s23;
                        devLog2 = devLog1;
                        s2 = s;
                        s3 = s1;
                        mutex2 = mutex5;
                        a0 = S2.f(s22, this, exception0);
                        break;
                    }
                    catch(Throwable throwable0) {
                        v2 = v4;
                        devLog2 = devLog1;
                        s2 = s;
                        s3 = s1;
                        mutex2 = mutex5;
                        goto label_216;
                    }
                label_194:
                    if(a0 != a1) {
                        v3 = v4;
                        devLog2 = devLog1;
                        s2 = s;
                        s3 = s1;
                        mutex2 = mutex5;
                        break;
                    }
                    return a1;
                }
                case 2: {
                    v3 = m20.T;
                    Mutex mutex6 = (Mutex)m20.G;
                    s3 = m20.E;
                    devLog2 = (DevLog)m20.D;
                    s22 = m20.B;
                    s2 = m20.w;
                    mutex2 = m20.r;
                    try {
                        try {
                            n.D(a0);
                            break;
                        }
                        catch(Exception exception0) {
                        }
                        a0 = S2.f(s22, this, exception0);
                        break;
                    }
                    catch(Throwable throwable0) {
                        v2 = v3;
                    }
                label_216:
                    long v13 = System.currentTimeMillis() - v2;
                    StringBuilder stringBuilder0 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
                    b.t(v13, s2, " (", stringBuilder0);
                    stringBuilder0.append("ms)");
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                    StringBuilder stringBuilder1 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
                    b.t(v13, s2, " (", stringBuilder1);
                    com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog2);
                    throw throwable0;
                }
                case 3: {
                    ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)m20.G;
                    Mutex mutex0 = (Mutex)m20.E;
                    DevLog devLog0 = (DevLog)m20.B;
                    n.D(a0);
                    return a0;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            long v14 = System.currentTimeMillis() - v3;
            StringBuilder stringBuilder2 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
            b.t(v14, s2, " (", stringBuilder2);
            stringBuilder2.append("ms)");
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
            StringBuilder stringBuilder3 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
            b.t(v14, s2, " (", stringBuilder3);
            com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog2);
            return a0;
        }
        if(continuation0 instanceof x1) {
            x10 = (x1)continuation0;
            int v15 = x10.X;
            if((v15 & 0x80000000) == 0) {
                x10 = new x1(this, continuation0);
            }
            else {
                x10.X = v15 ^ 0x80000000;
            }
        }
        else {
            x10 = new x1(this, continuation0);
        }
        a a3 = x10.V;
        ne.a a4 = ne.a.a;
        switch(x10.X) {
            case 0: {
                n.D(a3);
                S2 s25 = this.b;
                Mutex mutex8 = s25.e;
                s6 = (String)this.e;
                s7 = "";
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), b.f(mutex8.hashCode(), "ReentrantLock[", "]  try : ", s6), null, false, 6, null);
                MutexLockUtil mutexLockUtil1 = MutexLockUtil.INSTANCE;
                devLog5 = DevLog.Companion.get("MutexLockUtil");
                devLog5.put("ReentrantLock[" + mutex8.hashCode() + "]  try : " + s6);
                ReentrantMutexContextKey reentrantMutexContextKey3 = new ReentrantMutexContextKey(mutex8);
                g g1 = x10.getContext().get(reentrantMutexContextKey3);
                l13 = this.c;
                boolean z1 = this.d;
                if(g1 == null) {
                    ReentrantMutexContextElement reentrantMutexContextElement1 = new ReentrantMutexContextElement(reentrantMutexContextKey3);
                    w1 w10 = new w1(mutex8, null, mutex8, s6, devLog5, s25, this, l13, z1);
                    x10.r = null;
                    x10.w = null;
                    x10.B = null;
                    x10.D = null;
                    x10.E = null;
                    x10.G = null;
                    x10.I = 0;
                    x10.M = 0;
                    x10.X = 3;
                    a3 = BuildersKt.withContext(reentrantMutexContextElement1, w10, x10);
                    if(a3 != a4) {
                        return a3;
                    }
                }
                else {
                    try {
                        v16 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil1.getLog(), "ReentrantLock[" + mutex8.hashCode() + "]  Lock obtain : " + s6, null, false, 6, null);
                        devLog5.put("ReentrantLock[" + mutex8.hashCode() + "]  Lock obtain : " + s6);
                    }
                    catch(Throwable throwable1) {
                        mutex9 = mutex8;
                        s8 = "";
                        goto label_430;
                    }
                    try {
                        s25.r();
                        y1 y10 = new y1(s25, l13, z1, null);
                        x10.r = mutex8;
                        x10.w = s6;
                        x10.B = s25;
                        x10.D = l13;
                        x10.E = devLog5;
                        x10.G = "";
                        v17 = 0;
                        x10.I = 0;
                        x10.M = 0;
                        x10.N = 0;
                        x10.T = v16;
                        x10.S = 0;
                        x10.X = 1;
                        object1 = BuildersKt.withContext(Dispatchers.getIO(), y10, x10);
                    }
                    catch(Exception exception1) {
                        s26 = s25;
                        mutex9 = mutex8;
                        v18 = v16;
                        devLog6 = devLog5;
                        s9 = s6;
                        s8 = s7;
                        a3 = S2.f(s26, this, exception1);
                        break;
                    }
                    catch(Throwable throwable1) {
                        mutex9 = mutex8;
                        s8 = "";
                        goto label_430;
                    }
                    if(object1 != a4) {
                        s27 = s25;
                        v18 = v16;
                        a5 = object1;
                        mutex10 = mutex8;
                        v19 = 0;
                        v20 = 0;
                        devLog6 = devLog5;
                        s9 = s6;
                        v21 = 0;
                        goto label_367;
                    }
                }
                return a4;
            }
            case 1: {
                int v22 = x10.S;
                long v23 = x10.T;
                int v24 = x10.N;
                int v25 = x10.M;
                int v26 = x10.I;
                String s10 = x10.G;
                DevLog devLog7 = (DevLog)x10.E;
                l1 l14 = (l1)x10.D;
                S2 s28 = x10.B;
                String s11 = x10.w;
                Mutex mutex11 = x10.r;
                try {
                    n.D(a3);
                    v17 = v22;
                    a5 = a3;
                    l13 = l14;
                    v19 = v26;
                    s7 = s10;
                    v21 = v25;
                    s9 = s11;
                    s27 = s28;
                    mutex10 = mutex11;
                    v20 = v24;
                    v18 = v23;
                    devLog6 = devLog7;
                }
                catch(Exception exception1) {
                    mutex9 = mutex11;
                    v18 = v23;
                    s8 = s10;
                    devLog6 = devLog7;
                    s26 = s28;
                    s9 = s11;
                    a3 = S2.f(s26, this, exception1);
                    break;
                }
                catch(Throwable throwable1) {
                    mutex9 = mutex11;
                    devLog5 = devLog7;
                    v16 = v23;
                    s8 = s10;
                    s6 = s11;
                    goto label_430;
                }
                try {
                    try {
                    label_367:
                        devLog8 = devLog6;
                        playlistsSmartEditRes1 = (PlaylistsSmartEditRes)a5;
                        x10.r = mutex10;
                        x10.w = s9;
                        x10.B = s27;
                        x10.D = devLog6;
                        x10.E = s7;
                        devLog8 = devLog6;
                        goto label_381;
                    }
                    catch(Exception exception1) {
                        mutex9 = mutex10;
                        s26 = s27;
                    }
                    s8 = s7;
                    a3 = S2.f(s26, this, exception1);
                    break;
                    try {
                    label_381:
                        x10.G = null;
                        x10.I = v19;
                        x10.M = v21;
                        x10.N = v20;
                        x10.T = v18;
                        x10.S = v17;
                        x10.X = 2;
                        a3 = S2.e(s27, this, l13, playlistsSmartEditRes1, x10);
                    }
                    catch(Exception exception1) {
                        mutex9 = mutex10;
                        s26 = s27;
                        s8 = s7;
                        devLog6 = devLog8;
                        a3 = S2.f(s26, this, exception1);
                        break;
                    }
                }
                catch(Throwable throwable1) {
                    mutex9 = mutex10;
                    s6 = s9;
                    s8 = s7;
                    devLog5 = devLog8;
                    v16 = v18;
                    goto label_430;
                }
                if(a3 != a4) {
                    mutex9 = mutex10;
                    s8 = s7;
                    devLog6 = devLog8;
                    break;
                }
                return a4;
            }
            case 2: {
                v18 = x10.T;
                Mutex mutex12 = (Mutex)x10.G;
                s8 = x10.E;
                devLog6 = (DevLog)x10.D;
                s26 = x10.B;
                s9 = x10.w;
                mutex9 = x10.r;
                try {
                    n.D(a3);
                    break;
                }
                catch(Exception exception1) {
                    try {
                        a3 = S2.f(s26, this, exception1);
                        break;
                    }
                    catch(Throwable throwable1) {
                        devLog5 = devLog6;
                        v16 = v18;
                        s6 = s9;
                    }
                }
                catch(Throwable throwable1) {
                    s6 = s9;
                    devLog5 = devLog6;
                    v16 = v18;
                }
            label_430:
                long v27 = System.currentTimeMillis() - v16;
                StringBuilder stringBuilder4 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex9.hashCode(), s8);
                b.t(v27, s6, " (", stringBuilder4);
                stringBuilder4.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder4.toString(), null, false, 6, null);
                StringBuilder stringBuilder5 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex9.hashCode(), s8);
                b.t(v27, s6, " (", stringBuilder5);
                com.iloen.melon.custom.l1.C(stringBuilder5, "ms)", devLog5);
                throw throwable1;
            }
            case 3: {
                ReentrantMutexContextKey reentrantMutexContextKey2 = (ReentrantMutexContextKey)x10.G;
                Mutex mutex7 = (Mutex)x10.E;
                DevLog devLog4 = (DevLog)x10.B;
                n.D(a3);
                return a3;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v28 = System.currentTimeMillis() - v18;
        StringBuilder stringBuilder6 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex9.hashCode(), s8);
        b.t(v28, s9, " (", stringBuilder6);
        stringBuilder6.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder6.toString(), null, false, 6, null);
        StringBuilder stringBuilder7 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex9.hashCode(), s8);
        b.t(v28, s9, " (", stringBuilder7);
        com.iloen.melon.custom.l1.C(stringBuilder7, "ms)", devLog6);
        return a3;
    }
}

