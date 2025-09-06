package tc;

import androidx.appcompat.app.o;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.ReplaceDefaultPlaylistException;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Station;
import com.iloen.melon.playback.playlist.add.StationAddRequestPlayableListInfo;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.playlist.station.CastData;
import d5.n;
import d8.d;
import e3.h;
import ie.H;
import ie.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lc.a;
import oc.A0;
import oc.Q;
import oc.S;
import oc.V;
import oc.W;
import oc.Z;
import oc.e0;
import oc.f0;
import oc.g;
import oc.j;
import oc.w;
import oc.z0;
import oe.c;

public final class x implements w, b {
    public final E a;
    public final LogU b;
    public final Mutex c;
    public final MutableStateFlow d;
    public long e;
    public final a f;
    public final h g;

    public x(E e0) {
        this.a = e0;
        this.b = new LogU("StationPlaylistImpl");
        this.c = MutexKt.Mutex$default(false, 1, null);
        this.d = StateFlowKt.MutableStateFlow(new F(je.w.a, -1, null));
        this.e = -1L;
        this.f = new a("StationPlaylistImpl");
        this.g = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.w
    public final Object B(Continuation continuation0) {
        long v5;
        j j1;
        String s4;
        DevLog devLog4;
        Mutex mutex6;
        Mutex mutex5;
        String s3;
        DevLog devLog3;
        Mutex mutex4;
        j j0;
        long v3;
        Mutex mutex2;
        int v2;
        String s1;
        DevLog devLog1;
        String s;
        Mutex mutex1;
        int v1;
        tc.h h0;
        if(continuation0 instanceof tc.h) {
            h0 = (tc.h)continuation0;
            int v = h0.V;
            if((v & 0x80000000) == 0) {
                h0 = new tc.h(this, ((c)continuation0));
            }
            else {
                h0.V = v ^ 0x80000000;
            }
        }
        else {
            h0 = new tc.h(this, ((c)continuation0));
        }
        Object object0 = h0.S;
        ne.a a0 = ne.a.a;
        switch(h0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_nextWhenPlayCompleted"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_nextWhenPlayCompleted", devLog0);
                h0.r = mutex0;
                h0.w = "station_nextWhenPlayCompleted";
                h0.B = devLog0;
                h0.D = "";
                h0.E = mutex0;
                v1 = 0;
                h0.I = 0;
                h0.M = 0;
                h0.V = 1;
                if(mutex0.lock(null, h0) != a0) {
                    mutex1 = mutex0;
                    s = "";
                    devLog1 = devLog0;
                    s1 = "station_nextWhenPlayCompleted";
                    v2 = 0;
                    mutex2 = mutex1;
                    goto label_48;
                }
                return a0;
            }
            case 1: {
                v2 = h0.M;
                v1 = h0.I;
                mutex1 = h0.E;
                Object object1 = h0.D;
                DevLog devLog2 = h0.B;
                String s2 = h0.w;
                Mutex mutex3 = h0.r;
                n.D(object0);
                s1 = s2;
                devLog1 = devLog2;
                s = object1;
                mutex2 = mutex3;
                try {
                label_48:
                    v3 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                    try {
                        int v4 = this.p();
                        j0 = new j(v4, true);
                    }
                    catch(Throwable throwable0) {
                        mutex4 = mutex2;
                        devLog3 = devLog1;
                        goto label_78;
                    }
                    h0.r = mutex2;
                    h0.w = s1;
                    h0.B = devLog1;
                    h0.D = s;
                    h0.E = mutex1;
                    h0.G = j0;
                    h0.I = v1;
                    h0.M = v2;
                    h0.N = v3;
                    h0.V = 2;
                    mutex4 = mutex2;
                    devLog3 = devLog1;
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex2;
                    devLog3 = devLog1;
                    goto label_78;
                }
                try {
                    if(this.f(v4, 0L, "next", true, h0) == a0) {
                        return a0;
                    }
                    goto label_85;
                }
                catch(Throwable throwable0) {
                }
            label_78:
                s3 = s;
                mutex5 = mutex1;
                mutex6 = mutex4;
                devLog4 = devLog3;
                s4 = s1;
                goto label_104;
            label_85:
                j1 = j0;
                v5 = v3;
                s3 = s;
                mutex5 = mutex1;
                mutex6 = mutex4;
                devLog4 = devLog3;
                s4 = s1;
                goto label_108;
            }
            case 2: {
                try {
                    v5 = h0.N;
                    j1 = h0.G;
                    mutex5 = h0.E;
                    s3 = h0.D;
                    devLog4 = h0.B;
                    s4 = h0.w;
                    mutex6 = h0.r;
                    n.D(object0);
                    goto label_108;
                }
                catch(Throwable throwable0) {
                    v3 = v5;
                }
                try {
                label_104:
                    long v6 = System.currentTimeMillis() - v3;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex6.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v6 + "ms)");
                    throw throwable0;
                label_108:
                    long v7 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex6.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)");
                    goto label_115;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex5.unlock(null);
        throw throwable1;
    label_115:
        mutex5.unlock(null);
        return j1;
    }

    @Override  // oc.H
    public final AddPosition C() {
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        q.f(addPosition0, "getPlayListAddPosition(...)");
        return addPosition0;
    }

