package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzga;
import org.json.JSONException;

final class zzbe extends zzc {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzcc zzb;
    final int zzc;

    public zzbe(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0, zzcc zzcc0, int v, zzbd zzbd0) {
        this.zza = alternativeBillingOnlyReportingDetailsListener0;
        this.zzb = zzcc0;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzd
    public final void zza(Bundle bundle0) {
        AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0;
        if(bundle0 == null) {
            zzga zzga0 = zzcb.zza(71, 15, zzce.zzj);
            this.zzb.zzb(zzga0, this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzce.zzj, null);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzce.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + v);
            zzga zzga1 = zzcb.zza(23, 15, billingResult0);
            this.zzb.zzb(zzga1, this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResult0, null);
            return;
        }
        String s = bundle0.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS");
        try {
            alternativeBillingOnlyReportingDetails0 = new AlternativeBillingOnlyReportingDetails(s);
        }
        catch(JSONException jSONException0) {
            zzb.zzl("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", jSONException0);
            zzga zzga2 = zzcb.zza(72, 15, zzce.zzj);
            this.zzb.zzb(zzga2, this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzce.zzj, null);
            return;
        }
        this.zza.onAlternativeBillingOnlyTokenResponse(billingResult0, alternativeBillingOnlyReportingDetails0);
    }
}

