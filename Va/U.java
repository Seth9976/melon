package va;

import A8.x;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import we.n;

public final class u extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final L0 N;
    public final Mutex S;
    public final DevLog T;
    public final e0 V;
    public final String W;
    public final String X;
    public x Y;
    public int Z;
    public Mutex r;
    public Object w;

    public u(Mutex mutex0, Continuation continuation0, L0 l00, Mutex mutex1, DevLog devLog0, e0 e00, String s, String s1) {
        this.M = mutex0;
        this.N = l00;
        this.S = mutex1;
        this.T = devLog0;
        this.V = e00;
        this.W = s;
        this.X = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Mutex mutex1;
        Object object1;
        long v1;
        Object object8;
        Object object7;
        n1 n10;
        Mutex mutex5;
        Object object6;
        int v7;
        long v6;
        Object object5;
        int v5;
        int v4;
        int v3;
        Mutex mutex4;
        Object object4;
        x x0;
        Object object2;
        int v2;
        a a0 = a.a;
        int v = this.E;
        DevLog devLog0 = this.T;
        L0 l00 = this.N;
        e0 e00 = this.V;
        Mutex mutex0 = this.S;
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
                mutex1 = mutex2;
                v2 = 0;
                object2 = null;
                goto label_31;
            }
            case 1: {
                v2 = this.B;
                Object object3 = this.w;
                Mutex mutex3 = this.r;
                d5.n.D(object0);
                object2 = object3;
                mutex1 = mutex3;
                try {
                label_31:
                    v1 = System.currentTimeMillis();
                    l00.a(" LoginUseCase-loginByIdAndPassword()", true);
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByIdAndPassword()", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByIdAndPassword()");
                    x0 = () -> "ID_PWD";
                    this.r = mutex1;
                    this.w = object2;
                    this.Y = x0;
                    this.B = v2;
                    this.D = 0;
                    this.G = 0;
                    this.I = v1;
                    this.Z = 0;
                    this.E = 2;
                    object4 = ((j1)e00.b).d(this.W, this.X, this);
                }
                catch(Throwable throwable0) {
                    object1 = object2;
                    goto label_141;
                }
                if(object4 == a0) {
                    return a0;
                }
                object0 = object4;
                mutex4 = mutex1;
                v3 = 0;
                v4 = 0;
                v5 = 0;
                object5 = object2;
                v6 = v1;
                v7 = v2;
                goto label_81;
            }
            case 2: {
                try {
                    v6 = this.I;
                    int v8 = this.G;
                    int v9 = this.Z;
                    int v10 = this.B;
                    x0 = this.Y;
                    int v11 = this.D;
                    object6 = this.w;
                    mutex5 = this.r;
                    d5.n.D(object0);
                    v7 = v10;
                    mutex4 = mutex5;
                    v3 = v11;
                    v5 = v9;
                    v4 = v8;
                    object5 = object6;
                }
                catch(Throwable throwable0) {
                    v1 = v6;
                    mutex1 = mutex5;
                    object1 = object6;
                    goto label_141;
                }
                try {
                label_81:
                    n10 = (n1)object0;
                    LogU.debug$default(e00.j, "loginByIdAndPassword() result : " + n10, null, false, 6, null);
                    if(n10 instanceof m1) {
                        goto label_84;
                    }
                    else {
                        goto label_99;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    object1 = object5;
                    v1 = v6;
                    mutex1 = mutex4;
                    goto label_141;
                }
                try {
                label_84:
                    this.r = mutex4;
                    this.w = object5;
                    this.Y = null;
                    this.B = v7;
                    this.D = v3;
                    this.G = v4;
                    this.I = v6;
                    this.Z = v5;
                    this.E = 3;
                    if(e0.f(e00, x0, ((m1)n10).a, this) != a0) {
                        object1 = object5;
                        v1 = v6;
                        mutex1 = mutex4;
                        object7 = h0.a;
                        mutex4 = mutex1;
                        v6 = v1;
                        break;
                    }
                    return a0;
                label_99:
                    if(n10 instanceof k1) {
                        this.r = mutex4;
                        this.w = object5;
                        this.Y = null;
                        this.B = v7;
                        this.D = v3;
                        this.G = v4;
                        this.I = v6;
                        this.Z = v5;
                        this.E = 4;
                        if(e0.e(e00, x0, ((k1)n10).a, this) == a0) {
                            return a0;
                        }
                        goto label_117;
                    }
                    else {
                        goto label_122;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    object1 = object5;
                    v1 = v6;
                    mutex1 = mutex4;
                    goto label_141;
                }
                return a0;
            label_117:
                object1 = object5;
                v1 = v6;
                mutex1 = mutex4;
                try {
                    object7 = new g0(va.L0.d);
                    mutex4 = mutex1;
                    v6 = v1;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_141;
                }
                try {
                label_122:
                    if(!(n10 instanceof l1)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    e0.g(e00);
                    object7 = new f0(((l1)n10).a);
                    object1 = object5;
                    break;
                }
                catch(Throwable throwable0) {
                    object1 = object5;
                    v1 = v6;
                    mutex1 = mutex4;
                }
                goto label_141;
            }
            case 3: {
                try {
                    v1 = this.I;
                    object1 = this.w;
                    mutex1 = this.r;
                    d5.n.D(object0);
                    object7 = h0.a;
                    mutex4 = mutex1;
                    v6 = v1;
                    break;
                }
                catch(Throwable throwable0) {
                }
                try {
                label_141:
                    long v12 = System.currentTimeMillis() - v1;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByIdAndPassword() (" + v12 + "ms)", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByIdAndPassword() (" + v12 + "ms)");
                    l00.a(" LoginUseCase-loginByIdAndPassword()", false);
                    throw throwable0;
                }
                catch(Throwable throwable1) {
                    object8 = object1;
                    mutex1.unlock(object8);
                    throw throwable1;
                }
                mutex4 = mutex1;
                v6 = v1;
                break;
            }
            default: {
                if(v == 4) {
                    try {
                        v1 = this.I;
                        object1 = this.w;
                        mutex1 = this.r;
                        d5.n.D(object0);
                        object7 = new g0(va.L0.d);
                        mutex4 = mutex1;
                        v6 = v1;
                        break;
                    }
                    catch(Throwable throwable0) {
                        goto label_141;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            long v13 = System.currentTimeMillis() - v6;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByIdAndPassword() (" + v13 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByIdAndPassword() (" + v13 + "ms)");
            l00.a(" LoginUseCase-loginByIdAndPassword()", false);
        }
        catch(Throwable throwable1) {
            object8 = object1;
            mutex1 = mutex4;
            mutex1.unlock(object8);
            throw throwable1;
        }
        mutex4.unlock(object1);
        return object7;
    }
}

