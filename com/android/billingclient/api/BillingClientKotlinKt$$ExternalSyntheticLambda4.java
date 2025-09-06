package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda4 implements AcknowledgePurchaseResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda4(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.AcknowledgePurchaseResponseListener
    public final void onAcknowledgePurchaseResponse(@RecentlyNonNull BillingResult billingResult0) {
        BillingClientKotlinKt.$r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(this.f$0, billingResult0);
    }
}

