package com.android.billingclient.api;

public final class zzaa implements Runnable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyReportingDetailsListener zzb;

    public zzaa(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyReportingDetailsListener0;
    }

    @Override
    public final void run() {
        this.zza.zzU(this.zzb);
    }
}

