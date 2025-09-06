package va;

import A8.l;
import A8.r;
import A8.u;
import A8.z;
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

public final class y extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final L0 N;
    public final Mutex S;
    public final DevLog T;
    public final l V;
    public final e0 W;
    public final u X;
    public z Y;
    public int Z;
    public Mutex r;
    public Object w;

    public y(Mutex mutex0, Continuation continuation0, L0 l00, Mutex mutex1, DevLog devLog0, l l0, e0 e00, u u0) {
        this.M = mutex0;
        this.N = l00;
        this.S = mutex1;
        this.T = devLog0;
        this.V = l0;
        this.W = e00;
        this.X = u0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.M, continuation0, this.N, this.S, this.T, this.V, this.W, this.X);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object8;
        Mutex mutex6;
        long v13;
        Object object7;
        int v7;
        int v6;
        int v5;
        int v4;
        Object object5;
        j1 j10;
        mb.l l2;
        String s2;
        Mutex mutex4;
        Object object4;
        String s1;
        r r1;
        u u0;
        r r0;
        mb.l l1;
        String s;
        Long long0;
        l l0;
        z z0;
        Mutex mutex3;
        Object object3;
        int v3;
        LogU logU0;
        long v2;
        Object object1;
        int v;
        Mutex mutex1;
        a a0 = a.a;
        DevLog devLog0 = this.T;
        L0 l00 = this.N;
        Mutex mutex0 = this.S;
        e0 e00 = this.W;
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
                v = 0;
                object1 = null;
                goto label_24;
            }
            case 1: {
                int v1 = this.B;
                Object object2 = this.w;
                Mutex mutex2 = this.r;
                d5.n.D(object0);
                v = v1;
                mutex1 = mutex2;
                object1 = object2;
                try {
                label_24:
                    v2 = System.currentTimeMillis();
                    l00.a(" LoginUseCase-loginByKakao()", true);
                    logU0 = MutexLockUtil.INSTANCE.getLog();
                    v3 = mutex0.hashCode();
                }
                catch(Throwable throwable0) {
                    object3 = object1;
                    mutex3 = mutex1;
                    mutex4 = mutex3;
                    object4 = object3;
                    goto label_172;
                }
                try {
                    LogU.debug$default(logU0, "ReentrantLock[" + v3 + "]  Lock obtain : LoginUseCase-loginByKakao()", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakao()");
                    z0 = () -> "KAKAO";
                    l0 = this.V;
                    if(l0 == null) {
                        goto label_40;
                    }
                    else {
                        long0 = new Long(l0.a);
                    }
                    goto label_41;
                }
                catch(Throwable throwable0) {
                    goto label_83;
                }
                try {
                    long0 = new Long(l0.a);
                    goto label_41;
                }
                catch(Throwable throwable0) {
                    object4 = object1;
                    mutex4 = mutex1;
                    goto label_172;
                }
            label_40:
                long0 = null;
                try {
                label_41:
                    LogU.debug$default(e00.j, "loginByKakao(), kakaoLoginData-userId: " + long0, null, false, 6, null);
                    e00.k.put("loginByKakao(), kakaoLoginData-userId: " + long0);
                    if(l0 == null) {
                        s = "";
                        goto label_49;
                    }
                }
                catch(Throwable throwable0) {
                    goto label_83;
                }
                try {
                    s = new Long(l0.a).toString();
                    if(s == null) {
                        try {
                            s = "";
                        label_49:
                            l1 = e00.b;
                            r0 = r.g;
                            u0 = this.X == null ? u.d : this.X;
                            if(l0 == null) {
                                r1 = r0;
                                s1 = null;
                            }
                            else {
                                r1 = r0;
                                s1 = l0.c;
                            }
                            goto label_63;
                        }
                        catch(Throwable throwable0) {
                            goto label_83;
                        }
                    }
                    goto label_49;
                }
                catch(Throwable throwable0) {
                }
                object4 = object1;
                mutex4 = mutex1;
                goto label_172;
            label_63:
                if(l0 == null) {
                    l2 = l1;
                    s2 = null;
                }
                else {
                    s2 = l0.b;
                    l2 = l1;
                }
                try {
                    this.r = mutex1;
                    this.w = object1;
                    this.Y = z0;
                    this.B = v;
                    this.D = 0;
                    this.G = 0;
                    this.I = v2;
                    this.Z = 0;
                    this.E = 2;
                    j10 = (j1)l2;
                    mutex3 = mutex1;
                    object3 = object1;
                }
                catch(Throwable throwable0) {
                label_83:
                    mutex3 = mutex1;
                    object3 = object1;
                    mutex4 = mutex3;
                    object4 = object3;
                    goto label_172;
                }
                try {
                    object5 = j10.g(r1, u0, s, s1, s2, this);
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex3;
                    object4 = object3;
                    goto label_172;
                }
                if(object5 == a0) {
                    return a0;
                }
                mutex4 = mutex3;
                object4 = object3;
                v4 = v;
                v5 = 0;
                v6 = 0;
                v7 = 0;
                goto label_121;
            }
            case 2: {
                try {
                    int v8 = this.G;
                    int v9 = this.D;
                    int v10 = this.Z;
                    int v11 = this.B;
                    z z1 = this.Y;
                    long v12 = this.I;
                    Object object6 = this.w;
                    Mutex mutex5 = this.r;
                    object4 = object6;
                    mutex4 = mutex5;
                    v2 = v12;
                    d5.n.D(object0);
                    v7 = v10;
                    v6 = v8;
                    v5 = v9;
                    object4 = object6;
                    mutex4 = mutex5;
                    v4 = v11;
                    z0 = z1;
                    object5 = object0;
                    v2 = v12;
                label_121:
                    LogU.debug$default(e00.j, "loginByKakao() doLoginByKakao result: " + ((n1)object5), null, false, 6, null);
                    if(((n1)object5) instanceof m1) {
                        goto label_142;
                    }
                    else if(!(((n1)object5) instanceof k1)) {
                        if(!(((n1)object5) instanceof l1)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        e0.g(e00);
                        object7 = new f0(((l1)(((n1)object5))).a);
                    }
                    else {
                        this.r = mutex4;
                        this.w = object4;
                        this.Y = null;
                        this.B = v4;
                        this.D = v5;
                        this.G = v6;
                        this.I = v2;
                        this.Z = v7;
                        this.E = 4;
                        if(e0.e(e00, z0, ((k1)(((n1)object5))).a, this) != a0) {
                            v13 = v2;
                            object7 = new g0(va.L0.d);
                            v2 = v13;
                            break;
                        }
                        return a0;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_172;
                }
                try {
                    v13 = v2;
                    object7 = new g0(va.L0.d);
                    v2 = v13;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_171;
                }
                try {
                label_142:
                    this.r = mutex4;
                    this.w = object4;
                    this.Y = null;
                    this.B = v4;
                    this.D = v5;
                    this.G = v6;
                    this.I = v2;
                    this.Z = v7;
                    this.E = 3;
                    if(e0.f(e00, z0, ((m1)(((n1)object5))).a, this) != a0) {
                        object7 = h0.a;
                        break;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    goto label_172;
                }
                try {
                    object7 = h0.a;
                    break;
                label_158:
                    v13 = this.I;
                    object4 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    object7 = h0.a;
                    v2 = v13;
                    break;
                label_164:
                    v13 = this.I;
                    object4 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    object7 = new g0(va.L0.d);
                    v2 = v13;
                    break;
                }
                catch(Throwable throwable0) {
                }
                goto label_171;
            }
            case 3: {
                goto label_158;
            }
            case 4: {
                goto label_164;
            label_171:
                v2 = v13;
                try {
                label_172:
                    long v14 = System.currentTimeMillis() - v2;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByKakao() (" + v14 + "ms)", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByKakao() (" + v14 + "ms)");
                    l00.a(" LoginUseCase-loginByKakao()", false);
                    throw throwable0;
                }
                catch(Throwable throwable1) {
                    mutex6 = mutex4;
                    object8 = object4;
                    mutex6.unlock(object8);
                    throw throwable1;
                }
                v2 = v13;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            mutex6 = mutex4;
            object8 = object4;
            long v15 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByKakao() (" + v15 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-loginByKakao() (" + v15 + "ms)");
            l00.a(" LoginUseCase-loginByKakao()", false);
        }
        catch(Throwable throwable1) {
            mutex6.unlock(object8);
            throw throwable1;
        }
        mutex6.unlock(object8);
        return object7;
    }
}

