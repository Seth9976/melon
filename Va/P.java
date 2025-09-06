package va;

import com.iloen.melon.LoginUser;
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

public final class p extends i implements n {
    public final Mutex B;
    public final Mutex D;
    public final DevLog E;
    public final e0 G;
    public Mutex r;
    public int w;

    public p(Mutex mutex0, Continuation continuation0, Mutex mutex1, DevLog devLog0, e0 e00) {
        this.B = mutex0;
        this.D = mutex1;
        this.E = devLog0;
        this.G = e00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.B, continuation0, this.D, this.E, this.G);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        LoginUser loginUser0;
        long v1;
        Mutex mutex2;
        DevLog devLog0 = this.E;
        Mutex mutex0 = this.D;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex1 = this.B;
                this.r = mutex1;
                this.w = 1;
                if(mutex1.lock(null, this) == a0) {
                    return a0;
                }
                mutex2 = mutex1;
                break;
            }
            case 1: {
                mutex2 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v1 = System.currentTimeMillis();
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-getLoginUserSuspend", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-getLoginUserSuspend");
            loginUser0 = this.G.j();
        }
        catch(Throwable throwable0) {
            long v2 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-getLoginUserSuspend (" + v2 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-getLoginUserSuspend (" + v2 + "ms)");
            throw throwable0;
        }
        finally {
            mutex2.unlock(null);
        }
        long v3 = System.currentTimeMillis() - v1;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-getLoginUserSuspend (" + v3 + "ms)", null, false, 6, null);
        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : LoginUseCase-getLoginUserSuspend (" + v3 + "ms)");
        return loginUser0;
    }
}

