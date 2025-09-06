package Z8;

import Bc.d;
import com.iloen.melon.utils.log.LogU;

public final class e {
    public final g a;
    public final d b;

    public e(g g0, d d0) {
        this.a = g0;
        this.b = d0;
    }

    public final void a(com.gaa.sdk.iap.d d0) {
        boolean z = d0.a();
        LogU.Companion.d("OneStoreIapClientLifecycle", "startConnection() " + z + ", " + d0.a + ", " + d0.b);
        if(d0.a()) {
            this.a.g = true;
            this.b.invoke();
        }
    }
}

