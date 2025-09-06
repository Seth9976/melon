package com.android.billingclient.api;

public final class zzar implements Runnable {
    public final BillingClientImpl zza;
    public final ExternalOfferAvailabilityListener zzb;

    public zzar(BillingClientImpl billingClientImpl0, ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferAvailabilityListener0;
    }

    @Override
    public final void run() {
        this.zza.zzY(this.zzb);
    }
}

