package com.android.billingclient.api;

import U4.x;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/billingclient/api/ConsumeResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "purchaseToken", "", "(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getPurchaseToken", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ConsumeResult {
    @NotNull
    private final BillingResult zza;
    @Nullable
    private final String zzb;

    public ConsumeResult(@RecentlyNonNull BillingResult billingResult0, @Nullable String s) {
        q.g(billingResult0, "billingResult");
        super();
        this.zza = billingResult0;
        this.zzb = s;
    }

    @NotNull
    public final BillingResult component1() {
        return this.zza;
    }

    @RecentlyNullable
    public final String component2() {
        return this.zzb;
    }

    @NotNull
    public final ConsumeResult copy(@RecentlyNonNull BillingResult billingResult0, @Nullable String s) {
        q.g(billingResult0, "billingResult");
        return new ConsumeResult(billingResult0, s);
    }

    @RecentlyNonNull
    public static ConsumeResult copy$default(@RecentlyNonNull ConsumeResult consumeResult0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull String s, int v, @RecentlyNonNull Object object0) {
        if((v & 1) != 0) {
            billingResult0 = consumeResult0.zza;
        }
        if((v & 2) != 0) {
            s = consumeResult0.zzb;
        }
        return consumeResult0.copy(billingResult0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ConsumeResult)) {
            return false;
        }
        return q.b(this.zza, ((ConsumeResult)object0).zza) ? q.b(this.zzb, ((ConsumeResult)object0).zzb) : false;
    }

    @NotNull
    public final BillingResult getBillingResult() {
        return this.zza;
    }

    @RecentlyNullable
    public final String getPurchaseToken() {
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
        StringBuilder stringBuilder0 = new StringBuilder("ConsumeResult(billingResult=");
        stringBuilder0.append(this.zza);
        stringBuilder0.append(", purchaseToken=");
        return x.m(stringBuilder0, this.zzb, ")");
    }
}

