package com.android.billingclient.api;

public final class zzad implements Runnable {
    public final BillingClientImpl zza;
    public final SkuDetailsResponseListener zzb;

    public zzad(BillingClientImpl billingClientImpl0, SkuDetailsResponseListener skuDetailsResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = skuDetailsResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzac(this.zzb);
    }
}

