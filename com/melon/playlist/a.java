package com.melon.playlist;

import androidx.appcompat.app.o;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventCurPlaylistViewFocus;
import com.iloen.melon.eventbus.EventSmartRestoreFailedDialog;
import com.iloen.melon.eventbus.EventSongPlaylistViewFocus;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.p;
import kc.T0;
import kc.c;
import kc.g3;
import kc.h3;
import kc.i3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import nc.u0;
import oe.f;
import oe.i;
import sc.P0;
import sc.T2;
import we.n;

public final class a extends i implements n {
    public L0 B;
    public Object D;
    public Object E;
    public Object G;
    public Object I;
    public Object M;
    public P0 N;
    public Object S;
    public Object T;
    public boolean V;
    public boolean W;
    public int X;
    public int Y;
    public int Z;
    public int b0;
    public long c0;
    public int d0;
    public final b e0;
    public final boolean f0;
    public final String g0;
    public final boolean h0;
    public final C i0;
    public Mutex r;
    public String w;

    public a(b b0, boolean z, String s, boolean z1, C c0, Continuation continuation0) {
        this.e0 = b0;
        this.f0 = z;
        this.g0 = s;
        this.h0 = z1;
        this.i0 = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a(this.e0, this.f0, this.g0, this.h0, this.i0, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C c17;
        b b18;
        ne.a a9;
        String s37;
        b b16;
        Throwable throwable4;
        Object object12;
        int v67;
        b b14;
        Object object11;
        int v66;
        String s34;
        Object object10;
        ne.a a8;
        Mutex mutex13;
        Mutex mutex9;
        L0 l05;
        String s32;
        long v59;
        long v53;
        DevLog devLog8;
        L0 l04;
        C c11;
        Mutex mutex7;
        int v52;
        int v51;
        String s31;
        int v50;
        ne.a a7;
        i3 i31;
        Object object9;
        String s30;
        String s29;
        int v49;
        Mutex mutex6;
        b b12;
        DevLog devLog7;
        C c10;
        String s28;
        String s26;
        C c9;
        i3 i30;
        C c8;
        int v43;
        DevLog devLog5;
        String s25;
        b b10;
        P0 p08;
        Object object7;
        b b9;
        ne.a a6;
        int v42;
        b b8;
        int v36;
        int v35;
        int v34;
        P0 p06;
        b b6;
        C c6;
        ne.a a5;
        Mutex mutex3;
        L0 l02;
        String s23;
        long v33;
        DevLog devLog4;
        Object object6;
        int v23;
        String s18;
        String s17;
        b b4;
        int v22;
        String s14;
        LogU logU1;
        Throwable throwable1;
        C c5;
        String s21;
        int v27;
        int v26;
        P0 p04;
        String s20;
        int v25;
        String s19;
        b b5;
        P0 p03;
        int v24;
        C c4;
        String s12;
        P0 p01;
        C c2;
        int v17;
        int v16;
        int v15;
        String s11;
        DevLog devLog3;
        String s10;
        int v14;
        ne.a a4;
        String s9;
        b b2;
        int v13;
        int v12;
        Object object5;
        String s8;
        boolean z4;
        ne.a a3;
        Object object4;
        String s7;
        String s6;
        Mutex mutex2;
        String s5;
        L0 l01;
        DevLog devLog2;
        Object object3;
        long v7;
        P0 p00;
        int v6;
        int v5;
        int v4;
        int v3;
        boolean z2;
        ne.a a2;
        ne.a a1;
        Object object1;
        long v2;
        String s3;
        long v1;
        String s2;
        String s1;
        C c0;
        boolean z1;
        String s;
        DevLog devLog1;
        L0 l00;
        Mutex mutex1;
        b b0;
        ne.a a0 = ne.a.a;
        switch(this.d0) {
            case 0: {
                d5.n.D(object0);
                b0 = this.e0;
                mutex1 = b0.s;
                l00 = b0.j;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex1.hashCode(), "ReentrantLock[", "]  try : setSmartPlaylistUseByUserAction"), null, false, 6, null);
                devLog1 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey1 = l1.b("ReentrantLock[", mutex1.hashCode(), "]  try : setSmartPlaylistUseByUserAction", devLog1, mutex1);
                g g0 = this.getContext().get(reentrantMutexContextKey1);
                boolean z = this.f0;
                s = this.g0;
                z1 = this.h0;
                c0 = this.i0;
                if(g0 != null) {
                    long v = System.currentTimeMillis();
                    s1 = "setSmartPlaylistUseByUserAction";
                    s2 = "";
                    if(l00 == null) {
                        v1 = v;
                    }
                    else {
                        try {
                            v1 = v;
                            ((k8.b)l00).a(" setSmartPlaylistUseByUserAction", true);
                        }
                        catch(Throwable throwable0) {
                            s3 = "";
                            v2 = v1;
                            goto label_1151;
                        }
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : setSmartPlaylistUseByUserAction", null, false, 6, null);
                        v2 = v1;
                        devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : setSmartPlaylistUseByUserAction");
                        this.r = mutex1;
                        this.w = "setSmartPlaylistUseByUserAction";
                        this.B = l00;
                        this.D = b0;
                        this.E = s;
                        this.G = c0;
                        this.I = devLog1;
                        this.M = "";
                        this.N = null;
                        this.V = z;
                        this.W = z1;
                        this.X = 0;
                        this.Y = 0;
                        this.Z = 0;
                        v2 = v1;
                        this.c0 = v2;
                        this.b0 = 0;
                        this.d0 = 1;
                        object1 = b0.b.h(false, this);
                        a1 = a0;
                    }
                    catch(Throwable throwable0) {
                        s3 = "";
                        goto label_1151;
                    }
                    if(object1 == a1) {
                        return a1;
                    }
                    try {
                        a2 = a1;
                        z2 = z;
                        v3 = 0;
                        v4 = 0;
                        v5 = 0;
                        v6 = 0;
                        p00 = (P0)object1;
                        goto label_124;
                    }
                    catch(Throwable throwable0) {
                        s6 = s1;
                        s3 = s2;
                        s1 = s6;
                        goto label_1151;
                    }
                }
                a1 = a0;
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                T0 t00 = new T0(mutex1, null, l00, mutex1, devLog1, b0, z, s, z1, c0);
                this.r = null;
                this.w = null;
                this.B = null;
                this.D = null;
                this.E = null;
                this.G = null;
                this.I = null;
                this.X = 0;
                this.Y = 0;
                this.d0 = 16;
                Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, t00, this);
                return object2 == a1 ? a1 : object2;
            }
            case 1: {
                v7 = this.c0;
                int v8 = this.Z;
                int v9 = this.Y;
                int v10 = this.X;
                int v11 = this.b0;
                boolean z3 = this.W;
                z2 = this.V;
                Continuation continuation0 = (Continuation)this.N;
                object3 = this.M;
                devLog2 = (DevLog)this.I;
                C c1 = (C)this.G;
                String s4 = (String)this.E;
                b b1 = (b)this.D;
                l01 = this.B;
                s5 = this.w;
                mutex2 = this.r;
                try {
                    d5.n.D(object0);
                    v6 = v11;
                    devLog1 = devLog2;
                    c0 = c1;
                    v3 = v10;
                    v4 = v9;
                    mutex1 = mutex2;
                    s1 = s5;
                    a2 = a0;
                    s2 = object3;
                    z1 = z3;
                    v2 = v7;
                    s = s4;
                    b0 = b1;
                    v5 = v8;
                    l00 = l01;
                }
                catch(Throwable throwable0) {
                    goto label_242;
                }
                try {
                    p00 = (P0)object0;
                }
                catch(Throwable throwable0) {
                    s6 = s1;
                    s3 = s2;
                    s1 = s6;
                    goto label_1151;
                }
            label_124:
                if(z2) {
                    try {
                        this.r = mutex1;
                        this.w = s1;
                        this.B = l00;
                        this.D = b0;
                        this.E = s;
                        this.G = c0;
                        this.I = devLog1;
                        this.M = s2;
                        s7 = s2;
                        this.N = null;
                        this.S = p00;
                        this.V = z1;
                        this.X = v3;
                        this.Y = v4;
                        this.Z = v5;
                        this.c0 = v2;
                        this.b0 = v6;
                        this.d0 = 2;
                        object4 = p00.U(s, true, this);
                        if(object4 == a2) {
                            return a2;
                        }
                    }
                    catch(Throwable throwable0) {
                        s3 = s7;
                        goto label_1151;
                    }
                    a3 = a2;
                    z4 = z1;
                    s8 = s1;
                    object5 = object4;
                    v12 = v6;
                    v13 = v3;
                    b2 = b0;
                    s9 = s7;
                    goto label_249;
                }
                else {
                    try {
                        s7 = s2;
                        a4 = a2;
                        if(b0.p.getValue() == PlaylistId.SMART) {
                            goto label_170;
                        }
                        else {
                            goto label_158;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        s3 = s7;
                        s6 = s1;
                        s1 = s6;
                        goto label_1151;
                    }
                    try {
                    label_158:
                        if(!b0.i.a().b() || z1) {
                            goto label_170;
                        }
                        else {
                            goto label_163;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        try {
                            s3 = s7;
                        }
                        catch(Throwable throwable0) {
                            v2 = v53;
                            s3 = s9;
                            devLog1 = devLog3;
                            s1 = s21;
                        }
                        goto label_1151;
                    }
                label_163:
                    v14 = v3;
                    s10 = s;
                    devLog3 = devLog1;
                    s11 = s1;
                    s3 = s7;
                    v15 = v6;
                    goto label_1031;
                    try {
                    label_170:
                        b0.h.r();
                        this.r = mutex1;
                        this.w = s1;
                        this.B = l00;
                        this.D = b0;
                        this.E = s;
                        this.G = c0;
                        this.I = devLog1;
                        s3 = s7;
                        this.M = s3;
                        s6 = s1;
                    }
                    catch(Throwable throwable0) {
                        s3 = s7;
                        s6 = s1;
                        s1 = s6;
                        goto label_1151;
                    }
                    try {
                        this.N = null;
                        this.S = p00;
                        this.X = v3;
                        this.Y = v4;
                        this.Z = v5;
                        this.c0 = v2;
                        this.b0 = v6;
                        v16 = v3;
                        this.d0 = 13;
                        a0 = a4;
                        if(b.b(b0, PlaylistId.MUSIC, this) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        s1 = s6;
                        goto label_1151;
                    }
                    v17 = v6;
                    c2 = c0;
                    p01 = p00;
                    s12 = s6;
                    goto label_1022;
                }
                break;
            }
            case 2: {
                v7 = this.c0;
                int v18 = this.Z;
                int v19 = this.Y;
                int v20 = this.X;
                int v21 = this.b0;
                boolean z5 = this.V;
                P0 p02 = (P0)this.S;
                Continuation continuation1 = (Continuation)this.N;
                object3 = this.M;
                devLog2 = (DevLog)this.I;
                C c3 = (C)this.G;
                String s13 = (String)this.E;
                b b3 = (b)this.D;
                l01 = this.B;
                s5 = this.w;
                mutex2 = this.r;
                try {
                    d5.n.D(object0);
                    object5 = ((p)object0).d();
                    b2 = b3;
                    v5 = v18;
                    l00 = l01;
                    z4 = z5;
                    v12 = v21;
                    devLog1 = devLog2;
                    c0 = c3;
                    v2 = v7;
                    s9 = object3;
                    s = s13;
                    s8 = s5;
                    a3 = a0;
                    v13 = v20;
                    v4 = v19;
                    mutex1 = mutex2;
                    p00 = p02;
                }
                catch(Throwable throwable0) {
                label_242:
                    mutex1 = mutex2;
                    l00 = l01;
                    s1 = s5;
                    v2 = v7;
                    s3 = object3;
                    devLog1 = devLog2;
                    goto label_1151;
                }
                try {
                label_249:
                    if(p.c(object5)) {
                        if(b2.p.getValue() == PlaylistId.MUSIC || (!b2.i.a().b() || z4)) {
                            b2.h.r();
                            this.r = mutex1;
                            this.w = s8;
                            this.B = l00;
                            this.D = b2;
                            this.E = s;
                            this.G = c0;
                            this.I = devLog1;
                            this.M = s9;
                            this.N = null;
                            this.S = p00;
                            this.T = null;
                            this.X = v13;
                            this.Y = v4;
                            this.Z = v5;
                            this.c0 = v2;
                            c4 = c0;
                            v24 = v12;
                            this.b0 = v24;
                            p03 = p00;
                            this.d0 = 3;
                            a1 = a3;
                            if(b.b(b2, PlaylistId.SMART, this) == a1) {
                                return a1;
                            }
                            goto label_355;
                        }
                        else {
                            b5 = b2;
                            s19 = s;
                            v25 = v12;
                            s20 = s9;
                            p04 = p00;
                            v26 = v5;
                            v27 = v4;
                            s21 = s8;
                            c5 = c0;
                        }
                        goto label_370;
                    }
                    else {
                        throwable1 = p.a(object5);
                        LogU logU0 = b2.l;
                        if(throwable1 == null) {
                            logU1 = logU0;
                            s14 = null;
                        }
                        else {
                            logU1 = logU0;
                            s14 = throwable1.getMessage();
                        }
                        LogU.error$default(logU1, "Fail to setSmartPlaylistUseByUserAction true. - " + s14, null, false, 6, null);
                        String s15 = throwable1 == null ? null : throwable1.getMessage();
                        q.g(("restoreSmartPlaylistFailed from:setSmartPlaylistUseByUserAction(), exception:" + s15), "message");
                        String s16 = "memberKey:" + s + "\n" + ("restoreSmartPlaylistFailed from:setSmartPlaylistUseByUserAction(), exception:" + s15);
                        q.f(s16, "toString(...)");
                        Reporter.createReporter(Type.PLAYLIST, LogLevel.INFO).setMessage(s16).report();
                        this.r = mutex1;
                        this.w = s8;
                        this.B = l00;
                        this.D = b2;
                        this.E = s;
                        this.G = devLog1;
                        this.I = s9;
                        this.M = null;
                        this.N = null;
                        this.S = null;
                        this.T = throwable1;
                        this.X = v13;
                        this.Y = v4;
                        this.Z = v5;
                        this.c0 = v2;
                        v22 = v12;
                        this.b0 = v22;
                        this.d0 = 11;
                        a0 = a3;
                        if(p00.M(this) == a0) {
                            return a0;
                        }
                        b4 = b2;
                        s17 = s;
                        devLog3 = devLog1;
                        s18 = s8;
                        v23 = v13;
                        goto label_926;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    s1 = s8;
                    goto label_1150;
                }
            }
            case 3: {
                int v28 = this.b0;
                long v29 = this.c0;
                int v30 = this.Z;
                int v31 = this.Y;
                int v32 = this.X;
                P0 p05 = (P0)this.S;
                Continuation continuation2 = (Continuation)this.N;
                object6 = this.M;
                devLog4 = (DevLog)this.I;
                c4 = (C)this.G;
                String s22 = (String)this.E;
                b2 = (b)this.D;
                v33 = v29;
                s23 = this.w;
                l02 = this.B;
                mutex3 = this.r;
                try {
                    d5.n.D(object0);
                    p03 = p05;
                    mutex1 = mutex3;
                    v5 = v30;
                    s9 = object6;
                    v4 = v31;
                    s = s22;
                    s8 = s23;
                    a1 = a0;
                    v13 = v32;
                    l00 = l02;
                    devLog1 = devLog4;
                    v24 = v28;
                    v2 = v33;
                }
                catch(Throwable throwable0) {
                    goto label_437;
                }
                try {
                label_355:
                    c4.a = true;
                    b5 = b2;
                    a3 = a1;
                    v25 = v24;
                    v26 = v5;
                    v27 = v4;
                    s21 = s8;
                    c5 = c4;
                    s19 = s;
                    s20 = s9;
                    p04 = p03;
                }
                catch(Throwable throwable0) {
                    s1 = s8;
                    goto label_1150;
                }
                try {
                label_370:
                    this.r = mutex1;
                    this.w = s21;
                    this.B = l00;
                    this.D = b5;
                    this.E = s19;
                    this.G = c5;
                    this.I = devLog1;
                    this.M = s20;
                    this.N = null;
                    this.S = p04;
                    this.T = null;
                    this.X = v13;
                    this.Y = v27;
                    this.Z = v26;
                    this.c0 = v2;
                    this.b0 = v25;
                    this.d0 = 4;
                    if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s19, true, this) == a3) {
                        return a3;
                    }
                }
                catch(Throwable throwable0) {
                    s3 = s20;
                    s1 = s21;
                    goto label_1151;
                }
                a5 = a3;
                c6 = c5;
                b6 = b5;
                p06 = p04;
                s9 = s20;
                devLog3 = devLog1;
                v34 = v13;
                v35 = v26;
                v36 = v25;
                goto label_443;
            }
            case 4: {
                int v37 = this.b0;
                long v38 = this.c0;
                int v39 = this.Z;
                int v40 = this.Y;
                int v41 = this.X;
                P0 p07 = (P0)this.S;
                Continuation continuation3 = (Continuation)this.N;
                object6 = this.M;
                devLog4 = (DevLog)this.I;
                C c7 = (C)this.G;
                String s24 = (String)this.E;
                b b7 = (b)this.D;
                v33 = v38;
                s23 = this.w;
                l02 = this.B;
                mutex3 = this.r;
                try {
                    d5.n.D(object0);
                    b6 = b7;
                    a5 = a0;
                    s19 = s24;
                    v35 = v39;
                    v27 = v40;
                    p06 = p07;
                    s9 = object6;
                    devLog3 = devLog4;
                    mutex1 = mutex3;
                    s21 = s23;
                    v36 = v37;
                    v34 = v41;
                    l00 = l02;
                    c6 = c7;
                    v2 = v33;
                }
                catch(Throwable throwable0) {
                label_437:
                    mutex1 = mutex3;
                    s1 = s23;
                    s3 = object6;
                    devLog1 = devLog4;
                    l00 = l02;
                    v2 = v33;
                    goto label_1151;
                }
                try {
                label_443:
                    b6.r.setValue(f.a(true));
                    EventBusHelper.post(EventSongPlaylistViewFocus.INSTANCE);
                }
                catch(Throwable throwable0) {
                    s3 = s9;
                    devLog1 = devLog3;
                    s1 = s21;
                    goto label_1151;
                }
                try {
                    if(!b6.i.a().b()) {
                        goto label_452;
                    }
                    b8 = b6;
                    a6 = a5;
                    v42 = v36;
                    throw new IllegalArgumentException("Failed requirement.");
                }
                catch(Throwable throwable2) {
                    b8 = b6;
                    v42 = v36;
                    a6 = a5;
                    goto label_501;
                }
                try {
                label_452:
                    PlaylistId playlistId0 = (PlaylistId)b6.p.getValue();
                }
                catch(Throwable throwable2) {
                    b9 = b6;
                    goto label_485;
                }
                try {
                    b6.f.getClass();
                    if(c.b(playlistId0)) {
                        goto label_459;
                    }
                    b8 = b6;
                    a6 = a5;
                    v42 = v36;
                    throw new IllegalArgumentException("Failed requirement.");
                }
                catch(Throwable throwable2) {
                    b9 = b6;
                    goto label_485;
                }
                try {
                label_459:
                    this.r = mutex1;
                    this.w = s21;
                    this.B = l00;
                    this.D = b6;
                    this.E = c6;
                    this.G = devLog3;
                    this.I = s9;
                    b9 = b6;
                }
                catch(Throwable throwable2) {
                    b9 = b6;
                    goto label_485;
                }
                try {
                    this.M = null;
                    this.N = p06;
                    this.S = null;
                    this.T = null;
                    this.X = v34;
                    this.Y = v27;
                    this.Z = v35;
                    this.c0 = v2;
                    this.b0 = v36;
                    this.d0 = 5;
                    object7 = b6.f.a(s19, this);
                    a6 = a5;
                    goto label_490;
                }
                catch(Throwable throwable2) {
                }
            label_485:
                a6 = a5;
                p08 = p06;
                b10 = b9;
                s25 = s21;
                c8 = c6;
                goto label_562;
            label_490:
                if(object7 != a6) {
                    devLog5 = devLog3;
                    v43 = v35;
                    c8 = c6;
                    goto label_549;
                }
                return a6;
                try {
                    b8 = b6;
                    a6 = a5;
                    v42 = v36;
                    throw new IllegalArgumentException("Failed requirement.");
                }
                catch(Throwable throwable2) {
                }
            label_501:
                p08 = p06;
                b10 = b8;
                s25 = s21;
                v36 = v42;
                c8 = c6;
                goto label_562;
            }
            case 5: {
                int v44 = this.b0;
                long v45 = this.c0;
                v43 = this.Z;
                int v46 = this.Y;
                int v47 = this.X;
                p08 = this.N;
                Mutex mutex4 = (Mutex)this.M;
                Object object8 = this.I;
                DevLog devLog6 = (DevLog)this.G;
                c8 = (C)this.E;
                b b11 = (b)this.D;
                L0 l03 = this.B;
                s25 = this.w;
                Mutex mutex5 = this.r;
                try {
                    d5.n.D(object0);
                    object7 = ((p)object0).d();
                    p06 = p08;
                    s21 = s25;
                    b9 = b11;
                    v27 = v46;
                    l00 = l03;
                    mutex1 = mutex5;
                    a6 = a0;
                    devLog5 = devLog6;
                    v2 = v45;
                    v36 = v44;
                    s9 = object8;
                    v34 = v47;
                }
                catch(Throwable throwable2) {
                    b10 = b11;
                    v27 = v46;
                    l00 = l03;
                    mutex1 = mutex5;
                    a6 = a0;
                    v35 = v43;
                    devLog3 = devLog6;
                    v2 = v45;
                    v36 = v44;
                    s9 = object8;
                    v34 = v47;
                    goto label_562;
                }
                try {
                label_549:
                    d5.n.D(object7);
                    i30 = (i3)object7;
                    c9 = c8;
                    s26 = s21;
                    p08 = p06;
                    b10 = b9;
                    goto label_572;
                }
                catch(Throwable throwable2) {
                    v35 = v43;
                    devLog3 = devLog5;
                    p08 = p06;
                    b10 = b9;
                    s25 = s21;
                }
                try {
                label_562:
                    i30 = d5.n.t(throwable2);
                    c9 = c8;
                    devLog5 = devLog3;
                    v43 = v35;
                    s26 = s25;
                }
                catch(Throwable throwable0) {
                    s3 = s9;
                    devLog1 = devLog3;
                    s1 = s25;
                    goto label_1151;
                }
            label_572:
                if(p.b(i30)) {
                    i30 = null;
                }
                if(i30 instanceof h3) {
                    try {
                        String s27 = ((h3)i30).c();
                        s28 = s9;
                        long v48 = ((h3)i30).b();
                        this.r = mutex1;
                        this.w = s26;
                        this.B = l00;
                        this.D = b10;
                        this.E = c9;
                        this.G = devLog5;
                        this.I = s9;
                        s28 = s9;
                        this.M = null;
                        this.N = null;
                        this.S = null;
                        this.T = null;
                        this.X = v34;
                        this.Y = v27;
                        this.Z = v43;
                        this.c0 = v2;
                        this.b0 = v36;
                        this.d0 = 6;
                        a1 = a6;
                        if(p08.V(s27, v48, this) == a1) {
                            return a1;
                        }
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog5;
                        s1 = s26;
                        s3 = s28;
                        goto label_1151;
                    }
                    c10 = c9;
                    devLog7 = devLog5;
                    b12 = b10;
                    mutex6 = mutex1;
                    v49 = v36;
                    s29 = s28;
                    goto label_680;
                }
                else {
                    a1 = a6;
                    if(i30 instanceof g3) {
                        try {
                            this.r = mutex1;
                            this.w = s26;
                            this.B = l00;
                            this.D = b10;
                            this.E = c9;
                            this.G = devLog5;
                            s30 = s9;
                            this.I = s30;
                            this.M = null;
                            this.N = null;
                            this.S = null;
                            this.T = i30;
                            this.X = v34;
                            this.Y = v27;
                            this.Z = v43;
                            this.c0 = v2;
                            this.b0 = v36;
                            this.d0 = 8;
                            object9 = b10.b.b(false, this);
                            goto label_638;
                        }
                        catch(Throwable throwable0) {
                            try {
                                s1 = s26;
                                s3 = s30;
                                devLog1 = devLog5;
                                goto label_1151;
                            label_638:
                                if(object9 != a1) {
                                    i31 = i30;
                                    a7 = a1;
                                    v50 = v34;
                                    s31 = s26;
                                    v51 = v43;
                                    v52 = v36;
                                    mutex7 = mutex1;
                                    c11 = c9;
                                    l04 = l00;
                                    devLog8 = devLog5;
                                    goto label_760;
                                label_650:
                                    v53 = v2;
                                    devLog3 = devLog5;
                                    s21 = s26;
                                    object12 = new Success(c9.a);
                                    break;
                                }
                                return a1;
                            }
                            catch(Throwable throwable0) {
                                v2 = v53;
                                s3 = s9;
                                devLog1 = devLog3;
                                s1 = s21;
                                goto label_1151;
                            }
                        }
                    }
                    else {
                        goto label_650;
                    }
                }
                break;
            }
            case 6: {
                int v54 = this.b0;
                long v55 = this.c0;
                int v56 = this.Z;
                int v57 = this.Y;
                int v58 = this.X;
                i3 i32 = (i3)this.T;
                Mutex mutex8 = (Mutex)this.M;
                s29 = this.I;
                devLog7 = (DevLog)this.G;
                C c12 = (C)this.E;
                b12 = (b)this.D;
                v59 = v55;
                s32 = this.w;
                l05 = this.B;
                mutex9 = this.r;
                try {
                    d5.n.D(object0);
                    v27 = v57;
                    v43 = v56;
                    v49 = v54;
                    v34 = v58;
                    l00 = l05;
                    s26 = s32;
                    a1 = a0;
                    mutex6 = mutex9;
                    c10 = c12;
                    v2 = v59;
                }
                catch(Throwable throwable0) {
                    goto label_1090;
                }
                try {
                label_680:
                    this.r = mutex6;
                    this.w = s26;
                    this.B = l00;
                    this.D = c10;
                    this.E = devLog7;
                    this.G = s29;
                    this.I = null;
                    this.M = null;
                    this.N = null;
                    this.S = null;
                    this.T = null;
                    this.X = v34;
                    this.Y = v27;
                    this.Z = v43;
                    this.c0 = v2;
                    this.b0 = v49;
                    this.d0 = 7;
                    if(b.b(b12, PlaylistId.SMART, this) != a1) {
                        goto label_705;
                    }
                    return a1;
                }
                catch(Throwable throwable0) {
                    s1 = s26;
                    s3 = s29;
                    devLog1 = devLog7;
                    mutex1 = mutex6;
                    goto label_1151;
                }
            label_705:
                v53 = v2;
                s9 = s29;
                devLog3 = devLog7;
                c9 = c10;
                mutex1 = mutex6;
                s21 = s26;
                goto label_882;
            }
            case 7: {
                v53 = this.c0;
                i3 i33 = (i3)this.S;
                ReentrantMutexContextKey reentrantMutexContextKey2 = (ReentrantMutexContextKey)this.M;
                Mutex mutex10 = (Mutex)this.I;
                s9 = this.G;
                devLog3 = (DevLog)this.E;
                c9 = (C)this.D;
                l00 = this.B;
                s21 = this.w;
                mutex1 = this.r;
                goto label_881;
            }
            case 8: {
                int v60 = this.b0;
                long v61 = this.c0;
                int v62 = this.Z;
                int v63 = this.Y;
                int v64 = this.X;
                i3 i34 = (i3)this.T;
                Mutex mutex11 = (Mutex)this.M;
                s30 = this.I;
                DevLog devLog9 = (DevLog)this.G;
                C c13 = (C)this.E;
                b b13 = (b)this.D;
                s31 = this.w;
                L0 l06 = this.B;
                Mutex mutex12 = this.r;
                try {
                    d5.n.D(object0);
                    v52 = v60;
                    a7 = a0;
                    c11 = c13;
                    v27 = v63;
                    mutex7 = mutex12;
                    v50 = v64;
                    devLog8 = devLog9;
                    object9 = object0;
                    b10 = b13;
                    v51 = v62;
                    i31 = i34;
                    l04 = l06;
                    v2 = v61;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex12;
                    s1 = s31;
                    s3 = s30;
                    devLog1 = devLog9;
                    l00 = l06;
                    v2 = v61;
                    goto label_1151;
                }
                try {
                label_760:
                    DrawerPlaylistInfo drawerPlaylistInfo0 = ((g3)i31).c();
                    String s33 = ((g3)i31).b();
                    s25 = s31;
                    mutex13 = mutex7;
                    long v65 = ((g3)i31).d();
                    this.r = mutex7;
                    this.w = s31;
                    this.B = l04;
                    this.D = b10;
                    this.E = c11;
                    this.G = devLog8;
                    this.I = s30;
                    this.M = null;
                    this.N = null;
                    this.S = null;
                    this.T = null;
                    this.X = v50;
                    this.Y = v27;
                    this.Z = v51;
                    this.c0 = v2;
                    this.b0 = v52;
                    this.d0 = 9;
                    s25 = s31;
                    a8 = a7;
                    mutex13 = mutex7;
                    object10 = ((u0)object9).N(drawerPlaylistInfo0, s33, v65, this);
                }
                catch(Throwable throwable0) {
                    try {
                        devLog1 = devLog8;
                        l00 = l04;
                        s3 = s30;
                        mutex1 = mutex13;
                        s1 = s25;
                    }
                    catch(Throwable throwable0) {
                        v2 = v53;
                        s3 = s9;
                        devLog1 = devLog3;
                        s1 = s21;
                    }
                    goto label_1151;
                }
                if(object10 == a8) {
                    return a8;
                }
                v53 = v2;
                s9 = s30;
                s34 = s25;
                v66 = v51;
                object11 = object10;
                b14 = b10;
                devLog7 = devLog8;
                l00 = l04;
                mutex1 = mutex13;
                v67 = v50;
                goto label_834;
            }
            case 9: {
                int v68 = this.b0;
                long v69 = this.c0;
                int v70 = this.Z;
                int v71 = this.Y;
                int v72 = this.X;
                u0 u00 = (u0)this.T;
                Mutex mutex14 = (Mutex)this.M;
                s29 = this.I;
                devLog7 = (DevLog)this.G;
                C c14 = (C)this.E;
                b14 = (b)this.D;
                v59 = v69;
                s32 = this.w;
                l05 = this.B;
                mutex9 = this.r;
                try {
                    d5.n.D(object0);
                    v52 = v68;
                    object11 = ((p)object0).d();
                    v27 = v71;
                    v66 = v70;
                    s9 = s29;
                    mutex1 = mutex9;
                    s34 = s32;
                    v53 = v59;
                    v67 = v72;
                    l00 = l05;
                    a8 = a0;
                    c11 = c14;
                }
                catch(Throwable throwable0) {
                    goto label_1090;
                }
            label_834:
                if(p.c(object11)) {
                    try {
                        this.r = mutex1;
                        this.w = s34;
                        this.B = l00;
                        this.D = c11;
                        this.E = devLog7;
                        this.G = s9;
                        this.I = null;
                        this.M = null;
                        this.N = null;
                        this.S = null;
                        this.T = null;
                        this.X = v67;
                        this.Y = v27;
                        this.Z = v66;
                        this.c0 = v53;
                        this.b0 = v52;
                        this.V = true;
                        this.d0 = 10;
                        if(b.b(b14, PlaylistId.DRAWER, this) != a8) {
                            c9 = c11;
                            devLog3 = devLog7;
                            s21 = s34;
                            goto label_882;
                        }
                        return a8;
                    }
                    catch(Throwable throwable0) {
                        try {
                            s1 = s34;
                            v2 = v53;
                            devLog1 = devLog7;
                            s3 = s9;
                            goto label_1151;
                        label_866:
                            c9 = c11;
                            devLog3 = devLog7;
                            s21 = s34;
                        }
                        catch(Throwable throwable0) {
                            v2 = v53;
                            s3 = s9;
                            devLog1 = devLog3;
                            s1 = s21;
                            goto label_1151;
                        }
                    }
                }
                else {
                    goto label_866;
                }
                object12 = new Success(c9.a);
                break;
            }
            case 10: {
                v53 = this.c0;
                i3 i35 = (i3)this.T;
                u0 u01 = (u0)this.S;
                ReentrantMutexContextKey reentrantMutexContextKey3 = (ReentrantMutexContextKey)this.M;
                Mutex mutex15 = (Mutex)this.I;
                s9 = this.G;
                devLog3 = (DevLog)this.E;
                c9 = (C)this.D;
                l00 = this.B;
                s21 = this.w;
                mutex1 = this.r;
                try {
                label_881:
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    goto label_1138;
                }
                try {
                label_882:
                    c9.a = true;
                    EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                    object12 = new Success(c9.a);
                    break;
                }
                catch(Throwable throwable0) {
                    v2 = v53;
                    s3 = s9;
                    devLog1 = devLog3;
                    s1 = s21;
                    goto label_1151;
                }
            }
            case 11: {
                int v73 = this.b0;
                long v74 = this.c0;
                int v75 = this.Z;
                int v76 = this.Y;
                int v77 = this.X;
                Throwable throwable3 = (Throwable)this.T;
                Mutex mutex16 = (Mutex)this.M;
                Object object13 = this.I;
                DevLog devLog10 = (DevLog)this.G;
                String s35 = (String)this.E;
                b b15 = (b)this.D;
                v59 = v74;
                String s36 = this.w;
                L0 l07 = this.B;
                Mutex mutex17 = this.r;
                try {
                    mutex1 = mutex17;
                    d5.n.D(object0);
                    v5 = v75;
                    s9 = object13;
                    v4 = v76;
                    devLog3 = devLog10;
                    b4 = b15;
                    s17 = s35;
                    v2 = v59;
                    v23 = v77;
                    l00 = l07;
                    s18 = s36;
                    throwable1 = throwable3;
                    mutex1 = mutex17;
                    v22 = v73;
                }
                catch(Throwable throwable0) {
                    s1 = s36;
                    s3 = object13;
                    devLog1 = devLog10;
                    l00 = l07;
                    v2 = v59;
                    goto label_1151;
                }
                try {
                label_926:
                    this.r = mutex1;
                    this.w = s18;
                    this.B = l00;
                    this.D = b4;
                    this.E = devLog3;
                    this.G = s9;
                    this.I = null;
                    this.M = null;
                    this.N = null;
                    this.S = throwable1;
                    this.T = null;
                    this.X = v23;
                    this.Y = v4;
                    this.Z = v5;
                    this.c0 = v2;
                    this.b0 = v22;
                    this.d0 = 12;
                    if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s17, false, this) != a0) {
                        throwable4 = throwable1;
                        b16 = b4;
                        s21 = s18;
                        goto label_967;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    s1 = s18;
                    s3 = s9;
                    goto label_1151;
                }
                throwable4 = throwable1;
                b16 = b4;
                s21 = s18;
                goto label_967;
            }
            case 12: {
                v53 = this.c0;
                throwable4 = (Throwable)this.S;
                ReentrantMutexContextKey reentrantMutexContextKey4 = (ReentrantMutexContextKey)this.M;
                Mutex mutex18 = (Mutex)this.I;
                s9 = this.G;
                devLog3 = (DevLog)this.E;
                b16 = (b)this.D;
                l00 = this.B;
                s21 = this.w;
                mutex1 = this.r;
                try {
                    d5.n.D(object0);
                    v2 = v53;
                }
                catch(Throwable throwable0) {
                    goto label_1138;
                }
                try {
                label_967:
                    b16.r.setValue(f.a(false));
                    if(!(throwable4 instanceof T2)) {
                        EventBusHelper.post(new EventSmartRestoreFailedDialog());
                    }
                    if(throwable4 == null) {
                        s37 = "unknown";
                    }
                    else {
                        s37 = throwable4.getMessage();
                        if(s37 == null) {
                            s37 = "unknown";
                        }
                    }
                    object12 = new Failure(s37);
                    v53 = v2;
                    break;
                }
                catch(Throwable throwable0) {
                }
                s3 = s9;
                devLog1 = devLog3;
                s1 = s21;
                goto label_1151;
            }
            case 13: {
                int v78 = this.b0;
                long v79 = this.c0;
                int v80 = this.Z;
                int v81 = this.Y;
                int v82 = this.X;
                P0 p09 = (P0)this.S;
                Continuation continuation4 = (Continuation)this.N;
                Object object14 = this.M;
                DevLog devLog11 = (DevLog)this.I;
                C c15 = (C)this.G;
                String s38 = (String)this.E;
                b b17 = (b)this.D;
                v33 = v79;
                s12 = this.w;
                L0 l08 = this.B;
                Mutex mutex19 = this.r;
                try {
                    mutex1 = mutex19;
                    d5.n.D(object0);
                    v17 = v78;
                    v5 = v80;
                    devLog1 = devLog11;
                    b0 = b17;
                    c2 = c15;
                    mutex1 = mutex19;
                    v4 = v81;
                    s = s38;
                    s3 = object14;
                    l00 = l08;
                    v16 = v82;
                    p01 = p09;
                    v2 = v33;
                }
                catch(Throwable throwable0) {
                    s1 = s12;
                    s3 = object14;
                    devLog1 = devLog11;
                    l00 = l08;
                    v2 = v33;
                    goto label_1151;
                }
            label_1022:
                c2.a = true;
                v15 = v17;
                a4 = a0;
                s11 = s12;
                p00 = p01;
                c0 = c2;
                s10 = s;
                devLog3 = devLog1;
                v14 = v16;
                try {
                label_1031:
                    this.r = mutex1;
                    this.w = s11;
                    this.B = l00;
                    this.D = b0;
                    this.E = s10;
                    this.G = c0;
                    this.I = devLog3;
                    this.M = s3;
                    this.N = null;
                    this.S = null;
                    this.X = v14;
                    this.Y = v4;
                    this.Z = v5;
                    this.c0 = v2;
                    this.b0 = v15;
                    this.d0 = 14;
                    if(p00.M(this) == a4) {
                        return a4;
                    }
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    s1 = s11;
                    goto label_1151;
                }
                a9 = a4;
                s32 = s11;
                b18 = b0;
                goto label_1097;
            }
            case 14: {
                int v83 = this.b0;
                long v84 = this.c0;
                int v85 = this.Z;
                int v86 = this.Y;
                int v87 = this.X;
                P0 p010 = (P0)this.S;
                Continuation continuation5 = (Continuation)this.N;
                s29 = this.M;
                devLog7 = (DevLog)this.I;
                C c16 = (C)this.G;
                String s39 = (String)this.E;
                b b19 = (b)this.D;
                v59 = v84;
                s32 = this.w;
                l05 = this.B;
                mutex9 = this.r;
                try {
                    d5.n.D(object0);
                    v4 = v86;
                    devLog3 = devLog7;
                    v14 = v87;
                    l00 = l05;
                    c0 = c16;
                    a9 = a0;
                    b18 = b19;
                    v5 = v85;
                    s10 = s39;
                    v2 = v59;
                    s3 = s29;
                    mutex1 = mutex9;
                    v15 = v83;
                    goto label_1097;
                }
                catch(Throwable throwable0) {
                label_1090:
                    s3 = s29;
                    devLog1 = devLog7;
                    l00 = l05;
                    mutex1 = mutex9;
                    s1 = s32;
                }
                v2 = v59;
                goto label_1151;
                try {
                label_1097:
                    this.r = mutex1;
                    this.w = s32;
                    this.B = l00;
                    this.D = b18;
                    this.E = c0;
                    this.G = devLog3;
                    this.I = s3;
                    this.M = null;
                    this.N = null;
                    this.S = null;
                    this.X = v14;
                    this.Y = v4;
                    this.Z = v5;
                    this.c0 = v2;
                    this.b0 = v15;
                    this.d0 = 15;
                    a1 = a9;
                    if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s10, false, this) != a1) {
                        s9 = s3;
                        c17 = c0;
                        s21 = s32;
                        goto label_1143;
                    }
                    return a1;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    s1 = s32;
                    goto label_1151;
                }
                s9 = s3;
                c17 = c0;
                s21 = s32;
                goto label_1143;
            }
            case 15: {
                v53 = this.c0;
                Mutex mutex20 = (Mutex)this.M;
                s9 = this.I;
                devLog3 = (DevLog)this.G;
                c17 = (C)this.E;
                b18 = (b)this.D;
                l00 = this.B;
                s21 = this.w;
                mutex1 = this.r;
                try {
                    d5.n.D(object0);
                    v2 = v53;
                }
                catch(Throwable throwable0) {
                label_1138:
                    s3 = s9;
                    devLog1 = devLog3;
                    v2 = v53;
                    s1 = s21;
                    goto label_1151;
                }
                try {
                label_1143:
                    b18.r.setValue(f.a(false));
                    EventBusHelper.post(EventSongPlaylistViewFocus.INSTANCE);
                    object12 = new Success(c17.a);
                    v53 = v2;
                    break;
                }
                catch(Throwable throwable0) {
                    s1 = s21;
                    devLog1 = devLog3;
                }
            label_1150:
                s3 = s9;
            label_1151:
                long v88 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s3);
                H0.b.t(v88, s1, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s3);
                H0.b.t(v88, s1, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog1);
                if(l00 != null) {
                    com.iloen.melon.utils.a.u(s3, " ", s1, l00, false);
                }
                throw throwable0;
            }
            case 16: {
                ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)this.I;
                Mutex mutex0 = (Mutex)this.G;
                DevLog devLog0 = (DevLog)this.D;
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v89 = System.currentTimeMillis() - v53;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s9);
        H0.b.t(v89, s21, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s9);
        H0.b.t(v89, s21, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog3);
        if(l00 != null) {
            com.iloen.melon.utils.a.u(s9, " ", s21, l00, false);
        }
        return object12;
    }
}

