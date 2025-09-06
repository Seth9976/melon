package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda3 implements ProductDetailsResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda3(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.ProductDetailsResponseListener
    public final void onProductDetailsResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        BillingClientKotlinKt.$r8$lambda$_HjOTKlijnqR-5v_YY-SPcvW1bw(this.f$0, billingResult0, list0);
    }
}

