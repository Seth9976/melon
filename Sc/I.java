package sc;

import androidx.appcompat.app.o;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import k8.Y;
import kotlinx.coroutines.sync.Mutex;
import oc.F;
import oc.I;
import oc.a;
import oe.c;

public final class i implements a {
    public final P0 a;

    public i(P0 p00) {
        this.a = p00;
        super();
    }

    public Object a(h1 h10, c c0) {
        Mutex mutex4;
        String s4;
        String s3;
        long v6;
        Mutex mutex3;
        Mutex mutex1;
        String s1;
        int v2;
        int v1;
        P0 p01;
        h1 h11;
        DevLog devLog1;
        String s;
        Mutex mutex0;
        w0 w00;
        if(c0 instanceof w0) {
            w00 = (w0)c0;
            int v = w00.W;
            if((v & 0x80000000) == 0) {
                w00 = new w0(this, c0);
            }
            else {
                w00.W = v ^ 0x80000000;
            }
        }
        else {
            w00 = new w0(this, c0);
        }
        Object object0 = w00.T;
        ne.a a0 = ne.a.a;
        switch(w00.W) {
            case 0: {
                n.D(object0);
                mutex0 = this.a.j;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : smart_onNeedReplaceAllFromServer"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : smart_onNeedReplaceAllFromServer", devLog0);
                w00.r = h10;
                w00.w = mutex0;
                w00.B = "smart_onNeedReplaceAllFromServer";
                w00.D = this.a;
                w00.E = devLog0;
                s = "";
                w00.G = "";
                w00.I = mutex0;
                w00.M = 0;
                w00.N = 0;
                w00.W = 1;
                P0 p00 = this.a;
                if(mutex0.lock(null, w00) == a0) {
                    return a0;
                }
                devLog1 = devLog0;
                h11 = h10;
                p01 = p00;
                v1 = 0;
                v2 = 0;
                s1 = "smart_onNeedReplaceAllFromServer";
                mutex1 = mutex0;
                goto label_56;
            }
            case 1: {
                int v3 = w00.N;
                int v4 = w00.M;
                mutex1 = w00.I;
                s = w00.G;
                DevLog devLog2 = w00.E;
                P0 p02 = w00.D;
                String s2 = w00.B;
                Mutex mutex2 = w00.w;
                h11 = w00.r;
                n.D(object0);
                p01 = p02;
                s1 = s2;
                v2 = v4;
                devLog1 = devLog2;
                v1 = v3;
                mutex0 = mutex2;
                try {
                label_56:
                    long v5 = System.currentTimeMillis();
                    try {
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex0.hashCode() + "] " + s + " Lock obtain : " + s1, null, false, 6, null);
                        devLog1.put("Lock[" + mutex0.hashCode() + "] " + s + " Lock obtain : " + s1);
                        if(!p01.k) {
                            throw new IllegalArgumentException("onNeedReplaceAllDataFromServer - not restored");
                        }
                        w00.r = null;
                        w00.w = mutex0;
                        w00.B = s1;
                        w00.D = p01;
                        w00.E = devLog1;
                        w00.G = s;
                        w00.I = mutex1;
                        w00.M = v2;
                        w00.N = v1;
                        w00.S = v5;
                        w00.W = 2;
                        object0 = P0.F(p01, h11, w00);
                    }
                    catch(Throwable throwable1) {
                        mutex3 = mutex0;
                        v6 = v5;
                        s3 = s;
                        s4 = s1;
                        goto label_103;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex3 = mutex0;
                    v6 = v5;
                    mutex4 = mutex1;
                    s3 = s;
                    P0 p03 = p01;
                    s4 = s1;
                    goto label_97;
                    try {
                    label_89:
                        v6 = w00.S;
                        mutex4 = w00.I;
                        s3 = w00.G;
                        devLog1 = w00.E;
                        p03 = w00.D;
                        s4 = w00.B;
                        mutex3 = w00.w;
                        n.D(object0);
                    label_97:
                        I i0 = p03.y;
                        if(i0 != null) {
                            i0.c(((g1)object0), p03.m);
                        }
                        goto label_109;
                    }
                    catch(Throwable throwable1) {
                        mutex1 = mutex4;
                    }
                label_103:
                    long v7 = System.currentTimeMillis() - v6;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex3.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)", null, false, 6, null);
                    devLog1.put("Lock[" + mutex3.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v7 + "ms)");
                    throw throwable1;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                goto label_89;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        throw throwable0;
        try {
        label_109:
            long v8 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex3.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v8 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex3.hashCode() + "] " + s3 + " Lock return : " + s4 + " (" + v8 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex1 = mutex4;
            mutex1.unlock(null);
            throw throwable0;
        }
        mutex4.unlock(null);
        return H.a;
    }

    @Override  // oc.a
    public Object h(Playable playable0, F f0) {
        return this.a.v.b(playable0);
    }
}

