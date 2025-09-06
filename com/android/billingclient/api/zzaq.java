package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzaq implements Callable {
    public final BillingClientImpl zza;
    public final ExternalOfferAvailabilityListener zzb;

    public zzaq(BillingClientImpl billingClientImpl0, ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferAvailabilityListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzt(this.zzb);
        return null;
    }
}

