package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzi;
import org.json.JSONException;

final class zzbk extends zzi {
    final BillingConfigResponseListener zza;
    final zzcc zzb;
    final int zzc;

    public zzbk(BillingConfigResponseListener billingConfigResponseListener0, zzcc zzcc0, int v, zzbj zzbj0) {
        this.zza = billingConfigResponseListener0;
        this.zzb = zzcc0;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzj
    public final void zza(Bundle bundle0) {
        if(bundle0 == null) {
            zzga zzga0 = zzcb.zza(0x3F, 13, zzce.zzj);
            this.zzb.zzb(zzga0, this.zzc);
            this.zza.onBillingConfigResponse(zzce.zzj, null);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        String s = zzb.zzg(bundle0, "BillingClient");
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(v);
        billingResult$Builder0.setDebugMessage(s);
        if(v != 0) {
            zzb.zzk("BillingClient", "getBillingConfig() failed. Response code: " + v);
            BillingResult billingResult0 = billingResult$Builder0.build();
            zzga zzga1 = zzcb.zza(23, 13, billingResult0);
            this.zzb.zzb(zzga1, this.zzc);
            this.zza.onBillingConfigResponse(billingResult0, null);
            return;
        }
        if(!bundle0.containsKey("BILLING_CONFIG")) {
            zzb.zzk("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            billingResult$Builder0.setResponseCode(6);
            BillingResult billingResult1 = billingResult$Builder0.build();
            zzga zzga2 = zzcb.zza(0x40, 13, billingResult1);
            this.zzb.zzb(zzga2, this.zzc);
            this.zza.onBillingConfigResponse(billingResult1, null);
            return;
        }
        String s1 = bundle0.getString("BILLING_CONFIG");
        try {
            BillingConfig billingConfig0 = new BillingConfig(s1);
            BillingResult billingResult2 = billingResult$Builder0.build();
            this.zza.onBillingConfigResponse(billingResult2, billingConfig0);
        }
        catch(JSONException jSONException0) {
            zzb.zzl("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", jSONException0);
            zzga zzga3 = zzcb.zza(65, 13, zzce.zzj);
            this.zzb.zzb(zzga3, this.zzc);
            this.zza.onBillingConfigResponse(zzce.zzj, null);
        }
    }
}

