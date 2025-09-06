package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgj;

final class zzax extends ResultReceiver {
    final AlternativeBillingOnlyInformationDialogListener zza;
    final BillingClientImpl zzb;

    public zzax(BillingClientImpl billingClientImpl0, Handler handler0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        this.zza = alternativeBillingOnlyInformationDialogListener0;
        this.zzb = billingClientImpl0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(v);
        if(v != 0) {
            if(bundle0 == null) {
                BillingClientImpl.zzah(this.zzb, 73, 16, zzce.zzj);
                this.zza.onAlternativeBillingOnlyInformationDialogResponse(zzce.zzj);
                return;
            }
            billingResult$Builder0.setDebugMessage(zzb.zzg(bundle0, "BillingClient"));
            int v1 = bundle0.getInt("INTERNAL_LOG_ERROR_REASON");
            this.zzb.zzap(zzcb.zzb((v1 == 0 ? 23 : zzgj.zza(v1)), 16, billingResult$Builder0.build(), bundle0.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
        }
        BillingResult billingResult0 = billingResult$Builder0.build();
        this.zza.onAlternativeBillingOnlyInformationDialogResponse(billingResult0);
    }
}

