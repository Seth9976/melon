package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzah implements Callable {
    public final BillingClientImpl zza;
    public final ConsumeParams zzb;
    public final ConsumeResponseListener zzc;

    public zzah(BillingClientImpl billingClientImpl0, ConsumeParams consumeParams0, ConsumeResponseListener consumeResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = consumeParams0;
        this.zzc = consumeResponseListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzl(this.zzb, this.zzc);
        return null;
    }
}

