package com.kakaoent.trevi.ad.repository.remote.api;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0017\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\b\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000B¨\u0006\u001E"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/api/CpcApply;", "", "clientId", "", "dspContentId", "advId", "ask", "userId", "env", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdvId", "()Ljava/lang/String;", "getAsk", "getClientId", "getDspContentId", "getEnv", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CpcApply {
    @NotNull
    private final String advId;
    @NotNull
    private final String ask;
    @Nullable
    private final String clientId;
    @NotNull
    private final String dspContentId;
    @Nullable
    private final String env;
    @NotNull
    private final String userId;

    public CpcApply(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @Nullable String s5) {
        q.g(s1, "dspContentId");
        q.g(s2, "advId");
        q.g(s3, "ask");
        q.g(s4, "userId");
        super();
        this.clientId = s;
        this.dspContentId = s1;
        this.advId = s2;
        this.ask = s3;
        this.userId = s4;
        this.env = s5;
    }

    public CpcApply(String s, String s1, String s2, String s3, String s4, String s5, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        this(s, s1, s2, s3, s4, ((v & 0x20) == 0 ? s5 : null));
    }

    @Nullable
    public final String component1() {
        return this.clientId;
    }

    @NotNull
    public final String component2() {
        return this.dspContentId;
    }

    @NotNull
    public final String component3() {
        return this.advId;
    }

    @NotNull
    public final String component4() {
        return this.ask;
    }

    @NotNull
    public final String component5() {
        return this.userId;
    }

    @Nullable
    public final String component6() {
        return this.env;
    }

    @NotNull
    public final CpcApply copy(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @Nullable String s5) {
        q.g(s1, "dspContentId");
        q.g(s2, "advId");
        q.g(s3, "ask");
        q.g(s4, "userId");
        return new CpcApply(s, s1, s2, s3, s4, s5);
    }

    public static CpcApply copy$default(CpcApply cpcApply0, String s, String s1, String s2, String s3, String s4, String s5, int v, Object object0) {
        if((v & 1) != 0) {
            s = cpcApply0.clientId;
        }
        if((v & 2) != 0) {
            s1 = cpcApply0.dspContentId;
        }
        if((v & 4) != 0) {
            s2 = cpcApply0.advId;
        }
        if((v & 8) != 0) {
            s3 = cpcApply0.ask;
        }
        if((v & 16) != 0) {
            s4 = cpcApply0.userId;
        }
        if((v & 0x20) != 0) {
            s5 = cpcApply0.env;
        }
        return cpcApply0.copy(s, s1, s2, s3, s4, s5);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CpcApply)) {
            return false;
        }
        if(!q.b(this.clientId, ((CpcApply)object0).clientId)) {
            return false;
        }
        if(!q.b(this.dspContentId, ((CpcApply)object0).dspContentId)) {
            return false;
        }
        if(!q.b(this.advId, ((CpcApply)object0).advId)) {
            return false;
        }
        if(!q.b(this.ask, ((CpcApply)object0).ask)) {
            return false;
        }
        return q.b(this.userId, ((CpcApply)object0).userId) ? q.b(this.env, ((CpcApply)object0).env) : false;
    }

    @NotNull
    public final String getAdvId() {
        return this.advId;
    }

    @NotNull
    public final String getAsk() {
        return this.ask;
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @NotNull
    public final String getDspContentId() {
        return this.dspContentId;
    }

    @Nullable
    public final String getEnv() {
        return this.env;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = x.b(x.b(x.b(x.b((this.clientId == null ? 0 : this.clientId.hashCode()) * 0x1F, 0x1F, this.dspContentId), 0x1F, this.advId), 0x1F, this.ask), 0x1F, this.userId);
        String s = this.env;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CpcApply(clientId=");
        stringBuilder0.append(this.clientId);
        stringBuilder0.append(", dspContentId=");
        stringBuilder0.append(this.dspContentId);
        stringBuilder0.append(", advId=");
        stringBuilder0.append(this.advId);
        stringBuilder0.append(", ask=");
        stringBuilder0.append(this.ask);
        stringBuilder0.append(", userId=");
        stringBuilder0.append(this.userId);
        stringBuilder0.append(", env=");
        return o.r(stringBuilder0, this.env, ')');
    }
}

