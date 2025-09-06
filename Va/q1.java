package va;

import android.accounts.Account;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class q1 extends i implements n {
    public final t1 r;
    public final Account w;

    public q1(t1 t10, Account account0, Continuation continuation0) {
        this.r = t10;
        this.w = account0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q1(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        t1 t10 = this.r;
        d5.n.D(object0);
        try {
            return t10.b.blockingGetAuthToken(this.w, this.w.type, true);
        }
        catch(Exception exception0) {
            LogU.error$default(t10.c, "getAuthToken failed", exception0, false, 4, null);
            return null;
        }
    }
}

