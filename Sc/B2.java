package sc;

import H0.b;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.playback.SpApiQueueBaseTask;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import d5.n;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import me.g;
import we.a;

public final class b2 extends SpApiQueueBaseTask {
    public final String a;
    public final S2 b;
    public final int c;
    public final l1 d;
    public final ArrayList e;

    public b2(int v, String s, ArrayList arrayList0, l1 l10, S2 s20) {
        this.a = s;
        this.b = s20;
        this.c = v;
        this.d = l10;
        this.e = arrayList0;
        super(1, s);
    }

    @Override  // com.iloen.melon.playback.SpApiQueueBaseTask
    public final Object execute(Continuation continuation0) {
        a a1;
        PlaylistsSmartEditRes playlistsSmartEditRes0;
        Mutex mutex5;
        int v9;
        long v8;
        Mutex mutex3;
        S2 s23;
        int v7;
        int v6;
        int v5;
        l1 l11;
        String s4;
        Object object2;
        Object object1;
        int v4;
        S2 s22;
        a2 a20;
        S2 s21;
        long v3;
        DevLog devLog2;
        String s3;
        String s2;
        Mutex mutex2;
        long v2;
        DevLog devLog1;
        String s;
        Z1 z10;
        if(continuation0 instanceof Z1) {
            z10 = (Z1)continuation0;
            int v = z10.Y;
            if((v & 0x80000000) == 0) {
                z10 = new Z1(this, continuation0);
            }
            else {
                z10.Y = v ^ 0x80000000;
            }
        }
        else {
            z10 = new Z1(this, continuation0);
        }
        Object object0 = z10.W;
        ne.a a0 = ne.a.a;
        switch(z10.Y) {
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
                g g0 = z10.getContext().get(reentrantMutexContextKey1);
                int v1 = this.c;
                l1 l10 = this.d;
                ArrayList arrayList0 = this.e;
                if(g0 == null) {
                    ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                    Y1 y10 = new Y1(mutex1, null, mutex1, s1, devLog1, s20, v1, this, l10, arrayList0);
                    z10.r = null;
                    z10.w = null;
                    z10.B = null;
                    z10.D = null;
                    z10.E = null;
                    z10.G = null;
                    z10.I = 0;
                    z10.M = 0;
                    z10.Y = 3;
                    Object object3 = BuildersKt.withContext(reentrantMutexContextElement0, y10, z10);
                    if(object3 != a0) {
                        return object3;
                    }
                }
                else {
                    try {
                        v2 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : " + s1, null, false, 6, null);
                        devLog1.put("ReentrantLock[" + mutex1.hashCode() + "]  Lock obtain : " + s1);
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex1;
                        s2 = s1;
                        s3 = "";
                        devLog2 = devLog1;
                        goto label_225;
                    }
                    try {
                        s20.r();
                        if(!A8.b.d()) {
                            try {
                                if(MelonPrefs.getInstance().getBoolean("SP_4093_TEST_MODE", false)) {
                                    goto label_55;
                                }
                                goto label_56;
                            }
                            catch(Exception exception0) {
                                mutex2 = mutex1;
                                s2 = s1;
                                v3 = v2;
                                s3 = "";
                                devLog2 = devLog1;
                                s21 = s20;
                                a1 = S2.f(s21, this, exception0);
                                goto label_234;
                            }
                        label_55:
                            v1 = -1;
                        }
                    label_56:
                        a20 = new a2(s20, l10, v1, arrayList0, null);
                        s22 = s20;
                        v4 = v1;
                    }
                    catch(Exception exception0) {
                        s22 = s20;
                        goto label_85;
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex1;
                        s2 = s1;
                        s3 = "";
                        devLog2 = devLog1;
                        goto label_225;
                    }
                    try {
                        z10.r = mutex1;
                        z10.w = s1;
                        z10.B = s22;
                        z10.D = l10;
                        z10.E = devLog1;
                        z10.G = "";
                        z10.I = 0;
                        z10.M = 0;
                        z10.N = 0;
                        z10.V = v2;
                        z10.S = 0;
                        z10.T = v4;
                        z10.Y = 1;
                        object1 = BuildersKt.withContext(Dispatchers.getIO(), a20, z10);
                    }
                    catch(Exception exception0) {
                    label_85:
                        s21 = s22;
                        mutex2 = mutex1;
                        s2 = s1;
                        v3 = v2;
                        s3 = "";
                        devLog2 = devLog1;
                        a1 = S2.f(s21, this, exception0);
                        goto label_234;
                    }
                    catch(Throwable throwable0) {
                        mutex2 = mutex1;
                        s2 = s1;
                        s3 = "";
                        devLog2 = devLog1;
                        goto label_225;
                    }
                    if(object1 != a0) {
                        object2 = object1;
                        s4 = s1;
                        l11 = l10;
                        v5 = 0;
                        v6 = 0;
                        v7 = 0;
                        s23 = s22;
                        mutex3 = mutex1;
                        v8 = v2;
                        v9 = 0;
                        goto label_164;
                    }
                }
                return a0;
            }
            case 1: {
                v9 = z10.S;
                v8 = z10.V;
                int v10 = z10.N;
                int v11 = z10.M;
                int v12 = z10.I;
                int v13 = z10.T;
                String s5 = z10.G;
                object2 = object0;
                DevLog devLog3 = (DevLog)z10.E;
                l1 l12 = (l1)z10.D;
                S2 s24 = z10.B;
                String s6 = z10.w;
                Mutex mutex4 = z10.r;
                try {
                    n.D(object2);
                    l11 = l12;
                    v5 = v10;
                    v4 = v13;
                    s4 = s6;
                    v7 = v11;
                    devLog1 = devLog3;
                    mutex3 = mutex4;
                    s23 = s24;
                    v6 = v12;
                    s = s5;
                }
                catch(Exception exception0) {
                    mutex2 = mutex4;
                    v3 = v8;
                    devLog2 = devLog3;
                    s3 = s5;
                    s21 = s24;
                    s2 = s6;
                    a1 = S2.f(s21, this, exception0);
                    goto label_234;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex4;
                    s2 = s6;
                    v2 = v8;
                    devLog2 = devLog3;
                    s3 = s5;
                    goto label_225;
                }
                try {
                    try {
                    label_164:
                        mutex5 = mutex3;
                        playlistsSmartEditRes0 = (PlaylistsSmartEditRes)object2;
                        z10.r = mutex3;
                        z10.w = s4;
                        z10.B = s23;
                        z10.D = devLog1;
                        z10.E = s;
                        mutex5 = mutex3;
                    }
                    catch(Exception exception0) {
                        mutex5 = mutex3;
                        goto label_187;
                    }
                    try {
                        z10.G = null;
                        z10.I = v6;
                        z10.M = v7;
                        z10.N = v5;
                        z10.V = v8;
                        z10.S = v9;
                        z10.T = v4;
                        z10.Y = 2;
                        object0 = S2.e(s23, this, l11, playlistsSmartEditRes0, z10);
                        goto label_201;
                    }
                    catch(Exception exception0) {
                    }
                label_187:
                    v3 = v8;
                    s21 = s23;
                    s2 = s4;
                    s3 = s;
                    devLog2 = devLog1;
                    mutex2 = mutex5;
                    a1 = S2.f(s21, this, exception0);
                    goto label_234;
                }
                catch(Throwable throwable0) {
                    v2 = v8;
                    s2 = s4;
                    s3 = s;
                    devLog2 = devLog1;
                    mutex2 = mutex5;
                    goto label_225;
                }
            label_201:
                if(object0 != a0) {
                    v3 = v8;
                    s21 = s23;
                    s2 = s4;
                    s3 = s;
                    devLog2 = devLog1;
                    mutex2 = mutex5;
                    a1 = (a)object0;
                    goto label_234;
                }
                return a0;
            }
            case 2: {
                v3 = z10.V;
                Mutex mutex6 = (Mutex)z10.G;
                s3 = z10.E;
                devLog2 = (DevLog)z10.D;
                s21 = z10.B;
                s2 = z10.w;
                mutex2 = z10.r;
                try {
                    try {
                        n.D(object0);
                        a1 = (a)object0;
                        goto label_234;
                    }
                    catch(Exception exception0) {
                    }
                    a1 = S2.f(s21, this, exception0);
                    goto label_234;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 3: {
                ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)z10.G;
                Mutex mutex0 = (Mutex)z10.E;
                DevLog devLog0 = (DevLog)z10.B;
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v2 = v3;
    label_225:
        long v14 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder0 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v14, s2, " (", stringBuilder0);
        stringBuilder0.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        StringBuilder stringBuilder1 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v14, s2, " (", stringBuilder1);
        com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog2);
        throw throwable0;
    label_234:
        long v15 = System.currentTimeMillis() - v3;
        StringBuilder stringBuilder2 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v15, s2, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = com.iloen.melon.custom.l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
        b.t(v15, s2, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog2);
        return a1;
    }
}

