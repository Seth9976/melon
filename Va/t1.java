package va;

import Tf.v;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import java.io.IOException;
import java.util.List;
import je.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import ne.a;
import oe.c;

public final class t1 {
    public final CoroutineDispatcher a;
    public final AccountManager b;
    public final LogU c;

    public t1(CoroutineDispatcher coroutineDispatcher0, AccountManager accountManager0) {
        q.g(coroutineDispatcher0, "ioDispatcher");
        super();
        this.a = coroutineDispatcher0;
        this.b = accountManager0;
        this.c = LogU.Companion.create("SimpleLoginAccountDataSourceImpl", true, Category.Login);
    }

    public final List a() {
        Account[] arr_account = this.b.getAccountsByType("com.iloen.auth.login");
        q.f(arr_account, "getAccountsByType(...)");
        return n.N(arr_account);
    }

    public final Account b(String s) {
        for(Object object0: this.a()) {
            if(v.j0(((Account)object0).name, s, true)) {
                return (Account)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final Object c(Account account0, r1 r10) {
        s1 s10 = new s1(this, account0, null);
        return BuildersKt.withContext(this.a, s10, r10);
    }

    public final Object d(String s, c c0) {
        r1 r10;
        if(c0 instanceof r1) {
            r10 = (r1)c0;
            int v = r10.B;
            if((v & 0x80000000) == 0) {
                r10 = new r1(this, c0);
            }
            else {
                r10.B = v ^ 0x80000000;
            }
        }
        else {
            r10 = new r1(this, c0);
        }
        Object object0 = r10.r;
        a a0 = a.a;
        switch(r10.B) {
            case 0: {
                d5.n.D(object0);
                if(s.length() == 0) {
                    LogU.debug$default(this.c, "removeAccount() userId is empty", null, false, 6, null);
                    return false;
                }
                Account account0 = this.b(s);
                if(account0 == null) {
                    LogU.debug$default(this.c, "removeAccount() account not found userId=" + s, null, false, 6, null);
                    return false;
                }
                try {
                    r10.B = 1;
                    object0 = this.c(account0, r10);
                    if(object0 == a0) {
                        return a0;
                    label_25:
                        d5.n.D(object0);
                    }
                    LogU.debug$default(this.c, "removeAccount() result: " + ((Boolean)object0).booleanValue(), null, false, 6, null);
                    return object0;
                }
                catch(IllegalStateException illegalStateException0) {
                    break;
                }
                catch(OperationCanceledException operationCanceledException0) {
                    LogU.warn$default(this.c, "removeAccount() failed", operationCanceledException0, false, 4, null);
                    return false;
                }
                catch(AuthenticatorException authenticatorException0) {
                    LogU.warn$default(this.c, "removeAccount() failed", authenticatorException0, false, 4, null);
                    return false;
                }
                catch(IOException iOException0) {
                    LogU.warn$default(this.c, "removeAccount() failed", iOException0, false, 4, null);
                    return false;
                }
            }
            case 1: {
                goto label_25;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.warn$default(this.c, "removeAccount() failed", illegalStateException0, false, 4, null);
        return false;
    }
}

