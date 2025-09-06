package com.kakaoent.trevi.ad.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000B\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/ApplyResult;", "", "dspId", "", "dspCampaignId", "", "dspAdId", "dspContentId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDspAdId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDspCampaignId", "getDspContentId", "getDspId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakaoent/trevi/ad/domain/ApplyResult;", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ApplyResult {
    @Nullable
    private final Integer dspAdId;
    @Nullable
    private final Integer dspCampaignId;
    @Nullable
    private final Integer dspContentId;
    @Nullable
    private final String dspId;

    public ApplyResult() {
        this(null, null, null, null, 15, null);
    }

    public ApplyResult(@Nullable String s, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        this.dspId = s;
        this.dspCampaignId = integer0;
        this.dspAdId = integer1;
        this.dspContentId = integer2;
    }

    public ApplyResult(String s, Integer integer0, Integer integer1, Integer integer2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            integer0 = 0;
        }
        if((v & 4) != 0) {
            integer1 = 0;
        }
        if((v & 8) != 0) {
            integer2 = 0;
        }
        this(s, integer0, integer1, integer2);
    }

    @Nullable
    public final String component1() {
        return this.dspId;
    }

    @Nullable
    public final Integer component2() {
        return this.dspCampaignId;
    }

    @Nullable
    public final Integer component3() {
        return this.dspAdId;
    }

    @Nullable
    public final Integer component4() {
        return this.dspContentId;
    }

    @NotNull
    public final ApplyResult copy(@Nullable String s, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        return new ApplyResult(s, integer0, integer1, integer2);
    }

    public static ApplyResult copy$default(ApplyResult applyResult0, String s, Integer integer0, Integer integer1, Integer integer2, int v, Object object0) {
        if((v & 1) != 0) {
            s = applyResult0.dspId;
        }
        if((v & 2) != 0) {
            integer0 = applyResult0.dspCampaignId;
        }
        if((v & 4) != 0) {
            integer1 = applyResult0.dspAdId;
        }
        if((v & 8) != 0) {
            integer2 = applyResult0.dspContentId;
        }
        return applyResult0.copy(s, integer0, integer1, integer2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ApplyResult)) {
            return false;
        }
        if(!q.b(this.dspId, ((ApplyResult)object0).dspId)) {
            return false;
        }
        if(!q.b(this.dspCampaignId, ((ApplyResult)object0).dspCampaignId)) {
            return false;
        }
        return q.b(this.dspAdId, ((ApplyResult)object0).dspAdId) ? q.b(this.dspContentId, ((ApplyResult)object0).dspContentId) : false;
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
        int v1 = this.dspId == null ? 0 : this.dspId.hashCode();
        int v2 = this.dspCampaignId == null ? 0 : this.dspCampaignId.hashCode();
        int v3 = this.dspAdId == null ? 0 : this.dspAdId.hashCode();
        Integer integer0 = this.dspContentId;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "ApplyResult(dspId=" + this.dspId + ", dspCampaignId=" + this.dspCampaignId + ", dspAdId=" + this.dspAdId + ", dspContentId=" + this.dspContentId + ')';
    }
}

