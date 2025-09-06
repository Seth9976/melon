package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzm;

final class zzbo extends zzm {
    final AlternativeBillingOnlyAvailabilityListener zza;
    final zzcc zzb;
    final int zzc;

    public zzbo(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0, zzcc zzcc0, int v, zzbn zzbn0) {
        this.zza = alternativeBillingOnlyAvailabilityListener0;
        this.zzb = zzcc0;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzn
    public final void zza(Bundle bundle0) {
        if(bundle0 == null) {
            zzga zzga0 = zzcb.zza(67, 14, zzce.zzj);
            this.zzb.zzb(zzga0, this.zzc);
            this.zza.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzj);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzce.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + v);
            zzga zzga1 = zzcb.zza(23, 14, billingResult0);
            this.zzb.zzb(zzga1, this.zzc);
        }
        this.zza.onAlternativeBillingOnlyAvailabilityResponse(billingResult0);
    }
}

