package va;

import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
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

public final class h extends i implements n {
    public int B;
    public int D;
    public long E;
    public final Mutex G;
    public final Mutex I;
    public final DevLog M;
    public final va.n N;
    public Mutex r;
    public Object w;

    public h(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, va.n n0) {
        this.G = mutex0;
        this.I = mutex1;
        this.M = devLog0;
        this.N = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.G, continuation0, this.I, this.M, this.N);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        p p0;
        o o0;
        long v2;
        Mutex mutex3;
        Object object3;
        Object object2;
        long v1;
        int v;
        Mutex mutex2;
        Object object1;
        a a0 = a.a;
        DevLog devLog0 = this.M;
        Mutex mutex0 = this.I;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex1 = this.G;
                this.r = mutex1;
                object1 = null;
                this.w = null;
                this.B = 0;
                this.D = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                mutex2 = mutex1;
                v = 0;
                goto label_20;
            }
            case 1: {
                v = this.B;
                object1 = this.w;
                mutex2 = this.r;
                d5.n.D(object0);
                try {
                label_20:
                    v1 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-checkTokenValidAndUpdate", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-checkTokenValidAndUpdate");
                    try {
                        this.r = mutex2;
                        this.w = object1;
                        this.B = v;
                        this.E = v1;
                        this.D = 2;
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                        cancellableContinuationImpl0.initCancellability();
                        this.N.d().accessTokenInfo(new g(cancellableContinuationImpl0, 0));
                        object2 = cancellableContinuationImpl0.getResult();
                    }
                    catch(Exception exception0) {
                        object3 = object1;
                        mutex3 = mutex2;
                        v2 = v1;
                        o0 = d5.n.t(exception0);
                        p0 = new p(o0);
                        goto label_65;
                    }
                }
                catch(Throwable throwable0) {
                    object3 = object1;
                    mutex3 = mutex2;
                    v2 = v1;
                    break;
                }
                if(object2 == a0) {
                    return a0;
                }
                object3 = object1;
                mutex3 = mutex2;
                v2 = v1;
                o0 = ((p)object2).a;
                p0 = new p(o0);
                goto label_65;
            }
            case 2: {
                try {
                    try {
                        v2 = this.E;
                        object3 = this.w;
                        mutex3 = this.r;
                        d5.n.D(object0);
                        object2 = object0;
                        o0 = ((p)object2).a;
                        p0 = new p(o0);
                        goto label_65;
                    }
                    catch(Exception exception0) {
                    }
                    o0 = d5.n.t(exception0);
                    p0 = new p(o0);
                    goto label_65;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            long v3 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-checkTokenValidAndUpdate (" + v3 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-checkTokenValidAndUpdate (" + v3 + "ms)");
            throw throwable0;
        label_65:
            long v4 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-checkTokenValidAndUpdate (" + v4 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : KakaoLoginRepository-checkTokenValidAndUpdate (" + v4 + "ms)");
        }
        catch(Throwable throwable1) {
            mutex3.unlock(object3);
            throw throwable1;
        }
        mutex3.unlock(object3);
        return p0;
    }
}

