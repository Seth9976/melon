package com.kakaoent.trevi.ad.domain;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001B\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000B\u0010\u000B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;", "", "reqId", "", "winPrice", "", "(Ljava/lang/String;I)V", "getReqId", "()Ljava/lang/String;", "getWinPrice", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsCPVTrackApiData {
    @Nullable
    private final String reqId;
    private final int winPrice;

    public CashFriendsCPVTrackApiData() {
        this(null, 0, 3, null);
    }

    public CashFriendsCPVTrackApiData(@Nullable String s, int v) {
        this.reqId = s;
        this.winPrice = v;
    }

    public CashFriendsCPVTrackApiData(String s, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = null;
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        this(s, v);
    }

    @Nullable
    public final String component1() {
        return this.reqId;
    }

    public final int component2() {
        return this.winPrice;
    }

    @NotNull
    public final CashFriendsCPVTrackApiData copy(@Nullable String s, int v) {
        return new CashFriendsCPVTrackApiData(s, v);
    }

    public static CashFriendsCPVTrackApiData copy$default(CashFriendsCPVTrackApiData cashFriendsCPVTrackApiData0, String s, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = cashFriendsCPVTrackApiData0.reqId;
        }
        if((v1 & 2) != 0) {
            v = cashFriendsCPVTrackApiData0.winPrice;
        }
        return cashFriendsCPVTrackApiData0.copy(s, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CashFriendsCPVTrackApiData)) {
            return false;
        }
        return q.b(this.reqId, ((CashFriendsCPVTrackApiData)object0).reqId) ? this.winPrice == ((CashFriendsCPVTrackApiData)object0).winPrice : false;
    }

    @Nullable
    public final String getReqId() {
        return this.reqId;
    }

    public final int getWinPrice() {
        return this.winPrice;
    }

    @Override
    public int hashCode() {
        return this.reqId == null ? this.winPrice : this.winPrice + this.reqId.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CashFriendsCPVTrackApiData(reqId=");
        stringBuilder0.append(this.reqId);
        stringBuilder0.append(", winPrice=");
        return o.q(stringBuilder0, this.winPrice, ')');
    }
}

