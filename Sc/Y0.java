package sc;

import androidx.appcompat.app.o;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import we.n;

public final class y0 extends i implements n {
    public P0 B;
    public DevLog D;
    public String E;
    public Mutex G;
    public int I;
    public final P0 M;
    public Mutex r;
    public String w;

    public y0(P0 p00, Continuation continuation0) {
        this.M = p00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y0(this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MutexLockUtil mutexLockUtil0;
        long v1;
        String s1;
        Mutex mutex2;
        DevLog devLog1;
        Mutex mutex1;
        String s;
        P0 p00;
        a a0 = a.a;
        switch(this.I) {
            case 0: {
                d5.n.D(object0);
                p00 = this.M;
                Mutex mutex0 = p00.j;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : smart_onQueueCountOverThreshold"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : smart_onQueueCountOverThreshold", devLog0);
                this.r = mutex0;
                s = "smart_onQueueCountOverThreshold";
                this.w = "smart_onQueueCountOverThreshold";
                this.B = p00;
                this.D = devLog0;
                this.E = "";
                this.G = mutex0;
                this.I = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                devLog1 = devLog0;
                mutex2 = mutex1;
                s1 = "";
                break;
            }
            case 1: {
                mutex1 = this.G;
                s1 = this.E;
                devLog1 = this.D;
                p00 = this.B;
                s = this.w;
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
            mutexLockUtil0 = MutexLockUtil.INSTANCE;
            LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
            devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
            if(!p00.k) {
                throw new IllegalArgumentException("onQueueCountOverThreshold - not restored");
            }
            h1 h10 = p00.Q();
            ((S2)p00.e).G(h10, false);
        }
        catch(Throwable throwable0) {
            long v2 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v2 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v2 + "ms)");
            throw throwable0;
        }
        finally {
            mutex1.unlock(null);
        }
        long v3 = System.currentTimeMillis() - v1;
        LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)");
        return H.a;
    }
}

