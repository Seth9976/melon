package sc;

import H0.b;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.SpApiQueueBaseTask;
import com.iloen.melon.playback.SpApiQueueBaseTaskKt;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.p;
import java.io.Serializable;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import va.e;
import we.a;

public final class q1 extends SpApiQueueBaseTask {
    public final int a;
    public final String b;
    public final S2 c;
    public final l1 d;
    public final Serializable e;

    public q1(String s, S2 s20, l1 l10, Serializable serializable0, int v) {
        this.a = v;
        this.b = s;
        this.c = s20;
        this.d = l10;
        this.e = serializable0;
        super(1, s);
    }

    @Override  // com.iloen.melon.playback.SpApiQueueBaseTask
    public final Object execute(Continuation continuation0) {
        HttpResponse httpResponse0;
        DevLog devLog2;
        String s4;
        String s3;
        String s2;
        Mutex mutex2;
        long v2;
        S2 s21;
        long v1;
        DevLog devLog1;
        String s1;
        String s;
        Mutex mutex1;
        O2 o20;
        PlaylistsSmartEditRes playlistsSmartEditRes1;
        DevLog devLog12;
        int v25;
        int v24;
        int v23;
        int v22;
        Mutex mutex12;
        a a7;
        S2 s28;
        long v21;
        DevLog devLog10;
        S2 s27;
        Object object1;
        String s13;
        String s12;
        Mutex mutex11;
        long v20;
        l1 l13;
        DevLog devLog9;
        String s11;
        String s10;
        t1 t10;
        PlaylistsSmartEditRes playlistsSmartEditRes0;
        DevLog devLog7;
        int v11;
        int v10;
        int v9;
        int v8;
        Mutex mutex6;
        a a4;
        S2 s24;
        long v7;
        DevLog devLog5;
        S2 s23;
        Object object0;
        String s8;
        String s7;
        Mutex mutex5;
        long v6;
        l1 l11;
        DevLog devLog4;
        String s6;
        String s5;
        o1 o10;
        switch(this.a) {
            case 0: {
                if(continuation0 instanceof o1) {
                    o10 = (o1)continuation0;
                    int v5 = o10.X;
                    if((v5 & 0x80000000) == 0) {
                        o10 = new o1(this, continuation0);
                    }
                    else {
                        o10.X = v5 ^ 0x80000000;
                    }
                }
                else {
                    o10 = new o1(this, continuation0);
                }
                a a2 = o10.V;
                ne.a a3 = ne.a.a;
                switch(o10.X) {
                    case 0: {
                        n.D(a2);
                        S2 s22 = this.c;
                        Mutex mutex4 = s22.e;
                        AddPosition addPosition0 = (AddPosition)this.e;
                        s5 = "";
                        MutexLockUtil mutexLockUtil1 = MutexLockUtil.INSTANCE;
                        s6 = this.b;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), b.f(mutex4.hashCode(), "ReentrantLock[", "]  try : ", s6), null, false, 6, null);
                        devLog4 = DevLog.Companion.get("MutexLockUtil");
                        devLog4.put("ReentrantLock[" + mutex4.hashCode() + "]  try : " + s6);
                        ReentrantMutexContextKey reentrantMutexContextKey3 = new ReentrantMutexContextKey(mutex4);
                        g g1 = o10.getContext().get(reentrantMutexContextKey3);
                        l11 = this.d;
                        if(g1 == null) {
                            ReentrantMutexContextElement reentrantMutexContextElement1 = new ReentrantMutexContextElement(reentrantMutexContextKey3);
                            n1 n10 = new n1(mutex4, null, mutex4, s6, devLog4, s22, this, l11, addPosition0);
                            o10.r = null;
                            o10.w = null;
                            o10.B = null;
                            o10.D = null;
                            o10.E = null;
                            o10.G = null;
                            o10.I = 0;
                            o10.M = 0;
                            o10.X = 3;
                            a2 = BuildersKt.withContext(reentrantMutexContextElement1, n10, o10);
                            if(a2 != a3) {
                                return a2;
                            }
                        }
                        else {
                            try {
                                v6 = System.currentTimeMillis();
                                LogU.debug$default(mutexLockUtil1.getLog(), "ReentrantLock[" + mutex4.hashCode() + "]  Lock obtain : " + s6, null, false, 6, null);
                                devLog4.put("ReentrantLock[" + mutex4.hashCode() + "]  Lock obtain : " + s6);
                            }
                            catch(Throwable throwable3) {
                                mutex5 = mutex4;
                                s7 = "";
                                s8 = s6;
                                goto label_319;
                            }
                            try {
                                s22.r();
                                p1 p10 = new p1(s22, l11, addPosition0, null);
                                o10.r = mutex4;
                                o10.w = s6;
                                o10.B = s22;
                                o10.D = l11;
                                o10.E = devLog4;
                                o10.G = "";
                                o10.I = 0;
                                o10.M = 0;
                                o10.N = 0;
                                o10.T = v6;
                                o10.S = 0;
                                o10.X = 1;
                                object0 = BuildersKt.withContext(Dispatchers.getIO(), p10, o10);
                            }
                            catch(Exception exception0) {
                                s23 = s22;
                                mutex5 = mutex4;
                                devLog5 = devLog4;
                                v7 = v6;
                                s7 = "";
                                s8 = s6;
                                a2 = S2.f(s23, this, exception0);
                                break;
                            }
                            catch(Throwable throwable3) {
                                mutex5 = mutex4;
                                s7 = s5;
                                s8 = s6;
                                goto label_319;
                            }
                            if(object0 != a3) {
                                s24 = s22;
                                v7 = v6;
                                a4 = object0;
                                mutex6 = mutex4;
                                v8 = 0;
                                v9 = 0;
                                v10 = 0;
                                v11 = 0;
                                goto label_259;
                            }
                        }
                        return a3;
                    }
                    case 1: {
                        int v12 = o10.S;
                        long v13 = o10.T;
                        int v14 = o10.N;
                        int v15 = o10.M;
                        int v16 = o10.I;
                        s5 = o10.G;
                        DevLog devLog6 = (DevLog)o10.E;
                        l1 l12 = (l1)o10.D;
                        S2 s25 = o10.B;
                        String s9 = o10.w;
                        Mutex mutex7 = o10.r;
                        try {
                            n.D(a2);
                            l11 = l12;
                            v8 = v16;
                            s6 = s9;
                            s24 = s25;
                            v11 = v15;
                            mutex6 = mutex7;
                            v10 = v14;
                            v7 = v13;
                            v9 = v12;
                            a4 = a2;
                            devLog4 = devLog6;
                        }
                        catch(Exception exception0) {
                            mutex5 = mutex7;
                            v7 = v13;
                            s7 = s5;
                            devLog5 = devLog6;
                            s23 = s25;
                            s8 = s9;
                            a2 = S2.f(s23, this, exception0);
                            break;
                        }
                        catch(Throwable throwable3) {
                            mutex5 = mutex7;
                            devLog4 = devLog6;
                            s8 = s9;
                            v6 = v13;
                            s7 = s5;
                            goto label_319;
                        }
                        try {
                        label_259:
                            devLog7 = devLog4;
                            playlistsSmartEditRes0 = (PlaylistsSmartEditRes)a4;
                            o10.r = mutex6;
                            o10.w = s6;
                            o10.B = s24;
                            o10.D = devLog4;
                            o10.E = s5;
                            devLog7 = devLog4;
                            goto label_274;
                        }
                        catch(Exception exception0) {
                            goto label_284;
                        }
                        catch(Throwable throwable3) {
                        }
                        v6 = v7;
                        mutex5 = mutex6;
                        s7 = s5;
                        s8 = s6;
                        goto label_319;
                        try {
                        label_274:
                            o10.G = null;
                            o10.I = v8;
                            o10.M = v11;
                            o10.N = v10;
                            o10.T = v7;
                            o10.S = v9;
                            o10.X = 2;
                            a2 = S2.e(s24, this, l11, playlistsSmartEditRes0, o10);
                        }
                        catch(Exception exception0) {
                        label_284:
                            mutex5 = mutex6;
                            s23 = s24;
                            s7 = s5;
                            s8 = s6;
                            devLog5 = devLog7;
                            a2 = S2.f(s23, this, exception0);
                            break;
                        }
                        catch(Throwable throwable3) {
                            v6 = v7;
                            mutex5 = mutex6;
                            s7 = s5;
                            s8 = s6;
                            devLog4 = devLog7;
                            goto label_319;
                        }
                        if(a2 != a3) {
                            mutex5 = mutex6;
                            s7 = s5;
                            s8 = s6;
                            devLog5 = devLog7;
                            break;
                        }
                        return a3;
                    }
                    case 2: {
                        v7 = o10.T;
                        Mutex mutex8 = (Mutex)o10.G;
                        s7 = o10.E;
                        devLog5 = (DevLog)o10.D;
                        s23 = o10.B;
                        s8 = o10.w;
                        mutex5 = o10.r;
                        try {
                            n.D(a2);
                            break;
                        }
                        catch(Exception exception0) {
                            try {
                                a2 = S2.f(s23, this, exception0);
                                break;
                            }
                            catch(Throwable throwable3) {
                            }
                            goto label_317;
                        }
                        catch(Throwable throwable3) {
                        label_317:
                            devLog4 = devLog5;
                            v6 = v7;
                        }
                    label_319:
                        long v17 = System.currentTimeMillis() - v6;
                        StringBuilder stringBuilder4 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex5.hashCode(), s7);
                        b.t(v17, s8, " (", stringBuilder4);
                        stringBuilder4.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder4.toString(), null, false, 6, null);
                        StringBuilder stringBuilder5 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex5.hashCode(), s7);
                        b.t(v17, s8, " (", stringBuilder5);
                        com.iloen.melon.custom.l1.C(stringBuilder5, "ms)", devLog4);
                        throw throwable3;
                    }
                    case 3: {
                        ReentrantMutexContextKey reentrantMutexContextKey2 = (ReentrantMutexContextKey)o10.G;
                        Mutex mutex3 = (Mutex)o10.E;
                        DevLog devLog3 = (DevLog)o10.B;
                        n.D(a2);
                        return a2;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                long v18 = System.currentTimeMillis() - v7;
                StringBuilder stringBuilder6 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex5.hashCode(), s7);
                b.t(v18, s8, " (", stringBuilder6);
                stringBuilder6.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder6.toString(), null, false, 6, null);
                StringBuilder stringBuilder7 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex5.hashCode(), s7);
                b.t(v18, s8, " (", stringBuilder7);
                com.iloen.melon.custom.l1.C(stringBuilder7, "ms)", devLog5);
                return a2;
            }
            case 1: {
                if(continuation0 instanceof t1) {
                    t10 = (t1)continuation0;
                    int v19 = t10.X;
                    if((v19 & 0x80000000) == 0) {
                        t10 = new t1(this, continuation0);
                    }
                    else {
                        t10.X = v19 ^ 0x80000000;
                    }
                }
                else {
                    t10 = new t1(this, continuation0);
                }
                a a5 = t10.V;
                ne.a a6 = ne.a.a;
                switch(t10.X) {
                    case 0: {
                        n.D(a5);
                        S2 s26 = this.c;
                        Mutex mutex10 = s26.e;
                        ListKeepOption listKeepOption0 = (ListKeepOption)this.e;
                        s10 = "";
                        MutexLockUtil mutexLockUtil2 = MutexLockUtil.INSTANCE;
                        s11 = this.b;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), b.f(mutex10.hashCode(), "ReentrantLock[", "]  try : ", s11), null, false, 6, null);
                        devLog9 = DevLog.Companion.get("MutexLockUtil");
                        devLog9.put("ReentrantLock[" + mutex10.hashCode() + "]  try : " + s11);
                        ReentrantMutexContextKey reentrantMutexContextKey5 = new ReentrantMutexContextKey(mutex10);
                        g g2 = t10.getContext().get(reentrantMutexContextKey5);
                        l13 = this.d;
                        if(g2 == null) {
                            ReentrantMutexContextElement reentrantMutexContextElement2 = new ReentrantMutexContextElement(reentrantMutexContextKey5);
                            s1 s10_1 = new s1(mutex10, null, mutex10, s11, devLog9, s26, this, l13, listKeepOption0);
                            t10.r = null;
                            t10.w = null;
                            t10.B = null;
                            t10.D = null;
                            t10.E = null;
                            t10.G = null;
                            t10.I = 0;
                            t10.M = 0;
                            t10.X = 3;
                            a5 = BuildersKt.withContext(reentrantMutexContextElement2, s10_1, t10);
                            if(a5 != a6) {
                                return a5;
                            }
                        }
                        else {
                            try {
                                v20 = System.currentTimeMillis();
                                LogU.debug$default(mutexLockUtil2.getLog(), "ReentrantLock[" + mutex10.hashCode() + "]  Lock obtain : " + s11, null, false, 6, null);
                                devLog9.put("ReentrantLock[" + mutex10.hashCode() + "]  Lock obtain : " + s11);
                            }
                            catch(Throwable throwable4) {
                                mutex11 = mutex10;
                                s12 = "";
                                s13 = s11;
                                goto label_528;
                            }
                            try {
                                s26.r();
                                u1 u10 = new u1(s26, l13, listKeepOption0, null);
                                t10.r = mutex10;
                                t10.w = s11;
                                t10.B = s26;
                                t10.D = l13;
                                t10.E = devLog9;
                                t10.G = "";
                                t10.I = 0;
                                t10.M = 0;
                                t10.N = 0;
                                t10.T = v20;
                                t10.S = 0;
                                t10.X = 1;
                                object1 = BuildersKt.withContext(Dispatchers.getIO(), u10, t10);
                            }
                            catch(Exception exception1) {
                                s27 = s26;
                                mutex11 = mutex10;
                                devLog10 = devLog9;
                                v21 = v20;
                                s12 = "";
                                s13 = s11;
                                a5 = S2.f(s27, this, exception1);
                                break;
                            }
                            catch(Throwable throwable4) {
                                mutex11 = mutex10;
                                s12 = s10;
                                s13 = s11;
                                goto label_528;
                            }
                            if(object1 != a6) {
                                s28 = s26;
                                v21 = v20;
                                a7 = object1;
                                mutex12 = mutex10;
                                v22 = 0;
                                v23 = 0;
                                v24 = 0;
                                v25 = 0;
                                goto label_468;
                            }
                        }
                        return a6;
                    }
                    case 1: {
                        int v26 = t10.S;
                        long v27 = t10.T;
                        int v28 = t10.N;
                        int v29 = t10.M;
                        int v30 = t10.I;
                        s10 = t10.G;
                        DevLog devLog11 = (DevLog)t10.E;
                        l1 l14 = (l1)t10.D;
                        S2 s29 = t10.B;
                        String s14 = t10.w;
                        Mutex mutex13 = t10.r;
                        try {
                            n.D(a5);
                            l13 = l14;
                            v22 = v30;
                            s11 = s14;
                            s28 = s29;
                            v25 = v29;
                            mutex12 = mutex13;
                            v24 = v28;
                            v21 = v27;
                            v23 = v26;
                            a7 = a5;
                            devLog9 = devLog11;
                        }
                        catch(Exception exception1) {
                            mutex11 = mutex13;
                            v21 = v27;
                            s12 = s10;
                            devLog10 = devLog11;
                            s27 = s29;
                            s13 = s14;
                            a5 = S2.f(s27, this, exception1);
                            break;
                        }
                        catch(Throwable throwable4) {
                            mutex11 = mutex13;
                            devLog9 = devLog11;
                            s13 = s14;
                            v20 = v27;
                            s12 = s10;
                            goto label_528;
                        }
                        try {
                        label_468:
                            devLog12 = devLog9;
                            playlistsSmartEditRes1 = (PlaylistsSmartEditRes)a7;
                            t10.r = mutex12;
                            t10.w = s11;
                            t10.B = s28;
                            t10.D = devLog9;
                            t10.E = s10;
                            devLog12 = devLog9;
                            goto label_483;
                        }
                        catch(Exception exception1) {
                            goto label_493;
                        }
                        catch(Throwable throwable4) {
                        }
                        v20 = v21;
                        mutex11 = mutex12;
                        s12 = s10;
                        s13 = s11;
                        goto label_528;
                        try {
                        label_483:
                            t10.G = null;
                            t10.I = v22;
                            t10.M = v25;
                            t10.N = v24;
                            t10.T = v21;
                            t10.S = v23;
                            t10.X = 2;
                            a5 = S2.e(s28, this, l13, playlistsSmartEditRes1, t10);
                        }
                        catch(Exception exception1) {
                        label_493:
                            mutex11 = mutex12;
                            s27 = s28;
                            s12 = s10;
                            s13 = s11;
                            devLog10 = devLog12;
                            a5 = S2.f(s27, this, exception1);
                            break;
                        }
                        catch(Throwable throwable4) {
                            v20 = v21;
                            mutex11 = mutex12;
                            s12 = s10;
                            s13 = s11;
                            devLog9 = devLog12;
                            goto label_528;
                        }
                        if(a5 != a6) {
                            mutex11 = mutex12;
                            s12 = s10;
                            s13 = s11;
                            devLog10 = devLog12;
                            break;
                        }
                        return a6;
                    }
                    case 2: {
                        v21 = t10.T;
                        Mutex mutex14 = (Mutex)t10.G;
                        s12 = t10.E;
                        devLog10 = (DevLog)t10.D;
                        s27 = t10.B;
                        s13 = t10.w;
                        mutex11 = t10.r;
                        try {
                            n.D(a5);
                            break;
                        }
                        catch(Exception exception1) {
                            try {
                                a5 = S2.f(s27, this, exception1);
                                break;
                            }
                            catch(Throwable throwable4) {
                            }
                            goto label_526;
                        }
                        catch(Throwable throwable4) {
                        label_526:
                            devLog9 = devLog10;
                            v20 = v21;
                        }
                    label_528:
                        long v31 = System.currentTimeMillis() - v20;
                        StringBuilder stringBuilder8 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex11.hashCode(), s12);
                        b.t(v31, s13, " (", stringBuilder8);
                        stringBuilder8.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder8.toString(), null, false, 6, null);
                        StringBuilder stringBuilder9 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex11.hashCode(), s12);
                        b.t(v31, s13, " (", stringBuilder9);
                        com.iloen.melon.custom.l1.C(stringBuilder9, "ms)", devLog9);
                        throw throwable4;
                    }
                    case 3: {
                        ReentrantMutexContextKey reentrantMutexContextKey4 = (ReentrantMutexContextKey)t10.G;
                        Mutex mutex9 = (Mutex)t10.E;
                        DevLog devLog8 = (DevLog)t10.B;
                        n.D(a5);
                        return a5;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                long v32 = System.currentTimeMillis() - v21;
                StringBuilder stringBuilder10 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex11.hashCode(), s12);
                b.t(v32, s13, " (", stringBuilder10);
                stringBuilder10.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder10.toString(), null, false, 6, null);
                StringBuilder stringBuilder11 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex11.hashCode(), s12);
                b.t(v32, s13, " (", stringBuilder11);
                com.iloen.melon.custom.l1.C(stringBuilder11, "ms)", devLog10);
                return a5;
            }
            default: {
                if(continuation0 instanceof O2) {
                    o20 = (O2)continuation0;
                    int v = o20.S;
                    if((v & 0x80000000) == 0) {
                        o20 = new O2(this, continuation0);
                    }
                    else {
                        o20.S = v ^ 0x80000000;
                    }
                }
                else {
                    o20 = new O2(this, continuation0);
                }
                a a0 = o20.M;
                ne.a a1 = ne.a.a;
                switch(o20.S) {
                    case 0: {
                        n.D(a0);
                        S2 s20 = this.c;
                        mutex1 = s20.e;
                        Playable playable0 = (Playable)this.e;
                        s = "";
                        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                        s1 = this.b;
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), b.f(mutex1.hashCode(), "ReentrantLock[", "]  try : ", s1), null, false, 6, null);
                        devLog1 = DevLog.Companion.get("MutexLockUtil");
                        devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  try : " + s1);
                        ReentrantMutexContextKey reentrantMutexContextKey1 = new ReentrantMutexContextKey(mutex1);
                        g g0 = o20.getContext().get(reentrantMutexContextKey1);
                        l1 l10 = this.d;
                        if(g0 != null) {
                            try {
                                v1 = System.currentTimeMillis();
                                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : " + s1, null, false, 6, null);
                                devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : " + s1);
                            }
                            catch(Throwable throwable0) {
                                goto label_110;
                            }
                            try {
                                s20.r();
                                P2 p20 = new P2(s20, l10, playable0, null);
                                o20.r = mutex1;
                                o20.w = s1;
                                o20.B = s20;
                                o20.D = s1;
                                o20.E = devLog1;
                                o20.G = "";
                                o20.I = v1;
                                o20.S = 1;
                                a0 = BuildersKt.withContext(Dispatchers.getIO(), p20, o20);
                            }
                            catch(Throwable throwable1) {
                                s21 = s20;
                                v2 = v1;
                                mutex2 = mutex1;
                                s2 = "";
                                s3 = s1;
                                s4 = s3;
                                devLog2 = devLog1;
                                break;
                            }
                            if(a0 == a1) {
                                return a1;
                            }
                            s21 = s20;
                            v2 = v1;
                            mutex2 = mutex1;
                            s2 = "";
                            s3 = s1;
                            s4 = s3;
                            devLog2 = devLog1;
                            httpResponse0 = (HttpResponse)a0;
                            goto label_99;
                        }
                        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                        N2 n20 = new N2(mutex1, null, mutex1, s1, devLog1, this, s20, l10, playable0, s1);
                        o20.r = null;
                        o20.w = null;
                        o20.B = null;
                        o20.D = null;
                        o20.E = null;
                        o20.G = null;
                        o20.S = 2;
                        a0 = BuildersKt.withContext(reentrantMutexContextElement0, n20, o20);
                        return a0 == a1 ? a1 : a0;
                    }
                    case 1: {
                        try {
                            v2 = o20.I;
                            s2 = o20.G;
                            devLog2 = o20.E;
                            s3 = o20.D;
                            s21 = o20.B;
                            s4 = o20.w;
                            mutex2 = o20.r;
                            n.D(a0);
                            httpResponse0 = (HttpResponse)a0;
                            goto label_99;
                        }
                        catch(Throwable throwable1) {
                            break;
                        }
                    }
                    case 2: {
                        ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)o20.G;
                        Mutex mutex0 = (Mutex)o20.E;
                        DevLog devLog0 = (DevLog)o20.B;
                        n.D(a0);
                        return a0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                try {
                    httpResponse0 = n.t(throwable1);
                }
                catch(Throwable throwable0) {
                    v1 = v2;
                    devLog1 = devLog2;
                    mutex1 = mutex2;
                    s1 = s4;
                    s = s2;
                    goto label_110;
                }
                try {
                label_99:
                    v1 = v2;
                    devLog1 = devLog2;
                    mutex1 = mutex2;
                    s1 = s4;
                    s = s2;
                    Throwable throwable2 = p.a(httpResponse0);
                    if(throwable2 != null) {
                        LogU.debug$default(s21.a, s3 + " failed: " + throwable2.getMessage(), null, false, 6, null);
                    }
                    a0 = SpApiQueueBaseTaskKt.endAction(new Q2(0, s21, this));
                    goto label_119;
                }
                catch(Throwable throwable0) {
                }
            label_110:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder0 = e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s, " Lock return : ");
                b.t(v3, s1, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s, " Lock return : ");
                b.t(v3, s1, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog1);
                throw throwable0;
            label_119:
                long v4 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder2 = e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s, " Lock return : ");
                b.t(v4, s1, " (", stringBuilder2);
                stringBuilder2.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                StringBuilder stringBuilder3 = e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s, " Lock return : ");
                b.t(v4, s1, " (", stringBuilder3);
                com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog1);
                return a0;
            }
        }
    }
}

