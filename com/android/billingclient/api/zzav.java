package com.android.billingclient.api;

import java.util.concurrent.Callable;

final class zzav implements Callable {
    final String zza;
    final PurchaseHistoryResponseListener zzb;
    final BillingClientImpl zzc;

    public zzav(BillingClientImpl billingClientImpl0, String s, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zza = s;
        this.zzb = purchaseHistoryResponseListener0;
        this.zzc = billingClientImpl0;
        super();
    }

    @Override
    public final Object call() {
        zzbt zzbt0 = BillingClientImpl.zzg(this.zzc, this.zza);
        this.zzb.onPurchaseHistoryResponse(zzbt0.zza(), zzbt0.zzb());
        return null;
    }
}

