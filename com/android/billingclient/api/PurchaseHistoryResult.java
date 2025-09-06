package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0010\b\u0002\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2 = {"Lcom/android/billingclient/api/PurchaseHistoryResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "purchaseHistoryRecordList", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getPurchaseHistoryRecordList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class PurchaseHistoryResult {
    @NotNull
    private final BillingResult zza;
    @Nullable
    private final List zzb;

    public PurchaseHistoryResult(@RecentlyNonNull BillingResult billingResult0, @Nullable List list0) {
        q.g(billingResult0, "billingResult");
        super();
        this.zza = billingResult0;
        this.zzb = list0;
    }

    @NotNull
    public final BillingResult component1() {
        return this.zza;
    }

    @RecentlyNullable
    public final List component2() {
        return this.zzb;
    }

    @NotNull
    public final PurchaseHistoryResult copy(@RecentlyNonNull BillingResult billingResult0, @Nullable List list0) {
        q.g(billingResult0, "billingResult");
        return new PurchaseHistoryResult(billingResult0, list0);
    }

    @RecentlyNonNull
    public static PurchaseHistoryResult copy$default(@RecentlyNonNull PurchaseHistoryResult purchaseHistoryResult0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0, int v, @RecentlyNonNull Object object0) {
        if((v & 1) != 0) {
            billingResult0 = purchaseHistoryResult0.zza;
        }
        if((v & 2) != 0) {
            list0 = purchaseHistoryResult0.zzb;
        }
        return purchaseHistoryResult0.copy(billingResult0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PurchaseHistoryResult)) {
            return false;
        }
        return q.b(this.zza, ((PurchaseHistoryResult)object0).zza) ? q.b(this.zzb, ((PurchaseHistoryResult)object0).zzb) : false;
    }

    @NotNull
    public final BillingResult getBillingResult() {
        return this.zza;
    }

    @RecentlyNullable
    public final List getPurchaseHistoryRecordList() {
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
        StringBuilder stringBuilder0 = new StringBuilder("PurchaseHistoryResult(billingResult=");
        stringBuilder0.append(this.zza);
        stringBuilder0.append(", purchaseHistoryRecordList=");
        return Y.m(stringBuilder0, this.zzb, ")");
    }
}

