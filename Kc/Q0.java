package kc;

import com.iloen.melon.custom.L0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventCurPlaylistViewFocus;
import com.iloen.melon.eventbus.EventSmartRestoreFailedDialog;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import e1.u;
import ie.H;
import ie.o;
import ie.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import nc.u0;
import ne.a;
import oe.f;
import oe.i;
import sc.P0;
import sc.T2;
import we.n;

public final class q0 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final L0 N;
    public final Mutex S;
    public final DevLog T;
    public final b V;
    public final String W;
    public final boolean X;
    public C Y;
    public P0 Z;
    public Object b0;
    public int c0;
    public int d0;
    public boolean e0;
    public Mutex r;
    public Object w;

    public q0(Mutex mutex0, Continuation continuation0, L0 l00, Mutex mutex1, DevLog devLog0, b b0, String s, boolean z) {
        this.M = mutex0;
        this.N = l00;
        this.S = mutex1;
        this.T = devLog0;
        this.V = b0;
        this.W = s;
        this.X = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q0(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h0;
        Throwable throwable4;
        Mutex mutex13;
        Object object23;
        int v58;
        Object object22;
        Object object21;
        Mutex mutex12;
        Object object20;
        Object object19;
        long v47;
        boolean z7;
        boolean z6;
        int v44;
        Mutex mutex11;
        Object object18;
        long v43;
        i3 i31;
        int v42;
        int v41;
        Object object17;
        String s6;
        int v40;
        o o0;
        Mutex mutex10;
        Object object16;
        P0 p05;
        int v39;
        int v38;
        long v37;
        int v36;
        int v35;
        boolean z5;
        Object object15;
        String s5;
        P0 p04;
        int v34;
        boolean z4;
        Mutex mutex9;
        Mutex mutex8;
        Object object14;
        long v30;
        long v29;
        int v28;
        int v27;
        Object object13;
        long v26;
        int v25;
        String s1;
        LogU logU1;
        Throwable throwable1;
        String s4;
        Mutex mutex7;
        long v20;
        Object object12;
        Mutex mutex6;
        boolean z2;
        P0 p02;
        Object object11;
        Object object10;
        P0 p01;
        Mutex mutex5;
        Object object9;
        long v14;
        Object object8;
        Mutex mutex4;
        int v12;
        Object object7;
        Object object6;
        int v11;
        boolean z;
        Object object5;
        Object object4;
        int v5;
        int v4;
        int v3;
        C c0;
        long v2;
        Object object1;
        int v;
        Mutex mutex1;
        a a0 = a.a;
        DevLog devLog0 = this.T;
        L0 l00 = this.N;
        Mutex mutex0 = this.S;
        String s = this.W;
        b b0 = this.V;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                mutex1 = this.M;
                this.r = mutex1;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                v = 0;
                object1 = null;
                goto label_25;
            }
            case 1: {
                int v1 = this.B;
                Object object2 = this.w;
                Mutex mutex2 = this.r;
                d5.n.D(object0);
                v = v1;
                mutex1 = mutex2;
                object1 = object2;
                try {
                label_25:
                    v2 = System.currentTimeMillis();
                    if(l00 != null) {
                        l00.a(" onLoginStateChanged-login", true);
                    }
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : onLoginStateChanged-login", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : onLoginStateChanged-login");
                    c0 = new C();
                    p0 p00 = new p0(c0, b0, null);
                    this.r = mutex1;
                    this.w = object1;
                    this.Y = c0;
                    this.B = v;
                    this.D = 0;
                    this.G = 0;
                    this.I = v2;
                    this.c0 = 0;
                    this.E = 2;
                    Object object3 = b0.e.getUseSmartPlaylistOrSet(s, p00, this);
                    if(object3 == a0) {
                        return a0;
                    }
                    object0 = object3;
                    v3 = 0;
                    v4 = 0;
                    v5 = 0;
                    goto label_71;
                }
                catch(Throwable throwable0) {
                    object5 = object1;
                    goto label_661;
                }
            }
            case 2: {
                try {
                    long v6 = this.I;
                    int v7 = this.G;
                    int v8 = this.c0;
                    int v9 = this.D;
                    int v10 = this.B;
                    C c1 = this.Y;
                    object4 = this.w;
                    Mutex mutex3 = this.r;
                    mutex1 = mutex3;
                    v2 = v6;
                    d5.n.D(object0);
                    mutex1 = mutex3;
                    c0 = c1;
                    v5 = v7;
                    v3 = v8;
                    v2 = v6;
                    v = v10;
                    object1 = object4;
                    v4 = v9;
                }
                catch(Throwable throwable0) {
                    object5 = object4;
                    goto label_661;
                }
                try {
                label_71:
                    z = ((Boolean)object0).booleanValue();
                    v11 = !c0.a;
                    if(z) {
                        goto label_89;
                    }
                    else if(b0.p.getValue() == PlaylistId.SMART) {
                        b0.h.r();
                        this.r = mutex1;
                        this.w = object1;
                        this.Y = null;
                        this.B = v;
                        this.D = v4;
                        this.G = v5;
                        this.I = v2;
                        this.c0 = v3;
                        this.e0 = false;
                        this.d0 = v11;
                        this.E = 14;
                        if(b.b(b0, PlaylistId.MUSIC, this) != a0) {
                            goto label_649;
                        }
                        return a0;
                    }
                    else {
                        goto label_649;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    object5 = object1;
                    goto label_661;
                }
                try {
                label_89:
                    this.r = mutex1;
                    this.w = object1;
                    object6 = object1;
                    this.Y = null;
                    this.B = v;
                    this.D = v4;
                    this.G = v5;
                    this.I = v2;
                    this.c0 = v3;
                    this.e0 = true;
                    this.d0 = v11;
                    this.E = 3;
                    object7 = b0.b.h(false, this);
                }
                catch(Throwable throwable0) {
                    object5 = object6;
                    goto label_661;
                }
                if(object7 == a0) {
                    return a0;
                }
                v12 = v3;
                mutex4 = mutex1;
                object8 = object6;
                goto label_136;
            }
            case 3: {
                try {
                    boolean z1 = this.e0;
                    int v13 = this.c0;
                    v14 = this.I;
                    int v15 = this.d0;
                    int v16 = this.G;
                    int v17 = this.D;
                    int v18 = this.B;
                    object9 = this.w;
                    mutex5 = this.r;
                    d5.n.D(object0);
                    z = z1;
                    object8 = object9;
                    v4 = v17;
                    v5 = v16;
                    mutex4 = mutex5;
                    v11 = v15;
                    object7 = object0;
                    v2 = v14;
                    v12 = v13;
                    v = v18;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex5;
                    v2 = v14;
                    object5 = object9;
                    goto label_661;
                }
                try {
                label_136:
                    object6 = object8;
                    p01 = (P0)object7;
                    this.r = mutex4;
                    this.w = object8;
                    object6 = object8;
                    this.Y = null;
                    this.Z = p01;
                    this.B = v;
                    this.D = v4;
                    this.G = v5;
                    this.I = v2;
                    this.c0 = v12;
                    this.e0 = z;
                    this.d0 = v11;
                    this.E = 4;
                    object10 = p01.U(s, v11 != 0, this);
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex4;
                    object5 = object6;
                    goto label_661;
                }
                if(object10 == a0) {
                    return a0;
                }
                object11 = object10;
                p02 = p01;
                z2 = z;
                mutex6 = mutex4;
                object12 = object6;
                goto label_191;
            }
            case 4: {
                try {
                    z2 = this.e0;
                    int v19 = this.d0;
                    v20 = this.I;
                    int v21 = this.c0;
                    int v22 = this.G;
                    int v23 = this.D;
                    int v24 = this.B;
                    P0 p03 = this.Z;
                    object6 = this.w;
                    mutex7 = this.r;
                    d5.n.D(object0);
                    v4 = v23;
                    v5 = v22;
                    p02 = p03;
                    mutex6 = mutex7;
                    v11 = v19;
                    v2 = v20;
                    v12 = v21;
                    v = v24;
                    object11 = ((p)object0).d();
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex7;
                    v2 = v20;
                    object5 = object6;
                    goto label_661;
                }
                object12 = object6;
                try {
                label_191:
                    if(p.c(object11)) {
                        s4 = s;
                        if(b0.p.getValue() == PlaylistId.MUSIC) {
                            b0.h.r();
                            this.r = mutex6;
                            this.w = object12;
                            this.Y = null;
                            this.Z = p02;
                            this.B = v;
                            this.D = v4;
                            this.G = v5;
                            this.I = v2;
                            this.c0 = v12;
                            this.e0 = z2;
                            this.d0 = v11;
                            this.E = 5;
                            if(b.b(b0, PlaylistId.SMART, this) != a0) {
                                v27 = v;
                                v28 = v12;
                                v29 = v2;
                                goto label_263;
                            }
                            return a0;
                        }
                        goto label_266;
                    }
                    else {
                        throwable1 = p.a(object11);
                        LogU logU0 = b0.l;
                        if(throwable1 == null) {
                            logU1 = logU0;
                            s1 = null;
                        }
                        else {
                            logU1 = logU0;
                            s1 = throwable1.getMessage();
                        }
                        LogU.error$default(logU1, "Fail to restoreSmartPlaylist onLogin() - " + s1, null, false, 6, null);
                        String s2 = throwable1 == null ? null : throwable1.getMessage();
                        q.g(("restoreSmartPlaylistFailed from:onLogin(), exception:" + s2), "message");
                        String s3 = "memberKey:" + s + "\n" + ("restoreSmartPlaylistFailed from:onLogin(), exception:" + s2);
                        q.f(s3, "toString(...)");
                        Reporter.createReporter(Type.PLAYLIST, LogLevel.INFO).setMessage(s3).report();
                        this.r = mutex6;
                        this.w = object12;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = throwable1;
                        this.B = v;
                        this.D = v4;
                        this.G = v5;
                        this.I = v2;
                        this.c0 = v12;
                        this.e0 = z2;
                        this.d0 = v11;
                        this.E = 12;
                        if(p02.M(this) == a0) {
                            return a0;
                        }
                        v25 = v11;
                        v26 = v2;
                        object13 = object12;
                        goto label_587;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex6;
                    object5 = object12;
                    goto label_661;
                }
                v27 = v;
                v28 = v12;
                v29 = v2;
                goto label_263;
            }
            case 5: {
                try {
                    v28 = this.c0;
                    v30 = this.I;
                    int v31 = this.d0;
                    int v32 = this.G;
                    int v33 = this.D;
                    v27 = this.B;
                    p02 = this.Z;
                    boolean z3 = this.e0;
                    object14 = this.w;
                    mutex8 = this.r;
                    d5.n.D(object0);
                    s4 = s;
                    object12 = object14;
                    mutex6 = mutex8;
                    v11 = v31;
                    v5 = v32;
                    v4 = v33;
                    v29 = v30;
                    z2 = z3;
                }
                catch(Throwable throwable0) {
                    v2 = v30;
                    object5 = object14;
                    mutex1 = mutex8;
                    goto label_661;
                }
            label_263:
                v12 = v28;
                v2 = v29;
                v = v27;
                try {
                label_266:
                    mutex9 = mutex6;
                    object5 = object12;
                    z4 = z2;
                    v34 = v11;
                    p04 = p02;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex6;
                    object5 = object12;
                    goto label_661;
                }
                try {
                    b0.r.setValue(f.a(true));
                    if(!this.X) {
                        goto label_278;
                    }
                    s5 = s4;
                    throw new IllegalArgumentException("Failed requirement.");
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex9;
                    goto label_661;
                }
                try {
                label_278:
                    PlaylistId playlistId0 = (PlaylistId)b0.p.getValue();
                    b0.f.getClass();
                    if(c.b(playlistId0)) {
                        this.r = mutex9;
                        this.w = object5;
                        this.Y = null;
                        this.Z = p04;
                        this.B = v;
                        this.D = v4;
                        this.G = v5;
                        this.I = v2;
                        this.c0 = v12;
                        this.e0 = z4;
                        this.d0 = v34;
                        this.E = 6;
                        s5 = s4;
                        goto label_298;
                    }
                    s5 = s4;
                    throw new IllegalArgumentException("Failed requirement.");
                }
                catch(Throwable throwable2) {
                    s5 = s4;
                    goto label_347;
                }
                try {
                label_298:
                    object15 = b0.f.a(s5, this);
                    if(object15 == a0) {
                        return a0;
                    }
                    z5 = z4;
                    v35 = v5;
                    goto label_338;
                }
                catch(Throwable throwable2) {
                    goto label_347;
                }
            }
            case 6: {
                try {
                    v36 = this.c0;
                    v34 = this.d0;
                    z5 = this.e0;
                    v37 = this.I;
                    v38 = this.D;
                    v35 = this.G;
                    v39 = this.B;
                    p05 = this.Z;
                    object16 = this.w;
                    mutex10 = this.r;
                    d5.n.D(object0);
                    object15 = ((p)object0).d();
                    object5 = object16;
                    s5 = s;
                    mutex9 = mutex10;
                    p04 = p05;
                    v4 = v38;
                    v12 = v36;
                    v2 = v37;
                    v = v39;
                }
                catch(Throwable throwable2) {
                    z4 = z5;
                    object5 = object16;
                    s5 = s;
                    mutex9 = mutex10;
                    p04 = p05;
                    v5 = v35;
                    v4 = v38;
                    v12 = v36;
                    v2 = v37;
                    v = v39;
                    goto label_347;
                }
                try {
                label_338:
                    d5.n.D(object15);
                    z4 = z5;
                    v5 = v35;
                    o0 = (i3)object15;
                    v40 = v;
                    z4 = z5;
                    v5 = v35;
                    goto label_349;
                }
                catch(Throwable throwable2) {
                }
                try {
                label_347:
                    o0 = d5.n.t(throwable2);
                    v40 = v;
                label_349:
                    if(p.b(o0)) {
                        o0 = null;
                    }
                    i3 i30 = (i3)o0;
                    s6 = s5;
                    if(i30 instanceof h3) {
                        String s7 = ((h3)i30).c();
                        long v45 = ((h3)i30).b();
                        this.r = mutex9;
                        this.w = object5;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = null;
                        this.B = v40;
                        this.D = v4;
                        this.G = v5;
                        this.I = v2;
                        this.c0 = v12;
                        this.e0 = z4;
                        this.d0 = v34;
                        this.E = 7;
                        if(p04.V(s7, v45, this) == a0) {
                            return a0;
                        }
                        v26 = v2;
                        z7 = z4;
                        goto label_425;
                    }
                    else if(i30 instanceof g3) {
                        this.r = mutex9;
                        this.w = object5;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = i30;
                        this.B = v40;
                        this.D = v4;
                        this.G = v5;
                        this.I = v2;
                        this.c0 = v12;
                        this.e0 = z4;
                        this.d0 = v34;
                        this.E = 9;
                        object17 = b0.b.b(false, this);
                        if(object17 == a0) {
                            return a0;
                        }
                        v41 = v12;
                        v42 = v40;
                        i31 = i30;
                        v43 = v2;
                        object18 = object5;
                        mutex11 = mutex9;
                        v44 = v34;
                        z6 = z4;
                        goto label_474;
                    }
                    else {
                        mutex1 = mutex9;
                        s = s6;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex9;
                    goto label_661;
                }
                v26 = v2;
                z7 = z4;
                goto label_425;
            }
            case 7: {
                boolean z8 = this.e0;
                int v46 = this.c0;
                v47 = this.I;
                int v48 = this.d0;
                int v49 = this.G;
                int v50 = this.D;
                int v51 = this.B;
                i3 i32 = (i3)this.b0;
                object19 = this.w;
                mutex8 = this.r;
                try {
                    d5.n.D(object0);
                    s6 = s;
                    v5 = v49;
                    object5 = object19;
                    mutex9 = mutex8;
                    v4 = v50;
                    v12 = v46;
                    v26 = v47;
                    v34 = v48;
                    z7 = z8;
                    v40 = v51;
                }
                catch(Throwable throwable0) {
                    v2 = v47;
                    object5 = object19;
                    mutex1 = mutex8;
                    goto label_661;
                }
                try {
                label_425:
                    this.r = mutex9;
                    this.w = object5;
                    this.Y = null;
                    this.Z = null;
                    this.b0 = null;
                    this.B = v40;
                    this.D = v4;
                    this.G = v5;
                    this.I = v26;
                    this.c0 = v12;
                    this.e0 = z7;
                    this.d0 = v34;
                    this.E = 8;
                    if(b.b(b0, PlaylistId.SMART, this) == a0) {
                        return a0;
                    }
                    object13 = object5;
                    mutex1 = mutex9;
                    goto label_555;
                }
                catch(Throwable throwable0) {
                    v2 = v26;
                }
                mutex1 = mutex9;
                goto label_661;
            }
            case 8: {
                v26 = this.I;
                i3 i33 = (i3)this.b0;
                object13 = this.w;
                mutex1 = this.r;
                goto label_553;
            }
            case 9: {
                boolean z9 = this.e0;
                int v52 = this.c0;
                v30 = this.I;
                int v53 = this.d0;
                int v54 = this.G;
                int v55 = this.D;
                int v56 = this.B;
                i31 = (i3)this.b0;
                object14 = this.w;
                mutex8 = this.r;
                try {
                    d5.n.D(object0);
                    s6 = s;
                    v44 = v53;
                    v42 = v56;
                    z6 = z9;
                    v41 = v52;
                    v4 = v55;
                    object18 = object14;
                    v5 = v54;
                    v43 = v30;
                    mutex11 = mutex8;
                    object17 = object0;
                }
                catch(Throwable throwable0) {
                    v2 = v30;
                    object5 = object14;
                    mutex1 = mutex8;
                    goto label_661;
                }
                try {
                label_474:
                    DrawerPlaylistInfo drawerPlaylistInfo0 = ((g3)i31).c();
                    String s8 = ((g3)i31).b();
                    long v57 = ((g3)i31).d();
                    this.r = mutex11;
                    this.w = object18;
                    this.Y = null;
                    this.Z = null;
                    this.b0 = null;
                    this.B = v42;
                    this.D = v4;
                    this.G = v5;
                    this.I = v43;
                    this.c0 = v41;
                    this.e0 = z6;
                    this.d0 = v44;
                    this.E = 10;
                    object20 = object18;
                    mutex12 = mutex11;
                    object21 = ((u0)object17).N(drawerPlaylistInfo0, s8, v57, this);
                }
                catch(Throwable throwable0) {
                    v2 = v43;
                    mutex1 = mutex12;
                    object5 = object20;
                    goto label_661;
                }
                if(object21 == a0) {
                    return a0;
                }
                object22 = object21;
                v58 = v42;
                v26 = v43;
                mutex1 = mutex12;
                object13 = object20;
                goto label_533;
            }
            case 10: {
                boolean z10 = this.e0;
                int v59 = this.c0;
                v47 = this.I;
                int v60 = this.d0;
                int v61 = this.G;
                int v62 = this.D;
                int v63 = this.B;
                u0 u00 = (u0)this.b0;
                object19 = this.w;
                mutex8 = this.r;
                try {
                    d5.n.D(object0);
                    s6 = s;
                    v44 = v60;
                    object22 = ((p)object0).d();
                    z6 = z10;
                    v41 = v59;
                    v5 = v61;
                    v58 = v63;
                    mutex1 = mutex8;
                    v26 = v47;
                    object13 = object19;
                    v4 = v62;
                }
                catch(Throwable throwable0) {
                    v2 = v47;
                    object5 = object19;
                    mutex1 = mutex8;
                    goto label_661;
                }
                try {
                label_533:
                    if(p.c(object22)) {
                        this.r = mutex1;
                        this.w = object13;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = null;
                        this.B = v58;
                        this.D = v4;
                        this.G = v5;
                        this.I = v26;
                        this.c0 = v41;
                        this.e0 = z6;
                        this.d0 = v44;
                        this.E = 11;
                        if(b.b(b0, PlaylistId.DRAWER, this) != a0) {
                            goto label_555;
                        }
                        return a0;
                    }
                    object5 = object13;
                    s = s6;
                    v2 = v26;
                    break;
                }
                catch(Throwable throwable0) {
                    object5 = object13;
                    v2 = v26;
                    goto label_661;
                }
                goto label_555;
            }
            case 11: {
                v26 = this.I;
                u0 u01 = (u0)this.b0;
                object13 = this.w;
                mutex1 = this.r;
                try {
                label_553:
                    d5.n.D(object0);
                    s6 = s;
                }
                catch(Throwable throwable0) {
                    object5 = object13;
                    v2 = v26;
                    goto label_661;
                }
                try {
                label_555:
                    EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                    object5 = object13;
                    s = s6;
                    v2 = v26;
                    break;
                }
                catch(Throwable throwable0) {
                    object5 = object13;
                    v2 = v26;
                    goto label_661;
                }
            }
            case 12: {
                boolean z11 = this.e0;
                int v64 = this.c0;
                v30 = this.I;
                int v65 = this.d0;
                int v66 = this.G;
                int v67 = this.D;
                int v68 = this.B;
                Throwable throwable3 = (Throwable)this.b0;
                object14 = this.w;
                mutex8 = this.r;
                try {
                    d5.n.D(object0);
                    throwable1 = throwable3;
                    mutex6 = mutex8;
                    v25 = v65;
                    v12 = v64;
                    v26 = v30;
                    z2 = z11;
                    object13 = object14;
                    v5 = v66;
                    v4 = v67;
                    v = v68;
                    goto label_587;
                }
                catch(Throwable throwable0) {
                    v2 = v30;
                    object5 = object14;
                }
                mutex1 = mutex8;
                goto label_661;
                try {
                label_587:
                    if(u.o(s)) {
                        this.r = mutex6;
                        this.w = object13;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = throwable1;
                        this.B = v;
                        this.D = v4;
                        this.G = v5;
                        this.I = v26;
                        this.c0 = v12;
                        this.e0 = z2;
                        this.d0 = v25;
                        this.E = 13;
                        if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s, false, this) != a0) {
                            object23 = object13;
                            mutex13 = mutex6;
                            throwable4 = throwable1;
                            goto label_625;
                        }
                        try {
                            return a0;
                        }
                        catch(Throwable throwable0) {
                            object5 = object1;
                            goto label_661;
                        }
                    }
                    else {
                        try {
                            mutex1 = mutex6;
                            goto label_628;
                        }
                        catch(Throwable throwable0) {
                        }
                        mutex1 = mutex6;
                        object5 = object13;
                        v2 = v26;
                        goto label_661;
                    }
                    goto label_628;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex6;
                    object5 = object13;
                    v2 = v26;
                    goto label_661;
                }
            }
            case 13: {
                v25 = this.d0;
                v26 = this.I;
                throwable4 = (Throwable)this.b0;
                object23 = this.w;
                mutex13 = this.r;
                try {
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    object5 = object23;
                    mutex1 = mutex13;
                    v2 = v26;
                    goto label_661;
                }
            label_625:
                throwable1 = throwable4;
                object13 = object23;
                mutex1 = mutex13;
                try {
                label_628:
                    b0.r.setValue(f.a(false));
                    if(v25 != 0 && !(throwable1 instanceof T2)) {
                        EventBusHelper.post(new EventSmartRestoreFailedDialog());
                    }
                    object5 = object13;
                    v2 = v26;
                    break;
                }
                catch(Throwable throwable0) {
                    object5 = object13;
                }
                v2 = v26;
                goto label_661;
            }
            case 14: {
                try {
                    v26 = this.I;
                    object13 = this.w;
                    mutex1 = this.r;
                    d5.n.D(object0);
                    object1 = object13;
                    v2 = v26;
                }
                catch(Throwable throwable0) {
                    object5 = object13;
                    v2 = v26;
                    goto label_661;
                }
                try {
                label_649:
                    b0.r.setValue(f.a(false));
                    object5 = object1;
                    break;
                }
                catch(Throwable throwable0) {
                    object5 = object1;
                }
                goto label_661;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            boolean z12 = q.b(b0.r.getValue(), f.a(true));
            SmartPlaylistLog.INSTANCE.sendSpStatisticsAsync("onLogin", s, z12);
            h0 = H.a;
            goto label_667;
        }
        catch(Throwable throwable0) {
        }
        try {
        label_661:
            long v69 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-login (" + v69 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-login (" + v69 + "ms)");
            if(l00 != null) {
                l00.a(" onLoginStateChanged-login", false);
            }
            throw throwable0;
        label_667:
            long v70 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-login (" + v70 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-login (" + v70 + "ms)");
            if(l00 != null) {
                l00.a(" onLoginStateChanged-login", false);
            }
        }
        catch(Throwable throwable5) {
            mutex1.unlock(object5);
            throw throwable5;
        }
        mutex1.unlock(object5);
        return h0;
    }
}

