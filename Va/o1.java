package va;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProducerScope;

public final class o1 implements OnAccountsUpdateListener {
    public final ProducerScope a;

    public o1(ProducerScope producerScope0) {
        this.a = producerScope0;
    }

    @Override  // android.accounts.OnAccountsUpdateListener
    public final void onAccountsUpdated(Account[] arr_account) {
        q.d(arr_account);
        ArrayList arrayList0 = new ArrayList(arr_account.length);
        for(int v = 0; v < arr_account.length; ++v) {
            String s = arr_account[v].name;
            q.f(s, "name");
            arrayList0.add(s);
        }
        this.a.trySend-JP2dKIU(arrayList0);
    }
}

