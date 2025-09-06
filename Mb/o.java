package mb;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.melon.data.newlogin.SimpleAccount;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.internal.Util;
import va.p1;
import va.u1;

public final class o {
    public final u1 a;

    public o(u1 u10) {
        q.g(u10, "simpleLoginRepository");
        super();
        this.a = u10;
    }

    public final Flow a() {
        this.a.a.getClass();
        return FlowKt.callbackFlow(new p1(this.a.a, null));
    }

    public final String b() {
        List list0 = this.a.a.a();
        AccountManager accountManager0 = this.a.a.b;
        Iterator iterator0 = p.C0(list0).iterator();
        if(!iterator0.hasNext()) {
            return null;
        }
        Object object0 = iterator0.next();
        if(iterator0.hasNext()) {
            String s = accountManager0.getUserData(((Account)object0), "melon_key_updated_time");
            long v = s == null ? 0L : Util.toLongOrDefault(s, 0L);
            while(true) {
                Object object1 = iterator0.next();
                String s1 = accountManager0.getUserData(((Account)object1), "melon_key_updated_time");
                long v1 = s1 == null ? 0L : Util.toLongOrDefault(s1, 0L);
                if(v < v1) {
                    object0 = object1;
                    v = v1;
                }
                if(!iterator0.hasNext()) {
                    break;
                }
            }
        }
        return ((Account)object0) == null ? null : ((Account)object0).name;
    }

    public final boolean c(String s) {
        q.g(s, "userId");
        this.a.getClass();
        Account account0 = this.a.a.b(s);
        if(account0 != null) {
            String s1 = account0.name;
            q.f(s1, "name");
            return new SimpleAccount(s1) != null;
        }
        return false;
    }

    public final boolean d() {
        return !this.a.a.a().isEmpty();
    }
}

