package com.android.billingclient.api;

public final class zzv implements Runnable {
    public final BillingClientImpl zza;
    public final AcknowledgePurchaseResponseListener zzb;

    public zzv(BillingClientImpl billingClientImpl0, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = acknowledgePurchaseResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzR(this.zzb);
    }
}

