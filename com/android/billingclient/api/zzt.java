package com.android.billingclient.api;

public final class zzt implements Runnable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyInformationDialogListener zzb;

    public zzt(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyInformationDialogListener0;
    }

    @Override
    public final void run() {
        this.zza.zzad(this.zzb);
    }
}

