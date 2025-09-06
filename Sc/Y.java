package sc;

import androidx.appcompat.app.o;
import com.iloen.melon.constants.ListKeepOption;
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

public final class y extends i implements n {
    public P0 B;
    public ListKeepOption D;
    public DevLog E;
    public String G;
    public Mutex I;
    public int M;
    public final P0 N;
    public final ListKeepOption S;
    public Mutex r;
    public String w;

    public y(P0 p00, ListKeepOption listKeepOption0, Continuation continuation0) {
        this.N = p00;
        this.S = listKeepOption0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.N, this.S, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v1;
        Mutex mutex2;
        String s1;
        ListKeepOption listKeepOption1;
        String s;
        DevLog devLog1;
        Mutex mutex1;
        P0 p00;
        a a0 = a.a;
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                p00 = this.N;
                Mutex mutex0 = p00.j;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : smart_onChangeListKeepOption"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : smart_onChangeListKeepOption", devLog0);
                this.r = mutex0;
                this.w = "smart_onChangeListKeepOption";
                this.B = p00;
                ListKeepOption listKeepOption0 = this.S;
                this.D = listKeepOption0;
                this.E = devLog0;
                this.G = "";
                this.I = mutex0;
                this.M = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                mutex1 = mutex0;
                devLog1 = devLog0;
                s = "smart_onChangeListKeepOption";
                listKeepOption1 = listKeepOption0;
                s1 = "";
                mutex2 = mutex1;
                break;
            }
            case 1: {
                mutex1 = this.I;
                s1 = this.G;
                devLog1 = this.E;
                listKeepOption1 = this.D;
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
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
            devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock obtain : " + s);
            ((S2)p00.e).o(listKeepOption1);
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
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
        devLog1.put("Lock[" + mutex2.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v3 + "ms)");
        return H.a;
    }
}

