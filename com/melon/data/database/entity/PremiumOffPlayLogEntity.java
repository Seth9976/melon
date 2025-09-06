package com.melon.data.database.entity;

import A7.d;
import H0.b;
import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B]\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u00A2\u0006\u0004\b\u000F\u0010\u0010B\t\b\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0011J\t\u0010,\u001A\u00020\u0003H\u00C6\u0003J\t\u0010-\u001A\u00020\u0005H\u00C6\u0003J\t\u0010.\u001A\u00020\u0005H\u00C6\u0003J\t\u0010/\u001A\u00020\u0005H\u00C6\u0003J\t\u00100\u001A\u00020\u0005H\u00C6\u0003J\t\u00101\u001A\u00020\u0005H\u00C6\u0003J\t\u00102\u001A\u00020\u0005H\u00C6\u0003J\t\u00103\u001A\u00020\u0005H\u00C6\u0003J\t\u00104\u001A\u00020\u0005H\u00C6\u0003J\t\u00105\u001A\u00020\u000EH\u00C6\u0003Jm\u00106\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u000EH\u00C6\u0001J\u0013\u00107\u001A\u0002082\b\u00109\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010:\u001A\u00020\u0003H\u00D6\u0001J\t\u0010;\u001A\u00020\u0005H\u00D6\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001E\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0017\"\u0004\b\u001B\u0010\u0019R\u001E\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0017\"\u0004\b\u001D\u0010\u0019R\u001E\u0010\b\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0017\"\u0004\b\u001F\u0010\u0019R\u001E\u0010\t\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001E\u0010\u000B\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001E\u0010\f\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0017\"\u0004\b\'\u0010\u0019R\u001E\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+\u00A8\u0006<"}, d2 = {"Lcom/melon/data/database/entity/PremiumOffPlayLogEntity;", "", "uid", "", "cId", "", "cType", "psTime", "metaType", "bitrate", "bInfo", "freeYn", "memberKey", "timestamp", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "()V", "getUid", "()I", "setUid", "(I)V", "getCId", "()Ljava/lang/String;", "setCId", "(Ljava/lang/String;)V", "getCType", "setCType", "getPsTime", "setPsTime", "getMetaType", "setMetaType", "getBitrate", "setBitrate", "getBInfo", "setBInfo", "getFreeYn", "setFreeYn", "getMemberKey", "setMemberKey", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PremiumOffPlayLogEntity {
    public static final int $stable = 8;
    @NotNull
    private String bInfo;
    @NotNull
    private String bitrate;
    @NotNull
    private String cId;
    @NotNull
    private String cType;
    @NotNull
    private String freeYn;
    @NotNull
    private String memberKey;
    @NotNull
    private String metaType;
    @NotNull
    private String psTime;
    private long timestamp;
    private int uid;

    public PremiumOffPlayLogEntity() {
        this(0, "", "", "", "", "", "", "N", "", 0L);
    }

    public PremiumOffPlayLogEntity(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, long v1) {
        q.g(s, "cId");
        q.g(s1, "cType");
        q.g(s2, "psTime");
        q.g(s3, "metaType");
        q.g(s4, "bitrate");
        q.g(s5, "bInfo");
        q.g(s6, "freeYn");
        q.g(s7, "memberKey");
        super();
        this.uid = v;
        this.cId = s;
        this.cType = s1;
        this.psTime = s2;
        this.metaType = s3;
        this.bitrate = s4;
        this.bInfo = s5;
        this.freeYn = s6;
        this.memberKey = s7;
        this.timestamp = v1;
    }

    public PremiumOffPlayLogEntity(int v, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, long v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, s, s1, s2, s3, s4, s5, ((v2 & 0x80) == 0 ? s6 : "N"), s7, ((v2 & 0x200) == 0 ? v1 : 0L));
    }

    public final int component1() {
        return this.uid;
    }

    public final long component10() {
        return this.timestamp;
    }

    @NotNull
    public final String component2() {
        return this.cId;
    }

    @NotNull
    public final String component3() {
        return this.cType;
    }

    @NotNull
    public final String component4() {
        return this.psTime;
    }

    @NotNull
    public final String component5() {
        return this.metaType;
    }

    @NotNull
    public final String component6() {
        return this.bitrate;
    }

    @NotNull
    public final String component7() {
        return this.bInfo;
    }

    @NotNull
    public final String component8() {
        return this.freeYn;
    }

    @NotNull
    public final String component9() {
        return this.memberKey;
    }

    @NotNull
    public final PremiumOffPlayLogEntity copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, long v1) {
        q.g(s, "cId");
        q.g(s1, "cType");
        q.g(s2, "psTime");
        q.g(s3, "metaType");
        q.g(s4, "bitrate");
        q.g(s5, "bInfo");
        q.g(s6, "freeYn");
        q.g(s7, "memberKey");
        return new PremiumOffPlayLogEntity(v, s, s1, s2, s3, s4, s5, s6, s7, v1);
    }

    public static PremiumOffPlayLogEntity copy$default(PremiumOffPlayLogEntity premiumOffPlayLogEntity0, int v, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = premiumOffPlayLogEntity0.uid;
        }
        if((v2 & 2) != 0) {
            s = premiumOffPlayLogEntity0.cId;
        }
        if((v2 & 4) != 0) {
            s1 = premiumOffPlayLogEntity0.cType;
        }
        if((v2 & 8) != 0) {
            s2 = premiumOffPlayLogEntity0.psTime;
        }
        if((v2 & 16) != 0) {
            s3 = premiumOffPlayLogEntity0.metaType;
        }
        if((v2 & 0x20) != 0) {
            s4 = premiumOffPlayLogEntity0.bitrate;
        }
        if((v2 & 0x40) != 0) {
            s5 = premiumOffPlayLogEntity0.bInfo;
        }
        if((v2 & 0x80) != 0) {
            s6 = premiumOffPlayLogEntity0.freeYn;
        }
        if((v2 & 0x100) != 0) {
            s7 = premiumOffPlayLogEntity0.memberKey;
        }
        if((v2 & 0x200) != 0) {
            v1 = premiumOffPlayLogEntity0.timestamp;
        }
        return premiumOffPlayLogEntity0.copy(v, s, s1, s2, s3, s4, s5, s6, s7, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PremiumOffPlayLogEntity)) {
            return false;
        }
        if(this.uid != ((PremiumOffPlayLogEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.cId, ((PremiumOffPlayLogEntity)object0).cId)) {
            return false;
        }
        if(!q.b(this.cType, ((PremiumOffPlayLogEntity)object0).cType)) {
            return false;
        }
        if(!q.b(this.psTime, ((PremiumOffPlayLogEntity)object0).psTime)) {
            return false;
        }
        if(!q.b(this.metaType, ((PremiumOffPlayLogEntity)object0).metaType)) {
            return false;
        }
        if(!q.b(this.bitrate, ((PremiumOffPlayLogEntity)object0).bitrate)) {
            return false;
        }
        if(!q.b(this.bInfo, ((PremiumOffPlayLogEntity)object0).bInfo)) {
            return false;
        }
        if(!q.b(this.freeYn, ((PremiumOffPlayLogEntity)object0).freeYn)) {
            return false;
        }
        return q.b(this.memberKey, ((PremiumOffPlayLogEntity)object0).memberKey) ? this.timestamp == ((PremiumOffPlayLogEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getBInfo() [...] // 潜在的解密器

    @NotNull
    public final String getBitrate() [...] // 潜在的解密器

    @NotNull
    public final String getCId() [...] // 潜在的解密器

    @NotNull
    public final String getCType() [...] // 潜在的解密器

    @NotNull
    public final String getFreeYn() [...] // 潜在的解密器

    @NotNull
    public final String getMemberKey() [...] // 潜在的解密器

    @NotNull
    public final String getMetaType() [...] // 潜在的解密器

    @NotNull
    public final String getPsTime() [...] // 潜在的解密器

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.uid * 0x1F, 0x1F, this.cId), 0x1F, this.cType), 0x1F, this.psTime), 0x1F, this.metaType), 0x1F, this.bitrate), 0x1F, this.bInfo), 0x1F, this.freeYn), 0x1F, this.memberKey);
    }

    public final void setBInfo(@NotNull String s) {
        q.g(s, "<set-?>");
        this.bInfo = s;
    }

    public final void setBitrate(@NotNull String s) {
        q.g(s, "<set-?>");
        this.bitrate = s;
    }

    public final void setCId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cId = s;
    }

    public final void setCType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cType = s;
    }

    public final void setFreeYn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.freeYn = s;
    }

    public final void setMemberKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.memberKey = s;
    }

    public final void setMetaType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.metaType = s;
    }

    public final void setPsTime(@NotNull String s) {
        q.g(s, "<set-?>");
        this.psTime = s;
    }

    public final void setTimestamp(long v) {
        this.timestamp = v;
    }

    public final void setUid(int v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.cType;
        String s1 = this.psTime;
        String s2 = this.metaType;
        String s3 = this.bitrate;
        String s4 = this.bInfo;
        String s5 = this.freeYn;
        String s6 = this.memberKey;
        long v = this.timestamp;
        StringBuilder stringBuilder0 = x.o(this.uid, "PremiumOffPlayLogEntity(uid=", ", cId=", this.cId, ", cType=");
        d.u(stringBuilder0, s, ", psTime=", s1, ", metaType=");
        d.u(stringBuilder0, s2, ", bitrate=", s3, ", bInfo=");
        d.u(stringBuilder0, s4, ", freeYn=", s5, ", memberKey=");
        b.t(v, s6, ", timestamp=", stringBuilder0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

