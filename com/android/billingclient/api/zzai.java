package com.android.billingclient.api;

public final class zzai implements Runnable {
    public final BillingClientImpl zza;
    public final ConsumeResponseListener zzb;
    public final ConsumeParams zzc;

    public zzai(BillingClientImpl billingClientImpl0, ConsumeResponseListener consumeResponseListener0, ConsumeParams consumeParams0) {
        this.zza = billingClientImpl0;
        this.zzb = consumeResponseListener0;
        this.zzc = consumeParams0;
    }

    @Override
    public final void run() {
        this.zza.zzT(this.zzb, this.zzc);
    }
}

