package com.android.billingclient.api;

public final class zzx implements Runnable {
    public final BillingClientImpl zza;
    public final BillingConfigResponseListener zzb;

    public zzx(BillingClientImpl billingClientImpl0, BillingConfigResponseListener billingConfigResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = billingConfigResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzW(this.zzb);
    }
}

