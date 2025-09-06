package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda11 implements SkuDetailsResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda11(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.SkuDetailsResponseListener
    public final void onSkuDetailsResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        BillingClientKotlinKt.$r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(this.f$0, billingResult0, list0);
    }
}

