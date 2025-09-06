package com.android.billingclient.api;

public final class zzam implements Runnable {
    public final BillingClientImpl zza;
    public final PurchaseHistoryResponseListener zzb;

    public zzam(BillingClientImpl billingClientImpl0, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = purchaseHistoryResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzaa(this.zzb);
    }
}

