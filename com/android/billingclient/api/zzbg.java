package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzga;
import org.json.JSONException;

final class zzbg extends zze {
    final ExternalOfferReportingDetailsListener zza;
    final zzcc zzb;
    final int zzc;

    public zzbg(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0, zzcc zzcc0, int v, zzbf zzbf0) {
        this.zza = externalOfferReportingDetailsListener0;
        this.zzb = zzcc0;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzf
    public final void zza(Bundle bundle0) {
        ExternalOfferReportingDetails externalOfferReportingDetails0;
        if(bundle0 == null) {
            zzga zzga0 = zzcb.zza(0x5F, 24, zzce.zzj);
            this.zzb.zzb(zzga0, this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zzce.zzj, null);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzce.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "createExternalOfferReportingDetailsAsync() failed. Response code: " + v);
            zzga zzga1 = zzcb.zza(23, 24, billingResult0);
            this.zzb.zzb(zzga1, this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResult0, null);
            return;
        }
        String s = bundle0.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS");
        try {
            externalOfferReportingDetails0 = new ExternalOfferReportingDetails(s);
        }
        catch(JSONException jSONException0) {
            zzb.zzl("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", jSONException0);
            zzga zzga2 = zzcb.zza(104, 24, zzce.zzj);
            this.zzb.zzb(zzga2, this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zzce.zzj, null);
            return;
        }
        this.zza.onExternalOfferReportingDetailsResponse(billingResult0, externalOfferReportingDetails0);
    }
}