    @Override  // oc.w
    public final Object a(String s, Continuation continuation0) {
        Object object0 = null;
        for(Object object1: e1.b.B(((Q)this.d.getValue()))) {
            if(q.b("", s)) {
                object0 = object1;
                break;
            }
        }
        if(((Playable)object0) != null) {
            ((Playable)object0).setMenuid("1000002296");
            return H.a;
        }
        LogU.error$default(this.b, "processAfterLogging() failed. trackId: " + s, null, false, 6, null);
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
            return (F)this.d.getValue();
        }
        finally {
            mutex1.unlock(null);
        }
    }

    public final F c() {
        return (F)this.d.getValue();
    }

    @Override  // oc.H
    public final MutableStateFlow d() {
        return this.d;
    }

    public final Object e(c c0) {
        Mutex mutex1;
        String s1;
        DevLog devLog0;
        String s;
        Mutex mutex0;
        long v2;
        Mutex mutex7;
        int v24;
        Object object3;
        int v23;
        int v22;
        Mutex mutex6;
        int v21;
        E e1;
        String s6;
        DevLog devLog3;
        String s5;
        int v20;
        Mutex mutex5;
        long v14;
        Object object2;
        int v13;
        List list2;
        StationAddRequestPlayableListInfo stationAddRequestPlayableListInfo1;
        int v12;
        int v11;
        int v10;
        int v9;
        String s4;
        DevLog devLog2;
        String s3;
        Mutex mutex4;
        Mutex mutex3;
        String s2;
        DevLog devLog1;
        Object object1;
        Mutex mutex2;
        long v5;
        int v33;
        int v32;
        Object object5;
        int v31;
        String s7;
        long v26;
        int v36;
        Mutex mutex11;
        String s10;
        DevLog devLog5;
        int v34;
        ie.o o0;
        String s13;
        Iterator iterator0;
        int v39;
        int v38;
        StationAddRequestPlayableListInfo stationAddRequestPlayableListInfo2;
        List list3;
        Object object7;
        Object object6;
        String s11;
        long v37;
        tc.j j0;
        if(c0 instanceof tc.j) {
            j0 = (tc.j)c0;
            int v = j0.Z;
            if((v & 0x80000000) == 0) {
                j0 = new tc.j(this, c0);
            }
            else {
                j0.Z = v ^ 0x80000000;
            }
        }
        else {
            j0 = new tc.j(this, c0);
        }
        Object object0 = j0.X;
        ne.a a0 = ne.a.a;
        int v1 = j0.Z;
        E e0 = this.a;
        switch(v1) {
            case 0: {
                n.D(object0);
                Mutex mutex12 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex12.hashCode(), "Lock[", "]  try : station_restore"), null, false, 6, null);
                DevLog devLog6 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex12.hashCode(), "]  try : station_restore", devLog6);
                j0.r = mutex12;
                j0.w = "station_restore";
                j0.B = devLog6;
                s = "";
                j0.D = "";
                j0.E = mutex12;
                j0.M = 0;
                j0.N = 0;
                j0.Z = 1;
                if(mutex12.lock(null, j0) != a0) {
                    mutex11 = mutex12;
                    devLog5 = devLog6;
                    s10 = "station_restore";
                    v34 = 0;
                    mutex0 = mutex11;
                    v36 = 0;
                    try {
                    label_157:
                        v37 = System.currentTimeMillis();
                    }
                    catch(Throwable throwable1) {
                        mutex0.unlock(null);
                        throw throwable1;
                    }
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex11.hashCode() + "] " + s + " Lock obtain : " + s10, null, false, 6, null);
                        devLog5.put("Lock[" + mutex11.hashCode() + "] " + s + " Lock obtain : " + s10);
                        s11 = MelonPrefs.getInstance().getString("CAST_LAST_SEQ", null);
                        if(s11 == null || s11.length() == 0) {
                            throw new ReplaceDefaultPlaylistException("Try to restore StationPlaylist with invalid stationSeq");
                        }
                    }
                    catch(Throwable throwable2) {
                        goto label_341;
                    }
                    try {
                        j0.r = mutex11;
                        j0.w = s10;
                        j0.B = devLog5;
                        j0.D = s;
                        j0.E = mutex0;
                        j0.G = s11;
                        j0.M = v34;
                        j0.N = v36;
                        j0.S = 0;
                        j0.W = v37;
                        j0.T = 0;
                        j0.V = 0;
                        j0.Z = 2;
                        object6 = e0.a(j0);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex11;
                        devLog0 = devLog5;
                        v2 = v37;
                        s1 = s10;
                        o0 = n.t(throwable0);
                        goto label_334;
                    }
                    if(object6 != a0) {
                        object5 = object6;
                        v20 = 0;
                        v33 = v36;
                        s7 = s11;
                        s6 = s10;
                        v31 = 0;
                        mutex6 = mutex0;
                        v22 = v34;
                        v26 = v37;
                        mutex7 = mutex11;
                        devLog3 = devLog5;
                        s5 = s;
                        v32 = 0;
                        e1 = e0;
                        try {
                        label_199:
                            Station playDataForSeverContent$Station0 = new Station(s7, ((String)object5), "1000002298", null);
                            j0.r = mutex7;
                            j0.w = s6;
                            j0.B = devLog3;
                            j0.D = s5;
                            j0.E = mutex6;
                            j0.G = null;
                            j0.M = v22;
                            j0.N = v33;
                            j0.S = v20;
                            j0.W = v26;
                            j0.T = v32;
                            v23 = v31;
                            j0.V = v23;
                            j0.Z = 3;
                            object7 = playDataForSeverContent$Station0.getPlayableList(j0);
                        }
                        catch(Throwable throwable0) {
                            v2 = v26;
                            goto label_246;
                        }
                        if(object7 != a0) {
                            v24 = v32;
                            object3 = object7;
                            v21 = v33;
                            v2 = v26;
                            try {
                            label_224:
                                q.e(object3, "null cannot be cast to non-null type com.iloen.melon.playback.playlist.add.StationAddRequestPlayableListInfo");
                                if(((StationAddRequestPlayableListInfo)object3).getUserRequestedPlaylist().isEmpty() || ((StationAddRequestPlayableListInfo)object3).getResponse() == null) {
                                    throw new IllegalStateException("Check failed.");
                                }
                                list3 = ((StationAddRequestPlayableListInfo)object3).getUserRequestedPlaylist();
                                j0.r = mutex7;
                                j0.w = s6;
                                j0.B = devLog3;
                                j0.D = s5;
                                j0.E = mutex6;
                                j0.G = list3;
                                j0.I = (StationAddRequestPlayableListInfo)object3;
                                j0.M = v22;
                                j0.N = v21;
                                j0.S = v20;
                                j0.W = v2;
                                j0.T = v24;
                                j0.V = v23;
                                stationAddRequestPlayableListInfo2 = (StationAddRequestPlayableListInfo)object3;
                                j0.Z = 4;
                                object2 = e1.a(j0);
                                goto label_252;
                            }
                            catch(Throwable throwable0) {
                            }
                        label_246:
                            mutex0 = mutex6;
                            s = s5;
                            mutex1 = mutex7;
                            devLog0 = devLog3;
                            s1 = s6;
                            o0 = n.t(throwable0);
                            goto label_334;
                        label_252:
                            if(object2 != a0) {
                                v10 = v22;
                                v12 = v24;
                                list2 = list3;
                                v11 = v23;
                                v13 = v20;
                                devLog2 = devLog3;
                                s4 = s5;
                                v14 = v2;
                                s3 = s6;
                                stationAddRequestPlayableListInfo1 = stationAddRequestPlayableListInfo2;
                                mutex4 = mutex7;
                                mutex5 = mutex6;
                                v9 = v21;
                                try {
                                label_266:
                                    v38 = -1;
                                    String s12 = (String)object2;
                                    v39 = 0;
                                    iterator0 = list2.iterator();
                                label_270:
                                    while(!iterator0.hasNext()) {
                                        goto label_289;
                                    }
                                }
                                catch(Throwable throwable0) {
                                    s13 = s3;
                                    goto label_308;
                                }
                                try {
                                    iterator0.next();
                                    if(q.b("", s12)) {
                                        v38 = v39;
                                        goto label_289;
                                    }
                                    ++v39;
                                    goto label_270;
                                }
                                catch(Throwable throwable0) {
                                    v2 = v14;
                                    mutex0 = mutex5;
                                    s = s4;
                                    mutex1 = mutex4;
                                    devLog0 = devLog2;
                                    s1 = s3;
                                    o0 = n.t(throwable0);
                                    goto label_334;
                                }
                                v38 = v39;
                                goto label_289;
                                try {
                                    ++v39;
                                    goto label_270;
                                }
                                catch(Throwable throwable0) {
                                    s13 = s3;
                                    goto label_308;
                                }
                                try {
                                label_289:
                                    s13 = s3;
                                    l l0 = new l((v38 == -1 ? 0 : v38), stationAddRequestPlayableListInfo1, list2, null, this);
                                    j0.r = mutex4;
                                    j0.w = s13;
                                    j0.B = devLog2;
                                    j0.D = s4;
                                    j0.E = mutex5;
                                    j0.G = null;
                                    j0.I = null;
                                    j0.M = v10;
                                    j0.N = v9;
                                    j0.S = v13;
                                    j0.W = v14;
                                    j0.T = v12;
                                    j0.V = v11;
                                    j0.Z = 5;
                                    object0 = BuildersKt.withContext(NonCancellable.INSTANCE, l0, j0);
                                    goto label_315;
                                }
                                catch(Throwable throwable0) {
                                }
                            label_308:
                                v2 = v14;
                                mutex0 = mutex5;
                                s = s4;
                                mutex1 = mutex4;
                                s1 = s13;
                                devLog0 = devLog2;
                                o0 = n.t(throwable0);
                                goto label_334;
                            label_315:
                                if(object0 == a0) {
                                    return a0;
                                }
                                v2 = v14;
                                mutex0 = mutex5;
                                s = s4;
                                mutex1 = mutex4;
                                s1 = s13;
                                devLog0 = devLog2;
                                try {
                                    o0 = (F)object0;
                                    goto label_334;
                                }
                                catch(Throwable throwable0) {
                                }
                                try {
                                    o0 = n.t(throwable0);
                                    goto label_334;
                                }
                                catch(Throwable throwable2) {
                                    try {
                                        v37 = v2;
                                        devLog5 = devLog0;
                                        s10 = s1;
                                        mutex11 = mutex1;
                                        goto label_341;
                                    label_334:
                                        v37 = v2;
                                        devLog5 = devLog0;
                                        s10 = s1;
                                        mutex11 = mutex1;
                                        if(p.a(o0) != null) {
                                            throw new ReplaceDefaultPlaylistException("get from server failed");
                                        }
                                        goto label_345;
                                    }
                                    catch(Throwable throwable2) {
                                    }
                                }
                                try {
                                label_341:
                                    long v40 = System.currentTimeMillis() - v37;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex11.hashCode() + "] " + s + " Lock return : " + s10 + " (" + v40 + "ms)", null, false, 6, null);
                                    devLog5.put("Lock[" + mutex11.hashCode() + "] " + s + " Lock return : " + s10 + " (" + v40 + "ms)");
                                    throw throwable2;
                                label_345:
                                    long v41 = System.currentTimeMillis() - v37;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex11.hashCode() + "] " + s + " Lock return : " + s10 + " (" + v41 + "ms)", null, false, 6, null);
                                    devLog5.put("Lock[" + mutex11.hashCode() + "] " + s + " Lock return : " + s10 + " (" + v41 + "ms)");
                                }
                                catch(Throwable throwable1) {
                                    mutex0.unlock(null);
                                    throw throwable1;
                                }
                                mutex0.unlock(null);
                                return H.a;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                v34 = j0.M;
                mutex0 = j0.E;
                s = j0.D;
                devLog5 = j0.B;
                String s9 = j0.w;
                int v35 = j0.N;
                Mutex mutex10 = j0.r;
                n.D(object0);
                s10 = s9;
                mutex11 = mutex10;
                v36 = v35;
                goto label_157;
            }
            case 2: {
                int v25 = j0.T;
                v26 = j0.W;
                int v27 = j0.S;
                int v28 = j0.N;
                int v29 = j0.M;
                int v30 = j0.V;
                s7 = (String)j0.G;
                Mutex mutex8 = j0.E;
                Object object4 = j0.D;
                DevLog devLog4 = j0.B;
                String s8 = j0.w;
                Mutex mutex9 = j0.r;
                try {
                    n.D(object0);
                    mutex7 = mutex9;
                    v31 = v30;
                    object5 = object0;
                    v22 = v29;
                    v32 = v25;
                    devLog3 = devLog4;
                    v33 = v28;
                    v20 = v27;
                    s5 = object4;
                    mutex6 = mutex8;
                    s6 = s8;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex9;
                    v2 = v26;
                    mutex0 = mutex8;
                    s = object4;
                    devLog0 = devLog4;
                    s1 = s8;
                    o0 = n.t(throwable0);
                    goto label_334;
                }
                e1 = e0;
                goto label_199;
            }
            case 3: {
                goto label_54;
            label_80:
                mutex1 = mutex3;
                v2 = v5;
                mutex0 = mutex2;
                s = object1;
                devLog0 = devLog1;
                s1 = s2;
                o0 = n.t(throwable0);
                goto label_334;
            }
            case 4: {
                int v3 = j0.V;
                int v4 = j0.T;
                v5 = j0.W;
                int v6 = j0.S;
                int v7 = j0.N;
                int v8 = j0.M;
                StationAddRequestPlayableListInfo stationAddRequestPlayableListInfo0 = j0.I;
                List list1 = (List)j0.G;
                mutex2 = j0.E;
                object1 = j0.D;
                devLog1 = j0.B;
                s2 = j0.w;
                mutex3 = j0.r;
                try {
                    n.D(object0);
                    mutex4 = mutex3;
                    s3 = s2;
                    devLog2 = devLog1;
                    s4 = object1;
                    v9 = v7;
                    v10 = v8;
                    v11 = v3;
                    v12 = v4;
                    stationAddRequestPlayableListInfo1 = stationAddRequestPlayableListInfo0;
                    list2 = list1;
                    v13 = v6;
                    object2 = object0;
                    v14 = v5;
                    mutex5 = mutex2;
                    goto label_266;
                label_54:
                    int v15 = j0.V;
                    v5 = j0.W;
                    int v16 = j0.S;
                    int v17 = j0.N;
                    int v18 = j0.M;
                    int v19 = j0.T;
                    mutex2 = j0.E;
                    object1 = j0.D;
                    devLog1 = j0.B;
                    s2 = j0.w;
                    mutex3 = j0.r;
                    n.D(object0);
                    v20 = v16;
                    s5 = object1;
                    devLog3 = devLog1;
                    s6 = s2;
                    e1 = e0;
                    v21 = v17;
                    mutex6 = mutex2;
                    v22 = v18;
                    v23 = v15;
                    object3 = object0;
                    v24 = v19;
                    mutex7 = mutex3;
                    v2 = v5;
                    goto label_224;
                }
                catch(Throwable throwable0) {
                }
                goto label_80;
            }
            default: {
                if(v1 != 5) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                v2 = j0.W;
                List list0 = (List)j0.G;
                mutex0 = j0.E;
                s = j0.D;
                devLog0 = j0.B;
                s1 = j0.w;
                mutex1 = j0.r;
                try {
                    n.D(object0);
                    o0 = (F)object0;
                }
                catch(Throwable throwable0) {
                    o0 = n.t(throwable0);
                }
                goto label_334;
            }
        }
        return a0;
    }

    public final Object f(int v, long v1, String s, boolean z, c c0) {
        tc.o o0;
        if(c0 instanceof tc.o) {
            o0 = (tc.o)c0;
            int v2 = o0.D;
            if((v2 & 0x80000000) == 0) {
                o0 = new tc.o(this, c0);
            }
            else {
                o0.D = v2 ^ 0x80000000;
            }
        }
        else {
            o0 = new tc.o(this, c0);
        }
        Object object0 = o0.w;
        ne.a a0 = ne.a.a;
        switch(o0.D) {
            case 0: {
                n.D(object0);
                tc.q q0 = new tc.q(this, v1, v, z, s, null);
                o0.r = v1;
                o0.D = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, q0, o0);
                return object0 == a0 ? a0 : new e0(((F)object0), v1);
            }
            case 1: {
                long v3 = o0.r;
                n.D(object0);
                return new e0(((F)object0), v3);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // oc.w
    public final Object g(Continuation continuation0) {
        g g1;
        long v5;
        String s4;
        DevLog devLog4;
        Mutex mutex7;
        String s3;
        Mutex mutex6;
        int v4;
        DevLog devLog3;
        Mutex mutex5;
        long v3;
        Mutex mutex2;
        int v2;
        String s1;
        DevLog devLog1;
        Mutex mutex1;
        int v1;
        String s;
        tc.g g0;
        if(continuation0 instanceof tc.g) {
            g0 = (tc.g)continuation0;
            int v = g0.V;
            if((v & 0x80000000) == 0) {
                g0 = new tc.g(this, ((c)continuation0));
            }
            else {
                g0.V = v ^ 0x80000000;
            }
        }
        else {
            g0 = new tc.g(this, ((c)continuation0));
        }
        Object object0 = g0.S;
        ne.a a0 = ne.a.a;
        switch(g0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_next"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_next", devLog0);
                g0.r = mutex0;
                g0.w = "station_next";
                g0.B = devLog0;
                g0.D = "";
                g0.E = mutex0;
                g0.G = 0;
                g0.I = 0;
                g0.V = 1;
                if(mutex0.lock(null, g0) != a0) {
                    s = "";
                    v1 = 0;
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s1 = "station_next";
                    v2 = 0;
                    mutex2 = mutex1;
                    goto label_48;
                }
                return a0;
            }
            case 1: {
                v2 = g0.I;
                v1 = g0.G;
                Mutex mutex3 = g0.E;
                s = g0.D;
                DevLog devLog2 = g0.B;
                String s2 = g0.w;
                Mutex mutex4 = g0.r;
                n.D(object0);
                s1 = s2;
                mutex1 = mutex3;
                devLog1 = devLog2;
                mutex2 = mutex4;
                try {
                label_48:
                    v3 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    v4 = this.p();
                    g0.r = mutex2;
                    g0.w = s1;
                    g0.B = devLog1;
                    g0.D = s;
                    g0.E = mutex1;
                    g0.G = v1;
                    g0.I = v2;
                    g0.N = v3;
                    g0.M = v4;
                    g0.V = 2;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    if(this.f(v4, 0L, "next", true, g0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex6 = mutex1;
                    s3 = s;
                    mutex7 = mutex5;
                    devLog4 = devLog3;
                    s4 = s1;
                    goto label_95;
                }
                v5 = v3;
                mutex6 = mutex1;
                s3 = s;
                mutex7 = mutex5;
                devLog4 = devLog3;
                s4 = s1;
                g1 = new g(v4);
                goto label_99;
            }
            case 2: {
                try {
                    v4 = g0.M;
                    v5 = g0.N;
                    mutex6 = g0.E;
                    s3 = g0.D;
                    devLog4 = g0.B;
                    s4 = g0.w;
                    mutex7 = g0.r;
                    n.D(object0);
                    g1 = new g(v4);
                    goto label_99;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v3 = v5;
        try {
        label_95:
            long v6 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v6 + "ms)");
            throw throwable0;
        label_99:
            long v7 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex6.unlock(null);
            throw throwable1;
        }
        mutex6.unlock(null);
        return g1;
    }

    @Override  // oc.H
    public final PlaylistId getId() {
        return PlaylistId.STATION;
    }

    @Override  // oc.H
    public final String getMenuId() {
        return "1000002296";
    }

    @Override  // oc.H
    public final Q getState() {
        return this.c();
    }

    @Override  // oc.w
    public final Object h(String s, boolean z, we.n n0, c c0) {
        A0 a00;
        DevLog devLog4;
        String s11;
        Mutex mutex11;
        long v19;
        Mutex mutex10;
        z0 z00;
        long v16;
        Mutex mutex9;
        Mutex mutex8;
        String s9;
        DevLog devLog3;
        Object object4;
        Mutex mutex7;
        Mutex mutex6;
        long v11;
        int v10;
        String s8;
        int v9;
        DevLog devLog2;
        String s7;
        int v8;
        int v7;
        boolean z3;
        ne.a a1;
        Object object3;
        String s6;
        Object object2;
        long v6;
        Mutex mutex5;
        Mutex mutex4;
        ArrayList arrayList0;
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
        u u0;
        if(c0 instanceof u) {
            u0 = (u)c0;
            int v = u0.b0;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, c0);
            }
            else {
                u0.b0 = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, c0);
        }
        Object object0 = u0.Y;
        ne.a a0 = ne.a.a;
        switch(u0.b0) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), H0.b.f(mutex0.hashCode(), "Lock[", "]  try : ", "station_" + ("updatePlayable-" + s)), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("station_" + ("updatePlayable-" + s)));
                u0.r = n0;
                u0.w = "updatePlayable-" + s;
                u0.B = mutex0;
                u0.D = "station_" + ("updatePlayable-" + s);
                u0.E = devLog0;
                s1 = "";
                u0.G = "";
                u0.I = mutex0;
                z1 = z;
                u0.N = z1;
                u0.S = 0;
                u0.T = 0;
                u0.b0 = 1;
                if(mutex0.lock(null, u0) == a0) {
                    return a0;
                }
                s2 = "updatePlayable-" + s;
                mutex1 = mutex0;
                mutex2 = mutex1;
                n1 = n0;
                s3 = "station_" + ("updatePlayable-" + s);
                v1 = 0;
                v2 = 0;
                devLog1 = devLog0;
                goto label_61;
            }
            case 1: {
                int v3 = u0.S;
                boolean z2 = u0.N;
                Mutex mutex3 = u0.I;
                Object object1 = u0.G;
                devLog0 = u0.E;
                String s4 = u0.D;
                int v4 = u0.T;
                mutex1 = u0.B;
                String s5 = u0.w;
                n1 = u0.r;
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
                    arrayList0 = e1.b.B(this.c());
                    u0.r = null;
                    u0.w = s2;
                    u0.B = mutex1;
                    u0.D = s3;
                    u0.E = devLog1;
                    u0.G = s1;
                    mutex4 = mutex2;
                    u0.I = mutex4;
                    u0.M = arrayList0;
                    u0.N = z1;
                    u0.S = v2;
                    u0.T = v1;
                    mutex5 = mutex1;
                }
                catch(Throwable throwable0) {
                    v6 = v5;
                    mutex4 = mutex2;
                    mutex5 = mutex1;
                    s6 = s1;
                    v16 = v6;
                    mutex9 = mutex4;
                    goto label_229;
                }
                try {
                    u0.V = 0;
                    u0.X = v5;
                    u0.W = 0;
                    u0.b0 = 2;
                    object2 = n1.invoke(arrayList0, u0);
                }
                catch(Throwable throwable0) {
                    v6 = v5;
                    s6 = s1;
                    v16 = v6;
                    mutex9 = mutex4;
                    goto label_229;
                }
                if(object2 == a0) {
                    return a0;
                }
                object3 = object2;
                a1 = a0;
                z3 = z1;
                v7 = 0;
                v8 = 0;
                s7 = s3;
                devLog2 = devLog1;
                v9 = v2;
                s8 = s1;
                v10 = v1;
                v11 = v5;
                mutex6 = mutex5;
                goto label_146;
            }
            case 2: {
                try {
                    int v12 = u0.W;
                    v11 = u0.X;
                    int v13 = u0.T;
                    int v14 = u0.S;
                    boolean z4 = u0.N;
                    int v15 = u0.V;
                    mutex7 = u0.I;
                    object4 = u0.G;
                    devLog3 = u0.E;
                    s9 = u0.D;
                    mutex8 = u0.B;
                    ArrayList arrayList1 = u0.M;
                    String s10 = u0.w;
                    n.D(object0);
                    a1 = a0;
                    devLog2 = devLog3;
                    arrayList0 = arrayList1;
                    mutex4 = mutex7;
                    v8 = v12;
                    v10 = v13;
                    v9 = v14;
                    s2 = s10;
                    mutex6 = mutex8;
                    z3 = z4;
                    s7 = s9;
                    v7 = v15;
                    object3 = object0;
                    s8 = object4;
                }
                catch(Throwable throwable0) {
                    s6 = object4;
                    mutex5 = mutex8;
                    devLog1 = devLog3;
                    mutex9 = mutex7;
                    v16 = v11;
                    s3 = s9;
                    goto label_229;
                }
                try {
                label_146:
                    if(((List)object3).isEmpty()) {
                        goto label_151;
                    }
                    goto label_171;
                }
                catch(Throwable throwable0) {
                    v6 = v11;
                    goto label_192;
                }
                try {
                label_151:
                    LogU.debug$default(this.b, s2 + ", no updated items", null, false, 6, null);
                    z00 = new z0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable0) {
                    mutex9 = mutex4;
                    mutex5 = mutex6;
                    s6 = s8;
                    devLog1 = devLog2;
                    s3 = s7;
                    v16 = v11;
                    goto label_229;
                }
                try {
                    long v17 = System.currentTimeMillis() - v11;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s8 + " Lock return : " + s7 + " (" + v17 + "ms)", null, false, 6, null);
                    devLog2.put("Lock[" + mutex6.hashCode() + "] " + s8 + " Lock return : " + s7 + " (" + v17 + "ms)");
                }
                catch(Throwable throwable1) {
                    mutex10 = mutex4;
                    mutex10.unlock(null);
                    throw throwable1;
                }
                mutex4.unlock(null);
                return z00;
                try {
                label_171:
                    v6 = v11;
                    v v18 = new v(arrayList0, this, null);
                    u0.r = null;
                    u0.w = null;
                    u0.B = mutex6;
                    u0.D = s7;
                    u0.E = devLog2;
                    u0.G = s8;
                    u0.I = mutex4;
                    u0.M = null;
                    u0.N = z3;
                    u0.S = v9;
                    u0.T = v10;
                    u0.V = v7;
                    v6 = v11;
                    u0.X = v6;
                    u0.W = v8;
                    u0.b0 = 3;
                    object0 = this.m(v18, u0);
                    goto label_199;
                }
                catch(Throwable throwable0) {
                }
            label_192:
                mutex5 = mutex6;
                s6 = s8;
                devLog1 = devLog2;
                s3 = s7;
                v16 = v6;
                mutex9 = mutex4;
                goto label_229;
            label_199:
                if(object0 == a1) {
                    return a1;
                }
                mutex9 = mutex4;
                v19 = v6;
                mutex11 = mutex6;
                s6 = s8;
                s11 = s7;
                break;
            }
            case 3: {
                try {
                    v19 = u0.X;
                    mutex9 = u0.I;
                    s6 = u0.G;
                    devLog4 = u0.E;
                    s11 = u0.D;
                    mutex11 = u0.B;
                    n.D(object0);
                    devLog2 = devLog4;
                    break;
                }
                catch(Throwable throwable0) {
                    v16 = v19;
                    s3 = s11;
                    mutex5 = mutex11;
                    devLog1 = devLog4;
                    goto label_229;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            a00 = new A0(((F)object0));
            goto label_233;
        }
        catch(Throwable throwable0) {
            s3 = s11;
            devLog1 = devLog2;
            mutex5 = mutex11;
            v16 = v19;
        }
        try {
        label_229:
            long v20 = System.currentTimeMillis() - v16;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s6 + " Lock return : " + s3 + " (" + v20 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex5.hashCode() + "] " + s6 + " Lock return : " + s3 + " (" + v20 + "ms)");
            throw throwable0;
        label_233:
            long v21 = System.currentTimeMillis() - v19;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex11.hashCode() + "] " + s6 + " Lock return : " + s11 + " (" + v21 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex11.hashCode() + "] " + s6 + " Lock return : " + s11 + " (" + v21 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex10 = mutex9;
            mutex10.unlock(null);
            throw throwable1;
        }
        mutex9.unlock(null);
        return a00;
    }

    @Override  // oc.w
    public final Object i(List list0, c c0) {
        return new S("Not Supported", false);
    }

    public final Object j(CastData castData0, c c0) {
        DevLog devLog2;
        long v6;
        String s4;
        Mutex mutex5;
        Mutex mutex4;
        String s3;
        long v5;
        Mutex mutex2;
        String s1;
        CastData castData1;
        int v2;
        int v1;
        Mutex mutex1;
        DevLog devLog1;
        String s;
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.V;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.V = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.S;
        ne.a a0 = ne.a.a;
        switch(r0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_updateCastData"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_updateCastData", devLog0);
                r0.r = castData0;
                r0.w = mutex0;
                r0.B = "station_updateCastData";
                r0.D = devLog0;
                r0.E = "";
                r0.G = mutex0;
                r0.I = 0;
                r0.M = 0;
                r0.V = 1;
                if(mutex0.lock(null, r0) == a0) {
                    return a0;
                }
                s = "station_updateCastData";
                devLog1 = devLog0;
                mutex1 = mutex0;
                v1 = 0;
                v2 = 0;
                castData1 = castData0;
                s1 = "";
                mutex2 = mutex1;
                goto label_51;
            }
            case 1: {
                int v3 = r0.M;
                int v4 = r0.I;
                mutex2 = r0.G;
                s1 = r0.E;
                devLog1 = r0.D;
                String s2 = r0.B;
                Mutex mutex3 = r0.w;
                castData1 = r0.r;
                n.D(object0);
                v2 = v4;
                s = s2;
                v1 = v3;
                mutex1 = mutex3;
                try {
                label_51:
                    v5 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    LogU.debug$default(this.b, "updateCastData() castSeq: " + castData1.a, null, false, 6, null);
                    t t0 = new t(castData1, null, this);
                    r0.r = null;
                    r0.w = mutex1;
                    r0.B = s;
                    r0.D = devLog1;
                    r0.E = s1;
                    r0.G = mutex2;
                    r0.I = v2;
                    r0.M = v1;
                    r0.N = v5;
                    r0.V = 2;
                    object0 = BuildersKt.withContext(NonCancellable.INSTANCE, t0, r0);
                }
                catch(Throwable throwable0) {
                    s3 = s;
                    mutex4 = mutex2;
                    goto label_102;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex5 = mutex1;
                s4 = s1;
                s3 = s;
                v6 = v5;
                devLog2 = devLog1;
                mutex4 = mutex2;
                break;
            }
            case 2: {
                try {
                    v6 = r0.N;
                    mutex4 = r0.G;
                    s4 = r0.E;
                    devLog2 = r0.D;
                    s3 = r0.B;
                    mutex5 = r0.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog2;
                    s1 = s4;
                    mutex1 = mutex5;
                    v5 = v6;
                    goto label_102;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            F f0 = (F)object0;
            goto label_106;
        }
        catch(Throwable throwable0) {
            mutex1 = mutex5;
            v5 = v6;
            devLog1 = devLog2;
            s1 = s4;
        }
        try {
        label_102:
            long v7 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v7 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v7 + "ms)");
            throw throwable0;
        label_106:
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s4 + " Lock return : " + s3 + " (" + v8 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex5.hashCode() + "] " + s4 + " Lock return : " + s3 + " (" + v8 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex4.unlock(null);
            throw throwable1;
        }
        mutex4.unlock(null);
        return H.a;
    }

    @Override  // oc.H
    public final long k() {
        return this.e;
    }

    @Override  // oc.H
    public final int l() {
        Q q0 = (Q)this.d.getValue();
        this.f.getClass();
        return a.e(q0);
    }

    public final Object m(we.n n0, c c0) {
        tc.w w0;
        if(c0 instanceof tc.w) {
            w0 = (tc.w)c0;
            int v = w0.B;
            if((v & 0x80000000) == 0) {
                w0 = new tc.w(this, c0);
            }
            else {
                w0.B = v ^ 0x80000000;
            }
        }
        else {
            w0 = new tc.w(this, c0);
        }
        Object object0 = w0.r;
        ne.a a0 = ne.a.a;
        MutableStateFlow mutableStateFlow0 = this.d;
        switch(w0.B) {
            case 0: {
                n.D(object0);
                Object object1 = mutableStateFlow0.getValue();
                w0.B = 1;
                object0 = n0.invoke(object1, w0);
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
        mutableStateFlow0.setValue(((F)object0));
        return (F)object0;
    }

    @Override  // oc.H
    public final int p() {
        Q q0 = (Q)this.d.getValue();
        this.f.getClass();
        return a.d(q0);
    }

    @Override  // oc.w
    public final Object q(int v, int v1, c c0) {
        return new oc.t("Not Supported");
    }

    @Override  // oc.w
    public final Object r(long v, Continuation continuation0) {
        long v5;
        Mutex mutex2;
        Mutex mutex1;
        long v2;
        String s1;
        String s;
        DevLog devLog0;
        m m0;
        if(continuation0 instanceof m) {
            m0 = (m)continuation0;
            int v1 = m0.N;
            if((v1 & 0x80000000) == 0) {
                m0 = new m(this, ((c)continuation0));
            }
            else {
                m0.N = v1 ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, ((c)continuation0));
        }
        Object object0 = m0.I;
        ne.a a0 = ne.a.a;
        switch(m0.N) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_saveTimePositionMs"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_saveTimePositionMs", devLog0);
                m0.w = mutex0;
                s = "station_saveTimePositionMs";
                m0.B = "station_saveTimePositionMs";
                m0.D = devLog0;
                s1 = "";
                m0.E = "";
                m0.G = mutex0;
                v2 = v;
                m0.r = v2;
                m0.N = 1;
                if(mutex0.lock(null, m0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                mutex2 = mutex1;
                break;
            }
            case 1: {
                long v3 = m0.r;
                mutex2 = m0.G;
                s1 = m0.E;
                devLog0 = m0.D;
                s = m0.B;
                mutex1 = m0.w;
                n.D(object0);
                v2 = v3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v5 = System.currentTimeMillis();
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
            devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
            this.e = v2;
            this.a.c(v2, "saveTimePositionMs");
        }
        catch(Throwable throwable0) {
            long v6 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v6 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v6 + "ms)");
            throw throwable0;
        }
        finally {
            mutex2.unlock(null);
        }
        long v7 = System.currentTimeMillis() - v5;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
        devLog0.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v7 + "ms)");
        return H.a;
    }

    @Override  // oc.w
    public final Object u(V v0, c c0) {
        Z z0;
        long v15;
        W w2;
        W w1;
        Mutex mutex10;
        long v11;
        Object object3;
        V v10;
        DevLog devLog5;
        Mutex mutex9;
        String s3;
        Mutex mutex8;
        Object object2;
        e e0;
        Mutex mutex7;
        DevLog devLog4;
        long v9;
        W w0;
        Mutex mutex6;
        long v8;
        Mutex mutex5;
        DevLog devLog3;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        MutexLockUtil mutexLockUtil0;
        long v7;
        Mutex mutex2;
        V v4;
        int v3;
        int v2;
        String s1;
        DevLog devLog1;
        String s;
        ne.a a1;
        Mutex mutex1;
        tc.c c1;
        if(c0 instanceof tc.c) {
            c1 = (tc.c)c0;
            int v1 = c1.V;
            if((v1 & 0x80000000) == 0) {
                c1 = new tc.c(this, c0);
            }
            else {
                c1.V = v1 ^ 0x80000000;
            }
        }
        else {
            c1 = new tc.c(this, c0);
        }
        ne.a a0 = ne.a.a;
        Object object0 = c1.S;
        switch(c1.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_add"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_add", devLog0);
                c1.r = v0;
                c1.w = mutex0;
                c1.B = "station_add";
                c1.D = devLog0;
                c1.E = "";
                c1.G = mutex0;
                c1.I = 0;
                c1.M = 0;
                c1.V = 1;
                if(mutex0.lock(null, c1) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                a1 = a0;
                s = "station_add";
                devLog1 = devLog0;
                s1 = "";
                v2 = 0;
                v3 = 0;
                v4 = v0;
                mutex2 = mutex1;
                goto label_56;
            }
            case 1: {
                int v5 = c1.I;
                int v6 = c1.M;
                Mutex mutex3 = c1.G;
                Object object1 = c1.E;
                DevLog devLog2 = c1.D;
                String s2 = c1.B;
                Mutex mutex4 = c1.w;
                v4 = c1.r;
                n.D(object0);
                v3 = v5;
                s1 = object1;
                s = s2;
                mutex1 = mutex3;
                v2 = v6;
                mutex2 = mutex4;
                a1 = a0;
                devLog1 = devLog2;
                try {
                label_56:
                    v7 = System.currentTimeMillis();
                    mutexLockUtil0 = MutexLockUtil.INSTANCE;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    addRequestPlayableListInfo0 = v4.c;
                    LogConstantsKt.debugOnlyDebugMode(this.b, "add()" + ("\nclearBefore: " + v4.a) + ("\nremoveDuplicated: " + v4.b) + ("\naddPlayableListInfoSize: " + addRequestPlayableListInfo0.getUserRequestedPlaylist().size()) + ("\nposition: " + v4.d) + ("\nisAddAndPlay: " + v4.e));
                }
                catch(Throwable throwable0) {
                    devLog3 = devLog1;
                    mutex5 = mutex2;
                    v8 = v7;
                    mutex6 = mutex1;
                    goto label_115;
                }
                if(!(addRequestPlayableListInfo0 instanceof StationAddRequestPlayableListInfo)) {
                    try {
                        w0 = new W(PlaylistId.STATION, "Invalid AddRequest");
                        v9 = System.currentTimeMillis() - v7;
                    }
                    catch(Throwable throwable0) {
                        devLog4 = devLog1;
                        mutex7 = mutex1;
                        goto label_138;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)", null, false, 6, null);
                        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)");
                    }
                    catch(Throwable throwable1) {
                        mutex7 = mutex1;
                        mutex1 = mutex7;
                        mutex1.unlock(null);
                        throw throwable1;
                    }
                    mutex1.unlock(null);
                    return w0;
                }
                try {
                    devLog4 = devLog1;
                    mutex7 = mutex1;
                    if(!((StationAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist().isEmpty()) {
                        if(((StationAddRequestPlayableListInfo)addRequestPlayableListInfo0).getResponse() != null) {
                            d.E(System.currentTimeMillis(), ((StationAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist());
                            e0 = new e(addRequestPlayableListInfo0, null, this);
                            c1.r = v4;
                            mutex5 = mutex2;
                            c1.w = mutex5;
                            c1.B = s;
                            c1.D = devLog4;
                            c1.E = s1;
                            c1.G = mutex7;
                            c1.I = v3;
                            c1.M = v2;
                            devLog3 = devLog4;
                            mutex6 = mutex7;
                            v8 = v7;
                            c1.N = v8;
                            c1.V = 2;
                            object2 = BuildersKt.withContext(NonCancellable.INSTANCE, e0, c1);
                            goto label_120;
                        }
                        goto label_129;
                    }
                    w2 = new W(PlaylistId.STATION, "Empty List");
                    goto label_144;
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex2;
                    devLog3 = devLog4;
                    mutex6 = mutex7;
                    v8 = v7;
                    goto label_115;
                }
                try {
                    c1.N = v8;
                    c1.V = 2;
                    object2 = BuildersKt.withContext(NonCancellable.INSTANCE, e0, c1);
                    goto label_120;
                }
                catch(Throwable throwable0) {
                }
            label_115:
                mutex8 = mutex5;
                s3 = s1;
                mutex9 = mutex6;
                devLog5 = devLog3;
                goto label_182;
            label_120:
                if(object2 == a1) {
                    return a1;
                }
                v10 = v4;
                object3 = object2;
                v11 = v8;
                mutex8 = mutex5;
                mutex10 = mutex6;
                devLog5 = devLog3;
                break;
                try {
                label_129:
                    w1 = new W(PlaylistId.STATION, "Invalid CastData");
                }
                catch(Throwable throwable0) {
                    goto label_138;
                }
                try {
                    long v12 = System.currentTimeMillis() - v7;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v12 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v12 + "ms)");
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex7;
                    mutex1.unlock(null);
                    throw throwable1;
                }
                mutex7.unlock(null);
                return w1;
                try {
                    w2 = new W(PlaylistId.STATION, "Empty List");
                    goto label_144;
                }
                catch(Throwable throwable0) {
                }
            label_138:
                mutex8 = mutex2;
                devLog5 = devLog4;
                mutex9 = mutex7;
                s3 = s1;
                v8 = v7;
                goto label_182;
                try {
                label_144:
                    long v13 = System.currentTimeMillis() - v7;
                    LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v13 + "ms)", null, false, 6, null);
                    devLog4.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v13 + "ms)");
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex7;
                    mutex1.unlock(null);
                    throw throwable1;
                }
                mutex7.unlock(null);
                return w2;
            }
            case 2: {
                try {
                    v8 = c1.N;
                    mutex9 = c1.G;
                    s3 = c1.E;
                    DevLog devLog6 = c1.D;
                    String s4 = c1.B;
                    mutex8 = c1.w;
                    V v14 = c1.r;
                    s = s4;
                    devLog5 = devLog6;
                    n.D(object0);
                    s = s4;
                    s1 = s3;
                    devLog5 = devLog6;
                    mutex10 = mutex9;
                    v11 = v8;
                    v10 = v14;
                    object3 = object0;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_182;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v15 = v11;
            List list0 = ((StationAddRequestPlayableListInfo)v10.c).getUserRequestedPlaylist();
            v15 = v11;
            z0 = new Z(PlaylistId.STATION, list0, true, ((F)object3), this.e);
            goto label_189;
        }
        catch(Throwable throwable0) {
            v8 = v15;
            mutex9 = mutex10;
            s3 = s1;
        }
        try {
        label_182:
            long v16 = System.currentTimeMillis() - v8;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex8.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v16 + "ms)", null, false, 6, null);
            devLog5.put("Lock[" + mutex8.hashCode() + "] " + s3 + " Lock return : " + s + " (" + v16 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex1 = mutex9;
            mutex1.unlock(null);
            throw throwable1;
        }
        try {
        label_189:
            long v17 = System.currentTimeMillis() - v15;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex8.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v17 + "ms)", null, false, 6, null);
            devLog5.put("Lock[" + mutex8.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v17 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex1 = mutex10;
            mutex1.unlock(null);
            throw throwable1;
        }
        mutex10.unlock(null);
        return z0;
    }

    @Override  // oc.w
    public final Object v(int v, long v1, boolean z, String s, Continuation continuation0) {
        long v13;
        Mutex mutex5;
        f0 f00;
        long v12;
        Mutex mutex4;
        int v11;
        LogU logU0;
        int v6;
        Mutex mutex2;
        int v5;
        String s3;
        long v4;
        Mutex mutex1;
        String s2;
        boolean z1;
        String s1;
        DevLog devLog1;
        int v3;
        tc.n n0;
        if(continuation0 instanceof tc.n) {
            n0 = (tc.n)continuation0;
            int v2 = n0.Y;
            if((v2 & 0x80000000) == 0) {
                n0 = new tc.n(this, ((c)continuation0));
            }
            else {
                n0.Y = v2 ^ 0x80000000;
            }
        }
        else {
            n0 = new tc.n(this, ((c)continuation0));
        }
        Object object0 = n0.W;
        ne.a a0 = ne.a.a;
        switch(n0.Y) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_setCurrent"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_setCurrent", devLog0);
                n0.I = s;
                n0.M = mutex0;
                n0.N = "station_setCurrent";
                n0.S = devLog0;
                n0.T = "";
                n0.V = mutex0;
                v3 = v;
                n0.r = v3;
                n0.D = v1;
                n0.G = z;
                n0.w = 0;
                n0.B = 0;
                n0.Y = 1;
                if(mutex0.lock(null, n0) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                s1 = "station_setCurrent";
                z1 = z;
                s2 = s;
                mutex1 = mutex0;
                v4 = v1;
                s3 = "";
                v5 = 0;
                mutex2 = mutex1;
                v6 = 0;
                goto label_65;
            }
            case 1: {
                int v7 = n0.B;
                boolean z2 = n0.G;
                int v8 = n0.w;
                long v9 = n0.D;
                v3 = n0.r;
                mutex2 = n0.V;
                Object object1 = n0.T;
                DevLog devLog2 = n0.S;
                String s4 = n0.N;
                Mutex mutex3 = n0.M;
                String s5 = n0.I;
                n.D(object0);
                v5 = v8;
                s2 = s5;
                v6 = v7;
                v4 = v9;
                z1 = z2;
                s3 = object1;
                devLog1 = devLog2;
                s1 = s4;
                mutex1 = mutex3;
                try {
                label_65:
                    long v10 = System.currentTimeMillis();
                    try {
                        logU0 = MutexLockUtil.INSTANCE.getLog();
                        v11 = mutex1.hashCode();
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v12 = v10;
                        goto label_104;
                    }
                    try {
                        LogU.debug$default(logU0, "Lock[" + v11 + "] " + s3 + " Lock obtain : " + s1, null, false, 6, null);
                        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s3 + " Lock obtain : " + s1);
                        Q q0 = (Q)this.d.getValue();
                        f00 = this.f.c(v3, q0);
                        if(f00 == null) {
                            n0.I = null;
                            mutex4 = mutex1;
                            n0.M = mutex4;
                            n0.N = s1;
                            n0.S = devLog1;
                            n0.T = s3;
                            n0.V = mutex2;
                            n0.r = v3;
                            n0.D = v4;
                            n0.G = z1;
                            n0.w = v5;
                            n0.B = v6;
                            n0.E = v10;
                            n0.Y = 2;
                            v12 = v10;
                            object0 = this.f(v3, v4, s2, true, n0);
                            goto label_110;
                        }
                        else {
                            mutex5 = mutex1;
                            v13 = v10;
                        }
                        goto label_142;
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex1;
                        v12 = v10;
                        goto label_104;
                    }
                    try {
                        object0 = this.f(v3, v4, s2, true, n0);
                        goto label_110;
                    }
                    catch(Throwable throwable1) {
                    }
                label_104:
                    mutex5 = mutex4;
                    String s6 = s3;
                    DevLog devLog3 = devLog1;
                    String s7 = s1;
                    long v14 = v12;
                    goto label_138;
                label_110:
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex5 = mutex4;
                    s6 = s3;
                    devLog3 = devLog1;
                    s7 = s1;
                    Mutex mutex6 = mutex2;
                    v14 = v12;
                    goto label_130;
                    try {
                    label_119:
                        v14 = n0.E;
                        mutex6 = n0.V;
                        s6 = n0.T;
                        devLog3 = n0.S;
                        s7 = n0.N;
                        mutex5 = n0.M;
                        n.D(object0);
                    }
                    catch(Throwable throwable1) {
                        mutex2 = mutex6;
                        goto label_138;
                    }
                    try {
                    label_130:
                        mutex2 = mutex6;
                        s3 = s6;
                        devLog1 = devLog3;
                        s1 = s7;
                        v13 = v14;
                        f00 = (f0)object0;
                        goto label_142;
                    }
                    catch(Throwable throwable1) {
                    }
                label_138:
                    long v15 = System.currentTimeMillis() - v14;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s6 + " Lock return : " + s7 + " (" + v15 + "ms)", null, false, 6, null);
                    devLog3.put("Lock[" + mutex5.hashCode() + "] " + s6 + " Lock return : " + s7 + " (" + v15 + "ms)");
                    throw throwable1;
                label_142:
                    long v16 = System.currentTimeMillis() - v13;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex5.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v16 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex5.hashCode() + "] " + s3 + " Lock return : " + s1 + " (" + v16 + "ms)");
                    goto label_149;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_119;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_149:
        mutex2.unlock(null);
        return f00;
    }

    @Override  // oc.H
    public final ListKeepOption x() {
        ListKeepOption listKeepOption0 = MelonSettingInfo.getCurrentListKeepOption();
        q.f(listKeepOption0, "getCurrentListKeepOption(...)");
        return listKeepOption0;
    }

    @Override  // oc.w
    public final Object z(Continuation continuation0) {
        oc.n n0;
        long v5;
        String s4;
        DevLog devLog4;
        Mutex mutex7;
        String s3;
        Mutex mutex6;
        int v4;
        DevLog devLog3;
        Mutex mutex5;
        long v3;
        Mutex mutex2;
        int v2;
        String s1;
        DevLog devLog1;
        Mutex mutex1;
        int v1;
        String s;
        i i0;
        if(continuation0 instanceof i) {
            i0 = (i)continuation0;
            int v = i0.V;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, ((c)continuation0));
            }
            else {
                i0.V = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, ((c)continuation0));
        }
        Object object0 = i0.S;
        ne.a a0 = ne.a.a;
        switch(i0.V) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : station_previous"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : station_previous", devLog0);
                i0.r = mutex0;
                i0.w = "station_previous";
                i0.B = devLog0;
                i0.D = "";
                i0.E = mutex0;
                i0.G = 0;
                i0.I = 0;
                i0.V = 1;
                if(mutex0.lock(null, i0) != a0) {
                    s = "";
                    v1 = 0;
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s1 = "station_previous";
                    v2 = 0;
                    mutex2 = mutex1;
                    goto label_48;
                }
                return a0;
            }
            case 1: {
                v2 = i0.I;
                v1 = i0.G;
                Mutex mutex3 = i0.E;
                s = i0.D;
                DevLog devLog2 = i0.B;
                String s2 = i0.w;
                Mutex mutex4 = i0.r;
                n.D(object0);
                s1 = s2;
                mutex1 = mutex3;
                devLog1 = devLog2;
                mutex2 = mutex4;
                try {
                label_48:
                    v3 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s + " Lock obtain : " + s1);
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    v4 = this.l();
                    i0.r = mutex2;
                    i0.w = s1;
                    i0.B = devLog1;
                    i0.D = s;
                    i0.E = mutex1;
                    i0.G = v1;
                    i0.I = v2;
                    i0.N = v3;
                    i0.M = v4;
                    i0.V = 2;
                    mutex5 = mutex2;
                    devLog3 = devLog1;
                    if(this.f(v4, 0L, "previous", true, i0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex6 = mutex1;
                    s3 = s;
                    mutex7 = mutex5;
                    devLog4 = devLog3;
                    s4 = s1;
                    goto label_95;
                }
                v5 = v3;
                mutex6 = mutex1;
                s3 = s;
                mutex7 = mutex5;
                devLog4 = devLog3;
                s4 = s1;
                n0 = new oc.n(v4);
                goto label_99;
            }
            case 2: {
                try {
                    v4 = i0.M;
                    v5 = i0.N;
                    mutex6 = i0.E;
                    s3 = i0.D;
                    devLog4 = i0.B;
                    s4 = i0.w;
                    mutex7 = i0.r;
                    n.D(object0);
                    n0 = new oc.n(v4);
                    goto label_99;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v3 = v5;
        try {
        label_95:
            long v6 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v6 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v6 + "ms)");
            throw throwable0;
        label_99:
            long v7 = System.currentTimeMillis() - v5;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex7.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex6.unlock(null);
            throw throwable1;
        }
        mutex6.unlock(null);
        return n0;
    }
}

