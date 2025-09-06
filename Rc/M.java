package rc;

import H0.b;
import androidx.appcompat.app.o;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.MusicWaveAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MusicWave;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.playback.playlist.musicwave.MusicWavePlaylistRepositoryImpl;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import e3.h;
import ie.H;
import ie.p;
import java.util.ArrayList;
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
import oc.A0;
import oc.K;
import oc.Q;
import oc.S;
import oc.V;
import oc.W;
import oc.Z;
import oc.d0;
import oc.i;
import oc.k;
import oc.t;
import oc.w;
import oc.z0;
import oe.c;

public final class m implements K, w, a {
    public final MusicWavePlaylistRepositoryImpl a;
    public final LogU b;
    public final Mutex c;
    public final MutableStateFlow d;
    public long e;
    public final h f;

    public m(MusicWavePlaylistRepositoryImpl musicWavePlaylistRepositoryImpl0) {
        this.a = musicWavePlaylistRepositoryImpl0;
        this.b = new LogU("MusicWavePlaylistImpl");
        this.c = MutexKt.Mutex$default(false, 1, null);
        this.d = StateFlowKt.MutableStateFlow(new n(je.w.a, -1, null, null, null));
        this.e = -1L;
        new lc.a("MusicWavePlaylistImpl");
        this.f = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.w
    public final Object B(Continuation continuation0) {
        Object object2;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo1;
        long v18;
        String s5;
        Mutex mutex7;
        String s4;
        Mutex mutex6;
        long v17;
        int v16;
        DevLog devLog4;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0;
        String s3;
        DevLog devLog3;
        Object object1;
        Mutex mutex5;
        int v15;
        long v13;
        int v12;
        int v11;
        long v10;
        Mutex mutex4;
        int v9;
        int v8;
        int v7;
        int v6;
        long v3;
        String s1;
        int v2;
        int v1;
        Mutex mutex2;
        Mutex mutex1;
        DevLog devLog1;
        String s;
        e e0;
        if(continuation0 instanceof e) {
            e0 = (e)continuation0;
            int v = e0.W;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, ((c)continuation0));
            }
            else {
                e0.W = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, ((c)continuation0));
        }
        Object object0 = e0.T;
        ne.a a0 = ne.a.a;
        switch(e0.W) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : musicWave_nextWhenPlayCompleted"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : musicWave_nextWhenPlayCompleted", devLog0);
                e0.r = mutex0;
                e0.w = "musicWave_nextWhenPlayCompleted";
                e0.B = devLog0;
                s = "";
                e0.D = "";
                e0.E = mutex0;
                e0.G = 0;
                e0.I = 0;
                e0.W = 1;
                if(mutex0.lock(null, e0) == a0) {
                    return a0;
                }
                try {
                    devLog1 = devLog0;
                    mutex1 = mutex0;
                    mutex2 = mutex1;
                    v1 = 0;
                    v2 = 0;
                    s1 = "musicWave_nextWhenPlayCompleted";
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + "" + " Lock obtain : " + "musicWave_nextWhenPlayCompleted", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + "" + " Lock obtain : " + "musicWave_nextWhenPlayCompleted");
                    goto label_54;
                }
                catch(Throwable throwable1) {
                    goto label_134;
                }
            }
            case 1: {
                int v4 = e0.I;
                int v5 = e0.G;
                mutex2 = e0.E;
                s = e0.D;
                DevLog devLog2 = e0.B;
                String s2 = e0.w;
                Mutex mutex3 = e0.r;
                d5.n.D(object0);
                s1 = s2;
                v2 = v5;
                devLog1 = devLog2;
                v1 = v4;
                mutex1 = mutex3;
                try {
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1);
                }
                catch(Throwable throwable1) {
                    goto label_134;
                }
                try {
                label_54:
                    MusicWaveChannelInfo musicWaveChannelInfo0 = this.c().c;
                    q.d(musicWaveChannelInfo0);
                    v6 = v2;
                    v7 = 0;
                    MusicWave playDataForSeverContent$MusicWave0 = new MusicWave(musicWaveChannelInfo0, "1000003041", null);
                    e0.r = mutex1;
                    e0.w = s1;
                    e0.B = devLog1;
                    e0.D = s;
                    e0.E = mutex2;
                    v6 = v2;
                    e0.G = v6;
                    e0.I = v1;
                    e0.M = 0;
                    e0.S = v3;
                    e0.N = 0;
                    e0.W = 2;
                    object0 = playDataForSeverContent$MusicWave0.getPlayableList(e0);
                }
                catch(Throwable throwable2) {
                    v8 = 0;
                    goto label_128;
                }
                if(object0 == a0) {
                    return a0;
                }
                v9 = v6;
                mutex4 = mutex1;
                v10 = v3;
                v11 = v1;
                v12 = 0;
                goto label_114;
            }
            case 2: {
                try {
                    v13 = e0.S;
                    int v14 = e0.M;
                    v11 = e0.I;
                    v15 = e0.N;
                    v9 = e0.G;
                    mutex5 = e0.E;
                    object1 = e0.D;
                    devLog3 = e0.B;
                    s3 = e0.w;
                    mutex4 = e0.r;
                    v7 = v14;
                    d5.n.D(object0);
                    v7 = v14;
                    v12 = v15;
                    v10 = v13;
                    mutex2 = mutex5;
                    s = object1;
                    devLog1 = devLog3;
                    s1 = s3;
                }
                catch(Throwable throwable2) {
                    v8 = v15;
                    mutex1 = mutex4;
                    v6 = v9;
                    v1 = v11;
                    v3 = v13;
                    mutex2 = mutex5;
                    s = object1;
                    devLog1 = devLog3;
                    s1 = s3;
                    goto label_128;
                }
                try {
                label_114:
                    v8 = v12;
                    v1 = v11;
                    musicWaveAddRequestPlayableListInfo0 = (MusicWaveAddRequestPlayableListInfo)object0;
                    v8 = v12;
                    v1 = v11;
                    devLog4 = devLog1;
                    v16 = v9;
                    v17 = v10;
                    mutex1 = mutex4;
                    goto label_139;
                }
                catch(Throwable throwable2) {
                    v3 = v10;
                    mutex1 = mutex4;
                    v6 = v9;
                }
                try {
                label_128:
                    musicWaveAddRequestPlayableListInfo0 = d5.n.t(throwable2);
                    v17 = v3;
                    devLog4 = devLog1;
                    v16 = v6;
                }
                catch(Throwable throwable1) {
                label_134:
                    mutex6 = mutex1;
                    s4 = s;
                    mutex7 = mutex2;
                    s5 = s1;
                    goto label_206;
                }
                try {
                label_139:
                    v18 = v17;
                    musicWaveAddRequestPlayableListInfo1 = musicWaveAddRequestPlayableListInfo0 instanceof ie.o ? null : musicWaveAddRequestPlayableListInfo0;
                    if(musicWaveAddRequestPlayableListInfo1 == null) {
                        Throwable throwable3 = p.a(musicWaveAddRequestPlayableListInfo0);
                        LogU.error$default(this.b, "nextWhenPlayCompleted() failed. " + throwable3, null, false, 6, null);
                        object2 = new i("Failed to get next song");
                    }
                    else {
                        goto label_154;
                    }
                    goto label_213;
                }
                catch(Throwable throwable1) {
                    mutex6 = mutex1;
                    s4 = s;
                    mutex7 = mutex2;
                    s5 = s1;
                    devLog1 = devLog4;
                    v3 = v18;
                    goto label_206;
                }
                try {
                label_154:
                    e0.r = mutex1;
                    e0.w = s1;
                    e0.B = devLog4;
                    e0.D = s;
                    e0.E = mutex2;
                    e0.G = v16;
                    e0.I = v1;
                    e0.M = v7;
                    e0.S = v18;
                    e0.N = v8;
                    e0.W = 3;
                    object0 = this.f(musicWaveAddRequestPlayableListInfo1, e0);
                }
                catch(Throwable throwable1) {
                    mutex6 = mutex1;
                    devLog1 = devLog4;
                    s4 = s;
                    mutex7 = mutex2;
                    s5 = s1;
                    goto label_205;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex6 = mutex1;
                s4 = s;
                mutex7 = mutex2;
                s5 = s1;
                goto label_193;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v18 = e0.S;
            mutex7 = e0.E;
            s4 = e0.D;
            devLog4 = e0.B;
            s5 = e0.w;
            mutex6 = e0.r;
            d5.n.D(object0);
        }
        catch(Throwable throwable1) {
            devLog1 = devLog4;
            v3 = v18;
            goto label_206;
        }
        try {
        label_193:
            if(((Boolean)object0).booleanValue()) {
                object2 = new k(this.c(), this.e);
            }
            else {
                LogU.error$default(this.b, "nextWhenPlayCompleted() failed. replaceInternal failed", null, false, 6, null);
                object2 = new i("Failed to get next song");
            }
            mutex2 = mutex7;
            s1 = s5;
            s = s4;
            mutex1 = mutex6;
            goto label_213;
        }
        catch(Throwable throwable1) {
            devLog1 = devLog4;
        }
    label_205:
        v3 = v18;
        try {
        label_206:
            long v19 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s4 + " Lock return : " + s5 + " (" + v19 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex6.hashCode() + "] " + s4 + " Lock return : " + s5 + " (" + v19 + "ms)");
            throw throwable1;
        }
        catch(Throwable throwable0) {
            mutex2 = mutex7;
            mutex2.unlock(null);
            throw throwable0;
        }
        try {
        label_213:
            long v20 = System.currentTimeMillis() - v18;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v20 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v20 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex2.unlock(null);
            throw throwable0;
        }
        mutex2.unlock(null);
        return object2;
    }

    @Override  // oc.H
    public final AddPosition C() {
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        q.f(addPosition0, "getPlayListAddPosition(...)");
        return addPosition0;
    }

    @Override  // oc.w
    public final Object a(String s, Continuation continuation0) {
        return H.a;
    }

    @Override  // oc.H
    public final Object b(c c0) {
        Mutex mutex1;
        rc.c c1;
        if(c0 instanceof rc.c) {
            c1 = (rc.c)c0;
            int v = c1.D;
            if((v & 0x80000000) == 0) {
                c1 = new rc.c(this, c0);
            }
            else {
                c1.D = v ^ 0x80000000;
            }
        }
        else {
            c1 = new rc.c(this, c0);
        }
        Object object0 = c1.w;
        ne.a a0 = ne.a.a;
        switch(c1.D) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.c;
                c1.r = mutex0;
                c1.D = 1;
                if(mutex0.lock(null, c1) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                break;
            }
            case 1: {
                mutex1 = c1.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            return (n)this.d.getValue();
        }
        finally {
            mutex1.unlock(null);
        }
    }

    public final n c() {
        return (n)this.d.getValue();
    }

    @Override  // oc.H
    public final MutableStateFlow d() {
        return this.d;
    }

    public final Object e(c c0) {
        Object object2;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo1;
        long v18;
        String s5;
        Mutex mutex7;
        String s4;
        Mutex mutex6;
        long v17;
        int v16;
        DevLog devLog4;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0;
        String s3;
        DevLog devLog3;
        Object object1;
        Mutex mutex5;
        int v15;
        long v13;
        int v12;
        int v11;
        long v10;
        Mutex mutex4;
        int v9;
        int v8;
        int v7;
        int v6;
        long v3;
        String s1;
        int v2;
        int v1;
        Mutex mutex2;
        Mutex mutex1;
        DevLog devLog1;
        String s;
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.W;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.W = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.T;
        ne.a a0 = ne.a.a;
        switch(d0.W) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : musicWave_handleResume"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : musicWave_handleResume", devLog0);
                d0.r = mutex0;
                d0.w = "musicWave_handleResume";
                d0.B = devLog0;
                s = "";
                d0.D = "";
                d0.E = mutex0;
                d0.G = 0;
                d0.I = 0;
                d0.W = 1;
                if(mutex0.lock(null, d0) == a0) {
                    return a0;
                }
                try {
                    devLog1 = devLog0;
                    mutex1 = mutex0;
                    mutex2 = mutex1;
                    v1 = 0;
                    v2 = 0;
                    s1 = "musicWave_handleResume";
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + "" + " Lock obtain : " + "musicWave_handleResume", null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + "" + " Lock obtain : " + "musicWave_handleResume");
                    goto label_54;
                }
                catch(Throwable throwable1) {
                    goto label_134;
                }
            }
            case 1: {
                int v4 = d0.I;
                int v5 = d0.G;
                mutex2 = d0.E;
                s = d0.D;
                DevLog devLog2 = d0.B;
                String s2 = d0.w;
                Mutex mutex3 = d0.r;
                d5.n.D(object0);
                s1 = s2;
                v2 = v5;
                devLog1 = devLog2;
                v1 = v4;
                mutex1 = mutex3;
                try {
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex2.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock obtain : " + s1);
                }
                catch(Throwable throwable1) {
                    goto label_134;
                }
                try {
                label_54:
                    MusicWaveChannelInfo musicWaveChannelInfo0 = this.c().c;
                    q.d(musicWaveChannelInfo0);
                    v6 = v2;
                    v7 = 0;
                    MusicWave playDataForSeverContent$MusicWave0 = new MusicWave(musicWaveChannelInfo0, "1000003041", null);
                    d0.r = mutex1;
                    d0.w = s1;
                    d0.B = devLog1;
                    d0.D = s;
                    d0.E = mutex2;
                    v6 = v2;
                    d0.G = v6;
                    d0.I = v1;
                    d0.M = 0;
                    d0.S = v3;
                    d0.N = 0;
                    d0.W = 2;
                    object0 = playDataForSeverContent$MusicWave0.getPlayableList(d0);
                }
                catch(Throwable throwable2) {
                    v8 = 0;
                    goto label_128;
                }
                if(object0 == a0) {
                    return a0;
                }
                v9 = v6;
                mutex4 = mutex1;
                v10 = v3;
                v11 = v1;
                v12 = 0;
                goto label_114;
            }
            case 2: {
                try {
                    v13 = d0.S;
                    int v14 = d0.M;
                    v11 = d0.I;
                    v15 = d0.N;
                    v9 = d0.G;
                    mutex5 = d0.E;
                    object1 = d0.D;
                    devLog3 = d0.B;
                    s3 = d0.w;
                    mutex4 = d0.r;
                    v7 = v14;
                    d5.n.D(object0);
                    v7 = v14;
                    v12 = v15;
                    v10 = v13;
                    mutex2 = mutex5;
                    s = object1;
                    devLog1 = devLog3;
                    s1 = s3;
                }
                catch(Throwable throwable2) {
                    v8 = v15;
                    mutex1 = mutex4;
                    v6 = v9;
                    v1 = v11;
                    v3 = v13;
                    mutex2 = mutex5;
                    s = object1;
                    devLog1 = devLog3;
                    s1 = s3;
                    goto label_128;
                }
                try {
                label_114:
                    v8 = v12;
                    v1 = v11;
                    musicWaveAddRequestPlayableListInfo0 = (MusicWaveAddRequestPlayableListInfo)object0;
                    v8 = v12;
                    v1 = v11;
                    devLog4 = devLog1;
                    v16 = v9;
                    v17 = v10;
                    mutex1 = mutex4;
                    goto label_139;
                }
                catch(Throwable throwable2) {
                    v3 = v10;
                    mutex1 = mutex4;
                    v6 = v9;
                }
                try {
                label_128:
                    musicWaveAddRequestPlayableListInfo0 = d5.n.t(throwable2);
                    v17 = v3;
                    devLog4 = devLog1;
                    v16 = v6;
                }
                catch(Throwable throwable1) {
                label_134:
                    mutex6 = mutex1;
                    s4 = s;
                    mutex7 = mutex2;
                    s5 = s1;
                    goto label_206;
                }
                try {
                label_139:
                    v18 = v17;
                    musicWaveAddRequestPlayableListInfo1 = musicWaveAddRequestPlayableListInfo0 instanceof ie.o ? null : musicWaveAddRequestPlayableListInfo0;
                    if(musicWaveAddRequestPlayableListInfo1 == null) {
                        Throwable throwable3 = p.a(musicWaveAddRequestPlayableListInfo0);
                        LogU.error$default(this.b, "handleResume() failed. " + throwable3, null, false, 6, null);
                        object2 = new oc.p("Failed to get next song");
                    }
                    else {
                        goto label_154;
                    }
                    goto label_213;
                }
                catch(Throwable throwable1) {
                    mutex6 = mutex1;
                    s4 = s;
                    mutex7 = mutex2;
                    s5 = s1;
                    devLog1 = devLog4;
                    v3 = v18;
                    goto label_206;
                }
                try {
                label_154:
                    d0.r = mutex1;
                    d0.w = s1;
                    d0.B = devLog4;
                    d0.D = s;
                    d0.E = mutex2;
                    d0.G = v16;
                    d0.I = v1;
                    d0.M = v7;
                    d0.S = v18;
                    d0.N = v8;
                    d0.W = 3;
                    object0 = this.f(musicWaveAddRequestPlayableListInfo1, d0);
                }
                catch(Throwable throwable1) {
                    mutex6 = mutex1;
                    devLog1 = devLog4;
                    s4 = s;
                    mutex7 = mutex2;
                    s5 = s1;
                    goto label_205;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex6 = mutex1;
                s4 = s;
                mutex7 = mutex2;
                s5 = s1;
                goto label_193;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v18 = d0.S;
            mutex7 = d0.E;
            s4 = d0.D;
            devLog4 = d0.B;
            s5 = d0.w;
            mutex6 = d0.r;
            d5.n.D(object0);
        }
        catch(Throwable throwable1) {
            devLog1 = devLog4;
            v3 = v18;
            goto label_206;
        }
        try {
        label_193:
            if(((Boolean)object0).booleanValue()) {
                object2 = new oc.q(this.c(), this.e);
            }
            else {
                LogU.error$default(this.b, "handleResume() failed. replaceInternal failed", null, false, 6, null);
                object2 = new oc.p("Failed to get next song");
            }
            mutex2 = mutex7;
            s1 = s5;
            s = s4;
            mutex1 = mutex6;
            goto label_213;
        }
        catch(Throwable throwable1) {
            devLog1 = devLog4;
        }
    label_205:
        v3 = v18;
        try {
        label_206:
            long v19 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s4 + " Lock return : " + s5 + " (" + v19 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex6.hashCode() + "] " + s4 + " Lock return : " + s5 + " (" + v19 + "ms)");
            throw throwable1;
        }
        catch(Throwable throwable0) {
            mutex2 = mutex7;
            mutex2.unlock(null);
            throw throwable0;
        }
        try {
        label_213:
            long v20 = System.currentTimeMillis() - v18;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v20 + "ms)", null, false, 6, null);
            devLog4.put("Lock[" + mutex1.hashCode() + "] " + s + " Lock return : " + s1 + " (" + v20 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex2.unlock(null);
            throw throwable0;
        }
        mutex2.unlock(null);
        return object2;
    }

    public final Object f(MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0, c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                d5.n.D(object0);
                if(musicWaveAddRequestPlayableListInfo0.getUserRequestedPlaylist().isEmpty()) {
                    LogU.error$default(this.b, "replaceInternal() - empty list", null, false, 6, null);
                    return false;
                }
                rc.h h0 = new rc.h(musicWaveAddRequestPlayableListInfo0, null, this);
                f0.B = 1;
                return BuildersKt.withContext(NonCancellable.INSTANCE, h0, f0) == a0 ? a0 : true;
            }
            case 1: {
                d5.n.D(object0);
                return true;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // oc.w
    public final Object g(Continuation continuation0) {
        return new oc.f("Not Supported");
    }

    @Override  // oc.H
    public final PlaylistId getId() {
        return PlaylistId.MUSIC_WAVE;
    }

    @Override  // oc.H
    public final String getMenuId() {
        return "1000003041";
    }

    @Override  // oc.H
    public final Q getState() {
        return this.c();
    }

    @Override  // oc.w
    public final Object h(String s, boolean z, we.n n0, c c0) {
        A0 a00;
        Object object5;
        Mutex mutex12;
        z0 z00;
        long v15;
        Mutex mutex11;
        Mutex mutex10;
        String s7;
        DevLog devLog3;
        Mutex mutex9;
        long v11;
        int v9;
        int v8;
        Mutex mutex8;
        boolean z3;
        ne.a a1;
        Object object3;
        String s6;
        DevLog devLog2;
        long v7;
        Mutex mutex7;
        Object object2;
        long v6;
        Mutex mutex6;
        Mutex mutex5;
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
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.Z;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.Z = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.X;
        ne.a a0 = ne.a.a;
        switch(j0.Z) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), b.f(mutex0.hashCode(), "Lock[", "]  try : ", "musicWave_" + ("updatePlayable-" + s)), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                devLog0.put("Lock[" + mutex0.hashCode() + "]  try : " + ("musicWave_" + ("updatePlayable-" + s)));
                j0.r = n0;
                j0.w = "updatePlayable-" + s;
                j0.B = mutex0;
                j0.D = "musicWave_" + ("updatePlayable-" + s);
                j0.E = devLog0;
                s1 = "";
                j0.G = "";
                j0.I = mutex0;
                z1 = z;
                j0.M = z1;
                j0.N = 0;
                j0.S = 0;
                j0.Z = 1;
                if(mutex0.lock(null, j0) == a0) {
                    return a0;
                }
                s2 = "updatePlayable-" + s;
                mutex1 = mutex0;
                mutex2 = mutex1;
                n1 = n0;
                s3 = "musicWave_" + ("updatePlayable-" + s);
                v1 = 0;
                v2 = 0;
                devLog1 = devLog0;
                goto label_62;
            }
            case 1: {
                int v3 = j0.N;
                boolean z2 = j0.M;
                Mutex mutex3 = j0.I;
                Object object1 = j0.G;
                devLog0 = j0.E;
                String s4 = j0.D;
                int v4 = j0.S;
                Mutex mutex4 = j0.B;
                String s5 = j0.w;
                n1 = j0.r;
                d5.n.D(object0);
                mutex2 = mutex3;
                v1 = v4;
                mutex1 = mutex4;
                v2 = v3;
                s3 = s4;
                s1 = object1;
                s2 = s5;
                z1 = z2;
                devLog1 = devLog0;
                try {
                label_62:
                    v5 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s3, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s3);
                    arrayList0 = e1.b.B(this.c());
                    j0.r = null;
                    j0.w = s2;
                    j0.B = mutex1;
                    j0.D = s3;
                    j0.E = devLog1;
                    j0.G = s1;
                    mutex5 = mutex2;
                    j0.I = mutex5;
                    j0.M = z1;
                    j0.N = v2;
                    j0.S = v1;
                    mutex6 = mutex1;
                }
                catch(Throwable throwable0) {
                    v6 = v5;
                    mutex5 = mutex2;
                    mutex6 = mutex1;
                    goto label_92;
                }
                try {
                    j0.T = 0;
                    j0.W = v5;
                    j0.V = 0;
                    j0.Z = 2;
                    object2 = n1.invoke(arrayList0, j0);
                    goto label_97;
                }
                catch(Throwable throwable0) {
                    v6 = v5;
                }
            label_92:
                mutex7 = mutex5;
                v7 = v6;
                devLog2 = devLog1;
                s6 = s3;
                goto label_216;
            label_97:
                if(object2 == a0) {
                    return a0;
                }
                object3 = object2;
                a1 = a0;
                mutex7 = mutex5;
                z3 = z1;
                mutex8 = mutex6;
                v8 = 0;
                v9 = 0;
                goto label_143;
            }
            case 2: {
                try {
                    int v10 = j0.V;
                    v11 = j0.W;
                    int v12 = j0.S;
                    int v13 = j0.N;
                    boolean z4 = j0.M;
                    int v14 = j0.T;
                    mutex9 = j0.I;
                    Object object4 = j0.G;
                    devLog3 = j0.E;
                    s7 = j0.D;
                    mutex10 = j0.B;
                    String s8 = j0.w;
                    s1 = object4;
                    d5.n.D(object0);
                    a1 = a0;
                    z3 = z4;
                    devLog1 = devLog3;
                    s3 = s7;
                    v9 = v14;
                    mutex8 = mutex10;
                    object3 = object0;
                    mutex7 = mutex9;
                    v2 = v13;
                    v5 = v11;
                    v1 = v12;
                    s2 = s8;
                    v8 = v10;
                    s1 = object4;
                }
                catch(Throwable throwable0) {
                    mutex6 = mutex10;
                    v7 = v11;
                    devLog2 = devLog3;
                    s6 = s7;
                    mutex7 = mutex9;
                    goto label_216;
                }
                try {
                label_143:
                    if(((List)object3).isEmpty()) {
                        goto label_149;
                    }
                    goto label_163;
                }
                catch(Throwable throwable0) {
                    mutex11 = mutex7;
                    v15 = v5;
                    goto label_185;
                }
                try {
                label_149:
                    LogU.debug$default(this.b, s2 + " no updated items", null, false, 6, null);
                    z00 = new z0();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                catch(Throwable throwable0) {
                    mutex6 = mutex8;
                    devLog2 = devLog1;
                    s6 = s3;
                    v7 = v5;
                    goto label_216;
                }
                try {
                    long v16 = System.currentTimeMillis() - v5;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex8.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v16 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex8.hashCode() + "] " + s1 + " Lock return : " + s3 + " (" + v16 + "ms)");
                }
                catch(Throwable throwable1) {
                    mutex7.unlock(null);
                    throw throwable1;
                }
                mutex7.unlock(null);
                return z00;
                try {
                label_163:
                    mutex11 = mutex7;
                    v15 = v5;
                    rc.k k0 = new rc.k(this, null);
                    j0.r = null;
                    j0.w = null;
                    j0.B = mutex8;
                    j0.D = s3;
                    j0.E = devLog1;
                    j0.G = s1;
                    j0.I = mutex7;
                    j0.M = z3;
                    j0.N = v2;
                    j0.S = v1;
                    j0.T = v9;
                    mutex11 = mutex7;
                    v15 = v5;
                    j0.W = v15;
                    j0.V = v8;
                    j0.Z = 3;
                    object0 = this.j(k0, j0);
                    goto label_191;
                }
                catch(Throwable throwable0) {
                }
            label_185:
                mutex6 = mutex8;
                devLog2 = devLog1;
                s6 = s3;
                mutex7 = mutex11;
                v7 = v15;
                goto label_216;
            label_191:
                if(object0 == a1) {
                    return a1;
                }
                mutex12 = mutex8;
                devLog2 = devLog1;
                s6 = s3;
                mutex7 = mutex11;
                v7 = v15;
                break;
            }
            case 3: {
                try {
                    v7 = j0.W;
                    mutex7 = j0.I;
                    object5 = j0.G;
                    devLog2 = j0.E;
                    s6 = j0.D;
                    mutex12 = j0.B;
                    d5.n.D(object0);
                    s1 = object5;
                    break;
                }
                catch(Throwable throwable0) {
                    mutex6 = mutex12;
                    s1 = object5;
                    goto label_216;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            a00 = new A0(((n)object0));
            goto label_220;
        }
        catch(Throwable throwable0) {
            mutex6 = mutex12;
        }
        try {
        label_216:
            long v17 = System.currentTimeMillis() - v7;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex6.hashCode() + "] " + s1 + " Lock return : " + s6 + " (" + v17 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex6.hashCode() + "] " + s1 + " Lock return : " + s6 + " (" + v17 + "ms)");
            throw throwable0;
        label_220:
            long v18 = System.currentTimeMillis() - v7;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex12.hashCode() + "] " + s1 + " Lock return : " + s6 + " (" + v18 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex12.hashCode() + "] " + s1 + " Lock return : " + s6 + " (" + v18 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex7.unlock(null);
            throw throwable1;
        }
        mutex7.unlock(null);
        return a00;
    }

    @Override  // oc.w
    public final Object i(List list0, c c0) {
        return new S("Not Supported", false);
    }

    public final Object j(we.n n0, c c0) {
        l l0;
        if(c0 instanceof l) {
            l0 = (l)c0;
            int v = l0.B;
            if((v & 0x80000000) == 0) {
                l0 = new l(this, c0);
            }
            else {
                l0.B = v ^ 0x80000000;
            }
        }
        else {
            l0 = new l(this, c0);
        }
        Object object0 = l0.r;
        ne.a a0 = ne.a.a;
        MutableStateFlow mutableStateFlow0 = this.d;
        switch(l0.B) {
            case 0: {
                d5.n.D(object0);
                Object object1 = mutableStateFlow0.getValue();
                l0.B = 1;
                object0 = n0.invoke(object1, l0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutableStateFlow0.setValue(((n)object0));
        return (n)object0;
    }

    @Override  // oc.H
    public final long k() {
        return this.e;
    }

    @Override  // oc.H
    public final int l() {
        return 0;
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
        long v5;
        Mutex mutex2;
        Mutex mutex1;
        long v2;
        String s1;
        String s;
        DevLog devLog0;
        rc.i i0;
        if(continuation0 instanceof rc.i) {
            i0 = (rc.i)continuation0;
            int v1 = i0.N;
            if((v1 & 0x80000000) == 0) {
                i0 = new rc.i(this, ((c)continuation0));
            }
            else {
                i0.N = v1 ^ 0x80000000;
            }
        }
        else {
            i0 = new rc.i(this, ((c)continuation0));
        }
        Object object0 = i0.I;
        ne.a a0 = ne.a.a;
        switch(i0.N) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : musicWave_saveTimePositionMs"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : musicWave_saveTimePositionMs", devLog0);
                i0.w = mutex0;
                s = "musicWave_saveTimePositionMs";
                i0.B = "musicWave_saveTimePositionMs";
                i0.D = devLog0;
                s1 = "";
                i0.E = "";
                i0.G = mutex0;
                v2 = v;
                i0.r = v2;
                i0.N = 1;
                if(mutex0.lock(null, i0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                mutex2 = mutex1;
                break;
            }
            case 1: {
                long v3 = i0.r;
                mutex2 = i0.G;
                s1 = i0.E;
                devLog0 = i0.D;
                s = i0.B;
                mutex1 = i0.w;
                d5.n.D(object0);
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
        Object object4;
        Mutex mutex9;
        Object object2;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0;
        Mutex mutex8;
        Mutex mutex7;
        long v9;
        W w0;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        Mutex mutex6;
        Mutex mutex5;
        DevLog devLog3;
        long v8;
        LogU logU0;
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
        rc.b b0;
        if(c0 instanceof rc.b) {
            b0 = (rc.b)c0;
            int v1 = b0.W;
            if((v1 & 0x80000000) == 0) {
                b0 = new rc.b(this, c0);
            }
            else {
                b0.W = v1 ^ 0x80000000;
            }
        }
        else {
            b0 = new rc.b(this, c0);
        }
        ne.a a0 = ne.a.a;
        Object object0 = b0.T;
        switch(b0.W) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex0 = this.c;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : musicWave_add"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : musicWave_add", devLog0);
                b0.r = v0;
                b0.w = mutex0;
                b0.B = "musicWave_add";
                b0.D = devLog0;
                b0.E = "";
                b0.G = mutex0;
                b0.M = 0;
                b0.N = 0;
                b0.W = 1;
                if(mutex0.lock(null, b0) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                a1 = a0;
                s = "musicWave_add";
                devLog1 = devLog0;
                s1 = "";
                v2 = 0;
                v3 = 0;
                v4 = v0;
                mutex2 = mutex1;
                goto label_56;
            }
            case 1: {
                int v5 = b0.M;
                int v6 = b0.N;
                Mutex mutex3 = b0.G;
                Object object1 = b0.E;
                DevLog devLog2 = b0.D;
                String s2 = b0.B;
                Mutex mutex4 = b0.w;
                v4 = b0.r;
                d5.n.D(object0);
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
                    logU0 = mutexLockUtil0.getLog();
                }
                catch(Throwable throwable0) {
                    v8 = v7;
                    devLog3 = devLog1;
                    mutex5 = mutex1;
                    mutex6 = mutex2;
                    mutex7 = mutex6;
                    mutex8 = mutex5;
                    goto label_155;
                }
                try {
                    LogU.debug$default(logU0, "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    addRequestPlayableListInfo0 = v4.c;
                    LogConstantsKt.debugOnlyDebugMode(this.b, "add()" + ("\nclearBefore: " + v4.a) + ("\nremoveDuplicated: " + v4.b) + ("\naddPlayableListInfoSize: " + addRequestPlayableListInfo0.getUserRequestedPlaylist().size()) + ("\nposition: " + v4.d) + ("\nisAddAndPlay: " + v4.e));
                }
                catch(Throwable throwable0) {
                    mutex6 = mutex2;
                    devLog3 = devLog1;
                    mutex5 = mutex1;
                    v8 = v7;
                    mutex7 = mutex6;
                    mutex8 = mutex5;
                    goto label_155;
                }
                if(!(addRequestPlayableListInfo0 instanceof MusicWaveAddRequestPlayableListInfo)) {
                    try {
                        w0 = new W(PlaylistId.MUSIC_WAVE, "Invalid AddRequest");
                        v9 = System.currentTimeMillis() - v7;
                    }
                    catch(Throwable throwable0) {
                        devLog3 = devLog1;
                        mutex7 = mutex2;
                        mutex8 = mutex1;
                        v8 = v7;
                        goto label_155;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)", null, false, 6, null);
                        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v9 + "ms)");
                    }
                    catch(Throwable throwable1) {
                        mutex1.unlock(null);
                        throw throwable1;
                    }
                    mutex1.unlock(null);
                    return w0;
                }
                try {
                    devLog3 = devLog1;
                    mutex5 = mutex1;
                    mutex6 = mutex2;
                    musicWaveAddRequestPlayableListInfo0 = (MusicWaveAddRequestPlayableListInfo)addRequestPlayableListInfo0;
                    b0.r = null;
                    mutex6 = mutex2;
                    b0.w = mutex6;
                    b0.B = s;
                    b0.D = devLog3;
                    b0.E = s1;
                    b0.G = mutex5;
                    b0.I = (MusicWaveAddRequestPlayableListInfo)addRequestPlayableListInfo0;
                    b0.M = v3;
                    b0.N = v2;
                    v8 = v7;
                    b0.S = v8;
                    b0.W = 2;
                    object2 = this.f(musicWaveAddRequestPlayableListInfo0, b0);
                    goto label_120;
                }
                catch(Throwable throwable0) {
                }
                v8 = v7;
                mutex7 = mutex6;
                mutex8 = mutex5;
                goto label_155;
                try {
                    object2 = this.f(musicWaveAddRequestPlayableListInfo0, b0);
                }
                catch(Throwable throwable0) {
                    mutex7 = mutex6;
                    mutex8 = mutex5;
                    goto label_155;
                }
            label_120:
                if(object2 == a1) {
                    return a1;
                }
                mutex8 = mutex5;
                mutex9 = mutex6;
                break;
            }
            case 2: {
                try {
                    long v10 = b0.S;
                    MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo1 = b0.I;
                    mutex8 = b0.G;
                    Object object3 = b0.E;
                    DevLog devLog4 = b0.D;
                    String s3 = b0.B;
                    mutex7 = b0.w;
                    s = s3;
                    s1 = object3;
                    devLog3 = devLog4;
                    v8 = v10;
                    d5.n.D(object0);
                    s = s3;
                    s1 = object3;
                    mutex9 = mutex7;
                    addRequestPlayableListInfo0 = musicWaveAddRequestPlayableListInfo1;
                    object2 = object0;
                    devLog3 = devLog4;
                    v8 = v10;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_155;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            if(((Boolean)object2).booleanValue()) {
                n n0 = this.c();
                object4 = new Z(PlaylistId.MUSIC_WAVE, ((MusicWaveAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist(), true, n0, this.e);
            }
            else {
                object4 = new W(PlaylistId.MUSIC_WAVE, "replaceInternal failed");
            }
            goto label_159;
        }
        catch(Throwable throwable0) {
            mutex7 = mutex9;
        }
        try {
        label_155:
            long v11 = System.currentTimeMillis() - v8;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex7.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v11 + "ms)", null, false, 6, null);
            devLog3.put("Lock[" + mutex7.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v11 + "ms)");
            throw throwable0;
        label_159:
            long v12 = System.currentTimeMillis() - v8;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex9.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v12 + "ms)", null, false, 6, null);
            devLog3.put("Lock[" + mutex9.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v12 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex1 = mutex8;
            mutex1.unlock(null);
            throw throwable1;
        }
        mutex8.unlock(null);
        return object4;
    }

    @Override  // oc.w
    public final Object v(int v, long v1, boolean z, String s, Continuation continuation0) {
        return new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // oc.H
    public final ListKeepOption x() {
        ListKeepOption listKeepOption0 = MelonSettingInfo.getCurrentListKeepOption();
        q.f(listKeepOption0, "getCurrentListKeepOption(...)");
        return listKeepOption0;
    }

    @Override  // oc.w
    public final Object z(Continuation continuation0) {
        return new oc.m("Not Supported");
    }
}

