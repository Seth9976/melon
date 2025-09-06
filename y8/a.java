package Y8;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.GoogleIapPurchaseRestoreRes.RESPONSE;
import com.iloen.melon.net.v6x.response.GoogleIapPurchaseRestoreRes;
import com.iloen.melon.utils.log.LogU;

public final class a implements ErrorListener, Listener {
    public final int a;
    public final d b;

    public a(d d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 1) {
            this.b.e();
            LogU.Companion.e("BillingClientLifecycle", "requestConfirmPurchase() error:" + volleyError0);
            d.b(this.b, 2001);
            return;
        }
        this.b.e();
        LogU.Companion.e("BillingClientLifecycle", "requestRestorePurchase() error:" + volleyError0);
        d.b(this.b, 2002);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        d d0 = this.b;
        d0.e();
        RESPONSE googleIapPurchaseRestoreRes$RESPONSE0 = ((GoogleIapPurchaseRestoreRes)object0).response;
        String s = googleIapPurchaseRestoreRes$RESPONSE0 == null ? null : googleIapPurchaseRestoreRes$RESPONSE0.restoreResult;
        if(s != null) {
            LogU.Companion.d("BillingClientLifecycle", "requestRestorePurchase() restoreResult:" + s);
            e e0 = new e(1001, s);
            d0.c.postValue(e0);
            return;
        }
        LogU.Companion.d("BillingClientLifecycle", "requestRestorePurchase() restoreResult is null");
        d.b(d0, 2002);
    }
}

