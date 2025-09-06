package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda5 implements ExternalOfferReportingDetailsListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda5(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.ExternalOfferReportingDetailsListener
    public final void onExternalOfferReportingDetailsResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull ExternalOfferReportingDetails externalOfferReportingDetails0) {
        BillingClientKotlinKt.$r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(this.f$0, billingResult0, externalOfferReportingDetails0);
    }
}

