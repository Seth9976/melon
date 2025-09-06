package com.kakaoent.trevi.ad.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u00032\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/CashFriendsTotalCashApiData;", "", "success", "", "result", "", "(ZJ)V", "getResult", "()J", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsTotalCashApiData {
    private final long result;
    private final boolean success;

    public CashFriendsTotalCashApiData() {
        this(false, 0L, 3, null);
    }

    public CashFriendsTotalCashApiData(boolean z, long v) {
        this.success = z;
        this.result = v;
    }

    public CashFriendsTotalCashApiData(boolean z, long v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            z = false;
        }
        if((v1 & 2) != 0) {
            v = 0L;
        }
        this(z, v);
    }

    public final boolean component1() {
        return this.success;
    }

    public final long component2() {
        return this.result;
    }

    @NotNull
    public final CashFriendsTotalCashApiData copy(boolean z, long v) {
        return new CashFriendsTotalCashApiData(z, v);
    }

    public static CashFriendsTotalCashApiData copy$default(CashFriendsTotalCashApiData cashFriendsTotalCashApiData0, boolean z, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            z = cashFriendsTotalCashApiData0.success;
        }
        if((v1 & 2) != 0) {
            v = cashFriendsTotalCashApiData0.result;
        }
        return cashFriendsTotalCashApiData0.copy(z, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CashFriendsTotalCashApiData)) {
            return false;
        }
        return this.success == ((CashFriendsTotalCashApiData)object0).success ? this.result == ((CashFriendsTotalCashApiData)object0).result : false;
    }

    public final long getResult() {
        return this.result;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.result) + Boolean.hashCode(this.success) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "CashFriendsTotalCashApiData(success=" + this.success + ", result=" + this.result + ')';
    }
}

