package com.android.billingclient.api;

public final class zzag implements Runnable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyAvailabilityListener zzb;

    public zzag(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyAvailabilityListener0;
    }

    @Override
    public final void run() {
        this.zza.zzX(this.zzb);
    }
}

