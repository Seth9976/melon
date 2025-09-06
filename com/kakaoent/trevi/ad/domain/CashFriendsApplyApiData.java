package com.kakaoent.trevi.ad.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u00AD\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u00A2\u0006\u0002\u0010\u0013J\u000B\u0010&\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\'\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010(\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010)\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010*\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010+\u001A\u0004\u0018\u00010\u0012H\u00C6\u0003J\u0010\u0010,\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0002\u0010!J\u000B\u0010-\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010.\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010/\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00100\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00101\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00102\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u0010\u00103\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0002\u0010!J\u00B6\u0001\u00104\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u00C6\u0001\u00A2\u0006\u0002\u00105J\u0013\u00106\u001A\u0002072\b\u00108\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u00109\u001A\u00020\u0005H\u00D6\u0001J\t\u0010:\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0017R\u0013\u0010\t\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0017R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0017R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0017R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0017R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0017R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0017R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0017R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\n\n\u0002\u0010\"\u001A\u0004\b \u0010!R\u0015\u0010\f\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\n\n\u0002\u0010\"\u001A\u0004\b#\u0010!R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0017R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010\u0017\u00A8\u0006;"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/CashFriendsApplyApiData;", "", "finalUrl", "", "resultCode", "", "message", "responseTime", "appPackage", "endDate", "applyId", "expDate", "rewardAmount", "rewardUnit", "popupUrl", "orientation", "videoUrl", "apiResult", "Lcom/kakaoent/trevi/ad/domain/ApplyResult;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/kakaoent/trevi/ad/domain/ApplyResult;)V", "getApiResult", "()Lcom/kakaoent/trevi/ad/domain/ApplyResult;", "getAppPackage", "()Ljava/lang/String;", "getApplyId", "getEndDate", "getExpDate", "getFinalUrl", "getMessage", "getOrientation", "getPopupUrl", "getResponseTime", "getResultCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRewardAmount", "getRewardUnit", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/kakaoent/trevi/ad/domain/ApplyResult;)Lcom/kakaoent/trevi/ad/domain/CashFriendsApplyApiData;", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsApplyApiData {
    @Nullable
    private final ApplyResult apiResult;
    @Nullable
    private final String appPackage;
    @Nullable
    private final String applyId;
    @Nullable
    private final String endDate;
    @Nullable
    private final String expDate;
    @Nullable
    private final String finalUrl;
    @Nullable
    private final String message;
    @Nullable
    private final String orientation;
    @Nullable
    private final String popupUrl;
    @Nullable
    private final String responseTime;
    @Nullable
    private final Integer resultCode;
    @Nullable
    private final Integer rewardAmount;
    @Nullable
    private final String rewardUnit;
    @Nullable
    private final String videoUrl;

    public CashFriendsApplyApiData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0x3FFF, null);
    }

    public CashFriendsApplyApiData(@Nullable String s, @Nullable Integer integer0, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable Integer integer1, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable ApplyResult applyResult0) {
        this.finalUrl = s;
        this.resultCode = integer0;
        this.message = s1;
        this.responseTime = s2;
        this.appPackage = s3;
        this.endDate = s4;
        this.applyId = s5;
        this.expDate = s6;
        this.rewardAmount = integer1;
        this.rewardUnit = s7;
        this.popupUrl = s8;
        this.orientation = s9;
        this.videoUrl = s10;
        this.apiResult = applyResult0;
    }

    public CashFriendsApplyApiData(String s, Integer integer0, String s1, String s2, String s3, String s4, String s5, String s6, Integer integer1, String s7, String s8, String s9, String s10, ApplyResult applyResult0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        Integer integer2 = 0;
        Integer integer3 = (v & 2) == 0 ? integer0 : 0;
        if((v & 0x100) == 0) {
            integer2 = integer1;
        }
        this(((v & 1) == 0 ? s : null), integer3, ((v & 4) == 0 ? s1 : null), ((v & 8) == 0 ? s2 : null), ((v & 16) == 0 ? s3 : null), ((v & 0x20) == 0 ? s4 : null), ((v & 0x40) == 0 ? s5 : null), ((v & 0x80) == 0 ? s6 : null), integer2, ((v & 0x200) == 0 ? s7 : null), ((v & 0x400) == 0 ? s8 : null), ((v & 0x800) == 0 ? s9 : null), ((v & 0x1000) == 0 ? s10 : null), ((v & 0x2000) == 0 ? applyResult0 : null));
    }

    @Nullable
    public final String component1() {
        return this.finalUrl;
    }

    @Nullable
    public final String component10() {
        return this.rewardUnit;
    }

    @Nullable
    public final String component11() {
        return this.popupUrl;
    }

    @Nullable
    public final String component12() {
        return this.orientation;
    }

    @Nullable
    public final String component13() {
        return this.videoUrl;
    }

    @Nullable
    public final ApplyResult component14() {
        return this.apiResult;
    }

    @Nullable
    public final Integer component2() {
        return this.resultCode;
    }

    @Nullable
    public final String component3() {
        return this.message;
    }

    @Nullable
    public final String component4() {
        return this.responseTime;
    }

    @Nullable
    public final String component5() {
        return this.appPackage;
    }

    @Nullable
    public final String component6() {
        return this.endDate;
    }

    @Nullable
    public final String component7() {
        return this.applyId;
    }

    @Nullable
    public final String component8() {
        return this.expDate;
    }

    @Nullable
    public final Integer component9() {
        return this.rewardAmount;
    }

    @NotNull
    public final CashFriendsApplyApiData copy(@Nullable String s, @Nullable Integer integer0, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable Integer integer1, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable ApplyResult applyResult0) {
        return new CashFriendsApplyApiData(s, integer0, s1, s2, s3, s4, s5, s6, integer1, s7, s8, s9, s10, applyResult0);
    }

    public static CashFriendsApplyApiData copy$default(CashFriendsApplyApiData cashFriendsApplyApiData0, String s, Integer integer0, String s1, String s2, String s3, String s4, String s5, String s6, Integer integer1, String s7, String s8, String s9, String s10, ApplyResult applyResult0, int v, Object object0) {
        String s11 = (v & 1) == 0 ? s : cashFriendsApplyApiData0.finalUrl;
        Integer integer2 = (v & 2) == 0 ? integer0 : cashFriendsApplyApiData0.resultCode;
        String s12 = (v & 4) == 0 ? s1 : cashFriendsApplyApiData0.message;
        String s13 = (v & 8) == 0 ? s2 : cashFriendsApplyApiData0.responseTime;
        String s14 = (v & 16) == 0 ? s3 : cashFriendsApplyApiData0.appPackage;
        String s15 = (v & 0x20) == 0 ? s4 : cashFriendsApplyApiData0.endDate;
        String s16 = (v & 0x40) == 0 ? s5 : cashFriendsApplyApiData0.applyId;
        String s17 = (v & 0x80) == 0 ? s6 : cashFriendsApplyApiData0.expDate;
        Integer integer3 = (v & 0x100) == 0 ? integer1 : cashFriendsApplyApiData0.rewardAmount;
        String s18 = (v & 0x200) == 0 ? s7 : cashFriendsApplyApiData0.rewardUnit;
        String s19 = (v & 0x400) == 0 ? s8 : cashFriendsApplyApiData0.popupUrl;
        String s20 = (v & 0x800) == 0 ? s9 : cashFriendsApplyApiData0.orientation;
        String s21 = (v & 0x1000) == 0 ? s10 : cashFriendsApplyApiData0.videoUrl;
        return (v & 0x2000) == 0 ? cashFriendsApplyApiData0.copy(s11, integer2, s12, s13, s14, s15, s16, s17, integer3, s18, s19, s20, s21, applyResult0) : cashFriendsApplyApiData0.copy(s11, integer2, s12, s13, s14, s15, s16, s17, integer3, s18, s19, s20, s21, cashFriendsApplyApiData0.apiResult);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CashFriendsApplyApiData)) {
            return false;
        }
        if(!q.b(this.finalUrl, ((CashFriendsApplyApiData)object0).finalUrl)) {
            return false;
        }
        if(!q.b(this.resultCode, ((CashFriendsApplyApiData)object0).resultCode)) {
            return false;
        }
        if(!q.b(this.message, ((CashFriendsApplyApiData)object0).message)) {
            return false;
        }
        if(!q.b(this.responseTime, ((CashFriendsApplyApiData)object0).responseTime)) {
            return false;
        }
        if(!q.b(this.appPackage, ((CashFriendsApplyApiData)object0).appPackage)) {
            return false;
        }
        if(!q.b(this.endDate, ((CashFriendsApplyApiData)object0).endDate)) {
            return false;
        }
        if(!q.b(this.applyId, ((CashFriendsApplyApiData)object0).applyId)) {
            return false;
        }
        if(!q.b(this.expDate, ((CashFriendsApplyApiData)object0).expDate)) {
            return false;
        }
        if(!q.b(this.rewardAmount, ((CashFriendsApplyApiData)object0).rewardAmount)) {
            return false;
        }
        if(!q.b(this.rewardUnit, ((CashFriendsApplyApiData)object0).rewardUnit)) {
            return false;
        }
        if(!q.b(this.popupUrl, ((CashFriendsApplyApiData)object0).popupUrl)) {
            return false;
        }
        if(!q.b(this.orientation, ((CashFriendsApplyApiData)object0).orientation)) {
            return false;
        }
        return q.b(this.videoUrl, ((CashFriendsApplyApiData)object0).videoUrl) ? q.b(this.apiResult, ((CashFriendsApplyApiData)object0).apiResult) : false;
    }

    @Nullable
    public final ApplyResult getApiResult() {
        return this.apiResult;
    }

    @Nullable
    public final String getAppPackage() {
        return this.appPackage;
    }

    @Nullable
    public final String getApplyId() {
        return this.applyId;
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final String getExpDate() {
        return this.expDate;
    }

    @Nullable
    public final String getFinalUrl() {
        return this.finalUrl;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getOrientation() {
        return this.orientation;
    }

    @Nullable
    public final String getPopupUrl() {
        return this.popupUrl;
    }

    @Nullable
    public final String getResponseTime() {
        return this.responseTime;
    }

    @Nullable
    public final Integer getResultCode() {
        return this.resultCode;
    }

    @Nullable
    public final Integer getRewardAmount() {
        return this.rewardAmount;
    }

    @Nullable
    public final String getRewardUnit() {
        return this.rewardUnit;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.finalUrl == null ? 0 : this.finalUrl.hashCode();
        int v2 = this.resultCode == null ? 0 : this.resultCode.hashCode();
        int v3 = this.message == null ? 0 : this.message.hashCode();
        int v4 = this.responseTime == null ? 0 : this.responseTime.hashCode();
        int v5 = this.appPackage == null ? 0 : this.appPackage.hashCode();
        int v6 = this.endDate == null ? 0 : this.endDate.hashCode();
        int v7 = this.applyId == null ? 0 : this.applyId.hashCode();
        int v8 = this.expDate == null ? 0 : this.expDate.hashCode();
        int v9 = this.rewardAmount == null ? 0 : this.rewardAmount.hashCode();
        int v10 = this.rewardUnit == null ? 0 : this.rewardUnit.hashCode();
        int v11 = this.popupUrl == null ? 0 : this.popupUrl.hashCode();
        int v12 = this.orientation == null ? 0 : this.orientation.hashCode();
        int v13 = this.videoUrl == null ? 0 : this.videoUrl.hashCode();
        ApplyResult applyResult0 = this.apiResult;
        if(applyResult0 != null) {
            v = applyResult0.hashCode();
        }
        return ((((((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "CashFriendsApplyApiData(finalUrl=" + this.finalUrl + ", resultCode=" + this.resultCode + ", message=" + this.message + ", responseTime=" + this.responseTime + ", appPackage=" + this.appPackage + ", endDate=" + this.endDate + ", applyId=" + this.applyId + ", expDate=" + this.expDate + ", rewardAmount=" + this.rewardAmount + ", rewardUnit=" + this.rewardUnit + ", popupUrl=" + this.popupUrl + ", orientation=" + this.orientation + ", videoUrl=" + this.videoUrl + ", apiResult=" + this.apiResult + ')';
    }
}

