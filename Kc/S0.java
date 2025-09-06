package kc;

import androidx.appcompat.app.o;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.l1;
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
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playlist.b;
import e.k;
import e1.u;
import ie.H;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import nc.u0;
import ne.a;
import oe.f;
import oe.i;
import sc.P0;
import sc.T2;
import va.e0;
import we.n;

public final class s0 extends i implements n {
    public Object B;
    public Object D;
    public Object E;
    public Object G;
    public Object I;
    public C M;
    public P0 N;
    public Object S;
    public boolean T;
    public boolean V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int b0;
    public long c0;
    public int d0;
    public final boolean e0;
    public final b f0;
    public final boolean g0;
    public Object r;
    public Object w;

    public s0(boolean z, b b0, boolean z1, Continuation continuation0) {
        this.e0 = z;
        this.f0 = b0;
        this.g0 = z1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s0(this.e0, this.f0, this.g0, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s59;
        String s58;
        long v125;
        long v120;
        L0 l015;
        int v119;
        b b22;
        int v118;
        int v117;
        Object object15;
        String s57;
        int v106;
        long v105;
        L0 l013;
        String s53;
        DevLog devLog14;
        int v104;
        String s52;
        long v103;
        String s50;
        int v92;
        Object object14;
        int v91;
        Mutex mutex20;
        a a12;
        boolean z21;
        int v90;
        int v89;
        Object object13;
        Mutex mutex19;
        Mutex mutex18;
        String s47;
        L0 l012;
        DevLog devLog13;
        String s46;
        String s44;
        L0 l011;
        DevLog devLog12;
        Object object12;
        String s43;
        int v77;
        long v76;
        int v75;
        DevLog devLog11;
        Mutex mutex17;
        a a11;
        boolean z18;
        int v74;
        int v73;
        String s42;
        String s41;
        int v72;
        i3 i31;
        int v71;
        int v70;
        String s40;
        int v69;
        boolean z17;
        a a10;
        int v68;
        int v67;
        b b15;
        String s39;
        a a9;
        i3 i30;
        int v65;
        boolean z16;
        int v64;
        a a8;
        int v63;
        DevLog devLog10;
        int v57;
        boolean z15;
        String s35;
        String s34;
        Object object9;
        P0 p05;
        boolean z14;
        String s33;
        b b13;
        int v56;
        Object object8;
        long v52;
        String s30;
        int v51;
        int v50;
        Mutex mutex14;
        b b11;
        String s29;
        a a7;
        int v49;
        boolean z11;
        int v48;
        StringBuilder stringBuilder0;
        String s27;
        String s26;
        LogU logU1;
        Throwable throwable2;
        String s25;
        String s24;
        int v47;
        P0 p03;
        L0 l09;
        Mutex mutex13;
        String s23;
        int v46;
        a a6;
        int v45;
        boolean z10;
        int v44;
        boolean z9;
        long v43;
        b b9;
        Object object5;
        Mutex mutex11;
        boolean z6;
        int v36;
        int v35;
        int v34;
        a a5;
        String s20;
        Object object4;
        int v33;
        P0 p01;
        Mutex mutex10;
        String s17;
        Mutex mutex8;
        L0 l06;
        b b7;
        long v26;
        String s16;
        a a4;
        Mutex mutex7;
        boolean z3;
        boolean z2;
        int v25;
        int v24;
        L0 l05;
        int v23;
        int v22;
        String s15;
        a a3;
        a a2;
        Object object2;
        String s14;
        int v21;
        int v15;
        DevLog devLog5;
        String s11;
        String s10;
        int v14;
        b b5;
        L0 l03;
        int v13;
        String s9;
        b b4;
        int v12;
        int v11;
        int v10;
        Mutex mutex5;
        int v9;
        int v8;
        int v7;
        long v6;
        b b3;
        String s8;
        DevLog devLog4;
        L0 l02;
        String s7;
        Mutex mutex4;
        long v5;
        L0 l01;
        a a1;
        int v4;
        DevLog devLog2;
        Mutex mutex2;
        C c1;
        String s6;
        int v3;
        int v2;
        int v1;
        String s5;
        Object object1;
        C c0;
        String s4;
        Mutex mutex1;
        String s3;
        DevLog devLog1;
        String s2;
        long v;
        boolean z;
        b b1;
        L0 l00;
        String s;
        a a0 = a.a;
        switch(this.d0) {
            case 0: {
                d5.n.D(object0);
                s = "";
                b b0 = this.f0;
                if(this.e0) {
                    String s1 = u.v(((e0)b0.g).j());
                    Mutex mutex0 = b0.s;
                    l00 = b0.j;
                    MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    LogU.debug$default(mutexLockUtil0.getLog(), o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : onLoginStateChanged-login"), null, false, 6, null);
                    DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                    ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : onLoginStateChanged-login", devLog0, mutex0);
                    g g0 = this.getContext().get(reentrantMutexContextKey0);
                    b1 = this.f0;
                    z = this.g0;
                    if(g0 == null) {
                        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                        q0 q00 = new q0(mutex0, null, l00, mutex0, devLog0, b1, s1, z);
                        this.r = null;
                        this.w = null;
                        this.B = null;
                        this.D = null;
                        this.E = null;
                        this.G = null;
                        this.I = null;
                        this.W = 0;
                        this.X = 0;
                        this.d0 = 14;
                        if(BuildersKt.withContext(reentrantMutexContextElement0, q00, this) == a0) {
                            return a0;
                        }
                    }
                    else {
                        v = System.currentTimeMillis();
                        s2 = "onLoginStateChanged-login";
                        if(l00 != null) {
                            try {
                                ((k8.b)l00).a(" onLoginStateChanged-login", true);
                            }
                            catch(Throwable throwable0) {
                                devLog1 = devLog0;
                                s3 = "onLoginStateChanged-login";
                                mutex1 = mutex0;
                                s4 = "";
                                goto label_1283;
                            }
                        }
                        try {
                            LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : onLoginStateChanged-login", null, false, 6, null);
                            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : onLoginStateChanged-login");
                            c0 = new C();
                            p0 p00 = new p0(c0, b1, null);
                            this.r = s1;
                            this.w = mutex0;
                            this.B = "onLoginStateChanged-login";
                            this.D = l00;
                            this.E = b1;
                            this.G = devLog0;
                            this.I = "";
                            this.M = c0;
                            this.T = z;
                            this.W = 0;
                            this.X = 0;
                            this.Y = 0;
                            this.c0 = v;
                            this.Z = 0;
                            this.d0 = 1;
                            object1 = b1.e.getUseSmartPlaylistOrSet(s1, p00, this);
                        }
                        catch(Throwable throwable0) {
                            devLog1 = devLog0;
                            s3 = "onLoginStateChanged-login";
                            mutex1 = mutex0;
                            s4 = "";
                            goto label_1283;
                        }
                        if(object1 == a0) {
                            return a0;
                        }
                        object0 = object1;
                        s5 = "";
                        v1 = 0;
                        v2 = 0;
                        v3 = 0;
                        s6 = s1;
                        c1 = c0;
                        mutex2 = mutex0;
                        devLog2 = devLog0;
                        v4 = 0;
                        goto label_227;
                    }
                }
                else {
                    a1 = a0;
                    Mutex mutex3 = b0.s;
                    l01 = b0.j;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex3.hashCode(), "ReentrantLock[", "]  try : onLoginStateChanged-logout"), null, false, 6, null);
                    DevLog devLog3 = DevLog.Companion.get("MutexLockUtil");
                    ReentrantMutexContextKey reentrantMutexContextKey1 = l1.b("ReentrantLock[", mutex3.hashCode(), "]  try : onLoginStateChanged-logout", devLog3, mutex3);
                    g g1 = this.getContext().get(reentrantMutexContextKey1);
                    MutexLockUtil mutexLockUtil1 = MutexLockUtil.INSTANCE;
                    b b2 = this.f0;
                    if(g1 == null) {
                        ReentrantMutexContextElement reentrantMutexContextElement1 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                        r0 r00 = new r0(mutex3, null, l01, mutex3, devLog3, b2);
                        this.r = null;
                        this.w = null;
                        this.B = null;
                        this.D = null;
                        this.E = null;
                        this.G = null;
                        this.I = null;
                        this.W = 0;
                        this.X = 0;
                        this.d0 = 19;
                        if(BuildersKt.withContext(reentrantMutexContextElement1, r00, this) == a1) {
                            return a1;
                        }
                    }
                    else {
                        v5 = System.currentTimeMillis();
                        if(l01 != null) {
                            try {
                                ((k8.b)l01).a(" onLoginStateChanged-logout", true);
                            }
                            catch(Throwable throwable1) {
                                goto label_160;
                            }
                        }
                        try {
                            LogU.debug$default(mutexLockUtil1.getLog(), "ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : onLoginStateChanged-logout", null, false, 6, null);
                            devLog3.put("ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : onLoginStateChanged-logout");
                            if(p.d0(k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.DRAWER}), b2.p.getValue())) {
                                goto label_143;
                            }
                            else if(b2.p.getValue() == PlaylistId.LIVE) {
                                goto label_107;
                            }
                            else {
                                goto label_133;
                            }
                            return H.a;
                        }
                        catch(Throwable throwable1) {
                            mutex4 = mutex3;
                            s7 = "onLoginStateChanged-logout";
                            l02 = l01;
                            devLog4 = devLog3;
                            goto label_1489;
                        }
                        try {
                        label_107:
                            b2.h.r();
                            this.r = mutex3;
                            this.w = "onLoginStateChanged-logout";
                            this.B = l01;
                            this.D = b2;
                            this.E = devLog3;
                            this.G = "";
                            this.I = null;
                            this.W = 0;
                            this.X = 0;
                            this.Y = 0;
                            this.c0 = v5;
                            this.Z = 0;
                            this.d0 = 16;
                            if(b.b(b2, PlaylistId.MUSIC, this) == a1) {
                                return a1;
                            }
                            s8 = "onLoginStateChanged-logout";
                            l02 = l01;
                            b3 = b2;
                            v6 = v5;
                            v7 = 0;
                            v8 = 0;
                            v9 = 0;
                            mutex5 = mutex3;
                            devLog4 = devLog3;
                            v10 = 0;
                            goto label_1363;
                        label_133:
                            v6 = v5;
                            v11 = 0;
                            v12 = 0;
                            mutex5 = mutex3;
                            b4 = b2;
                            devLog4 = devLog3;
                            v10 = 0;
                            s9 = "onLoginStateChanged-logout";
                            v13 = 0;
                            goto label_1376;
                        label_143:
                            b2.h.r();
                            this.r = mutex3;
                            this.w = "onLoginStateChanged-logout";
                            this.B = l01;
                            this.D = b2;
                            this.E = devLog3;
                            this.G = "";
                            this.I = null;
                            this.W = 0;
                            this.X = 0;
                            this.Y = 0;
                            this.c0 = v5;
                            this.Z = 0;
                            this.d0 = 15;
                            if(b.b(b2, PlaylistId.MUSIC, this) == a1) {
                                return a1;
                            }
                        }
                        catch(Throwable throwable1) {
                        label_160:
                            mutex4 = mutex3;
                            s7 = "onLoginStateChanged-logout";
                            l02 = l01;
                            devLog4 = devLog3;
                            goto label_1489;
                        }
                        mutex4 = mutex3;
                        l03 = l01;
                        b5 = b2;
                        v6 = v5;
                        v14 = 0;
                        v9 = 0;
                        s10 = "onLoginStateChanged-logout";
                        s11 = "";
                        devLog5 = devLog3;
                        v13 = 0;
                        v15 = 0;
                        goto label_1330;
                    }
                }
                return H.a;
            }
            case 1: {
                int v16 = this.Y;
                int v17 = this.X;
                int v18 = this.W;
                int v19 = this.Z;
                boolean z1 = this.T;
                C c2 = this.M;
                long v20 = this.c0;
                s5 = this.I;
                devLog2 = (DevLog)this.G;
                b b6 = (b)this.E;
                L0 l04 = (L0)this.D;
                String s12 = (String)this.B;
                Mutex mutex6 = (Mutex)this.w;
                String s13 = (String)this.r;
                try {
                    l00 = l04;
                    d5.n.D(object0);
                    v2 = v19;
                    v3 = v16;
                    s6 = s13;
                    c1 = c2;
                    s2 = s12;
                    v4 = v18;
                    l00 = l04;
                    v1 = v17;
                    b1 = b6;
                    mutex2 = mutex6;
                    z = z1;
                    v = v20;
                }
                catch(Throwable throwable0) {
                    s3 = s12;
                    mutex1 = mutex6;
                    devLog1 = devLog2;
                    s4 = s5;
                    v = v20;
                    goto label_1283;
                }
                try {
                label_227:
                    v21 = !c1.a;
                    if(((Boolean)object0).booleanValue()) {
                        goto label_235;
                    }
                    else {
                        goto label_275;
                    }
                    goto label_1272;
                }
                catch(Throwable throwable0) {
                    s14 = s5;
                    s3 = s2;
                    mutex1 = mutex2;
                    devLog1 = devLog2;
                    s4 = s14;
                    goto label_1283;
                }
                try {
                label_235:
                    this.r = s6;
                    this.w = mutex2;
                    this.B = s2;
                    this.D = l00;
                    this.E = b1;
                    this.G = devLog2;
                    this.I = s5;
                    this.M = null;
                    this.T = z;
                    this.W = v4;
                    this.X = v1;
                    this.Y = v3;
                    this.c0 = v;
                    this.Z = v2;
                    this.V = true;
                    this.b0 = v21;
                    this.d0 = 2;
                    object2 = b1.b.h(false, this);
                    a2 = a0;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex2;
                    s3 = s2;
                    devLog1 = devLog2;
                    s4 = s5;
                    goto label_1283;
                }
                if(object2 == a2) {
                    return a2;
                }
                a3 = a2;
                s15 = s2;
                devLog1 = devLog2;
                s4 = s5;
                v22 = v21;
                object0 = object2;
                v23 = v3;
                l05 = l00;
                v24 = v2;
                v25 = v1;
                z2 = z;
                z3 = true;
                goto label_365;
                try {
                label_275:
                    if(b1.p.getValue() == PlaylistId.SMART) {
                        goto label_282;
                    }
                    else {
                        goto label_319;
                    }
                    goto label_1272;
                }
                catch(Throwable throwable0) {
                    s14 = s5;
                    s3 = s2;
                    mutex1 = mutex2;
                    devLog1 = devLog2;
                    s4 = s14;
                    goto label_1283;
                }
                try {
                label_282:
                    s14 = s5;
                    mutex7 = mutex2;
                    b1.h.r();
                    this.r = s6;
                    this.w = mutex2;
                    this.B = s2;
                    this.D = l00;
                    this.E = b1;
                    this.G = devLog2;
                    s14 = s5;
                    this.I = s14;
                    mutex7 = mutex2;
                    this.M = null;
                    this.W = v4;
                    this.X = v1;
                    this.Y = v3;
                    this.c0 = v;
                    this.Z = v2;
                    this.T = false;
                    this.b0 = v21;
                    this.d0 = 13;
                    a4 = a0;
                    if(b.b(b1, PlaylistId.MUSIC, this) == a4) {
                        return a4;
                    }
                }
                catch(Throwable throwable0) {
                    s3 = s2;
                    mutex1 = mutex7;
                    devLog1 = devLog2;
                    s4 = s14;
                    goto label_1283;
                }
                s16 = s14;
                v26 = v;
                b7 = b1;
                l06 = l00;
                mutex8 = mutex7;
                s17 = s2;
                goto label_1260;
            label_319:
                s16 = s5;
                v26 = v;
                l06 = l00;
                mutex8 = mutex2;
                goto label_1262;
            }
            case 2: {
                int v27 = this.Z;
                long v28 = this.c0;
                int v29 = this.Y;
                int v30 = this.b0;
                int v31 = this.X;
                int v32 = this.W;
                boolean z4 = this.V;
                Object object3 = this.I;
                boolean z5 = this.T;
                DevLog devLog6 = (DevLog)this.G;
                b b8 = (b)this.E;
                L0 l07 = (L0)this.D;
                String s18 = (String)this.B;
                Mutex mutex9 = (Mutex)this.w;
                String s19 = (String)this.r;
                try {
                    s4 = object3;
                    devLog1 = devLog6;
                    d5.n.D(object0);
                    s6 = s19;
                    v23 = v29;
                    s15 = s18;
                    z3 = z4;
                    mutex2 = mutex9;
                    a3 = a0;
                    z2 = z5;
                    devLog1 = devLog6;
                    s4 = object3;
                    v25 = v31;
                    v22 = v30;
                    l05 = l07;
                    v4 = v32;
                    v = v28;
                    b1 = b8;
                    v24 = v27;
                }
                catch(Throwable throwable0) {
                    s3 = s18;
                    mutex1 = mutex9;
                    v = v28;
                    l00 = l07;
                    goto label_1283;
                }
                try {
                label_365:
                    mutex10 = mutex2;
                    p01 = (P0)object0;
                    this.r = s6;
                    this.w = mutex2;
                    this.B = s15;
                    this.D = l05;
                    this.E = b1;
                    this.G = devLog1;
                    this.I = s4;
                    mutex10 = mutex2;
                    this.M = null;
                    this.N = p01;
                    this.T = z2;
                    this.W = v4;
                    this.X = v25;
                    this.Y = v23;
                    this.c0 = v;
                    this.Z = v24;
                    this.V = z3;
                    this.b0 = v22;
                    v33 = v22;
                    this.d0 = 3;
                    object4 = p01.U(s6, v22 != 0, this);
                    a2 = a3;
                }
                catch(Throwable throwable0) {
                    s20 = s15;
                    l00 = l05;
                    mutex1 = mutex10;
                    s3 = s20;
                    goto label_1283;
                }
                if(object4 != a2) {
                    a5 = a2;
                    v34 = v25;
                    v35 = v4;
                    v36 = v23;
                    z6 = z3;
                    mutex11 = mutex10;
                    object5 = object4;
                    b9 = b1;
                    s17 = s15;
                    goto label_451;
                }
                return a2;
            }
            case 3: {
                int v37 = this.Z;
                long v38 = this.c0;
                int v39 = this.Y;
                int v40 = this.b0;
                int v41 = this.X;
                int v42 = this.W;
                boolean z7 = this.T;
                boolean z8 = this.V;
                Object object6 = this.I;
                P0 p02 = this.N;
                DevLog devLog7 = (DevLog)this.G;
                b b10 = (b)this.E;
                L0 l08 = (L0)this.D;
                String s21 = (String)this.B;
                Mutex mutex12 = (Mutex)this.w;
                String s22 = (String)this.r;
                try {
                    d5.n.D(object0);
                    s4 = object6;
                    devLog1 = devLog7;
                    object5 = ((ie.p)object0).d();
                    s6 = s22;
                    b9 = b10;
                    v36 = v39;
                    v34 = v41;
                    v33 = v40;
                    l05 = l08;
                    mutex11 = mutex12;
                    z6 = z8;
                    devLog1 = devLog7;
                    z2 = z7;
                    s4 = object6;
                    v35 = v42;
                    v = v38;
                    s17 = s21;
                    v24 = v37;
                    a5 = a0;
                    p01 = p02;
                }
                catch(Throwable throwable0) {
                    s3 = s21;
                    mutex1 = mutex12;
                    v = v38;
                    l00 = l08;
                    goto label_1283;
                }
            label_451:
                if(ie.p.c(object5)) {
                    try {
                        Object object7 = b9.p.getValue();
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex11;
                        s3 = s17;
                        l00 = l05;
                        goto label_1283;
                    }
                    try {
                        if(object7 == PlaylistId.MUSIC) {
                            b9.h.r();
                            this.r = s6;
                            this.w = mutex11;
                            this.B = s17;
                            this.D = l05;
                            this.E = b9;
                            this.G = devLog1;
                            this.I = s4;
                            this.M = null;
                            this.N = p01;
                            this.T = z2;
                            this.W = v35;
                            this.X = v34;
                            this.Y = v36;
                            v43 = v;
                            goto label_473;
                        }
                        else {
                            goto label_490;
                        }
                        goto label_608;
                    }
                    catch(Throwable throwable0) {
                        v43 = v;
                        goto label_552;
                    }
                    try {
                    label_473:
                        this.c0 = v43;
                        z9 = z2;
                        v44 = v24;
                        this.Z = v44;
                        z10 = z6;
                        this.V = z10;
                        v45 = v36;
                        this.b0 = v33;
                        this.d0 = 4;
                        a6 = a5;
                        if(b.b(b9, PlaylistId.SMART, this) != a6) {
                            goto label_484;
                        }
                        return a6;
                    }
                    catch(Throwable throwable0) {
                        goto label_552;
                    }
                label_484:
                    v46 = v34;
                    s23 = s17;
                    mutex13 = mutex11;
                    l09 = l05;
                    p03 = p01;
                    goto label_602;
                    try {
                    label_490:
                        z10 = z6;
                        v45 = v36;
                        v43 = v;
                        z9 = z2;
                        v47 = v24;
                        s24 = s6;
                        mutex8 = mutex11;
                        s25 = s17;
                        p03 = p01;
                        v46 = v34;
                        goto label_608;
                    }
                    catch(Throwable throwable0) {
                        v43 = v;
                        goto label_552;
                    }
                }
                else {
                    try {
                        v43 = v;
                        throwable2 = ie.p.a(object5);
                        LogU logU0 = b9.l;
                        if(throwable2 == null) {
                            logU1 = logU0;
                            s26 = null;
                        }
                        else {
                            logU1 = logU0;
                            s26 = throwable2.getMessage();
                        }
                        LogU.error$default(logU1, "Fail to restoreSmartPlaylist onLogin() - " + s26, null, false, 6, null);
                        s27 = throwable2 == null ? null : throwable2.getMessage();
                        q.g(("restoreSmartPlaylistFailed from:onLogin(), exception:" + s27), "message");
                        stringBuilder0 = new StringBuilder();
                    }
                    catch(Throwable throwable0) {
                        goto label_552;
                    }
                    try {
                        stringBuilder0.append("memberKey:" + s6);
                        stringBuilder0.append("\n");
                        stringBuilder0.append("restoreSmartPlaylistFailed from:onLogin(), exception:" + s27);
                        String s28 = stringBuilder0.toString();
                        q.f(s28, "toString(...)");
                        Reporter.createReporter(Type.PLAYLIST, LogLevel.INFO).setMessage(s28).report();
                        this.r = s6;
                        this.w = mutex11;
                        this.B = s17;
                        this.D = l05;
                        this.E = b9;
                        this.G = devLog1;
                        this.I = s4;
                        this.M = null;
                        this.N = null;
                        this.S = throwable2;
                        this.W = v35;
                        this.X = v34;
                        v48 = v36;
                        this.Y = v48;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex11;
                        v = v43;
                        s3 = s17;
                        l00 = l05;
                        goto label_1283;
                    }
                    try {
                        this.c0 = v43;
                        this.Z = v24;
                        z11 = z6;
                        this.T = z11;
                        this.b0 = v33;
                        v49 = v33;
                        this.d0 = 11;
                        a4 = a5;
                        if(p01.M(this) == a4) {
                            return a4;
                        }
                        goto label_555;
                    }
                    catch(Throwable throwable0) {
                    }
                label_552:
                    mutex1 = mutex11;
                    v = v43;
                    s3 = s17;
                    l00 = l05;
                    goto label_1283;
                label_555:
                    a7 = a4;
                    s29 = s6;
                    b11 = b9;
                    mutex14 = mutex11;
                    v50 = v24;
                    v51 = v35;
                    s30 = s4;
                    v52 = v43;
                    goto label_1150;
                }
                goto label_1272;
            }
            case 4: {
                v44 = this.Z;
                v52 = this.c0;
                int v53 = this.Y;
                v46 = this.X;
                int v54 = this.W;
                int v55 = this.b0;
                boolean z12 = this.T;
                boolean z13 = this.V;
                object8 = this.I;
                P0 p04 = this.N;
                DevLog devLog8 = (DevLog)this.G;
                b b12 = (b)this.E;
                l09 = (L0)this.D;
                String s31 = (String)this.B;
                Mutex mutex15 = (Mutex)this.w;
                String s32 = (String)this.r;
                try {
                    devLog1 = devLog8;
                    d5.n.D(object0);
                    devLog1 = devLog8;
                    v45 = v53;
                    z9 = z12;
                    s6 = s32;
                    v33 = v55;
                    b9 = b12;
                    s4 = object8;
                    v35 = v54;
                    p03 = p04;
                    a6 = a0;
                    z10 = z13;
                    mutex13 = mutex15;
                    s23 = s31;
                    v43 = v52;
                }
                catch(Throwable throwable0) {
                    l00 = l09;
                    s3 = s31;
                    mutex1 = mutex15;
                    v103 = v52;
                    s4 = object8;
                    goto label_1282;
                }
            label_602:
                v47 = v44;
                s24 = s6;
                a5 = a6;
                l05 = l09;
                mutex8 = mutex13;
                s25 = s23;
                try {
                label_608:
                    v56 = v45;
                    b9.r.setValue(f.a(true));
                }
                catch(Throwable throwable0) {
                    s3 = s25;
                    v = v43;
                    mutex1 = mutex8;
                    l00 = l05;
                    goto label_1283;
                }
                if(!z9) {
                    try {
                        PlaylistId playlistId0 = (PlaylistId)b9.p.getValue();
                    }
                    catch(Throwable throwable3) {
                        goto label_648;
                    }
                    try {
                        b9.f.getClass();
                        if(c.b(playlistId0)) {
                            goto label_626;
                        }
                        goto label_667;
                    }
                    catch(Throwable throwable3) {
                        b13 = b9;
                        s33 = s4;
                        z14 = z10;
                        p05 = p03;
                        a4 = a5;
                        s34 = s24;
                        z15 = z14;
                        goto label_740;
                    }
                    try {
                    label_626:
                        this.r = s24;
                        this.w = mutex8;
                        this.B = s25;
                        this.D = l05;
                        b13 = b9;
                        this.E = b13;
                        this.G = devLog1;
                        this.I = s4;
                        s33 = s4;
                        this.M = null;
                        this.N = p03;
                        this.W = v35;
                        this.X = v46;
                        this.Y = v56;
                        this.c0 = v43;
                        this.Z = v47;
                        z14 = z10;
                        this.T = z14;
                        p05 = p03;
                        this.b0 = v33;
                    }
                    catch(Throwable throwable3) {
                    label_648:
                        b13 = b9;
                        s33 = s4;
                        z14 = z10;
                        p05 = p03;
                        a4 = a5;
                        s34 = s24;
                        z15 = z14;
                        goto label_740;
                    }
                    try {
                        this.d0 = 5;
                        object9 = b9.f.a(s24, this);
                        a4 = a5;
                    }
                    catch(Throwable throwable3) {
                        a4 = a5;
                        s34 = s24;
                        z15 = z14;
                        goto label_740;
                    }
                    if(object9 == a4) {
                        return a4;
                    }
                    s35 = s24;
                    z15 = z14;
                    v57 = v56;
                    goto label_726;
                }
                try {
                label_667:
                    b13 = b9;
                    s33 = s4;
                    z14 = z10;
                    p05 = p03;
                    a4 = a5;
                    s34 = s24;
                    throw new IllegalArgumentException("Failed requirement.");
                }
                catch(Throwable throwable3) {
                }
                z15 = z14;
                goto label_740;
            }
            case 5: {
                z15 = this.T;
                int v58 = this.Z;
                long v59 = this.c0;
                v57 = this.Y;
                int v60 = this.X;
                int v61 = this.b0;
                int v62 = this.W;
                P0 p06 = this.N;
                Object object10 = this.I;
                DevLog devLog9 = (DevLog)this.G;
                b b14 = (b)this.E;
                L0 l010 = (L0)this.D;
                String s36 = (String)this.B;
                Mutex mutex16 = (Mutex)this.w;
                String s37 = (String)this.r;
                try {
                    d5.n.D(object0);
                    object9 = ((ie.p)object0).d();
                    s35 = s37;
                    b13 = b14;
                    devLog1 = devLog9;
                    s33 = object10;
                    a4 = a0;
                    v47 = v58;
                    v35 = v62;
                    v33 = v61;
                    l05 = l010;
                    p05 = p06;
                    s25 = s36;
                    v43 = v59;
                    mutex8 = mutex16;
                    v46 = v60;
                }
                catch(Throwable throwable3) {
                    s34 = s37;
                    v56 = v57;
                    devLog10 = devLog9;
                    b13 = b14;
                    s33 = object10;
                    a4 = a0;
                    v47 = v58;
                    v35 = v62;
                    v33 = v61;
                    l05 = l010;
                    p05 = p06;
                    s25 = s36;
                    v43 = v59;
                    mutex8 = mutex16;
                    v46 = v60;
                    goto label_741;
                }
                try {
                label_726:
                    d5.n.D(object9);
                    s17 = s25;
                    v63 = v46;
                    a8 = a4;
                    v64 = v35;
                    z16 = z15;
                    v65 = v33;
                    i30 = (i3)object9;
                    s29 = s35;
                    v56 = v57;
                    goto label_756;
                }
                catch(Throwable throwable3) {
                    s34 = s35;
                    v56 = v57;
                }
            label_740:
                devLog10 = devLog1;
                try {
                label_741:
                    i30 = d5.n.t(throwable3);
                    s29 = s34;
                    a8 = a4;
                    v64 = v35;
                    z16 = z15;
                    v65 = v33;
                    s17 = s25;
                    v63 = v46;
                    devLog1 = devLog10;
                }
                catch(Throwable throwable0) {
                    s3 = s25;
                    v = v43;
                    devLog1 = devLog10;
                    s4 = s33;
                    mutex1 = mutex8;
                    l00 = l05;
                    goto label_1283;
                }
                try {
                label_756:
                    s4 = s33;
                    if(ie.p.b(i30)) {
                        i30 = null;
                    }
                    if(i30 instanceof h3) {
                        String s38 = ((h3)i30).c();
                        long v66 = ((h3)i30).b();
                        this.r = s29;
                        this.w = mutex8;
                        this.B = s17;
                        this.D = l05;
                        this.E = b13;
                        this.G = devLog1;
                        this.I = s4;
                        s33 = s4;
                        goto label_775;
                    }
                    else {
                        goto label_799;
                    }
                    goto label_1272;
                }
                catch(Throwable throwable0) {
                    v = v43;
                    s3 = s17;
                    mutex1 = mutex8;
                    l00 = l05;
                    goto label_1283;
                }
                try {
                label_775:
                    this.M = null;
                    this.N = null;
                    this.S = null;
                    this.W = v64;
                    this.X = v63;
                    this.Y = v56;
                    this.c0 = v43;
                    this.Z = v47;
                    this.T = z16;
                    this.b0 = v65;
                    this.d0 = 6;
                    a9 = a8;
                    if(p05.V(s38, v66, this) == a9) {
                        return a9;
                    }
                    s39 = s29;
                    b15 = b13;
                    v67 = v63;
                    v68 = v56;
                    a10 = a9;
                    z17 = z16;
                    v69 = v65;
                    s40 = s33;
                    v70 = v47;
                    v71 = v64;
                    goto label_881;
                label_799:
                    a9 = a8;
                    if(i30 instanceof g3) {
                        this.r = s29;
                        this.w = mutex8;
                        this.B = s17;
                        this.D = l05;
                        this.E = b13;
                        this.G = devLog1;
                        this.I = s4;
                        s33 = s4;
                        this.M = null;
                        this.N = null;
                        this.S = i30;
                        this.W = v64;
                        this.X = v63;
                        this.Y = v56;
                        this.c0 = v43;
                        this.Z = v47;
                        this.T = z16;
                        this.b0 = v65;
                        this.d0 = 8;
                        Object object11 = b13.b.b(false, this);
                        if(object11 != a9) {
                            i31 = i30;
                            v72 = v56;
                            s41 = s17;
                            s42 = s33;
                            v73 = v64;
                            v74 = v63;
                            z18 = z16;
                            a11 = a9;
                            mutex17 = mutex8;
                            devLog11 = devLog1;
                            v75 = v47;
                            v76 = v43;
                            v77 = v65;
                            s43 = s29;
                            object12 = object11;
                            goto label_959;
                        }
                        return a9;
                    }
                    else {
                        v26 = v43;
                        devLog2 = devLog1;
                        l06 = l05;
                        s16 = s4;
                    }
                    goto label_1272;
                }
                catch(Throwable throwable0) {
                    v = v43;
                    s3 = s17;
                }
                s4 = s33;
                mutex1 = mutex8;
                l00 = l05;
                goto label_1283;
            }
            case 6: {
                boolean z19 = this.T;
                int v78 = this.Z;
                v52 = this.c0;
                int v79 = this.Y;
                int v80 = this.X;
                int v81 = this.W;
                int v82 = this.b0;
                i3 i32 = (i3)this.S;
                object8 = this.I;
                devLog12 = (DevLog)this.G;
                b b16 = (b)this.E;
                l011 = (L0)this.D;
                s44 = (String)this.B;
                mutex1 = (Mutex)this.w;
                String s45 = (String)this.r;
                try {
                    d5.n.D(object0);
                    a10 = a0;
                    s39 = s45;
                    v43 = v52;
                    v71 = v81;
                    b15 = b16;
                    mutex8 = mutex1;
                    v70 = v78;
                    v67 = v80;
                    z17 = z19;
                    s17 = s44;
                    v69 = v82;
                    l05 = l011;
                    devLog1 = devLog12;
                    v68 = v79;
                    s40 = object8;
                }
                catch(Throwable throwable0) {
                    goto label_1045;
                }
                try {
                label_881:
                    this.r = s39;
                    this.w = mutex8;
                    this.B = s17;
                    this.D = l05;
                    this.E = b15;
                    this.G = devLog1;
                    this.I = s40;
                    this.M = null;
                    this.N = null;
                    this.S = null;
                    this.W = v71;
                    this.X = v67;
                    this.Y = v68;
                    this.c0 = v43;
                    this.Z = v70;
                    this.T = z17;
                    this.b0 = v69;
                    this.d0 = 7;
                    a9 = a10;
                    if(b.b(b15, PlaylistId.SMART, this) != a9) {
                        goto label_909;
                    }
                    return a9;
                }
                catch(Throwable throwable0) {
                    v = v43;
                    s3 = s17;
                    mutex1 = mutex8;
                    l00 = l05;
                    s4 = s40;
                    goto label_1283;
                }
            label_909:
                v26 = v43;
                s46 = s39;
                devLog2 = devLog1;
                l06 = l05;
                s16 = s40;
                goto label_1098;
            }
            case 7: {
                v26 = this.c0;
                i3 i33 = (i3)this.S;
                s16 = this.I;
                devLog2 = (DevLog)this.G;
                b15 = (b)this.E;
                l06 = (L0)this.D;
                s17 = (String)this.B;
                mutex8 = (Mutex)this.w;
                s46 = (String)this.r;
                goto label_1097;
            }
            case 8: {
                boolean z20 = this.T;
                int v83 = this.Z;
                v52 = this.c0;
                int v84 = this.Y;
                int v85 = this.X;
                int v86 = this.W;
                int v87 = this.b0;
                object8 = this.I;
                i3 i34 = (i3)this.S;
                devLog13 = (DevLog)this.G;
                b b17 = (b)this.E;
                l012 = (L0)this.D;
                s47 = (String)this.B;
                mutex18 = (Mutex)this.w;
                String s48 = (String)this.r;
                try {
                    d5.n.D(object0);
                    object12 = object0;
                    i31 = i34;
                    z18 = z20;
                    a11 = a0;
                    s43 = s48;
                    v74 = v85;
                    s42 = object8;
                    v72 = v84;
                    v76 = v52;
                    v73 = v86;
                    devLog11 = devLog13;
                    mutex17 = mutex18;
                    v77 = v87;
                    b13 = b17;
                    l05 = l012;
                    v75 = v83;
                    s41 = s47;
                }
                catch(Throwable throwable0) {
                    goto label_1143;
                }
                try {
                label_959:
                    DrawerPlaylistInfo drawerPlaylistInfo0 = ((g3)i31).c();
                    String s49 = ((g3)i31).b();
                    s20 = s41;
                    mutex19 = mutex17;
                    long v88 = ((g3)i31).d();
                    this.r = s43;
                    this.w = mutex17;
                    this.B = s41;
                    this.D = l05;
                    this.E = b13;
                    this.G = devLog11;
                    this.I = s42;
                    s20 = s41;
                    this.M = null;
                    this.N = null;
                    this.S = null;
                    this.W = v73;
                    this.X = v74;
                    this.Y = v72;
                    this.c0 = v76;
                    this.Z = v75;
                    this.T = z18;
                    this.b0 = v77;
                    this.d0 = 9;
                    a1 = a11;
                    mutex19 = mutex17;
                    object13 = ((u0)object12).N(drawerPlaylistInfo0, s49, v88, this);
                }
                catch(Throwable throwable0) {
                    v = v76;
                    s4 = s42;
                    devLog1 = devLog11;
                    l00 = l05;
                    mutex1 = mutex19;
                    s3 = s20;
                    goto label_1283;
                }
                if(object13 == a1) {
                    return a1;
                }
                v26 = v76;
                devLog2 = devLog11;
                v89 = v74;
                v90 = v72;
                z21 = z18;
                s46 = s43;
                a12 = a1;
                l06 = l05;
                mutex20 = mutex19;
                v91 = v73;
                object14 = object13;
                v92 = v77;
                b15 = b13;
                s50 = s20;
                goto label_1049;
            }
            case 9: {
                boolean z22 = this.T;
                int v93 = this.Z;
                v52 = this.c0;
                int v94 = this.Y;
                int v95 = this.X;
                int v96 = this.W;
                int v97 = this.b0;
                u0 u00 = (u0)this.S;
                object8 = this.I;
                devLog12 = (DevLog)this.G;
                b b18 = (b)this.E;
                l011 = (L0)this.D;
                s44 = (String)this.B;
                mutex1 = (Mutex)this.w;
                String s51 = (String)this.r;
                try {
                    d5.n.D(object0);
                    a12 = a0;
                    l06 = l011;
                    v90 = v94;
                    s46 = s51;
                    v75 = v93;
                    b15 = b18;
                    s50 = s44;
                    v92 = v97;
                    mutex20 = mutex1;
                    s42 = object8;
                    v26 = v52;
                    z21 = z22;
                    devLog2 = devLog12;
                    object14 = ((ie.p)object0).d();
                    v91 = v96;
                    v89 = v95;
                }
                catch(Throwable throwable0) {
                label_1045:
                    devLog1 = devLog12;
                    l00 = l011;
                    s3 = s44;
                    v103 = v52;
                    s4 = object8;
                    goto label_1282;
                }
            label_1049:
                if(ie.p.c(object14)) {
                    try {
                        this.r = s46;
                        this.w = mutex20;
                        this.B = s50;
                        this.D = l06;
                        this.E = b15;
                        this.G = devLog2;
                        this.I = s42;
                        this.M = null;
                        this.N = null;
                        this.S = null;
                        this.W = v91;
                        this.X = v89;
                        this.Y = v90;
                        this.c0 = v26;
                        this.Z = v75;
                        this.T = z21;
                        this.b0 = v92;
                        this.V = true;
                        this.d0 = 10;
                        a6 = a12;
                        if(b.b(b15, PlaylistId.DRAWER, this) == a6) {
                            return a6;
                        }
                    }
                    catch(Throwable throwable0) {
                        l00 = l06;
                        s3 = s50;
                        s4 = s42;
                        mutex1 = mutex20;
                        devLog1 = devLog2;
                        v = v26;
                        goto label_1283;
                    }
                    s16 = s42;
                    mutex8 = mutex20;
                    s17 = s50;
                    goto label_1098;
                }
                else {
                    s16 = s42;
                    mutex8 = mutex20;
                    s17 = s50;
                }
                b13 = b15;
                s29 = s46;
                goto label_1272;
            }
            case 10: {
                v26 = this.c0;
                u0 u01 = (u0)this.S;
                s16 = this.I;
                devLog2 = (DevLog)this.G;
                b15 = (b)this.E;
                l06 = (L0)this.D;
                s17 = (String)this.B;
                mutex8 = (Mutex)this.w;
                s46 = (String)this.r;
                try {
                label_1097:
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    goto label_1253;
                }
                try {
                label_1098:
                    EventBusHelper.post(EventCurPlaylistViewFocus.INSTANCE);
                }
                catch(Throwable throwable0) {
                    v = v26;
                    devLog1 = devLog2;
                    s3 = s17;
                    mutex1 = mutex8;
                    s4 = s16;
                    l00 = l06;
                    goto label_1283;
                }
                b13 = b15;
                s29 = s46;
                goto label_1272;
            }
            case 11: {
                boolean z23 = this.T;
                int v98 = this.Z;
                v52 = this.c0;
                int v99 = this.Y;
                int v100 = this.X;
                int v101 = this.W;
                int v102 = this.b0;
                object8 = this.I;
                Throwable throwable4 = (Throwable)this.S;
                devLog13 = (DevLog)this.G;
                b b19 = (b)this.E;
                l012 = (L0)this.D;
                s47 = (String)this.B;
                mutex18 = (Mutex)this.w;
                s29 = (String)this.r;
                try {
                    d5.n.D(object0);
                    s30 = object8;
                    mutex14 = mutex18;
                    throwable2 = throwable4;
                    a7 = a0;
                    v34 = v100;
                    s17 = s47;
                    v50 = v98;
                    v51 = v101;
                    v48 = v99;
                    b11 = b19;
                    devLog1 = devLog13;
                    z11 = z23;
                    v49 = v102;
                    l05 = l012;
                    goto label_1150;
                }
                catch(Throwable throwable0) {
                label_1143:
                    devLog1 = devLog13;
                    l00 = l012;
                    s3 = s47;
                    mutex1 = mutex18;
                }
                v103 = v52;
                s4 = object8;
                goto label_1282;
                try {
                label_1150:
                    if(u.o(s29)) {
                        this.r = s29;
                        this.w = mutex14;
                        this.B = s17;
                        this.D = l05;
                        this.E = b11;
                        this.G = devLog1;
                        this.I = s30;
                        mutex1 = mutex14;
                        goto label_1159;
                    }
                    else {
                        goto label_1182;
                    }
                    goto label_1226;
                }
                catch(Throwable throwable0) {
                    goto label_1189;
                }
                try {
                label_1159:
                    this.M = null;
                    this.N = null;
                    this.S = throwable2;
                    this.W = v51;
                    this.X = v34;
                    this.Y = v48;
                    this.c0 = v52;
                    this.Z = v50;
                    this.T = z11;
                    this.b0 = v49;
                    this.d0 = 12;
                    a6 = a7;
                    if(SmartPlaylistUseSettingPreferencesRepository.INSTANCE.updateUseSmartPlaylist(s29, false, this) != a6) {
                        goto label_1175;
                    }
                    return a6;
                }
                catch(Throwable throwable0) {
                    goto label_1190;
                }
            label_1175:
                s52 = s29;
                v104 = v49;
                devLog14 = devLog1;
                s53 = s17;
                l013 = l05;
                goto label_1220;
                try {
                label_1182:
                    mutex1 = mutex14;
                    v105 = v52;
                    v106 = v49;
                    devLog2 = devLog1;
                    l06 = l05;
                    goto label_1226;
                }
                catch(Throwable throwable0) {
                label_1189:
                    mutex1 = mutex14;
                }
            label_1190:
                v = v52;
                s4 = s30;
                s3 = s17;
                l00 = l05;
                goto label_1283;
            }
            case 12: {
                int v107 = this.b0;
                long v108 = this.c0;
                Throwable throwable5 = (Throwable)this.S;
                s4 = this.I;
                devLog14 = (DevLog)this.G;
                b11 = (b)this.E;
                l013 = (L0)this.D;
                s53 = (String)this.B;
                Mutex mutex21 = (Mutex)this.w;
                String s54 = (String)this.r;
                try {
                    mutex1 = mutex21;
                    d5.n.D(object0);
                    mutex1 = mutex21;
                    throwable2 = throwable5;
                    s30 = s4;
                    v52 = v108;
                    s52 = s54;
                    v104 = v107;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog14;
                    s3 = s53;
                    l00 = l013;
                    v = v108;
                    goto label_1283;
                }
            label_1220:
                v105 = v52;
                v106 = v104;
                s29 = s52;
                devLog2 = devLog14;
                l06 = l013;
                s17 = s53;
                try {
                label_1226:
                    v26 = v105;
                    b13 = b11;
                    mutex8 = mutex1;
                    b13.r.setValue(f.a(false));
                    if(v106 != 0 && !(throwable2 instanceof T2)) {
                        EventBusHelper.post(new EventSmartRestoreFailedDialog());
                    }
                    s16 = s30;
                    goto label_1272;
                }
                catch(Throwable throwable0) {
                    v = v26;
                    devLog1 = devLog2;
                    s4 = s30;
                    s3 = s17;
                    mutex1 = mutex8;
                    l00 = l06;
                    goto label_1283;
                }
            }
            case 13: {
                v26 = this.c0;
                s16 = this.I;
                devLog2 = (DevLog)this.G;
                b7 = (b)this.E;
                l06 = (L0)this.D;
                s17 = (String)this.B;
                mutex8 = (Mutex)this.w;
                s6 = (String)this.r;
                try {
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                label_1253:
                    mutex1 = mutex8;
                    l00 = l06;
                    s3 = s17;
                    s4 = s16;
                    devLog1 = devLog2;
                    v = v26;
                    goto label_1283;
                }
            label_1260:
                s2 = s17;
                b1 = b7;
                try {
                label_1262:
                    b1.r.setValue(f.a(false));
                    s29 = s6;
                    b13 = b1;
                    s17 = s2;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex8;
                    l00 = l06;
                    s3 = s2;
                    goto label_1279;
                }
                try {
                label_1272:
                    boolean z24 = q.b(b13.r.getValue(), f.a(true));
                    SmartPlaylistLog.INSTANCE.sendSpStatisticsAsync("onLogin", s29, z24);
                    goto label_1294;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex8;
                    l00 = l06;
                    s3 = s17;
                }
            label_1279:
                devLog1 = devLog2;
                s4 = s16;
                v103 = v26;
            label_1282:
                v = v103;
            label_1283:
                long v109 = System.currentTimeMillis() - v;
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s4);
                H0.b.t(v109, s3, " (", stringBuilder1);
                stringBuilder1.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder1.toString(), null, false, 6, null);
                StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s4);
                H0.b.t(v109, s3, " (", stringBuilder2);
                l1.C(stringBuilder2, "ms)", devLog1);
                if(l00 != null) {
                    com.iloen.melon.utils.a.u(s4, " ", s3, l00, false);
                }
                throw throwable0;
            label_1294:
                long v110 = System.currentTimeMillis() - v26;
                StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex8.hashCode(), s16);
                H0.b.t(v110, s17, " (", stringBuilder3);
                stringBuilder3.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder3.toString(), null, false, 6, null);
                StringBuilder stringBuilder4 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex8.hashCode(), s16);
                H0.b.t(v110, s17, " (", stringBuilder4);
                l1.C(stringBuilder4, "ms)", devLog2);
                if(l06 != null) {
                    com.iloen.melon.utils.a.u(s16, " ", s17, l06, false);
                    return H.a;
                }
                return H.a;
            }
            case 14: {
                Mutex mutex22 = (Mutex)this.I;
                DevLog devLog15 = (DevLog)this.E;
                L0 l014 = (L0)this.D;
                String s55 = (String)this.B;
                Mutex mutex23 = (Mutex)this.w;
                String s56 = (String)this.r;
                break;
            }
            case 15: {
                int v111 = this.Z;
                v6 = this.c0;
                int v112 = this.Y;
                v14 = this.X;
                v15 = this.W;
                Mutex mutex24 = (Mutex)this.I;
                s11 = this.G;
                devLog5 = (DevLog)this.E;
                v9 = v111;
                b b20 = (b)this.D;
                l03 = (L0)this.B;
                s57 = (String)this.w;
                mutex4 = (Mutex)this.r;
                try {
                    d5.n.D(object0);
                    b5 = b20;
                    s10 = s57;
                    a1 = a0;
                    v13 = v112;
                }
                catch(Throwable throwable1) {
                    goto label_1434;
                }
            label_1330:
                v10 = v14;
                s9 = s10;
                v12 = v15;
                s = s11;
                devLog4 = devLog5;
                l01 = l03;
                mutex5 = mutex4;
                b4 = b5;
                goto label_1375;
            }
            case 16: {
                int v113 = this.Z;
                v6 = this.c0;
                int v114 = this.Y;
                int v115 = this.X;
                int v116 = this.W;
                Mutex mutex25 = (Mutex)this.I;
                s11 = this.G;
                devLog5 = (DevLog)this.E;
                v9 = v113;
                b b21 = (b)this.D;
                l03 = (L0)this.B;
                s57 = (String)this.w;
                mutex4 = (Mutex)this.r;
                try {
                    d5.n.D(object0);
                    b3 = b21;
                    s8 = s57;
                    v8 = v114;
                    v7 = v116;
                    s = s11;
                    a1 = a0;
                    l02 = l03;
                    v10 = v115;
                    devLog4 = devLog5;
                    mutex5 = mutex4;
                }
                catch(Throwable throwable1) {
                    goto label_1434;
                }
                try {
                label_1363:
                    ToastManager.show(0x7F130390);  // string:end_live "로그아웃으로 LIVE 재생이 종료됩니다."
                    l01 = l02;
                    v13 = v8;
                    v12 = v7;
                    s9 = s8;
                    b4 = b3;
                }
                catch(Throwable throwable1) {
                    s7 = s8;
                    mutex4 = mutex5;
                    v5 = v6;
                    goto label_1489;
                }
            label_1375:
                v11 = v9;
                try {
                label_1376:
                    this.r = mutex5;
                    this.w = s9;
                    this.B = l01;
                    this.D = b4;
                    this.E = devLog4;
                    this.G = s;
                    this.I = null;
                    this.W = v12;
                    this.X = v10;
                    this.Y = v13;
                    this.c0 = v6;
                    this.Z = v11;
                    this.d0 = 17;
                    object15 = b4.b.h(false, this);
                }
                catch(Throwable throwable1) {
                    l02 = l01;
                    s7 = s9;
                    mutex4 = mutex5;
                    v5 = v6;
                    goto label_1489;
                }
                if(object15 != a1) {
                    v117 = v11;
                    v118 = v13;
                    b22 = b4;
                    v119 = v12;
                    s7 = s9;
                    l015 = l01;
                    v120 = v6;
                    goto label_1440;
                }
                return a1;
            }
            case 17: {
                int v121 = this.Z;
                v6 = this.c0;
                int v122 = this.Y;
                int v123 = this.X;
                int v124 = this.W;
                Mutex mutex26 = (Mutex)this.I;
                s11 = this.G;
                devLog5 = (DevLog)this.E;
                b b23 = (b)this.D;
                l03 = (L0)this.B;
                s57 = (String)this.w;
                mutex4 = (Mutex)this.r;
                try {
                    d5.n.D(object0);
                    v119 = v124;
                    s = s11;
                    b22 = b23;
                    l015 = l03;
                    s7 = s57;
                    a1 = a0;
                    v120 = v6;
                    v118 = v122;
                    v10 = v123;
                    devLog4 = devLog5;
                    v117 = v121;
                    mutex5 = mutex4;
                    object15 = object0;
                }
                catch(Throwable throwable1) {
                label_1434:
                    s = s11;
                    devLog4 = devLog5;
                    l02 = l03;
                    v5 = v6;
                    s7 = s57;
                    goto label_1489;
                }
                try {
                label_1440:
                    this.r = mutex5;
                    this.w = s7;
                    this.B = l015;
                    this.D = b22;
                    this.E = devLog4;
                    this.G = s;
                    this.I = null;
                    this.W = v119;
                    this.X = v10;
                    this.Y = v118;
                    this.c0 = v120;
                    this.Z = v117;
                    this.d0 = 18;
                    if(((P0)object15).M(this) != a1) {
                        goto label_1460;
                    }
                    return a1;
                }
                catch(Throwable throwable1) {
                    mutex4 = mutex5;
                    l02 = l015;
                    v5 = v120;
                    goto label_1489;
                }
            label_1460:
                v125 = v120;
                s58 = s;
                l02 = l015;
                s59 = s7;
                goto label_1482;
            }
            case 18: {
                v125 = this.c0;
                Mutex mutex27 = (Mutex)this.I;
                s58 = this.G;
                devLog4 = (DevLog)this.E;
                b22 = (b)this.D;
                l02 = (L0)this.B;
                s59 = (String)this.w;
                mutex5 = (Mutex)this.r;
                try {
                    d5.n.D(object0);
                }
                catch(Throwable throwable1) {
                    mutex4 = mutex5;
                    v5 = v125;
                    s7 = s59;
                    s = s58;
                    goto label_1489;
                }
                try {
                label_1482:
                    b22.r.setValue(f.a(false));
                    goto label_1500;
                }
                catch(Throwable throwable1) {
                    s = s58;
                    s7 = s59;
                    mutex4 = mutex5;
                    v5 = v125;
                }
            label_1489:
                long v126 = System.currentTimeMillis() - v5;
                StringBuilder stringBuilder5 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex4.hashCode(), s);
                H0.b.t(v126, s7, " (", stringBuilder5);
                stringBuilder5.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder5.toString(), null, false, 6, null);
                StringBuilder stringBuilder6 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex4.hashCode(), s);
                H0.b.t(v126, s7, " (", stringBuilder6);
                l1.C(stringBuilder6, "ms)", devLog4);
                if(l02 != null) {
                    com.iloen.melon.utils.a.u(s, " ", s7, l02, false);
                }
                throw throwable1;
            label_1500:
                long v127 = System.currentTimeMillis() - v125;
                StringBuilder stringBuilder7 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex5.hashCode(), s58);
                H0.b.t(v127, s59, " (", stringBuilder7);
                stringBuilder7.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder7.toString(), null, false, 6, null);
                StringBuilder stringBuilder8 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex5.hashCode(), s58);
                H0.b.t(v127, s59, " (", stringBuilder8);
                l1.C(stringBuilder8, "ms)", devLog4);
                if(l02 != null) {
                    com.iloen.melon.utils.a.u(s58, " ", s59, l02, false);
                    return H.a;
                }
                return H.a;
            }
            case 19: {
                ReentrantMutexContextKey reentrantMutexContextKey2 = (ReentrantMutexContextKey)this.I;
                Mutex mutex28 = (Mutex)this.G;
                DevLog devLog16 = (DevLog)this.D;
                L0 l016 = (L0)this.B;
                String s60 = (String)this.w;
                Mutex mutex29 = (Mutex)this.r;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
        return H.a;
    }
}

