package com.android.billingclient.api;

public final class zzao implements Runnable {
    public final BillingClientImpl zza;
    public final ProductDetailsResponseListener zzb;

    public zzao(BillingClientImpl billingClientImpl0, ProductDetailsResponseListener productDetailsResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = productDetailsResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzZ(this.zzb);
    }
}

