package sc;

import androidx.appcompat.app.o;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.playback.SpApiQueueBaseTask;
import com.iloen.melon.playback.SpApiQueueBaseTaskKt;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import k8.b;
import kd.j;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import ne.a;

public final class v2 extends SpApiQueueBaseTask {
    public final S2 a;
    public final l1 b;
    public final h1 c;

    public v2(S2 s20, l1 l10, h1 h10) {
        this.a = s20;
        this.b = l10;
        this.c = h10;
        super(1, "SyncByAppDataFromUserSelectPopup");
    }

    @Override  // com.iloen.melon.playback.SpApiQueueBaseTask
    public final Object execute(Continuation continuation0) {
        String s29_1;
        String s28_1;
        L0 l06;
        Mutex mutex11;
        String s27_1;
        String s26_1;
        DevLog devLog8;
        String s23_1;
        String s22_1;
        L0 l05;
        S2 s210;
        l1 l15;
        int v43;
        String s21_1;
        int v42;
        int v41;
        int v40;
        int v39;
        PlaylistsSmartEditRes playlistsSmartEditRes5;
        int v38;
        a a7;
        PlaylistsSmartEditRes playlistsSmartEditRes4;
        Mutex mutex10;
        String s20_1;
        S2 s29;
        Object object12;
        DevLog devLog7;
        String s18;
        L0 l04;
        long v32;
        long v30;
        String s15;
        S2 s28;
        Object object10;
        Object object9;
        we.a a6;
        Mutex mutex7;
        int v24;
        int v23;
        String s11;
        String s10;
        int v22;
        DevLog devLog6;
        Mutex mutex6;
        int v21;
        l1 l12;
        a a5;
        long v20;
        PlaylistsSmartEditRes playlistsSmartEditRes0;
        Mutex mutex5;
        String s9;
        S2 s27;
        Object object7;
        DevLog devLog5;
        long v15;
        String s7;
        String s6;
        int v13;
        DevLog devLog4;
        S2 s25;
        int v12;
        int v11;
        int v10;
        int v9;
        int v8;
        a a4;
        H h2;
        String s5;
        Object object4;
        DevLog devLog3;
        Mutex mutex4;
        String s4;
        S2 s24;
        L0 l00;
        Object object3;
        Mutex mutex3;
        String s3;
        a a3;
        t2 t21;
        int v7;
        int v6;
        int v5;
        int v4;
        int v3;
        int v2;
        a a2;
        Object object2;
        String s2;
        H h1;
        S2 s23;
        Object object1;
        S2 s22;
        S2 s21;
        k8.a a1;
        DevLog devLog2;
        Mutex mutex2;
        long v1;
        l1 l10;
        String s1;
        t2 t20;
        String s = "SyncByAppDataFromUserSelectPopup";
        if(continuation0 instanceof t2) {
            t20 = (t2)continuation0;
            int v = t20.g0;
            if((v & 0x80000000) == 0) {
                t20 = new t2(this, continuation0);
            }
            else {
                t20.g0 = v ^ 0x80000000;
            }
        }
        else {
            t20 = new t2(this, continuation0);
        }
        Object object0 = t20.e0;
        a a0 = a.a;
        H h0 = H.a;
        switch(t20.g0) {
            case 0: {
                n.D(object0);
                S2 s20 = this.a;
                Mutex mutex1 = s20.e;
                s1 = "";
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex1.hashCode(), "ReentrantLock[", "]  try : SyncByAppDataFromUserSelectPopup"), null, false, 6, null);
                DevLog devLog1 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey1 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex1.hashCode(), "]  try : SyncByAppDataFromUserSelectPopup", devLog1, mutex1);
                g g0 = t20.getContext().get(reentrantMutexContextKey1);
                l10 = this.b;
                h1 h10 = this.c;
                if(g0 != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : SyncByAppDataFromUserSelectPopup", null, false, 6, null);
                        devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : SyncByAppDataFromUserSelectPopup");
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex1;
                        devLog2 = devLog1;
                        goto label_777;
                    }
                    try {
                        s20.r();
                        a1 = s20.h;
                        goto label_47;
                    }
                    catch(Exception exception0) {
                        s21 = s20;
                        mutex2 = mutex1;
                        s23 = s21;
                        devLog2 = devLog1;
                        s3 = "SyncByAppDataFromUserSelectPopup";
                        v20 = v1;
                        a6 = S2.f(s23, this, exception0);
                        v30 = v20;
                        goto label_789;
                    label_47:
                        if(a1 == null) {
                            try {
                                t20.r = mutex1;
                                t20.w = "SyncByAppDataFromUserSelectPopup";
                                t20.B = s20;
                                t20.D = "SyncByAppDataFromUserSelectPopup";
                                t20.E = l10;
                                t20.G = devLog1;
                                t20.I = "";
                                t20.M = null;
                                t20.N = null;
                                t20.S = null;
                                t20.T = null;
                                t20.W = 0;
                                t20.X = 0;
                                t20.Y = 0;
                                t20.d0 = v1;
                                t20.Z = 0;
                                t20.b0 = 0;
                                t20.c0 = 0;
                                t20.g0 = 1;
                                try {
                                    s22 = s20;
                                    object1 = TimeoutKt.withTimeout(3000L, new o2(s20, l10, h10, true, null), t20);
                                }
                                catch(Exception exception0) {
                                    s23 = s22;
                                    devLog2 = devLog1;
                                    mutex2 = mutex1;
                                    goto label_122;
                                }
                            }
                            catch(Throwable throwable0) {
                                devLog2 = devLog1;
                                mutex2 = mutex1;
                                goto label_777;
                            }
                            if(object1 == a0) {
                                return a0;
                            }
                            h1 = h0;
                            s2 = "SyncByAppDataFromUserSelectPopup";
                            object2 = object1;
                            devLog2 = devLog1;
                            a2 = a0;
                            v2 = 0;
                            v3 = 0;
                            v4 = 0;
                            v5 = 0;
                            v6 = 0;
                            mutex2 = mutex1;
                            v7 = 0;
                            goto label_207;
                        }
                        else {
                            try {
                                s21 = s20;
                                t21 = t20;
                                a3 = a0;
                                ((b)a1).a("SyncByAppDataFromUserSelectPopup true", true);
                                t21.r = mutex1;
                                t21.w = "SyncByAppDataFromUserSelectPopup";
                                t21.B = s21;
                                t21.D = "SyncByAppDataFromUserSelectPopup";
                                t21.E = l10;
                                t21.G = devLog1;
                                t21.I = "";
                                t21.M = null;
                                t21.N = null;
                                t21.S = a1;
                                t21.T = "SyncByAppDataFromUserSelectPopup";
                                t21.W = 0;
                                t21.X = 0;
                                t21.Y = 0;
                                t21.d0 = v1;
                                t21.Z = 0;
                                t21.b0 = 0;
                                t21.c0 = 0;
                                t21.g0 = 5;
                                goto label_128;
                            }
                            catch(Exception exception0) {
                            }
                            catch(Throwable throwable0) {
                                mutex2 = mutex1;
                                devLog2 = devLog1;
                                goto label_777;
                            }
                            mutex2 = mutex1;
                            s23 = s21;
                            devLog2 = devLog1;
                        label_122:
                            s3 = "SyncByAppDataFromUserSelectPopup";
                            v20 = v1;
                            a6 = S2.f(s23, this, exception0);
                            v30 = v20;
                            goto label_789;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex1;
                        devLog2 = devLog1;
                        goto label_777;
                    }
                    try {
                    label_128:
                        mutex3 = mutex1;
                        object3 = TimeoutKt.withTimeout(3000L, new o2(s21, l10, h10, true, null), t21);
                    }
                    catch(Throwable throwable1) {
                        l00 = a1;
                        s24 = s21;
                        s4 = "";
                        mutex4 = mutex3;
                        s3 = "SyncByAppDataFromUserSelectPopup";
                        devLog3 = devLog1;
                        goto label_739;
                    }
                    if(object3 == a3) {
                        return a3;
                    }
                    object4 = object3;
                    s5 = "SyncByAppDataFromUserSelectPopup";
                    l00 = a1;
                    h2 = h0;
                    s4 = "";
                    a4 = a3;
                    v8 = 0;
                    v9 = 0;
                    v10 = 0;
                    v11 = 0;
                    v12 = 0;
                    s25 = s21;
                    devLog4 = devLog1;
                    v13 = 0;
                    s6 = "SyncByAppDataFromUserSelectPopup";
                    s7 = "SyncByAppDataFromUserSelectPopup";
                    goto label_489;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                s2 s26 = new s2(mutex1, null, mutex1, devLog1, s20, this, l10, h10);
                t20.r = null;
                t20.w = null;
                t20.B = null;
                t20.D = null;
                t20.E = null;
                t20.G = null;
                t20.W = 0;
                t20.X = 0;
                t20.g0 = 9;
                Object object5 = BuildersKt.withContext(reentrantMutexContextElement0, s26, t20);
                return object5 == a0 ? a0 : object5;
            }
            case 1: {
                int v14 = t20.b0;
                v3 = t20.Z;
                v15 = t20.d0;
                int v16 = t20.Y;
                int v17 = t20.X;
                int v18 = t20.c0;
                int v19 = t20.W;
                L0 l01 = (L0)t20.S;
                Continuation continuation1 = (Continuation)t20.N;
                Continuation continuation2 = (Continuation)t20.M;
                Object object6 = t20.I;
                devLog5 = (DevLog)t20.G;
                l1 l11 = (l1)t20.E;
                String s8 = (String)t20.D;
                object7 = object6;
                s27 = t20.B;
                s9 = t20.w;
                mutex5 = t20.r;
                try {
                    n.D(object0);
                    v5 = v14;
                    object2 = object0;
                    v4 = v19;
                    h1 = h0;
                    s22 = s27;
                    a2 = a0;
                    mutex2 = mutex5;
                    s = s8;
                    v2 = v16;
                    v7 = v17;
                    s1 = object7;
                    v6 = v18;
                    l10 = l11;
                    v1 = v15;
                    devLog2 = devLog5;
                    s2 = s9;
                }
                catch(Exception exception0) {
                    goto label_288;
                }
                catch(Throwable throwable0) {
                    goto label_296;
                }
                try {
                label_207:
                    playlistsSmartEditRes0 = (PlaylistsSmartEditRes)object2;
                    t20.r = mutex2;
                    t20.w = s2;
                    t20.B = s22;
                    t20.D = s;
                    t20.E = l10;
                    t20.G = devLog2;
                    t20.I = s1;
                    t20.M = null;
                    t20.N = null;
                    t20.S = null;
                    t20.T = null;
                    t20.V = playlistsSmartEditRes0;
                    t20.W = v4;
                    t20.X = v7;
                    t20.Y = v2;
                    t20.d0 = v1;
                    t20.Z = v3;
                    t20.b0 = v5;
                    t20.c0 = v6;
                    t20.g0 = 2;
                    S2.g(s22, l10, playlistsSmartEditRes0);
                }
                catch(Exception exception0) {
                    s23 = s22;
                    v20 = v1;
                    s3 = s2;
                    a6 = S2.f(s23, this, exception0);
                    v30 = v20;
                    goto label_789;
                }
                catch(Throwable throwable0) {
                    s = s2;
                    goto label_777;
                }
                if(h1 == a2) {
                    return a2;
                }
                a5 = a2;
                l12 = l10;
                v21 = v4;
                mutex6 = mutex2;
                devLog6 = devLog2;
                v22 = v6;
                s23 = s22;
                s10 = s1;
                s11 = s;
                v23 = v7;
                v24 = v2;
                goto label_302;
            }
            case 2: {
                int v25 = t20.b0;
                v3 = t20.Z;
                v15 = t20.d0;
                int v26 = t20.Y;
                int v27 = t20.X;
                int v28 = t20.W;
                int v29 = t20.c0;
                PlaylistsSmartEditRes playlistsSmartEditRes1 = t20.V;
                L0 l02 = (L0)t20.S;
                Continuation continuation3 = (Continuation)t20.N;
                Continuation continuation4 = (Continuation)t20.M;
                Object object8 = t20.I;
                devLog5 = (DevLog)t20.G;
                l1 l13 = (l1)t20.E;
                String s12 = (String)t20.D;
                object7 = object8;
                s27 = t20.B;
                s9 = t20.w;
                mutex5 = t20.r;
                try {
                    n.D(object0);
                    v5 = v25;
                    l12 = l13;
                    playlistsSmartEditRes0 = playlistsSmartEditRes1;
                    mutex6 = mutex5;
                    v22 = v29;
                    s11 = s12;
                    v21 = v28;
                    v23 = v27;
                    v24 = v26;
                    s10 = object7;
                    s2 = s9;
                    s23 = s27;
                    a5 = a0;
                    devLog6 = devLog5;
                    v1 = v15;
                }
                catch(Exception exception0) {
                label_288:
                    mutex2 = mutex5;
                    v20 = v15;
                    devLog2 = devLog5;
                    s1 = object7;
                    s23 = s27;
                    s3 = s9;
                    a6 = S2.f(s23, this, exception0);
                    v30 = v20;
                    goto label_789;
                }
                catch(Throwable throwable0) {
                label_296:
                    mutex2 = mutex5;
                    s1 = object7;
                    s = s9;
                    v1 = v15;
                    devLog2 = devLog5;
                    goto label_777;
                }
            label_302:
                if(playlistsSmartEditRes0.success) {
                    try {
                        t20.r = mutex6;
                        t20.w = s2;
                        t20.B = s23;
                        t20.D = s11;
                        t20.E = devLog6;
                        t20.G = s10;
                        t20.I = null;
                        t20.M = null;
                        t20.N = null;
                        t20.S = null;
                        t20.T = null;
                        t20.V = null;
                        t20.W = v21;
                        t20.X = v23;
                        t20.Y = v24;
                        t20.d0 = v1;
                        t20.Z = v3;
                        t20.b0 = v5;
                        t20.c0 = v22;
                        t20.g0 = 3;
                        mutex4 = mutex6;
                        if(S2.l(s23, l12, playlistsSmartEditRes0.result.updatedDate, playlistsSmartEditRes0.result.replaceThreshold, t20) == a5) {
                            return a5;
                        }
                        goto label_338;
                    }
                    catch(Exception exception0) {
                        s1 = s10;
                        devLog2 = devLog6;
                        mutex2 = mutex4;
                        s3 = s2;
                        v20 = v1;
                        a6 = S2.f(s23, this, exception0);
                        v30 = v20;
                        goto label_789;
                    }
                    catch(Throwable throwable0) {
                        s = s2;
                        s1 = s10;
                        devLog2 = devLog6;
                        mutex2 = mutex4;
                        goto label_777;
                    }
                    return a5;
                    try {
                    label_338:
                        mutex7 = mutex4;
                        devLog2 = devLog6;
                        v20 = v1;
                        a6 = SpApiQueueBaseTaskKt.endAction(new j(s23, this, s11, 6));
                    }
                    catch(Exception exception0) {
                        mutex2 = mutex7;
                        goto label_437;
                    }
                    catch(Throwable throwable0) {
                        goto label_441;
                    }
                }
                else {
                    try {
                        t20.r = mutex6;
                        t20.w = s2;
                        t20.B = s23;
                        t20.D = devLog6;
                        t20.E = s10;
                        t20.G = null;
                        t20.I = null;
                        t20.M = null;
                        t20.N = null;
                        t20.S = null;
                        t20.T = null;
                        t20.V = null;
                        t20.W = v21;
                        t20.X = v23;
                        t20.Y = v24;
                        t20.d0 = v1;
                        t20.Z = v3;
                        t20.b0 = v5;
                        t20.c0 = v22;
                        t20.g0 = 4;
                        object9 = S2.e(s23, this, l12, playlistsSmartEditRes0, t20);
                        a3 = a5;
                    }
                    catch(Exception exception0) {
                        s1 = s10;
                        devLog2 = devLog6;
                        v20 = v1;
                        mutex2 = mutex6;
                        s3 = s2;
                        a6 = S2.f(s23, this, exception0);
                        v30 = v20;
                        goto label_789;
                    }
                    catch(Throwable throwable0) {
                        s = s2;
                        s1 = s10;
                        devLog2 = devLog6;
                        mutex2 = mutex6;
                        goto label_777;
                    }
                    if(object9 != a3) {
                        devLog2 = devLog6;
                        v20 = v1;
                        mutex7 = mutex6;
                        a6 = (we.a)object9;
                        v30 = v20;
                        break;
                    }
                    return a3;
                }
                v30 = v20;
                break;
            }
            case 3: {
                v20 = t20.d0;
                PlaylistsSmartEditRes playlistsSmartEditRes2 = (PlaylistsSmartEditRes)t20.T;
                String s13 = (String)t20.S;
                L0 l03 = (L0)t20.N;
                Continuation continuation5 = (Continuation)t20.M;
                Mutex mutex8 = (Mutex)t20.I;
                object10 = t20.G;
                devLog2 = (DevLog)t20.E;
                String s14 = (String)t20.D;
                s28 = t20.B;
                s15 = t20.w;
                mutex7 = t20.r;
                try {
                    n.D(object0);
                    s23 = s28;
                    s10 = object10;
                    s2 = s15;
                }
                catch(Exception exception0) {
                    goto label_422;
                }
                catch(Throwable throwable0) {
                    goto label_428;
                }
                try {
                    a6 = SpApiQueueBaseTaskKt.endAction(new j(s23, this, s14, 6));
                    v30 = v20;
                    break;
                }
                catch(Exception exception0) {
                }
                catch(Throwable throwable0) {
                    goto label_441;
                }
                mutex2 = mutex7;
                goto label_437;
            }
            case 4: {
                v20 = t20.d0;
                PlaylistsSmartEditRes playlistsSmartEditRes3 = (PlaylistsSmartEditRes)t20.S;
                String s16 = (String)t20.N;
                ReentrantMutexContextKey reentrantMutexContextKey2 = (ReentrantMutexContextKey)t20.I;
                Mutex mutex9 = (Mutex)t20.G;
                object10 = t20.E;
                devLog2 = (DevLog)t20.D;
                s28 = t20.B;
                s15 = t20.w;
                mutex7 = t20.r;
                try {
                    n.D(object0);
                    object9 = object0;
                    s23 = s28;
                    s10 = object10;
                    s2 = s15;
                }
                catch(Exception exception0) {
                label_422:
                    mutex2 = mutex7;
                    s1 = object10;
                    s23 = s28;
                    s3 = s15;
                    a6 = S2.f(s23, this, exception0);
                    v30 = v20;
                    goto label_789;
                }
                catch(Throwable throwable0) {
                label_428:
                    mutex2 = mutex7;
                    s1 = object10;
                    s = s15;
                    v1 = v20;
                    goto label_777;
                }
                try {
                    a6 = (we.a)object9;
                }
                catch(Exception exception0) {
                    mutex2 = mutex7;
                label_437:
                    s1 = s10;
                    s3 = s2;
                    a6 = S2.f(s23, this, exception0);
                    v30 = v20;
                    goto label_789;
                }
                catch(Throwable throwable0) {
                label_441:
                    v1 = v20;
                    s = s2;
                    mutex2 = mutex7;
                    s1 = s10;
                    goto label_777;
                }
                v30 = v20;
                break;
            }
            case 5: {
                object4 = object0;
                int v31 = t20.Z;
                v32 = t20.d0;
                int v33 = t20.Y;
                int v34 = t20.c0;
                int v35 = t20.X;
                int v36 = t20.b0;
                String s17 = t20.T;
                int v37 = t20.W;
                l04 = (L0)t20.S;
                Continuation continuation6 = (Continuation)t20.N;
                Continuation continuation7 = (Continuation)t20.M;
                s18 = s17;
                Object object11 = t20.I;
                devLog7 = (DevLog)t20.G;
                l1 l14 = (l1)t20.E;
                String s19 = (String)t20.D;
                object12 = object11;
                s29 = t20.B;
                s20_1 = t20.w;
                mutex10 = t20.r;
                try {
                    n.D(object4);
                    l00 = l04;
                    s5 = s18;
                    l10 = l14;
                    s7 = s20_1;
                    v12 = v31;
                    a4 = a0;
                    v8 = v35;
                    mutex3 = mutex10;
                    v9 = v33;
                    h2 = h0;
                    t21 = t20;
                    v13 = v37;
                    s25 = s29;
                    s6 = s19;
                    v10 = v34;
                    v1 = v32;
                    devLog4 = devLog7;
                    s4 = object12;
                    v11 = v36;
                }
                catch(Throwable throwable1) {
                    goto label_581;
                }
                try {
                label_489:
                    playlistsSmartEditRes4 = (PlaylistsSmartEditRes)object4;
                    t21.r = mutex3;
                    t21.w = s7;
                    t21.B = s25;
                    t21.D = s6;
                    t21.E = l10;
                    t21.G = devLog4;
                    t21.I = s4;
                    t21.M = null;
                    t21.N = null;
                    t21.S = l00;
                    t21.T = s5;
                    t21.V = playlistsSmartEditRes4;
                    t21.W = v13;
                    t21.X = v8;
                    t21.Y = v9;
                    t21.d0 = v1;
                    t21.Z = v12;
                    t21.b0 = v11;
                    t21.c0 = v10;
                    t21.g0 = 6;
                    S2.g(s25, l10, playlistsSmartEditRes4);
                }
                catch(Throwable throwable1) {
                    s3 = s7;
                    s = s5;
                    s24 = s25;
                    mutex4 = mutex3;
                    devLog3 = devLog4;
                    goto label_739;
                }
                if(h2 == a4) {
                    return a4;
                }
                a7 = a4;
                v38 = v9;
                playlistsSmartEditRes5 = playlistsSmartEditRes4;
                v39 = v10;
                v40 = v11;
                v41 = v8;
                v42 = v12;
                s3 = s7;
                s21_1 = s6;
                v43 = v13;
                l15 = l10;
                s210 = s25;
                l05 = l00;
                s22_1 = s5;
                s23_1 = s4;
                devLog8 = devLog4;
                goto label_590;
            }
            case 6: {
                int v44 = t20.b0;
                int v45 = t20.Z;
                v32 = t20.d0;
                int v46 = t20.Y;
                int v47 = t20.X;
                int v48 = t20.W;
                int v49 = t20.c0;
                String s24_1 = t20.T;
                PlaylistsSmartEditRes playlistsSmartEditRes6 = t20.V;
                l04 = (L0)t20.S;
                Continuation continuation8 = (Continuation)t20.N;
                Continuation continuation9 = (Continuation)t20.M;
                s18 = s24_1;
                Object object13 = t20.I;
                devLog7 = (DevLog)t20.G;
                l1 l16 = (l1)t20.E;
                String s25_1 = (String)t20.D;
                object12 = object13;
                s29 = t20.B;
                s20_1 = t20.w;
                mutex10 = t20.r;
                try {
                    n.D(object0);
                    s22_1 = s18;
                    l15 = l16;
                    s23_1 = object12;
                    s210 = s29;
                    s21_1 = s25_1;
                    a7 = a0;
                    playlistsSmartEditRes5 = playlistsSmartEditRes6;
                    mutex3 = mutex10;
                    v40 = v44;
                    v38 = v46;
                    v43 = v48;
                    v39 = v49;
                    s3 = s20_1;
                    v42 = v45;
                    t21 = t20;
                    l05 = l04;
                    v41 = v47;
                    v1 = v32;
                    devLog8 = devLog7;
                }
                catch(Throwable throwable1) {
                label_581:
                    mutex4 = mutex10;
                    l00 = l04;
                    s = s18;
                    devLog3 = devLog7;
                    s24 = s29;
                    s3 = s20_1;
                    v1 = v32;
                    s4 = object12;
                    goto label_739;
                }
            label_590:
                if(playlistsSmartEditRes5.success) {
                    try {
                        t21.r = mutex3;
                        t21.w = s3;
                        t21.B = s210;
                        t21.D = s21_1;
                        t21.E = devLog8;
                        t21.G = s23_1;
                        t21.I = null;
                        t21.M = null;
                        t21.N = l05;
                        t21.S = s22_1;
                        t21.T = null;
                        t21.V = null;
                        t21.W = v43;
                        t21.X = v41;
                        t21.Y = v38;
                        t21.d0 = v1;
                        t21.Z = v42;
                        t21.b0 = v40;
                        t21.c0 = v39;
                        t21.g0 = 7;
                        s26_1 = s21_1;
                        if(S2.l(s210, l15, playlistsSmartEditRes5.result.updatedDate, playlistsSmartEditRes5.result.replaceThreshold, t21) == a7) {
                            return a7;
                        }
                    }
                    catch(Throwable throwable1) {
                        s24 = s210;
                        s4 = s23_1;
                        l00 = l05;
                        s = s22_1;
                        mutex4 = mutex3;
                        devLog3 = devLog8;
                        goto label_739;
                    }
                    v30 = v1;
                    s27_1 = s3;
                    s = s22_1;
                    s24 = s210;
                    mutex11 = mutex3;
                    devLog3 = devLog8;
                    s4 = s23_1;
                    l06 = l05;
                    a6 = SpApiQueueBaseTaskKt.endAction(new j(s24, this, s26_1, 6));
                    s29_1 = s;
                    mutex7 = mutex11;
                }
                else {
                    try {
                        t21.r = mutex3;
                        t21.w = s3;
                        t21.B = s210;
                        t21.D = devLog8;
                        t21.E = s23_1;
                        s28_1 = s3;
                        t21.G = null;
                        t21.I = null;
                        t21.M = l05;
                        t21.N = s22_1;
                        t21.S = null;
                        t21.T = null;
                        t21.V = null;
                        t21.W = v43;
                        t21.X = v41;
                        t21.Y = v38;
                        t21.d0 = v1;
                        t21.Z = v42;
                        t21.b0 = v40;
                        t21.c0 = v39;
                        t21.g0 = 8;
                        object0 = S2.e(s210, this, l15, playlistsSmartEditRes5, t21);
                    }
                    catch(Throwable throwable1) {
                        s = s22_1;
                        l00 = l05;
                        mutex4 = mutex3;
                        devLog3 = devLog8;
                        s4 = s23_1;
                        s3 = s28_1;
                        s24 = s210;
                        goto label_739;
                    }
                    if(object0 != a7) {
                        s29_1 = s22_1;
                        v30 = v1;
                        l06 = l05;
                        mutex4 = mutex3;
                        devLog3 = devLog8;
                        s4 = s23_1;
                        s24 = s210;
                        a6 = (we.a)object0;
                        mutex7 = mutex4;
                        s27_1 = s28_1;
                        goto label_754;
                    }
                    return a7;
                }
                goto label_754;
            }
            case 7: {
                long v50 = t20.d0;
                PlaylistsSmartEditRes playlistsSmartEditRes7 = (PlaylistsSmartEditRes)t20.T;
                String s30 = (String)t20.S;
                l06 = (L0)t20.N;
                Continuation continuation10 = (Continuation)t20.M;
                Mutex mutex12 = (Mutex)t20.I;
                s4 = t20.G;
                devLog3 = (DevLog)t20.E;
                String s31 = (String)t20.D;
                v30 = v50;
                S2 s211 = t20.B;
                s27_1 = t20.w;
                mutex11 = t20.r;
                try {
                    s24 = s211;
                    s = s30;
                    n.D(object0);
                    s26_1 = s31;
                    s24 = s211;
                    s = s30;
                }
                catch(Throwable throwable1) {
                    v1 = v30;
                    l00 = l06;
                    s3 = s27_1;
                    mutex4 = mutex11;
                    goto label_739;
                }
                try {
                    a6 = SpApiQueueBaseTaskKt.endAction(new j(s24, this, s26_1, 6));
                    s29_1 = s;
                    mutex7 = mutex11;
                    goto label_754;
                }
                catch(Throwable throwable1) {
                    l00 = l06;
                    v1 = v30;
                }
                s3 = s27_1;
                mutex4 = mutex11;
                goto label_739;
            }
            case 8: {
                long v51 = t20.d0;
                PlaylistsSmartEditRes playlistsSmartEditRes8 = (PlaylistsSmartEditRes)t20.S;
                s29_1 = (String)t20.N;
                l06 = t20.M;
                ReentrantMutexContextKey reentrantMutexContextKey3 = (ReentrantMutexContextKey)t20.I;
                Mutex mutex13 = (Mutex)t20.G;
                s4 = t20.E;
                devLog3 = (DevLog)t20.D;
                s24 = t20.B;
                v30 = v51;
                String s32 = t20.w;
                mutex4 = t20.r;
                try {
                    n.D(object0);
                    s28_1 = s32;
                    a6 = (we.a)object0;
                    mutex7 = mutex4;
                    s27_1 = s28_1;
                    goto label_754;
                }
                catch(Throwable throwable1) {
                    s3 = s32;
                    s = s29_1;
                    l00 = l06;
                    v1 = v30;
                }
                goto label_739;
                try {
                    a6 = (we.a)object0;
                    mutex7 = mutex4;
                    s27_1 = s28_1;
                    goto label_754;
                }
                catch(Throwable throwable1) {
                    s = s29_1;
                    v1 = v30;
                    l00 = l06;
                    s3 = s28_1;
                }
                try {
                label_739:
                    l00.a(s + " false", false);
                    throw throwable1;
                }
                catch(Exception exception0) {
                    s23 = s24;
                    s1 = s4;
                    devLog2 = devLog3;
                    mutex2 = mutex4;
                    v20 = v1;
                    a6 = S2.f(s23, this, exception0);
                    v30 = v20;
                    goto label_789;
                }
                catch(Throwable throwable0) {
                    s = s3;
                    s1 = s4;
                    devLog2 = devLog3;
                }
                mutex2 = mutex4;
                goto label_777;
                try {
                label_754:
                    devLog2 = devLog3;
                    l06.a(s29_1 + " false", false);
                    s2 = s27_1;
                    s10 = s4;
                    break;
                }
                catch(Exception exception0) {
                    s3 = s27_1;
                    s23 = s24;
                    mutex2 = mutex7;
                    v20 = v30;
                    s1 = s4;
                    try {
                        a6 = S2.f(s23, this, exception0);
                        v30 = v20;
                        goto label_789;
                    }
                    catch(Throwable throwable0) {
                        v1 = v20;
                        s = s3;
                    }
                }
                catch(Throwable throwable0) {
                    s = s27_1;
                    mutex2 = mutex7;
                    v1 = v30;
                    s1 = s4;
                }
            label_777:
                long v52 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder0 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s1);
                H0.b.t(v52, s, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s1);
                H0.b.t(v52, s, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog2);
                throw throwable0;
            }
            case 9: {
                ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)t20.G;
                Mutex mutex0 = (Mutex)t20.E;
                DevLog devLog0 = (DevLog)t20.B;
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2 = mutex7;
        s1 = s10;
        s3 = s2;
    label_789:
        long v53 = System.currentTimeMillis() - v30;
        StringBuilder stringBuilder2 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s1);
        H0.b.t(v53, s3, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s1);
        H0.b.t(v53, s3, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog2);
        return a6;
    }
}

