package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda10 implements PurchasesResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda10(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.PurchasesResponseListener
    public final void onQueryPurchasesResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        BillingClientKotlinKt.$r8$lambda$Iy_vpeZ_JH-NmajeE6ZBdUlqJKA(this.f$0, billingResult0, list0);
    }
}

