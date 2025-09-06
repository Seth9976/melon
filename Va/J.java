package va;

import A8.l;
import android.content.Context;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import e1.u;
import ie.H;
import ie.o;
import ie.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final Mutex N;
    public final DevLog S;
    public final va.n T;
    public final Context V;
    public OAuthToken W;
    public int X;
    public int Y;
    public Mutex r;
    public Object w;

    public j(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, va.n n0, Context context0) {
        this.M = mutex0;
        this.N = mutex1;
        this.S = devLog0;
        this.T = n0;
        this.V = context0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.M, continuation0, this.N, this.S, this.T, this.V);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        p p0;
        o o0;
        Object object5;
        OAuthToken oAuthToken0;
        Mutex mutex5;
        Object object4;
        int v8;
        int v7;
        int v6;
        int v5;
        long v4;
        Object object3;
        Mutex mutex4;
        long v3;
        Mutex mutex3;
        DevLog devLog2;
        Object object2;
        long v1;
        DevLog devLog1;
        int v;
        Object object1;
        Mutex mutex1;
        a a0 = a.a;
        DevLog devLog0 = this.S;
        va.n n0 = this.T;
        Mutex mutex0 = this.N;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                mutex1 = this.M;
                this.r = mutex1;
                object1 = null;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                try {
                    v = 0;
                    devLog1 = devLog0;
                    v1 = System.currentTimeMillis();
                    goto label_26;
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(object1);
                    throw throwable0;
                }
            }
            case 1: {
                int v2 = this.B;
                object1 = this.w;
                Mutex mutex2 = this.r;
                d5.n.D(object0);
                v = v2;
                mutex1 = mutex2;
                devLog1 = devLog0;
                try {
                    v1 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(object1);
                    throw throwable0;
                }
                try {
                label_26:
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-loginWithKakaoAccount", null, false, 6, null);
                    devLog1.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-loginWithKakaoAccount");
                }
                catch(Throwable throwable1) {
                    goto label_142;
                }
                try {
                    this.r = mutex1;
                    this.w = object1;
                    this.B = v;
                    this.D = 0;
                    this.G = 0;
                    this.I = v1;
                    this.X = 0;
                    this.Y = 0;
                    this.E = 2;
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                    cancellableContinuationImpl0.initCancellability();
                    UserApiClient userApiClient0 = n0.d();
                    g g0 = new g(cancellableContinuationImpl0, 1);
                    UserApiClient.loginWithKakaoAccount$default(userApiClient0, this.V, null, null, null, null, null, g0, 62, null);
                    object2 = cancellableContinuationImpl0.getResult();
                }
                catch(Throwable throwable2) {
                    devLog2 = devLog1;
                    mutex3 = mutex1;
                    v3 = v1;
                    break;
                }
                if(object2 == a0) {
                    return a0;
                }
                mutex4 = mutex1;
                object3 = object1;
                v4 = v1;
                object0 = object2;
                devLog2 = devLog1;
                v5 = 0;
                v6 = 0;
                v7 = 0;
                v8 = 0;
                goto label_85;
            }
            case 2: {
                try {
                    int v9 = this.Y;
                    v5 = this.X;
                    v4 = this.I;
                    int v10 = this.G;
                    v = this.B;
                    int v11 = this.D;
                    object4 = this.w;
                    mutex5 = this.r;
                    d5.n.D(object0);
                    v6 = v10;
                    v8 = v9;
                    v7 = v11;
                    devLog2 = devLog0;
                    mutex4 = mutex5;
                    object3 = object4;
                }
                catch(Throwable throwable2) {
                    mutex3 = mutex5;
                    v3 = v4;
                    devLog2 = devLog0;
                    object1 = object4;
                    break;
                }
                try {
                label_85:
                    oAuthToken0 = (OAuthToken)object0;
                    this.r = mutex4;
                    this.w = object3;
                    this.W = oAuthToken0;
                    this.B = v;
                    this.D = v7;
                    this.G = v6;
                    this.I = v4;
                    this.X = v5;
                    this.Y = v8;
                    this.E = 3;
                    CancellableContinuationImpl cancellableContinuationImpl1 = new CancellableContinuationImpl(u.D(this), 1);
                    cancellableContinuationImpl1.initCancellability();
                    UserApiClient.me$default(n0.d(), null, false, new g(cancellableContinuationImpl1, 2), 3, null);
                    object5 = cancellableContinuationImpl1.getResult();
                }
                catch(Throwable throwable2) {
                    object1 = object3;
                    v3 = v4;
                    mutex3 = mutex4;
                    break;
                }
                if(object5 == a0) {
                    return a0;
                }
                object1 = object3;
                v3 = v4;
                mutex3 = mutex4;
                goto label_121;
            }
            case 3: {
                try {
                    v3 = this.I;
                    OAuthToken oAuthToken1 = this.W;
                    object1 = this.w;
                    mutex3 = this.r;
                    devLog2 = devLog0;
                    d5.n.D(object0);
                    devLog2 = devLog0;
                    oAuthToken0 = oAuthToken1;
                    object5 = object0;
                label_121:
                    o0 = new l(((Number)object5).longValue(), oAuthToken0.getRefreshToken(), oAuthToken0.getAccessToken());
                    va.n.a(n0, ((l)o0));
                    goto label_132;
                }
                catch(Throwable throwable2) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            o0 = d5.n.t(throwable2);
        }
        catch(Throwable throwable1) {
            devLog1 = devLog2;
            mutex1 = mutex3;
            v1 = v3;
            goto label_142;
        }
        try {
        label_132:
            mutex1 = mutex3;
            v1 = v3;
            Throwable throwable3 = p.a(o0);
            if(throwable3 != null) {
                LogU.debug$default(n0.c, "loginWithKakaoAccount Failed: " + throwable3, null, false, 6, null);
                d5.n.t(throwable3);
            }
            p0 = new p(o0);
            goto label_146;
        }
        catch(Throwable throwable1) {
            devLog1 = devLog2;
        }
        try {
        label_142:
            long v12 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-loginWithKakaoAccount (" + v12 + "ms)", null, false, 6, null);
            devLog1.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-loginWithKakaoAccount (" + v12 + "ms)");
            throw throwable1;
        label_146:
            long v13 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-loginWithKakaoAccount (" + v13 + "ms)", null, false, 6, null);
            devLog2.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-loginWithKakaoAccount (" + v13 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex1.unlock(object1);
            throw throwable0;
        }
        mutex1.unlock(object1);
        return p0;
    }
}

