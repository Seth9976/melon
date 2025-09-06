package com.kakaoent.trevi.ad.domain;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u00B9\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\u0002\u0010\u0016J\u000B\u0010,\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010-\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010.\u001A\u00020\u0003H\u00C6\u0003J\u000B\u0010/\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00100\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00101\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00102\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00103\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u0010\u00104\u001A\u0004\u0018\u00010\u0015H\u00C6\u0003\u00A2\u0006\u0002\u0010\u001AJ\t\u00105\u001A\u00020\u0003H\u00C6\u0003J\t\u00106\u001A\u00020\u0003H\u00C6\u0003J\t\u00107\u001A\u00020\u0003H\u00C6\u0003J\t\u00108\u001A\u00020\u0003H\u00C6\u0003J\t\u00109\u001A\u00020\tH\u00C6\u0003J\u000B\u0010:\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010;\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010<\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u00CE\u0001\u0010=\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u00C6\u0001\u00A2\u0006\u0002\u0010>J\u0013\u0010?\u001A\u00020@2\b\u0010A\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010B\u001A\u00020\tH\u00D6\u0001J\t\u0010C\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\n\n\u0002\u0010\u001B\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0018R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0018R\u0011\u0010\u0006\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0018R\u0013\u0010\f\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0018R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b \u0010\u0018R\u0011\u0010\u000E\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0018R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0018R\u0011\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0018R\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0018R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010\u0018R\u0013\u0010\u0013\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b&\u0010\u0018R\u0011\u0010\u0005\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u0018R\u0011\u0010\b\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b*\u0010\u0018R\u0011\u0010\u0007\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b+\u0010\u0018\u00A8\u0006D"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviAdRequestData;", "", "clientId", "", "plainIfa", "slotId", "deviceOs", "userInfo_userId", "userInfo_age", "", "userInfo_gender", "deviceModelName", "deviceOsVersion", "deviceId", "network", "inchar", "outchar", "serviceContentType", "serviceContentId", "settlementValue", "connectionTimeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getClientId", "()Ljava/lang/String;", "getConnectionTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeviceId", "getDeviceModelName", "getDeviceOs", "getDeviceOsVersion", "getInchar", "getNetwork", "getOutchar", "getPlainIfa", "getServiceContentId", "getServiceContentType", "getSettlementValue", "getSlotId", "getUserInfo_age", "()I", "getUserInfo_gender", "getUserInfo_userId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/kakaoent/trevi/ad/domain/TreviAdRequestData;", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAdRequestData {
    @Nullable
    private final String clientId;
    @Nullable
    private final Long connectionTimeout;
    @Nullable
    private final String deviceId;
    @Nullable
    private final String deviceModelName;
    @NotNull
    private final String deviceOs;
    @Nullable
    private final String deviceOsVersion;
    @Nullable
    private final String inchar;
    @NotNull
    private final String network;
    @Nullable
    private final String outchar;
    @NotNull
    private final String plainIfa;
    @Nullable
    private final String serviceContentId;
    @Nullable
    private final String serviceContentType;
    @Nullable
    private final String settlementValue;
    @NotNull
    private final String slotId;
    private final int userInfo_age;
    @Nullable
    private final String userInfo_gender;
    @NotNull
    private final String userInfo_userId;

    public TreviAdRequestData(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, int v, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @NotNull String s9, @Nullable String s10, @Nullable String s11, @Nullable String s12, @Nullable String s13, @Nullable String s14, @Nullable Long long0) {
        q.g(s1, "plainIfa");
        q.g(s2, "slotId");
        q.g(s3, "deviceOs");
        q.g(s4, "userInfo_userId");
        q.g(s9, "network");
        super();
        this.clientId = s;
        this.plainIfa = s1;
        this.slotId = s2;
        this.deviceOs = s3;
        this.userInfo_userId = s4;
        this.userInfo_age = v;
        this.userInfo_gender = s5;
        this.deviceModelName = s6;
        this.deviceOsVersion = s7;
        this.deviceId = s8;
        this.network = s9;
        this.inchar = s10;
        this.outchar = s11;
        this.serviceContentType = s12;
        this.serviceContentId = s13;
        this.settlementValue = s14;
        this.connectionTimeout = long0;
    }

    public TreviAdRequestData(String s, String s1, String s2, String s3, String s4, int v, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, Long long0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v1 & 1) == 0 ? s : null), s1, s2, s3, s4, ((v1 & 0x20) == 0 ? v : 0), ((v1 & 0x40) == 0 ? s5 : null), ((v1 & 0x80) == 0 ? s6 : null), ((v1 & 0x100) == 0 ? s7 : null), ((v1 & 0x200) == 0 ? s8 : null), s9, ((v1 & 0x800) == 0 ? s10 : null), ((v1 & 0x1000) == 0 ? s11 : null), ((v1 & 0x2000) == 0 ? s12 : null), ((v1 & 0x4000) == 0 ? s13 : null), ((v1 & 0x8000) == 0 ? s14 : null), long0);
    }

    @Nullable
    public final String component1() {
        return this.clientId;
    }

    @Nullable
    public final String component10() {
        return this.deviceId;
    }

    @NotNull
    public final String component11() {
        return this.network;
    }

    @Nullable
    public final String component12() {
        return this.inchar;
    }

    @Nullable
    public final String component13() {
        return this.outchar;
    }

    @Nullable
    public final String component14() {
        return this.serviceContentType;
    }

    @Nullable
    public final String component15() {
        return this.serviceContentId;
    }

    @Nullable
    public final String component16() {
        return this.settlementValue;
    }

    @Nullable
    public final Long component17() {
        return this.connectionTimeout;
    }

    @NotNull
    public final String component2() {
        return this.plainIfa;
    }

    @NotNull
    public final String component3() {
        return this.slotId;
    }

    @NotNull
    public final String component4() {
        return this.deviceOs;
    }

    @NotNull
    public final String component5() {
        return this.userInfo_userId;
    }

    public final int component6() {
        return this.userInfo_age;
    }

    @Nullable
    public final String component7() {
        return this.userInfo_gender;
    }

    @Nullable
    public final String component8() {
        return this.deviceModelName;
    }

    @Nullable
    public final String component9() {
        return this.deviceOsVersion;
    }

    @NotNull
    public final TreviAdRequestData copy(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, int v, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @NotNull String s9, @Nullable String s10, @Nullable String s11, @Nullable String s12, @Nullable String s13, @Nullable String s14, @Nullable Long long0) {
        q.g(s1, "plainIfa");
        q.g(s2, "slotId");
        q.g(s3, "deviceOs");
        q.g(s4, "userInfo_userId");
        q.g(s9, "network");
        return new TreviAdRequestData(s, s1, s2, s3, s4, v, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, long0);
    }

    public static TreviAdRequestData copy$default(TreviAdRequestData treviAdRequestData0, String s, String s1, String s2, String s3, String s4, int v, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, Long long0, int v1, Object object0) {
        String s15 = (v1 & 1) == 0 ? s : treviAdRequestData0.clientId;
        String s16 = (v1 & 2) == 0 ? s1 : treviAdRequestData0.plainIfa;
        String s17 = (v1 & 4) == 0 ? s2 : treviAdRequestData0.slotId;
        String s18 = (v1 & 8) == 0 ? s3 : treviAdRequestData0.deviceOs;
        String s19 = (v1 & 16) == 0 ? s4 : treviAdRequestData0.userInfo_userId;
        int v2 = (v1 & 0x20) == 0 ? v : treviAdRequestData0.userInfo_age;
        String s20 = (v1 & 0x40) == 0 ? s5 : treviAdRequestData0.userInfo_gender;
        String s21 = (v1 & 0x80) == 0 ? s6 : treviAdRequestData0.deviceModelName;
        String s22 = (v1 & 0x100) == 0 ? s7 : treviAdRequestData0.deviceOsVersion;
        String s23 = (v1 & 0x200) == 0 ? s8 : treviAdRequestData0.deviceId;
        String s24 = (v1 & 0x400) == 0 ? s9 : treviAdRequestData0.network;
        String s25 = (v1 & 0x800) == 0 ? s10 : treviAdRequestData0.inchar;
        String s26 = (v1 & 0x1000) == 0 ? s11 : treviAdRequestData0.outchar;
        String s27 = (v1 & 0x2000) == 0 ? s12 : treviAdRequestData0.serviceContentType;
        String s28 = (v1 & 0x4000) == 0 ? s13 : treviAdRequestData0.serviceContentId;
        String s29 = (v1 & 0x8000) == 0 ? s14 : treviAdRequestData0.settlementValue;
        return (v1 & 0x10000) == 0 ? treviAdRequestData0.copy(s15, s16, s17, s18, s19, v2, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, long0) : treviAdRequestData0.copy(s15, s16, s17, s18, s19, v2, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, treviAdRequestData0.connectionTimeout);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviAdRequestData)) {
            return false;
        }
        if(!q.b(this.clientId, ((TreviAdRequestData)object0).clientId)) {
            return false;
        }
        if(!q.b(this.plainIfa, ((TreviAdRequestData)object0).plainIfa)) {
            return false;
        }
        if(!q.b(this.slotId, ((TreviAdRequestData)object0).slotId)) {
            return false;
        }
        if(!q.b(this.deviceOs, ((TreviAdRequestData)object0).deviceOs)) {
            return false;
        }
        if(!q.b(this.userInfo_userId, ((TreviAdRequestData)object0).userInfo_userId)) {
            return false;
        }
        if(this.userInfo_age != ((TreviAdRequestData)object0).userInfo_age) {
            return false;
        }
        if(!q.b(this.userInfo_gender, ((TreviAdRequestData)object0).userInfo_gender)) {
            return false;
        }
        if(!q.b(this.deviceModelName, ((TreviAdRequestData)object0).deviceModelName)) {
            return false;
        }
        if(!q.b(this.deviceOsVersion, ((TreviAdRequestData)object0).deviceOsVersion)) {
            return false;
        }
        if(!q.b(this.deviceId, ((TreviAdRequestData)object0).deviceId)) {
            return false;
        }
        if(!q.b(this.network, ((TreviAdRequestData)object0).network)) {
            return false;
        }
        if(!q.b(this.inchar, ((TreviAdRequestData)object0).inchar)) {
            return false;
        }
        if(!q.b(this.outchar, ((TreviAdRequestData)object0).outchar)) {
            return false;
        }
        if(!q.b(this.serviceContentType, ((TreviAdRequestData)object0).serviceContentType)) {
            return false;
        }
        if(!q.b(this.serviceContentId, ((TreviAdRequestData)object0).serviceContentId)) {
            return false;
        }
        return q.b(this.settlementValue, ((TreviAdRequestData)object0).settlementValue) ? q.b(this.connectionTimeout, ((TreviAdRequestData)object0).connectionTimeout) : false;
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final Long getConnectionTimeout() {
        return this.connectionTimeout;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final String getDeviceModelName() {
        return this.deviceModelName;
    }

    @NotNull
    public final String getDeviceOs() {
        return this.deviceOs;
    }

    @Nullable
    public final String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    @Nullable
    public final String getInchar() {
        return this.inchar;
    }

    @NotNull
    public final String getNetwork() {
        return this.network;
    }

    @Nullable
    public final String getOutchar() {
        return this.outchar;
    }

    @NotNull
    public final String getPlainIfa() {
        return this.plainIfa;
    }

    @Nullable
    public final String getServiceContentId() {
        return this.serviceContentId;
    }

    @Nullable
    public final String getServiceContentType() {
        return this.serviceContentType;
    }

    @Nullable
    public final String getSettlementValue() {
        return this.settlementValue;
    }

    @NotNull
    public final String getSlotId() {
        return this.slotId;
    }

    public final int getUserInfo_age() {
        return this.userInfo_age;
    }

    @Nullable
    public final String getUserInfo_gender() {
        return this.userInfo_gender;
    }

    @NotNull
    public final String getUserInfo_userId() {
        return this.userInfo_userId;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = x.b(((((d.b(this.userInfo_age, x.b(x.b(x.b(x.b((this.clientId == null ? 0 : this.clientId.hashCode()) * 0x1F, 0x1F, this.plainIfa), 0x1F, this.slotId), 0x1F, this.deviceOs), 0x1F, this.userInfo_userId), 0x1F) + (this.userInfo_gender == null ? 0 : this.userInfo_gender.hashCode())) * 0x1F + (this.deviceModelName == null ? 0 : this.deviceModelName.hashCode())) * 0x1F + (this.deviceOsVersion == null ? 0 : this.deviceOsVersion.hashCode())) * 0x1F + (this.deviceId == null ? 0 : this.deviceId.hashCode())) * 0x1F, 0x1F, this.network);
        int v2 = this.inchar == null ? 0 : this.inchar.hashCode();
        int v3 = this.outchar == null ? 0 : this.outchar.hashCode();
        int v4 = this.serviceContentType == null ? 0 : this.serviceContentType.hashCode();
        int v5 = this.serviceContentId == null ? 0 : this.serviceContentId.hashCode();
        int v6 = this.settlementValue == null ? 0 : this.settlementValue.hashCode();
        Long long0 = this.connectionTimeout;
        if(long0 != null) {
            v = long0.hashCode();
        }
        return (((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "TreviAdRequestData(clientId=" + this.clientId + ", plainIfa=" + this.plainIfa + ", slotId=" + this.slotId + ", deviceOs=" + this.deviceOs + ", userInfo_userId=" + this.userInfo_userId + ", userInfo_age=" + this.userInfo_age + ", userInfo_gender=" + this.userInfo_gender + ", deviceModelName=" + this.deviceModelName + ", deviceOsVersion=" + this.deviceOsVersion + ", deviceId=" + this.deviceId + ", network=" + this.network + ", inchar=" + this.inchar + ", outchar=" + this.outchar + ", serviceContentType=" + this.serviceContentType + ", serviceContentId=" + this.serviceContentId + ", settlementValue=" + this.settlementValue + ", connectionTimeout=" + this.connectionTimeout + ')';
    }
}

