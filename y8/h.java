package Y8;

import android.app.Application;
import androidx.lifecycle.a;
import com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder;
import com.android.billingclient.api.BillingFlowParams.ProductDetailsParams;
import com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ProductDetails;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.log.LogU;
import e.k;
import e1.u;
import java.util.List;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e0;
import va.o;

public final class h extends a {
    public final d a;
    public final SingleLiveEvent b;
    public final SingleLiveEvent c;
    public String d;
    public final SingleLiveEvent e;
    public final SingleLiveEvent f;

    public h(@NotNull Application application0) {
        q.g(application0, "application");
        super(application0);
        this.a = ((MelonAppBase)application0).getGoogleIapLifecycle();
        d d0 = ((MelonAppBase)application0).getGoogleIapLifecycle();
        SingleLiveEvent singleLiveEvent0 = null;
        this.b = d0 == null ? null : d0.d;
        d d1 = ((MelonAppBase)application0).getGoogleIapLifecycle();
        if(d1 != null) {
            singleLiveEvent0 = d1.e;
        }
        this.c = singleLiveEvent0;
        this.e = new SingleLiveEvent();
        this.f = new SingleLiveEvent();
    }

    public final void b(int v, String s) {
        e e0;
        if(v == 1003) {
            String s1 = this.d == null || this.d.length() == 0 || s == null || s.length() == 0 ? null : this.d + "&externalTransactionToken=" + s;
            e0 = s1 == null ? new e(2003, null) : new e(1003, s1);
        }
        else {
            e0 = new e(v, s);
        }
        this.e.postValue(e0);
        this.d = null;
    }

    public final void c(ProductDetails productDetails0, String s, String s1, SubscriptionUpdateParams billingFlowParams$SubscriptionUpdateParams0) {
        LogU.Companion.d("GoogleIapViewModel", "purchase() productDetails:" + productDetails0 + ", offerToken:" + s1 + ", returnData:" + s);
        Builder billingFlowParams$ProductDetailsParams$Builder0 = ProductDetailsParams.newBuilder();
        billingFlowParams$ProductDetailsParams$Builder0.setProductDetails(productDetails0);
        if(s1 != null) {
            billingFlowParams$ProductDetailsParams$Builder0.setOfferToken(s1);
        }
        List list0 = k.z(billingFlowParams$ProductDetailsParams$Builder0.build());
        com.android.billingclient.api.BillingFlowParams.Builder billingFlowParams$Builder0 = BillingFlowParams.newBuilder();
        billingFlowParams$Builder0.setProductDetailsParamsList(list0);
        billingFlowParams$Builder0.setObfuscatedAccountId(u.v(((e0)o.a()).j()));
        billingFlowParams$Builder0.setObfuscatedProfileId(s);
        if(billingFlowParams$SubscriptionUpdateParams0 != null) {
            billingFlowParams$Builder0.setSubscriptionUpdateParams(billingFlowParams$SubscriptionUpdateParams0);
        }
        BillingFlowParams billingFlowParams0 = billingFlowParams$Builder0.build();
        q.f(billingFlowParams0, "build(...)");
        this.f.postValue(billingFlowParams0);
    }
}

