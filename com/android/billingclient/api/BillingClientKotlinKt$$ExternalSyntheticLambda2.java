package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda2 implements ExternalOfferAvailabilityListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda2(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.ExternalOfferAvailabilityListener
    public final void onExternalOfferAvailabilityResponse(@RecentlyNonNull BillingResult billingResult0) {
        BillingClientKotlinKt.$r8$lambda$OmYoMPMU8NG-G-TTJRupXijq_ag(this.f$0, billingResult0);
    }
}

