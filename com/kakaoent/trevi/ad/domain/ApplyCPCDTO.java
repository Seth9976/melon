package com.kakaoent.trevi.ad.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u001A\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0002\u0010\fJ\u000B\u0010\u0019\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001D\u001A\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u000BHÆ\u0003¢\u0006\u0002\u0010\u0017JV\u0010\u001F\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001A\u00020\u000B2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\tHÖ\u0001J\t\u0010$\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0015\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/ApplyCPCDTO;", "", "applyId", "", "applyResult", "Lcom/kakaoent/trevi/ad/domain/ApplyResultCPC;", "finalUrl", "message", "resultCode", "", "succeed", "", "(Ljava/lang/String;Lcom/kakaoent/trevi/ad/domain/ApplyResultCPC;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getApplyId", "()Ljava/lang/String;", "getApplyResult", "()Lcom/kakaoent/trevi/ad/domain/ApplyResultCPC;", "getFinalUrl", "getMessage", "getResultCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSucceed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/kakaoent/trevi/ad/domain/ApplyResultCPC;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/kakaoent/trevi/ad/domain/ApplyCPCDTO;", "equals", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ApplyCPCDTO {
    @Nullable
    private final String applyId;
    @Nullable
    private final ApplyResultCPC applyResult;
    @Nullable
    private final String finalUrl;
    @Nullable
    private final String message;
    @Nullable
    private final Integer resultCode;
    @Nullable
    private final Boolean succeed;

    public ApplyCPCDTO() {
        this(null, null, null, null, null, null, 0x3F, null);
    }

    public ApplyCPCDTO(@Nullable String s, @Nullable ApplyResultCPC applyResultCPC0, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable Boolean boolean0) {
        this.applyId = s;
        this.applyResult = applyResultCPC0;
        this.finalUrl = s1;
        this.message = s2;
        this.resultCode = integer0;
        this.succeed = boolean0;
    }

    public ApplyCPCDTO(String s, ApplyResultCPC applyResultCPC0, String s1, String s2, Integer integer0, Boolean boolean0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            applyResultCPC0 = null;
        }
        if((v & 4) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            s2 = null;
        }
        if((v & 16) != 0) {
            integer0 = null;
        }
        this(s, applyResultCPC0, s1, s2, integer0, ((v & 0x20) == 0 ? boolean0 : null));
    }

    @Nullable
    public final String component1() {
        return this.applyId;
    }

    @Nullable
    public final ApplyResultCPC component2() {
        return this.applyResult;
    }

    @Nullable
    public final String component3() {
        return this.finalUrl;
    }

    @Nullable
    public final String component4() {
        return this.message;
    }

    @Nullable
    public final Integer component5() {
        return this.resultCode;
    }

    @Nullable
    public final Boolean component6() {
        return this.succeed;
    }

    @NotNull
    public final ApplyCPCDTO copy(@Nullable String s, @Nullable ApplyResultCPC applyResultCPC0, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable Boolean boolean0) {
        return new ApplyCPCDTO(s, applyResultCPC0, s1, s2, integer0, boolean0);
    }

    public static ApplyCPCDTO copy$default(ApplyCPCDTO applyCPCDTO0, String s, ApplyResultCPC applyResultCPC0, String s1, String s2, Integer integer0, Boolean boolean0, int v, Object object0) {
        if((v & 1) != 0) {
            s = applyCPCDTO0.applyId;
        }
        if((v & 2) != 0) {
            applyResultCPC0 = applyCPCDTO0.applyResult;
        }
        if((v & 4) != 0) {
            s1 = applyCPCDTO0.finalUrl;
        }
        if((v & 8) != 0) {
            s2 = applyCPCDTO0.message;
        }
        if((v & 16) != 0) {
            integer0 = applyCPCDTO0.resultCode;
        }
        if((v & 0x20) != 0) {
            boolean0 = applyCPCDTO0.succeed;
        }
        return applyCPCDTO0.copy(s, applyResultCPC0, s1, s2, integer0, boolean0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ApplyCPCDTO)) {
            return false;
        }
        if(!q.b(this.applyId, ((ApplyCPCDTO)object0).applyId)) {
            return false;
        }
        if(!q.b(this.applyResult, ((ApplyCPCDTO)object0).applyResult)) {
            return false;
        }
        if(!q.b(this.finalUrl, ((ApplyCPCDTO)object0).finalUrl)) {
            return false;
        }
        if(!q.b(this.message, ((ApplyCPCDTO)object0).message)) {
            return false;
        }
        return q.b(this.resultCode, ((ApplyCPCDTO)object0).resultCode) ? q.b(this.succeed, ((ApplyCPCDTO)object0).succeed) : false;
    }

    @Nullable
    public final String getApplyId() {
        return this.applyId;
    }

    @Nullable
    public final ApplyResultCPC getApplyResult() {
        return this.applyResult;
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
    public final Integer getResultCode() {
        return this.resultCode;
    }

    @Nullable
    public final Boolean getSucceed() {
        return this.succeed;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.applyId == null ? 0 : this.applyId.hashCode();
        int v2 = this.applyResult == null ? 0 : this.applyResult.hashCode();
        int v3 = this.finalUrl == null ? 0 : this.finalUrl.hashCode();
        int v4 = this.message == null ? 0 : this.message.hashCode();
        int v5 = this.resultCode == null ? 0 : this.resultCode.hashCode();
        Boolean boolean0 = this.succeed;
        if(boolean0 != null) {
            v = boolean0.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "ApplyCPCDTO(applyId=" + this.applyId + ", applyResult=" + this.applyResult + ", finalUrl=" + this.finalUrl + ", message=" + this.message + ", resultCode=" + this.resultCode + ", succeed=" + this.succeed + ')';
    }
}

