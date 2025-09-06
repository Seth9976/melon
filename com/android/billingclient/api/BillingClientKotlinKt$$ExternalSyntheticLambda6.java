package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

public final class BillingClientKotlinKt..ExternalSyntheticLambda6 implements PurchaseHistoryResponseListener {
    @RecentlyNonNull
    public CompletableDeferred f$0;

    public BillingClientKotlinKt..ExternalSyntheticLambda6(@RecentlyNonNull CompletableDeferred completableDeferred0) {
        this.f$0 = completableDeferred0;
    }

    @Override  // com.android.billingclient.api.PurchaseHistoryResponseListener
    public final void onPurchaseHistoryResponse(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        BillingClientKotlinKt.$r8$lambda$Jmx2bDJUe-jQbQfqNR-Rv-qVuz0(this.f$0, billingResult0, list0);
    }
}

