package com.android.billingclient.api;

public final class zzal implements Runnable {
    public final BillingClientImpl zza;
    public final ExternalOfferInformationDialogListener zzb;

    public zzal(BillingClientImpl billingClientImpl0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferInformationDialogListener0;
    }

    @Override
    public final void run() {
        this.zza.zzae(this.zzb);
    }
}

