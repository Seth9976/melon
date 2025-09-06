package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "alternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;", "(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V", "getAlternativeBillingOnlyReportingDetails", "()Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CreateAlternativeBillingOnlyReportingDetailsResult {
    @NotNull
    private final BillingResult zza;
    @Nullable
    private final AlternativeBillingOnlyReportingDetails zzb;

    public CreateAlternativeBillingOnlyReportingDetailsResult(@RecentlyNonNull BillingResult billingResult0, @Nullable AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0) {
        q.g(billingResult0, "billingResult");
        super();
        this.zza = billingResult0;
        this.zzb = alternativeBillingOnlyReportingDetails0;
    }

    @NotNull
    public final BillingResult component1() {
        return this.zza;
    }

    @RecentlyNullable
    public final AlternativeBillingOnlyReportingDetails component2() {
        return this.zzb;
    }

    @NotNull
    public final CreateAlternativeBillingOnlyReportingDetailsResult copy(@RecentlyNonNull BillingResult billingResult0, @Nullable AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0) {
        q.g(billingResult0, "billingResult");
        return new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult0, alternativeBillingOnlyReportingDetails0);
    }

    @RecentlyNonNull
    public static CreateAlternativeBillingOnlyReportingDetailsResult copy$default(@RecentlyNonNull CreateAlternativeBillingOnlyReportingDetailsResult createAlternativeBillingOnlyReportingDetailsResult0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0, int v, @RecentlyNonNull Object object0) {
        if((v & 1) != 0) {
            billingResult0 = createAlternativeBillingOnlyReportingDetailsResult0.zza;
        }
        if((v & 2) != 0) {
            alternativeBillingOnlyReportingDetails0 = createAlternativeBillingOnlyReportingDetailsResult0.zzb;
        }
        return createAlternativeBillingOnlyReportingDetailsResult0.copy(billingResult0, alternativeBillingOnlyReportingDetails0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CreateAlternativeBillingOnlyReportingDetailsResult)) {
            return false;
        }
        return q.b(this.zza, ((CreateAlternativeBillingOnlyReportingDetailsResult)object0).zza) ? q.b(this.zzb, ((CreateAlternativeBillingOnlyReportingDetailsResult)object0).zzb) : false;
    }

    @RecentlyNullable
    public final AlternativeBillingOnlyReportingDetails getAlternativeBillingOnlyReportingDetails() {
        return this.zzb;
    }

    @NotNull
    public final BillingResult getBillingResult() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        int v = this.zza.hashCode();
        return this.zzb == null ? v * 0x1F : v * 0x1F + this.zzb.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "CreateAlternativeBillingOnlyReportingDetailsResult(billingResult=" + this.zza + ", alternativeBillingOnlyReportingDetails=" + this.zzb + ")";
    }
}

