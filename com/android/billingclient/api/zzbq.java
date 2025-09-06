package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzo;

final class zzbq extends zzo {
    final ExternalOfferAvailabilityListener zza;
    final zzcc zzb;
    final int zzc;

    public zzbq(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0, zzcc zzcc0, int v, zzbp zzbp0) {
        this.zza = externalOfferAvailabilityListener0;
        this.zzb = zzcc0;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzp
    public final void zza(Bundle bundle0) {
        if(bundle0 == null) {
            zzga zzga0 = zzcb.zza(92, 23, zzce.zzj);
            this.zzb.zzb(zzga0, this.zzc);
            this.zza.onExternalOfferAvailabilityResponse(zzce.zzj);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzce.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "isExternalOfferAvailableAsync() failed. Response code: " + v);
            zzga zzga1 = zzcb.zza(23, 23, billingResult0);
            this.zzb.zzb(zzga1, this.zzc);
        }
        this.zza.onExternalOfferAvailabilityResponse(billingResult0);
    }
}

