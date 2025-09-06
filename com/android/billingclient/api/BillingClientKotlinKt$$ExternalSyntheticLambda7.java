package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda7 implements AlternativeBillingOnlyAvailabilityListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda7(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.AlternativeBillingOnlyAvailabilityListener
    public final void onAlternativeBillingOnlyAvailabilityResponse(@RecentlyNonNull BillingResult billingResult0) {
        BillingClientKotlinKt.$r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(this.f$0, billingResult0);
    }
}

