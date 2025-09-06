package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2 = {"Lcom/android/billingclient/api/PurchasesResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "purchasesList", "", "Lcom/android/billingclient/api/Purchase;", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getPurchasesList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class PurchasesResult {
    @NotNull
    private final BillingResult zza;
    @NotNull
    private final List zzb;

    public PurchasesResult(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        q.g(billingResult0, "billingResult");
        q.g(list0, "purchasesList");
        super();
        this.zza = billingResult0;
        this.zzb = list0;
    }

    @NotNull
    public final BillingResult component1() {
        return this.zza;
    }

    @NotNull
    public final List component2() {
        return this.zzb;
    }

    @NotNull
    public final PurchasesResult copy(@RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) {
        q.g(billingResult0, "billingResult");
        q.g(list0, "purchasesList");
        return new PurchasesResult(billingResult0, list0);
    }

    @RecentlyNonNull
    public static PurchasesResult copy$default(@RecentlyNonNull PurchasesResult purchasesResult0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0, int v, @RecentlyNonNull Object object0) {
        if((v & 1) != 0) {
            billingResult0 = purchasesResult0.zza;
        }
        if((v & 2) != 0) {
            list0 = purchasesResult0.zzb;
        }
        return purchasesResult0.copy(billingResult0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PurchasesResult)) {
            return false;
        }
        return q.b(this.zza, ((PurchasesResult)object0).zza) ? q.b(this.zzb, ((PurchasesResult)object0).zzb) : false;
    }

    @NotNull
    public final BillingResult getBillingResult() {
        return this.zza;
    }

    @NotNull
    public final List getPurchasesList() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return this.zzb.hashCode() + this.zza.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PurchasesResult(billingResult=");
        stringBuilder0.append(this.zza);
        stringBuilder0.append(", purchasesList=");
        return Y.m(stringBuilder0, this.zzb, ")");
    }
}

