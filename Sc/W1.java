package sc;

import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import oe.i;
import we.a;
import we.n;

public final class w1 extends i implements n {
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
    public final z1 W;
    public final l1 X;
    public final boolean Y;
    public int Z;
    public Mutex r;
    public Object w;

    public w1(Mutex mutex0, Continuation continuation0, Mutex mutex1, String s, DevLog devLog0, S2 s20, z1 z10, l1 l10, boolean z) {
        this.M = mutex0;
        this.N = mutex1;
        this.S = s;
        this.T = devLog0;
        this.V = s20;
        this.W = z10;
        this.X = l10;
        this.Y = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w1(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X, this.Y);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object7;
        a a1;
        Object object2;
        Mutex mutex1;
        Object object1;
        long v1;
        Mutex mutex4;
        Object object6;
        int v7;
        int v6;
        long v5;
        Mutex mutex3;
        int v4;
        Object object5;
        Object object4;
        long v3;
        Object object3;
        int v2;
        ne.a a0 = ne.a.a;
        int v = this.E;
        z1 z10 = this.W;
        l1 l10 = this.X;
        DevLog devLog0 = this.T;
        S2 s20 = this.V;
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
                try {
                    mutex1 = mutex2;
                    v2 = 0;
                    object3 = null;
                    v3 = System.currentTimeMillis();
                    goto label_34;
                }
                catch(Throwable throwable1) {
                    mutex1.unlock(object7);
                    throw throwable1;
                }
            }
            case 1: {
                v2 = this.B;
                object3 = this.w;
                mutex1 = this.r;
                d5.n.D(object0);
                try {
                    v3 = System.currentTimeMillis();
                }
                catch(Throwable throwable1) {
                    mutex1.unlock(object7);
                    throw throwable1;
                }
                try {
                label_34:
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : " + s, null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : " + s);
                    try {
                        s20.r();
                        y1 y10 = new y1(s20, l10, this.Y, null);
                        this.r = mutex1;
                        this.w = object3;
                        this.B = v2;
                        this.D = 0;
                        this.G = 0;
                        this.I = v3;
                        this.Z = 0;
                        this.E = 2;
                        object4 = BuildersKt.withContext(Dispatchers.getIO(), y10, this);
                    }
                    catch(Exception exception0) {
                        object1 = object3;
                        v1 = v3;
                        a1 = S2.f(s20, z10, exception0);
                        goto label_128;
                    }
                }
                catch(Throwable throwable0) {
                    object1 = object3;
                    v1 = v3;
                    goto label_121;
                }
                if(object4 == a0) {
                    return a0;
                }
                object5 = object3;
                v4 = 0;
                mutex3 = mutex1;
                v5 = v3;
                v6 = 0;
                v7 = 0;
                break;
            }
            case 2: {
                try {
                    v5 = this.I;
                    int v8 = this.Z;
                    int v9 = this.D;
                    int v10 = this.B;
                    int v11 = this.G;
                    object6 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    v4 = v8;
                    v7 = v11;
                    object5 = object6;
                    mutex3 = mutex4;
                    v6 = v9;
                    v2 = v10;
                    object4 = object0;
                    break;
                }
                catch(Exception exception0) {
                    mutex1 = mutex4;
                    v1 = v5;
                    object1 = object6;
                    a1 = S2.f(s20, z10, exception0);
                    goto label_128;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex4;
                    v1 = v5;
                    object1 = object6;
                    goto label_121;
                }
            }
            default: {
                if(v == 3) {
                    try {
                        v1 = this.I;
                        object1 = this.w;
                        mutex1 = this.r;
                        d5.n.D(object0);
                        object2 = object0;
                        a1 = (a)object2;
                        goto label_128;
                    }
                    catch(Exception exception0) {
                        a1 = S2.f(s20, z10, exception0);
                        goto label_128;
                    }
                    catch(Throwable throwable0) {
                        goto label_121;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            this.r = mutex3;
            this.w = object5;
            this.B = v2;
            this.D = v6;
            this.G = v7;
            this.I = v5;
            this.Z = v4;
            this.E = 3;
            object2 = S2.e(s20, z10, l10, ((PlaylistsSmartEditRes)object4), this);
        }
        catch(Exception exception0) {
            object1 = object5;
            v1 = v5;
            mutex1 = mutex3;
            a1 = S2.f(s20, z10, exception0);
            goto label_128;
        }
        catch(Throwable throwable0) {
            object1 = object5;
            v1 = v5;
            mutex1 = mutex3;
            goto label_121;
        }
        if(object2 == a0) {
            return a0;
        }
        object1 = object5;
        v1 = v5;
        mutex1 = mutex3;
        try {
            a1 = (a)object2;
            goto label_128;
        }
        catch(Exception exception0) {
            try {
                a1 = S2.f(s20, z10, exception0);
                goto label_128;
            }
            catch(Throwable throwable0) {
            }
        }
        catch(Throwable throwable0) {
        }
        try {
        label_121:
            long v12 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v12 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v12 + "ms)");
            throw throwable0;
        }
        catch(Throwable throwable1) {
            object7 = object1;
            mutex1.unlock(object7);
            throw throwable1;
        }
        try {
        label_128:
            object7 = object1;
            long v13 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v13 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : " + s + " (" + v13 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex1.unlock(object7);
            throw throwable1;
        }
        mutex1.unlock(object7);
        return a1;
    }
}

