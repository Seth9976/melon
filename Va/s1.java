package va;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class s1 extends i implements n {
    public final Account B;
    public int r;
    public final t1 w;

    public s1(t1 t10, Account account0, Continuation continuation0) {
        this.w = t10;
        this.B = account0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        t1 t10 = this.w;
        AccountManager accountManager0 = t10.b;
        a a0 = a.a;
        Account account0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                q1 q10 = new q1(t10, account0, null);
                object0 = BuildersKt.withContext(t10.a, q10, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        accountManager0.invalidateAuthToken("com.iloen.auth.login", ((String)object0));
        AccountManagerFuture accountManagerFuture0 = accountManager0.removeAccount(account0, null, null);
        if(accountManagerFuture0 != null) {
            Boolean boolean0 = (Boolean)accountManagerFuture0.getResult();
            return boolean0 == null ? false : Boolean.valueOf(boolean0.booleanValue());
        }
        return false;
    }
}

