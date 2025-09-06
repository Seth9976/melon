package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "externalOfferReportingDetails", "Lcom/android/billingclient/api/ExternalOfferReportingDetails;", "(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getExternalOfferReportingDetails", "()Lcom/android/billingclient/api/ExternalOfferReportingDetails;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CreateExternalOfferReportingDetailsResult {
    @NotNull
    private final BillingResult zza;
    @Nullable
    private final ExternalOfferReportingDetails zzb;

    public CreateExternalOfferReportingDetailsResult(@RecentlyNonNull BillingResult billingResult0, @Nullable ExternalOfferReportingDetails externalOfferReportingDetails0) {
        q.g(billingResult0, "billingResult");
        super();
        this.zza = billingResult0;
        this.zzb = externalOfferReportingDetails0;
    }

    @NotNull
    public final BillingResult component1() {
        return this.zza;
    }

    @RecentlyNullable
    public final ExternalOfferReportingDetails component2() {
        return this.zzb;
    }

    @NotNull
    public final CreateExternalOfferReportingDetailsResult copy(@RecentlyNonNull BillingResult billingResult0, @Nullable ExternalOfferReportingDetails externalOfferReportingDetails0) {
        q.g(billingResult0, "billingResult");
        return new CreateExternalOfferReportingDetailsResult(billingResult0, externalOfferReportingDetails0);
    }

    @RecentlyNonNull
    public static CreateExternalOfferReportingDetailsResult copy$default(@RecentlyNonNull CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull ExternalOfferReportingDetails externalOfferReportingDetails0, int v, @RecentlyNonNull Object object0) {
        if((v & 1) != 0) {
            billingResult0 = createExternalOfferReportingDetailsResult0.zza;
        }
        if((v & 2) != 0) {
            externalOfferReportingDetails0 = createExternalOfferReportingDetailsResult0.zzb;
        }
        return createExternalOfferReportingDetailsResult0.copy(billingResult0, externalOfferReportingDetails0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CreateExternalOfferReportingDetailsResult)) {
            return false;
        }
        return q.b(this.zza, ((CreateExternalOfferReportingDetailsResult)object0).zza) ? q.b(this.zzb, ((CreateExternalOfferReportingDetailsResult)object0).zzb) : false;
    }

    @NotNull
    public final BillingResult getBillingResult() {
        return this.zza;
    }

    @RecentlyNullable
    public final ExternalOfferReportingDetails getExternalOfferReportingDetails() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        int v = this.zza.hashCode();
        return this.zzb == null ? v * 0x1F : v * 0x1F + this.zzb.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "CreateExternalOfferReportingDetailsResult(billingResult=" + this.zza + ", externalOfferReportingDetails=" + this.zzb + ")";
    }
}

