package com.android.billingclient.api;

public final class zzae implements Runnable {
    public final BillingClientImpl zza;
    public final PurchasesResponseListener zzb;

    public zzae(BillingClientImpl billingClientImpl0, PurchasesResponseListener purchasesResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = purchasesResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzab(this.zzb);
    }
}

