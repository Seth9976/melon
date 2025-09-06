package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda1 implements ConsumeResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda1(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.ConsumeResponseListener
    public final void onConsumeResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull String s) {
        BillingClientKotlinKt.$r8$lambda$BC2cAL2vk_I3dV-pkSAsSywRIek(this.f$0, billingResult0, s);
    }
}

