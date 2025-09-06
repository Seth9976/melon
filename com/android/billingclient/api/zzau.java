package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzai;
import java.util.concurrent.Callable;

final class zzau implements Callable {
    final String zza;
    final PurchasesResponseListener zzb;
    final BillingClientImpl zzc;

    public zzau(BillingClientImpl billingClientImpl0, String s, PurchasesResponseListener purchasesResponseListener0) {
        this.zza = s;
        this.zzb = purchasesResponseListener0;
        this.zzc = billingClientImpl0;
        super();
    }

    @Override
    public final Object call() {
        zzcz zzcz0 = BillingClientImpl.zzag(this.zzc, this.zza, 9);
        if(zzcz0.zzb() != null) {
            this.zzb.onQueryPurchasesResponse(zzcz0.zza(), zzcz0.zzb());
            return null;
        }
        this.zzb.onQueryPurchasesResponse(zzcz0.zza(), zzai.zzk());
        return null;
    }
}

