package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgj;

final class zzay extends ResultReceiver {
    final ExternalOfferInformationDialogListener zza;
    final BillingClientImpl zzb;

    public zzay(BillingClientImpl billingClientImpl0, Handler handler0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        this.zza = externalOfferInformationDialogListener0;
        this.zzb = billingClientImpl0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(v);
        if(v != 0) {
            if(bundle0 == null) {
                BillingClientImpl.zzah(this.zzb, 97, 25, zzce.zzj);
                this.zza.onExternalOfferInformationDialogResponse(zzce.zzj);
                return;
            }
            billingResult$Builder0.setDebugMessage(zzb.zzg(bundle0, "BillingClient"));
            int v1 = bundle0.getInt("INTERNAL_LOG_ERROR_REASON");
            this.zzb.zzap(zzcb.zzb((v1 == 0 ? 23 : zzgj.zza(v1)), 25, billingResult$Builder0.build(), bundle0.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
        }
        BillingResult billingResult0 = billingResult$Builder0.build();
        this.zza.onExternalOfferInformationDialogResponse(billingResult0);
    }
}

