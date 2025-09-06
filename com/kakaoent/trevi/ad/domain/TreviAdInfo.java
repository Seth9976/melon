package com.kakaoent.trevi.ad.domain;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0002\u0010\u000BJ\u000B\u0010\u0015\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u0017\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010\u0018\u001A\u00020\u0007H\u00C6\u0003J\u000B\u0010\u0019\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J[\u0010\u001C\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010 \u001A\u00020\u0007H\u00D6\u0001J\t\u0010!\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\b\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\r\u00A8\u0006\""}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviAdInfo;", "", "dspCampaignId", "", "dspAdId", "dspContentId", "priority", "", "contentSeq", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentSeq", "()Ljava/lang/String;", "getDspAdId", "getDspCampaignId", "getDspContentId", "getEndDate", "getPriority", "()I", "getStartDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAdInfo {
    @Nullable
    private final String contentSeq;
    @Nullable
    private final String dspAdId;
    @Nullable
    private final String dspCampaignId;
    @Nullable
    private final String dspContentId;
    @Nullable
    private final String endDate;
    private final int priority;
    @Nullable
    private final String startDate;

    public TreviAdInfo() {
        this(null, null, null, 0, null, null, null, 0x7F, null);
    }

    public TreviAdInfo(@Nullable String s, @Nullable String s1, @Nullable String s2, int v, @Nullable String s3, @Nullable String s4, @Nullable String s5) {
        this.dspCampaignId = s;
        this.dspAdId = s1;
        this.dspContentId = s2;
        this.priority = v;
        this.contentSeq = s3;
        this.startDate = s4;
        this.endDate = s5;
    }

    public TreviAdInfo(String s, String s1, String s2, int v, String s3, String s4, String s5, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = null;
        }
        if((v1 & 2) != 0) {
            s1 = null;
        }
        if((v1 & 4) != 0) {
            s2 = null;
        }
        if((v1 & 8) != 0) {
            v = 0;
        }
        if((v1 & 16) != 0) {
            s3 = null;
        }
        if((v1 & 0x20) != 0) {
            s4 = null;
        }
        this(s, s1, s2, v, s3, s4, ((v1 & 0x40) == 0 ? s5 : null));
    }

    @Nullable
    public final String component1() {
        return this.dspCampaignId;
    }

    @Nullable
    public final String component2() {
        return this.dspAdId;
    }

    @Nullable
    public final String component3() {
        return this.dspContentId;
    }

    public final int component4() {
        return this.priority;
    }

    @Nullable
    public final String component5() {
        return this.contentSeq;
    }

    @Nullable
    public final String component6() {
        return this.startDate;
    }

    @Nullable
    public final String component7() {
        return this.endDate;
    }

    @NotNull
    public final TreviAdInfo copy(@Nullable String s, @Nullable String s1, @Nullable String s2, int v, @Nullable String s3, @Nullable String s4, @Nullable String s5) {
        return new TreviAdInfo(s, s1, s2, v, s3, s4, s5);
    }

    public static TreviAdInfo copy$default(TreviAdInfo treviAdInfo0, String s, String s1, String s2, int v, String s3, String s4, String s5, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = treviAdInfo0.dspCampaignId;
        }
        if((v1 & 2) != 0) {
            s1 = treviAdInfo0.dspAdId;
        }
        if((v1 & 4) != 0) {
            s2 = treviAdInfo0.dspContentId;
        }
        if((v1 & 8) != 0) {
            v = treviAdInfo0.priority;
        }
        if((v1 & 16) != 0) {
            s3 = treviAdInfo0.contentSeq;
        }
        if((v1 & 0x20) != 0) {
            s4 = treviAdInfo0.startDate;
        }
        if((v1 & 0x40) != 0) {
            s5 = treviAdInfo0.endDate;
        }
        return treviAdInfo0.copy(s, s1, s2, v, s3, s4, s5);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviAdInfo)) {
            return false;
        }
        if(!q.b(this.dspCampaignId, ((TreviAdInfo)object0).dspCampaignId)) {
            return false;
        }
        if(!q.b(this.dspAdId, ((TreviAdInfo)object0).dspAdId)) {
            return false;
        }
        if(!q.b(this.dspContentId, ((TreviAdInfo)object0).dspContentId)) {
            return false;
        }
        if(this.priority != ((TreviAdInfo)object0).priority) {
            return false;
        }
        if(!q.b(this.contentSeq, ((TreviAdInfo)object0).contentSeq)) {
            return false;
        }
        return q.b(this.startDate, ((TreviAdInfo)object0).startDate) ? q.b(this.endDate, ((TreviAdInfo)object0).endDate) : false;
    }

    @Nullable
    public final String getContentSeq() {
        return this.contentSeq;
    }

    @Nullable
    public final String getDspAdId() {
        return this.dspAdId;
    }

    @Nullable
    public final String getDspCampaignId() {
        return this.dspCampaignId;
    }

    @Nullable
    public final String getDspContentId() {
        return this.dspContentId;
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Nullable
    public final String getStartDate() {
        return this.startDate;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.b(this.priority, (((this.dspCampaignId == null ? 0 : this.dspCampaignId.hashCode()) * 0x1F + (this.dspAdId == null ? 0 : this.dspAdId.hashCode())) * 0x1F + (this.dspContentId == null ? 0 : this.dspContentId.hashCode())) * 0x1F, 0x1F);
        int v2 = this.contentSeq == null ? 0 : this.contentSeq.hashCode();
        int v3 = this.startDate == null ? 0 : this.startDate.hashCode();
        String s = this.endDate;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TreviAdInfo(dspCampaignId=");
        stringBuilder0.append(this.dspCampaignId);
        stringBuilder0.append(", dspAdId=");
        stringBuilder0.append(this.dspAdId);
        stringBuilder0.append(", dspContentId=");
        stringBuilder0.append(this.dspContentId);
        stringBuilder0.append(", priority=");
        stringBuilder0.append(this.priority);
        stringBuilder0.append(", contentSeq=");
        stringBuilder0.append(this.contentSeq);
        stringBuilder0.append(", startDate=");
        stringBuilder0.append(this.startDate);
        stringBuilder0.append(", endDate=");
        return o.r(stringBuilder0, this.endDate, ')');
    }
}

