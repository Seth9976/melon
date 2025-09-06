package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda9 implements AlternativeBillingOnlyReportingDetailsListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda9(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.AlternativeBillingOnlyReportingDetailsListener
    public final void onAlternativeBillingOnlyTokenResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0) {
        BillingClientKotlinKt.$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25-w(this.f$0, billingResult0, alternativeBillingOnlyReportingDetails0);
    }
}

