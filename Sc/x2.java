package sc;

import com.iloen.melon.custom.L0;
import com.iloen.melon.net.mcp.response.PlaylistsSmartGetRes.Playlist;
import com.iloen.melon.net.mcp.response.PlaylistsSmartGetRes;
import com.iloen.melon.playback.SpApiQueueBaseTaskKt;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.b;
import kd.j;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import oe.i;
import we.a;
import we.n;

public final class x2 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final Mutex N;
    public final DevLog S;
    public final S2 T;
    public final l1 V;
    public final A2 W;
    public final B0 X;
    public PlaylistsSmartGetRes Y;
    public Playlist Z;
    public L0 b0;
    public String c0;
    public int d0;
    public int e0;
    public int f0;
    public Mutex r;
    public Object w;

    public x2(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, S2 s20, l1 l10, A2 a20, B0 b00) {
        this.M = mutex0;
        this.N = mutex1;
        this.S = devLog0;
        this.T = s20;
        this.V = l10;
        this.W = a20;
        this.X = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x2(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Mutex mutex10;
        Object object17;
        long v41;
        String s3;
        Mutex mutex9;
        Object object16;
        L0 l01;
        String s2;
        long v35;
        a a2;
        Mutex mutex8;
        Object object15;
        long v28;
        int v26;
        int v25;
        String s1;
        int v24;
        Object object14;
        Mutex mutex7;
        L0 l00;
        Object object13;
        Object object12;
        Object object11;
        int v23;
        int v22;
        int v21;
        int v20;
        Object object10;
        Object object9;
        long v19;
        Object object8;
        k8.a a1;
        Playlist playlistsSmartGetRes$Playlist1;
        Long long0;
        long v18;
        Mutex mutex6;
        Object object7;
        long v14;
        int v13;
        PlaylistsSmartGetRes playlistsSmartGetRes1;
        int v12;
        Object object6;
        PlaylistsSmartGetRes playlistsSmartGetRes0;
        Mutex mutex5;
        Object object5;
        long v7;
        int v6;
        int v5;
        int v4;
        Mutex mutex4;
        Object object4;
        Mutex mutex3;
        long v3;
        Object object3;
        long v1;
        Object object1;
        int v;
        Mutex mutex1;
        ne.a a0 = ne.a.a;
        l1 l10 = this.V;
        A2 a20 = this.W;
        DevLog devLog0 = this.S;
        String s = "SyncByServerDataFromUserSelectPopup";
        Mutex mutex0 = this.N;
        S2 s20 = this.T;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                mutex1 = this.M;
                this.r = mutex1;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex1.lock(null, this) != a0) {
                    try {
                        v = 0;
                        object1 = null;
                        v1 = System.currentTimeMillis();
                        goto label_28;
                    }
                    catch(Throwable throwable0) {
                        mutex10.unlock(object17);
                        throw throwable0;
                    }
                }
                return a0;
            }
            case 1: {
                int v2 = this.B;
                Object object2 = this.w;
                Mutex mutex2 = this.r;
                d5.n.D(object0);
                v = v2;
                mutex1 = mutex2;
                object1 = object2;
                try {
                    v1 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex10.unlock(object17);
                    throw throwable0;
                }
                try {
                label_28:
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : SyncByServerDataFromUserSelectPopup", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : SyncByServerDataFromUserSelectPopup");
                    try {
                        s20.r();
                        this.r = mutex1;
                        this.w = object1;
                        this.B = v;
                        this.D = 0;
                        this.G = 0;
                        this.I = v1;
                        this.d0 = 0;
                        this.E = 2;
                        object3 = S2.k(s20, l10, this);
                    }
                    catch(Exception exception0) {
                        v3 = v1;
                        mutex3 = mutex1;
                        object4 = object1;
                        a2 = S2.h(s20, a20, exception0);
                        goto label_421;
                    }
                }
                catch(Throwable throwable1) {
                    v3 = v1;
                    mutex3 = mutex1;
                    object4 = object1;
                    goto label_413;
                }
                if(object3 != a0) {
                    mutex4 = mutex1;
                    object4 = object1;
                    object0 = object3;
                    v4 = 0;
                    v5 = 0;
                    v6 = 0;
                    goto label_85;
                }
                return a0;
            }
            case 2: {
                try {
                    v7 = this.I;
                    int v8 = this.G;
                    int v9 = this.d0;
                    int v10 = this.D;
                    int v11 = this.B;
                    object5 = this.w;
                    mutex5 = this.r;
                    d5.n.D(object0);
                    v5 = v10;
                    mutex4 = mutex5;
                    v4 = v9;
                    v = v11;
                    v1 = v7;
                    v6 = v8;
                    object4 = object5;
                }
                catch(Exception exception0) {
                    mutex3 = mutex5;
                    v3 = v7;
                    object4 = object5;
                    a2 = S2.h(s20, a20, exception0);
                    goto label_421;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex5;
                    v3 = v7;
                    object4 = object5;
                    goto label_413;
                }
                try {
                label_85:
                    playlistsSmartGetRes0 = (PlaylistsSmartGetRes)object0;
                    this.r = mutex4;
                    this.w = object4;
                    this.Y = playlistsSmartGetRes0;
                    this.B = v;
                    this.D = v5;
                    this.G = v6;
                    this.I = v1;
                    this.d0 = v4;
                    this.E = 3;
                    S2.y(l10, playlistsSmartGetRes0);
                }
                catch(Exception exception0) {
                    v3 = v1;
                    mutex3 = mutex4;
                    a2 = S2.h(s20, a20, exception0);
                    goto label_421;
                }
                catch(Throwable throwable1) {
                    v3 = v1;
                    mutex3 = mutex4;
                    goto label_413;
                }
                if(H.a != a0) {
                    object6 = object4;
                    v12 = v6;
                    playlistsSmartGetRes1 = playlistsSmartGetRes0;
                    v13 = v4;
                    goto label_138;
                }
                return a0;
            }
            case 3: {
                try {
                    v14 = this.I;
                    v12 = this.G;
                    int v15 = this.d0;
                    int v16 = this.D;
                    int v17 = this.B;
                    PlaylistsSmartGetRes playlistsSmartGetRes2 = this.Y;
                    object7 = this.w;
                    mutex6 = this.r;
                    d5.n.D(object0);
                    v5 = v16;
                    mutex4 = mutex6;
                    v = v17;
                    playlistsSmartGetRes1 = playlistsSmartGetRes2;
                    v13 = v15;
                    object6 = object7;
                    v1 = v14;
                }
                catch(Exception exception0) {
                    mutex3 = mutex6;
                    v3 = v14;
                    object4 = object7;
                    a2 = S2.h(s20, a20, exception0);
                    goto label_421;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex6;
                    v3 = v14;
                    object4 = object7;
                    goto label_413;
                }
            label_138:
                LogU logU0 = s20.a;
                Playlist playlistsSmartGetRes$Playlist0 = playlistsSmartGetRes1.result;
                if(playlistsSmartGetRes$Playlist0 == null) {
                    v18 = v1;
                    long0 = null;
                }
                else {
                    v18 = v1;
                    long0 = new Long(playlistsSmartGetRes$Playlist0.updatedDate);
                }
                try {
                    LogU.debug$default(logU0, "SyncByServerDataFromUserSelectPopup, getRawRes: " + long0, null, false, 6, null);
                    playlistsSmartGetRes$Playlist1 = playlistsSmartGetRes1.result;
                    q.d(playlistsSmartGetRes$Playlist1);
                    a1 = s20.h;
                    B0 b00 = this.X;
                }
                catch(Exception exception0) {
                    object8 = object6;
                    v19 = v18;
                    object4 = object8;
                    mutex3 = mutex4;
                    v3 = v19;
                    a2 = S2.h(s20, a20, exception0);
                    goto label_421;
                }
                catch(Throwable throwable1) {
                    object9 = object6;
                    v19 = v18;
                    object4 = object9;
                    mutex3 = mutex4;
                    v3 = v19;
                    goto label_413;
                }
                if(a1 == null) {
                    try {
                        object10 = object6;
                        v19 = v18;
                        h1 h10 = S2.m(playlistsSmartGetRes$Playlist1);
                        this.r = mutex4;
                        this.w = object6;
                        this.Y = null;
                        this.Z = playlistsSmartGetRes$Playlist1;
                        this.b0 = null;
                        this.c0 = null;
                        this.B = v;
                        this.D = v5;
                        this.G = v12;
                        v19 = v18;
                        this.I = v19;
                        this.d0 = v13;
                        object10 = object6;
                        goto label_182;
                    }
                    catch(Exception exception0) {
                        object10 = object6;
                        v19 = v18;
                        goto label_188;
                        try {
                        label_182:
                            this.e0 = 0;
                            this.f0 = 0;
                            this.E = 4;
                            if(b00.invoke(h10, this) != a0) {
                                goto label_195;
                            }
                            return a0;
                        }
                        catch(Exception exception0) {
                        }
                        catch(Throwable throwable1) {
                            object4 = object10;
                            mutex3 = mutex4;
                            v3 = v19;
                            goto label_413;
                        }
                    label_188:
                        object4 = object10;
                        mutex3 = mutex4;
                        v3 = v19;
                        a2 = S2.h(s20, a20, exception0);
                        goto label_421;
                    }
                    catch(Throwable throwable1) {
                        object4 = object10;
                        mutex3 = mutex4;
                        v3 = v19;
                        goto label_413;
                    }
                label_195:
                    v20 = v12;
                    mutex3 = mutex4;
                    v21 = v13;
                    v22 = 0;
                    v23 = 0;
                    object11 = object10;
                    goto label_278;
                }
                else {
                    try {
                        v19 = v18;
                        ((b)a1).a("SyncByServerDataFromUserSelectPopup true", true);
                        goto label_215;
                    }
                    catch(Exception exception0) {
                        object8 = object6;
                        object4 = object8;
                        mutex3 = mutex4;
                        v3 = v19;
                        a2 = S2.h(s20, a20, exception0);
                        goto label_421;
                    }
                    catch(Throwable throwable1) {
                        object9 = object6;
                    }
                    object4 = object9;
                    mutex3 = mutex4;
                    v3 = v19;
                    goto label_413;
                    try {
                    label_215:
                        object12 = object6;
                        h1 h11 = S2.m(playlistsSmartGetRes$Playlist1);
                        this.r = mutex4;
                        object12 = object6;
                        this.w = object12;
                        this.Y = null;
                        this.Z = playlistsSmartGetRes$Playlist1;
                        this.b0 = a1;
                        this.c0 = "SyncByServerDataFromUserSelectPopup";
                        this.B = v;
                        this.D = v5;
                        this.G = v12;
                        this.I = v19;
                        this.d0 = v13;
                        this.e0 = 0;
                        this.f0 = 0;
                        this.E = 6;
                        if(b00.invoke(h11, this) != a0) {
                            goto label_239;
                        }
                        return a0;
                    }
                    catch(Throwable throwable2) {
                        object13 = object12;
                        l00 = a1;
                        mutex7 = mutex4;
                        goto label_389;
                    }
                label_239:
                    object14 = object12;
                    v24 = v13;
                    s1 = "SyncByServerDataFromUserSelectPopup";
                    v25 = 0;
                    v26 = 0;
                    l00 = a1;
                    mutex7 = mutex4;
                    goto label_344;
                }
                return a0;
            }
            case 4: {
                try {
                    int v27 = this.d0;
                    v28 = this.I;
                    int v29 = this.G;
                    int v30 = this.f0;
                    int v31 = this.D;
                    int v32 = this.B;
                    playlistsSmartGetRes$Playlist1 = this.Z;
                    int v33 = this.e0;
                    object15 = this.w;
                    mutex8 = this.r;
                    mutex3 = mutex8;
                    d5.n.D(object0);
                    mutex3 = mutex8;
                    v20 = v29;
                    v5 = v31;
                    v23 = v30;
                    v21 = v27;
                    object11 = object15;
                    v19 = v28;
                    v = v32;
                    v22 = v33;
                }
                catch(Exception exception0) {
                    mutex3 = mutex8;
                    v3 = v28;
                    object4 = object15;
                    a2 = S2.h(s20, a20, exception0);
                    goto label_421;
                }
                catch(Throwable throwable1) {
                    v3 = v28;
                    object4 = object15;
                    goto label_413;
                }
                try {
                label_278:
                    this.r = mutex3;
                    this.w = object11;
                    this.Y = null;
                    this.Z = null;
                    this.b0 = null;
                    this.c0 = null;
                    this.B = v;
                    this.D = v5;
                    this.G = v20;
                    this.I = v19;
                    this.d0 = v21;
                    this.e0 = v22;
                    this.f0 = v23;
                    this.E = 5;
                    if(S2.H(l10, playlistsSmartGetRes$Playlist1.updatedDate, playlistsSmartGetRes$Playlist1.replaceThreshold, this) != a0) {
                        v3 = v19;
                        object4 = object11;
                        a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, a20, "SyncByServerDataFromUserSelectPopup", 7));
                        goto label_421;
                    }
                    return a0;
                }
                catch(Exception exception0) {
                    v3 = v19;
                    object4 = object11;
                    a2 = S2.h(s20, a20, exception0);
                    goto label_421;
                }
                catch(Throwable throwable1) {
                    v3 = v19;
                    object4 = object11;
                    goto label_413;
                }
                v3 = v19;
                object4 = object11;
                a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, a20, "SyncByServerDataFromUserSelectPopup", 7));
                goto label_421;
            }
            case 5: {
                try {
                    v3 = this.I;
                    object4 = this.w;
                    mutex3 = this.r;
                    d5.n.D(object0);
                    a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, a20, "SyncByServerDataFromUserSelectPopup", 7));
                    goto label_421;
                }
                catch(Exception exception0) {
                }
                catch(Throwable throwable1) {
                    goto label_413;
                }
                a2 = S2.h(s20, a20, exception0);
                goto label_421;
            }
            case 6: {
                try {
                    int v34 = this.d0;
                    v35 = this.I;
                    int v36 = this.f0;
                    int v37 = this.G;
                    int v38 = this.D;
                    int v39 = this.e0;
                    s2 = this.c0;
                    int v40 = this.B;
                    playlistsSmartGetRes$Playlist1 = this.Z;
                    l01 = this.b0;
                    object16 = this.w;
                    mutex7 = this.r;
                    d5.n.D(object0);
                    v5 = v38;
                    v26 = v39;
                    object14 = object16;
                    l00 = l01;
                    v25 = v36;
                    v24 = v34;
                    v12 = v37;
                    s1 = s2;
                    v19 = v35;
                    v = v40;
                }
                catch(Throwable throwable2) {
                    s = s2;
                    l00 = l01;
                    v19 = v35;
                    object13 = object16;
                    goto label_389;
                }
                try {
                label_344:
                    this.r = mutex7;
                    this.w = object14;
                    mutex9 = mutex7;
                    this.Y = null;
                    this.Z = null;
                    this.b0 = l00;
                    this.c0 = s1;
                    this.B = v;
                    this.D = v5;
                    this.G = v12;
                    this.I = v19;
                    this.d0 = v24;
                    this.e0 = v26;
                    this.f0 = v25;
                    this.E = 7;
                    if(S2.H(l10, playlistsSmartGetRes$Playlist1.updatedDate, playlistsSmartGetRes$Playlist1.replaceThreshold, this) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable2) {
                    s = s1;
                    object13 = object14;
                    goto label_388;
                }
                s3 = s1;
                object13 = object14;
                v3 = v19;
                break;
            }
            case 7: {
                try {
                    s3 = this.c0;
                    l00 = this.b0;
                    object13 = this.w;
                    v41 = this.I;
                    mutex7 = this.r;
                    d5.n.D(object0);
                    mutex9 = mutex7;
                    v3 = v41;
                    break;
                }
                catch(Throwable throwable2) {
                    s = s3;
                    v19 = v41;
                    goto label_389;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            a2 = SpApiQueueBaseTaskKt.endAction(new j(s20, a20, "SyncByServerDataFromUserSelectPopup", 7));
            goto label_401;
        }
        catch(Throwable throwable2) {
            v19 = v3;
            s = s3;
        }
    label_388:
        mutex7 = mutex9;
        try {
        label_389:
            l00.a(s + " false", false);
            throw throwable2;
        }
        catch(Exception exception0) {
            mutex3 = mutex7;
            object4 = object13;
            v3 = v19;
            a2 = S2.h(s20, a20, exception0);
            goto label_421;
        }
        catch(Throwable throwable1) {
            mutex3 = mutex7;
            object4 = object13;
        }
        v3 = v19;
        goto label_413;
        try {
        label_401:
            object4 = object13;
            mutex3 = mutex9;
            l00.a(s3 + " false", false);
            object4 = object13;
            mutex3 = mutex9;
            goto label_421;
        }
        catch(Exception exception0) {
            object4 = object13;
            mutex3 = mutex9;
            try {
                a2 = S2.h(s20, a20, exception0);
                goto label_421;
            }
            catch(Throwable throwable1) {
            }
        }
        catch(Throwable throwable1) {
        }
        try {
        label_413:
            long v42 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByServerDataFromUserSelectPopup (" + v42 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByServerDataFromUserSelectPopup (" + v42 + "ms)");
            throw throwable1;
        }
        catch(Throwable throwable0) {
            object17 = object4;
            mutex10 = mutex3;
            mutex10.unlock(object17);
            throw throwable0;
        }
        try {
        label_421:
            object17 = object4;
            mutex10 = mutex3;
            long v43 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByServerDataFromUserSelectPopup (" + v43 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : SyncByServerDataFromUserSelectPopup (" + v43 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex10.unlock(object17);
            throw throwable0;
        }
        mutex10.unlock(object17);
        return a2;
    }
}

