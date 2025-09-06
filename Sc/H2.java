package sc;

import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import oe.i;
import we.a;
import we.n;

public final class h2 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final Mutex N;
    public final String S;
    public final DevLog T;
    public final S2 V;
    public final k2 W;
    public final l1 X;
    public final int Y;
    public final ArrayList Z;
    public final ArrayList b0;
    public final String c0;
    public int d0;
    public Mutex r;
    public Object w;

    public h2(Mutex mutex0, Continuation continuation0, Mutex mutex1, String s, DevLog devLog0, S2 s20, k2 k20, l1 l10, int v, ArrayList arrayList0, ArrayList arrayList1, String s1) {
        this.M = mutex0;
        this.N = mutex1;
        this.S = s;
        this.T = devLog0;
        this.V = s20;
        this.W = k20;
        this.X = l10;
        this.Y = v;
        this.Z = arrayList0;
        this.b0 = arrayList1;
        this.c0 = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h2(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X, this.Y, this.Z, this.b0, this.c0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Mutex mutex7;
        a a1;
        Object object3;
        long v3;
        long v2;
        Object object2;
        Mutex mutex1;
        Object object1;
        long v1;
        Mutex mutex6;
        Object object6;
        long v12;
        int v5;
        Mutex mutex5;
        int v4;
        Mutex mutex3;
        ne.a a0 = ne.a.a;
        int v = this.E;
        l1 l10 = this.X;
        k2 k20 = this.W;
        S2 s20 = this.V;
        DevLog devLog0 = this.T;
        String s = this.S;
        Mutex mutex0 = this.N;
        switch(v) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex2 = this.M;
                this.r = mutex2;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex2.lock(null, this) == a0) {
                    return a0;
                }
                object3 = null;
                mutex3 = mutex2;
                v4 = 0;
                goto label_42;
            }
            case 1: {
                v4 = this.B;
                Object object4 = this.w;
                Mutex mutex4 = this.r;
                d5.n.D(object0);
                object3 = object4;
                mutex3 = mutex4;
                try {
                label_42:
                    v2 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : " + s, null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : " + s);
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex3;
                    goto label_126;
                }
                try {
                    try {
                        mutex5 = mutex3;
                        s20.r();
                        v5 = 0;
                        mutex5 = mutex3;
                    }
                    catch(Exception exception0) {
                        mutex5 = mutex3;
                        mutex1 = mutex5;
                        object1 = object3;
                        a1 = S2.f(s20, k20, exception0);
                        goto label_133;
                    }
                    try {
                        j2 j20 = new j2(this.V, l10, this.Y, this.Z, this.b0, this.c0, null);
                        this.r = mutex5;
                        this.w = object3;
                        this.B = v4;
                        this.D = 0;
                        this.G = 0;
                        this.I = v2;
                        this.d0 = 0;
                        this.E = 2;
                        Object object5 = BuildersKt.withContext(Dispatchers.getIO(), j20, this);
                        if(object5 == a0) {
                            return a0;
                        }
                        int v6 = 0;
                        int v7 = 0;
                        goto label_99;
                        try {
                        label_71:
                            int v8 = this.G;
                            int v9 = this.d0;
                            int v10 = this.D;
                            int v11 = this.B;
                            v12 = this.I;
                            object6 = this.w;
                            mutex6 = this.r;
                            object3 = object6;
                            d5.n.D(object0);
                            v6 = v9;
                            v7 = v10;
                            mutex5 = mutex6;
                            v5 = v8;
                            object3 = object6;
                            v4 = v11;
                            object5 = object0;
                            v2 = v12;
                        }
                        catch(Exception exception0) {
                            mutex1 = mutex6;
                            object1 = object6;
                            v3 = v12;
                            v2 = v3;
                            a1 = S2.f(s20, k20, exception0);
                            goto label_133;
                        }
                        catch(Throwable throwable0) {
                            mutex1 = mutex6;
                            v2 = v12;
                            goto label_126;
                        }
                    label_99:
                        this.r = mutex5;
                        this.w = object3;
                        this.B = v4;
                        this.D = v7;
                        this.G = v5;
                        this.I = v2;
                        this.d0 = v6;
                        this.E = 3;
                        object2 = S2.e(s20, k20, l10, ((PlaylistsSmartEditRes)object5), this);
                        if(object2 == a0) {
                            return a0;
                        }
                        goto label_117;
                    }
                    catch(Exception exception0) {
                    }
                    mutex1 = mutex5;
                    object1 = object3;
                    a1 = S2.f(s20, k20, exception0);
                    goto label_133;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                goto label_71;
            }
            default: {
                if(v == 3) {
                    try {
                        v1 = this.I;
                        object1 = this.w;
                        mutex1 = this.r;
                        d5.n.D(object0);
                        object2 = object0;
                        v2 = v1;
                        a1 = (a)object2;
                        goto label_133;
                    }
                    catch(Exception exception0) {
                        v3 = v1;
                        v2 = v3;
                        a1 = S2.f(s20, k20, exception0);
                        goto label_133;
                    }
                    catch(Throwable throwable0) {
                        object3 = object1;
                        v2 = v1;
                        goto label_126;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1 = mutex5;
        goto label_126;
    label_117:
        mutex1 = mutex5;
        object1 = object3;
        try {
            try {
                a1 = (a)object2;
                goto label_133;
            }
            catch(Exception exception0) {
            }
            a1 = S2.f(s20, k20, exception0);
            goto label_133;
        }
        catch(Throwable throwable0) {
            object3 = object1;
        }
        try {
        label_126:
            long v13 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v13 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v13 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex7 = mutex1;
            mutex7.unlock(object3);
            throw throwable1;
        }
        try {
        label_133:
            object3 = object1;
            mutex7 = mutex1;
            long v14 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v14 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v14 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex7.unlock(object3);
            throw throwable1;
        }
        mutex7.unlock(object3);
        return a1;
    }
}

