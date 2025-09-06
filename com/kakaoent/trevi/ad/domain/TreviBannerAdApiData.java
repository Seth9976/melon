package com.kakaoent.trevi.ad.domain;

import A7.d;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u001C\b\u0002\u0010\u0005\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\u001C\b\u0002\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0002\u0010\u000EJ\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u0019\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u001D\u0010\u001A\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u00C6\u0003J\u001D\u0010\u001B\u001A\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\bH\u00C6\u0003J\t\u0010\u001C\u001A\u00020\fH\u00C6\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003Js\u0010\u001E\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u001C\b\u0002\u0010\u0005\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u001C\b\u0002\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\b2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010\"\u001A\u00020\fH\u00D6\u0001J\t\u0010#\u001A\u00020\u0003H\u00D6\u0001R%\u0010\u0005\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R%\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\b\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000B\u001A\u00020\f\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0013\u00A8\u0006$"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviBannerAdApiData;", "", "reqId", "", "version", "ads", "Ljava/util/ArrayList;", "Lcom/kakaoent/trevi/ad/domain/TreviBannerAd;", "Lkotlin/collections/ArrayList;", "creatives", "Lcom/kakaoent/trevi/ad/domain/TreviCreative;", "totalCount", "", "nextOffset", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/lang/String;)V", "getAds", "()Ljava/util/ArrayList;", "getCreatives", "getNextOffset", "()Ljava/lang/String;", "getReqId", "getTotalCount", "()I", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviBannerAdApiData {
    @Nullable
    private final ArrayList ads;
    @Nullable
    private final ArrayList creatives;
    @Nullable
    private final String nextOffset;
    @Nullable
    private final String reqId;
    private final int totalCount;
    @Nullable
    private final String version;

    public TreviBannerAdApiData() {
        this(null, null, null, null, 0, null, 0x3F, null);
    }

    public TreviBannerAdApiData(@Nullable String s, @Nullable String s1, @Nullable ArrayList arrayList0, @Nullable ArrayList arrayList1, int v, @Nullable String s2) {
        this.reqId = s;
        this.version = s1;
        this.ads = arrayList0;
        this.creatives = arrayList1;
        this.totalCount = v;
        this.nextOffset = s2;
    }

    public TreviBannerAdApiData(String s, String s1, ArrayList arrayList0, ArrayList arrayList1, int v, String s2, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = null;
        }
        if((v1 & 2) != 0) {
            s1 = null;
        }
        if((v1 & 4) != 0) {
            arrayList0 = null;
        }
        if((v1 & 8) != 0) {
            arrayList1 = null;
        }
        if((v1 & 16) != 0) {
            v = 0;
        }
        this(s, s1, arrayList0, arrayList1, v, ((v1 & 0x20) == 0 ? s2 : null));
    }

    @Nullable
    public final String component1() {
        return this.reqId;
    }

    @Nullable
    public final String component2() {
        return this.version;
    }

    @Nullable
    public final ArrayList component3() {
        return this.ads;
    }

    @Nullable
    public final ArrayList component4() {
        return this.creatives;
    }

    public final int component5() {
        return this.totalCount;
    }

    @Nullable
    public final String component6() {
        return this.nextOffset;
    }

    @NotNull
    public final TreviBannerAdApiData copy(@Nullable String s, @Nullable String s1, @Nullable ArrayList arrayList0, @Nullable ArrayList arrayList1, int v, @Nullable String s2) {
        return new TreviBannerAdApiData(s, s1, arrayList0, arrayList1, v, s2);
    }

    public static TreviBannerAdApiData copy$default(TreviBannerAdApiData treviBannerAdApiData0, String s, String s1, ArrayList arrayList0, ArrayList arrayList1, int v, String s2, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = treviBannerAdApiData0.reqId;
        }
        if((v1 & 2) != 0) {
            s1 = treviBannerAdApiData0.version;
        }
        if((v1 & 4) != 0) {
            arrayList0 = treviBannerAdApiData0.ads;
        }
        if((v1 & 8) != 0) {
            arrayList1 = treviBannerAdApiData0.creatives;
        }
        if((v1 & 16) != 0) {
            v = treviBannerAdApiData0.totalCount;
        }
        if((v1 & 0x20) != 0) {
            s2 = treviBannerAdApiData0.nextOffset;
        }
        return treviBannerAdApiData0.copy(s, s1, arrayList0, arrayList1, v, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviBannerAdApiData)) {
            return false;
        }
        if(!q.b(this.reqId, ((TreviBannerAdApiData)object0).reqId)) {
            return false;
        }
        if(!q.b(this.version, ((TreviBannerAdApiData)object0).version)) {
            return false;
        }
        if(!q.b(this.ads, ((TreviBannerAdApiData)object0).ads)) {
            return false;
        }
        if(!q.b(this.creatives, ((TreviBannerAdApiData)object0).creatives)) {
            return false;
        }
        return this.totalCount == ((TreviBannerAdApiData)object0).totalCount ? q.b(this.nextOffset, ((TreviBannerAdApiData)object0).nextOffset) : false;
    }

    @Nullable
    public final ArrayList getAds() {
        return this.ads;
    }

    @Nullable
    public final ArrayList getCreatives() {
        return this.creatives;
    }

    @Nullable
    public final String getNextOffset() {
        return this.nextOffset;
    }

    @Nullable
    public final String getReqId() {
        return this.reqId;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.b(this.totalCount, ((((this.reqId == null ? 0 : this.reqId.hashCode()) * 0x1F + (this.version == null ? 0 : this.version.hashCode())) * 0x1F + (this.ads == null ? 0 : this.ads.hashCode())) * 0x1F + (this.creatives == null ? 0 : this.creatives.hashCode())) * 0x1F, 0x1F);
        String s = this.nextOffset;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TreviBannerAdApiData(reqId=");
        stringBuilder0.append(this.reqId);
        stringBuilder0.append(", version=");
        stringBuilder0.append(this.version);
        stringBuilder0.append(", ads=");
        stringBuilder0.append(this.ads);
        stringBuilder0.append(", creatives=");
        stringBuilder0.append(this.creatives);
        stringBuilder0.append(", totalCount=");
        stringBuilder0.append(this.totalCount);
        stringBuilder0.append(", nextOffset=");
        return o.r(stringBuilder0, this.nextOffset, ')');
    }
}

