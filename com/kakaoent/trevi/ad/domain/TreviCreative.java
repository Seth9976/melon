package com.kakaoent.trevi.ad.domain;

import A7.d;
import H0.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B\u00B5\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\u001C\b\u0002\u0010\u000E\u001A\u0016\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000F\u0018\u0001`\t\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u0019\u00A2\u0006\u0002\u0010\u001AJ\u000B\u00102\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00103\u001A\u0004\u0018\u00010\u0015H\u00C6\u0003J\u000B\u00104\u001A\u0004\u0018\u00010\u0017H\u00C6\u0003J\t\u00105\u001A\u00020\u0019H\u00C6\u0003J\t\u00106\u001A\u00020\u0005H\u00C6\u0003J\u001D\u00107\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u00C6\u0003J\u000B\u00108\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00109\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010:\u001A\u0004\u0018\u00010\rH\u00C6\u0003J\u001D\u0010;\u001A\u0016\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000F\u0018\u0001`\tH\u00C6\u0003J\u000B\u0010<\u001A\u0004\u0018\u00010\u0011H\u00C6\u0003J\u000B\u0010=\u001A\u0004\u0018\u00010\u0013H\u00C6\u0003J\u00B9\u0001\u0010>\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\u001C\b\u0002\u0010\u000E\u001A\u0016\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000F\u0018\u0001`\t2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u00C6\u0001J\u0013\u0010?\u001A\u00020\u00192\b\u0010@\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010A\u001A\u00020\u0005H\u00D6\u0001J\t\u0010B\u001A\u00020\u0003H\u00D6\u0001R\u001A\u0010\u0018\u001A\u00020\u0019X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u0013\u0010\f\u001A\u0004\u0018\u00010\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u0017\u00A2\u0006\b\n\u0000\u001A\u0004\b#\u0010$R%\u0010\u000E\u001A\u0016\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000F\u0018\u0001`\t\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b)\u0010(R\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b*\u0010+R%\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u00A2\u0006\b\n\u0000\u001A\u0004\b,\u0010&R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b-\u0010(R\u0013\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\b\n\u0000\u001A\u0004\b0\u00101\u00A8\u0006C"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviCreative;", "", "impId", "", "impType", "", "integrationInfos", "Ljava/util/ArrayList;", "Lcom/kakaoent/trevi/ad/domain/IntegrationInfo;", "Lkotlin/collections/ArrayList;", "creativeFormat", "landingUrl", "adInfo", "Lcom/kakaoent/trevi/ad/domain/TreviAdInfo;", "assets", "Lcom/kakaoent/trevi/ad/domain/TreviAsset;", "userInfo", "Lcom/kakaoent/trevi/ad/domain/TreviUserInfo;", "adReward", "Lcom/kakaoent/trevi/ad/domain/TreviAdReward;", "trackers", "Lcom/kakaoent/trevi/ad/domain/TreviTracker;", "apply", "Lcom/kakaoent/trevi/ad/domain/TreviApply;", "_needSendVImp", "", "(Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/kakaoent/trevi/ad/domain/TreviAdInfo;Ljava/util/ArrayList;Lcom/kakaoent/trevi/ad/domain/TreviUserInfo;Lcom/kakaoent/trevi/ad/domain/TreviAdReward;Lcom/kakaoent/trevi/ad/domain/TreviTracker;Lcom/kakaoent/trevi/ad/domain/TreviApply;Z)V", "get_needSendVImp", "()Z", "set_needSendVImp", "(Z)V", "getAdInfo", "()Lcom/kakaoent/trevi/ad/domain/TreviAdInfo;", "getAdReward", "()Lcom/kakaoent/trevi/ad/domain/TreviAdReward;", "getApply", "()Lcom/kakaoent/trevi/ad/domain/TreviApply;", "getAssets", "()Ljava/util/ArrayList;", "getCreativeFormat", "()Ljava/lang/String;", "getImpId", "getImpType", "()I", "getIntegrationInfos", "getLandingUrl", "getTrackers", "()Lcom/kakaoent/trevi/ad/domain/TreviTracker;", "getUserInfo", "()Lcom/kakaoent/trevi/ad/domain/TreviUserInfo;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviCreative {
    private boolean _needSendVImp;
    @Nullable
    private final TreviAdInfo adInfo;
    @Nullable
    private final TreviAdReward adReward;
    @Nullable
    private final TreviApply apply;
    @Nullable
    private final ArrayList assets;
    @Nullable
    private final String creativeFormat;
    @Nullable
    private final String impId;
    private final int impType;
    @Nullable
    private final ArrayList integrationInfos;
    @Nullable
    private final String landingUrl;
    @Nullable
    private final TreviTracker trackers;
    @Nullable
    private final TreviUserInfo userInfo;

    public TreviCreative() {
        this(null, 0, null, null, null, null, null, null, null, null, null, false, 0xFFF, null);
    }

    public TreviCreative(@Nullable String s, int v, @Nullable ArrayList arrayList0, @Nullable String s1, @Nullable String s2, @Nullable TreviAdInfo treviAdInfo0, @Nullable ArrayList arrayList1, @Nullable TreviUserInfo treviUserInfo0, @Nullable TreviAdReward treviAdReward0, @Nullable TreviTracker treviTracker0, @Nullable TreviApply treviApply0, boolean z) {
        this.impId = s;
        this.impType = v;
        this.integrationInfos = arrayList0;
        this.creativeFormat = s1;
        this.landingUrl = s2;
        this.adInfo = treviAdInfo0;
        this.assets = arrayList1;
        this.userInfo = treviUserInfo0;
        this.adReward = treviAdReward0;
        this.trackers = treviTracker0;
        this.apply = treviApply0;
        this._needSendVImp = z;
    }

    public TreviCreative(String s, int v, ArrayList arrayList0, String s1, String s2, TreviAdInfo treviAdInfo0, ArrayList arrayList1, TreviUserInfo treviUserInfo0, TreviAdReward treviAdReward0, TreviTracker treviTracker0, TreviApply treviApply0, boolean z, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = null;
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            arrayList0 = null;
        }
        if((v1 & 8) != 0) {
            s1 = null;
        }
        if((v1 & 16) != 0) {
            s2 = null;
        }
        if((v1 & 0x20) != 0) {
            treviAdInfo0 = null;
        }
        if((v1 & 0x40) != 0) {
            arrayList1 = null;
        }
        if((v1 & 0x80) != 0) {
            treviUserInfo0 = null;
        }
        if((v1 & 0x100) != 0) {
            treviAdReward0 = null;
        }
        if((v1 & 0x200) != 0) {
            treviTracker0 = null;
        }
        if((v1 & 0x400) != 0) {
            treviApply0 = null;
        }
        if((v1 & 0x800) != 0) {
            z = true;
        }
        this(s, v, arrayList0, s1, s2, treviAdInfo0, arrayList1, treviUserInfo0, treviAdReward0, treviTracker0, treviApply0, z);
    }

    @Nullable
    public final String component1() {
        return this.impId;
    }

    @Nullable
    public final TreviTracker component10() {
        return this.trackers;
    }

    @Nullable
    public final TreviApply component11() {
        return this.apply;
    }

    public final boolean component12() {
        return this._needSendVImp;
    }

    public final int component2() {
        return this.impType;
    }

    @Nullable
    public final ArrayList component3() {
        return this.integrationInfos;
    }

    @Nullable
    public final String component4() {
        return this.creativeFormat;
    }

    @Nullable
    public final String component5() {
        return this.landingUrl;
    }

    @Nullable
    public final TreviAdInfo component6() {
        return this.adInfo;
    }

    @Nullable
    public final ArrayList component7() {
        return this.assets;
    }

    @Nullable
    public final TreviUserInfo component8() {
        return this.userInfo;
    }

    @Nullable
    public final TreviAdReward component9() {
        return this.adReward;
    }

    @NotNull
    public final TreviCreative copy(@Nullable String s, int v, @Nullable ArrayList arrayList0, @Nullable String s1, @Nullable String s2, @Nullable TreviAdInfo treviAdInfo0, @Nullable ArrayList arrayList1, @Nullable TreviUserInfo treviUserInfo0, @Nullable TreviAdReward treviAdReward0, @Nullable TreviTracker treviTracker0, @Nullable TreviApply treviApply0, boolean z) {
        return new TreviCreative(s, v, arrayList0, s1, s2, treviAdInfo0, arrayList1, treviUserInfo0, treviAdReward0, treviTracker0, treviApply0, z);
    }

    public static TreviCreative copy$default(TreviCreative treviCreative0, String s, int v, ArrayList arrayList0, String s1, String s2, TreviAdInfo treviAdInfo0, ArrayList arrayList1, TreviUserInfo treviUserInfo0, TreviAdReward treviAdReward0, TreviTracker treviTracker0, TreviApply treviApply0, boolean z, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = treviCreative0.impId;
        }
        if((v1 & 2) != 0) {
            v = treviCreative0.impType;
        }
        if((v1 & 4) != 0) {
            arrayList0 = treviCreative0.integrationInfos;
        }
        if((v1 & 8) != 0) {
            s1 = treviCreative0.creativeFormat;
        }
        if((v1 & 16) != 0) {
            s2 = treviCreative0.landingUrl;
        }
        if((v1 & 0x20) != 0) {
            treviAdInfo0 = treviCreative0.adInfo;
        }
        if((v1 & 0x40) != 0) {
            arrayList1 = treviCreative0.assets;
        }
        if((v1 & 0x80) != 0) {
            treviUserInfo0 = treviCreative0.userInfo;
        }
        if((v1 & 0x100) != 0) {
            treviAdReward0 = treviCreative0.adReward;
        }
        if((v1 & 0x200) != 0) {
            treviTracker0 = treviCreative0.trackers;
        }
        if((v1 & 0x400) != 0) {
            treviApply0 = treviCreative0.apply;
        }
        if((v1 & 0x800) != 0) {
            z = treviCreative0._needSendVImp;
        }
        return treviCreative0.copy(s, v, arrayList0, s1, s2, treviAdInfo0, arrayList1, treviUserInfo0, treviAdReward0, treviTracker0, treviApply0, z);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviCreative)) {
            return false;
        }
        if(!q.b(this.impId, ((TreviCreative)object0).impId)) {
            return false;
        }
        if(this.impType != ((TreviCreative)object0).impType) {
            return false;
        }
        if(!q.b(this.integrationInfos, ((TreviCreative)object0).integrationInfos)) {
            return false;
        }
        if(!q.b(this.creativeFormat, ((TreviCreative)object0).creativeFormat)) {
            return false;
        }
        if(!q.b(this.landingUrl, ((TreviCreative)object0).landingUrl)) {
            return false;
        }
        if(!q.b(this.adInfo, ((TreviCreative)object0).adInfo)) {
            return false;
        }
        if(!q.b(this.assets, ((TreviCreative)object0).assets)) {
            return false;
        }
        if(!q.b(this.userInfo, ((TreviCreative)object0).userInfo)) {
            return false;
        }
        if(!q.b(this.adReward, ((TreviCreative)object0).adReward)) {
            return false;
        }
        if(!q.b(this.trackers, ((TreviCreative)object0).trackers)) {
            return false;
        }
        return q.b(this.apply, ((TreviCreative)object0).apply) ? this._needSendVImp == ((TreviCreative)object0)._needSendVImp : false;
    }

    @Nullable
    public final TreviAdInfo getAdInfo() {
        return this.adInfo;
    }

    @Nullable
    public final TreviAdReward getAdReward() {
        return this.adReward;
    }

    @Nullable
    public final TreviApply getApply() {
        return this.apply;
    }

    @Nullable
    public final ArrayList getAssets() {
        return this.assets;
    }

    @Nullable
    public final String getCreativeFormat() {
        return this.creativeFormat;
    }

    @Nullable
    public final String getImpId() {
        return this.impId;
    }

    public final int getImpType() {
        return this.impType;
    }

    @Nullable
    public final ArrayList getIntegrationInfos() {
        return this.integrationInfos;
    }

    @Nullable
    public final String getLandingUrl() {
        return this.landingUrl;
    }

    @Nullable
    public final TreviTracker getTrackers() {
        return this.trackers;
    }

    @Nullable
    public final TreviUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final boolean get_needSendVImp() {
        return this._needSendVImp;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.b(this.impType, (this.impId == null ? 0 : this.impId.hashCode()) * 0x1F, 0x1F);
        int v2 = this.integrationInfos == null ? 0 : this.integrationInfos.hashCode();
        int v3 = this.creativeFormat == null ? 0 : this.creativeFormat.hashCode();
        int v4 = this.landingUrl == null ? 0 : this.landingUrl.hashCode();
        int v5 = this.adInfo == null ? 0 : this.adInfo.hashCode();
        int v6 = this.assets == null ? 0 : this.assets.hashCode();
        int v7 = this.userInfo == null ? 0 : this.userInfo.hashCode();
        int v8 = this.adReward == null ? 0 : this.adReward.hashCode();
        int v9 = this.trackers == null ? 0 : this.trackers.hashCode();
        TreviApply treviApply0 = this.apply;
        if(treviApply0 != null) {
            v = treviApply0.hashCode();
        }
        return Boolean.hashCode(this._needSendVImp) + (((((((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v) * 0x1F;
    }

    public final void set_needSendVImp(boolean z) {
        this._needSendVImp = z;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TreviCreative(impId=");
        stringBuilder0.append(this.impId);
        stringBuilder0.append(", impType=");
        stringBuilder0.append(this.impType);
        stringBuilder0.append(", integrationInfos=");
        stringBuilder0.append(this.integrationInfos);
        stringBuilder0.append(", creativeFormat=");
        stringBuilder0.append(this.creativeFormat);
        stringBuilder0.append(", landingUrl=");
        stringBuilder0.append(this.landingUrl);
        stringBuilder0.append(", adInfo=");
        stringBuilder0.append(this.adInfo);
        stringBuilder0.append(", assets=");
        stringBuilder0.append(this.assets);
        stringBuilder0.append(", userInfo=");
        stringBuilder0.append(this.userInfo);
        stringBuilder0.append(", adReward=");
        stringBuilder0.append(this.adReward);
        stringBuilder0.append(", trackers=");
        stringBuilder0.append(this.trackers);
        stringBuilder0.append(", apply=");
        stringBuilder0.append(this.apply);
        stringBuilder0.append(", _needSendVImp=");
        return b.k(stringBuilder0, this._needSendVImp, ')');
    }
}

