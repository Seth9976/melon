package sc;

import com.iloen.melon.custom.L0;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.playback.SpApiQueueBaseTaskKt;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.b;
import kd.j;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import oe.i;
import we.a;
import we.n;

public final class s2 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final Mutex N;
    public final DevLog S;
    public final S2 T;
    public final v2 V;
    public final l1 W;
    public final h1 X;
    public L0 Y;
    public String Z;
    public PlaylistsSmartEditRes b0;
    public int c0;
    public int d0;
    public int e0;
    public Mutex r;
    public Object w;

    public s2(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, S2 s20, v2 v20, l1 l10, h1 h10) {
        this.M = mutex0;
        this.N = mutex1;
        this.S = devLog0;
        this.T = s20;
        this.V = v20;
        this.W = l10;
        this.X = h10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s2(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Mutex mutex9;
        Object object15;
        Mutex mutex8;
        long v43;
        Object object13;
        Object object12;
        Object object11;
        long v42;
        int v35;
        int v34;
        PlaylistsSmartEditRes playlistsSmartEditRes2;
        Mutex mutex7;
        Object object10;
        L0 l02;
        String s1;
        a a2;
        Object object9;
        long v28;
        PlaylistsSmartEditRes playlistsSmartEditRes1;
        int v21_1;
        PlaylistsSmartEditRes playlistsSmartEditRes0;
        Object object8;
        Mutex mutex6;
        Object object7;
        int v14;
        Mutex mutex5;
        int v13;
        int v12;
        int v11;
        int v10;
        v2 v22;
        Object object6;
        Mutex mutex4;
        Object object5;
        L0 l01;
        String s;
        Object object4;
        int v9;
        L0 l00;
        int v8;
        int v7;
        int v6;
        int v5;
        int v4;
        long v3;
        Object object3;
        Mutex mutex3;
        Object object2;
        v2 v21;
        h1 h10;
        k8.a a1;
        long v1;
        Object object1;
        int v;
        Mutex mutex2;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        DevLog devLog0 = this.S;
        v2 v20 = this.V;
        l1 l10 = this.W;
        Mutex mutex0 = this.N;
        S2 s20 = this.T;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex1 = this.M;
                this.r = mutex1;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                mutex2 = mutex1;
                v = 0;
                object1 = null;
                goto label_24;
            }
            case 1: {
                v = this.B;
                object1 = this.w;
                mutex2 = this.r;
                d5.n.D(object0);
                try {
                label_24:
                    v1 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex9.unlock(object15);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : SyncByAppDataFromUserSelectPopup", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : SyncByAppDataFromUserSelectPopup");
                    try {
                        s20.r();
                        a1 = s20.h;
                        h10 = this.X;
                        goto label_35;
                    }
                    catch(Exception exception0) {
                    }
                }
                catch(Throwable throwable1) {
                    object3 = object1;
                    mutex3 = mutex2;
                    v3 = v1;
                    goto label_488;
                }
                v21 = v20;
                long v2 = v1;
                object3 = object1;
                mutex3 = mutex2;
                v3 = v2;
                a2 = S2.f(s20, v21, exception0);
                v28 = v3;
                goto label_496;
            label_35:
                if(a1 == null) {
                    try {
                        this.r = mutex2;
                        this.w = object1;
                        this.Y = null;
                        this.Z = null;
                        this.B = v;
                        this.D = 0;
                        this.G = 0;
                        this.I = v1;
                        this.c0 = 0;
                        this.d0 = 0;
                        this.e0 = 0;
                        this.E = 2;
                        object2 = TimeoutKt.withTimeout(3000L, new o2(s20, l10, h10, true, null), this);
                    }
                    catch(Exception exception0) {
                        mutex3 = mutex2;
                        v21 = v20;
                        object3 = object1;
                        v3 = v1;
                        a2 = S2.f(s20, v21, exception0);
                        v28 = v3;
                        goto label_496;
                    }
                    catch(Throwable throwable1) {
                        mutex3 = mutex2;
                        object3 = object1;
                        v3 = v1;
                        goto label_488;
                    }
                    if(object2 == a0) {
                        return a0;
                    }
                    object0 = object2;
                    v4 = 0;
                    v5 = 0;
                    v6 = 0;
                    v7 = 0;
                    v8 = 0;
                    goto label_139;
                }
                else {
                    try {
                        ((b)a1).a("SyncByAppDataFromUserSelectPopup true", true);
                        this.r = mutex2;
                        this.w = object1;
                        this.Y = a1;
                        this.Z = "SyncByAppDataFromUserSelectPopup";
                        this.B = v;
                        this.D = 0;
                        this.G = 0;
                        this.I = v1;
                        this.c0 = 0;
                        this.d0 = 0;
                        this.e0 = 0;
                        this.E = 6;
                        l00 = a1;
                        v21 = v20;
                    }
                    catch(Exception exception0) {
                        v2 = v1;
                        v21 = v20;
                        object3 = object1;
                        mutex3 = mutex2;
                        v3 = v2;
                        a2 = S2.f(s20, v21, exception0);
                        v28 = v3;
                        goto label_496;
                    }
                    catch(Throwable throwable1) {
                        object3 = object1;
                        mutex3 = mutex2;
                        v3 = v1;
                        goto label_488;
                    }
                    try {
                        v9 = v;
                        object4 = TimeoutKt.withTimeout(3000L, new o2(s20, l10, h10, true, null), this);
                    }
                    catch(Throwable throwable2) {
                        s = "SyncByAppDataFromUserSelectPopup";
                        l01 = l00;
                        object5 = object1;
                        mutex4 = mutex2;
                        v3 = v1;
                        goto label_467;
                    }
                    if(object4 == a0) {
                        return a0;
                    }
                    object0 = object4;
                    s = "SyncByAppDataFromUserSelectPopup";
                    object6 = object1;
                    v22 = v21;
                    v10 = 0;
                    v11 = 0;
                    v12 = 0;
                    v13 = 0;
                    mutex5 = mutex2;
                    v3 = v1;
                    v14 = 0;
                    goto label_308;
                }
                goto label_496;
            }
            case 2: {
                try {
                    int v15 = this.c0;
                    v3 = this.I;
                    int v16 = this.e0;
                    int v17 = this.G;
                    int v18 = this.D;
                    int v19 = this.B;
                    int v20_1 = this.d0;
                    object7 = this.w;
                    mutex6 = this.r;
                    d5.n.D(object0);
                    v6 = v17;
                    v5 = v18;
                    v8 = v20_1;
                    v = v19;
                    v4 = v16;
                    mutex2 = mutex6;
                    object1 = object7;
                    v7 = v15;
                    v1 = v3;
                }
                catch(Exception exception0) {
                    goto label_199;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex6;
                    object3 = object7;
                    goto label_488;
                }
                try {
                label_139:
                    object8 = object1;
                    playlistsSmartEditRes0 = (PlaylistsSmartEditRes)object0;
                    this.r = mutex2;
                    this.w = object1;
                    object8 = object1;
                    goto label_148;
                }
                catch(Exception exception0) {
                    object8 = object1;
                    mutex3 = mutex2;
                    v21 = v20;
                    v3 = v1;
                    object3 = object8;
                    a2 = S2.f(s20, v21, exception0);
                    v28 = v3;
                    goto label_496;
                    try {
                    label_148:
                        this.Y = null;
                        this.Z = null;
                        this.b0 = playlistsSmartEditRes0;
                        this.B = v;
                        this.D = v5;
                        this.G = v6;
                        this.I = v1;
                        this.c0 = v7;
                        this.d0 = v8;
                        this.e0 = v4;
                        this.E = 3;
                        S2.y(l10, playlistsSmartEditRes0);
                        goto label_171;
                    }
                    catch(Exception exception0) {
                    }
                    catch(Throwable throwable1) {
                        mutex3 = mutex2;
                        v3 = v1;
                        object3 = object8;
                        goto label_488;
                    }
                    mutex3 = mutex2;
                    v21 = v20;
                    v3 = v1;
                    object3 = object8;
                    a2 = S2.f(s20, v21, exception0);
                    v28 = v3;
                    goto label_496;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex2;
                    v3 = v1;
                    object3 = object8;
                    goto label_488;
                }
            label_171:
                if(h0 == a0) {
                    return a0;
                }
                mutex3 = mutex2;
                v3 = v1;
                object3 = object8;
                v21_1 = v4;
                playlistsSmartEditRes1 = playlistsSmartEditRes0;
                goto label_207;
            }
            case 3: {
                try {
                    int v22_1 = this.c0;
                    v3 = this.I;
                    int v23 = this.G;
                    int v24 = this.e0;
                    int v25 = this.D;
                    int v26 = this.B;
                    playlistsSmartEditRes1 = this.b0;
                    int v27 = this.d0;
                    object7 = this.w;
                    mutex6 = this.r;
                    d5.n.D(object0);
                    v7 = v22_1;
                    object3 = object7;
                    v5 = v25;
                    v8 = v27;
                    v6 = v23;
                    mutex3 = mutex6;
                    v = v26;
                    v21_1 = v24;
                }
                catch(Exception exception0) {
                label_199:
                    mutex3 = mutex6;
                    v21 = v20;
                    object3 = object7;
                    a2 = S2.f(s20, v21, exception0);
                    v28 = v3;
                    goto label_496;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex6;
                    object3 = object7;
                    goto label_488;
                }
            label_207:
                if(playlistsSmartEditRes1.success) {
                    try {
                        this.r = mutex3;
                        this.w = object3;
                        try {
                            this.Y = null;
                            this.Z = null;
                            this.b0 = null;
                            this.B = v;
                            this.D = v5;
                            this.G = v6;
                            this.I = v3;
                            this.c0 = v7;
                            this.d0 = v8;
                            this.e0 = v21_1;
                            this.E = 4;
                            if(S2.H(l10, playlistsSmartEditRes1.result.updatedDate, playlistsSmartEditRes1.result.replaceThreshold, this) == a0) {
                                return a0;
                            }
                            v28 = v3;
                            a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, v20, "SyncByAppDataFromUserSelectPopup", 6));
                            goto label_496;
                        }
                        catch(Exception exception0) {
                        }
                    }
                    catch(Throwable throwable1) {
                        goto label_488;
                    }
                    v21 = v20;
                    a2 = S2.f(s20, v21, exception0);
                    v28 = v3;
                }
                else {
                    try {
                        this.r = mutex3;
                        this.w = object3;
                        object8 = object3;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = null;
                        this.B = v;
                        this.D = v5;
                        this.G = v6;
                        this.I = v3;
                        this.c0 = v7;
                        this.d0 = v8;
                        this.e0 = v21_1;
                        this.E = 5;
                        object9 = S2.e(s20, v20, l10, playlistsSmartEditRes1, this);
                    }
                    catch(Exception exception0) {
                        v21 = v20;
                        object3 = object8;
                        a2 = S2.f(s20, v21, exception0);
                        v28 = v3;
                        goto label_496;
                    }
                    catch(Throwable throwable1) {
                        object3 = object8;
                        goto label_488;
                    }
                    if(object9 == a0) {
                        return a0;
                    }
                    v28 = v3;
                    object3 = object8;
                    a2 = (a)object9;
                }
                goto label_496;
            }
            case 4: {
                try {
                    v28 = this.I;
                    object3 = this.w;
                    mutex3 = this.r;
                    d5.n.D(object0);
                }
                catch(Exception exception0) {
                    goto label_271;
                }
                catch(Throwable throwable1) {
                    v3 = v28;
                    goto label_488;
                }
                try {
                    a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, v20, "SyncByAppDataFromUserSelectPopup", 6));
                    goto label_496;
                }
                catch(Exception exception0) {
                }
                catch(Throwable throwable1) {
                    v3 = v28;
                    goto label_488;
                }
                v3 = v28;
                v21 = v20;
                a2 = S2.f(s20, v21, exception0);
                v28 = v3;
                goto label_496;
            }
            case 5: {
                try {
                    v28 = this.I;
                    object3 = this.w;
                    mutex3 = this.r;
                    d5.n.D(object0);
                    object9 = object0;
                }
                catch(Exception exception0) {
                label_271:
                    v3 = v28;
                    v21 = v20;
                    a2 = S2.f(s20, v21, exception0);
                    v28 = v3;
                    goto label_496;
                }
                catch(Throwable throwable1) {
                    v3 = v28;
                    goto label_488;
                }
                try {
                    a2 = (a)object9;
                    goto label_496;
                }
                catch(Exception exception0) {
                    v3 = v28;
                    v21 = v20;
                    a2 = S2.f(s20, v21, exception0);
                    v28 = v3;
                    goto label_496;
                }
                catch(Throwable throwable1) {
                    v3 = v28;
                    goto label_488;
                }
            }
            case 6: {
                try {
                    v22 = v20;
                    int v29 = this.c0;
                    v3 = this.I;
                    int v30 = this.e0;
                    int v31 = this.G;
                    int v32 = this.D;
                    v9 = this.B;
                    int v33 = this.d0;
                    s1 = this.Z;
                    l02 = this.Y;
                    object10 = this.w;
                    mutex7 = this.r;
                    d5.n.D(object0);
                    s = s1;
                    l00 = l02;
                    v12 = v30;
                    v11 = v33;
                    v13 = v32;
                    v14 = v31;
                    mutex5 = mutex7;
                    v10 = v29;
                    object6 = object10;
                }
                catch(Throwable throwable2) {
                    goto label_363;
                }
                try {
                label_308:
                    playlistsSmartEditRes2 = (PlaylistsSmartEditRes)object0;
                    this.r = mutex5;
                    this.w = object6;
                    this.Y = l00;
                    this.Z = s;
                    this.b0 = playlistsSmartEditRes2;
                    this.B = v9;
                    this.D = v13;
                    this.G = v14;
                    this.I = v3;
                    this.c0 = v10;
                    this.d0 = v11;
                    this.e0 = v12;
                    this.E = 7;
                    S2.y(l10, playlistsSmartEditRes2);
                }
                catch(Throwable throwable2) {
                    v21 = v22;
                    l01 = l00;
                    mutex4 = mutex5;
                    object5 = object6;
                    goto label_467;
                }
                if(h0 == a0) {
                    return a0;
                }
                l01 = l00;
                object5 = object6;
                v34 = v10;
                v35 = v9;
                goto label_369;
            }
            case 7: {
                try {
                    int v36 = this.c0;
                    v22 = v20;
                    v3 = this.I;
                    int v37 = this.e0;
                    int v38 = this.G;
                    int v39 = this.D;
                    int v40 = this.B;
                    PlaylistsSmartEditRes playlistsSmartEditRes3 = this.b0;
                    int v41 = this.d0;
                    s1 = this.Z;
                    l02 = this.Y;
                    object10 = this.w;
                    mutex7 = this.r;
                    d5.n.D(object0);
                    v11 = v41;
                    v14 = v38;
                    mutex5 = mutex7;
                    v35 = v40;
                    s = s1;
                    v13 = v39;
                    object5 = object10;
                    v34 = v36;
                    l01 = l02;
                    playlistsSmartEditRes2 = playlistsSmartEditRes3;
                    v12 = v37;
                }
                catch(Throwable throwable2) {
                label_363:
                    mutex4 = mutex7;
                    v21 = v22;
                    s = s1;
                    l01 = l02;
                    object5 = object10;
                    goto label_467;
                }
            label_369:
                if(playlistsSmartEditRes2.success) {
                    try {
                        this.r = mutex5;
                        this.w = object5;
                        this.Y = l01;
                        this.Z = s;
                        this.b0 = null;
                        this.B = v35;
                        this.D = v13;
                        this.G = v14;
                        v42 = v3;
                        this.I = v42;
                        this.c0 = v34;
                        this.d0 = v11;
                        this.e0 = v12;
                        this.E = 8;
                        if(S2.H(l10, playlistsSmartEditRes2.result.updatedDate, playlistsSmartEditRes2.result.replaceThreshold, this) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable2) {
                        v21 = v22;
                        v3 = v42;
                        mutex4 = mutex5;
                        goto label_467;
                    }
                    object11 = object5;
                    mutex4 = mutex5;
                    goto label_438;
                }
                else {
                    try {
                        this.r = mutex5;
                        this.w = object5;
                        this.Y = l01;
                        this.Z = s;
                        this.b0 = null;
                        this.B = v35;
                        this.D = v13;
                        this.G = v14;
                        this.I = v3;
                        this.c0 = v34;
                        this.d0 = v11;
                        this.e0 = v12;
                        this.E = 9;
                        v21 = v22;
                        object12 = S2.e(s20, v21, l10, playlistsSmartEditRes2, this);
                    }
                    catch(Throwable throwable2) {
                        mutex4 = mutex5;
                        goto label_467;
                    }
                    if(object12 == a0) {
                        return a0;
                    }
                    mutex4 = mutex5;
                    a2 = (a)object12;
                    object3 = object5;
                }
                goto label_475;
            }
            case 8: {
                try {
                    String s2 = this.Z;
                    L0 l03 = this.Y;
                    object13 = this.w;
                    v43 = this.I;
                    mutex8 = this.r;
                    s = s2;
                    l01 = l03;
                    d5.n.D(object0);
                    s = s2;
                    l01 = l03;
                    object11 = object13;
                    mutex4 = mutex8;
                    v42 = v43;
                    v22 = v20;
                }
                catch(Throwable throwable2) {
                    v21 = v20;
                    object5 = object13;
                    v3 = v43;
                    mutex4 = mutex8;
                    goto label_467;
                }
                try {
                label_438:
                    a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, v22, "SyncByAppDataFromUserSelectPopup", 6));
                    object3 = object11;
                    v21 = v22;
                    v3 = v42;
                    goto label_475;
                }
                catch(Throwable throwable2) {
                    object5 = object11;
                    v21 = v22;
                    v3 = v42;
                    goto label_467;
                }
            }
            case 9: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            long v44 = this.I;
            String s3 = this.Z;
            l01 = this.Y;
            Object object14 = this.w;
            mutex4 = this.r;
            object5 = object14;
            s = s3;
            v21 = v20;
            v3 = v44;
            d5.n.D(object0);
            object12 = object0;
            object5 = object14;
            s = s3;
            v21 = v20;
            v3 = v44;
            a2 = (a)object12;
            object3 = object5;
            goto label_475;
        }
        catch(Throwable throwable2) {
        }
        try {
        label_467:
            l01.a(s + " false", false);
            throw throwable2;
        }
        catch(Exception exception0) {
            object3 = object5;
            goto label_480;
        }
        catch(Throwable throwable1) {
            object3 = object5;
            goto label_487;
        }
        try {
        label_475:
            l01.a(s + " false", false);
            v28 = v3;
            mutex3 = mutex4;
            goto label_496;
        }
        catch(Exception exception0) {
        label_480:
            mutex3 = mutex4;
            try {
                a2 = S2.f(s20, v21, exception0);
                v28 = v3;
                goto label_496;
            }
            catch(Throwable throwable1) {
                goto label_488;
            }
        }
        catch(Throwable throwable1) {
        }
    label_487:
        mutex3 = mutex4;
        try {
        label_488:
            long v45 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByAppDataFromUserSelectPopup (" + v45 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByAppDataFromUserSelectPopup (" + v45 + "ms)");
            throw throwable1;
        }
        catch(Throwable throwable0) {
            object15 = object3;
            mutex9 = mutex3;
            mutex9.unlock(object15);
            throw throwable0;
        }
        try {
        label_496:
            object15 = object3;
            mutex9 = mutex3;
            long v46 = System.currentTimeMillis() - v28;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByAppDataFromUserSelectPopup (" + v46 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByAppDataFromUserSelectPopup (" + v46 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex9.unlock(object15);
            throw throwable0;
        }
        mutex9.unlock(object15);
        return a2;
    }
}

