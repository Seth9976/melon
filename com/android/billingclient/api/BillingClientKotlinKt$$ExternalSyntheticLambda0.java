package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda0 implements PurchasesResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda0(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.PurchasesResponseListener
    public final void onQueryPurchasesResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        BillingClientKotlinKt.$r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(this.f$0, billingResult0, list0);
    }
}

