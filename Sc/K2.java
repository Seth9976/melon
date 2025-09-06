package sc;

import H0.b;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.playback.SpApiQueueBaseTask;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import we.a;

public final class k2 extends SpApiQueueBaseTask {
    public final String a;
    public final S2 b;
    public final l1 c;
    public final int d;
    public final ArrayList e;
    public final ArrayList f;

    public k2(String s, S2 s20, l1 l10, int v, ArrayList arrayList0, ArrayList arrayList1) {
        this.a = s;
        this.b = s20;
        this.c = l10;
        this.d = v;
        this.e = arrayList0;
        this.f = arrayList1;
        super(1, s);
    }

    @Override  // com.iloen.melon.playback.SpApiQueueBaseTask
    public final Object execute(Continuation continuation0) {
        a a1;
        PlaylistsSmartEditRes playlistsSmartEditRes0;
        Mutex mutex5;
        int v8;
        S2 s23;
        int v7;
        long v6;
        Mutex mutex3;
        int v5;
        int v4;
        l1 l11;
        String s4;
        Object object2;
        S2 s22;
        Object object1;
        S2 s21;
        String s3;
        long v3;
        Mutex mutex2;
        DevLog devLog2;
        String s2;
        long v2;
        DevLog devLog1;
        String s;
        i2 i20;
        if(continuation0 instanceof i2) {
            i20 = (i2)continuation0;
            int v = i20.X;
            if((v & 0x80000000) == 0) {
                i20 = new i2(this, continuation0);
            }
            else {
                i20.X = v ^ 0x80000000;
            }
        }
        else {
            i20 = new i2(this, continuation0);
        }
        Object object0 = i20.V;
        ne.a a0 = ne.a.a;
        switch(i20.X) {
            case 0: {
                n.D(object0);
                Mutex mutex1 = this.b.e;
                s = "";
                String s1 = this.a;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), b.f(mutex1.hashCode(), "ReentrantLock[", "]  try : ", s1), null, false, 6, null);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                devLog1 = DevLog.Companion.get("MutexLockUtil");
                S2 s20 = this.b;
                devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  try : " + s1);
                ReentrantMutexContextKey reentrantMutexContextKey1 = new ReentrantMutexContextKey(mutex1);
                g g0 = i20.getContext().get(reentrantMutexContextKey1);
                l1 l10 = this.c;
                int v1 = this.d;
                ArrayList arrayList0 = this.e;
                ArrayList arrayList1 = this.f;
                if(g0 == null) {
                    goto label_94;
                }
                try {
                    v2 = System.currentTimeMillis();
                    LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : " + s1, null, false, 6, null);
                    devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : " + s1);
                }
                catch(Throwable throwable0) {
                    s2 = s1;
                    devLog2 = devLog1;
                    mutex2 = mutex1;
                    v3 = v2;
                    s3 = "";
                    break;
                }
                try {
                    try {
                        s20.r();
                    }
                    catch(Exception exception0) {
                        s21 = s20;
                        goto label_68;
                    }
                    try {
                        s21 = s20;
                        j2 j20 = new j2(s20, l10, v1, arrayList0, arrayList1, s1, null);
                        s21 = s20;
                        i20.r = mutex1;
                        i20.w = s1;
                        i20.B = s21;
                        i20.D = l10;
                        i20.E = devLog1;
                        i20.G = "";
                        i20.I = 0;
                        i20.M = 0;
                        i20.N = 0;
                        i20.T = v2;
                        i20.S = 0;
                        i20.X = 1;
                        object1 = BuildersKt.withContext(Dispatchers.getIO(), j20, i20);
                        goto label_82;
                    }
                    catch(Exception exception0) {
                    }
                label_68:
                    s2 = s1;
                    devLog2 = devLog1;
                    mutex2 = mutex1;
                    s3 = "";
                    s22 = s21;
                    v3 = v2;
                    a1 = S2.f(s22, this, exception0);
                    goto label_215;
                }
                catch(Throwable throwable0) {
                    s2 = s1;
                    devLog2 = devLog1;
                    mutex2 = mutex1;
                    v3 = v2;
                    s3 = "";
                    break;
                }
            label_82:
                if(object1 != a0) {
                    object2 = object1;
                    s4 = s1;
                    l11 = l10;
                    v4 = 0;
                    v5 = 0;
                    mutex3 = mutex1;
                    v6 = v2;
                    v7 = 0;
                    s23 = s21;
                    v8 = 0;
                    goto label_147;
                label_94:
                    ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                    h2 h20 = new h2(mutex1, null, mutex1, s1, devLog1, s20, this, l10, v1, arrayList0, arrayList1, s1);
                    i20.r = null;
                    i20.w = null;
                    i20.B = null;
                    i20.D = null;
                    i20.E = null;
                    i20.G = null;
                    i20.I = 0;
                    i20.M = 0;
                    i20.X = 3;
                    Object object3 = BuildersKt.withContext(reentrantMutexContextElement0, h20, i20);
                    return object3 == a0 ? a0 : object3;
                }
                return a0;
            }
            case 1: {
                int v9 = i20.S;
                v6 = i20.T;
                int v10 = i20.N;
                int v11 = i20.M;
                int v12 = i20.I;
                s = i20.G;
                object2 = object0;
                DevLog devLog3 = (DevLog)i20.E;
                l1 l12 = (l1)i20.D;
                S2 s24 = i20.B;
                String s5 = i20.w;
                Mutex mutex4 = i20.r;
                try {
                    n.D(object2);
                    l11 = l12;
                    v4 = v11;
                    devLog1 = devLog3;
                    mutex3 = mutex4;
                    v5 = v12;
                    s4 = s5;
                    s23 = s24;
                    v7 = v10;
                    v8 = v9;
                }
                catch(Exception exception0) {
                    mutex2 = mutex4;
                    v3 = v6;
                    s3 = s;
                    devLog2 = devLog3;
                    s22 = s24;
                    s2 = s5;
                    a1 = S2.f(s22, this, exception0);
                    goto label_215;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex4;
                    v3 = v6;
                    s3 = s;
                    devLog2 = devLog3;
                    s2 = s5;
                    break;
                }
                try {
                    try {
                    label_147:
                        mutex5 = mutex3;
                        playlistsSmartEditRes0 = (PlaylistsSmartEditRes)object2;
                        i20.r = mutex3;
                        i20.w = s4;
                        i20.B = s23;
                        i20.D = devLog1;
                        i20.E = s;
                        mutex5 = mutex3;
                    }
                    catch(Exception exception0) {
                        mutex5 = mutex3;
                        goto label_169;
                    }
                    try {
                        i20.G = null;
                        i20.I = v5;
                        i20.M = v4;
                        i20.N = v7;
                        i20.T = v6;
                        i20.S = v8;
                        i20.X = 2;
                        object0 = S2.e(s23, this, l11, playlistsSmartEditRes0, i20);
                        goto label_183;
                    }
                    catch(Exception exception0) {
                    }
                label_169:
                    v3 = v6;
                    s3 = s;
                    devLog2 = devLog1;
                    s2 = s4;
                    mutex2 = mutex5;
                    s22 = s23;
                    a1 = S2.f(s22, this, exception0);
                    goto label_215;
                }
                catch(Throwable throwable0) {
                    v3 = v6;
                    s3 = s;
                    devLog2 = devLog1;
                    s2 = s4;
                    mutex2 = mutex5;
                    break;
                }
            label_183:
                if(object0 != a0) {
                    v3 = v6;
                    s3 = s;
                    devLog2 = devLog1;
                    s2 = s4;
                    mutex2 = mutex5;
                    s22 = s23;
                    a1 = (a)object0;
                    goto label_215;
                }
                return a0;
            }
            case 2: {
                v3 = i20.T;
                Mutex mutex6 = (Mutex)i20.G;
                s3 = i20.E;
                devLog2 = (DevLog)i20.D;
                s22 = i20.B;
                s2 = i20.w;
                mutex2 = i20.r;
                try {
                    try {
                        n.D(object0);
                        a1 = (a)object0;
                        goto label_215;
                    }
                    catch(Exception exception0) {
                    }
                    a1 = S2.f(s22, this, exception0);
                    goto label_215;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 3: {
                ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)i20.G;
                Mutex mutex0 = (Mutex)i20.E;
                DevLog devLog0 = (DevLog)i20.B;
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v13 = System.currentTimeMillis() - v3;
        StringBuilder stringBuilder0 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v13, s2, " (", stringBuilder0);
        stringBuilder0.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        StringBuilder stringBuilder1 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v13, s2, " (", stringBuilder1);
        com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog2);
        throw throwable0;
    label_215:
        long v14 = System.currentTimeMillis() - v3;
        StringBuilder stringBuilder2 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v14, s2, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v14, s2, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog2);
        return a1;
    }
}

