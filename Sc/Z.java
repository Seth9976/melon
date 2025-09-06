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

public final class z extends i implements n {
    public P0 B;
    public DevLog D;
    public String E;
    public Mutex G;
    public boolean I;
    public int M;
    public final P0 N;
    public final boolean S;
    public Mutex r;
    public String w;

    public z(Continuation continuation0, P0 p00, boolean z) {
        this.N = p00;
        this.S = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z(continuation0, this.N, this.S);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v1;
        Mutex mutex1;
        boolean z1;
        String s1;
        DevLog devLog1;
        String s;
        Mutex mutex0;
        P0 p00;
        a a0 = a.a;
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                p00 = this.N;
                mutex0 = p00.j;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : smart_onChangeRemoveDuplicatedPlaylistOption"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : smart_onChangeRemoveDuplicatedPlaylistOption", devLog0);
                this.r = mutex0;
                this.w = "smart_onChangeRemoveDuplicatedPlaylistOption";
                this.B = p00;
                this.D = devLog0;
                this.E = "";
                this.G = mutex0;
                boolean z = this.S;
                this.I = z;
                this.M = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                s = "smart_onChangeRemoveDuplicatedPlaylistOption";
                devLog1 = devLog0;
                s1 = "";
                z1 = z;
                mutex1 = mutex0;
                break;
            }
            case 1: {
                z1 = this.I;
                mutex0 = this.G;
                s1 = this.E;
                devLog1 = this.D;
                p00 = this.B;
                s = this.w;
                mutex1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v1 = System.currentTimeMillis();
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
            ((S2)p00.e).p(z1);
        }
        catch(Throwable throwable0) {
            long v2 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v2 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v2 + "ms)");
            throw throwable0;
        }
        finally {
            mutex0.unlock(null);
        }
        long v3 = System.currentTimeMillis() - v1;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
        devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)");
        return H.a;
    }
}

