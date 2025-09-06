package Z8;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.gaa.sdk.auth.e;
import com.iloen.melon.net.v6x.response.OneStoreIapPurchaseRes;
import com.iloen.melon.net.v6x.response.OneStoreIapPurchaseRestoreRes.RESPONSE;
import com.iloen.melon.net.v6x.response.OneStoreIapPurchaseRestoreRes;
import com.iloen.melon.utils.log.LogU;

public final class b implements ErrorListener, Listener {
    public final int a;
    public final g b;

    public b(g g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    public void a(e e0) {
        if(this.a != 1) {
            boolean z = e0.a();
            LogU.Companion.d("OneStoreIapClientLifecycle", "launchSignInFlow " + z + ", " + e0.a + ", " + e0.b);
            boolean z1 = e0.a();
            g g0 = this.b;
            g0.h = z1;
            if(z1) {
                g0.i();
            }
            return;
        }
        boolean z2 = e0.a();
        LogU.Companion.d("OneStoreIapClientLifecycle", "silentSignIn() " + z2 + ", " + e0.a + ", " + e0.b);
        this.b.h = e0.a();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 4) {
            LogU.Companion.e("OneStoreIapClientLifecycle", "restore() error:" + volleyError0);
            g.f(this.b, 20002, false, null, 10);
            return;
        }
        LogU.Companion.e("OneStoreIapClientLifecycle", "requestConfirmPurchase() error:" + volleyError0);
        g.f(this.b, 20001, false, null, 10);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 3) {
            g g0 = this.b;
            g0.i();
            RESPONSE oneStoreIapPurchaseRestoreRes$RESPONSE0 = ((OneStoreIapPurchaseRestoreRes)object0).response;
            String s = oneStoreIapPurchaseRestoreRes$RESPONSE0 == null ? null : oneStoreIapPurchaseRestoreRes$RESPONSE0.restoreResult;
            if(s != null) {
                LogU.Companion.d("OneStoreIapClientLifecycle", "restore() restoreResult:" + s);
                g.f(g0, 10001, false, s, 2);
                return;
            }
            LogU.Companion.w("OneStoreIapClientLifecycle", "restore() response is null");
            g.f(g0, 20002, false, null, 10);
            return;
        }
        g g1 = this.b;
        g1.i();
        com.iloen.melon.net.v6x.response.OneStoreIapPurchaseRes.RESPONSE oneStoreIapPurchaseRes$RESPONSE0 = ((OneStoreIapPurchaseRes)object0).response;
        if(oneStoreIapPurchaseRes$RESPONSE0 != null) {
            g.f(g1, 10000, true, oneStoreIapPurchaseRes$RESPONSE0.link.returnUrl, 2);
            return;
        }
        LogU.Companion.w("OneStoreIapClientLifecycle", "requestConfirmPurchase() response is null");
        g.f(g1, 20001, true, null, 10);
    }
}

