package va;

import A8.q;
import A8.r;
import A8.u;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import we.n;

public final class a1 extends i implements n {
    public int B;
    public int D;
    public long E;
    public final Mutex G;
    public final Mutex I;
    public final DevLog M;
    public final j1 N;
    public final String S;
    public Mutex r;
    public Object w;

    public a1(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, j1 j10, String s) {
        this.G = mutex0;
        this.I = mutex1;
        this.M = devLog0;
        this.N = j10;
        this.S = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a1(this.G, continuation0, this.I, this.M, this.N, this.S);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v3;
        Mutex mutex4;
        Object object3;
        long v2;
        Object object1;
        Mutex mutex2;
        int v;
        j1 j10 = this.N;
        a a0 = a.a;
        DevLog devLog0 = this.M;
        Mutex mutex0 = this.I;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex1 = this.G;
                this.r = mutex1;
                this.w = null;
                v = 0;
                this.B = 0;
                this.D = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                mutex2 = mutex1;
                object1 = null;
                goto label_24;
            }
            case 1: {
                int v1 = this.B;
                Object object2 = this.w;
                Mutex mutex3 = this.r;
                d5.n.D(object0);
                v = v1;
                object1 = object2;
                mutex2 = mutex3;
                try {
                label_24:
                    v2 = System.currentTimeMillis();
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByOtpBackground()", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByOtpBackground()");
                    LogU.debug$default(j10.d, "doLoginByOtp()", null, false, 6, null);
                    q q0 = q.a(j1.a(j10, r.k, u.d), null, null, this.S, null, null, null, 0xFFFB);
                    j10.i = true;
                    this.r = mutex2;
                    this.w = object1;
                    this.B = v;
                    this.E = v2;
                    this.D = 2;
                    object3 = j1.b(j10, q0, this);
                }
                catch(Throwable throwable0) {
                    mutex4 = mutex2;
                    v3 = v2;
                    goto label_53;
                }
                if(object3 == a0) {
                    return a0;
                }
                mutex4 = mutex2;
                v3 = v2;
                goto label_57;
            }
            case 2: {
                try {
                    v3 = this.E;
                    object1 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    object3 = object0;
                    goto label_57;
                }
                catch(Throwable throwable0) {
                }
                try {
                label_53:
                    long v4 = System.currentTimeMillis() - v3;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : MelonLoginRepository-doLoginByOtpBackground() (" + v4 + "ms)", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : MelonLoginRepository-doLoginByOtpBackground() (" + v4 + "ms)");
                    throw throwable0;
                label_57:
                    long v5 = System.currentTimeMillis() - v3;
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : MelonLoginRepository-doLoginByOtpBackground() (" + v5 + "ms)", null, false, 6, null);
                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : MelonLoginRepository-doLoginByOtpBackground() (" + v5 + "ms)");
                    goto label_64;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex4.unlock(object1);
        throw throwable1;
    label_64:
        mutex4.unlock(object1);
        return object3;
    }
}

