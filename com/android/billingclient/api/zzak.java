package com.android.billingclient.api;

public final class zzak implements Runnable {
    public final BillingClientImpl zza;
    public final ExternalOfferReportingDetailsListener zzb;

    public zzak(BillingClientImpl billingClientImpl0, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferReportingDetailsListener0;
    }

    @Override
    public final void run() {
        this.zza.zzV(this.zzb);
    }
}

