package va;

import A8.u;
import A8.w;
import com.iloen.melon.LoginUser;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import mb.l;
import ne.a;
import oe.i;
import pd.s;
import we.n;

public final class r extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final Mutex N;
    public final DevLog S;
    public final e0 T;
    public final String V;
    public final u W;
    public w X;
    public String Y;
    public String Z;
    public String b0;
    public l1 c0;
    public e0 d0;
    public int e0;
    public Mutex r;
    public Object w;

    public r(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, e0 e00, String s, u u0) {
        this.M = mutex0;
        this.N = mutex1;
        this.S = devLog0;
        this.T = e00;
        this.V = s;
        this.W = u0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.M, continuation0, this.N, this.S, this.T, this.V, this.W);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Mutex mutex6;
        Object object10;
        Object object9;
        int v14;
        Mutex mutex4;
        Object object7;
        long v13;
        n1 n11;
        int v17;
        long v16;
        int v15;
        w w1;
        int v9;
        String s4;
        int v8;
        Object object5;
        int v7;
        int v6;
        w w0;
        String s3;
        String s2;
        String s1;
        int v3;
        int v2;
        Mutex mutex3;
        long v1;
        Object object3;
        Object object2;
        long v;
        Object object1;
        Mutex mutex1;
        e0 e00 = this.T;
        l l0 = e00.b;
        a a0 = a.a;
        DevLog devLog0 = this.S;
        String s = this.V;
        Mutex mutex0 = this.N;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                mutex1 = this.M;
                this.r = mutex1;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                object1 = null;
                goto label_21;
            }
            case 1: {
                object1 = this.w;
                Mutex mutex2 = this.r;
                d5.n.D(object0);
                mutex1 = mutex2;
                try {
                label_21:
                    v = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(object1);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByAuto", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByAuto");
                    new w(e00.l);
                    LoginUser loginUser0 = ((j1)l0).f;
                    LoginUser loginUser1 = ((j1)l0).f;
                    LogU.debug$default(e00.j, "loginByAuto() userId : , token is empty: " + true, null, false, 6, null);
                    object2 = new g0(M0.d);
                    break;
                }
                catch(Throwable throwable1) {
                    object3 = object1;
                    v1 = v;
                    mutex3 = mutex1;
                    goto label_316;
                }
            }
            case 2: {
                try {
                    v1 = this.I;
                    v2 = this.D;
                    v3 = this.B;
                    s1 = this.b0;
                    int v4 = this.e0;
                    s2 = this.Z;
                    s3 = this.Y;
                    w0 = this.X;
                    int v5 = this.G;
                    Object object4 = this.w;
                    mutex1 = this.r;
                    object3 = object4;
                    d5.n.D(object0);
                    mutex3 = mutex1;
                    v6 = v4;
                    v7 = v5;
                    object3 = object4;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                    goto label_316;
                }
                try {
                    if(((Boolean)object0).booleanValue()) {
                        e0.i(e00, System.currentTimeMillis(), s, "SKIPPED");
                        e00.l = 0;
                        object2 = new g0(K0.d);
                        mutex1 = mutex3;
                        v = v1;
                        object1 = object3;
                    }
                    else {
                        this.r = mutex3;
                        this.w = object3;
                        this.X = w0;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = s1;
                        this.B = v3;
                        this.D = v2;
                        this.G = v7;
                        this.I = v1;
                        this.e0 = v6;
                        this.E = 3;
                        object5 = ((j1)l0).c(s3, s2, this.W, this);
                        if(object5 == a0) {
                            return a0;
                        }
                        v8 = v2;
                        s4 = s1;
                        v9 = v3;
                        w1 = w0;
                        goto label_101;
                    }
                    break;
                }
                catch(Throwable throwable1) {
                    goto label_316;
                }
            }
            case 3: {
                try {
                    v1 = this.I;
                    int v10 = this.G;
                    v8 = this.D;
                    v9 = this.B;
                    int v11 = this.e0;
                    String s5 = this.b0;
                    w w2 = this.X;
                    Object object6 = this.w;
                    mutex1 = this.r;
                    object3 = object6;
                    d5.n.D(object0);
                    object5 = object0;
                    mutex3 = mutex1;
                    object3 = object6;
                    w1 = w2;
                    s4 = s5;
                    v7 = v10;
                    v6 = v11;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex1;
                    goto label_316;
                }
                try {
                label_101:
                    n1 n10 = (n1)object5;
                    LogU.debug$default(e00.j, "loginByAuto() result : " + n10, null, false, 6, null);
                    c9.a.a(s4, s, n10);
                    if(n10 instanceof m1) {
                        this.r = mutex3;
                        this.w = object3;
                        this.X = null;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = null;
                        this.c0 = null;
                        this.B = v9;
                        this.D = v8;
                        this.G = v7;
                        this.I = v1;
                        this.e0 = v6;
                        this.E = 4;
                        if(e0.f(e00, w1, ((m1)n10).a, this) != a0) {
                            v15 = v6;
                            v16 = v1;
                            v17 = v7;
                            goto label_203;
                        }
                        return a0;
                    }
                    else if(!(n10 instanceof k1)) {
                        if(!(n10 instanceof l1)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        int v12 = e00.l;
                        if(v12 >= 3) {
                            if(e00.m()) {
                                this.r = mutex3;
                                this.w = object3;
                                this.X = null;
                                this.Y = null;
                                this.Z = null;
                                this.b0 = null;
                                this.c0 = (l1)n10;
                                this.B = v9;
                                this.D = v8;
                                this.G = v7;
                                this.I = v1;
                                this.e0 = v6;
                                this.E = 9;
                                if(e0.f(e00, w1, A8.r.c, this) == a0) {
                                    return a0;
                                }
                            }
                            else {
                                e00.l = 0;
                            }
                            n11 = n10;
                            v13 = v1;
                            object7 = object3;
                            mutex4 = mutex3;
                            goto label_307;
                        }
                        else {
                            e00.l = v12 + 1;
                            this.r = mutex3;
                            this.w = object3;
                            this.X = null;
                            this.Y = null;
                            this.Z = null;
                            this.b0 = null;
                            this.c0 = null;
                            this.B = v9;
                            this.D = v8;
                            this.G = v7;
                            this.I = v1;
                            this.e0 = v6;
                            this.E = 7;
                            if(DelayKt.delay-VtjQ1oo(e0.o, this) != a0) {
                                v14 = v6;
                                object7 = object3;
                                mutex4 = mutex3;
                                goto label_264;
                            }
                            return a0;
                        }
                    }
                    else {
                        this.r = mutex3;
                        this.w = object3;
                        this.X = null;
                        this.Y = null;
                        this.Z = null;
                        this.b0 = null;
                        this.c0 = null;
                        this.B = v9;
                        this.D = v8;
                        this.G = v7;
                        this.I = v1;
                        this.e0 = v6;
                        this.E = 6;
                        if(e0.e(e00, w1, ((k1)n10).a, this) != a0) {
                            v13 = v1;
                            object7 = object3;
                            mutex4 = mutex3;
                            object2 = new g0(L0.d);
                            v = v13;
                            object1 = object7;
                            mutex1 = mutex4;
                            break;
                        }
                        return a0;
                    }
                    break;
                }
                catch(Throwable throwable1) {
                    goto label_316;
                }
            }
            case 4: {
                try {
                    v15 = this.e0;
                    v16 = this.I;
                    v17 = this.G;
                    v8 = this.D;
                    v9 = this.B;
                    Object object8 = this.w;
                    Mutex mutex5 = this.r;
                    object3 = object8;
                    mutex3 = mutex5;
                    d5.n.D(object0);
                    object3 = object8;
                    mutex3 = mutex5;
                }
                catch(Throwable throwable1) {
                    v1 = v16;
                    goto label_316;
                }
                try {
                label_203:
                    this.r = mutex3;
                    this.w = object3;
                    this.X = null;
                    this.Y = null;
                    this.Z = null;
                    this.b0 = null;
                    this.c0 = null;
                    this.d0 = e00;
                    this.B = v9;
                    this.D = v8;
                    this.G = v17;
                    this.I = v16;
                    this.e0 = v15;
                    this.E = 5;
                    object9 = FlowKt.first(new s(FlowKt.catch(((j1)l0).b.a.getData(), new n0(((j1)l0).b, null, 1)), 7), this);
                    if(object9 != a0) {
                        goto label_230;
                    }
                    return a0;
                }
                catch(Throwable throwable1) {
                    v1 = v16;
                    goto label_316;
                }
                goto label_230;
            }
            case 5: {
                try {
                    v13 = this.I;
                    e0 e01 = this.d0;
                    object7 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    object3 = object7;
                    object9 = object0;
                    mutex3 = mutex4;
                    v16 = v13;
                    e00 = e01;
                }
                catch(Throwable throwable1) {
                    v1 = v13;
                    object3 = object7;
                    mutex3 = mutex4;
                    goto label_316;
                }
                try {
                label_230:
                    e0.i(e00, ((Number)object9).longValue(), s, "SUCCESS");
                    object2 = h0.a;
                    object1 = object3;
                    mutex1 = mutex3;
                    v = v16;
                    break;
                }
                catch(Throwable throwable1) {
                    v1 = v16;
                    goto label_316;
                }
            }
            case 6: {
                try {
                    v13 = this.I;
                    object7 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                }
                catch(Throwable throwable1) {
                    v1 = v13;
                    object3 = object7;
                    mutex3 = mutex4;
                    goto label_316;
                }
                try {
                    object2 = new g0(L0.d);
                    v = v13;
                    object1 = object7;
                    mutex1 = mutex4;
                    break;
                }
                catch(Throwable throwable1) {
                    goto label_313;
                }
            }
            case 7: {
                try {
                    v14 = this.e0;
                    int v18 = this.G;
                    int v19 = this.D;
                    v9 = this.B;
                    object10 = this.w;
                    long v20 = this.I;
                    mutex6 = this.r;
                    v1 = v20;
                    d5.n.D(object0);
                    object7 = object10;
                    v7 = v18;
                    v8 = v19;
                    v1 = v20;
                    mutex4 = mutex6;
                }
                catch(Throwable throwable1) {
                    mutex3 = mutex6;
                    object3 = object10;
                    goto label_316;
                }
                try {
                label_264:
                    this.r = mutex4;
                    this.w = object7;
                    this.X = null;
                    this.Y = null;
                    this.Z = null;
                    this.b0 = null;
                    this.c0 = null;
                    this.B = v9;
                    this.D = v8;
                    this.G = v7;
                    this.I = v1;
                    this.e0 = v14;
                    this.E = 8;
                    object2 = e00.p(u.d, s + e00.l, this);
                }
                catch(Throwable throwable1) {
                    goto label_314;
                }
                if(object2 != a0) {
                    v13 = v1;
                    v = v13;
                    object1 = object7;
                    mutex1 = mutex4;
                    break;
                }
                try {
                    return a0;
                }
                catch(Throwable throwable1) {
                }
                goto label_316;
            }
            case 8: {
                try {
                    v13 = this.I;
                    object7 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    object2 = object0;
                    v = v13;
                    object1 = object7;
                    mutex1 = mutex4;
                    break;
                label_296:
                    v13 = this.I;
                    n11 = this.c0;
                    object7 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    goto label_307;
                }
                catch(Throwable throwable1) {
                }
                v1 = v13;
                object3 = object7;
                mutex3 = mutex4;
                goto label_316;
            }
            case 9: {
                goto label_296;
                try {
                label_307:
                    v = v13;
                    object1 = object7;
                    mutex1 = mutex4;
                    object2 = new f0(((l1)n11).a);
                    break;
                }
                catch(Throwable throwable1) {
                label_313:
                    v1 = v13;
                }
            label_314:
                object3 = object7;
                mutex3 = mutex4;
                try {
                label_316:
                    long v21 = System.currentTimeMillis() - v1;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByAuto (" + v21 + "ms)", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByAuto (" + v21 + "ms)");
                    throw throwable1;
                }
                catch(Throwable throwable0) {
                    object1 = object3;
                    mutex1 = mutex3;
                    mutex1.unlock(object1);
                    throw throwable0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            long v22 = System.currentTimeMillis() - v;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByAuto (" + v22 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByAuto (" + v22 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex1.unlock(object1);
            throw throwable0;
        }
        mutex1.unlock(object1);
        return object2;
    }
}

