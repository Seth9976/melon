package com.kakaoent.trevi.ad.domain;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0014\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/ApplyResultCPC;", "", "dspAdId", "", "dspCampaignId", "dspContentId", "dspId", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDspAdId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDspCampaignId", "getDspContentId", "getDspId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/kakaoent/trevi/ad/domain/ApplyResultCPC;", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ApplyResultCPC {
    @Nullable
    private final Integer dspAdId;
    @Nullable
    private final Integer dspCampaignId;
    @Nullable
    private final Integer dspContentId;
    @Nullable
    private final String dspId;

    public ApplyResultCPC() {
        this(null, null, null, null, 15, null);
    }

    public ApplyResultCPC(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable String s) {
        this.dspAdId = integer0;
        this.dspCampaignId = integer1;
        this.dspContentId = integer2;
        this.dspId = s;
    }

    public ApplyResultCPC(Integer integer0, Integer integer1, Integer integer2, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            integer0 = null;
        }
        if((v & 2) != 0) {
            integer1 = null;
        }
        if((v & 4) != 0) {
            integer2 = null;
        }
        if((v & 8) != 0) {
            s = null;
        }
        this(integer0, integer1, integer2, s);
    }

    @Nullable
    public final Integer component1() {
        return this.dspAdId;
    }

    @Nullable
    public final Integer component2() {
        return this.dspCampaignId;
    }

    @Nullable
    public final Integer component3() {
        return this.dspContentId;
    }

    @Nullable
    public final String component4() {
        return this.dspId;
    }

    @NotNull
    public final ApplyResultCPC copy(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable String s) {
        return new ApplyResultCPC(integer0, integer1, integer2, s);
    }

    public static ApplyResultCPC copy$default(ApplyResultCPC applyResultCPC0, Integer integer0, Integer integer1, Integer integer2, String s, int v, Object object0) {
        if((v & 1) != 0) {
            integer0 = applyResultCPC0.dspAdId;
        }
        if((v & 2) != 0) {
            integer1 = applyResultCPC0.dspCampaignId;
        }
        if((v & 4) != 0) {
            integer2 = applyResultCPC0.dspContentId;
        }
        if((v & 8) != 0) {
            s = applyResultCPC0.dspId;
        }
        return applyResultCPC0.copy(integer0, integer1, integer2, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ApplyResultCPC)) {
            return false;
        }
        if(!q.b(this.dspAdId, ((ApplyResultCPC)object0).dspAdId)) {
            return false;
        }
        if(!q.b(this.dspCampaignId, ((ApplyResultCPC)object0).dspCampaignId)) {
            return false;
        }
        return q.b(this.dspContentId, ((ApplyResultCPC)object0).dspContentId) ? q.b(this.dspId, ((ApplyResultCPC)object0).dspId) : false;
    }

    @Nullable
    public final Integer getDspAdId() {
        return this.dspAdId;
    }

    @Nullable
    public final Integer getDspCampaignId() {
        return this.dspCampaignId;
    }

    @Nullable
    public final Integer getDspContentId() {
        return this.dspContentId;
    }

    @Nullable
    public final String getDspId() {
        return this.dspId;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.dspAdId == null ? 0 : this.dspAdId.hashCode();
        int v2 = this.dspCampaignId == null ? 0 : this.dspCampaignId.hashCode();
        int v3 = this.dspContentId == null ? 0 : this.dspContentId.hashCode();
        String s = this.dspId;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ApplyResultCPC(dspAdId=");
        stringBuilder0.append(this.dspAdId);
        stringBuilder0.append(", dspCampaignId=");
        stringBuilder0.append(this.dspCampaignId);
        stringBuilder0.append(", dspContentId=");
        stringBuilder0.append(this.dspContentId);
        stringBuilder0.append(", dspId=");
        return o.r(stringBuilder0, this.dspId, ')');
    }
}

